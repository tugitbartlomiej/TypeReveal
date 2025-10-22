# 🏭 Wzorce Projektowe: Factory Method i Abstract Factory

## 📚 Kompletny Pakiet Dydaktyczny - Salon Bajtazara

---

## 📂 Struktura Projektu

```
prezentacja/
├── Kod/                          # 5 wersji kodu (ewolucja rozwiązania)
│   ├── 01_SalonDemo_START.java          # Problem: duplikacja, różne typy
│   ├── 02_SalonDemo_IFELSE.java         # Próba rozwiązania (ZŁA!)
│   ├── 03_SalonDemo_INTERFEJS.java      # Krok 1: Interfejs + polimorfizm
│   ├── 04_SalonDemo_FACTORY_METHOD.java # Krok 2: Wzorzec Factory Method
│   └── 05_SalonDemo_ABSTRACT_FACTORY.java # Krok 3: Abstract Factory
│
├── Zadania/                      # Zadania dla studentów
│   ├── ZADANIE_01_PODSTAWOWE.md         # Intro: specjalne funkcje samochodów
│   └── ZADANIE_02_OI_STYLE.md           # Zadanie OI (3 podproblemy)
│
├── SkryptProwadzacego/           # Scenariusze warsztatów
│   ├── 01_SCENARIUSZ_INTERFEJS_I_FACTORY.md     # 45-50 min
│   └── 02_SCENARIUSZ_ABSTRACT_FACTORY.md        # 35-40 min
│
└── README.md                     # Ten plik

```

---

## 🎯 Temat: Salon Bajtazara - Specjalne Funkcje Samochodów

### Samochody w salonie:

1. **BMW M5** (300 000 zł)
   - Specjalna funkcja: `aktywujTrybM()`

2. **Jaguar F-Type** (280 000 zł)
   - Specjalna funkcja: `wydajRyk()`

3. **Bentley Continental GT** (850 000 zł)
   - Specjalna funkcja: `wlaczMasazFoteli()`

4. **Koenigsegg Jesko** (12 000 000 zł) ⭐ EGZOTYCZNY!
   - 3 specjalne funkcje: `aktywujTryb1600KM()`, `wlaczSystemNitro()`, `sprawdzPredkoscMaksymalna()`

### Problem do rozwiązania:

Każdy samochód ma **różne specjalne metody**. Jak obsłużyć to w kodzie bez duplikacji if-else?

---

## 📖 Ewolucja Rozwiązania (5 kroków)

### Krok 0: START (01_SalonDemo_START.java)
```java
BMW bmw = new BMW();
bmw.aktywujTrybM();

Koenigsegg k = new Koenigsegg();
k.aktywujTryb1600KM();  // ← 3 różne metody!
k.wlaczSystemNitro();
k.sprawdzPredkoscMaksymalna();
```

**Problem:**
- Każdy samochód to INNY TYP
- Nie można zrobić `List<???>`
- Koenigsegg ma 3 metody - jak to uogólnić?

---

### Krok 1: IF-ELSE (02_SalonDemo_IFELSE.java) ❌ ZŁE!

```java
public static void pokazSamochod(String marka) {
    if (marka.equals("bmw")) {
        BMW auto = new BMW();
        auto.aktywujTrybM();
    } else if (marka.equals("jaguar")) {
        Jaguar auto = new Jaguar();
        auto.wydajRyk();
    } else if (marka.equals("koenigsegg")) {
        Koenigsegg auto = new Koenigsegg();
        auto.aktywujTryb1600KM();
        auto.wlaczSystemNitro();
        auto.sprawdzPredkoscMaksymalna();
    }
}
```

**Problem:**
- Duplikacja if-else w KAŻDEJ metodzie
- Dodanie Ferrari = zmiany WSZĘDZIE
- Koenigsegg to koszmar (3 metody)

---

### Krok 2: INTERFEJS (03_SalonDemo_INTERFEJS.java) ✅

```java
interface Samochod {
    String getMarka();
    int getCena();
    void jedz();
    void pokazSpecjalneFunkcje();  // ← KLUCZOWE!
}

class Koenigsegg implements Samochod {
    @Override
    public void pokazSpecjalneFunkcje() {
        // Wywołuje WSZYSTKIE 3 funkcje!
        aktywujTryb1600KM();
        wlaczSystemNitro();
        sprawdzPredkoscMaksymalna();
    }
}
```

**Zalety:**
- Wszystkie samochody jako `Samochod`
- Możliwa lista: `List<Samochod>`
- Pętla działa dla wszystkich
- Koenigsegg automatycznie wywołuje 3 funkcje!

**Problem:**
- Nadal piszemy `new BMW()`, `new Jaguar()`...

---

### Krok 3: FACTORY METHOD (04_SalonDemo_FACTORY_METHOD.java) ⭐

```java
class FabrykaSamochodow {
    public static Samochod stworzSamochod(String marka) {
        switch (marka.toLowerCase()) {
            case "bmw": return new BMW();
            case "jaguar": return new Jaguar();
            case "bentley": return new Bentley();
            case "koenigsegg": return new Koenigsegg();
            default: return null;
        }
    }
}

// Użycie:
Samochod auto = FabrykaSamochodow.stworzSamochod("bmw");
auto.pokazSpecjalneFunkcje();
```

**Zalety:**
- Jedna metoda tworzy wszystkie samochody
- If-else TYLKO w jednym miejscu
- Działa z Koenigseggiem (3 funkcje)!
- Dodanie Ferrari = 2 zmiany (klasa + case)

---

### Krok 4: ABSTRACT FACTORY (05_SalonDemo_ABSTRACT_FACTORY.java) 🏆

**Problem:** Factory Method tworzy JEDEN produkt. Co jeśli chcemy RODZINY?

```java
// RODZINY: Sedan + SUV
interface FabrykaSamochodowAbstract {
    Sedan stworzSedan();
    SUV stworzSUV();
}

class FabrykaBMW implements FabrykaSamochodowAbstract {
    public Sedan stworzSedan() { return new BMWSedan(); }
    public SUV stworzSUV() { return new BMWSUV(); }
}

// Użycie:
FabrykaSamochodowAbstract fabryka = ProducentFabryk.getFabryka("bmw");
Sedan sedan = fabryka.stworzSedan();  // BMW Seria 7
SUV suv = fabryka.stworzSUV();        // BMW X7
```

**Zalety:**
- Tworzy RODZINY produktów
- Gwarantowana spójność (oba BMW!)
- Łatwa zamiana rodziny (jedna zmiana fabryki)

---

## 🎓 Jak Używać Tego Pakietu?

### Scenariusz 1: Warsztaty (zalecane)

**Dzień 1: Factory Method (45-50 min)**
1. Studenci robią `ZADANIE_01_PODSTAWOWE.md` (30 min)
2. Otwierasz `01_SCENARIUSZ_INTERFEJS_I_FACTORY.md`
3. Piszesz kod na żywo według scenariusza:
   - Pokazujesz `01_SalonDemo_START.java` (problem)
   - Pokazujesz `02_SalonDemo_IFELSE.java` (zła próba)
   - Piszesz `03_SalonDemo_INTERFEJS.java` (polimorfizm)
   - Piszesz `04_SalonDemo_FACTORY_METHOD.java` (wzorzec!)

**Dzień 2: Abstract Factory (35-40 min)**
1. Przypominasz Factory Method
2. Otwierasz `02_SCENARIUSZ_ABSTRACT_FACTORY.md`
3. Piszesz `05_SalonDemo_ABSTRACT_FACTORY.java` według scenariusza

---

### Scenariusz 2: Zadanie domowe + wykład

**Przed zajęciami:**
- Studenci robią `ZADANIE_01_PODSTAWOWE.md`

**Na zajęciach:**
- Pokazujesz gotowe pliki Java (01-05)
- Omawiasz ewolucję rozwiązania
- Wyjaśniasz wzorce

---

### Scenariusz 3: Zadanie konkursowe OI

**Dla bardziej zaawansowanych:**
- Studenci rozwiązują `ZADANIE_02_OI_STYLE.md`
- 3 podproblemy (40 + 30 + 30 punktów)
- Wymaga implementacji fabryki + polimorfizmu

---

## 🔑 Kluczowe Koncepcje

### 1. Polimorfizm przez `pokazSpecjalneFunkcje()`

**Problem:** Koenigsegg ma 3 metody, BMW ma 1. Jak uogólnić?

**Rozwiązanie:**
```java
// JEDNA metoda w interfejsie
void pokazSpecjalneFunkcje();

// RÓŻNE implementacje
class BMW { ... pokazSpecjalneFunkcje() { aktywujTrybM(); } }
class Koenigsegg { ... pokazSpecjalneFunkcje() {
    aktywujTryb1600KM();
    wlaczSystemNitro();
    sprawdzPredkoscMaksymalna();
}}
```

### 2. Factory Method - If-else w jednym miejscu

**Bez fabryki:**
- If-else w `pokazSamochod()`
- If-else w `pobierzCene()`
- If-else w `testJazdy()`
- **3× duplikacja!**

**Z fabryką:**
- If-else TYLKO w `FabrykaSamochodow.stworzSamochod()`
- **1× if-else, wszędzie indziej polimorfizm!**

### 3. Abstract Factory - Rodziny produktów

**Factory Method:**
```java
Samochod bmw = stworzSamochod("bmw");
Samochod bentley = stworzSamochod("bentley"); // Mieszanka!
```

**Abstract Factory:**
```java
FabrykaSamochodowAbstract fabryka = getFabryka("bmw");
Sedan sedan = fabryka.stworzSedan();  // BMW
SUV suv = fabryka.stworzSUV();        // BMW - gwarantowane!
```

---

## 💡 Najczęstsze Pytania

### Q: Dlaczego `pokazSpecjalneFunkcje()` zamiast konkretnych metod?

A: Bo każdy samochód ma **różne** specjalne funkcje. Polimorfizm pozwala wywołać **jedną metodę**, a każda klasa robi **swoje**.

### Q: Koenigsegg ma 3 metody - czy to nie problem?

A: **NIE!** W `pokazSpecjalneFunkcje()` wywołuje wszystkie 3. Z zewnątrz nadal jedna metoda!

### Q: Po co fabryka jeśli nadal jest if-else?

A: If-else jest, ale **w jednym miejscu**! Bez fabryki if-else byłby w 10 miejscach!

### Q: Kiedy używać Factory Method, a kiedy Abstract Factory?

A:
- **Factory Method:** Jeden produkt (Samochod)
- **Abstract Factory:** Rodzina produktów (Sedan + SUV)

### Q: Jak dodać Ferrari?

**Factory Method:**
1. Dodaj `class Ferrari implements Samochod`
2. Dodaj `case "ferrari": return new Ferrari();`
3. GOTOWE!

**Abstract Factory:**
1. Dodaj `class FerrariSedan implements Sedan`
2. Dodaj `class FerrariSUV implements SUV`
3. Dodaj `class FabrykaFerrari implements FabrykaSamochodowAbstract`
4. Dodaj `case "ferrari": return new FabrykaFerrari();`
5. GOTOWE!

---

## 🚀 Szybki Start

### Kompilacja i uruchomienie:

```bash
# Krok 1: Problem
javac prezentacja/Kod/01_SalonDemo_START.java
java 01_SalonDemo_START

# Krok 2: Zła próba (if-else)
javac prezentacja/Kod/02_SalonDemo_IFELSE.java
java 02_SalonDemo_IFELSE

# Krok 3: Interfejs
javac prezentacja/Kod/03_SalonDemo_INTERFEJS.java
java 03_SalonDemo_INTERFEJS

# Krok 4: Factory Method ⭐
javac prezentacja/Kod/04_SalonDemo_FACTORY_METHOD.java
java 04_SalonDemo_FACTORY_METHOD

# Krok 5: Abstract Factory 🏆
javac prezentacja/Kod/05_SalonDemo_ABSTRACT_FACTORY.java
java 05_SalonDemo_ABSTRACT_FACTORY
```

---

## 📊 Porównanie Wzorców

| Cecha | Factory Method | Abstract Factory |
|-------|----------------|------------------|
| **Produkty** | Jeden typ | Rodzina typów |
| **Metody** | `stworzSamochod()` | `stworzSedan()`, `stworzSUV()` |
| **Zwraca** | `Samochod` | `Sedan`, `SUV` |
| **Spójność** | Nie gwarantuje | Gwarantuje rodzinę |
| **Przykład** | Tworzy BMW | Tworzy BMW Sedan + BMW SUV |

---

## ✅ Checklist dla Prowadzącego

### Przed zajęciami:
- [ ] Przekompiluj wszystkie 5 plików Java
- [ ] Przeczytaj scenariusz (01 lub 02)
- [ ] Przygotuj tablicę/flipchart
- [ ] Upewnij się, że studenci mają JDK

### Podczas zajęć:
- [ ] Pokaż `01_SalonDemo_START.java` (problem)
- [ ] Pokaż `02_SalonDemo_IFELSE.java` (zła próba)
- [ ] **Pisz kod na żywo** według scenariusza
- [ ] Podkreśl `pokazSpecjalneFunkcje()` - KLUCZOWE!
- [ ] Wyjaśnij dlaczego Koenigsegg działa (3 metody w jednej)
- [ ] Narysuj diagram ewolucji na tablicy

### Kluczowe momenty:
1. **Moment AHA! #1:** Koenigsegg w `pokazSpecjalneFunkcje()` wywołuje 3 metody - automatycznie!
2. **Moment AHA! #2:** Fabryka zwraca `Samochod`, nie `BMW` - polimorfizm!
3. **Moment AHA! #3:** Abstract Factory gwarantuje spójność rodziny

---

## 🎨 Przykładowe Wyjście

```
╔═══════════════════════════════════════╗
║  SALON BAJTAZARA - DEMO SAMOCHODÓW    ║
╚═══════════════════════════════════════╝

=== BMW M5 ===
Cena: 300000 bajtalarów
BMW jedzie!
TRYB M AKTYWNY! +100 KM!

=== Koenigsegg Jesko ===
Cena: 12000000 bajtalarów
Koenigsegg jedzie!
TRYB 1600 KM AKTYWNY!!!
NITRO WŁĄCZONE! BOOST!
Prędkość maksymalna: 483 km/h!
```

---

## 📚 Dodatkowe Materiały

### Wzorce w praktyce:
- **GUI:** `WindowsFactory` (Button + Checkbox + ScrollBar)
- **Bazy danych:** `DatabaseFactory` (Connection + Statement + ResultSet)
- **Gry:** `EnvironmentFactory` (Terrain + Weather + Lighting)

### Zasady SOLID:
- **Open/Closed:** Dodanie Ferrari nie wymaga zmian istniejącego kodu
- **Single Responsibility:** Fabryka tylko tworzy, klasy tylko definiują zachowanie
- **Dependency Inversion:** Kod zależy od interfejsów (`Samochod`), nie klas (`BMW`)

---

## 🎯 Cele Nauczania

Po wykonaniu tych materiałów studenci będą potrafili:

✅ Rozpoznać problem duplikacji if-else
✅ Zastosować interfejs dla polimorfizmu
✅ Zaimplementować wzorzec Factory Method
✅ Zaimplementować wzorzec Abstract Factory
✅ Wyjaśnić różnicę między Factory Method a Abstract Factory
✅ Obsłużyć "egzotyczne" klasy (Koenigsegg z 3 metodami)
✅ Dodać nowe klasy bez zmian w istniejącym kodzie

---

## 📞 Kontakt / Feedback

Jeśli znalazłeś błąd lub masz sugestie, zgłoś issue lub pull request!

---

**Powodzenia na zajęciach!** 🚀

---

## 📄 Licencja

Ten materiał dydaktyczny jest udostępniony do użytku edukacyjnego.

---

**Wersja:** 1.0
**Data:** 2025
**Temat:** Wzorce projektowe - Factory Method i Abstract Factory
**Przykład:** Salon Bajtazara - Specjalne funkcje samochodów
