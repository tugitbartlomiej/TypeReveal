import java.util.*;

/**
 * WERSJA 1: BEZ WZORCA PROJEKTOWEGO
 *
 * ❌ Problem: Kod pełen if-else i bezpośrednich wywołań new
 * ❌ Duplikacja kodu w wielu miejscach
 * ❌ Trudno utrzymać i rozszerzyć
 */

// ========== KLASY SAMOCHODÓW (bez interfejsu!) ==========

class BMW {
    public String getMarka() { return "BMW M5"; }
    public int getCena() { return 300000; }
    public void jedz() {
        System.out.println("🏎️  BMW M5 jedzie! (V8 twin-turbo)");
    }
}

class Jaguar {
    public String getMarka() { return "Jaguar F-Type"; }
    public int getCena() { return 280000; }
    public void jedz() {
        System.out.println("🐆 Jaguar F-Type jedzie! (V6 supercharged)");
    }
}

class Bentley {
    public String getMarka() { return "Bentley Continental GT"; }
    public int getCena() { return 850000; }
    public void jedz() {
        System.out.println("👑 Bentley Continental GT jedzie! (W12)");
    }
}

class Koenigsegg {
    public String getMarka() { return "Koenigsegg Jesko"; }
    public int getCena() { return 12000000; }
    public void jedz() {
        System.out.println("⚡ Koenigsegg Jesko jedzie! (1600 KM!!!)");
    }
}

// ========== PROGRAM GŁÓWNY ==========

public class BezWzorca {

    /**
     * ❌ PROBLEM 1: Metoda pełna if-else
     * Musisz powielać tę logikę wszędzie!
     */
    public static void wyswietlSamochod(String marka) {
        System.out.println("\n--- Tworzenie samochodu: " + marka + " ---");

        // ❌ Bezpośrednie użycie konkretnych klas!
        if (marka.equalsIgnoreCase("bmw")) {
            BMW auto = new BMW();
            System.out.println("Marka: " + auto.getMarka());
            System.out.println("Cena: " + auto.getCena() + " zł");
            auto.jedz();

        } else if (marka.equalsIgnoreCase("jaguar")) {
            Jaguar auto = new Jaguar();
            System.out.println("Marka: " + auto.getMarka());
            System.out.println("Cena: " + auto.getCena() + " zł");
            auto.jedz();

        } else if (marka.equalsIgnoreCase("bentley")) {
            Bentley auto = new Bentley();
            System.out.println("Marka: " + auto.getMarka());
            System.out.println("Cena: " + auto.getCena() + " zł");
            auto.jedz();

        } else if (marka.equalsIgnoreCase("koenigsegg")) {
            Koenigsegg auto = new Koenigsegg();
            System.out.println("Marka: " + auto.getMarka());
            System.out.println("Cena: " + auto.getCena() + " zł");
            auto.jedz();

        } else {
            System.out.println("❌ Nieznana marka!");
        }
    }

    /**
     * ❌ PROBLEM 2: Powtórzenie tej samej logiki!
     * Ten sam if-else musimy pisać wszędzie
     */
    public static void testJazdy(String marka) {
        System.out.println("\n🏁 Test jazdy: " + marka);

        // ❌ Znowu to samo if-else!
        if (marka.equalsIgnoreCase("bmw")) {
            BMW auto = new BMW();
            auto.jedz();
        } else if (marka.equalsIgnoreCase("jaguar")) {
            Jaguar auto = new Jaguar();
            auto.jedz();
        } else if (marka.equalsIgnoreCase("bentley")) {
            Bentley auto = new Bentley();
            auto.jedz();
        } else if (marka.equalsIgnoreCase("koenigsegg")) {
            Koenigsegg auto = new Koenigsegg();
            auto.jedz();
        } else {
            System.out.println("❌ Nieznana marka!");
        }
    }

    /**
     * ❌ PROBLEM 3: Nie możemy użyć kolekcji!
     * Każdy samochód to inna klasa - brak wspólnego interfejsu
     */
    public static void pokazProblemy() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("❌ PROBLEMY BEZ WZORCA:");
        System.out.println("=".repeat(50));

        System.out.println("1. Duplikacja kodu (if-else wszędzie)");
        System.out.println("2. Trudno dodać nową markę (zmiana w wielu miejscach)");
        System.out.println("3. Brak polimorfizmu (każda klasa osobno)");
        System.out.println("4. Kod zależy od konkretnych klas (BMW, Jaguar, etc.)");

        // ❌ Nie możemy zrobić:
        // List<???> auta = new ArrayList<>();
        // Bo każdy samochód to inna klasa!
    }

    public static void main(String[] args) {
        System.out.println("╔═══════════════════════════════════════╗");
        System.out.println("║  🚗 SALON SAMOCHODOWY                 ║");
        System.out.println("║  WERSJA: BEZ WZORCA (zły przykład!)   ║");
        System.out.println("╚═══════════════════════════════════════╝");

        // Demonstracja problemów
        wyswietlSamochod("bmw");
        wyswietlSamochod("bentley");
        wyswietlSamochod("koenigsegg");

        testJazdy("jaguar");

        pokazProblemy();

        // Interaktywna część
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Dostępne marki: BMW, Jaguar, Bentley, Koenigsegg");
        System.out.print("Wybierz markę: ");
        String wybor = scanner.nextLine();

        wyswietlSamochod(wybor);

        System.out.println("\n⚠️  UWAGA: Ten kod jest ZŁY!");
        System.out.println("Zobacz plik Fabryka.java - tam jest wzorzec!");

        scanner.close();
    }
}
