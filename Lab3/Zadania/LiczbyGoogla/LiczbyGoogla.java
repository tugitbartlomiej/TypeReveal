import java.util.*;

/**
 * Zadanie: Liczby Google'a
 * Temat: String, StringBuffer, operacje na napisach
 */
public class LiczbyGoogla {

    /**
     * Sprawdza czy dana liczba jest "liczbą Google'a"
     * (wygląda tak samo po obróceniu o 180°)
     *
     * @param number liczba do sprawdzenia
     * @return true jeśli liczba jest liczbą Google'a
     */
    public static boolean isGoogleNumber(int number) {
        // Konwertuj liczbę na String - użycie metody z wykładu!
        String str = String.valueOf(number);

        // StringBuffer do budowania odwróconej liczby - z wykładu!
        StringBuffer rotated = new StringBuffer();

        // Sprawdź każdą cyfrę
        for (int i = str.length() - 1; i >= 0; i--) {
            char digit = str.charAt(i); // Użycie charAt() z wykładu!

            // Sprawdź czy cyfra może być obrócona
            char rotatedDigit = getRotatedDigit(digit);

            if (rotatedDigit == '?') {
                // Cyfra nie może być obrócona (2, 3, 4, 5, 7)
                return false;
            }

            // Dodaj obrócona cyfrę
            rotated.append(rotatedDigit);
        }

        // Porównaj oryginalny String z obróconym
        // Użycie equals() z wykładu!
        return str.equals(rotated.toString());
    }

    /**
     * Zwraca cyfrę po obróceniu o 180°
     *
     * @param digit cyfra do obrócenia
     * @return obrócona cyfra lub '?' jeśli obrót niemożliwy
     */
    private static char getRotatedDigit(char digit) {
        switch (digit) {
            case '0': return '0';
            case '1': return '1';
            case '6': return '9';
            case '8': return '8';
            case '9': return '6';
            default:  return '?'; // Cyfry 2, 3, 4, 5, 7
        }
    }

    /**
     * Liczy ile jest liczb Google'a w przedziale [0, n]
     *
     * @param n górna granica przedziału
     * @return liczba liczb Google'a
     */
    public static int countGoogleNumbers(int n) {
        int count = 0;

        for (int i = 0; i <= n; i++) {
            if (isGoogleNumber(i)) {
                count++;
            }
        }

        return count;
    }

    /**
     * Generuje wszystkie liczby Google'a w przedziale [0, n]
     *
     * @param n górna granica przedziału
     * @return lista liczb Google'a
     */
    public static ArrayList<Integer> generateGoogleNumbers(int n) {
        ArrayList<Integer> googleNumbers = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            if (isGoogleNumber(i)) {
                googleNumbers.add(i);
            }
        }

        return googleNumbers;
    }

    /**
     * Znajduje największą liczbę Google'a mniejszą lub równą n
     *
     * @param n górna granica
     * @return największa liczba Google'a <= n, lub -1 jeśli nie istnieje
     */
    public static int largestGoogleNumber(int n) {
        for (int i = n; i >= 0; i--) {
            if (isGoogleNumber(i)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Wyświetla liczby Google'a w czytelny sposób
     *
     * @param numbers lista liczb
     */
    private static void displayNumbers(ArrayList<Integer> numbers) {
        // Użycie StringBuilder z wykładu!
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numbers.size(); i++) {
            sb.append(numbers.get(i));
            if (i < numbers.size() - 1) {
                sb.append(" ");
            }
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== LICZBY GOOGLE'A ===\n");

        // Demonstracja sprawdzania pojedynczych liczb
        System.out.println("Przykłady sprawdzania:");
        int[] testNumbers = {0, 1, 8, 11, 69, 88, 96, 101, 609, 1001, 1234};

        for (int num : testNumbers) {
            boolean result = isGoogleNumber(num);
            System.out.printf("%4d → %s\n", num, result ? "✓ TAK" : "✗ NIE");
        }

        System.out.println("\n" + "=".repeat(40));

        // Wczytaj górną granicę
        System.out.print("\nPodaj górną granicę przedziału: ");
        int n = scanner.nextInt();

        // Generuj i wyświetl liczby Google'a
        System.out.println("\nGenerowanie liczb Google'a...");
        ArrayList<Integer> googleNumbers = generateGoogleNumbers(n);

        System.out.println("\nLiczba liczb Google'a w [0, " + n + "]: " +
                          googleNumbers.size());
        System.out.println("\nWszystkie liczby Google'a:");
        displayNumbers(googleNumbers);

        // Znajdź największą liczbę Google'a
        int largest = largestGoogleNumber(n);
        System.out.println("\nNajwiększa liczba Google'a <= " + n + ": " + largest);

        scanner.close();
    }
}
