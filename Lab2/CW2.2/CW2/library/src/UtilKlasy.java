package lib;

import java.util.*;
import java.util.stream.*;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

public final class UtilKlasy {
    private UtilKlasy() {}

    /** ETAP 1: musi być co najmniej 1 Wojownik i 1 Łucznik; dodatkowo sprawdza specyfikację klas. */
    public static boolean pokazEtap1(List<?> lista) throws Exception {
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        TerminalScreen screen = new TerminalScreen(terminal);
        try {
            screen.startScreen();
            screen.clear();
            TextGraphics tg = screen.newTextGraphics();
            tg.setBackgroundColor(TextColor.Factory.fromString("#101214"));
            tg.setForegroundColor(TextColor.ANSI.WHITE);

            var size = screen.getTerminalSize();
            int w = Math.max(70, size.getColumns() - 4);
            int h = Math.max(22, size.getRows() - 4);
            int x = 2, y = 2;

            drawBox(tg, x, y, w, h);
            tg.putString(x + 2, y, " RAPORT KLAS (ETAP 1) ", SGR.BOLD);
            clearArea(tg, x + 2, y + 2, w - 4, h - 4);

            Raport r = policz(lista);
            int line = y + 2 + wypiszPodsumowanie(tg, x + 2, y + 2, r);

            // Weryfikacja istnienia i zgodności Wojownika/Łucznika
            WeryfResult wWoj = verifySubclassAndField(lista, "Wojownik", "Postac", "sila", int.class);
            WeryfResult wLuc = verifySubclassAndField(lista, "Łucznik",  "Postac", "zrecznosc", int.class);

            line = wypiszWeryfikacje(tg, x + 2, line, wWoj);
            line = wypiszWeryfikacje(tg, x + 2, line, wLuc);

            boolean ok = r.hasWoj && r.hasLucz && wWoj.ok && wLuc.ok;
            if (!r.hasWoj) tg.putString(x + 2, line++, "Brak instancji: Wojownik.");
            if (!r.hasLucz) tg.putString(x + 2, line++, "Brak instancji: Łucznik (dodaj podklasę i obiekt do listy).");

            tg.putString(x + 2, line++, ok ? "Etap 1 zaliczony." : "Etap 1 niezaliczony.");
            tg.putString(x + 2, y + h - 2, "Naciśnij dowolny klawisz, aby wyjść...");
            screen.refresh();

            KeyStroke k = screen.readInput(); // pauza
            return ok;
        } finally {
            try { screen.stopScreen(); } catch (Exception ignored) {}
            try { terminal.close(); }     catch (Exception ignored) {}
        }
    }

    /** ETAP 2: >=100 Wojowników i >=100 Łuczników oraz razem >=200; weryfikuje też specyfikację klas. */
    public static boolean pokazEtap2(List<?> lista) throws Exception {
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        TerminalScreen screen = new TerminalScreen(terminal);
        try {
            screen.startScreen();
            screen.clear();
            TextGraphics tg = screen.newTextGraphics();
            tg.setBackgroundColor(TextColor.Factory.fromString("#101214"));
            tg.setForegroundColor(TextColor.ANSI.WHITE);

            var size = screen.getTerminalSize();
            int w = Math.max(70, size.getColumns() - 4);
            int h = Math.max(24, size.getRows() - 4);
            int x = 2, y = 2;

            drawBox(tg, x, y, w, h);
            tg.putString(x + 2, y, " RAPORT KLAS (ETAP 2) ", SGR.BOLD);
            clearArea(tg, x + 2, y + 2, w - 4, h - 4);

            Raport r = policz(lista);
            int line = y + 2 + wypiszPodsumowanie(tg, x + 2, y + 2, r);

            // Weryfikacja specyfikacji klas
            WeryfResult wWoj = verifySubclassAndField(lista, "Wojownik", "Postac", "sila", int.class);
            WeryfResult wLuc = verifySubclassAndField(lista, "Łucznik",  "Postac", "zrecznosc", int.class);
            line = wypiszWeryfikacje(tg, x + 2, line, wWoj);
            line = wypiszWeryfikacje(tg, x + 2, line, wLuc);

            boolean ok = true;
            if (r.woj < 100) { tg.putString(x + 2, line++, "Wojownicy: " + r.woj + " (<100) – dodaj pętlą."); ok = false; }
            if (r.lucz < 100){ tg.putString(x + 2, line++, "Łucznicy: " + r.lucz + " (<100) – dodaj pętlą."); ok = false; }
            if (r.total < 200){ tg.putString(x + 2, line++, "Razem: " + r.total + " (<200)."); ok = false; }

            ok = ok && wWoj.ok && wLuc.ok;

            tg.putString(x + 2, line++, ok ? "Etap 2 zaliczony." : "Etap 2 niezaliczony.");
            tg.putString(x + 2, y + h - 2, "Naciśnij dowolny klawisz, aby wyjść...");
            screen.refresh();

            screen.readInput(); // pauza
            return ok;
        } finally {
            try { screen.stopScreen(); } catch (Exception ignored) {}
            try { terminal.close(); }     catch (Exception ignored) {}
        }
    }

    // ===================== LICZENIE / RAPORT =====================

    private static Raport policz(List<?> lista) {
        Raport r = new Raport();
        if (lista == null) lista = Collections.emptyList();
        r.total = lista.size();
        r.byType = lista.stream().collect(Collectors.groupingBy(
                o -> o.getClass().getSimpleName(), LinkedHashMap::new, Collectors.counting()));
        r.bazowe = lista.stream().filter(o -> "Postac".equals(o.getClass().getSimpleName())).count();
        r.woj    = lista.stream().filter(o -> "Wojownik".equals(o.getClass().getSimpleName())).count();
        r.lucz   = lista.stream().filter(o -> "Łucznik".equals(o.getClass().getSimpleName())).count();
        r.hasWoj  = r.woj  > 0;
        r.hasLucz = r.lucz > 0;
        return r;
    }

    private static int wypiszPodsumowanie(TextGraphics tg, int x, int y, Raport r) {
        int line = y;
        if (r.total == 0) {
            tg.putString(x, line++, "Lista jest pusta.");
            return line - y;
        }
        tg.putString(x, line++, "Razem: " + r.total);
        tg.putString(x, line++, "Bazowe Postac: " + r.bazowe);
        for (var e : r.byType.entrySet()) tg.putString(x, line++, e.getKey() + ": " + e.getValue());
        line++;
        return line - y;
    }

    private static int wypiszWeryfikacje(TextGraphics tg, int x, int line, WeryfResult wr) {
        if (!wr.checked) {
            tg.putString(x, line++, wr.kind + ": brak klasy lub obiektu na liście (pomijam weryfikację).");
            return line;
        }
        tg.putString(x, line++, wr.kind + ": " + (wr.ok ? "OK" : "BŁĄD"));
        if (!wr.subclassOk)   tg.putString(x + 2, line++, "- musi być podklasą Postac.");
        if (!wr.fieldExists)  tg.putString(x + 2, line++, "- brak pola '" + wr.fieldName + "'.");
        if (!wr.fieldTypeOk)  tg.putString(x + 2, line++, "- pole '" + wr.fieldName + "' nie jest typu int.");
        return line;
    }

    // ===================== WERYFIKACJA KLAS (refleksja) =====================

    /** Szuka w liście klasy o simpleName=kind, sprawdza czy dziedziczy po baseSimpleName i ma pole fieldName typu fieldType. */
    private static WeryfResult verifySubclassAndField(List<?> lista,
                                                      String kind,
                                                      String baseSimpleName,
                                                      String fieldName,
                                                      Class<?> fieldType) {
        WeryfResult out = new WeryfResult(kind, fieldName);

        if (lista == null || lista.isEmpty()) return out; // checked=false
        Class<?> cls = findClassBySimpleName(lista, kind);
        if (cls == null) return out; // brak klasy/instancji — zostaw checked=false
        out.checked = true;

        // 1) Podklasa Postac? (po simpleName w łańcuchu nadklas)
        out.subclassOk = isSubclassOfBySimpleName(cls, baseSimpleName);

        // 2) Pole o nazwie fieldName i typie int?
        try {
            var f = cls.getDeclaredField(fieldName);
            out.fieldExists = true;
            out.fieldTypeOk = (f.getType() == fieldType);
        } catch (NoSuchFieldException e) {
            out.fieldExists = false;
            out.fieldTypeOk = false;
        }

        out.ok = out.subclassOk && out.fieldExists && out.fieldTypeOk;
        return out;
    }

    private static Class<?> findClassBySimpleName(List<?> lista, String simpleName) {
        for (Object o : lista) {
            if (o != null && simpleName.equals(o.getClass().getSimpleName())) return o.getClass();
        }
        // Spróbuj załadować po pełnej nazwie, jeśli student podał pakiet (opcjonalnie)
        try {
            return Class.forName(simpleName); // np. gdy ktoś użyje pełnej nazwy w classpath
        } catch (ClassNotFoundException ignored) {}
        return null;
    }

    /** True, jeśli cls ma w łańcuchu nadklas klasę o simpleName=baseSimpleName (i nie jest nią sam). */
    private static boolean isSubclassOfBySimpleName(Class<?> cls, String baseSimpleName) {
        if (cls == null) return false;
        Class<?> c = cls.getSuperclass();
        while (c != null) {
            if (baseSimpleName.equals(c.getSimpleName())) return true;
            c = c.getSuperclass();
        }
        return false;
    }

    // ===================== RYSOWANIE (lokalne) =====================

    private static void clearArea(TextGraphics tg, int x, int y, int width, int height) {
        for (int j = 0; j < height; j++)
            for (int i = 0; i < width; i++)
                tg.putString(x + i, y + j, " ");
    }

    private static void drawBox(TextGraphics tg, int x, int y, int width, int height) {
        int x2 = x + width - 1, y2 = y + height - 1;
        for (int i = x; i <= x2; i++) { tg.putString(i, y, "-"); tg.putString(i, y2, "-"); }
        for (int j = y; j <= y2; j++) { tg.putString(x, j, "|"); tg.putString(x2, j, "|"); }
        tg.putString(x,  y,  "+"); tg.putString(x2, y,  "+");
        tg.putString(x,  y2, "+"); tg.putString(x2, y2, "+");
    }

    // ===================== DTO =====================

    private static final class Raport {
        Map<String, Long> byType = Map.of();
        long bazowe, woj, lucz;
        boolean hasWoj, hasLucz;
        int total;
    }

    private static final class WeryfResult {
        final String kind;
        final String fieldName;
        boolean checked=false, subclassOk=false, fieldExists=false, fieldTypeOk=false, ok=false;
        WeryfResult(String kind, String fieldName) { this.kind = kind; this.fieldName = fieldName; }
    }
}
