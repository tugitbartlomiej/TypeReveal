/*
Przypisania w Javie — prymitywy vs referencje, aliasy, przekazywanie do metod.
 */
public class Main {
    // Funkcje na które będziemy się powoływać
    public static void prymitywy(){
        System.out.println("1) Prymitywy (kopiowanie wartości)");
        int a = 5;
        int b = a;      // kopia wartości
        b++;
        System.out.println("   a=" + a + ", b=" + b);
        // Skopiowaliśmy wartość więc nie zmieniamy oryginalnej wartości
        System.out.println();
    }

    // Prosta Klasa
    static class Kwadrat {
        int n;

        Kwadrat(int n) {
            this.n = n;
        }
    }

    public static void obiekty(){
        Kwadrat a = new Kwadrat(0);
        Kwadrat b = a;
        b.n = 1;
        System.out.println("a=" + a.n + ", b=" + b.n);
        // Nie kopiujesz wartość ale kopiujesz referencje
        // Zmiany w jednym powodują zmianę w drugim
    }

    public static void plus_jeden_prym(int n)
    {
        n++;
        System.out.println("n W funkcji: " + n);
    }

    public static void plus_jeden_obiekt(Kwadrat ob)
    {
        ob.n++;
        System.out.println("obiekt W funkcji: " + ob.n);
    }



    public static void main(String[] args) throws Exception {

        // 1) PRYMITYWY: przypisanie kopiuje wartość
//        prymitywy();

        // 2) OBIETKY: przypisanie kopiuje referencje
//        obiekty();

        // 3) Przekazanie do funkcji (Odkomentuj)
//        int prym = 0;
//        plus_jeden_prym(prym);
//        System.out.println("n Za funkcją: " + prym);

        // !!!ZADANIE!!! zmień funkcje plus_jeden_prym żeby prym zostało zmienione za funkcją. podpowiedź: najpierw zmień void


        Kwadrat obiekt = new Kwadrat(20);
        plus_jeden_obiekt(obiekt);
        System.out.println("obiekt Za funkcją: " + obiekt.n);

        // !!!ZADANIE!!! zmień funkcje plus_jeden_obiekt żeby wartość "n" została zmieniona w funkcji, ale wróciła do
        // oryginalnej wartości po funkcji. podpowiedź: wykorzystaj konstruktor new Kwadrat()
    }
}