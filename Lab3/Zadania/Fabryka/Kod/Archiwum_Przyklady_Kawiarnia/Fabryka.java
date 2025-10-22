import java.util.*;

/**
 * WERSJA 2: WZORZEC FACTORY METHOD
 *
 * ✅ Rozwiązanie: Jedna metoda tworzy wszystkie samochody
 * ✅ Kod używa interfejsu (polimorfizm!)
 * ✅ Łatwo dodać nową markę
 */

// ========== INTERFEJS ==========

interface Samochod {
    String getMarka();
    int getCena();
    void jedz();
}

// ========== KONKRETNE SAMOCHODY ==========

class BMW implements Samochod {
    @Override
    public String getMarka() { return "BMW M5"; }

    @Override
    public int getCena() { return 300000; }

    @Override
    public void jedz() {
        System.out.println("🏎️  BMW M5 jedzie! (V8 twin-turbo, 625 KM)");
    }
}

class Jaguar implements Samochod {
    @Override
    public String getMarka() { return "Jaguar F-Type"; }

    @Override
    public int getCena() { return 280000; }

    @Override
    public void jedz() {
        System.out.println("🐆 Jaguar F-Type jedzie! (V6 supercharged, 380 KM)");
    }
}

class Bentley implements Samochod {
    @Override
    public String getMarka() { return "Bentley Continental GT"; }

    @Override
    public int getCena() { return 850000; }

    @Override
    public void jedz() {
        System.out.println("👑 Bentley Continental GT jedzie! (W12, 635 KM)");
    }
}

class Koenigsegg implements Samochod {
    @Override
    public String getMarka() { return "Koenigsegg Jesko"; }

    @Override
    public int getCena() { return 12000000; }

    @Override
    public void jedz() {
        System.out.println("⚡ Koenigsegg Jesko jedzie! (V8 twin-turbo, 1600 KM!!!)");
    }
}

// ========== FABRYKA - TO JEST WZORZEC! ==========

/**
 * ✅ KLUCZOWA KLASA: FabrykaSamochodow
 * Wzorzec Factory Method - jedna metoda tworzy wszystkie auta!
 */
class FabrykaSamochodow {

    /**
     * ✅ METODA FABRYKUJĄCA
     * Centralizuje tworzenie obiektów w jednym miejscu
     */
    public static Samochod stworzSamochod(String marka) {
        if (marka == null) {
            return null;
        }

        // ✅ Jedna metoda obsługuje wszystkie marki!
        switch (marka.toLowerCase().trim()) {
            case "bmw":
                return new BMW();

            case "jaguar":
                return new Jaguar();

            case "bentley":
                return new Bentley();

            case "koenigsegg":
                return new Koenigsegg();

            default:
                System.out.println("⚠️  Nieznana marka: " + marka);
                return null;
        }
    }

    /**
     * Pomocnicza metoda - lista dostępnych marek
     */
    public static String[] dostepneMarki() {
        return new String[]{"BMW", "Jaguar", "Bentley", "Koenigsegg"};
    }
}

// ========== PROGRAM GŁÓWNY ==========

public class Fabryka {

    /**
     * ✅ Teraz metoda jest PROSTA - używa fabryki!
     */
    public static void wyswietlSamochod(Samochod auto) {
        if (auto != null) {
            System.out.println("\n--- " + auto.getMarka() + " ---");
            System.out.println("Cena: " + String.format("%,d", auto.getCena()) + " zł");
            auto.jedz();
        }
    }

    /**
     * ✅ Demonstracja polimorfizmu
     */
    public static void demonstracjaPolimorfizmu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("✅ ZALETY WZORCA FACTORY:");
        System.out.println("=".repeat(50));

        // ✅ Możemy użyć kolekcji! (polimorfizm)
        List<Samochod> salon = new ArrayList<>();
        salon.add(FabrykaSamochodow.stworzSamochod("bmw"));
        salon.add(FabrykaSamochodow.stworzSamochod("jaguar"));
        salon.add(FabrykaSamochodow.stworzSamochod("bentley"));
        salon.add(FabrykaSamochodow.stworzSamochod("koenigsegg"));

        System.out.println("\n🏪 Samochody w salonie:");
        for (Samochod auto : salon) {
            if (auto != null) {
                System.out.printf("  - %-25s %,10d zł\n",
                    auto.getMarka(), auto.getCena());
            }
        }

        // ✅ Obliczanie - wszystko przez interfejs!
        int lacznaWartosc = 0;
        for (Samochod auto : salon) {
            if (auto != null) {
                lacznaWartosc += auto.getCena();
            }
        }
        System.out.printf("\n💰 Łączna wartość salonu: %,d zł\n", lacznaWartosc);
    }

    public static void main(String[] args) {
        System.out.println("╔═══════════════════════════════════════╗");
        System.out.println("║  🚗 SALON SAMOCHODOWY                 ║");
        System.out.println("║  WERSJA: Factory Method Pattern       ║");
        System.out.println("╚═══════════════════════════════════════╝");

        // Demonstracja wzorca
        System.out.println("\nDostępne marki:");
        for (String marka : FabrykaSamochodow.dostepneMarki()) {
            // ✅ Użycie fabryki - PROSTO!
            Samochod auto = FabrykaSamochodow.stworzSamochod(marka);
            wyswietlSamochod(auto);
        }

        // Demonstracja polimorfizmu
        demonstracjaPolimorfizmu();

        // Interaktywna część
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Wybierz markę: BMW, Jaguar, Bentley, Koenigsegg");
        System.out.print("Twój wybór: ");
        String wybor = scanner.nextLine();

        // ✅ Jedna linijka tworzy samochód!
        Samochod wybrany = FabrykaSamochodow.stworzSamochod(wybor);
        wyswietlSamochod(wybrany);

        System.out.println("\n✅ Wzorzec Factory Method - kod jest czysty!");

        scanner.close();
    }
}
