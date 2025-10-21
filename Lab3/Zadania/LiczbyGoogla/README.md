# Zadanie Liczby Google'a

## 📚 Temat wykładu
- **Klasa String** - operacje na napisach
- **StringBuffer/StringBuilder** - budowanie i modyfikacja napisów
- **Metody String**: charAt(), length(), equals()
- **Konwersja String ↔ int**
- **ArrayList** - dynamiczne tablice

## 📁 Struktura plików

```
LiczbyGoogla/
├── Tresc.md                # Treść zadania z przykładami
├── LiczbyGoogla.java       # Rozwiązanie zadania
├── TestLiczbyGoogla.java   # Testy automatyczne
└── README.md               # Ten plik
```

## 🚀 Jak uruchomić?

### Opcja 1: Kompilacja i uruchomienie ręczne

```bash
# Kompilacja
javac LiczbyGoogla.java

# Uruchomienie programu
java LiczbyGoogla
```

### Opcja 2: Uruchomienie testów

```bash
# Kompilacja testów
javac TestLiczbyGoogla.java LiczbyGoogla.java

# Uruchomienie testów
java TestLiczbyGoogla
```

## 📝 Przykładowe użycie

```
=== LICZBY GOOGLE'A ===

Przykłady sprawdzania:
   0 → ✓ TAK
   1 → ✓ TAK
   8 → ✓ TAK
  11 → ✓ TAK
  69 → ✗ NIE
  88 → ✓ TAK
  96 → ✗ NIE
 101 → ✓ TAK

Podaj górną granicę przedziału: 1000

Liczba liczb Google'a w [0, 1000]: 13
Wszystkie liczby Google'a:
0 1 8 11 69 88 96 101 111 181 609 619 689

Największa liczba Google'a <= 1000: 689
```

## 🧪 Testy

Program zawiera 4 kategorie testów:

1. **Test pojedynczych liczb** (19 testów):
   - Cyfry 0-9
   - Liczby dwucyfrowe (11, 69, 88, 96)
   - Liczby wielocyfrowe (101, 1001, 1234)

2. **Test zliczania** (4 testy):
   - Przedziały: [0, 10], [0, 100], [0, 200], [0, 1000]

3. **Test generowania** (1 test):
   - Sprawdzenie poprawności listy dla n=100

4. **Test największej liczby** (4 testy):
   - Znalezienie największej liczby Google'a <= n

## 🎓 Co pokazuje to zadanie?

### 1. **String.valueOf()** (slajd 33):
```java
String str = String.valueOf(number);
```

### 2. **String.charAt()** (slajd 35):
```java
char digit = str.charAt(i);
```

### 3. **StringBuffer** (slajd 39-43):
```java
StringBuffer rotated = new StringBuffer();
rotated.append(rotatedDigit);
```

### 4. **String.equals()** (slajd 36):
```java
return str.equals(rotated.toString());
```

### 5. **StringBuilder** (slajd 40):
```java
StringBuilder sb = new StringBuilder();
sb.append(numbers.get(i));
```

## 💡 Kluczowe koncepty

### Cyfry symetryczne po obróceniu o 180°:
```
0 → 0
1 → 1
6 → 9
8 → 8
9 → 6
```

### Algorytm sprawdzania:
1. Konwertuj liczbę na String
2. Odwróć String i zamień cyfry (6↔9)
3. Porównaj z oryginalnym String

### Przykład:
```
609 → "609"
Odwróć: "906"
Zamień 6↔9: "609"
Porównaj: "609" == "609" ✓
```

## 🔗 Powiązanie z wykładem

To zadanie wykorzystuje **wszystkie kluczowe metody klasy String** z wykładu:

| Metoda wykładowa | Użycie w zadaniu |
|-----------------|------------------|
| `String.valueOf()` (slajd 33) | Konwersja int → String |
| `charAt(i)` (slajd 35) | Pobieranie cyfr |
| `length()` (slajd 35) | Długość liczby |
| `equals()` (slajd 36) | Porównywanie napisów |
| `StringBuffer` (slajd 39-41) | Budowanie odwróconej liczby |
| `StringBuilder` (slajd 40) | Wyświetlanie wyników |

## 🎯 Dodatkowe wyzwania

Program zawiera **bonus**:
- Metoda `largestGoogleNumber(n)` - znajdź największą liczbę Google'a <= n
- Pokazuje zastosowanie pętli wyszukiwania wstecz

## 📊 Wyniki dla popularnych zakresów

| Zakres | Liczba liczb Google'a |
|--------|----------------------|
| [0, 10] | 3 |
| [0, 100] | 7 |
| [0, 1000] | 13 |
| [0, 10000] | 23 |
