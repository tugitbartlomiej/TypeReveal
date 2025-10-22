# System Sprawdzania - Salon Samochodowy

**Automatyczny judge dla zadania OI**

---

## Grupy testów

### Grupa 0: Przykład (0 punktów)
**Testy:** 1
**Opis:** Test z przykładu w treści zadania
**Oczekiwane wyjście:** Dokładnie jak w przykładzie

---

### Grupa 1: Interfejs i podstawowa klasa (10 punktów)
**Testy:** 1oa, 1ob, 1oc
**Ograniczenia:** Sprawdzenie tylko klasy BMW

#### Test 1oa (3 pkt):
```java
// Sprawdzenie istnienia interfejsu
assert Samochod.class.isInterface();
assert Samochod.class.getDeclaredMethods().length == 3;
```

#### Test 1ob (4 pkt):
```java
// Sprawdzenie implementacji BMW
BMW bmw = new BMW();
assert bmw instanceof Samochod;
assert bmw.getMarka().equals("BMW M5");
assert bmw.getCena() == 300000;
```

#### Test 1oc (3 pkt):
```java
// Sprawdzenie metody wyswietlInfo
BMW bmw = new BMW();
ByteArrayOutputStream output = new ByteArrayOutputStream();
System.setOut(new PrintStream(output));
bmw.wyswietlInfo();
String result = output.toString().trim();
assert result.equals("BMW M5: 300000 zl");
```

**Punktacja:**
- Wszystkie testy zaliczone: 10 pkt
- 2 z 3 testów: 6 pkt
- 1 z 3 testów: 3 pkt
- 0 testów: 0 pkt

---

### Grupa 2: Wszystkie klasy samochodów (20 punktów)
**Testy:** 2oa, 2ob, 2oc, 2od
**Ograniczenia:** Sprawdzenie wszystkich 4 klas

#### Test 2oa (5 pkt): BMW i Jaguar
```java
BMW bmw = new BMW();
Jaguar jaguar = new Jaguar();
assert bmw.getCena() == 300000;
assert jaguar.getCena() == 280000;
assert bmw.getMarka().contains("BMW");
assert jaguar.getMarka().contains("Jaguar");
```

#### Test 2ob (5 pkt): Bentley
```java
Bentley bentley = new Bentley();
assert bentley.getCena() == 850000;
assert bentley.getMarka().contains("Bentley");
```

#### Test 2oc (5 pkt): Koenigsegg
```java
Koenigsegg koenigsegg = new Koenigsegg();
assert koenigsegg.getCena() == 12000000;
assert koenigsegg.getMarka().contains("Koenigsegg");
```

#### Test 2od (5 pkt): Wszystkie implementują Samochod
```java
assert new BMW() instanceof Samochod;
assert new Jaguar() instanceof Samochod;
assert new Bentley() instanceof Samochod;
assert new Koenigsegg() instanceof Samochod;
```

**Punktacja:**
- Wszystkie testy: 20 pkt
- 3 testy: 15 pkt
- 2 testy: 10 pkt
- 1 test: 5 pkt

---

### Grupa 3: Factory Method (30 punktów)
**Testy:** 3oa, 3ob, 3oc, 3od, 3oe, 3of
**Ograniczenia:** Sprawdzenie metody stworzSamochod

#### Test 3oa (5 pkt): Podstawowe tworzenie
```java
Samochod bmw = FabrykaSamochodow.stworzSamochod("bmw");
Samochod jaguar = FabrykaSamochodow.stworzSamochod("jaguar");
assert bmw != null;
assert jaguar != null;
assert bmw instanceof BMW;
assert jaguar instanceof Jaguar;
```

#### Test 3ob (5 pkt): Case insensitive
```java
Samochod bmw1 = FabrykaSamochodow.stworzSamochod("bmw");
Samochod bmw2 = FabrykaSamochodow.stworzSamochod("BMW");
Samochod bmw3 = FabrykaSamochodow.stworzSamochod("Bmw");
Samochod bmw4 = FabrykaSamochodow.stworzSamochod("bMw");
assert bmw1 != null && bmw2 != null && bmw3 != null && bmw4 != null;
```

#### Test 3oc (5 pkt): Wszystkie marki
```java
String[] marki = {"bmw", "jaguar", "bentley", "koenigsegg"};
for (String marka : marki) {
    Samochod auto = FabrykaSamochodow.stworzSamochod(marka);
    assert auto != null : "Nie utworzono: " + marka;
}
```

#### Test 3od (5 pkt): Nieznana marka
```java
assert FabrykaSamochodow.stworzSamochod("ferrari") == null;
assert FabrykaSamochodow.stworzSamochod("toyota") == null;
assert FabrykaSamochodow.stworzSamochod("") == null;
```

#### Test 3oe (5 pkt): Null safety
```java
assert FabrykaSamochodow.stworzSamochod(null) == null;
```

#### Test 3of (5 pkt): Typ zwracany to interfejs
```java
Method method = FabrykaSamochodow.class.getMethod("stworzSamochod", String.class);
assert method.getReturnType() == Samochod.class;
assert method.getReturnType() != BMW.class;
```

**Punktacja:**
- Wszystkie testy: 30 pkt
- 5 testów: 25 pkt
- 4 testy: 20 pkt
- 3 testy: 15 pkt
- 2 testy: 10 pkt
- 1 test: 5 pkt

---

### Grupa 4: Interfejs AutoFactory (10 punktów)
**Testy:** 4oa, 4ob, 4oc
**Ograniczenia:** Sprawdzenie interfejsu i podstawowych klas

#### Test 4oa (3 pkt): Interfejs AutoFactory
```java
assert AutoFactory.class.isInterface();
Method[] methods = AutoFactory.class.getDeclaredMethods();
assert methods.length == 2;
assert hasMethod(AutoFactory.class, "createSedan");
assert hasMethod(AutoFactory.class, "createSUV");
```

#### Test 4ob (4 pkt): BentleySedan
```java
BentleySedan sedan = new BentleySedan();
assert sedan instanceof Samochod;
assert sedan.getMarka().contains("Bentley");
assert sedan.getMarka().contains("Flying Spur");
assert sedan.getCena() == 950000;
```

#### Test 4oc (3 pkt): BentleySUV
```java
BentleySUV suv = new BentleySUV();
assert suv instanceof Samochod;
assert suv.getMarka().contains("Bentley");
assert suv.getMarka().contains("Bentayga");
assert suv.getCena() == 1100000;
```

**Punktacja:**
- Wszystkie testy: 10 pkt
- 2 testy: 6 pkt
- 1 test: 3 pkt

---

### Grupa 5: Fabryki konkretne (20 punktów)
**Testy:** 5oa, 5ob, 5oc, 5od
**Ograniczenia:** Sprawdzenie LuxuryFactory i SportFactory

#### Test 5oa (5 pkt): LuxuryFactory istnieje i działa
```java
LuxuryFactory factory = new LuxuryFactory();
assert factory instanceof AutoFactory;
Samochod sedan = factory.createSedan();
Samochod suv = factory.createSUV();
assert sedan != null;
assert suv != null;
```

#### Test 5ob (5 pkt): LuxuryFactory tworzy Bentley
```java
LuxuryFactory factory = new LuxuryFactory();
Samochod sedan = factory.createSedan();
Samochod suv = factory.createSUV();
assert sedan instanceof BentleySedan;
assert suv instanceof BentleySUV;
assert sedan.getCena() == 950000;
assert suv.getCena() == 1100000;
```

#### Test 5oc (5 pkt): SportFactory istnieje i działa
```java
SportFactory factory = new SportFactory();
assert factory instanceof AutoFactory;
Samochod sedan = factory.createSedan();
Samochod suv = factory.createSUV();
assert sedan != null;
assert suv != null;
```

#### Test 5od (5 pkt): SportFactory tworzy Koenigsegg
```java
SportFactory factory = new SportFactory();
Samochod sedan = factory.createSedan();
Samochod suv = factory.createSUV();
assert sedan instanceof KoenigseggCoupe;
assert suv instanceof KoenigseggRoadster;
assert sedan.getCena() == 12000000;
assert suv.getCena() == 11500000;
```

**Punktacja:**
- Wszystkie testy: 20 pkt
- 3 testy: 15 pkt
- 2 testy: 10 pkt
- 1 test: 5 pkt

---

### Grupa 6: Demonstracja (10 punktów)
**Testy:** 6oa, 6ob
**Ograniczenia:** Sprawdzenie wyjścia programu

#### Test 6oa (5 pkt): Wyjście Factory Method
```bash
java Salon | grep "=== FACTORY METHOD ===" > /dev/null
java Salon | grep "Wartosc salonu: 13430000 zl" > /dev/null
```

#### Test 6ob (5 pkt): Wyjście Abstract Factory
```bash
java Salon | grep "=== ABSTRACT FACTORY ===" > /dev/null
java Salon | grep "Segment: LUXURY" > /dev/null
java Salon | grep "Wartosc pakietu: 2050000 zl" > /dev/null
java Salon | grep "Segment: SPORT" > /dev/null
java Salon | grep "Wartosc pakietu: 23500000 zl" > /dev/null
```

**Punktacja:**
- Oba testy: 10 pkt
- 1 test: 5 pkt

---

## Suma punktów: 100

| Grupa | Punkty | Opis |
|-------|--------|------|
| Grupa 0 | 0 | Przykład (0 pkt) |
| Grupa 1 | 10 | Interfejs i BMW |
| Grupa 2 | 20 | Wszystkie klasy |
| Grupa 3 | 30 | Factory Method |
| Grupa 4 | 10 | Interfejs AutoFactory |
| Grupa 5 | 20 | Fabryki konkretne |
| Grupa 6 | 10 | Demonstracja |
| **SUMA** | **100** | |

---

## Próg zaliczenia

- **50 punktów (50%)** - zaliczenie
- **70 punktów (70%)** - dobry wynik
- **90 punktów (90%)** - bardzo dobry wynik
- **100 punktów (100%)** - wynik maksymalny

---

## Typowe błędy i kary

### Błąd 1: Niewłaściwy typ zwracany (-10 pkt)
```java
// ŹLE
public static BMW stworzSamochod(String marka)

// DOBRZE
public static Samochod stworzSamochod(String marka)
```
**Kara:** Grupa 3: 0 punktów

### Błąd 2: Brak case-insensitive (-5 pkt)
```java
// ŹLE - tylko małe litery
if (marka.equals("bmw"))

// DOBRZE
if (marka.toLowerCase().equals("bmw"))
```
**Kara:** Test 3ob: 0 punktów (-5 pkt)

### Błąd 3: Brak obsługi null (-5 pkt)
```java
// ŹLE - NullPointerException
public static Samochod stworzSamochod(String marka) {
    switch (marka.toLowerCase()) { ... }
}

// DOBRZE
public static Samochod stworzSamochod(String marka) {
    if (marka == null) return null;
    switch (marka.toLowerCase()) { ... }
}
```
**Kara:** Test 3oe: 0 punktów (-5 pkt)

### Błąd 4: Publiczne pola (-5 pkt)
```java
// ŹLE
class BMW implements Samochod {
    public int cena = 300000;
}

// DOBRZE
class BMW implements Samochod {
    private int cena = 300000;
}
```
**Kara:** Grupa 2: -5 punktów

### Błąd 5: Niewłaściwy format wyjścia (-3 pkt)
```java
// ŹLE
"BMW M5 - 300000zl"

// DOBRZE
"BMW M5: 300000 zl"
```
**Kara:** Test 1oc: 0 punktów (-3 pkt)

---

## Skrypt automatycznego sprawdzania

### judge.sh
```bash
#!/bin/bash

# Kompilacja
echo "Kompilacja..."
javac Salon.java 2> errors.txt

if [ $? -ne 0 ]; then
    echo "Błąd kompilacji!"
    cat errors.txt
    exit 1
fi

# Uruchomienie testów
echo "Uruchamianie testów..."

POINTS=0

# Grupa 1 (10 pkt)
echo "Grupa 1: Interfejs i BMW"
java -ea TestJudge grupa1
if [ $? -eq 0 ]; then
    POINTS=$((POINTS + 10))
    echo "✓ Grupa 1: 10/10 pkt"
else
    echo "✗ Grupa 1: 0/10 pkt"
fi

# Grupa 2 (20 pkt)
echo "Grupa 2: Wszystkie klasy"
java -ea TestJudge grupa2
if [ $? -eq 0 ]; then
    POINTS=$((POINTS + 20))
    echo "✓ Grupa 2: 20/20 pkt"
else
    echo "✗ Grupa 2: 0/20 pkt"
fi

# Grupa 3 (30 pkt)
echo "Grupa 3: Factory Method"
java -ea TestJudge grupa3
RESULT=$?
GROUP3_POINTS=$((RESULT * 5))
POINTS=$((POINTS + GROUP3_POINTS))
echo "Grupa 3: $GROUP3_POINTS/30 pkt"

# Grupa 4 (10 pkt)
echo "Grupa 4: AutoFactory"
java -ea TestJudge grupa4
if [ $? -eq 0 ]; then
    POINTS=$((POINTS + 10))
    echo "✓ Grupa 4: 10/10 pkt"
else
    echo "✗ Grupa 4: 0/10 pkt"
fi

# Grupa 5 (20 pkt)
echo "Grupa 5: Fabryki konkretne"
java -ea TestJudge grupa5
RESULT=$?
GROUP5_POINTS=$((RESULT * 5))
POINTS=$((POINTS + GROUP5_POINTS))
echo "Grupa 5: $GROUP5_POINTS/20 pkt"

# Grupa 6 (10 pkt)
echo "Grupa 6: Demonstracja"
java -ea TestJudge grupa6
if [ $? -eq 0 ]; then
    POINTS=$((POINTS + 10))
    echo "✓ Grupa 6: 10/10 pkt"
else
    echo "✗ Grupa 6: 0/10 pkt"
fi

# Podsumowanie
echo "================================"
echo "WYNIK KOŃCOWY: $POINTS/100 pkt"
echo "================================"

if [ $POINTS -ge 50 ]; then
    echo "Status: ZALICZONE"
else
    echo "Status: NIEZALICZONE"
fi
```

---

## Uruchomienie sprawdzania

```bash
# Kompilacja i testy
./judge.sh

# Lub ręcznie:
javac Salon.java
java -ea TestJudge all
```

---

## Format raportu

```
================================
RAPORT SPRAWDZENIA
================================
Zadanie: Salon Samochodowy (sal)
Uczestnik: [ID]
Data: 2024-10-21 12:34:56
================================

GRUPA 1: Interfejs i BMW............10/10 pkt
  Test 1oa: ✓ (3 pkt)
  Test 1ob: ✓ (4 pkt)
  Test 1oc: ✓ (3 pkt)

GRUPA 2: Wszystkie klasy............20/20 pkt
  Test 2oa: ✓ (5 pkt)
  Test 2ob: ✓ (5 pkt)
  Test 2oc: ✓ (5 pkt)
  Test 2od: ✓ (5 pkt)

GRUPA 3: Factory Method.............25/30 pkt
  Test 3oa: ✓ (5 pkt)
  Test 3ob: ✓ (5 pkt)
  Test 3oc: ✓ (5 pkt)
  Test 3od: ✓ (5 pkt)
  Test 3oe: ✗ (0 pkt) - NullPointerException
  Test 3of: ✓ (5 pkt)

GRUPA 4: AutoFactory................10/10 pkt
  Test 4oa: ✓ (3 pkt)
  Test 4ob: ✓ (4 pkt)
  Test 4oc: ✓ (3 pkt)

GRUPA 5: Fabryki konkretne..........20/20 pkt
  Test 5oa: ✓ (5 pkt)
  Test 5ob: ✓ (5 pkt)
  Test 5oc: ✓ (5 pkt)
  Test 5od: ✓ (5 pkt)

GRUPA 6: Demonstracja...............10/10 pkt
  Test 6oa: ✓ (5 pkt)
  Test 6ob: ✓ (5 pkt)

================================
WYNIK KOŃCOWY: 95/100 pkt
================================
Status: ZALICZONE
Ocena: Bardzo dobry wynik

Uwagi:
- Test 3oe nie przeszedł: Brak obsługi null w metodzie stworzSamochod
```

---

## Konfiguracja judge'a

### config.ini
```ini
[General]
TimeLimit=1000ms
MemoryLimit=256MB
CompilerFlags=-encoding UTF-8
RuntimeFlags=-ea -Xmx256m

[Grading]
PassingScore=50
GoodScore=70
ExcellentScore=90
MaxScore=100

[Groups]
Group1Weight=10
Group2Weight=20
Group3Weight=30
Group4Weight=10
Group5Weight=20
Group6Weight=10
```

---

## Notatki dla administratora systemu

1. Wszystkie testy muszą być uruchomione z włączonymi asercjami (`-ea`)
2. Timeout dla pojedynczego testu: 1 sekunda
3. Każdy test jest niezależny - należy resetować System.out między testami
4. Użyj SecurityManager aby zapobiec:
   - System.exit()
   - Modyfikacji System.out/err/in
   - Operacjom na plikach

---

**Wersja judge:** 1.0
**Data ostatniej aktualizacji:** 2024-10-21
