# 🎬 SCENARIUSZ: Jak wprowadzić wzorzec FABRYKA?

**Czas:** 30-40 minut
**Od:** If-else chaos
**Do:** Wzorzec Factory Method

---

## 📋 PRZYGOTOWANIE

### Przed warsztatami:
1. Studenci zrobili już zadanie startowe (SalonDemo_START.java)
2. Widzieli problem z if-else (SalonDemo_IFELSE.java)
3. Teraz wprowadzasz rozwiązanie krok po kroku

### Materiały:
- ✅ SalonDemo_START.java (punkt wyjścia)
- ✅ SalonDemo_IFELSE.java (pokazuje problem)
- ✅ SalonDemo_KROK1_interfejs.java (będziesz pisać)
- ✅ SalonDemo_KROK2_fabryka.java (będziesz pisać)

---

## 🎯 KROK 1: WPROWADZENIE INTERFEJSU (10-12 minut)

### [ZACZYNASZ OD PYTANIA]

**Ty**: "OK, widzieliśmy że if-else nie działa. Koenigsegg z 3 metodami to koszmar.
Pytanie: co jest WSPÓLNE dla wszystkich samochodów?"

*[Czekaj na odpowiedzi]*

**Student**: "Marka, cena, jeżdżą..."

**Ty**: "Dokładnie! Każdy ma markę, cenę, może jechać. A co jest RÓŻNE?"

**Student**: "Te specjalne funkcje - BMW ma tryb M, Jaguar ma ryk..."

**Ty**: "TAK! Wspólne + różne = INTERFEJS! Piszmy!"

### [OTWIERASZ NOWY PLIK]

**Ty**: "Nowy plik - SalonDemo_KROK1_interfejs.java"

### [PISZESZ INTERFEJS]

```java
interface Samochod {
```

**Ty**: "Interfejs Samochod - kontrakt dla wszystkich aut"

```java
    String getMarka();
    int getCena();
    void jedz();
```

**Ty**: "Trzy metody WSPÓLNE - każdy ma markę, cenę, jedzie"

**Ty**: "Ale czekaj - każdy ma RÓŻNE specjalne funkcje. Jak to rozwiązać?"

*[Moment ciszy - niech pomyślą]*

**Ty**: "Zrobimy JEDNĄ metodę, ale każdy zaimplementuje ją INACZEJ!"

```java
    void pokazSpecjalneFunkcje();
}
```

**Ty**: "pokazSpecjalneFunkcje() - każdy POKAŻE swoje unikalne funkcje!"

### [IMPLEMENTUJESZ PIERWSZĄ KLASĘ]

```java
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
        System.out.println("🏎️ BMW jedzie!");
    }

    @Override
    public void pokazSpecjalneFunkcje() {
        // BMW pokazuje SWOJĄ funkcję
        System.out.println("⚡ TRYB M AKTYWNY!");
    }
}
```

**Ty**: "BMW implementuje interfejs. W pokazSpecjalneFunkcje() robi SWOJĄ rzecz - tryb M!"

### [PRZYŚPIESZASZ - KOENIGSEGG]

**Ty**: "Resztę szybko... ale Koenigsegg - UWAGA!"

```java
class Koenigsegg implements Samochod {
    // ... getMarka, getCena, jedz ...

    @Override
    public void pokazSpecjalneFunkcje() {
        // ⚡ EGZOTYCZNY - pokazuje WSZYSTKIE 3!
        System.out.println("🚀 TRYB 1600 KM AKTYWNY!!!");
        System.out.println("💨 NITRO WŁĄCZONE!");
        System.out.println("📊 Prędkość: 483 km/h!");
    }
}
```

**Ty**: "Koenigsegg w pokazSpecjalneFunkcje() wywołuje WSZYSTKIE 3 funkcje!
Ten sam interfejs, ale RÓŻNA implementacja!"

### [POKAZUJESZ POLIMORFIZM]

```java
public static void main(String[] args) {
    // ✅ TERAZ WSZYSTKIE TO TEN SAM TYP!
    Samochod bmw = new BMW();
    Samochod jaguar = new Jaguar();
    Samochod koenigsegg = new Koenigsegg();

    // ✅ MOŻEMY ZROBIĆ LISTĘ!
    Samochod[] salon = {bmw, jaguar, koenigsegg};

    // ✅ PĘTLA DZIAŁA!
    for (Samochod auto : salon) {
        System.out.println(auto.getMarka());
        auto.jedz();
        auto.pokazSpecjalneFunkcje(); // ← każdy robi SWOJE!
    }
}
```

### [URUCHAMIASZ]

```bash
javac SalonDemo_KROK1_interfejs.java
java SalonDemo_KROK1_interfejs
```

**Wyjście:**
```
=== BMW M5 ===
🏎️ BMW jedzie!
⚡ TRYB M AKTYWNY!

=== Koenigsegg Jesko ===
⚡ Koenigsegg jedzie!
🚀 TRYB 1600 KM AKTYWNY!!!
💨 NITRO WŁĄCZONE!
📊 Prędkość: 483 km/h!
```

**Ty**: "PATRZCIE! Koenigsegg pokazał WSZYSTKIE 3 funkcje, automatycznie!
Jedna pętla obsługuje WSZYSTKO!"

### [MOMENT REFLEKSJI]

**Ty**: "Super! Ale nadal piszemy 'new BMW()', 'new Jaguar()'...
Co jeśli klient wybiera markę? Znowu if-else?"

*[Studenci: tak, if-else...]*

**Ty**: "Właśnie! Potrzebujemy... FABRYKI!"

---

## 🏭 KROK 2: WZORZEC FABRYKA (15-20 minut)

### [NOWY PLIK]

**Ty**: "Nowy plik - SalonDemo_KROK2_fabryka.java
Skopiuję interfejs i klasy... i dodaję FABRYKĘ!"

### [PISZESZ FABRYKĘ]

```java
class FabrykaSamochodow {
```

**Ty**: "Klasa FabrykaSamochodow - to jest wzorzec!"

```java
    public static Samochod stworzSamochod(String marka) {
```

**Ty**: "UWAGA! Metoda STATYCZNA. Zwraca SAMOCHOD (interfejs), nie BMW czy Jaguar!"

*[Zaznacz to na tablicy: ZWRACA INTERFEJS!]*

```java
        if (marka == null) {
            return null;
        }

        String markaNorm = marka.toLowerCase().trim();
```

**Ty**: "Normalizacja - żeby 'BMW', 'bmw', '  Bmw  ' działały tak samo"

```java
        switch (markaNorm) {
            case "bmw":
                return new BMW();
            case "jaguar":
                return new Jaguar();
            case "bentley":
                return new Bentley();
            case "koenigsegg":
                return new Koenigsegg();
            default:
                return null;
        }
    }
}
```

**Ty**: "Switch - prosty wybór. JEDEN switch, w JEDNYM miejscu!
To jest CAŁA fabryka. Prosta, prawda?"

*[CZEKAJ NA PYTANIE! Ktoś powie: "Ale to nadal switch/if-else, więc jaka różnica?"]*

**Ty**: "ŚWIETNE PYTANIE! Patrzcie na różnicę..."

*[Rysuj na tablicy porównanie]*

```
╔════════════════════════════════════════════════════════╗
║  BEZ FABRYKI (if-else WSZĘDZIE)                        ║
╚════════════════════════════════════════════════════════╝

pokazSamochod(String marka) {
    if (marka.equals("bmw")) { ... }        ← 10 linii
    else if (marka.equals("jaguar")) { ... }
    ...
}

pobierzCene(String marka) {
    if (marka.equals("bmw")) { ... }        ← 10 linii ZNOWU!
    else if (marka.equals("jaguar")) { ... }
    ...
}

testJazdy(String marka) {
    if (marka.equals("bmw")) { ... }        ← 10 linii PO RAZ TRZECI!
    else if (marka.equals("jaguar")) { ... }
    ...
}

❌ PROBLEM: If-else powtórzony 3 RAZY!
❌ Dodanie Ferrari → zmiana w 3 miejscach!


╔════════════════════════════════════════════════════════╗
║  Z FABRYKĄ (switch RAZ!)                               ║
╚════════════════════════════════════════════════════════╝

FabrykaSamochodow.stworzSamochod(String marka) {
    switch (marka) {                        ← 10 linii RAZ!
        case "bmw": return new BMW();
        case "jaguar": return new Jaguar();
        ...
    }
}

pokazSamochod(String marka) {
    Samochod auto = FabrykaSamochodow.stworzSamochod(marka);
    auto.pokazSpecjalneFunkcje();           ← 2 linie!
}

pobierzCene(String marka) {
    Samochod auto = FabrykaSamochodow.stworzSamochod(marka);
    return auto.getCena();                  ← 2 linie!
}

✅ ZALETA: Switch TYLKO w fabryce!
✅ Dodanie Ferrari → zmiana w 1 miejscu (fabryka)!
```

**Ty**: "Widzicie różnicę?

**BEZ fabryki:**
- 3 metody × 10 linii if-else = **30 linii duplikacji**!
- Dodanie Ferrari = zmiana w **3 miejscach** (a może więcej!)

**Z fabryką:**
- 1 metoda × 10 linii switch = **10 linii** RAZ!
- Dodanie Ferrari = zmiana w **1 miejscu** (fabryka) + nowa klasa

To jest **DRY principle** - Don't Repeat Yourself!"

**Ty**: "Ale to nie wszystko! Z fabryką możemy..."

*[Pokazujesz na tablicy]*

```java
// ✅ Zrobić listę!
List<Samochod> salon = new ArrayList<>();
salon.add(FabrykaSamochodow.stworzSamochod("bmw"));
salon.add(FabrykaSamochodow.stworzSamochod("jaguar"));

// ✅ Iterować!
for (Samochod auto : salon) {
    auto.pokazSpecjalneFunkcje();  // Polimorfizm!
}

// ✅ Czytać z pliku/input!
String marka = scanner.nextLine();
Samochod auto = FabrykaSamochodow.stworzSamochod(marka);
```

**Ty**: "Bez fabryki? Niemożliwe! Bo każdy samochód to INNY typ!

**Czyli:**
- Switch/if-else sam w sobie nie jest zły
- **ZŁE** jest powtarzanie go w wielu miejscach!
- **DOBRE** jest scentralizowanie go w fabryce!

**Fabryka = if-else w JEDNYM miejscu + polimorfizm w RESZCIE kodu!**"

### [POKAZUJESZ UŻYCIE]

```java
public static void main(String[] args) {
```

**Ty**: "Teraz używamy fabryki..."

```java
    // ✅ PRZED (bez fabryki):
    Samochod bmw = new BMW();

    // ✅ PO (z fabryką):
    Samochod bmw = FabrykaSamochodow.stworzSamochod("bmw");
```

**Ty**: "Widzicie różnicę? Zamiast 'new BMW()' używamy fabryki!"

```java
    String[] marki = {"bmw", "jaguar", "bentley", "koenigsegg"};

    for (String marka : marki) {
        // ⭐ FABRYKA!
        Samochod auto = FabrykaSamochodow.stworzSamochod(marka);

        if (auto != null) {
            System.out.println(auto.getMarka());
            auto.jedz();
            auto.pokazSpecjalneFunkcje();
        }
    }
}
```

**Ty**: "Jedna pętla, fabryka tworzy różne auta. Koenigsegg? Bez problemu - automatycznie 3 funkcje!"

### [URUCHAMIASZ]

```bash
javac SalonDemo_KROK2_fabryka.java
java SalonDemo_KROK2_fabryka
```

**Ty**: "Działa! Każdy samochód, nawet Koenigsegg z 3 metodami!"

### [DEMONSTRACJA ZALET]

**Ty**: "Zobaczmy co zyskaliśmy..."

#### Demo 1: Case insensitive
```java
Samochod auto1 = FabrykaSamochodow.stworzSamochod("BMW");
Samochod auto2 = FabrykaSamochodow.stworzSamochod("bmw");
Samochod auto3 = FabrykaSamochodow.stworzSamochod("  Bmw  ");
// Wszystkie działają!
```

**Ty**: "Normalizacja w JEDNYM miejscu - wszędzie działa!"

#### Demo 2: Dodanie nowego auta

**Ty**: "Chcę dodać Ferrari. Ile miejsc zmieniam?"

*[Studenci: 2! Klasa + case w fabryce!]*

**Ty**: "TAK! 2 miejsca. Bez fabryki? 10 miejsc, wszędzie gdzie tworzę auta!"

#### Demo 3: Lista aut

```java
List<Samochod> salon = new ArrayList<>();
salon.add(FabrykaSamochodow.stworzSamochod("bmw"));
salon.add(FabrykaSamochodow.stworzSamochod("koenigsegg"));
```

**Ty**: "Lista działa! Polimorfizm + fabryka = perfekcja!"

---

## 📊 KROK 3: PORÓWNANIE (5 minut)

### [RYSUJESZ NA TABLICY]

```
╔═══════════════════════════════════════════════════════╗
║              EWOLUCJA KODU                            ║
╚═══════════════════════════════════════════════════════╝

WERSJA START: Bez interfejsu
───────────────────────────────
BMW bmw = new BMW();
bmw.aktywujTrybM();

Koenigsegg k = new Koenigsegg();
k.aktywujTryb1600KM();
k.wlaczSystemNitro();
k.sprawdzPredkoscMaksymalna();

❌ Problem: Każdy typ osobno, brak listy


WERSJA IF-ELSE: Próba uogólnienia
───────────────────────────────
if (marka.equals("bmw")) {
    BMW auto = new BMW();
    auto.aktywujTrybM();
} else if (marka.equals("koenigsegg")) {
    Koenigsegg auto = new Koenigsegg();
    auto.aktywujTryb1600KM();
    auto.wlaczSystemNitro();
    auto.sprawdzPredkoscMaksymalna();
}

❌ Problem: If-else wszędzie, duplikacja


WERSJA INTERFEJS: Polimorfizm
───────────────────────────────
Samochod bmw = new BMW();
Samochod k = new Koenigsegg();

Samochod[] salon = {bmw, k};
for (Samochod auto : salon) {
    auto.pokazSpecjalneFunkcje(); // każdy swoje!
}

✅ Lepiej, ale: nadal 'new BMW()', 'new Koenigsegg()'


WERSJA FABRYKA: Wzorzec!
───────────────────────────────
Samochod auto = FabrykaSamochodow.stworzSamochod("bmw");
auto.pokazSpecjalneFunkcje();

✅✅ IDEALNIE:
   - Interfejs (polimorfizm)
   - Fabryka (tworzenie)
   - Działa z Koenigseggiem (3 metody)!
```

---

## 🎓 KROK 4: PYTANIA I ODPOWIEDZI (5 minut)

### Częste pytania:

**Q**: "Dlaczego metoda statyczna?"
**A**: "Bo nie potrzebujemy stanu. To prosta funkcja: marka → samochód."

**Q**: "Dlaczego zwraca Samochod, nie BMW?"
**A**: "KLUCZOWE! Polimorfizm. Nie interesuje nas konkretna klasa, tylko interfejs."

**Q**: "A jak Koenigsegg ma 3 metody?"
**A**: "W pokazSpecjalneFunkcje() wywołuje wszystkie 3! Interfejs jest elastyczny."

**Q**: "To lepsze niż if-else?"
**A**: "TAK! If-else w jednym miejscu (fabryka), nie wszędzie."

**Q**: "A jak dodać Ferrari?"
**A**: "Klasa Ferrari + case w fabryce. 2 miejsca. Bez fabryki? Wszędzie!"

---

## ✅ PODSUMOWANIE (2 minuty)

**Ty**: "Co dzisiaj zrobiliśmy?

1. PROBLEM: If-else wszędzie, Koenigsegg z 3 metodami
2. KROK 1: Interfejs - polimorfizm, pokazSpecjalneFunkcje()
3. KROK 2: Fabryka - jedna metoda tworzy wszystko
4. WYNIK: Czysty kod, działa z egzotycznymi autami!

**To jest wzorzec Factory Method!**"

**Ty**: "Pytanie na koniec: A co jeśli chcemy tworzyć RODZINY aut?
Nie jeden samochód, ale Bentley Sedan + Bentley SUV razem?
To jest... Abstract Factory! Ale to następnym razem 😉"

---

## 📎 TIMELINE

| Czas | Faza | Co robisz |
|------|------|-----------|
| 0:00-0:02 | Intro | Przypominasz problem z if-else |
| 0:02-0:12 | Krok 1 | Piszesz interfejs Samochod |
| 0:12-0:14 | Demo 1 | Uruchamiasz, pokazujesz polimorfizm |
| 0:14-0:16 | Transition | "Ale nadal 'new BMW()'... Fabryka!" |
| 0:16-0:30 | Krok 2 | Piszesz FabrykaSamochodow |
| 0:30-0:32 | Demo 2 | Uruchamiasz, pokazujesz działanie |
| 0:32-0:37 | Zalety | Pokazujesz case-insensitive, lista, itp. |
| 0:37-0:42 | Porównanie | Rysujesz schemat ewolucji na tablicy |
| 0:42-0:47 | Q&A | Odpowiadasz na pytania |
| 0:47-0:50 | Podsumowanie | Recap + zapowiedź Abstract Factory |

**Łącznie: 45-50 minut**

---

## 🎯 KLUCZOWE MOMENTY

### Moment AHA! #1 (min 8):
```java
auto.pokazSpecjalneFunkcje(); // ← każdy robi SWOJE!
```
**Mówisz**: "Jedna metoda, różne implementacje! To jest polimorfizm!"

### Moment AHA! #2 (min 18):
```java
public static Samochod stworzSamochod(String marka)
                ↑
          ZWRACA INTERFEJS!
```
**Mówisz**: "Zwraca Samochod, nie BMW! To jest klucz!"

### Moment AHA! #3 (min 25):
```java
// Koenigsegg z 3 metodami - DZIAŁA!
Samochod k = FabrykaSamochodow.stworzSamochod("koenigsegg");
k.pokazSpecjalneFunkcje(); // automatycznie wszystkie 3!
```
**Mówisz**: "Egzotyczny samochód? Bez problemu! Fabryka się tym nie przejmuje!"

---

## 🆘 CO JEŚLI...

### Studenci się gubią przy interfejsie?
**Rozwiązanie**: Wróć do przykładu. "BMW ma tryb M, Jaguar ma ryk. Różne, prawda?
Ale możemy to nazwać 'pokazSpecjalneFunkcje()' - nazwa taka sama, zachowanie różne!"

### Nie rozumieją po co fabryka?
**Rozwiązanie**: Pokaż SalonDemo_IFELSE.java znowu. "Zobacz - if-else 3 razy!
Z fabryką? Raz!"

### Pytają "dlaczego static"?
**Rozwiązanie**: "Spróbuj bez static - musisz robić 'new FabrykaSamochodow().stworzSamochod()'.
Po co obiekt? To prosta funkcja!"

---

**GOTOWE!** Masz kompletny scenariusz wprowadzenia wzorca Fabryka! 🎓🏭
