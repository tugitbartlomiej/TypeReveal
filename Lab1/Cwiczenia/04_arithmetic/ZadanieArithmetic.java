/*
 * ========================================
 *  CWICZENIE 4: FUNKCJE ARYTMETYCZNE - KALKULATOR BMI
 * ========================================
 *
 * ZADANIE:
 * Napisz program "Kalkulator BMI", ktory:
 * 1. Wczyta wzrost uzytkownika w metrach (np. 1.75)
 * 2. Wczyta wage uzytkownika w kilogramach (np. 70)
 * 3. Obliczy BMI wedlug wzoru: BMI = waga / (wzrost * wzrost)
 * 4. Wyswietli wynik
 *
 * ZADANIE BONUS (dla chetnych):
 * Dodaj interpretacje BMI:
 * - BMI < 18.5 → "Niedowaga"
 * - BMI 18.5-24.9 → "Waga prawidlowa"
 * - BMI >= 25 → "Nadwaga"
 *
 * PRZYKLAD DZIALANIA:
 * Podaj wzrost w metrach (np. 1.75): 1.75
 * Podaj wage w kg (np. 70): 70
 *
 * Twoje BMI wynosi: 22.86
 * Waga prawidlowa
 *
 * WSKAZOWKI:
 * - Uzyj Double.parseDouble() do zamiany String na double
 * - Mozesz uzyc: wzrost * wzrost  lub  Math.pow(wzrost, 2)
 * - Do BONUSU uzyj instrukcji if:
 *   if (bmi < 18.5) {
 *       System.out.println("Niedowaga");
 *   }
 *
 * ========================================
 */

import java.util.Scanner;

public class ZadanieArithmetic {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj wzrost w metrach (np. 1.75): ");
        String wzrostString = scanner.nextLine();
        double wzrost = Double.parseDouble(wzrostString);

        System.out.print("Podaj wage w kg (np. 70): ");
        String wagaString = scanner.nextLine();
        double waga = Double.parseDouble(wagaString);

        double bmi = waga / (wzrost * wzrost);

        System.out.println("Twoje BMI wynosi: " + bmi);

        if (bmi < 18.5) {
            System.out.println("Niedowaga");
        } else if (bmi < 25) {
            System.out.println("Waga prawidlowa");
        } else {
            System.out.println("Nadwaga");
        }

        scanner.close();

    }
}
