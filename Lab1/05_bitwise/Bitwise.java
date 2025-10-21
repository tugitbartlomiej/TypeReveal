import java.util.Scanner;

public class Bitwise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj liczbe calkowita: ");
        int liczba = Integer.parseInt(scanner.nextLine());

        // MNOŻENIE I DZIELENIE BEZ * i /
        // Używamy operacji bitowych - przesuwania bitów w lewo/prawo
        System.out.println("\n=== MNOZENIE BEZ ZNAKU * ===");

        // << to przesunięcie w LEWO (left shift)
        // Każde przesunięcie w lewo = mnożenie razy 2
        int razy2 = liczba << 1;    // przesuń o 1 bit = razy 2
        System.out.println(liczba + " * 2 = " + razy2);

        int razy4 = liczba << 2;    // przesuń o 2 bity = razy 4
        System.out.println(liczba + " * 4 = " + razy4);

        int razy8 = liczba << 3;    // przesuń o 3 bity = razy 8
        System.out.println(liczba + " * 8 = " + razy8);

        System.out.println("\n=== DZIELENIE BEZ ZNAKU / ===");

        // >> to przesunięcie w PRAWO (right shift)
        // Każde przesunięcie w prawo = dzielenie przez 2
        int przez2 = liczba >> 1;   // przesuń o 1 bit = przez 2
        System.out.println(liczba + " / 2 = " + przez2);

        int przez4 = liczba >> 2;   // przesuń o 2 bity = przez 4
        System.out.println(liczba + " / 4 = " + przez4);

        int przez8 = liczba >> 3;   // przesuń o 3 bity = przez 8
        System.out.println(liczba + " / 8 = " + przez8);

        // BONUS: jak to działa w systemie binarnym?
        System.out.println("\n=== JAK TO DZIALA? ===");
        System.out.println("Liczba " + liczba + " w zapisie binarnym: " + Integer.toBinaryString(liczba));
        System.out.println("Po przesunieciu w lewo << 1: " + Integer.toBinaryString(razy2));
        System.out.println("Po przesunieciu w prawo >> 1: " + Integer.toBinaryString(przez2));

        scanner.close();
    }
}
