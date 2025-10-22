/**
 * SALON BAJTAZARA - KOD STARTOWY
 *
 * Zadanie: Stwórz klasy dla 4 samochodów i pokaż ich specjalne funkcje
 *
 * UWAGA: To jest kod STARTOWY - pokazuje PROBLEM!
 * Pomyśl jak to można poprawić!
 */

// ========== KLASY SAMOCHODÓW ==========

class BMW {
    String marka = "BMW M5";
    int cena = 300000;

    void jedz() {
        System.out.println("🏎️ BMW jedzie!");
    }

    void aktywujTrybM() {
        System.out.println("⚡ TRYB M AKTYWNY! +100 KM!");
    }
}

class Jaguar {
    String marka = "Jaguar F-Type";
    int cena = 280000;

    void jedz() {
        System.out.println("🐆 Jaguar jedzie!");
    }

    void wydajRyk() {
        System.out.println("🔊 RRRROOOAAARRR! (V8 supercharged)");
    }
}

class Bentley {
    String marka = "Bentley Continental GT";
    int cena = 850000;

    void jedz() {
        System.out.println("👑 Bentley jedzie luksusowo!");
    }

    void wlaczMasazFoteli() {
        System.out.println("💺 Masaż foteli WŁĄCZONY - poziom relaksu: MAKSYMALNY");
    }
}

class Koenigsegg {
    String marka = "Koenigsegg Jesko";
    int cena = 12000000;

    void jedz() {
        System.out.println("⚡ Koenigsegg jedzie!");
    }

    // ⚠️ UWAGA - EGZOTYCZNY SAMOCHÓD!
    // Ma 3 SPECJALNE FUNKCJE których inne nie mają!

    void aktywujTryb1600KM() {
        System.out.println("🚀 TRYB 1600 KM AKTYWNY!!!");
    }

    void wlaczSystemNitro() {
        System.out.println("💨 NITRO WŁĄCZONE! BOOST!");
    }

    void sprawdzPredkoscMaksymalna() {
        System.out.println("📊 Prędkość maksymalna: 483 km/h (najszybszy samochód produkcyjny!)");
    }
}

// ========== PROGRAM GŁÓWNY ==========

public class SalonDemo_START {

    public static void main(String[] args) {
        System.out.println("╔═══════════════════════════════════════╗");
        System.out.println("║  🚗 SALON BAJTAZARA - DEMO SAMOCHODÓW    ║");
        System.out.println("╚═══════════════════════════════════════╝\n");

        // ========== DEMONSTRACJA BMW ==========
        System.out.println("=== BMW M5 ===");
        BMW bmw = new BMW();
        System.out.println("Cena: " + bmw.cena + " bajtalarów");
        bmw.jedz();
        bmw.aktywujTrybM();
        System.out.println();

        // ========== DEMONSTRACJA JAGUAR ==========
        System.out.println("=== Jaguar F-Type ===");
        Jaguar jaguar = new Jaguar();
        System.out.println("Cena: " + jaguar.cena + " bajtalarów");
        jaguar.jedz();
        jaguar.wydajRyk();
        System.out.println();

        // ========== DEMONSTRACJA BENTLEY ==========
        System.out.println("=== Bentley Continental GT ===");
        Bentley bentley = new Bentley();
        System.out.println("Cena: " + bentley.cena + " bajtalarów");
        bentley.jedz();
        bentley.wlaczMasazFoteli();
        System.out.println();

        // ========== DEMONSTRACJA KOENIGSEGG (EGZOTYCZNY!) ==========
        System.out.println("=== Koenigsegg Jesko ===");
        Koenigsegg koenigsegg = new Koenigsegg();
        System.out.println("Cena: " + koenigsegg.cena + " bajtalarów");
        koenigsegg.jedz();
        koenigsegg.aktywujTryb1600KM();      // ← Specjalna funkcja 1
        koenigsegg.wlaczSystemNitro();       // ← Specjalna funkcja 2
        koenigsegg.sprawdzPredkoscMaksymalna(); // ← Specjalna funkcja 3
        System.out.println();

        // ========== PROBLEM! ==========
        System.out.println("=".repeat(50));
        System.out.println("❌ PROBLEM:");
        System.out.println("=".repeat(50));
        System.out.println("1. Każdy samochód to INNY TYP (BMW, Jaguar, Bentley, Koenigsegg)");
        System.out.println("2. Każdy ma INNE METODY (aktywujTrybM, wydajRyk, wlaczMasazFoteli...)");
        System.out.println("3. Nie możemy zrobić List<???> - bo różne typy!");
        System.out.println("4. Koenigsegg ma 3 specjalne metody - jak to obsłużyć?");
        System.out.println();
        System.out.println("❓ PYTANIE: Jak to uprościć?");
    }
}
