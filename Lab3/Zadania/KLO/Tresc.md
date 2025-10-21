# Zadanie: Wieża z Klocków (KLO)

## Temat wykładu
- Klasy abstrakcyjne i interfejsy
- Sortowanie obiektów (Comparable, Comparator)
- Klasa Arrays
- Tablice w Javie

## Treść zadania

Bajtazar dostał na urodziny **n** drewnianych klocków. Każdy klocek to prostopadłościan o wymiarach `a[i] × b[i] × c[i]`.

Bajtazar układa z nich wieżę według następujących zasad:
1. Jeden klocek kładzie na podłodze
2. Następne klocki kładzie jeden na drugim
3. Każdy kolejny klocek jest ustawiony tak, aby krawędzie podstawy były równoległe lub prostopadłe do krawędzi podstawy klocka poprzedniego
4. **Warunek stabilności**: Każdy kolejny klocek musi mieć podstawę **mniejszą** od podstawy poprzedniego klocka (oba wymiary podstawy muszą być mniejsze)

### Przykłady:
- Klocek `2×2×2` **NIE MOŻE** stać na klocku `2×2×2`
- Klocek `2×2×1` **NIE MOŻE** stać na klocku `2×2×2`
- Klocek `1×1×9` **MOŻE** stać na klocku `2×2×2` (podstawa `1×1`)

## Zadanie
Napisz program, który obliczy **maksymalną wysokość wieży**, którą może ułożyć Bajtazar.

**Uwaga**: Nie wszystkie klocki muszą być wykorzystane!

## Format danych

### Wejście:
```
n
a[0] b[0] c[0]
a[1] b[1] c[1]
...
a[n-1] b[n-1] c[n-1]
```

### Wyjście:
```
maksymalna_wysokość
```

## Przykład 1

### Wejście:
```
3
1 2 3
2 3 4
3 4 5
```

### Wyjście:
```
12
```

### Wyjaśnienie:
Możemy ułożyć wszystkie 3 klocki:
- Klocek 3 (3×4×5): podstawa 3×4, wysokość 5
- Klocek 2 (2×3×4): podstawa 2×3, wysokość 4
- Klocek 1 (1×2×3): podstawa 1×2, wysokość 3
- **Suma: 5 + 4 + 3 = 12**

## Przykład 2

### Wejście:
```
4
4 6 7
1 2 3
4 5 6
10 12 32
```

### Wyjście:
```
60
```

### Wyjaśnienie:
Optymalne ułożenie to klocki: 10×12×32 i 4×6×7, co daje 32 + 7 + 6 + ... = 60

## Ograniczenia:
- `2 ≤ n ≤ 100`
- `1 ≤ a[i], b[i], c[i] ≤ 1000`

## Podpowiedzi do implementacji:

1. **Każdy klocek można ułożyć na 3 sposoby** (wybór wysokości):
   - Podstawa: a×b, wysokość: c
   - Podstawa: a×c, wysokość: b
   - Podstawa: b×c, wysokość: a

2. **Użyj interfejsu Comparable** do sortowania klocków

3. **Zastosuj Arrays.sort()** do posortowania klocków

4. **Dynamiczne programowanie**: Po posortowaniu, dla każdego klocka oblicz maksymalną wysokość wieży kończącej się tym klockiem

## Wymagania techniczne:

- Stwórz klasę `Klocek` implementującą interfejs `Comparable<Klocek>`
- Użyj metody `Arrays.sort()` do sortowania
- Użyj tablic do przechowywania danych
- Zaimplementuj metodę `compareTo()` do porównywania klocków
