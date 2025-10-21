import java.util.Scanner;

public class Arithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //wczytujemy dwie liczby
        System.out.print("Podaj pierwsza liczbe: ");
        double a = Double.parseDouble(scanner.nextLine());

        System.out.print("Podaj druga liczbe: ");
        double b = Double.parseDouble(scanner.nextLine());

        // PODSTAWOWE DZIAŁANIA MATEMATYCZNE
        System.out.println("\n=== PODSTAWOWE DZIALANIA ===");

        // Dodawanie
        double suma = a + b;
        System.out.println(a + " + " + b + " = " + suma);

        // Odejmowanie
        double roznica = a - b;
        System.out.println(a + " - " + b + " = " + roznica);

        // Mnożenie
        double iloczyn = a * b;
        System.out.println(a + " * " + b + " = " + iloczyn);

        // Dzielenie
        double iloraz = a / b;
        System.out.println(a + " / " + b + " = " + iloraz);

        // PRZYDATNE FUNKCJE Z KLASY Math
        System.out.println("\n=== PRZYDATNE FUNKCJE ===");

        // Potęgowanie - a do potęgi b
        double potega = Math.pow(a, b);
        System.out.println(a + " do potegi " + b + " = " + potega);

        // Pierwiastek kwadratowy
        double pierwiastek = Math.sqrt(a);
        System.out.println("Pierwiastek z " + a + " = " + pierwiastek);

        // Wartość bezwzględna (bez minusa)
        double bezwzgledna = Math.abs(a);
        System.out.println("Wartosc bezwzgledna " + a + " = " + bezwzgledna);

        // Większa z dwóch liczb
        double max = Math.max(a, b);
        System.out.println("Wieksza liczba: " + max);

        // Mniejsza z dwóch liczb
        double min = Math.min(a, b);
        System.out.println("Mniejsza liczba: " + min);

        scanner.close();
    }
}
