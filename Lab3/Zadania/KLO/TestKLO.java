/**
 * Testy dla zadania KLO
 * Automatyczne testy sprawdzające poprawność rozwiązania
 */
public class TestKLO {

    // Klasa pomocnicza do testów
    static class Test {
        int n;
        int[] a, b, c;
        int expectedResult;
        String description;

        Test(int n, int[] a, int[] b, int[] c, int expected, String desc) {
            this.n = n;
            this.a = a;
            this.b = b;
            this.c = c;
            this.expectedResult = expected;
            this.description = desc;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== TESTY DLA ZADANIA KLO ===\n");

        // Test 1: Przykład z treści zadania
        Test test1 = new Test(
            3,
            new int[]{1, 2, 3},
            new int[]{2, 3, 4},
            new int[]{3, 4, 5},
            12,
            "Przykład 1 z treści - wszystkie klocki w kolejności"
        );

        // Test 2: Dwa klocki
        Test test2 = new Test(
            2,
            new int[]{4, 1},
            new int[]{6, 2},
            new int[]{7, 3},
            10,
            "Dwa klocki - większy na dole"
        );

        // Test 3: Pojedynczy klocek
        Test test3 = new Test(
            1,
            new int[]{5},
            new int[]{5},
            new int[]{5},
            5,
            "Jeden klocek - maksymalna wysokość = 5"
        );

        // Test 4: Klocki o tych samych wymiarach podstawy
        Test test4 = new Test(
            3,
            new int[]{1, 1, 1},
            new int[]{1, 1, 1},
            new int[]{1, 2, 3},
            3,
            "Klocki o tej samej podstawie - tylko jeden może być użyty"
        );

        // Test 5: Klocki niemontoniczne
        Test test5 = new Test(
            4,
            new int[]{4, 1, 4, 10},
            new int[]{6, 2, 5, 12},
            new int[]{7, 3, 6, 32},
            48,
            "Przykład 2 z treści - klocki w różnej kolejności"
        );

        // Test 6: Wszystkie klocki mają te same wymiary
        Test test6 = new Test(
            3,
            new int[]{2, 2, 2},
            new int[]{2, 2, 2},
            new int[]{2, 2, 2},
            2,
            "Wszystkie identyczne - tylko jeden może być użyty"
        );

        // Uruchom wszystkie testy
        Test[] tests = {test1, test2, test3, test4, test5, test6};
        int passed = 0;
        int failed = 0;

        for (int i = 0; i < tests.length; i++) {
            Test t = tests[i];
            System.out.println("Test " + (i + 1) + ": " + t.description);

            int result = KLO.maxTowerHeight(t.n, t.a, t.b, t.c);

            if (result == t.expectedResult) {
                System.out.println("✓ PASSED - Otrzymano: " + result);
                passed++;
            } else {
                System.out.println("✗ FAILED - Oczekiwano: " + t.expectedResult +
                                 ", Otrzymano: " + result);
                failed++;
            }
            System.out.println();
        }

        // Podsumowanie
        System.out.println("=== PODSUMOWANIE ===");
        System.out.println("Testy zaliczone: " + passed + "/" + tests.length);
        System.out.println("Testy niezaliczone: " + failed + "/" + tests.length);

        if (failed == 0) {
            System.out.println("\n🎉 Wszystkie testy zaliczone!");
        }
    }
}
