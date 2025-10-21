# Salon Bajtazara (sal)

**Limit czasu:** 1s
**Limit pamięci:** 256 MB

---

## Treść zadania

Bajtek otworzył luksusowy salon samochodowy w Bajtocji. Sprzedaje w nim cztery marki samochodów:

- **BMW M5** - niemiecki samochód sportowy (cena: **300 000** bajtalarów)
- **Jaguar F-Type** - brytyjski samochód sportowy (cena: **280 000** bajtalarów)
- **Bentley Continental GT** - luksusowa limuzyna (cena: **850 000** bajtalarów)
- **Koenigsegg Jesko** - szwedzki hipersamochód (cena: **12 000 000** bajtalarów)

Do salonu przychodzą klienci i składają zamówienia. Bajtek potrzebuje systemu, który:
1. Przetwarza zamówienia klientów
2. Wyświetla informacje o zamówionych samochodach
3. Oblicza łączną wartość zamówień

---

## Wejście

W pierwszej linii znajduje się jedna liczba całkowita **n** (1 ≤ n ≤ 1000) - liczba zamówień.

W kolejnych **n** liniach znajdują się nazwy marek samochodów (ciągi znaków składające się wyłącznie z małych i wielkich liter alfabetu łacińskiego, o długości co najwyżej 20 znaków).

Nazwy marek mogą być zapisane różnymi sposobami: `bmw`, `BMW`, `Bmw` itp. - program powinien je rozpoznać niezależnie od wielkości liter.

---

## Wyjście

Dla każdego zamówienia program powinien wypisać w osobnej linii:
```
[Nazwa modelu]: [cena] bajtalarow
```

Jeśli marka jest nieznana, program powinien wypisać:
```
NIEZNANA MARKA
```

W ostatniej linii program powinien wypisać:
```
Laczna wartosc: [suma] bajtalarow
```

gdzie **suma** to łączna wartość wszystkich zamówionych (rozpoznanych) samochodów.

---

## Przykład

### Wejście 1:
```
5
bmw
jaguar
bentley
koenigsegg
bmw
```

### Wyjście 1:
```
BMW M5: 300000 bajtalarow
Jaguar F-Type: 280000 bajtalarow
Bentley Continental GT: 850000 bajtalarow
Koenigsegg Jesko: 12000000 bajtalarow
BMW M5: 300000 bajtalarow
Laczna wartosc: 13730000 bajtalarow
```

### Wejście 2:
```
4
BMW
Ferrari
BENTLEY
toyota
```

### Wyjście 2:
```
BMW M5: 300000 bajtalarow
NIEZNANA MARKA
Bentley Continental GT: 850000 bajtalarow
NIEZNANA MARKA
Laczna wartosc: 1150000 bajtalarow
```

### Wejście 3:
```
2
koenigsegg
koenigsegg
```

### Wyjście 3:
```
Koenigsegg Jesko: 12000000 bajtalarow
Koenigsegg Jesko: 12000000 bajtalarow
Laczna wartosc: 24000000 bajtalarow
```

---

## Podproblem 1 (40 punktów)

**Ograniczenia:** 1 ≤ n ≤ 10, wszystkie marki to tylko `bmw` lub `jaguar` (małymi literami).

W tym podproblemie wystarczy napisać prosty kod z instrukcjami warunkowymi.

---

## Podproblem 2 (30 punktów)

**Ograniczenia:** 1 ≤ n ≤ 100, marki mogą być zapisane różnymi wielkościami liter.

Program musi obsługiwać wszystkie cztery marki i rozpoznawać je niezależnie od wielkości liter.

---

## Podproblem 3 (30 punktów)

**Ograniczenia:** 1 ≤ n ≤ 1000, wszystkie cztery marki, różne wielkości liter, mogą występować nieznane marki.

Pełna wersja zadania - program musi działać szybko i poprawnie dla wszystkich przypadków testowych.

---

## Uwagi

- Nazwy marek w wejściu mogą zawierać tylko litery (bez spacji, cyfr, znaków specjalnych)
- Program powinien działać efektywnie nawet dla n = 1000
- Suma cen mieści się w typie `long` (do 10^12)
- Kolejność wypisywania: dokładnie taka sama jak kolejność zamówień w wejściu

---

## Punktacja

| Podproblem | Punkty | Ograniczenia |
|------------|--------|--------------|
| 1 | 40 | n ≤ 10, tylko bmw/jaguar małymi literami |
| 2 | 30 | n ≤ 100, wszystkie marki, case-insensitive |
| 3 | 30 | n ≤ 1000, pełna wersja |
| **RAZEM** | **100** | |

---

## Wskazówka

Aby program był czytelny i łatwy w utrzymaniu, warto pomyśleć jak zorganizować kod tak, aby:
- Dodanie nowej marki samochodu było proste
- Zmiana ceny samochodu wymagała zmiany tylko w jednym miejscu
- Kod nie był pełen powtarzających się fragmentów

Możesz wykorzystać znane Ci konstrukcje języka Java, takie jak klasy, interfejsy, czy metody pomocnicze.

---

## Format rozwiązania

Rozwiązanie powinno być w pliku `Salon.java` zawierającym klasę `public class Salon` z metodą `main`.

Kompilacja:
```bash
javac Salon.java
```

Uruchomienie:
```bash
java Salon
```

Program czyta dane ze standardowego wejścia i wypisuje wynik na standardowe wyjście.

---

## Przykładowe testy

### Test 1 (podproblem 1):
**Wejście:**
```
3
bmw
jaguar
bmw
```

**Oczekiwane wyjście:**
```
BMW M5: 300000 bajtalarow
Jaguar F-Type: 280000 bajtalarow
BMW M5: 300000 bajtalarow
Laczna wartosc: 880000 bajtalarow
```

### Test 2 (podproblem 2):
**Wejście:**
```
4
BMW
BENTLEY
koenigsegg
Jaguar
```

**Oczekiwane wyjście:**
```
BMW M5: 300000 bajtalarow
Bentley Continental GT: 850000 bajtalarow
Koenigsegg Jesko: 12000000 bajtalarow
Jaguar F-Type: 280000 bajtalarow
Laczna wartosc: 13430000 bajtalarow
```

### Test 3 (podproblem 3):
**Wejście:**
```
5
porsche
BMW
ferrari
bentley
audi
```

**Oczekiwane wyjście:**
```
NIEZNANA MARKA
BMW M5: 300000 bajtalarow
NIEZNANA MARKA
Bentley Continental GT: 850000 bajtalarow
NIEZNANA MARKA
Laczna wartosc: 1150000 bajtalarow
```

---

## Autor zadania

Zadanie przygotowane na potrzeby zajęć z programowania obiektowego w Bajtocji.

---

*Powodzenia!*
