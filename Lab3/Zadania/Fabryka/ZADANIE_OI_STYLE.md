# Salon Samochodowy (sal)

**Limit czasu:** 1s
**Limit pamięci:** 256 MB
**Punkty:** 100

---

## Opis problemu

Jesteś właścicielem luksusowego salonu samochodowego. W salonie dostępne są cztery marki samochodów różniące się ceną i charakterystyką. Twoim zadaniem jest zaprojektowanie systemu zarządzania salonem wykorzystującego wzorce projektowe Factory Method oraz Abstract Factory.

Dostępne marki samochodów:
- BMW M5 (cena: 300000)
- Jaguar F-Type (cena: 280000)
- Bentley Continental GT (cena: 850000)
- Koenigsegg Jesko (cena: 12000000)

---

## Specyfikacja techniczna

### Podzadanie 1: Factory Method (60 punktów)

Zaimplementuj wzorzec Factory Method zgodnie z następującą specyfikacją:

**Interfejs Samochod:**
```java
interface Samochod {
    String getMarka();
    int getCena();
    void wyswietlInfo();
}
```

**Wymagania:**
1. Zdefiniuj interfejs `Samochod` z trzema metodami
2. Zaimplementuj cztery klasy: `BMW`, `Jaguar`, `Bentley`, `Koenigsegg`
3. Każda klasa implementuje interfejs `Samochod`
4. Zaimplementuj klasę `FabrykaSamochodow` z metodą statyczną:
   ```java
   public static Samochod stworzSamochod(String marka)
   ```
5. Metoda przyjmuje nazwę marki (bez rozróżniania wielkości liter)
6. Metoda zwraca obiekt implementujący interfejs `Samochod` lub `null` dla nieznanej marki

**Format wyjścia metody wyswietlInfo():**
```
[Nazwa modelu]: [cena] zl
```

### Podzadanie 2: Abstract Factory (40 punktów)

Rozszerz system o wzorzec Abstract Factory obsługujący dwa segmenty samochodów.

**Segmenty:**

Segment LUXURY (Bentley):
- BentleySedan: Bentley Flying Spur (cena: 950000)
- BentleySUV: Bentley Bentayga (cena: 1100000)

Segment SPORT (Koenigsegg):
- KoenigseggCoupe: Koenigsegg Jesko (cena: 12000000)
- KoenigseggRoadster: Koenigsegg Regera (cena: 11500000)

**Interfejs AutoFactory:**
```java
interface AutoFactory {
    Samochod createSedan();
    Samochod createSUV();
}
```

**Wymagania:**
1. Zdefiniuj interfejs `AutoFactory` z dwiema metodami
2. Zaimplementuj klasy: `BentleySedan`, `BentleySUV`, `KoenigseggCoupe`, `KoenigseggRoadster`
3. Zaimplementuj dwie fabryki: `LuxuryFactory` i `SportFactory`
4. Każda fabryka implementuje interfejs `AutoFactory`

---

## Wejście

Program nie czyta danych z wejścia standardowego.

---

## Wyjście

### Dla podzadania 1:

Program wypisuje na wyjście standardowe:

```
=== FACTORY METHOD ===
[informacje o wszystkich samochodach]
Wartosc salonu: [suma_cen] zl
```

### Dla podzadania 2:

Program dodatkowo wypisuje:

```
=== ABSTRACT FACTORY ===
Segment: LUXURY
Sedan: [model] ([cena] zl)
SUV: [model] ([cena] zl)
Wartosc pakietu: [suma] zl

Segment: SPORT
Sedan: [model] ([cena] zl)
SUV: [model] ([cena] zl)
Wartosc pakietu: [suma] zl
```

---

## Przykład

### Wyjście dla podzadania 1:

```
=== FACTORY METHOD ===
BMW M5: 300000 zl
Jaguar F-Type: 280000 zl
Bentley Continental GT: 850000 zl
Koenigsegg Jesko: 12000000 zl
Wartosc salonu: 13430000 zl
```

### Wyjście dla podzadania 2:

```
=== ABSTRACT FACTORY ===
Segment: LUXURY
Sedan: Bentley Flying Spur (950000 zl)
SUV: Bentley Bentayga (1100000 zl)
Wartosc pakietu: 2050000 zl

Segment: SPORT
Sedan: Koenigsegg Jesko (12000000 zl)
SUV: Koenigsegg Regera (11500000 zl)
Wartosc pakietu: 23500000 zl
```

---

## Ograniczenia

- Wszystkie ceny są liczbami całkowitymi nieujemnymi
- Nazwy marek są ciągami znaków o długości co najwyżej 50
- Metoda `stworzSamochod` musi obsługiwać nazwy marek niezależnie od wielkości liter
- Klasa główna musi nazywać się dokładnie `Salon`
- Wszystkie klasy muszą znajdować się w jednym pliku `Salon.java`

---

## Punktacja

### Grupa 1 (10 punktów): Interfejs i podstawowe klasy
- Poprawna definicja interfejsu `Samochod`
- Poprawna implementacja klasy `BMW`

### Grupa 2 (20 punktów): Wszystkie klasy samochodów
- Poprawna implementacja wszystkich czterech klas
- Poprawne zwracanie nazw i cen

### Grupa 3 (30 punktów): Fabryka
- Poprawna implementacja metody `stworzSamochod`
- Obsługa wszystkich marek (case-insensitive)
- Zwracanie `null` dla nieznanej marki
- Typ zwracany to `Samochod`, nie konkretna klasa

### Grupa 4 (10 punktów): Interfejs AutoFactory
- Poprawna definicja interfejsu `AutoFactory`
- Poprawna implementacja klas `BentleySedan` i `BentleySUV`

### Grupa 5 (20 punktów): Fabryki konkretne
- Poprawna implementacja `LuxuryFactory`
- Poprawna implementacja `SportFactory`
- Fabryki zwracają odpowiednie obiekty

### Grupa 6 (10 punktów): Demonstracja
- Poprawne wypisanie wyników dla obu segmentów
- Poprawne obliczenie wartości pakietów

---

## Wymagania implementacyjne

1. **Polimorfizm**: Metody fabrykujące MUSZĄ zwracać typ interfejsu, nie konkretną klasę
   ```java
   // DOBRZE:
   public static Samochod stworzSamochod(String marka)

   // ŹLE:
   public static BMW stworzSamochod(String marka)
   ```

2. **Enkapsulacja**: Pola klas muszą być prywatne

3. **Immutability**: Ceny i nazwy nie mogą być modyfikowane po utworzeniu obiektu

4. **Naming**: Nazwy metod i klas muszą być zgodne ze specyfikacją

---

## Rozwiązanie wzorcowe

### Struktura programu:

```java
// Interfejsy
interface Samochod { ... }
interface AutoFactory { ... }

// Klasy dla Factory Method
class BMW implements Samochod { ... }
class Jaguar implements Samochod { ... }
class Bentley implements Samochod { ... }
class Koenigsegg implements Samochod { ... }

// Fabryka dla Factory Method
class FabrykaSamochodow {
    public static Samochod stworzSamochod(String marka) { ... }
}

// Klasy dla Abstract Factory
class BentleySedan implements Samochod { ... }
class BentleySUV implements Samochod { ... }
class KoenigseggCoupe implements Samochod { ... }
class KoenigseggRoadster implements Samochod { ... }

// Fabryki konkretne
class LuxuryFactory implements AutoFactory { ... }
class SportFactory implements AutoFactory { ... }

// Główna klasa
public class Salon {
    public static void main(String[] args) {
        // Demonstracja Factory Method
        // Demonstracja Abstract Factory
    }
}
```

---

## Kompilacja i uruchomienie

```bash
javac Salon.java
java Salon
```

---

## Autor zadania

Zadanie przygotowane na potrzeby warsztatów z wzorców projektowych.

---

## Notatki dla sprawdzającego

### Typowe błędy uczestników:

1. **Zwracanie konkretnej klasy zamiast interfejsu**
   ```java
   // ŹLE - zwraca BMW zamiast Samochod
   public static BMW stworzSamochod(String marka)
   ```
   Kara: 0 punktów za grupę 3

2. **Brak obsługi case-insensitive**
   ```java
   // ŹLE - nie obsługuje "BMW", "bmw", "Bmw"
   if (marka.equals("bmw"))
   ```
   Kara: -10 punktów za grupę 3

3. **Publiczne pola w klasach**
   ```java
   // ŹLE
   public class BMW {
       public int cena = 300000; // pole publiczne
   }
   ```
   Kara: -5 punktów za grupę 2

4. **Brak walidacji w fabryce**
   ```java
   // ŹLE - nie obsługuje null
   public static Samochod stworzSamochod(String marka) {
       switch (marka.toLowerCase()) { ... }
       // NullPointerException dla marka == null
   }
   ```
   Kara: -5 punktów za grupę 3

### Testy sprawdzające:

**Test 1 (grupa 1-2):**
```java
Samochod bmw = new BMW();
assert bmw.getMarka().equals("BMW M5");
assert bmw.getCena() == 300000;
```

**Test 2 (grupa 3):**
```java
Samochod auto1 = FabrykaSamochodow.stworzSamochod("bmw");
Samochod auto2 = FabrykaSamochodow.stworzSamochod("BMW");
Samochod auto3 = FabrykaSamochodow.stworzSamochod("Bmw");
assert auto1 != null && auto2 != null && auto3 != null;
assert FabrykaSamochodow.stworzSamochod("ferrari") == null;
```

**Test 3 (grupa 4-5):**
```java
AutoFactory luxury = new LuxuryFactory();
Samochod sedan = luxury.createSedan();
Samochod suv = luxury.createSUV();
assert sedan.getMarka().contains("Bentley");
assert suv.getMarka().contains("Bentley");
assert sedan.getCena() == 950000;
assert suv.getCena() == 1100000;
```

**Test 4 (polimorfizm):**
```java
// Sprawdzenie że zwraca interfejs, nie konkretną klasę
Method m = FabrykaSamochodow.class.getMethod("stworzSamochod", String.class);
assert m.getReturnType() == Samochod.class; // NIE BMW.class
```

---

## Rozszerzenia (nieobowiązkowe)

### Podzadanie 3: Interaktywność (bonus +10 punktów)

Dodaj obsługę wejścia interaktywnego:

**Wejście:**
```
4
bmw
jaguar
bentley
koenigsegg
```

Pierwsza linia: liczba n (1 ≤ n ≤ 100) - liczba zapytań
Kolejne n linii: nazwy marek do utworzenia

**Wyjście:**
Dla każdej marki wypisz informacje lub "NIEZNANA MARKA" dla błędnych nazw.

### Podzadanie 4: Nowy segment (bonus +15 punktów)

Dodaj trzeci segment PREMIUM (BMW):
- BMWSedan: BMW Seria 7 (cena: 450000)
- BMWSUV: BMW X7 (cena: 520000)

Zaimplementuj `PremiumFactory` i rozszerz demonstrację.

---

## Historia zmian

- **v1.0** (2024-10-21): Pierwsza wersja zadania
- **v1.1** (2024-10-21): Dodano wymagania implementacyjne
- **v1.2** (2024-10-21): Rozszerzono sekcję "Notatki dla sprawdzającego"
