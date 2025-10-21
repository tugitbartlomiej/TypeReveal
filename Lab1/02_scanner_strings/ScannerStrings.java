// Importujemy klasę Scanner, która pozwala wczytywać dane od użytkownika
import java.util.Scanner;

public class ScannerStrings {
    public static void main(String[] args) {


        // Tworzymy obiekt Scanner do wczytywania danych z klawiatury
        // System.in oznacza "wejście standardowe" czyli klawiaturę
        Scanner scanner = new Scanner(System.in);

        // Wyświetlamy pytanie
        System.out.print("Podaj swoje imie: ");

        // Wczytujemy całą linię tekstu (String) i zapisujemy do zmiennej imie
        String imie = scanner.nextLine();

        // To samo dla nazwiska
        System.out.print("Podaj swoje nazwisko: ");
        String nazwisko = scanner.nextLine();

        // Wyświetlamy wczytane dane
        // Znak + łączy teksty (konkatenacja)
        System.out.println("Witaj " + imie + " " + nazwisko + "!");

        // Zamykamy scanner gdy już nie jest potrzebny
        scanner.close();
    }
}
