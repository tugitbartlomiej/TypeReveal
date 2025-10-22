/**
 * SALON BAJTAZARA - KROK 3: FABRYKA ABSTRAKCYJNA (Abstract Factory)
 *
 * Problem: Fabryka tworzy JEDEN samochód na raz
 * Co jeśli chcemy tworzyć RODZINY produktów?
 * Np. Bentley Sedan + Bentley SUV razem?
 *
 * Rozwiązanie: ABSTRACT FACTORY - tworzy rodziny powiązanych obiektów!
 */

// ========== INTERFEJSY DLA RÓŻNYCH TYPÓW AUT ==========

interface Sedan {
    String getModel();
    void jedz();
    void pokazLuksusoweWnetrze();
}

interface SUV {
    String getModel();
    void jedz();
    void pokazTerenoweMozliwosci();
}

// ========== RODZINA BMW ==========

class BMWSedan implements Sedan {
    @Override
    public String getModel() {
        return "BMW Seria 7";
    }

    @Override
    public void jedz() {
        System.out.println("BMW Sedan jedzie!");
    }

    @Override
    public void pokazLuksusoweWnetrze() {
        System.out.println("Skórzane fotele z masażem + ambient lighting");
    }
}

class BMWSUV implements SUV {
    @Override
    public String getModel() {
        return "BMW X7";
    }

    @Override
    public void jedz() {
        System.out.println("BMW SUV jedzie!");
    }

    @Override
    public void pokazTerenoweMozliwosci() {
        System.out.println("Tryb OFF-ROAD + xDrive (napęd 4x4)");
    }
}

// ========== RODZINA BENTLEY ==========

class BentleySedan implements Sedan {
    @Override
    public String getModel() {
        return "Bentley Flying Spur";
    }

    @Override
    public void jedz() {
        System.out.println("Bentley Sedan jedzie luksusowo!");
    }

    @Override
    public void pokazLuksusoweWnetrze() {
        System.out.println("Drewniane wykończenia + diamentowe przeszycia");
    }
}

class BentleySUV implements SUV {
    @Override
    public String getModel() {
        return "Bentley Bentayga";
    }

    @Override
    public void jedz() {
        System.out.println("Bentley SUV jedzie majestatycznie!");
    }

    @Override
    public void pokazTerenoweMozliwosci() {
        System.out.println("Luksusowy terenowy + zawieszenie pneumatyczne");
    }
}

// ========== RODZINA JAGUAR ==========

class JaguarSedan implements Sedan {
    @Override
    public String getModel() {
        return "Jaguar XJ";
    }

    @Override
    public void jedz() {
        System.out.println("Jaguar Sedan jedzie!");
    }

    @Override
    public void pokazLuksusoweWnetrze() {
        System.out.println("System audio Meridian + sportowe fotele");
    }
}

class JaguarSUV implements SUV {
    @Override
    public String getModel() {
        return "Jaguar F-PACE";
    }

    @Override
    public void jedz() {
        System.out.println("Jaguar SUV jedzie sportowo!");
    }

    @Override
    public void pokazTerenoweMozliwosci() {
        System.out.println("Terrain Response + AWD");
    }
}

// ==========  ABSTRACT FACTORY - INTERFEJS ==========

/**
 *  TO JEST WZORZEC ABSTRACT FACTORY!
 *
 * Każda fabryka tworzy RODZINĘ produktów (Sedan + SUV)
 * Wszystkie fabryki implementują ten sam interfejs
 */
interface FabrykaSamochodowAbstract {
    Sedan stworzSedan();
    SUV stworzSUV();
}

// ========== KONKRETNE FABRYKI ==========

class FabrykaBMW implements FabrykaSamochodowAbstract {
    @Override
    public Sedan stworzSedan() {
        return new BMWSedan();
    }

    @Override
    public SUV stworzSUV() {
        return new BMWSUV();
    }
}

class FabrykaBentley implements FabrykaSamochodowAbstract {
    @Override
    public Sedan stworzSedan() {
        return new BentleySedan();
    }

    @Override
    public SUV stworzSUV() {
        return new BentleySUV();
    }
}

class FabrykaJaguar implements FabrykaSamochodowAbstract {
    @Override
    public Sedan stworzSedan() {
        return new JaguarSedan();
    }

    @Override
    public SUV stworzSUV() {
        return new JaguarSUV();
    }
}

// ========== PRODUCER FABRYK (Factory Method dla fabryk!) ==========

class ProducentFabryk {
    /**
     *  FACTORY METHOD - tworzy FABRYKI!
     * Zwraca interfejs FabrykaSamochodowAbstract
     */
    public static FabrykaSamochodowAbstract getFabryka(String marka) {
        if (marka == null) {
            return null;
        }

        String markaNorm = marka.toLowerCase().trim();

        switch (markaNorm) {
            case "bmw":
                return new FabrykaBMW();

            case "bentley":
                return new FabrykaBentley();

            case "jaguar":
                return new FabrykaJaguar();

            default:
                System.out.println("Nieznana marka: " + marka);
                return null;
        }
    }
}

// ========== PROGRAM GŁÓWNY ==========

public class SalonDemo_KROK3_abstrakcyjna {

    public static void main(String[] args) {
        System.out.println("╔═══════════════════════════════════════════════════╗");
        System.out.println("║  KROK 3: FABRYKA ABSTRAKCYJNA                  ║");
        System.out.println("╚═══════════════════════════════════════════════════╝\n");

        // PRZED (Factory Method):
        System.out.println("PRZED (Factory Method - jeden samochód):");
        System.out.println("Samochod bmw = FabrykaSamochodow.stworzSamochod(\"bmw\");");
        System.out.println("Samochod bentley = FabrykaSamochodow.stworzSamochod(\"bentley\");");
        System.out.println("// Ale co jeśli chcę BMW Sedan + BMW SUV razem?\n");

        // PO (Abstract Factory):
        System.out.println("PO (Abstract Factory - rodzina produktów):");
        System.out.println("FabrykaSamochodowAbstract fabrykaBMW = ProducentFabryk.getFabryka(\"bmw\");");
        System.out.println("Sedan sedan = fabrykaBMW.stworzSedan();");
        System.out.println("SUV suv = fabrykaBMW.stworzSUV();");
        System.out.println("// Jedna fabryka tworzy RODZINĘ produktów!\n");

        System.out.println("=".repeat(60));

        // ========== DEMONSTRACJA ==========

        String[] marki = {"bmw", "bentley", "jaguar"};

        for (String marka : marki) {
            System.out.println("\n" + "=".repeat(60));
            System.out.println("=== " + marka.toUpperCase() + " - RODZINA PRODUKTÓW ===");
            System.out.println("=".repeat(60));

            // Pobieramy fabrykę dla marki
            FabrykaSamochodowAbstract fabryka = ProducentFabryk.getFabryka(marka);

            if (fabryka != null) {
                // Fabryka tworzy SEDAN
                System.out.println("\n SEDAN:");
                Sedan sedan = fabryka.stworzSedan();
                System.out.println("Model: " + sedan.getModel());
                sedan.jedz();
                sedan.pokazLuksusoweWnetrze();

                // Fabryka tworzy SUV
                System.out.println("\n SUV:");
                SUV suv = fabryka.stworzSUV();
                System.out.println("Model: " + suv.getModel());
                suv.jedz();
                suv.pokazTerenoweMozliwosci();
            }
        }

        // ========== KLUCZOWE PORÓWNANIE ==========

        System.out.println("\n\n" + "=".repeat(60));
        System.out.println("FACTORY METHOD vs ABSTRACT FACTORY");
        System.out.println("=".repeat(60));

        System.out.println("\n╔════════════════════════════════════════════════════╗");
        System.out.println("║ FACTORY METHOD (Krok 2)                            ║");
        System.out.println("╚════════════════════════════════════════════════════╝");
        System.out.println("• Tworzy JEDEN PRODUKT na raz");
        System.out.println("• Metoda: stworzSamochod(\"bmw\")");
        System.out.println("• Zwraca: Samochod");
        System.out.println("• Przykład:");
        System.out.println("   Samochod auto = FabrykaSamochodow.stworzSamochod(\"bmw\");");

        System.out.println("\n╔════════════════════════════════════════════════════╗");
        System.out.println("║ ABSTRACT FACTORY (Krok 3)                          ║");
        System.out.println("╚════════════════════════════════════════════════════╝");
        System.out.println("• Tworzy RODZINĘ PRODUKTÓW");
        System.out.println("• Metody: stworzSedan(), stworzSUV()");
        System.out.println("• Zwraca: Sedan, SUV (różne interfejsy!)");
        System.out.println("• Przykład:");
        System.out.println("   FabrykaSamochodowAbstract fabryka = ProducentFabryk.getFabryka(\"bmw\");");
        System.out.println("   Sedan sedan = fabryka.stworzSedan();");
        System.out.println("   SUV suv = fabryka.stworzSUV();");

        // ========== PODSUMOWANIE ZALET ==========

        System.out.println("\n\n" + "=".repeat(60));
        System.out.println("ZALETY ABSTRACT FACTORY:");
        System.out.println("=".repeat(60));

        System.out.println("\n1. RODZINA PRODUKTÓW");
        System.out.println("  Jedna fabryka tworzy WIELE typów obiektów");
        System.out.println("  BMW: Sedan + SUV (oba BMW!)");

        System.out.println("\n2. SPÓJNOŚĆ");
        System.out.println("  Gwarantuje, że produkty pasują do siebie");
        System.out.println("  Nie możesz przypadkowo stworzyć BMW Sedan + Bentley SUV");

        System.out.println("\n3. ŁATWE PRZEŁĄCZANIE");
        System.out.println("  Zmiana fabryki = zmiana CAŁEJ RODZINY");
        System.out.println("  getFabryka(\"bmw\") → getFabryka(\"bentley\")");
        System.out.println("  Cały kod działa bez zmian!");

        System.out.println("\n4. OPEN/CLOSED PRINCIPLE");
        System.out.println("  Dodanie nowej marki:");
        System.out.println("  - Dodaj klasę FerrariSedan implements Sedan");
        System.out.println("  - Dodaj klasę FerrariSUV implements SUV");
        System.out.println("  - Dodaj klasę FabrykaFerrari implements FabrykaSamochodowAbstract");
        System.out.println("  - Dodaj case w ProducentFabryk");
        System.out.println("  - Istniejący kod bez zmian!");

        System.out.println("\n5. ENKAPSULACJA TWORZENIA");
        System.out.println("  Klient NIE WIDZI konkretnych klas (BMWSedan, BMWSUV...)");
        System.out.println("  Klient operuje na interfejsach (Sedan, SUV)");

        // ========== PRZYKŁAD: SALON Z RODZINAMI AUT ==========

        System.out.println("\n\n" + "=".repeat(60));
        System.out.println("PRZYKŁAD: Salon sprzedaje pary (Sedan + SUV)");
        System.out.println("=".repeat(60));

        String markaPary = "bentley";
        System.out.println("\n📦 Klient kupuje parę: " + markaPary.toUpperCase());

        FabrykaSamochodowAbstract fabrykaParowa = ProducentFabryk.getFabryka(markaPary);

        if (fabrykaParowa != null) {
            Sedan s = fabrykaParowa.stworzSedan();
            SUV u = fabrykaParowa.stworzSUV();

            System.out.println("\n Otrzymuje:");
            System.out.println("  • " + s.getModel() + " (Sedan)");
            System.out.println("  • " + u.getModel() + " (SUV)");
            System.out.println("\n Gwarantowana spójność - oba to " + markaPary.toUpperCase() + "!");
        }

        System.out.println("\n" + "=".repeat(60));
        System.out.println("WZORZEC ABSTRACT FACTORY - NAUCZONY!");
        System.out.println("=".repeat(60));

        // ========== KIEDY UŻYWAĆ? ==========

        System.out.println("\n\n" + "=".repeat(60));
        System.out.println("KIEDY UŻYWAĆ KTÓREGO WZORCA?");
        System.out.println("=".repeat(60));

        System.out.println("\n FACTORY METHOD:");
        System.out.println("  Gdy tworzysz JEDEN TYP obiektu");
        System.out.println("  Przykład: stworzSamochod(\"bmw\")");

        System.out.println("\n ABSTRACT FACTORY:");
        System.out.println("  Gdy tworzysz RODZINY powiązanych obiektów");
        System.out.println("  Przykład: fabryka.stworzSedan() + fabryka.stworzSUV()");
        System.out.println("  Obierty muszą pasować do siebie!");

        System.out.println("\n W PRAKTYCE:");
        System.out.println("  • GUI: WindowsFactory (Button, Checkbox, ScrollBar)");
        System.out.println("  • Bazy danych: DatabaseFactory (Connection, Statement, ResultSet)");
        System.out.println("  • Gry: EnvironmentFactory (Terrain, Weather, Lighting)");
    }
}
