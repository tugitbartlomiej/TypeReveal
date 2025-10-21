// ZADANIE: Popraw błędy w oryginalnym programie
//
// Oryginalny program (z błędami):
// public class Blady {
//     public static void main() {                    // BŁĄD 1: brak (String[] args)
//         string a="1.2";                            // BŁĄD 2: "string" zamiast "String"
//         string b="8.10";                           // BŁĄD 3: "string" zamiast "String"
//         double k=a+b;                              // BŁĄD 4: nie można dodawać Stringów do double
//         System.out.println(k);
//     }
// }

// POPRAWIONY PROGRAM:
public class Blady {

    // POPRAWKA 1: Dodano (String[] args) - wymagany parametr metody main
    public static void main(String[] args) {

        // POPRAWKA 2 i 3: Zmieniono "string" na "String" (wielka litera S)
        String a = "1.2";
        String b = "8.10";

        // POPRAWKA 4: Użyto Double.parseDouble() do zamiany String na double
        // Najpierw zamieniamy tekst na liczbę, dopiero potem dodajemy
        double k = Double.parseDouble(a) + Double.parseDouble(b);

        // Wyświetlamy wynik
        System.out.println("Wynik: " + k);
    }
}
