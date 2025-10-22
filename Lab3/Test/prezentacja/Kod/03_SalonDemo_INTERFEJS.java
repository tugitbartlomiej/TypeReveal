/**
 * SALON BAJTAZARA - KROK 1: INTERFEJS
 *
 * Problem z poprzedniej wersji: Każdy samochód to INNY TYP
 * Rozwiązanie: INTERFEJS - wspólny kontrakt dla wszystkich
 */

// ========== KROK 1: INTERFEJS SAMOCHOD ==========

interface Samochod {
    // Metody WSPÓLNE dla wszystkich samochodów
    String getMarka();
    int getCena();
    void jedz();

    // KLUCZOWE: Metoda do pokazania specjalnych funkcji!
    // Każdy samochód pokaże SWOJE unikalne funkcje
    void pokazSpecjalneFunkcje();
}

// ========== KLASY IMPLEMENTUJĄCE INTERFEJS ==========

class BMW implements Samochod {
    @Override
    public String getMarka() {
        return "BMW M5";
    }

    @Override
    public int getCena() {
        return 300000;
    }

    @Override
    public void jedz() {
        System.out.println("BMW jedzie!");
    }

    @Override
    public void pokazSpecjalneFunkcje() {
        // BMW pokazuje SWOJĄ specjalną funkcję
        aktywujTrybM();
    }

    // Prywatna metoda specjalna BMW
    private void aktywujTrybM() {
        System.out.println("TRYB M AKTYWNY! +100 KM!");
    }
}

class Jaguar implements Samochod {
    @Override
    public String getMarka() {
        return "Jaguar F-Type";
    }

    @Override
    public int getCena() {
        return 280000;
    }

    @Override
    public void jedz() {
        System.out.println("Jaguar jedzie!");
    }

    @Override
    public void pokazSpecjalneFunkcje() {
        // Jaguar pokazuje SWOJĄ specjalną funkcję
        wydajRyk();
    }

    private void wydajRyk() {
        System.out.println("RRRROOOAAARRR! (V8 supercharged)");
    }
}

class Bentley implements Samochod {
    @Override
    public String getMarka() {
        return "Bentley Continental GT";
    }

    @Override
    public int getCena() {
        return 850000;
    }

    @Override
    public void jedz() {
        System.out.println("Bentley jedzie luksusowo!");
    }

    @Override
    public void pokazSpecjalneFunkcje() {
        wlaczMasazFoteli();
    }

    private void wlaczMasazFoteli() {
        System.out.println("Masaż foteli WŁĄCZONY - poziom relaksu: MAKSYMALNY");
    }
}

class Koenigsegg implements Samochod {
    @Override
    public String getMarka() {
        return "Koenigsegg Jesko";
    }

    @Override
    public int getCena() {
        return 12000000;
    }

    @Override
    public void jedz() {
        System.out.println("Koenigsegg jedzie!");
    }

    @Override
    public void pokazSpecjalneFunkcje() {
        // EGZOTYCZNY - pokazuje WSZYSTKIE 3 funkcje!
        aktywujTryb1600KM();
        wlaczSystemNitro();
        sprawdzPredkoscMaksymalna();
    }

    private void aktywujTryb1600KM() {
        System.out.println("TRYB 1600 KM AKTYWNY!!!");
    }

    private void wlaczSystemNitro() {
        System.out.println("NITRO WŁĄCZONE! BOOST!");
    }

    private void sprawdzPredkoscMaksymalna() {
        System.out.println("Prędkość maksymalna: 483 km/h!");
    }
}

// ========== PROGRAM GŁÓWNY ==========

public class SalonDemo_KROK1_interfejs {

    public static void main(String[] args) {
        System.out.println("╔═══════════════════════════════════════╗");
        System.out.println("║  KROK 1: INTERFEJS                 ║");
        System.out.println("╚═══════════════════════════════════════╝\n");

        // TERAZ WSZYSTKIE SAMOCHODY TO TEN SAM TYP: Samochod!
        Samochod bmw = new BMW();
        Samochod jaguar = new Jaguar();
        Samochod bentley = new Bentley();
        Samochod koenigsegg = new Koenigsegg();

        // Możemy je dodać do LISTY!
        Samochod[] salon = {bmw, jaguar, bentley, koenigsegg};

        // Możemy iterować po nich JEDNAKOWO!
        for (Samochod auto : salon) {
            System.out.println("=== " + auto.getMarka() + " ===");
            System.out.println("Cena: " + auto.getCena() + " bajtalarów");
            auto.jedz();
            auto.pokazSpecjalneFunkcje(); // ← KAŻDY pokaże SWOJE!
            System.out.println();
        }

        // Polimorfizm w akcji!
        System.out.println("=".repeat(50));
        System.out.println("ZALETY INTERFEJSU:");
        System.out.println("=".repeat(50));
        System.out.println("1. Wszystkie samochody jako JEDEN TYP: Samochod");
        System.out.println("2. Możemy zrobić List<Samochod> lub Samochod[]");
        System.out.println("3. Pętla działa dla WSZYSTKICH jednakowo");
        System.out.println("4. pokazSpecjalneFunkcje() - każdy robi SWOJE!");
        System.out.println("5. Koenigsegg pokazuje 3 funkcje - automatycznie!");

        System.out.println("\n ALE NADAL PROBLEM:");
        System.out.println("Jak TWORZYĆ samochody bez 'new BMW()', 'new Jaguar()'?");
        System.out.println("→ Następny krok: FABRYKA!");
    }
}
