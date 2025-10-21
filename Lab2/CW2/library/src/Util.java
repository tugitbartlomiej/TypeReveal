package lib;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;


public class Util {

    public static void runOrcEncounter() throws Exception {
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        TerminalScreen screen = new TerminalScreen(terminal);
        try {
            screen.startScreen();
            screen.clear();

            TerminalSize size = screen.getTerminalSize();
            TextGraphics tg = screen.newTextGraphics();
            tg.setBackgroundColor(TextColor.Factory.fromString("#1b1f23")); // dark bg
            tg.fill(' ');

            // frame
            int w = Math.max(70, size.getColumns() - 4);
            int h = Math.max(28, size.getRows() - 4);
            drawBox(tg, 2, 2, w, h);
            tg.putString(4, 2, " Spotkanie z orkiem ", SGR.BOLD);

            // --- ORC ASCII (Unicode block characters) ---
            String[] orc = new String[] {
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⣿⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣤⣶⣧⣄⣉⣉⣠⣼⣶⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                    "⠀⠀⠀⠀⠀⠀⠀⢰⣿⣿⣿⣿⡿⣿⣿⣿⣿⢿⣿⣿⣿⣿⡆⠀⠀⠀⠀⠀⠀⠀",
                    "⠀⠀⠀⠀⠀⠀⠀⣼⣤⣤⣈⠙⠳⢄⣉⣋⡡⠞⠋⣁⣤⣤⣧⠀⠀⠀⠀⠀⠀⠀",
                    "⠀⢲⣶⣤⣄⡀⢀⣿⣄⠙⠿⣿⣦⣤⡿⢿⣤⣴⣿⠿⠋⣠⣿⠀⢀⣠⣤⣶⡖⠀",
                    "⠀⠀⠙⣿⠛⠇⢸⣿⣿⡟⠀⡄⢉⠉⢀⡀⠉⡉⢠⠀⢻⣿⣿⡇⠸⠛⣿⠋⠀⠀",
                    "⠀⠀⠀⠘⣷⠀⢸⡏⠻⣿⣤⣤⠂⣠⣿⣿⣄⠑⣤⣤⣿⠟⢹⡇⠀⣾⠃⠀⠀⠀",
                    "⠀⠀⠀⠀⠘⠀⢸⣿⡀⢀⠙⠻⢦⣌⣉⣉⣡⡴⠟⠋⡀⢀⣿⡇⠀⠃⠀⠀⠀⠀",
                    "⠀⠀⠀⠀⠀⠀⢸⣿⣧⠈⠛⠂⠀⠉⠛⠛⠉⠀⠐⠛⠁⣼⣿⡇⠀⠀⠀⠀⠀⠀",
                    "⠀⠀⠀⠀⠀⠀⠸⣏⠀⣤⡶⠖⠛⠋⠉⠉⠙⠛⠲⢶⣤⠀⣹⠇⠀⠀⠀⠀⠀⠀",
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣿⣶⣿⣿⣿⣿⣿⣿⣶⣿⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠉⠛⠛⠛⠛⠉⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"
            };

            int artX = 6, artY = 4;
            drawAscii(tg, artX, artY, orc);

            // Menu
            int menuX = artX + 36;
            int menuY = artY + 1;
            tg.putString(menuX, menuY,     "Wybierz akcję:", SGR.BOLD);
            tg.putString(menuX, menuY + 2, "1) Walcz z orkiem");
            tg.putString(menuX, menuY + 3, "2) Powiedz, że się spóźniasz");
            tg.putString(menuX, menuY + 4, "3) Powiedz \"Przepraszam\"\n");
            tg.putString(menuX, menuY + 6, "Naciśnij 1 / 2 / 3 ...");

            screen.refresh();

            // Input loop
            while (true) {
                var key = screen.readInput();
                if (key == null) continue;

                if (key.getKeyType() == KeyType.Character) {
                    Character ch = key.getCharacter();
                    if (ch == null || (ch != '1' && ch != '2' && ch != '3')) continue;

                    String outcome = null;
                    outcome = "Ork atakuje...";

                    if (outcome != null) {
                        clearArea(tg, 4, artY + orc.length + 1, w - 6, 4);
                        tg.putString(4, artY + orc.length + 1, outcome);
                        tg.putString(4, artY + orc.length + 3, "Naciśnij dowolny klawisz, aby kontynuować...");
                        screen.refresh();
                        screen.readInput();

                        showGameOver(screen, tg, w, h);
                        break;
                    }
                }

                if (key.getKeyType() == KeyType.Escape) {
                    showGameOver(screen, tg, w, h);
                    break;
                }
            }
        } finally {
            try { screen.stopScreen(); } catch (Exception ignored) {}
            try { terminal.close(); }     catch (Exception ignored) {}
        }
    }

    public static void showGameOver(TerminalScreen screen, TextGraphics tg, int w, int h) throws Exception {
        screen.clear();
        tg.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        tg.setForegroundColor(TextColor.ANSI.RED);
        drawBox(tg, 2, 2, w, h);

        String[] dead = new String[] {
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣤⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣴⣶⣄⠀",
                "⠀⠀⠀⣾⣿⣷⡀⠀⠀⠀⠀⠸⣿⣿⣿⣄⠀⠀⠀⠀⠀⣠⣴⣾⣿⣿⣿⣿⡿⠀",
                "⠀⠀⠀⠻⣿⣿⣿⣦⡀⠀⠀⠀⠹⣿⣿⣿⣆⠀⠀⢀⣾⣿⣿⣿⠿⠛⠋⠁⠀⠀",
                "⠀⠀⠀⠀⠙⢿⣿⣿⣿⣆⠀⠀⠀⠙⣿⣿⣿⣧⠀⣾⣿⣿⡿⠀⠀⠀⠀⠀⠀⠀",
                "⠀⠀⠀⠀⠀⠀⢻⣿⣿⣿⠀⠀⣠⣴⣿⣿⣿⣿⣷⣿⣿⡿⠁⠀⠀⠀⠀⠀⠀⠀",
                "⠀⠀⠀⠀⠀⠀⣾⣿⣿⣿⣴⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀",
                "⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⡿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                "⠀⠀⠀⠀⠀⠀⢿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                "⠀⢀⣴⣾⣿⣷⣦⡹⣿⣿⣿⣿⣿⠟⠉⠀⠀⠀⢀⣤⣾⣿⣆⠀⠀⠀⠀⠀⠀⠀",
                "⠀⣾⣿⣿⣿⣿⣿⣷⠘⣿⣿⣿⣿⣷⣦⣄⣠⣾⣿⣿⣿⣿⠟⠀⠀⠀⠀⠀⠀⠀",
                "⠀⠻⣿⣿⣿⣿⣿⠏⠀⠀⠉⠛⠿⢿⣿⣿⣿⣿⣿⠟⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                "⠀⠀⠈⠛⠛⠋⠁⠀⠀⠀⠀⠀⠀⠀⠈⠙⠛⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"
        };
        int dx = 8, dy = 6;
        drawAscii(tg, dx, dy, dead);

        tg.putString(4, 3, " GAME OVER ", SGR.BOLD);
        tg.setForegroundColor(TextColor.ANSI.WHITE);
        tg.putString(4, dy + dead.length + 2, "Przygoda skończona. Naciśnij dowolny klawisz, aby wyjść.");
        screen.refresh();
        screen.readInput();
    }

    /** Prints a small ASCII-art array starting at (x,y). */
    public static void drawAscii(TextGraphics tg, int x, int y, String[] lines) {
        for (int i = 0; i < lines.length; i++) tg.putString(x, y + i, lines[i]);
    }

    /** Fills a rectangular area with spaces using current background. */
    public static void clearArea(TextGraphics tg, int x, int y, int width, int height) {
        for (int j = 0; j < height; j++)
            for (int i = 0; i < width; i++)
                tg.putString(x + i, y + j, " ");
    }

    /** Simple rectangle using ASCII line chars. */
    public static void drawBox(TextGraphics tg, int x, int y, int width, int height) {
        int x2 = x + width - 1, y2 = y + height - 1;
        for (int i = x; i <= x2; i++) { tg.putString(i, y, "-"); tg.putString(i, y2, "-"); }
        for (int j = y; j <= y2; j++) { tg.putString(x, j, "|"); tg.putString(x2, j, "|"); }
        tg.putString(x,  y,  "+"); tg.putString(x2, y,  "+");
        tg.putString(x,  y2, "+"); tg.putString(x2, y2, "+");
    }
}
