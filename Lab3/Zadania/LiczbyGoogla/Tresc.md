# Zadanie: Liczby Google'a

## Temat wykładu
- Klasa String i StringBuffer
- Operacje na napisach
- Metody klasy String (charAt, length, substring)
- Tablice w Javie

## Treść zadania

Student i nauczyciel siedzą naprzeciwko siebie przy stole. Student zapisuje liczby na kartce.

**Problem**: Liczby muszą być zapisane tak, aby nauczyciel (patrzący z **przeciwnej strony stołu**, czyli do góry nogami) odczytał **dokładnie tę samą liczbę**.

### Przykład:
```
Student pisze:    1001
Nauczyciel widzi: 1001  ✓ (ta sama liczba!)

Student pisze:    69
Nauczyciel widzi: 96   ✗ (inna liczba!)

Student pisze:    1691
Nauczyciel widzi: 1691  ✓ (ta sama liczba!)
```

## Cyfry symetryczne po obróceniu o 180°:

| Cyfra | Po obróceniu |
|-------|--------------|
| 0     | 0            |
| 1     | 1            |
| 6     | 9            |
| 8     | 8            |
| 9     | 6            |

**Cyfry 2, 3, 4, 5, 7 NIE MOGĄ być użyte** (nie wyglądają tak samo po obróceniu)

## Zadania

### Zadanie 1: Sprawdzanie pojedynczej liczby
Napisz metodę, która sprawdzi, czy dana liczba jest "liczbą Google'a" (wygląda tak samo po obróceniu o 180°).

```java
boolean isGoogleNumber(int number)
```

#### Przykłady:
```
isGoogleNumber(0)     → true
isGoogleNumber(1)     → true
isGoogleNumber(8)     → true
isGoogleNumber(11)    → true
isGoogleNumber(69)    → false
isGoogleNumber(88)    → true
isGoogleNumber(96)    → false
isGoogleNumber(101)   → true
isGoogleNumber(609)   → true
isGoogleNumber(1001)  → true
isGoogleNumber(1234)  → false (zawiera 2, 3, 4)
```

### Zadanie 2: Liczenie liczb Google'a w przedziale
Napisz metodę, która policzy ile jest liczb Google'a w przedziale [0, n].

```java
int countGoogleNumbers(int n)
```

#### Przykłady:
```
countGoogleNumbers(10)     → 3  (0, 1, 8)
countGoogleNumbers(100)    → 7  (0, 1, 8, 11, 69, 88, 96)
countGoogleNumbers(1000)   → 13
countGoogleNumbers(10000)  → 23
```

### Zadanie 3: Generowanie liczb Google'a
Napisz metodę, która wygeneruje wszystkie liczby Google'a w przedziale [0, n].

```java
ArrayList<Integer> generateGoogleNumbers(int n)
```

## Format wejścia/wyjścia

### Wejście:
```
n
```
gdzie n to górna granica przedziału

### Wyjście:
```
liczba_liczb_googla
lista_liczb_googla
```

## Przykład 1

### Wejście:
```
100
```

### Wyjście:
```
7
0 1 8 11 69 88 96
```

## Przykład 2

### Wejście:
```
1000
```

### Wyjście:
```
13
0 1 8 11 69 88 96 101 111 181 609 619 689
```

## Podpowiedzi do implementacji:

1. **Użyj String.valueOf()** do konwersji liczby na String
2. **Użyj String.charAt()** do pobierania poszczególnych cyfr
3. **Użyj StringBuilder** lub **StringBuffer** do odwracania i budowania liczb
4. **Stwórz mapę** cyfr po obróceniu:
   ```java
   Map<Character, Character> rotated = new HashMap<>();
   rotated.put('0', '0');
   rotated.put('1', '1');
   rotated.put('6', '9');
   rotated.put('8', '8');
   rotated.put('9', '6');
   ```

## Wymagania techniczne:

- Użyj klasy **String** do operacji na napisach
- Użyj **StringBuffer** lub **StringBuilder** do budowania napisów
- Zastosuj metody: `charAt()`, `length()`, `reverse()`
- Użyj **ArrayList** do przechowywania wyników

## Dodatkowe wyzwanie (opcjonalnie):

Napisz metodę, która znajdzie **największą liczbę Google'a mniejszą lub równą n**:

```java
int largestGoogleNumber(int n)
```

### Przykłady:
```
largestGoogleNumber(50)    → 11
largestGoogleNumber(100)   → 96
largestGoogleNumber(1000)  → 689
```
