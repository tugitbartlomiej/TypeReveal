/*
 * ========================================
 *  CWICZENIE 6: ZNAJDOWANIE I POPRAWIANIE BLEDOW
 * ========================================
 *
 * ZADANIE:
 * Ponizszy kod zawiera 5 bledow!
 * Znajdz wszystkie bledy i popraw je, aby program sie skompilowal i dzialal.
 *
 * ZNALEZIONE BLEDY:
 * 1. Brak "String[] args" w metodzie main
 * 2. "string" zamiast "String" (mala litera)
 * 3. "string" zamiast "String" (mala litera) - drugi raz
 * 4. Proba dodania String + String i przypisania do int (trzeba uzyc Integer.parseInt)
 * 5. Brak srednika na koncu System.out.println
 */

public class ZadanieBledow {

    public static void main(String[] args) {

        String x = "10";

        String y = "20";

        int suma = Integer.parseInt(x) + Integer.parseInt(y);

        System.out.println("Suma: " + suma);
    }
}
