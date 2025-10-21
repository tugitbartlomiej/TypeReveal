/*
 * ========================================
 *  CWICZENIE 5: OPERACJE BITOWE - SZYBKIE OBLICZENIA
 * ========================================
 *
 * ZADANIE:
 * Napisz program, ktory:
 * 1. Wczyta liczbe calkowita od uzytkownika
 * 2. Obliczy i wyswietli (BEZ uzycia operatorow * i /):
 *    - liczba × 16
 *    - liczba × 32
 *    - liczba ÷ 16
 *    - liczba ÷ 32
 *
 * PRZYKLAD DZIALANIA:
 * Podaj liczbe calkowita: 64
 *
 * 64 × 16 = 1024
 * 64 × 32 = 2048
 * 64 ÷ 16 = 4
 * 64 ÷ 32 = 2
 *
 * WSKAZOWKI:
 * Mnozenie przez potegi dwojki:
 * - × 2 = << 1   (przesuniecie o 1 bit w lewo)
 * - × 4 = << 2   (przesuniecie o 2 bity w lewo)
 * - × 8 = << 3   (przesuniecie o 3 bity w lewo)
 * - × 16 = << 4  (przesuniecie o 4 bity w lewo)
 * - × 32 = << 5  (przesuniecie o 5 bitow w lewo)
 *
 * Dzielenie przez potegi dwojki:
 * - ÷ 2 = >> 1   (przesuniecie o 1 bit w prawo)
 * - ÷ 4 = >> 2   (przesuniecie o 2 bity w prawo)
 * - ÷ 8 = >> 3   (przesuniecie o 3 bity w prawo)
 * - ÷ 16 = >> 4  (przesuniecie o 4 bity w prawo)
 * - ÷ 32 = >> 5  (przesuniecie o 5 bitow w prawo)
 *
 * MATEMATYKA:
 * Dlaczego << 4 to × 16?
 * Bo 2^4 = 16
 * Kazde przesuniecie w lewo to mnozenie przez 2
 *
 */

import java.util.Scanner;

public class ZadanieBitwise {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj liczbe calkowita: ");
        String liczbaString = scanner.nextLine();
        int liczba = Integer.parseInt(liczbaString);

        int razy16 = liczba << 4;

        int razy32 = liczba << 5;

        int przez16 = liczba >> 4;

        int przez32 = liczba >> 5;

        System.out.println(liczba + " × 16 = " + razy16);
        System.out.println(liczba + " × 32 = " + razy32);
        System.out.println(liczba + " ÷ 16 = " + przez16);
        System.out.println(liczba + " ÷ 32 = " + przez32);

        scanner.close();

    }
}
