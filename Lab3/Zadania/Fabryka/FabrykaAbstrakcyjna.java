/**
 * WERSJA 3: WZORZEC ABSTRACT FACTORY
 *
 * ✅ Rozwiązanie: Różne fabryki dla różnych SEGMENTÓW
 * ✅ Każda fabryka tworzy RODZINĘ produktów
 * ✅ Wszystkie produkty z rodziny są spójne
 */

// ========== INTERFEJS SAMOCHODU ==========

interface Samochod {
    String getModel();
    String getTyp();
    int getCena();
    void jedz();
}

// ========== RODZINA LUXURY (Bentley) ==========

class BentleySedan implements Samochod {
    @Override
    public String getModel() { return "Bentley Flying Spur"; }

    @Override
    public String getTyp() { return "Sedan"; }

    @Override
    public int getCena() { return 950000; }

    @Override
    public void jedz() {
        System.out.println("👑 Bentley Flying Spur (Sedan) - luksusowa limuzyna!");
    }
}

class BentleySUV implements Samochod {
    @Override
    public String getModel() { return "Bentley Bentayga"; }

    @Override
    public String getTyp() { return "SUV"; }

    @Override
    public int getCena() { return 1100000; }

    @Override
    public void jedz() {
        System.out.println("👑 Bentley Bentayga (SUV) - luksusowy terenowy!");
    }
}

// ========== RODZINA SPORT (Koenigsegg) ==========

class KoenigseggCoupe implements Samochod {
    @Override
    public String getModel() { return "Koenigsegg Jesko"; }

    @Override
    public String getTyp() { return "Coupe"; }

    @Override
    public int getCena() { return 12000000; }

    @Override
    public void jedz() {
        System.out.println("⚡ Koenigsegg Jesko (Coupe) - 1600 KM hipersamochód!");
    }
}

class KoenigseggRoadster implements Samochod {
    @Override
    public String getModel() { return "Koenigsegg Regera"; }

    @Override
    public String getTyp() { return "Roadster"; }

    @Override
    public int getCena() { return 11500000; }

    @Override
    public void jedz() {
        System.out.println("⚡ Koenigsegg Regera (Roadster) - 1500 KM bez dachu!");
    }
}

// ========== INTERFEJS FABRYKI ABSTRAKCYJNEJ ==========

/**
 * ✅ KLUCZOWY INTERFEJS: AutoFactory
 * Definiuje metody do tworzenia RODZINY samochodów
 */
interface AutoFactory {
    Samochod createSedan();
    Samochod createSUV();
}

// ========== KONKRETNE FABRYKI ==========

/**
 * ✅ Fabryka segmentu LUXURY
 * Tworzy luksusowe samochody Bentley
 */
class LuxuryFactory implements AutoFactory {
    @Override
    public Samochod createSedan() {
        return new BentleySedan();
    }

    @Override
    public Samochod createSUV() {
        return new BentleySUV();
    }
}

/**
 * ✅ Fabryka segmentu SPORT
 * Tworzy hipersamochody Koenigsegg
 */
class SportFactory implements AutoFactory {
    @Override
    public Samochod createSedan() {
        // Sport - zamiast sedan mamy coupe
        return new KoenigseggCoupe();
    }

    @Override
    public Samochod createSUV() {
        // Sport - zamiast SUV mamy roadster
        return new KoenigseggRoadster();
    }
}

// ========== APLIKACJA KLIENCKA ==========

/**
 * ✅ Klasa Showroom pracuje z abstrakcjami
 * NIE zna konkretnych klas (BentleySedan, etc.)
 */
class Showroom {
    private Samochod sedan;
    private Samochod suv;
    private String segment;

    public Showroom(AutoFactory factory, String segment) {
        this.segment = segment;
        // ✅ Tworzymy CAŁĄ RODZINĘ z jednej fabryki!
        this.sedan = factory.createSedan();
        this.suv = factory.createSUV();
    }

    public void prezentacjaOferty() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("🏪 SHOWROOM: Segment " + segment);
        System.out.println("=".repeat(50));

        System.out.println("\n📦 Model 1:");
        System.out.println("   " + sedan.getModel() + " (" + sedan.getTyp() + ")");
        System.out.println("   Cena: " + String.format("%,d", sedan.getCena()) + " zł");
        sedan.jedz();

        System.out.println("\n📦 Model 2:");
        System.out.println("   " + suv.getModel() + " (" + suv.getTyp() + ")");
        System.out.println("   Cena: " + String.format("%,d", suv.getCena()) + " zł");
        suv.jedz();

        int lacznie = sedan.getCena() + suv.getCena();
        System.out.println("\n💰 Łączna wartość: " + String.format("%,d", lacznie) + " zł");
    }
}

// ========== PROGRAM GŁÓWNY ==========

public class FabrykaAbstrakcyjna {

    public static void main(String[] args) {
        System.out.println("╔═══════════════════════════════════════╗");
        System.out.println("║  🚗 EKSKLUZYWNY SALON SAMOCHODOWY     ║");
        System.out.println("║  WERSJA: Abstract Factory Pattern     ║");
        System.out.println("╚═══════════════════════════════════════╝");

        // ✅ KLUCZOWA IDEA: Wybieramy segment (fabrykę)
        // i dostajemy CAŁĄ RODZINĘ spójnych produktów!

        System.out.println("\n🎯 Kluczowa idea:");
        System.out.println("Każda fabryka tworzy RODZINĘ spójnych samochodów!");

        // Demonstracja 1: Segment LUXURY
        System.out.println("\n" + "█".repeat(50));
        System.out.println("SEGMENT 1: LUXURY (Bentley)");
        System.out.println("█".repeat(50));

        AutoFactory luxuryFactory = new LuxuryFactory();
        Showroom luxuryShowroom = new Showroom(luxuryFactory, "LUXURY");
        luxuryShowroom.prezentacjaOferty();

        // Demonstracja 2: Segment SPORT
        System.out.println("\n" + "█".repeat(50));
        System.out.println("SEGMENT 2: SPORT (Koenigsegg)");
        System.out.println("█".repeat(50));

        AutoFactory sportFactory = new SportFactory();
        Showroom sportShowroom = new Showroom(sportFactory, "SPORT");
        sportShowroom.prezentacjaOferty();

        // Podsumowanie
        System.out.println("\n" + "=".repeat(50));
        System.out.println("✅ ZALETY ABSTRACT FACTORY:");
        System.out.println("=".repeat(50));
        System.out.println("1. Rodziny produktów są SPÓJNE");
        System.out.println("   - LuxuryFactory → tylko Bentley");
        System.out.println("   - SportFactory → tylko Koenigsegg");
        System.out.println("\n2. Łatwa ZMIANA segmentu");
        System.out.println("   - Zmień fabrykę → zmień całą rodzinę!");
        System.out.println("\n3. Kod pracuje z ABSTRAKCJAMI");
        System.out.println("   - Showroom nie zna konkretnych klas");
        System.out.println("   - Używa tylko AutoFactory i Samochod");

        System.out.println("\n" + "=".repeat(50));
        System.out.println("PORÓWNANIE WZORCÓW:");
        System.out.println("=".repeat(50));
        System.out.println("Factory Method:     stworzSamochod(\"bmw\")");
        System.out.println("                    → jeden produkt");
        System.out.println("\nAbstract Factory:   factory.createSedan()");
        System.out.println("                    factory.createSUV()");
        System.out.println("                    → rodzina produktów!");
    }
}
