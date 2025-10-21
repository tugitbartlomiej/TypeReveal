import java.util.*;

/**
 * Zadanie: Wieża z Klocków (KLO)
 * Temat: Comparable, Arrays.sort(), sortowanie obiektów
 */

// Klasa reprezentująca klocek - implementuje Comparable
class Klocek implements Comparable<Klocek> {
    int szerokosc;  // szerokość podstawy
    int glebokosc;  // głębokość podstawy
    int wysokosc;   // wysokość klocka

    // Konstruktor
    public Klocek(int w, int d, int h) {
        this.szerokosc = w;
        this.glebokosc = d;
        this.wysokosc = h;
    }

    // Metoda compareTo - sortowanie według powierzchni podstawy (malejąco)
    @Override
    public int compareTo(Klocek other) {
        int thisSurface = this.szerokosc * this.glebokosc;
        int otherSurface = other.szerokosc * other.glebokosc;

        // Sortowanie malejąco według powierzchni podstawy
        if (thisSurface != otherSurface) {
            return otherSurface - thisSurface;
        }

        // Jeśli powierzchnie równe, sortuj według szerokości
        if (this.szerokosc != other.szerokosc) {
            return other.szerokosc - this.szerokosc;
        }

        // W ostateczności według głębokości
        return other.glebokosc - this.glebokosc;
    }

    // Metoda sprawdzająca czy można położyć klocek 'other' na tym klocku
    public boolean canPlaceOn(Klocek other) {
        // Sprawdź oba możliwe ułożenia podstawy
        return (this.szerokosc < other.szerokosc && this.glebokosc < other.glebokosc) ||
               (this.szerokosc < other.glebokosc && this.glebokosc < other.szerokosc);
    }

    // Metoda pomocnicza do wyświetlania
    @Override
    public String toString() {
        return String.format("Klocek[%d×%d×%d]", szerokosc, glebokosc, wysokosc);
    }
}

public class KLO {

    /**
     * Oblicza maksymalną wysokość wieży z klocków
     * @param n liczba oryginalnych klocków
     * @param a tablica pierwszych wymiarów
     * @param b tablica drugich wymiarów
     * @param c tablica trzecich wymiarów
     * @return maksymalna wysokość wieży
     */
    public static int maxTowerHeight(int n, int[] a, int[] b, int[] c) {
        // Krok 1: Stwórz wszystkie możliwe orientacje klocków
        // Każdy klocek może być ułożony na 3 sposoby
        ArrayList<Klocek> wszystkieKlocki = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            // Orientacja 1: wysokość = c[i]
            wszystkieKlocki.add(new Klocek(
                Math.min(a[i], b[i]),
                Math.max(a[i], b[i]),
                c[i]
            ));

            // Orientacja 2: wysokość = b[i]
            wszystkieKlocki.add(new Klocek(
                Math.min(a[i], c[i]),
                Math.max(a[i], c[i]),
                b[i]
            ));

            // Orientacja 3: wysokość = a[i]
            wszystkieKlocki.add(new Klocek(
                Math.min(b[i], c[i]),
                Math.max(b[i], c[i]),
                a[i]
            ));
        }

        // Krok 2: Konwertuj ArrayList na tablicę i posortuj
        Klocek[] klocki = wszystkieKlocki.toArray(new Klocek[0]);
        Arrays.sort(klocki); // Użycie Arrays.sort() z wykładu!

        int rozmiar = klocki.length;

        // Krok 3: Dynamiczne programowanie
        // dp[i] = maksymalna wysokość wieży kończącej się klockiem i
        int[] dp = new int[rozmiar];

        // Każdy klocek sam w sobie tworzy wieżę o wysokości równej jego wysokości
        for (int i = 0; i < rozmiar; i++) {
            dp[i] = klocki[i].wysokosc;
        }

        // Krok 4: Oblicz maksymalną wysokość dla każdego klocka
        for (int i = 1; i < rozmiar; i++) {
            for (int j = 0; j < i; j++) {
                // Jeśli klocek i może być położony na klocku j
                if (klocki[i].canPlaceOn(klocki[j])) {
                    dp[i] = Math.max(dp[i], dp[j] + klocki[i].wysokosc);
                }
            }
        }

        // Krok 5: Znajdź maksymalną wysokość
        int maxHeight = 0;
        for (int i = 0; i < rozmiar; i++) {
            maxHeight = Math.max(maxHeight, dp[i]);
        }

        return maxHeight;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Wczytaj liczbę klocków
        System.out.print("Podaj liczbę klocków: ");
        int n = scanner.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];

        // Wczytaj wymiary klocków
        System.out.println("Podaj wymiary klocków (a b c):");
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            b[i] = scanner.nextInt();
            c[i] = scanner.nextInt();
        }

        // Oblicz i wyświetl wynik
        int wynik = maxTowerHeight(n, a, b, c);
        System.out.println("\nMaksymalna wysokość wieży: " + wynik);

        scanner.close();
    }
}
