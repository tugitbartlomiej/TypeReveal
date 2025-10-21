/*
 * ========================================
 *  CWICZENIE 2: SCANNER - WCZYTYWANIE DANYCH
 * ========================================
 *
 * ZADANIE:
 * Napisz program, ktory zapyta uzytkownika o:
 * 1. Imie
 * 2. Nazwisko
 * 3. Wiek
 * 4. Ulubiony kolor
 * 5. Miasto zamieszkania
 *
 * Nastepnie wyswietl wszystkie dane w jednej linii:
 * "Jan Kowalski ma 20 lat, lubi niebieski i mieszka w Warszawie"
 *
 * PRZYKLAD DZIALANIA:
 * Podaj imie: Jan
 * Podaj nazwisko: Kowalski
 * Podaj wiek: 20
 * Podaj ulubiony kolor: niebieski
 * Podaj miasto: Warszawa
 *
 * Jan Kowalski ma 20 lat, lubi niebieski i mieszka w Warszawie
 *
 * WSKAZOWKI:
 * - Uzyj Scanner scanner = new Scanner(System.in);
 * - Uzyj scanner.nextLine() do wczytania tekstu
 * - Uzyj System.out.print("tekst: "); do wyswietlenia pytania (bez nowej linii)
 * - Uzyj + do polaczenia tekstow
 * - Pamietaj o scanner.close() na koncu
 *
 * ========================================
 */

import java.util.Scanner;

public class ZadanieScanner {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj imie: ");
        String imie = scanner.nextLine();

        System.out.print("Podaj nazwisko: ");
        String nazwisko = scanner.nextLine();

        System.out.print("Podaj wiek: ");
        String wiek = scanner.nextLine();

        System.out.print("Podaj ulubiony kolor: ");
        String kolor = scanner.nextLine();

        System.out.print("Podaj miasto: ");
        String miasto = scanner.nextLine();

        System.out.println(imie + " " + nazwisko + " ma " + wiek + " lat, lubi " + kolor + " i mieszka w " + miasto);

        scanner.close();

    }
}
