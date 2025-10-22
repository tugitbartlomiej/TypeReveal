# ZADANIE: Salon Samochodowy

**Czas**: 60 minut
**Punkty**: 100
**Poziom**: Średniozaawansowany
**Temat**: Wzorce projektowe (Factory Method, Abstract Factory)

---

## 📋 OPIS PROBLEMU

Jesteś właścicielem luksusowego salonu samochodowego sprzedającego 4 marki:
- **BMW M5** - 300 000 zł
- **Jaguar F-Type** - 280 000 zł
- **Bentley Continental GT** - 850 000 zł
- **Koenigsegg Jesko** - 12 000 000 zł (szwedzki hipersamochód)

Twoim zadaniem jest zaprojektowanie systemu zarządzania salonem używając wzorców projektowych.

---

## 🎯 ZADANIE 1: FACTORY METHOD (60 punktów)

### Opis
Zaimplementuj wzorzec **Factory Method** do tworzenia samochodów.

### Wymagania

#### 1. Interfejs `Samochod` (10 pkt)
Zdefiniuj interfejs z metodami:
```java
interface Samochod {
    String getMarka();      // Zwraca nazwę modelu
    int getCena();          // Zwraca cenę w złotych
    void jedz();            // Wyświetla komunikat o jeździe
}
```

#### 2. Klasy implementujące (20 pkt)
Zaimplementuj 4 klasy: `BMW`, `Jaguar`, `Bentley`, `Koenigsegg`

Każda klasa musi:
- Implementować interfejs `Samochod`
- Zwracać poprawną markę i cenę
- Wyświetlać unikalny komunikat w metodzie `jedz()`

#### 3. Fabryka (20 pkt)
Stwórz klasę `FabrykaSamochodow` z metodą:
```java
public static Samochod stworzSamochod(String marka)
```

Metoda powinna:
- Przyjmować nazwę marki (case-insensitive)
- Zwracać obiekt implementujący `Samochod`
- Zwracać `null` dla nieznanej marki

#### 4. Demonstracja polimorfizmu (10 pkt)
W metodzie `main()`:
- Utwórz listę `ArrayList<Samochod>`
- Dodaj wszystkie 4 samochody używając fabryki
- Oblicz i wyświetl łączną wartość salonu

### Dane wejściowe
Brak (program nie czyta danych)

### Dane wyjściowe

#### Format:
```
=== SALON SAMOCHODOWY ===

Samochody w ofercie:
1. BMW M5 - 300000 zł
2. Jaguar F-Type - 280000 zł
3. Bentley Continental GT - 850000 zł
4. Koenigsegg Jesko - 12000000 zł

Test jazdy:
[Komunikaty z metody jedz()]

Łączna wartość salonu: [suma] zł
```

### Przykładowe wyjście
```
=== SALON SAMOCHODOWY ===

Samochody w ofercie:
1. BMW M5 - 300000 zł
2. Jaguar F-Type - 280000 zł
3. Bentley Continental GT - 850000 zł
4. Koenigsegg Jesko - 12000000 zł

Test jazdy:
🏎️ BMW M5 jedzie! (V8 twin-turbo, 625 KM)
🐆 Jaguar F-Type jedzie! (V6 supercharged, 380 KM)
👑 Bentley Continental GT jedzie! (W12, 635 KM)
⚡ Koenigsegg Jesko jedzie! (V8 twin-turbo, 1600 KM!!!)

Łączna wartość salonu: 13430000 zł
```

### Kryteria oceny
| Kryterium | Punkty |
|-----------|--------|
| Interfejs `Samochod` poprawnie zdefiniowany | 10 |
| Wszystkie 4 klasy poprawnie zaimplementowane | 20 |
| Fabryka działa poprawnie (case-insensitive) | 20 |
| Demonstracja polimorfizmu (lista, obliczenia) | 10 |
| **RAZEM** | **60** |

---

## 🎯 ZADANIE 2: ABSTRACT FACTORY (40 punktów)

### Opis
Rozszerz system o **Abstract Factory** obsługujący segmenty samochodów.

### Wymagania

#### Segmenty:
1. **LUXURY** (Bentley):
   - `BentleySedan` (Bentley Flying Spur) - 950 000 zł
   - `BentleySUV` (Bentley Bentayga) - 1 100 000 zł

2. **SPORT** (Koenigsegg):
   - `KoenigseggCoupe` (Jesko) - 12 000 000 zł
   - `KoenigseggRoadster` (Regera) - 11 500 000 zł

#### 1. Interfejs `AutoFactory` (10 pkt)
```java
interface AutoFactory {
    Samochod createSedan();
    Samochod createSUV();
}
```

#### 2. Konkretne fabryki (20 pkt)
Zaimplementuj:
- `LuxuryFactory` - tworzy modele Bentley
- `SportFactory` - tworzy modele Koenigsegg

#### 3. Demonstracja (10 pkt)
W `main()`:
- Utwórz oba segmenty
- Wyświetl ofertę każdego segmentu
- Pokaż, że zmiana fabryki zmienia całą rodzinę produktów

### Dane wyjściowe

#### Format:
```
=== ABSTRACT FACTORY DEMO ===

--- SEGMENT: LUXURY ---
Sedan: [model]
[komunikat jedz()]
SUV: [model]
[komunikat jedz()]
Wartość pakietu: [suma] zł

--- SEGMENT: SPORT ---
Coupe: [model]
[komunikat jedz()]
Roadster: [model]
[komunikat jedz()]
Wartość pakietu: [suma] zł
```

### Przykładowe wyjście
```
=== ABSTRACT FACTORY DEMO ===

--- SEGMENT: LUXURY ---
Sedan: Bentley Flying Spur
👑 Bentley Flying Spur (Sedan) - luksusowa limuzyna!
SUV: Bentley Bentayga
👑 Bentley Bentayga (SUV) - luksusowy terenowy!
Wartość pakietu: 2050000 zł

--- SEGMENT: SPORT ---
Coupe: Koenigsegg Jesko
⚡ Koenigsegg Jesko (Coupe) - 1600 KM hipersamochód!
Roadster: Koenigsegg Regera
⚡ Koenigsegg Regera (Roadster) - 1500 KM bez dachu!
Wartość pakietu: 23500000 zł
```

### Kryteria oceny
| Kryterium | Punkty |
|-----------|--------|
| Interfejs `AutoFactory` poprawnie zdefiniowany | 10 |
| Obie fabryki poprawnie zaimplementowane | 20 |
| Demonstracja rodzin produktów | 10 |
| **RAZEM** | **40** |

---

## 🎓 WYMAGANIA TECHNICZNE

### Ogólne wymagania
1. ✅ Kod kompiluje się bez błędów
2. ✅ Wszystkie klasy w jednym pliku `.java`
3. ✅ Używasz `interface`, nie `abstract class`
4. ✅ Metody fabrykujące zwracają interfejs, nie konkretną klasę
5. ✅ Wszystkie ceny jako `int` (nie `double`)

### Zabronione
❌ Używanie bibliotek zewnętrznych
❌ Pliki konfiguracyjne (XML, properties)
❌ Bazy danych

### Dozwolone
✅ `java.util.ArrayList`
✅ `java.util.Scanner` (dla wersji interaktywnej)
✅ `System.out.println()`

---

## 📊 PUNKTACJA

| Zadanie | Punkty maksymalne |
|---------|-------------------|
| **Zadanie 1: Factory Method** | 60 |
| - Interfejs Samochod | 10 |
| - Klasy implementujące | 20 |
| - Fabryka | 20 |
| - Polimorfizm | 10 |
| **Zadanie 2: Abstract Factory** | 40 |
| - Interfejs AutoFactory | 10 |
| - Fabryki konkretne | 20 |
| - Demonstracja | 10 |
| **RAZEM** | **100** |

### Próg zaliczenia: 50 punktów (50%)

---

## 💡 WSKAZÓWKI

### Dla Zadania 1:
1. Zacznij od interfejsu `Samochod`
2. Zaimplementuj jedną klasę (np. `BMW`)
3. Napisz fabrykę dla jednej marki
4. Rozszerz na pozostałe marki
5. Dodaj polimorfizm (lista)

### Dla Zadania 2:
1. Najpierw stwórz nowe klasy (np. `BentleySedan`)
2. Napisz interfejs `AutoFactory`
3. Zaimplementuj `LuxuryFactory`
4. Przetestuj jedną fabrykę
5. Dodaj `SportFactory`

### Częste błędy do uniknięcia:
- ❌ `return new BMW()` zamiast `return new BMW();` w fabryce
- ❌ Typ zwracany `BMW` zamiast `Samochod`
- ❌ Brak obsługi case-insensitive w fabryce
- ❌ Duplikacja kodu w metodzie `main()`

---

## 🎯 ROZSZERZENIA (BONUS - nieobowiązkowe)

### Bonus 1: Interaktywność (+10 pkt)
Dodaj menu pozwalające użytkownikowi:
- Wybrać markę samochodu
- Wyświetlić szczegóły
- Dodać do koszyka
- Obliczyć łączną cenę

### Bonus 2: Walidacja (+5 pkt)
Dodaj walidację:
- Sprawdzanie czy marka istnieje
- Komunikaty błędów
- Obsługa `null`

### Bonus 3: Nowy segment (+10 pkt)
Dodaj trzeci segment:
- **PREMIUM** (BMW):
  - `BMWSedan` (Seria 7)
  - `BMWSUV` (X7)

---

## 📚 MATERIAŁY POMOCNICZE

### Przykład użycia Factory Method:
```java
Samochod auto = FabrykaSamochodow.stworzSamochod("bmw");
System.out.println(auto.getMarka());  // BMW M5
System.out.println(auto.getCena());   // 300000
auto.jedz();                          // 🏎️ BMW M5 jedzie!
```

### Przykład użycia Abstract Factory:
```java
AutoFactory factory = new LuxuryFactory();
Samochod sedan = factory.createSedan();   // BentleySedan
Samochod suv = factory.createSUV();       // BentleySUV

// Zmiana segmentu:
factory = new SportFactory();
sedan = factory.createSedan();            // KoenigseggCoupe
```

---

## 📝 FORMAT ODDAWANIA

1. **Nazwa pliku**: `NazwiskoImie_Fabryka.java`
2. **Zawartość**:
   - Wszystkie klasy i interfejsy
   - Metoda `main()` z demonstracją
   - Komentarze wyjaśniające wzorce

3. **Struktura kodu**:
```java
// Interfejsy
interface Samochod { ... }
interface AutoFactory { ... }

// Klasy dla Zadania 1
class BMW implements Samochod { ... }
// ...

// Fabryka dla Zadania 1
class FabrykaSamochodow { ... }

// Klasy dla Zadania 2
class BentleySedan implements Samochod { ... }
// ...

// Fabryki dla Zadania 2
class LuxuryFactory implements AutoFactory { ... }
class SportFactory implements AutoFactory { ... }

// Główna klasa
public class NazwiskoImie_Fabryka {
    public static void main(String[] args) {
        // Demonstracja Zadania 1
        // Demonstracja Zadania 2
    }
}
```

---

## ⏰ CZAS REALIZACJI

- **Zadanie 1**: ~35 minut
- **Zadanie 2**: ~25 minut
- **Łącznie**: 60 minut

---

## ✅ SPRAWDZENIE POPRAWNOŚCI

### Test 1: Factory Method
```java
Samochod auto = FabrykaSamochodow.stworzSamochod("bmw");
assert auto != null;
assert auto.getMarka().contains("BMW");
assert auto.getCena() == 300000;
```

### Test 2: Abstract Factory
```java
AutoFactory factory = new LuxuryFactory();
Samochod s1 = factory.createSedan();
Samochod s2 = factory.createSUV();
assert s1.getMarka().contains("Bentley");
assert s2.getMarka().contains("Bentley");
```

---

**Powodzenia!** 🚗⚡

*Pamiętaj: Wzorce projektowe to nie kod dla kodu - to rozwiązania prawdziwych problemów!*
