/**
 * Testy dla wzorców Factory
 */
public class TestFabryka {

    private static int passed = 0;
    private static int failed = 0;

    public static void main(String[] args) {
        System.out.println("=== TESTY WZORCÓW FABRYKA ===\n");

        testFactoryMethod();
        testAbstractFactory();

        // Podsumowanie
        System.out.println("\n" + "=".repeat(40));
        System.out.println("Zaliczone: " + passed + "/" + (passed + failed));
        System.out.println("Niezaliczone: " + failed + "/" + (passed + failed));

        if (failed == 0) {
            System.out.println("\n✓ WSZYSTKIE TESTY ZALICZONE!");
        }
    }

    // ========== TESTY FACTORY METHOD ==========

    private static void testFactoryMethod() {
        System.out.println("--- FACTORY METHOD ---\n");

        // Test tworzenia aut
        Samochod bmw = FabrykaSamochodow.stworzSamochod("bmw");
        test("Tworzenie BMW", bmw != null && bmw instanceof BMW);

        Samochod jaguar = FabrykaSamochodow.stworzSamochod("jaguar");
        test("Tworzenie Jaguar", jaguar != null && jaguar instanceof Jaguar);

        Samochod bentley = FabrykaSamochodow.stworzSamochod("bentley");
        test("Tworzenie Bentley", bentley != null && bentley instanceof Bentley);

        Samochod koenigsegg = FabrykaSamochodow.stworzSamochod("koenigsegg");
        test("Tworzenie Koenigsegg", koenigsegg != null && koenigsegg instanceof Koenigsegg);

        // Test case insensitive
        test("Case insensitive", FabrykaSamochodow.stworzSamochod("BMW") != null);

        // Test null
        test("Nieznana marka = null", FabrykaSamochodow.stworzSamochod("fiat") == null);

        // Test polimorfizmu
        test("Polimorfizm - interfejs", bmw instanceof Samochod);

        System.out.println();
    }

    // ========== TESTY ABSTRACT FACTORY ==========

    private static void testAbstractFactory() {
        System.out.println("--- ABSTRACT FACTORY ---\n");

        // Test LuxuryFactory
        AutoFactory luxury = new LuxuryFactory();
        Samochod luxSedan = luxury.createSedan();
        Samochod luxSUV = luxury.createSUV();

        test("LuxuryFactory tworzy sedan", luxSedan instanceof BentleySedan);
        test("LuxuryFactory tworzy SUV", luxSUV instanceof BentleySUV);

        // Test SportFactory
        AutoFactory sport = new SportFactory();
        Samochod sportSedan = sport.createSedan();
        Samochod sportSUV = sport.createSUV();

        test("SportFactory tworzy coupe", sportSedan instanceof KoenigseggCoupe);
        test("SportFactory tworzy roadster", sportSUV instanceof KoenigseggRoadster);

        // Test spójności rodziny
        boolean luxurySpojne =
            luxSedan.getModel().contains("Bentley") &&
            luxSUV.getModel().contains("Bentley");
        test("Spójność rodziny Luxury", luxurySpojne);

        boolean sportSpojne =
            sportSedan.getModel().contains("Koenigsegg") &&
            sportSUV.getModel().contains("Koenigsegg");
        test("Spójność rodziny Sport", sportSpojne);
    }

    // ========== POMOCNICZE ==========

    private static void test(String name, boolean condition) {
        if (condition) {
            System.out.println("✓ " + name);
            passed++;
        } else {
            System.out.println("✗ " + name);
            failed++;
        }
    }
}
