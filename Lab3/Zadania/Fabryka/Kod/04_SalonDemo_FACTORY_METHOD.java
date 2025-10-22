/**
 * SALON BAJTAZARA - KROK 2: WZORZEC FABRYKA (Factory Method)
 *
 * Problem: Nadal piszemy 'new BMW()', 'new Jaguar()'...
 * Rozwiązanie: FABRYKA - jedna metoda tworzy wszystkie samochody!
 */

// ========== TEN SAM INTERFEJS CO WCZEŚNIEJ ==========

interface Samochod {
    String getMarka();
    int getCena();
    void jedz();
    void pokazSpecjalneFunkcje();
}

// ========== TE SAME KLASY CO WCZEŚNIEJ ==========

class BMW implements Samochod {
    @Override
    public String getMarka() { return "BMW M5"; }

    @Override
    public int getCena() { return 300000; }

    @Override
    public void jedz() {
        System.out.println("🏎️ BMW jedzie!");
    }

    @Override
    public void pokazSpecjalneFunkcje() {
        System.out.println("⚡ TRYB M AKTYWNY! +100 KM!");
    }
}

class Jaguar implements Samochod {
    @Override
    public String getMarka() { return "Jaguar F-Type"; }

    @Override
    public int getCena() { return 280000; }

    @Override
    public void jedz() {
        System.out.println("🐆 Jaguar jedzie!");
    }

    @Override
    public void pokazSpecjalneFunkcje() {
        System.out.println("🔊 RRRROOOAAARRR! (V8 supercharged)");
    }
}

class Bentley implements Samochod {
    @Override
    public String getMarka() { return "Bentley Continental GT"; }

    @Override
    public int getCena() { return 850000; }

    @Override
    public void jedz() {
        System.out.println("👑 Bentley jedzie luksusowo!");
    }

    @Override
    public void pokazSpecjalneFunkcje() {
        System.out.println("💺 Masaż foteli WŁĄCZONY - poziom relaksu: MAKSYMALNY");
    }
}

class Koenigsegg implements Samochod {
    @Override
    public String getMarka() { return "Koenigsegg Jesko"; }

    @Override
    public int getCena() { return 12000000; }

    @Override
    public void jedz() {
        System.out.println("⚡ Koenigsegg jedzie!");
    }

    @Override
    public void pokazSpecjalneFunkcje() {
        // ⚡ EGZOTYCZNY - 3 funkcje!
        System.out.println("🚀 TRYB 1600 KM AKTYWNY!!!");
        System.out.println("💨 NITRO WŁĄCZONE! BOOST!");
        System.out.println("📊 Prędkość maksymalna: 483 km/h!");
    }
}

// ========== ⭐ KROK 2: FABRYKA! ==========

class FabrykaSamochodow {

    /**
     * ⭐ TO JEST WZORZEC FACTORY METHOD!
     *
     * Jedna metoda tworzy WSZYSTKIE samochody
     * Zwraca INTERFEJS (Samochod), nie konkretną klasę!
     */
    public static Samochod stworzSamochod(String marka) {
        if (marka == null) {
            return null;
        }

        // Normalizacja - case insensitive
        String markaNorm = marka.toLowerCase().trim();

        // ✅ FABRYKA - decyduje która klasa zostanie utworzona
        switch (markaNorm) {
            case "bmw":
                return new BMW();

            case "jaguar":
                return new Jaguar();

            case "bentley":
                return new Bentley();

            case "koenigsegg":
                return new Koenigsegg();

            default:
                System.out.println("⚠️ Nieznana marka: " + marka);
                return null;
        }
    }
}

// ========== PROGRAM GŁÓWNY ==========

public class SalonDemo_KROK2_fabryka {

    public static void main(String[] args) {
        System.out.println("╔═══════════════════════════════════════╗");
        System.out.println("║  🏭 KROK 2: WZORZEC FABRYKA           ║");
        System.out.println("╚═══════════════════════════════════════╝\n");

        // ✅ PRZED (bez fabryki):
        System.out.println("❌ PRZED (bez fabryki):");
        System.out.println("Samochod bmw = new BMW();");
        System.out.println("Samochod jaguar = new Jaguar();");
        System.out.println("// Muszę WIEDZIEĆ jaką klasę utworzyć!\n");

        // ✅ PO (z fabryką):
        System.out.println("✅ PO (z fabryką):");
        System.out.println("Samochod bmw = FabrykaSamochodow.stworzSamochod(\"bmw\");");
        System.out.println("Samochod jaguar = FabrykaSamochodow.stworzSamochod(\"jaguar\");");
        System.out.println("// Jedna metoda, różne parametry!\n");

        System.out.println("=".repeat(50));

        // ✅ Używamy fabryki!
        String[] marki = {"bmw", "jaguar", "bentley", "koenigsegg"};

        for (String marka : marki) {
            System.out.println("\n=== Tworzenie: " + marka + " ===");

            // ⭐ FABRYKA W AKCJI!
            Samochod auto = FabrykaSamochodow.stworzSamochod(marka);

            if (auto != null) {
                System.out.println("Marka: " + auto.getMarka());
                System.out.println("Cena: " + auto.getCena() + " bajtalarów");
                auto.jedz();
                auto.pokazSpecjalneFunkcje();
            }
        }

        // ✅ Demonstracja - case insensitive
        System.out.println("\n" + "=".repeat(50));
        System.out.println("✅ BONUS: Case insensitive!");
        System.out.println("=".repeat(50));

        Samochod auto1 = FabrykaSamochodow.stworzSamochod("BMW");
        Samochod auto2 = FabrykaSamochodow.stworzSamochod("Bmw");
        Samochod auto3 = FabrykaSamochodow.stworzSamochod("  bmw  ");

        System.out.println("stworzSamochod(\"BMW\"): " + (auto1 != null ? "✓" : "✗"));
        System.out.println("stworzSamochod(\"Bmw\"): " + (auto2 != null ? "✓" : "✗"));
        System.out.println("stworzSamochod(\"  bmw  \"): " + (auto3 != null ? "✓" : "✗"));

        // ✅ Demonstracja - nieznana marka
        System.out.println("\n" + "=".repeat(50));
        System.out.println("✅ BONUS: Obsługa błędów");
        System.out.println("=".repeat(50));

        Samochod ferrari = FabrykaSamochodow.stworzSamochod("ferrari");
        System.out.println("Ferrari: " + (ferrari == null ? "null (OK!)" : "utworzono (ŹLE!)"));

        // ========== PODSUMOWANIE ==========
        System.out.println("\n" + "=".repeat(50));
        System.out.println("✅ ZALETY WZORCA FABRYKA:");
        System.out.println("=".repeat(50));

        System.out.println("\n1. JEDNA METODA tworzy wszystkie samochody");
        System.out.println("   FabrykaSamochodow.stworzSamochod(marka)");

        System.out.println("\n2. Zwraca INTERFEJS, nie konkretną klasę");
        System.out.println("   Typ: Samochod (nie BMW, Jaguar, etc.)");

        System.out.println("\n3. If-else TYLKO w jednym miejscu");
        System.out.println("   W metodzie stworzSamochod() - nigdzie indziej!");

        System.out.println("\n4. Łatwo dodać nową markę");
        System.out.println("   - Dodaj klasę (np. Ferrari)");
        System.out.println("   - Dodaj case w fabryce");
        System.out.println("   - GOTOWE!");

        System.out.println("\n5. Działa z EGZOTYCZNYMI autami!");
        System.out.println("   Koenigsegg z 3 funkcjami - bez problemu!");

        System.out.println("\n6. Case insensitive + trim");
        System.out.println("   \"bmw\", \"BMW\", \"  Bmw  \" - wszystko działa!");

        System.out.println("\n" + "=".repeat(50));
        System.out.println("🎓 WZORZEC FACTORY METHOD - NAUCZONY!");
        System.out.println("=".repeat(50));
    }
}
