/*
 * ========================================
 *  CWICZENIE 3: RZUTOWANIE TYPOW - KALKULATOR WIEKU
 * ========================================
 *
 * ZADANIE:
 * Napisz program "Kalkulator wieku", ktory:
 * 1. Wczyta rok urodzenia uzytkownika (jako tekst)
 * 2. Wczyta obecny rok (jako tekst)
 * 3. Obliczy wiek uzytkownika
 * 4. Wyswietli: "Masz X lat"
 *
 * ZADANIE BONUS:
 * - Oblicz ile to w przyblizeniu dni (wiek * 365)
 * - Oblicz ile to w przyblizeniu godzin (dni * 24)
 *
 * PRZYKLAD DZIALANIA:
 * Podaj rok urodzenia: 2000
 * Podaj obecny rok: 2024
 *
 * Masz 24 lat
 * To okolo 8760 dni
 * To okolo 210240 godzin
 *
 * WSKAZOWKI:
 * - Scanner wczytuje ZAWSZE tekst (String)
 * - Aby obliczyc wiek, musisz zamienic tekst na liczbe
 * - Uzyj Integer.parseInt(tekst) do zamiany String na int
 * - wiek = obecnyRok - rokUrodzenia
 * - dni = wiek * 365
 * - godziny = dni * 24
 *
 * ========================================
 */

import java.util.Scanner;

public class ZadanieCasting {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj rok urodzenia: ");
        String rokUrodzeniaString = scanner.nextLine();

        int rokUrodzenia = Integer.parseInt(rokUrodzeniaString);

        System.out.print("Podaj obecny rok: ");
        String obecnyRokString = scanner.nextLine();

        int obecnyRok = Integer.parseInt(obecnyRokString);

        int wiek = obecnyRok - rokUrodzenia;

        System.out.println("Masz " + wiek + " lat");

        int dni = wiek * 365;

        int godziny = dni * 24;

        System.out.println("To okolo " + dni + " dni");
        System.out.println("To okolo " + godziny + " godzin");

        scanner.close();

    }
}
