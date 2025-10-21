# Zadanie: Wzorce Projektowe - Fabryka Samochodów 🚗

## Wprowadzenie

Tworzysz **salon samochodowy**, który sprzedaje luksusowe marki:
- 🏎️ **BMW** (niemieckie, premium)
- 🐆 **Jaguar** (brytyjskie, eleganckie)
- 👑 **Bentley** (ultra-luksusowe)
- ⚡ **Koenigsegg** (szwedzkie hipersportowe - MEGA EGZOTYCZNE!)

Zobaczysz **3 wersje kodu** - od prostego do wzorców projektowych.

---

## Wersja 1️⃣: BEZ WZORCA (BezWzorca.java)

**Problem**: Kod pełen `if-else` i bezpośrednich wywołań `new`.

```java
String marka = "bmw";

if (marka.equals("bmw")) {
    BMW auto = new BMW();
    auto.jedz();
} else if (marka.equals("jaguar")) {
    Jaguar auto = new Jaguar();
    auto.jedz();
} else if (marka.equals("bentley")) {
    Bentley auto = new Bentley();
    auto.jedz();
}
// ... powtarzanie tego wszędzie!
```

❌ **Wady**:
- Powtarzanie kodu w wielu miejscach
- Trudno dodać nową markę
- Kod zależy od konkretnych klas

---

## Wersja 2️⃣: FABRYKA (Factory Method) (Fabryka.java)

**Rozwiązanie**: Jedna metoda tworzy wszystkie samochody!

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
auto.jedz();
```

✅ **Zalety**:
- Jedna metoda tworzy wszystkie auta
- Łatwo dodać nową markę
- Kod używa interfejsu `Samochod`

---

## Wersja 3️⃣: FABRYKA ABSTRAKCYJNA (FabrykaAbstrakcyjna.java)

**Rozwiązanie**: Różne fabryki dla różnych **segmentów** samochodów!

### Segmenty:
- **LuxuryFactory** → tworzy Bentley (luksusowe sedan + SUV)
- **SportFactory** → tworzy Koenigsegg (sportowe coupe + roadster)

```java
interface AutoFactory {
    Samochod createSedan();
    Samochod createSUV();
}

class LuxuryFactory implements AutoFactory {
    public Samochod createSedan() { return new BentleySedan(); }
    public Samochod createSUV() { return new BentleySUV(); }
}

class SportFactory implements AutoFactory {
    public Samochod createSedan() { return new KoenigseggCoupe(); }
    public Samochod createSUV() { return new KoenigseggRoadster(); }
}

// Użycie:
AutoFactory factory = new LuxuryFactory();
Samochod sedan = factory.createSedan();   // Bentley Sedan
Samochod suv = factory.createSUV();       // Bentley SUV
// Wszystko w stylu Luxury!
```

✅ **Zalety**:
- Tworzy **rodziny** aut (Luxury lub Sport)
- Wszystkie auta z rodziny są **spójne**
- Łatwo dodać nowy segment

---

## Porównanie wzorców

| Bez wzorca | Factory Method | Abstract Factory |
|------------|----------------|------------------|
| `if-else` wszędzie | `stworzSamochod("bmw")` | `factory.createSedan()` |
| Trudne utrzymanie | Łatwe dodanie marki | Łatwe dodanie segmentu |
| Duplikacja kodu | Jedna metoda | Rodziny produktów |

---

## Zadania

### Zadanie 1: Uruchom wersję BEZ wzorca
```bash
javac BezWzorca.java && java BezWzorca
```

### Zadanie 2: Uruchom wersję z Factory Method
```bash
javac Fabryka.java && java Fabryka
```

### Zadanie 3: Uruchom wersję z Abstract Factory
```bash
javac FabrykaAbstrakcyjna.java && java FabrykaAbstrakcyjna
```

### Zadanie 4: Porównaj kody
Otwórz wszystkie 3 pliki i zobacz, jak wzorce upraszczają kod!

---

## Kluczowe koncepty

### Interfejs Samochod:
```java
interface Samochod {
    String getMarka();
    int getCena();
    void jedz();
}
```

### Przykładowa klasa:
```java
class BMW implements Samochod {
    public String getMarka() { return "BMW"; }
    public int getCena() { return 300000; }
    public void jedz() {
        System.out.println("🏎️ BMW jedzie! Vroom!");
    }
}
```

---

## 🎯 Co nauczysz się?

✅ Jak wygląda kod **przed** użyciem wzorców
✅ Czym jest **Factory Method** i jak upraszcza kod
✅ Czym jest **Abstract Factory** i kiedy go używać
✅ Różnice między wzorcami kreacyjnymi

Teraz masz **3 gotowe pliki** do nauki! 🚀
