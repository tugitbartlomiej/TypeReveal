#  Warsztaty: Wzorce Fabryka - Materiały Dydaktyczne

**Temat:** Factory Method i Abstract Factory na przykładzie Salonu Bajtazara

**Czas:** 60-80 minut (2 części: Factory Method + Abstract Factory)

---

##  Struktura Materiałów

### 1⃣ `Kod/` - Przykłady Java (ponumerowane w kolejności prowadzenia zajęć)

Pliki Java pokazujące ewolucję od problemu do rozwiązania:

| Plik | Opis | Czas | Co pokazuje |
|------|------|------|-------------|
| **01_SalonDemo_START.java** | Kod startowy - punkt wyjścia | Min 0-10 | Problem: każdy samochód to inny typ, brak wspólnego interfejsu |
| **02_SalonDemo_IFELSE.java** | Próba rozwiązania z if-else | Min 10-15 | Problem: duplikacja kodu, if-else wszędzie |
| **03_SalonDemo_INTERFEJS.java** | Wprowadzenie interfejsu | Min 15-30 | Rozwiązanie: interfejs Samochod + polimorfizm |
| **04_SalonDemo_FACTORY_METHOD.java** | Wzorzec Factory Method | Min 30-50 | Rozwiązanie: fabryka tworzy obiekty |
| **05_SalonDemo_ABSTRACT_FACTORY.java** | Wzorzec Abstract Factory | Min 50-80 | Rozwiązanie: fabryka tworzy rodziny obiektów |

**Podfolder:**
- `Archiwum_Przyklady_Kawiarnia/` - wcześniejsze przykłady z kawiarni (do wglądu)

---

### 2⃣ `SkryptProwadzacego/` - Scenariusze dla nauczyciela

Szczegółowe scenariusze krok-po-kroku z dokładnym dialogiem:

| Plik | Czas | Co zawiera |
|------|------|------------|
| **01_SCENARIUSZ_INTERFEJS_I_FACTORY.md** | 30-40 min | Jak wprowadzić interfejs + Factory Method |
| **02_SCENARIUSZ_ABSTRACT_FACTORY.md** | 25-30 min | Jak wprowadzić Abstract Factory |

**Co jest w scenariuszach:**
-  Dokładny dialog (co mówisz, jak wyjaśniasz)
-  Timeline (minuty dla każdej fazy)
-  Kluczowe momenty "AHA!"
-  Rysunki na tablicy
-  Odpowiedzi na typowe pytania
-  Co robić gdy studenci się gubią

**Podfolder:**
- `Archiwum_Stare_Wersje/` - wcześniejsze wersje scenariuszy (nieaktualne)

---

### 3⃣ `Zadania/` - Treści zadań dla studentów

Zadania w stylu olimpiad programistycznych (Bajtocja):

| Plik | Poziom | Opis |
|------|--------|------|
| **ZADANIE_01_PODSTAWOWE.md** | Podstawowy | Zadanie startowe - stwórz klasy samochodów, zobacz problem |
| **ZADANIE_02_OI_STYLE.md** | Średni | Zadanie w stylu OI z podproblemami i punktacją |

**Zadania:**
- Nie wspominają o wzorcach projektowych na początku
- Pokazują problem, który rozwiąże wzorzec
- W stylu Bajtocja/Bajtazar (polskie olimpiady)

---

### 4⃣ `Prezentacja/` - Slajdy (opcjonalne, obecnie puste)

Folder na ewentualne slajdy PowerPoint/PDF do pokazania na ekranie.

---

##  Kluczowe Koncepcje

### Problem: Koenigsegg - samochód egzotyczny

**Koenigsegg Jesko** ma **3 specjalne metody** (vs 1 dla innych aut):
```java
koenigsegg.aktywujTryb1600KM();
koenigsegg.wlaczSystemNitro();
koenigsegg.sprawdzPredkoscMaksymalna();
```

**Dlaczego to problem?**
- Z if-else: musisz wywołać 3 metody w każdym miejscu gdzie obsługujesz Koenigsegg
- Duplikacja kodu
- Niemożliwe do uogólnienia

**Jak rozwiązuje interfejs:**
```java
interface Samochod {
    void pokazSpecjalneFunkcje(); // Każdy implementuje inaczej!
}

class Koenigsegg implements Samochod {
    @Override
    public void pokazSpecjalneFunkcje() {
        // Wewnątrz wywołuje WSZYSTKIE 3 metody!
        aktywujTryb1600KM();
        wlaczSystemNitro();
        sprawdzPredkoscMaksymalna();
    }
}
```

**Rezultat:**
```java
Samochod auto = new Koenigsegg();
auto.pokazSpecjalneFunkcje(); // Automatycznie wywołuje wszystkie 3!
```

---

##  Jak Prowadzić Warsztaty

### Część 1: Factory Method (30-40 minut)

1. **Intro (5 min)**: Pokaż `01_SalonDemo_START.java` - problem
2. **Problem if-else (5 min)**: Pokaż `02_SalonDemo_IFELSE.java` - duplikacja
3. **Interfejs (10 min)**: Pisz `03_SalonDemo_INTERFEJS.java` na żywo
4. **Factory Method (15 min)**: Pisz `04_SalonDemo_FACTORY_METHOD.java` na żywo
5. **Porównanie (5 min)**: Pokaż ewolucję na tablicy

**Użyj:** `SkryptProwadzacego/01_SCENARIUSZ_INTERFEJS_I_FACTORY.md`

### Część 2: Abstract Factory (25-30 minut)

1. **Intro (5 min)**: Problem - jak tworzyć RODZINY produktów?
2. **Interfejsy (8 min)**: Sedan i SUV - różne typy
3. **Abstract Factory (10 min)**: Interfejs fabryki + konkretne fabryki
4. **Demonstracja (7 min)**: Pokazanie spójności rodzin
5. **Porównanie (5 min)**: Factory Method vs Abstract Factory

**Użyj:** `SkryptProwadzacego/02_SCENARIUSZ_ABSTRACT_FACTORY.md`

---

##  Ewolucja Kodu (Pełen Obraz)

```
╔═══════════════════════════════════════════════════════╗
║        EWOLUCJA - OD PROBLEMU DO ROZWIĄZANIA         ║
╚═══════════════════════════════════════════════════════╝

01_START: Bez interfejsu
────────────────────────
BMW bmw = new BMW();
Jaguar jaguar = new Jaguar();
Koenigsegg k = new Koenigsegg();

 Problem: Każdy typ osobno, brak listy
 Koenigsegg: 3 metody do wywołania


02_IFELSE: Próba uogólnienia
─────────────────────────
if (marka.equals("bmw")) {
    BMW auto = new BMW();
    auto.aktywujTrybM();
} else if (marka.equals("koenigsegg")) {
    Koenigsegg auto = new Koenigsegg();
    auto.aktywujTryb1600KM();      // 3 linie!
    auto.wlaczSystemNitro();
    auto.sprawdzPredkoscMaksymalna();
}

 Problem: If-else wszędzie, duplikacja


03_INTERFEJS: Polimorfizm
──────────────────────────
Samochod bmw = new BMW();
Samochod k = new Koenigsegg();

Samochod[] salon = {bmw, k};
for (Samochod auto : salon) {
    auto.pokazSpecjalneFunkcje(); // każdy swoje!
}

 Lepiej: polimorfizm działa
 Nadal: 'new BMW()', 'new Koenigsegg()'


04_FACTORY_METHOD: Wzorzec!
────────────────────────────
Samochod auto = FabrykaSamochodow.stworzSamochod("bmw");
auto.pokazSpecjalneFunkcje();

 IDEALNIE:
   - Interfejs (polimorfizm)
   - Fabryka (tworzenie)
   - Koenigsegg działa automatycznie!


05_ABSTRACT_FACTORY: Rodziny!
──────────────────────────────
FabrykaSamochodowAbstract fabryka = ProducentFabryk.getFabryka("bmw");
Sedan sedan = fabryka.stworzSedan();   // BMW Sedan
SUV suv = fabryka.stworzSUV();         // BMW SUV

 PERFEKCJA:
   - Rodziny produktów (Sedan + SUV)
   - Gwarantowana spójność (oba BMW!)
   - Łatwa zamiana rodziny
```

---

##  Kluczowe Pytania dla Studentów

### Po kodzie START:
- "Jak zrobić listę wszystkich aut?" (Nie da się - różne typy!)
- "Koenigsegg ma 3 metody - jak to uprościć?" (Interface!)

### Po kodzie IFELSE:
- "Co się stanie gdy dodamy Ferrari?" (Zmiana wszędzie!)
- "Ile razy powtarzasz ten sam if-else?" (3+ razy!)

### Po kodzie INTERFEJS:
- "Jak Koenigsegg wywołuje 3 metody?" (W pokazSpecjalneFunkcje()!)
- "Nadal piszemy 'new BMW()' - czy to problem?" (Tak!)

### Po kodzie FACTORY_METHOD:
- "Ale to nadal switch - jaka różnica?" (Switch RAZ, nie wszędzie!)
- "Zwraca Samochod czy BMW?" (Samochod - interfejs!)

### Po kodzie ABSTRACT_FACTORY:
- "Co jeśli przypadkowo zrobię BMW Sedan + Bentley SUV?" (Niemożliwe!)
- "Kiedy używać Factory Method, a kiedy Abstract Factory?" (1 produkt vs rodzina!)

---

##  Punkty Kontrolne

Po warsztatach studenci powinni:

- [ ] Rozumieć **problem if-else hell** (duplikacja, brak polimorfizmu)
- [ ] Wiedzieć jak **interfejs umożliwia polimorfizm**
- [ ] Rozumieć że `pokazSpecjalneFunkcje()` to **uniform interface** dla różnych zachowań
- [ ] Wiedzieć czym jest **Factory Method** i kiedy go używać
- [ ] Rozumieć różnicę między **Factory Method a Abstract Factory**
- [ ] Umieć **dodać nową markę** bez zmiany całego kodu
- [ ] Wiedzieć że fabryka zwraca **interfejs, nie konkretną klasę**

---

##  Dla Nauczyciela

### Najważniejsze momenty:

1. **"Koenigsegg z 3 metodami"** - kluczowy przykład dlaczego if-else nie działa
2. **"pokazSpecjalneFunkcje()"** - moment AHA! jak ujednolicić różne zachowania
3. **"Zwraca INTERFEJS!"** - fabryka nie zwraca BMW, tylko Samochod
4. **"Switch RAZ, nie wszędzie"** - różnica między fabryką a if-else wszędzie

### Częste błędy studentów:

- Myślą że fabryka to tylko "if-else w innym miejscu"
  → Wyjaśnij: if-else RAZ + polimorfizm w reszcie kodu!

- Nie widzą różnicy między Factory Method a Abstract Factory
  → Pokaż: 1 produkt vs rodzina produktów

- Pytają "dlaczego static?"
  → Bo to prosta funkcja, nie potrzebuje stanu

---

##  Materiały Dodatkowe

### Polecane do przeczytania:
- "Design Patterns" - Gang of Four (Factory Method, Abstract Factory)
- "Head First Design Patterns" - Freeman & Freeman (rozdział 4)

### Przykłady z życia:
- **Factory Method**: `DocumentFactory.create("pdf")` → PDFDocument
- **Abstract Factory**: `GUIFactory` tworzy Button + Checkbox + Menu (wszystkie w tym samym stylu)

---

##  Historia Zmian

- **2024-10-22**: Uporządkowanie struktury, numeracja plików
- **2024-10-22**: Zmiana "Salon Bajtka" → "Salon Bajtazara"
- **2024-10-21**: Dodanie przykładu Koenigsegg (3 metody)
- **2024-10-21**: Stworzenie scenariuszy dla nauczyciela

---

**Powodzenia na warsztatach!** 

*Jeśli masz pytania lub sugestie, kontakt: [twój email]*
