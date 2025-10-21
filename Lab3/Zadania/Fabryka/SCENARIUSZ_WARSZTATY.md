# 🎬 SCENARIUSZ WARSZTATÓW: Wzorce Fabryka

**Temat**: Od if-else do wzorców projektowych
**Czas**: 45-60 minut
**Poziom**: Średniozaawansowany
**Cel**: Pokazać ewolucję kodu i DLACZEGO wzorce są potrzebne

---

# 📋 PRZYGOTOWANIE

## Przed warsztatami:
1. ✅ Otwórz edytor kodu (IntelliJ/VSCode/Notepad++)
2. ✅ Przygotuj puste pliki: `Wersja1.java`, `Wersja2.java`, `Wersja3.java`
3. ✅ Terminal obok edytora (do kompilacji na żywo)
4. ✅ Wyświetl cennik samochodów (slajd lub tablica)

## Materiały dla studentów:
- Treść zadania (TrescZadania.md)
- Pusta kartka do notowania

---

# 🎯 WPROWADZENIE (5 minut)

## [SLAJD lub TABLICA]

```
═══════════════════════════════════════
  🚗 SALON SAMOCHODOWY - PROBLEM
═══════════════════════════════════════

Mamy luksusowy salon samochodowy:
  🏎️  BMW M5          →  300 000 zł
  🐆 Jaguar F-Type   →  280 000 zł
  👑 Bentley Continental GT → 850 000 zł
  ⚡ Koenigsegg Jesko → 12 000 000 zł

ZADANIE: Napisz system obsługi salonu
```

## [CO MÓWISZ]

**Ty**: "Dzień dobry! Dzisiaj będziemy programować system dla salonu samochodowego.
Sprzedajemy tylko luksusowe marki - BMW, Jaguar, Bentley, i coś NAPRAWDĘ egzotycznego -
szwedzkie Koenigsegg za 12 milionów złotych!"

*[Pokaż cennik]*

**Ty**: "Zobaczycie 3 wersje kodu:
1. WERSJA 1 - najprostsza, z if-else (TAK ROBICIE TERAZ)
2. WERSJA 2 - z wzorcem Factory Method (LEPIEJ)
3. WERSJA 3 - z wzorcem Abstract Factory (PROFESJONALNIE)

Każdą wersję napiszemy razem, od zera. Gotowi? Zaczynamy!"

---

# 📝 KROK 1: NAJPROŚCIEJ JAK SIĘ DA (10 minut)

## [OTWIERASZ PLIK: Wersja1.java]

**Ty**: "Zacznijmy od NAJPROSTSZEGO rozwiązania. Nie myślimy o wzorcach,
po prostu piszemy kod, który działa. Jak byście to zrobili?"

*[Czekaj na odpowiedzi studentów - pewnie powiedzą: if-else]*

**Ty**: "Dokładnie! If-else. Piszmy!"

## [CO PISZESZ - LINIJKA PO LINIJCE]

```java
// KOMENTUJ NA BIEŻĄCO!

public class Wersja1 {
    public static void main(String[] args) {
```

**Ty** *(pisząc)*: "Main, standardowo..."

```java
        String marka = "bmw";
```

**Ty**: "Klient przychodzi i mówi: chcę BMW!"

```java
        // ❌ NAJPROŚCIEJ: IF-ELSE
        if (marka.equals("bmw")) {
```

**Ty**: "Jeśli BMW, to co robimy?"

```java
            System.out.println("BMW M5");
            System.out.println("Cena: 300000 zł");
            System.out.println("Jedzie! Vroom!");
```

**Ty**: "Pokazujemy auto, cenę, jedziemy. Proste!"

```java
        } else if (marka.equals("jaguar")) {
            System.out.println("Jaguar F-Type");
            System.out.println("Cena: 280000 zł");
            System.out.println("Jedzie! Roar!");
```

**Ty**: "To samo dla Jaguara... widzicie już problem?"

*[Czekaj - ktoś powie: duplikacja!]*

```java
        } else if (marka.equals("bentley")) {
            System.out.println("Bentley Continental GT");
            System.out.println("Cena: 850000 zł");
            System.out.println("Jedzie! Elegancko!");
        } else if (marka.equals("koenigsegg")) {
            System.out.println("Koenigsegg Jesko");
            System.out.println("Cena: 12000000 zł");
            System.out.println("Jedzie! MEGA FAST!");
        }
    }
}
```

## [URUCHAMIASZ]

```bash
javac Wersja1.java
java Wersja1
```

**Wyjście:**
```
BMW M5
Cena: 300000 zł
Jedzie! Vroom!
```

**Ty**: "Działa! Ale..."

## [ZATRZYMUJESZ SIĘ - MOMENT REFLEKSJI]

**Ty**: "Pytanie do was: co się stanie, jak będę chciał wyświetlić samochód
w INNYM miejscu programu?"

*[Student]: Muszę skopiować ten sam if-else!*

**Ty**: "DOKŁADNIE! Zobaczcie:"

## [DODAJESZ DRUGĄ METODĘ]

```java
// Metoda 2 - obliczanie ceny
public static void obliczCene(String marka) {
    // ❌ ZNOWU TO SAMO!
    if (marka.equals("bmw")) {
        System.out.println("Do zapłaty: 300000 zł");
    } else if (marka.equals("jaguar")) {
        System.out.println("Do zapłaty: 280000 zł");
    } else if (marka.equals("bentley")) {
        System.out.println("Do zapłaty: 850000 zł");
    } else if (marka.equals("koenigsegg")) {
        System.out.println("Do zapłaty: 12000000 zł");
    }
}
```

**Ty**: "Widzicie? DUPLIKACJA! Ten sam if-else w 2 miejscach.
A co jak dodam Ferrari? Muszę zmienić w 10 miejscach!"

## [PISZESZ NA TABLICY - PROBLEMY]

```
❌ PROBLEMY:
1. Duplikacja kodu (if-else wszędzie)
2. Trudno dodać nową markę
3. Łatwo o błędy (pomylić cenę)
4. Nie ma polimorfizmu
```

**Ty**: "Potrzebujemy czegoś lepszego!"

---

# 🔧 KROK 2: WPROWADZENIE INTERFEJSU (8 minut)

## [OTWIERASZ NOWY PLIK: Wersja2.java]

**Ty**: "Najpierw pomyślmy: co jest WSPÓLNE dla wszystkich aut?"

*[Czekaj - studenci: marka, cena, jeżdżą]*

**Ty**: "Dokładnie! Każde auto ma markę, cenę i może jechać. To brzmi jak... INTERFEJS!"

## [PISZESZ INTERFEJS]

```java
// ✅ WSPÓLNY INTERFEJS
interface Samochod {
```

**Ty**: "Interfejs Samochod - kontrakt dla wszystkich aut"

```java
    String getMarka();
    int getCena();
    void jedz();
}
```

**Ty**: "Trzy rzeczy: pobierz markę, pobierz cenę, jedź. KAŻDY samochód to musi mieć!"

## [PISZESZ PIERWSZĄ KLASĘ]

```java
class BMW implements Samochod {
```

**Ty**: "BMW implementuje interfejs Samochod"

```java
    public String getMarka() {
        return "BMW M5";
    }
```

**Ty** *(szybko)*: "getMarka - zwraca nazwę"

```java
    public int getCena() {
        return 300000;
    }
```

**Ty**: "getCena - zwraca cenę jako liczbę, nie String!"

```java
    public void jedz() {
        System.out.println("🏎️ BMW jedzie! Vroom!");
    }
}
```

**Ty**: "I metoda jedz(). Proste!"

## [PRZYŚPIESZASZ - RESZTA KLAS]

**Ty**: "Reszta analogicznie - piszę szybko!"

```java
class Jaguar implements Samochod {
    public String getMarka() { return "Jaguar F-Type"; }
    public int getCena() { return 280000; }
    public void jedz() {
        System.out.println("🐆 Jaguar jedzie! Roar!");
    }
}

class Bentley implements Samochod {
    public String getMarka() { return "Bentley Continental GT"; }
    public int getCena() { return 850000; }
    public void jedz() {
        System.out.println("👑 Bentley jedzie! Luksusowo!");
    }
}

class Koenigsegg implements Samochod {
    public String getMarka() { return "Koenigsegg Jesko"; }
    public int getCena() { return 12000000; }
    public void jedz() {
        System.out.println("⚡ Koenigsegg! 1600 KM!!!");
    }
}
```

## [ZATRZYMUJESZ SIĘ]

**Ty**: "OK, mamy interfejs i 4 klasy. Ale nadal mam problem - JAK JE TWORZYĆ?"

## [POKAZUJESZ PROBLEM]

```java
public static void main(String[] args) {
    String wybor = "bmw";

    // ❌ NADAL IF-ELSE!
    if (wybor.equals("bmw")) {
        Samochod auto = new BMW();
        auto.jedz();
    } else if (wybor.equals("jaguar")) {
        Samochod auto = new Jaguar();
        auto.jedz();
    }
    // itd...
}
```

**Ty**: "Widzicie? Mamy interfejs, ale NADAL if-else przy tworzeniu!
Potrzebujemy FABRYKI!"

---

# 🏭 KROK 3: WZORZEC FACTORY METHOD (12 minut)

**Ty**: "Teraz magia! Wzorzec FABRYKA - Factory Method!"

## [PISZESZ KLASĘ FABRYKI]

```java
// ✅ TO JEST WZORZEC FABRYKA!
class FabrykaSamochodow {
```

**Ty**: "Klasa FabrykaSamochodow - jej JEDYNE zadanie to tworzyć auta!"

```java
    public static Samochod stworzSamochod(String marka) {
```

**Ty**: "Jedna metoda! 'Daj mi markę, zwrócę Ci samochód'. UWAGA: zwraca INTERFEJS!"

*[Podkreśl to na tablicy: ZWRACA INTERFEJS, NIE KONKRETNĄ KLASĘ]*

```java
        switch (marka.toLowerCase()) {
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

**Ty**: "Switch - prosty wybór. Jeden if-else, ale w JEDNYM miejscu!"

## [TERAZ UŻYWASZ FABRYKI]

```java
public static void main(String[] args) {
```

**Ty**: "Teraz patrzcie jak CZYSTO wygląda kod!"

```java
    // ✅ UŻYWAMY FABRYKI!
    Samochod auto1 = FabrykaSamochodow.stworzSamochod("bmw");
    auto1.jedz();

    Samochod auto2 = FabrykaSamochodow.stworzSamochod("koenigsegg");
    auto2.jedz();
```

**Ty**: "DWA RAZY ta sama linijka! Różni się tylko parametrem!"

## [POKAZUJESZ MOC POLIMORFIZMU]

```java
    // ✅ POLIMORFIZM - lista różnych aut!
    List<Samochod> salon = new ArrayList<>();
    salon.add(FabrykaSamochodow.stworzSamochod("bmw"));
    salon.add(FabrykaSamochodow.stworzSamochod("jaguar"));
    salon.add(FabrykaSamochodow.stworzSamochod("bentley"));
```

**Ty**: "PATRZCIE! Lista różnych aut jako TEN SAM TYP! To jest polimorfizm!"

```java
    // Obliczamy wartość salonu
    int wartosc = 0;
    for (Samochod auto : salon) {
        wartosc += auto.getCena();
    }
    System.out.println("Wartość salonu: " + wartosc + " zł");
}
```

**Ty**: "I możemy po nich iterować jak po JEDNYM TYPIE!"

## [KOMPILACJA I URUCHOMIENIE]

```bash
javac Wersja2.java
java Wersja2
```

## [MOMENT REFLEKSJI - PISZESZ NA TABLICY]

```
✅ ZALETY FACTORY METHOD:
1. Jedna metoda tworzy wszystkie auta
2. If-else TYLKO w jednym miejscu
3. Polimorfizm - lista różnych aut
4. Łatwo dodać nową markę (1 miejsce zmian)
```

**Ty**: "Pytanie: jak dodać Ferrari?"

*[Student]: Dodać klasę Ferrari i case w switch!*

**Ty**: "TAK! Tylko 2 miejsca. W wersji 1 było 10 miejsc!"

---

# 🎨 KROK 4: ABSTRACT FACTORY (15 minut)

**Ty**: "OK, Factory Method jest super. Ale co jeśli chcemy tworzyć
NIE POJEDYNCZE auta, ale CAŁE RODZINY aut? SEGMENTY?"

## [RYSUJ NA TABLICY]

```
SEGMENT LUXURY (luksusowe):
  - Bentley Sedan
  - Bentley SUV

SEGMENT SPORT (sportowe):
  - Koenigsegg Coupe
  - Koenigsegg Roadster
```

**Ty**: "Widzicie? Mamy SEGMENTY. W każdym segmencie jest sedan i SUV,
ale z TEJ SAMEJ marki! To jest RODZINA produktów!"

## [NOWY PLIK: Wersja3.java]

### [NAJPIERW NOWE KLASY - DWA MODELE NA MARKĘ]

```java
// RODZINA BENTLEY (Luxury)
class BentleySedan implements Samochod {
    public String getMarka() { return "Bentley Flying Spur"; }
    public int getCena() { return 950000; }
    public void jedz() {
        System.out.println("👑 Bentley Sedan - limuzyna!");
    }
}

class BentleySUV implements Samochod {
    public String getMarka() { return "Bentley Bentayga"; }
    public int getCena() { return 1100000; }
    public void jedz() {
        System.out.println("👑 Bentley SUV - terenowy luksus!");
    }
}
```

**Ty**: "Dwa modele Bentley - sedan i SUV. RODZINA!"

```java
// RODZINA KOENIGSEGG (Sport)
class KoenigseggCoupe implements Samochod {
    public String getMarka() { return "Koenigsegg Jesko"; }
    public int getCena() { return 12000000; }
    public void jedz() {
        System.out.println("⚡ Koenigsegg Coupe - hipersamochód!");
    }
}

class KoenigseggRoadster implements Samochod {
    public String getMarka() { return "Koenigsegg Regera"; }
    public int getCena() { return 11500000; }
    public void jedz() {
        System.out.println("⚡ Koenigsegg Roadster - bez dachu!");
    }
}
```

### [TERAZ INTERFEJS FABRYKI]

**Ty**: "Teraz KLUCZOWE! Fabryka abstrakcyjna - interfejs!"

```java
// ✅ ABSTRACT FACTORY - INTERFEJS!
interface AutoFactory {
```

**Ty**: "To NIE jest konkretna fabryka, to INTERFEJS fabryki!"

```java
    Samochod createSedan();
    Samochod createSUV();
}
```

**Ty**: "Dwie metody - utwórz sedan, utwórz SUV. KAŻDA fabryka to musi mieć!"

### [KONKRETNE FABRYKI]

```java
// ✅ Fabryka dla segmentu LUXURY
class LuxuryFactory implements AutoFactory {
```

**Ty**: "Konkretna fabryka dla luksusowych aut!"

```java
    public Samochod createSedan() {
        return new BentleySedan();
    }

    public Samochod createSUV() {
        return new BentleySUV();
    }
}
```

**Ty**: "Tworzy RODZINĘ Bentley! Wszystko spójne!"

```java
// ✅ Fabryka dla segmentu SPORT
class SportFactory implements AutoFactory {
    public Samochod createSedan() {
        return new KoenigseggCoupe();  // Sport ma coupe zamiast sedana
    }

    public Samochod createSUV() {
        return new KoenigseggRoadster();  // Sport ma roadster zamiast SUV
    }
}
```

**Ty**: "Druga fabryka - Koenigsegg! Też RODZINA!"

### [APLIKACJA KLIENCKA]

**Ty**: "Teraz najważniejsze - kod który UŻYWA fabryki!"

```java
public static void main(String[] args) {
```

**Ty**: "Wybieramy segment - załóżmy LUXURY"

```java
    // ✅ Wybieramy FABRYKĘ (segment)
    AutoFactory factory = new LuxuryFactory();
```

**Ty**: "UWAGA! Typ to AutoFactory (interfejs), ale obiekt to LuxuryFactory!"

```java
    // ✅ Tworzymy RODZINĘ produktów
    Samochod sedan = factory.createSedan();
    Samochod suv = factory.createSUV();
```

**Ty**: "I teraz patrzcie - tworzymy sedan i SUV z TEJ SAMEJ fabryki!"

```java
    System.out.println("=== SEGMENT LUXURY ===");
    System.out.println("Sedan: " + sedan.getMarka());
    sedan.jedz();
    System.out.println("SUV: " + suv.getMarka());
    suv.jedz();
```

**Ty**: "Wszystko Bentley - SPÓJNE!"

### [ZMIANA SEGMENTU]

```java
    // ✅ Zmiana segmentu? Jedna linijka!
    factory = new SportFactory();
```

**Ty**: "Chcę sport? JEDNA linijka! Zmieniam fabrykę!"

```java
    sedan = factory.createSedan();
    suv = factory.createSUV();

    System.out.println("\n=== SEGMENT SPORT ===");
    System.out.println("Coupe: " + sedan.getMarka());
    sedan.jedz();
    System.out.println("Roadster: " + suv.getMarka());
    suv.jedz();
}
```

**Ty**: "Teraz wszystko Koenigsegg! Też SPÓJNE!"

## [URUCHOMIENIE]

```bash
javac Wersja3.java
java Wersja3
```

**Wyjście:**
```
=== SEGMENT LUXURY ===
Sedan: Bentley Flying Spur
👑 Bentley Sedan - limuzyna!
SUV: Bentley Bentayga
👑 Bentley SUV - terenowy luksus!

=== SEGMENT SPORT ===
Coupe: Koenigsegg Jesko
⚡ Koenigsegg Coupe - hipersamochód!
Roadster: Koenigsegg Regera
⚡ Koenigsegg Roadster - bez dachu!
```

---

# 📊 KROK 5: PORÓWNANIE WSZYSTKICH WERSJI (5 minut)

## [RYSUJESZ NA TABLICY - DUŻY SCHEMAT]

```
╔═════════════════════════════════════════════════════════╗
║              EWOLUCJA KODU                              ║
╚═════════════════════════════════════════════════════════╝

WERSJA 1: BEZ WZORCA
───────────────────────────────────────
if (marka.equals("bmw")) { ... }
else if (marka.equals("jaguar")) { ... }

❌ Problemy:
   - If-else w KAŻDEJ metodzie
   - Duplikacja kodu
   - Brak polimorfizmu


WERSJA 2: FACTORY METHOD
───────────────────────────────────────
Samochod auto = FabrykaSamochodow.stworzSamochod("bmw");

✅ Zalety:
   - If-else TYLKO w jednym miejscu
   - Polimorfizm (List<Samochod>)
   - Łatwe dodawanie marek


WERSJA 3: ABSTRACT FACTORY
───────────────────────────────────────
AutoFactory factory = new LuxuryFactory();
Samochod sedan = factory.createSedan();
Samochod suv = factory.createSUV();

✅✅ Zalety:
   - Tworzy RODZINY produktów
   - Wszystko spójne (Bentley lub Koenigsegg)
   - Zmiana segmentu = jedna linijka
```

---

# 🎓 KROK 6: KIEDY UŻYWAĆ? (3 minuty)

**Ty**: "Ostatnie pytanie - KIEDY używać każdego wzorca?"

## [PISZESZ NA TABLICY]

```
KIEDY UŻYWAĆ?

Factory Method:
  ✅ Masz kilka podobnych klas
  ✅ Tworzenie jest proste
  ✅ Jeden typ produktu (samochody)

  Przykład: Sklep z samochodami (różne marki)

Abstract Factory:
  ✅ Masz RODZINY produktów
  ✅ Produkty muszą być SPÓJNE
  ✅ Wiele typów produktów (sedan + SUV)

  Przykład: System GUI (Windows/Mac -> Button+Window)
           Salon samochodowy (Luxury/Sport -> Sedan+SUV)

Bez wzorca:
  ✅ Masz tylko 2-3 klasy
  ✅ Projekt jest bardzo prosty
  ✅ Nie będzie rozszerzany
```

---

# 💡 KROK 7: ZADANIE DLA STUDENTÓW (2 minuty)

**Ty**: "Teraz wasze zadanie - macie 30 minut!"

## [ROZDAJESZ KARTKI Z ZADANIEM]

**Ty**: "Dostajecie treść zadania. Macie zaimplementować salon rowerów używając:
1. Wersja podstawowa - Factory Method
2. Wersja zaawansowana - Abstract Factory (segmenty: miejski, górski)

Powodzenia!"

---

# ✅ ZAKOŃCZENIE (2 minuty)

**Ty**: "Podsumowanie:
1. Zaczęliśmy od if-else - DZIAŁA, ale źle
2. Dodaliśmy interfejs - lepiej
3. Factory Method - profesjonalnie
4. Abstract Factory - dla rodzin produktów

Wzorce to NIE KOD dla kodu - to rozwiązania PRAWDZIWYCH problemów!"

**Ty**: "Pytania?"

---

# 📎 ZAŁĄCZNIKI DLA NAUCZYCIELA

## Czasy (łącznie ~60 minut):
- Wprowadzenie: 5 min
- Wersja 1 (if-else): 10 min
- Wersja 2 (interfejs): 8 min
- Factory Method: 12 min
- Abstract Factory: 15 min
- Porównanie: 5 min
- Kiedy używać: 3 min
- Zadanie: 2 min

## Kluczowe momenty "AHA!":
1. ⚡ Duplikacja if-else w wersji 1
2. ⚡ `return new BMW()` ale typ `Samochod` (polimorfizm!)
3. ⚡ Zmiana fabryki = jedna linijka (Abstract Factory)

## Pytania które możesz zadać:
- "Co się stanie jak dodam Ferrari?" (po wersji 1)
- "Jaki typ zwraca metoda stworzSamochod()?" (Samochod - interfejs!)
- "Ile miejsc muszę zmienić żeby dodać markę?" (Factory: 1, bez wzorca: wiele)

## Częste błędy studentów:
- Mylenie Factory Method z Abstract Factory
- Zwracanie konkretnej klasy zamiast interfejsu
- Tworzenie fabryki dla 2 klas (overkill)

---

# 🎯 SUKCES = Student rozumie DLACZEGO, nie tylko JAK!

Pamiętaj: Nie uczysz wzorców, uczysz **rozwiązywania problemów**!
