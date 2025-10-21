import java.util.List;
import java.util.ArrayList;


// KLASY
public class Main {
    public static void main(String[] args)  throws Exception {
        Postac p = new Postac("Zwyklak", 10);
        Postac w = new Wojownik("Aragorn", 12, 3); // Wojownik dziedziczy po Postac

        System.out.println(p);
        System.out.println(w);

        // Polimorfizm: zmienna typu bazowego może wskazywać obiekt pochodny.
        p.atak(w); // bazowy atak (-1 HP)
        w.atak(p); // przesłonięty atak Wojownika (-1 - siła)

        System.out.println("Po atakach:");
        System.out.println(p);
        System.out.println(w);


        // !!ZADANIE!! Stworz klase Łucznik analogiczną do Wojownik z parametrem zrecznosc zamiast sila.
        List<Postac> lista = new ArrayList<>();
        lista.add(new Postac("Zwyklak", 10));
        lista.add(new Wojownik("Aragorn", 12, 3));

        lib.UtilKlasy.pokazEtap1(lista);

        // !!ZADANIE!! Używając for loop dodaj do listy 100 wojowników i 100 Łuczników
        // for (int i = 0; i < NUMER; i++)

        //lib.UtilKlasy.pokazEtap2(lista);

    }
}

class Postac {
    private String imie;
    private int hp;

    public Postac(String imie, int hp) {
        this.imie = imie;
        this.hp = hp;
    }

    // "Bazowy" atak — można go przesłonić w klasie pochodnej
    public void atak(Postac cel) {
        cel.otrzymajObrazenia(1);
    }

    // Chroni stan; klasy dziedziczące mogą korzystać (protected)
    protected void otrzymajObrazenia(int dmg) {
        hp = Math.max(0, hp - Math.max(0, dmg));
    }

    public String getImie() { return imie; }
    public int getHp() { return hp; }

    @Override public String toString() {
        return imie + " (HP=" + hp + ")";
    }
}

class Wojownik extends Postac {
    private int sila;

    public Wojownik(String imie, int hp, int sila) {
        super(imie, hp);
        this.sila = Math.max(0, sila);
    }

    // Override: własna wersja ataku
    @Override
    public void atak(Postac cel) {
        // 1 (bazowe) + premia za siłę
        cel.otrzymajObrazenia(1 + sila);
    }
}

class Łucznik extends Postac {
    private int zrecznosc;

    public Łucznik(String imie, int hp, int zrecznosc) {
        super(imie, hp);
        this.zrecznosc = Math.max(0, zrecznosc);
    }

    // Override: własna wersja ataku
    @Override
    public void atak(Postac cel) {
        // 1 (bazowe) + premia za siłę
        cel.otrzymajObrazenia(1 + zrecznosc);
    }
}
