/*
 * ========================================
 *  PRZYKŁAD: MASKI BITOWE - GENEROWANIE PODZBIORÓW
 * ========================================
 *
 * Ten program pokazuje jak używać masek bitowych do:
 * 1. Generowania wszystkich możliwych podzbiorów zbioru
 * 2. Sprawdzania czy zbiór można podzielić na dwa równe części
 *
 * CZYM JEST MASKA BITOWA?
 * Maska bitowa to liczba, gdzie każdy bit reprezentuje "tak/nie" dla elementu.
 *
 * Przykład dla zbioru [3, 5, 7]:
 * Maska 101 (binarne) = 5 (dziesiętne) oznacza: weź element 0 i element 2
 * - bit 0 (od prawej) = 1 → weź element 0 (liczba 3)
 * - bit 1 = 0 → pomiń element 1 (liczba 5)
 * - bit 2 = 1 → weź element 2 (liczba 7)
 * Więc maska 101 = podzbiór {3, 7}
 *
 * ========================================
 */

public class MaskiBitowe {

    public static void main(String[] args) {

        // Nasz przykładowy zbiór liczb
        int[] zbior = {3, 5, 7, 1}; //w java to tablica
        int n = zbior.length;

        System.out.println("Zbiór: {3, 5, 7, 1}\n");

        // Liczba wszystkich podzbiorów = 2^n
        // Dla 4 elementów: 2^4 = 16 możliwych podzbiorów
        int liczba_podzbiorow = 1 << n;  // To samo co: (int) Math.pow(2, n)

        System.out.println("Liczba wszystkich podzbiorów: " + liczba_podzbiorow);
        System.out.println();

        // Generujemy wszystkie podzbiory używając masek bitowych
        for (int maska = 0; maska < liczba_podzbiorow; maska++) {

            System.out.print("Maska " + maska + " (binarnie: " +
                           String.format("%4s", Integer.toBinaryString(maska)).replace(' ', '0') +
                           ") → Podzbiór: {");

            // Sprawdzamy każdy bit maski
            boolean pierwszy = true; // Flaga do formatowania przecinków i tylko tylee
            for (int i = 0; i < n; i++) {
                // Sprawdź czy i-ty bit jest ustawiony
                if ((maska & (1 << i)) != 0) {
                    if (!pierwszy) System.out.print(", ");
                    System.out.print(zbior[i]);
                    pierwszy = false;
                }
            }
            System.out.println("}");
        }
    }
}
