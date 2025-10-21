import java.util.*;

/**
 * Testy dla zadania Liczby Google'a
 * Automatyczne testy sprawdzające poprawność rozwiązania
 */
public class TestLiczbyGoogla {

    // Klasa pomocnicza do testów pojedynczych liczb
    static class TestSingle {
        int number;
        boolean expected;
        String description;

        TestSingle(int num, boolean exp, String desc) {
            this.number = num;
            this.expected = exp;
            this.description = desc;
        }
    }

    // Klasa pomocnicza do testów zliczania
    static class TestCount {
        int n;
        int expectedCount;
        String description;

        TestCount(int n, int count, String desc) {
            this.n = n;
            this.expectedCount = count;
            this.description = desc;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== TESTY DLA ZADANIA LICZBY GOOGLE'A ===\n");

        // ===== TEST 1: Sprawdzanie pojedynczych liczb =====
        System.out.println("--- Test 1: Sprawdzanie pojedynczych liczb ---\n");

        TestSingle[] singleTests = {
            new TestSingle(0, true, "Cyfra 0"),
            new TestSingle(1, true, "Cyfra 1"),
            new TestSingle(8, true, "Cyfra 8"),
            new TestSingle(6, false, "Cyfra 6 sama (6→9)"),
            new TestSingle(9, false, "Cyfra 9 sama (9→6)"),
            new TestSingle(2, false, "Cyfra 2 (niedozwolona)"),
            new TestSingle(11, true, "11 (symetryczna)"),
            new TestSingle(69, false, "69 → 96"),
            new TestSingle(88, true, "88 (symetryczna)"),
            new TestSingle(96, false, "96 → 69"),
            new TestSingle(101, true, "101 (symetryczna)"),
            new TestSingle(111, true, "111 (symetryczna)"),
            new TestSingle(181, true, "181 (1-8-1 → 1-8-1)"),
            new TestSingle(609, true, "609 (6-0-9 → 6-0-9)"),
            new TestSingle(619, true, "619 (6-1-9 → 6-1-9)"),
            new TestSingle(689, true, "689 (6-8-9 → 6-8-9)"),
            new TestSingle(906, false, "906 → 609"),
            new TestSingle(1001, true, "1001 (symetryczna)"),
            new TestSingle(1234, false, "1234 (zawiera 2, 3, 4)")
        };

        int passedSingle = 0;
        int failedSingle = 0;

        for (TestSingle t : singleTests) {
            boolean result = LiczbyGoogla.isGoogleNumber(t.number);
            boolean passed = (result == t.expected);

            if (passed) {
                System.out.println("✓ " + t.description + " - " + t.number +
                                 " → " + (result ? "TAK" : "NIE"));
                passedSingle++;
            } else {
                System.out.println("✗ " + t.description + " - " + t.number +
                                 " → Oczekiwano: " + (t.expected ? "TAK" : "NIE") +
                                 ", Otrzymano: " + (result ? "TAK" : "NIE"));
                failedSingle++;
            }
        }

        System.out.println("\nWynik testów pojedynczych: " +
                          passedSingle + "/" + singleTests.length + " zaliczonych");

        // ===== TEST 2: Zliczanie liczb Google'a =====
        System.out.println("\n--- Test 2: Zliczanie liczb Google'a ---\n");

        TestCount[] countTests = {
            new TestCount(10, 3, "Przedział [0, 10]"),
            new TestCount(100, 7, "Przedział [0, 100]"),
            new TestCount(200, 9, "Przedział [0, 200]"),
            new TestCount(1000, 13, "Przedział [0, 1000]")
        };

        int passedCount = 0;
        int failedCount = 0;

        for (TestCount t : countTests) {
            int result = LiczbyGoogla.countGoogleNumbers(t.n);
            boolean passed = (result == t.expectedCount);

            if (passed) {
                System.out.println("✓ " + t.description + " → " + result + " liczb");
                passedCount++;
            } else {
                System.out.println("✗ " + t.description +
                                 " → Oczekiwano: " + t.expectedCount +
                                 ", Otrzymano: " + result);
                failedCount++;
            }
        }

        System.out.println("\nWynik testów zliczania: " +
                          passedCount + "/" + countTests.length + " zaliczonych");

        // ===== TEST 3: Generowanie liczb =====
        System.out.println("\n--- Test 3: Generowanie liczb Google'a ---\n");

        // Test dla małego przedziału
        ArrayList<Integer> result100 = LiczbyGoogla.generateGoogleNumbers(100);
        Integer[] expected100 = {0, 1, 8, 11, 69, 88, 96};
        boolean test3Passed = Arrays.equals(result100.toArray(), expected100);

        if (test3Passed) {
            System.out.println("✓ Generowanie dla n=100: " + result100);
        } else {
            System.out.println("✗ Generowanie dla n=100");
            System.out.println("  Oczekiwano: " + Arrays.toString(expected100));
            System.out.println("  Otrzymano:  " + result100);
        }

        // ===== TEST 4: Największa liczba Google'a =====
        System.out.println("\n--- Test 4: Największa liczba Google'a ---\n");

        int[][] largestTests = {
            {50, 11},
            {100, 96},
            {500, 181},
            {1000, 689}
        };

        int passedLargest = 0;

        for (int[] test : largestTests) {
            int n = test[0];
            int expected = test[1];
            int result = LiczbyGoogla.largestGoogleNumber(n);

            if (result == expected) {
                System.out.println("✓ Największa <= " + n + " → " + result);
                passedLargest++;
            } else {
                System.out.println("✗ Największa <= " + n +
                                 " → Oczekiwano: " + expected +
                                 ", Otrzymano: " + result);
            }
        }

        // ===== PODSUMOWANIE =====
        System.out.println("\n" + "=".repeat(50));
        System.out.println("=== PODSUMOWANIE WSZYSTKICH TESTÓW ===");
        System.out.println("=".repeat(50));

        int totalTests = singleTests.length + countTests.length + 1 + largestTests.length;
        int totalPassed = passedSingle + passedCount + (test3Passed ? 1 : 0) + passedLargest;
        int totalFailed = totalTests - totalPassed;

        System.out.println("Testy zaliczone:    " + totalPassed + "/" + totalTests);
        System.out.println("Testy niezaliczone: " + totalFailed + "/" + totalTests);

        if (totalFailed == 0) {
            System.out.println("\n🎉 WSZYSTKIE TESTY ZALICZONE! 🎉");
        } else {
            System.out.println("\n⚠️ Niektóre testy nie przeszły. Sprawdź implementację.");
        }
    }
}
