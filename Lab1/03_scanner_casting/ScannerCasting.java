import java.util.Scanner;

public class ScannerCasting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // KROK 1: Wczytywanie tekstu i zamiana na liczbę całkowitą
        System.out.print("Podaj liczbe calkowita: ");
        String tekstLiczby = scanner.nextLine();  // Wczytujemy jako tekst

        // Zamieniamy tekst na liczbę całkowitą (int)
        // parseInt = "parse integer" = "przetwórz na liczbę całkowitą"
        int liczba = Integer.parseInt(tekstLiczby);

        System.out.println("Twoja liczba: " + liczba);
        System.out.println("Twoja liczba * 2 = " + (liczba * 2));

        // KROK 2: Wczytywanie i zamiana na liczbę zmiennoprzecinkową
        System.out.print("\nPodaj liczbe z przecinkiem (np. 3.14): ");
        String tekstDouble = scanner.nextLine();

        // Zamieniamy tekst na double (liczba z przecinkiem)
        double liczbaDouble = Double.parseDouble(tekstDouble);

        System.out.println("Twoja liczba: " + liczbaDouble);
        System.out.println("Twoja liczba / 2 = " + (liczbaDouble / 2));

        // KROK 3: Rzutowanie - zamiana double na int (ucina przecinek!)
        int liczbaUcieta = (int) liczbaDouble;
        System.out.println("\nLiczba " + liczbaDouble + " po uciu ciu przecinka: " + liczbaUcieta);

        scanner.close();
    }
}
