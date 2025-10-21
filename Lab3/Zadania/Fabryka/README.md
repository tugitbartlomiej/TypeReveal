# Wzorce Fabryka - Salon Samochodowy 🚗

## 🎯 3 wersje kodu - od prostego do wzorców!

Zobaczysz **ewolucję kodu** - jak wzorce projektowe rozwiązują problemy!

### Marki w salonie:
- 🏎️ **BMW M5** (300,000 zł) - niemieckie premium
- 🐆 **Jaguar F-Type** (280,000 zł) - brytyjska elegancja
- 👑 **Bentley Continental GT** (850,000 zł) - ultra-luksus
- ⚡ **Koenigsegg Jesko** (12,000,000 zł) - szwedzki hipersamochód!

---

## 📁 Pliki

### 1️⃣ BezWzorca.java - ❌ Zły przykład
**Problem**: Kod pełen `if-else` i duplikacji

```bash
javac BezWzorca.java && java BezWzorca
```

### 2️⃣ Fabryka.java - ✅ Factory Method
**Rozwiązanie**: Jedna metoda tworzy wszystkie auta

```bash
javac Fabryka.java && java Fabryka
```

### 3️⃣ FabrykaAbstrakcyjna.java - ✅ Abstract Factory
**Rozwiązanie**: Rodziny produktów (Luxury, Sport)

```bash
javac FabrykaAbstrakcyjna.java && java FabrykaAbstrakcyjna
```

### 🧪 Testy
```bash
javac TestFabryka.java Fabryka.java FabrykaAbstrakcyjna.java
java TestFabryka
```

---

## 📊 Porównanie

| Aspekt | Bez wzorca | Factory Method | Abstract Factory |
|--------|------------|----------------|------------------|
| **Kod** | `if-else` wszędzie | `stworzSamochod("bmw")` | `factory.createSedan()` |
| **Produkty** | Każdy osobno | Wszystkie marki | Rodziny (Luxury/Sport) |
| **Utrzymanie** | ❌ Trudne | ✅ Łatwe | ✅ Bardzo łatwe |
| **Rozszerzanie** | ❌ Zmiana wszędzie | ✅ Jedna metoda | ✅ Nowa fabryka |

---

## 💡 Kluczowe różnice

### Factory Method
```java
// Tworzy JEDEN produkt
Samochod auto = FabrykaSamochodow.stworzSamochod("bmw");
```

### Abstract Factory
```java
// Tworzy RODZINĘ produktów
AutoFactory factory = new LuxuryFactory();
Samochod sedan = factory.createSedan();   // Bentley Sedan
Samochod suv = factory.createSUV();       // Bentley SUV
// Wszystko spójne!
```

---

## 🎓 Czego się nauczysz?

✅ Jak wygląda kod **przed** wzorcami (BezWzorca.java)
✅ Jak **Factory Method** upraszcza tworzenie obiektów
✅ Jak **Abstract Factory** tworzy rodziny produktów
✅ Kiedy używać każdego wzorca

---

## 🚀 Zalety wzorców

### Factory Method:
- ✅ Centralizacja tworzenia obiektów
- ✅ Polimorfizm (interfejs `Samochod`)
- ✅ Łatwe dodawanie nowych marek

### Abstract Factory:
- ✅ Spójne rodziny produktów
- ✅ Łatwa zmiana segmentu
- ✅ Kod pracuje z abstrakcjami

---

## 📖 Struktura

### Bez wzorca:
```
BMW, Jaguar, Bentley, Koenigsegg
(każda klasa osobno, bez interfejsu)
```

### Factory Method:
```
interface Samochod
    ↑
    ├── BMW
    ├── Jaguar
    ├── Bentley
    └── Koenigsegg

FabrykaSamochodow.stworzSamochod() → Samochod
```

### Abstract Factory:
```
interface AutoFactory
    ↑
    ├── LuxuryFactory → BentleySedan, BentleySUV
    └── SportFactory → KoenigseggCoupe, KoenigseggRoadster

Showroom używa AutoFactory
```

---

## 🔥 Koenigsegg - egzotyczna marka!

**Koenigsegg** to szwedzki producent hipersamochodów:
- Tylko ~20 aut rocznie
- Silniki V8 1500-1600 KM
- Ceny od 10-30 mln zł
- **Najszybsze auta produkcyjne na świecie!**

Idealny przykład ultra-egzotycznej marki! ⚡

---

## 🎯 Zadanie

1. Uruchom **BezWzorca.java** - zobacz problem
2. Uruchom **Fabryka.java** - zobacz rozwiązanie
3. Uruchom **FabrykaAbstrakcyjna.java** - zobacz zaawansowany wzorzec
4. Porównaj kody - zauważ różnice!
5. Uruchom testy - sprawdź poprawność

**Trzy pliki pokazują ewolucję od złego kodu do dobrych wzorców!** 🚀
