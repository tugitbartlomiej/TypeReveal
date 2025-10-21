# Salon Bajtazara - Specjalne Funkcje Samochodów

**Czas:** 30 minut
**Poziom:** Podstawowy

---

## Opis problemu

Bajtek prowadzi salon samochodowy w Bajtocji. Każdy samochód ma swoją **unikalną specjalną funkcję**:

### 1. BMW M5 (300 000 bajtalarów)
- Podstawowe: marka, cena, jedź
- **SPECJALNA FUNKCJA:** `aktywujTrybM()` - włącza tryb sportowy M

### 2. Jaguar F-Type (280 000 bajtalarów)
- Podstawowe: marka, cena, jedź
- **SPECJALNA FUNKCJA:** `wydajRyk()` - charakterystyczny ryk silnika V8

### 3. Bentley Continental GT (850 000 bajtalarów)
- Podstawowe: marka, cena, jedź
- **SPECJALNA FUNKCJA:** `wlaczMasazFoteli()` - luksusowy masaż w fotelach

### 4. Koenigsegg Jesko (12 000 000 bajtalarów) ⚡ **MEGA EGZOTYCZNY!**
- Podstawowe: marka, cena, jedź
- **SPECJALNA FUNKCJA 1:** `aktywujTryb1600KM()` - pełna moc 1600 KM!
- **SPECJALNA FUNKCJA 2:** `wlaczSystemNitro()` - dodatkowe przyspieszenie
- **SPECJALNA FUNKCJA 3:** `sprawdzPredkoscMaksymalna()` - wyświetla prędkość maksymalną (483 km/h!)

---

## Zadanie

Napisz program, który:

1. **Tworzy obiekty** samochodów (BMW, Jaguar, Bentley, Koenigsegg)
2. **Wyświetla podstawowe informacje** (marka, cena)
3. **Testuje jazdę** (metoda `jedz()`)
4. **Pokazuje specjalne funkcje** każdego samochodu

---

## Wymagania

### Część 1: Podstawowa (bez wzorców)

Napisz program z klasami:
```java
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

// ... itd.
```

**Problem do przemyślenia:**
- Jak wywołać specjalne funkcje dla różnych aut?
- Co jeśli nie wiesz z góry jaki typ samochodu masz?
- Jak uniknąć duplikacji kodu?

---

## Oczekiwane wyjście

```
╔═══════════════════════════════════════╗
║  🚗 SALON BAJTAZARA - DEMO SAMOCHODÓW    ║
╚═══════════════════════════════════════╝

=== BMW M5 ===
Cena: 300000 bajtalarów
🏎️ BMW jedzie!
⚡ TRYB M AKTYWNY! +100 KM!

=== Jaguar F-Type ===
Cena: 280000 bajtalarów
🐆 Jaguar jedzie!
🔊 RRRROOOAAARRR! (V8 supercharged)

=== Bentley Continental GT ===
Cena: 850000 bajtalarów
👑 Bentley jedzie luksusowo!
💺 Masaż foteli WŁĄCZONY - poziom relaksu: MAKSYMALNY

=== Koenigsegg Jesko ===
Cena: 12000000 bajtalarów
⚡ Koenigsegg jedzie!
🚀 TRYB 1600 KM AKTYWNY!!!
💨 NITRO WŁĄCZONE! BOOST!
📊 Prędkość maksymalna: 483 km/h (najszybszy samochód produkcyjny!)
```

---

## Część 2: Przemyślenia (do dyskusji)

### Problem 1: If-else hell

Jak byś to napisał z if-else?

```java
String typAuta = "bmw"; // Skąd to wiesz?

if (typAuta.equals("bmw")) {
    BMW auto = new BMW();
    auto.jedz();
    auto.aktywujTrybM(); // ← muszę WIEDZIEĆ że to BMW!
} else if (typAuta.equals("jaguar")) {
    Jaguar auto = new Jaguar();
    auto.jedz();
    auto.wydajRyk(); // ← muszę WIEDZIEĆ że to Jaguar!
} else if (typAuta.equals("bentley")) {
    Bentley auto = new Bentley();
    auto.jedz();
    auto.wlaczMasazFoteli(); // ← muszę WIEDZIEĆ że to Bentley!
} else if (typAuta.equals("koenigsegg")) {
    Koenigsegg auto = new Koenigsegg();
    auto.jedz();
    auto.aktywujTryb1600KM(); // ← 3 RÓŻNE metody!
    auto.wlaczSystemNitro();
    auto.sprawdzPredkoscMaksymalna();
}
```

**Co jest złego?**
- Musisz ZNAĆ typ samochodu
- Każdy samochód wymaga INNEGO kodu
- Nie możesz zrobić `List<???>` - bo każdy ma inny typ!
- Duplikacja kodu wszędzie

### Problem 2: Dodanie nowego samochodu

Bajtek kupił do salonu **Bugatti Chiron** (nowy hipersamochód).

**Pytanie:** Ile miejsc musisz zmienić w kodzie?

Z if-else: **WSZĘDZIE** gdzie tworzysz auta!

### Problem 3: Zmiana funkcjonalności

Jaguar dostał nową funkcję: `wlaczTrybWyścigowy()`.

**Pytanie:** Co musisz zmienić?

Z if-else: Wszystkie miejsca gdzie obsługujesz Jaguara!

---

## Wskazówka

Pomyśl o tym:
1. Co jest **wspólne** dla wszystkich samochodów?
2. Co jest **różne** (unikalne)?
3. Jak to **uogólnić**?

*Czy istnieje lepszy sposób niż if-else?*

---

## Format rozwiązania

Napisz program w pliku `SalonDemo.java`:

```java
public class SalonDemo {
    public static void main(String[] args) {
        // Twój kod tutaj
        // Stwórz 4 samochody
        // Pokaż ich funkcje
    }
}
```

Kompilacja:
```bash
javac SalonDemo.java
java SalonDemo
```

---

## Przykładowy kod startowy (Część 1)

```java
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

class Koenigsegg {
    String marka = "Koenigsegg Jesko";
    int cena = 12000000;

    void jedz() {
        System.out.println("⚡ Koenigsegg jedzie!");
    }

    // ⚠️ UWAGA - 3 SPECJALNE METODY!
    void aktywujTryb1600KM() {
        System.out.println("🚀 TRYB 1600 KM AKTYWNY!!!");
    }

    void wlaczSystemNitro() {
        System.out.println("💨 NITRO WŁĄCZONE! BOOST!");
    }

    void sprawdzPredkoscMaksymalna() {
        System.out.println("📊 Prędkość maksymalna: 483 km/h!");
    }
}

public class SalonDemo {
    public static void main(String[] args) {
        BMW bmw = new BMW();
        bmw.jedz();
        bmw.aktywujTrybM();

        Koenigsegg koenigsegg = new Koenigsegg();
        koenigsegg.jedz();
        koenigsegg.aktywujTryb1600KM();
        koenigsegg.wlaczSystemNitro();
        koenigsegg.sprawdzPredkoscMaksymalna();

        // TODO: Dodaj Jaguar i Bentley
        // TODO: Pomyśl jak to uprościć...
    }
}
```

---

## Pytania do przemyślenia

1. **Jak zrobić listę wszystkich aut?**
   ```java
   // ❌ Nie działa - różne typy!
   List<???> salon = new ArrayList<>();
   salon.add(new BMW());
   salon.add(new Jaguar());
   ```

2. **Jak wywołać specjalne funkcje w pętli?**
   ```java
   // ❌ Każdy samochód ma inną metodę!
   for (??? auto : salon) {
       auto.jedz(); // OK
       auto.???(); // Którą metodę wywołać?
   }
   ```

3. **Jak dodać nowy samochód bez zmiany całego kodu?**

---

## Cel zadania

Po wykonaniu tego zadania powinieneś:
- ✅ Zobaczyć **problem** z if-else dla różnych typów
- ✅ Zrozumieć **dlaczego** potrzebujemy lepszego rozwiązania
- ✅ Pomyśleć o **interfejsach** i **polimorfizmie**
- ✅ Być gotowym do nauki **wzorców projektowych**

*To zadanie pokazuje PROBLEM. Rozwiązanie poznasz na warsztatach!* 😉

---

## Bonus: Dlaczego Koenigsegg jest egzotyczny?

**Koenigsegg** to szwedzka firma produkująca hipersamochody:
- Tylko ~20 aut rocznie (ultra-rzadkie!)
- Silnik V8 twin-turbo 1600 KM
- Prędkość maksymalna: 483 km/h
- Cena: 10-30 milionów złotych
- System "Light Speed Transmission" (najszybsza skrzynia na świecie)
- **Wiele unikalnych technologii** których inne auta nie mają!

Dlatego Koenigsegg ma **3 specjalne metody** - bo ma funkcje których inne samochody po prostu nie mają! 🚀

---

*Zastanów się nad rozwiązaniem. Zobaczymy jak to poprawić!*
