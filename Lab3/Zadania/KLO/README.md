# Zadanie KLO - Wieża z Klocków

## 📚 Temat wykładu
- **Interfejs Comparable** - sortowanie własnych obiektów
- **Metoda compareTo()** - implementacja porównywania
- **Arrays.sort()** - sortowanie tablic obiektów
- **Tablice w Javie** - praca z tablicami obiektów

## 📁 Struktura plików

```
KLO/
├── Tresc.md          # Treść zadania z przykładami
├── KLO.java          # Rozwiązanie zadania
├── TestKLO.java      # Testy automatyczne
└── README.md         # Ten plik
```

## 🚀 Jak uruchomić?

### Opcja 1: Kompilacja i uruchomienie ręczne

```bash
# Kompilacja
javac KLO.java

# Uruchomienie programu
java KLO
```

### Opcja 2: Uruchomienie testów

```bash
# Kompilacja testów
javac TestKLO.java KLO.java

# Uruchomienie testów
java TestKLO
```

## 📝 Przykładowe użycie

```
Podaj liczbę klocków: 3
Podaj wymiary klocków (a b c):
1 2 3
2 3 4
3 4 5

Maksymalna wysokość wieży: 12
```

## 🧪 Testy

Program zawiera 6 automatycznych testów sprawdzających:
- Klocki w rosnącej kolejności
- Klocki w losowej kolejności
- Pojedynczy klocek
- Klocki o tych samych wymiarach
- Wszystkie identyczne klocki

## 🎓 Co pokazuje to zadanie?

1. **Implementacja interfejsu Comparable** (slajd 52-54):
   ```java
   class Klocek implements Comparable<Klocek> {
       public int compareTo(Klocek other) { ... }
   }
   ```

2. **Użycie Arrays.sort()** (slajd 47):
   ```java
   Arrays.sort(klocki);
   ```

3. **Praca z tablicami obiektów** (slajd 6, 52):
   ```java
   Klocek[] klocki = new Klocek[n];
   ```

4. **Dynamiczne programowanie** - algorytm obliczania maksymalnej wysokości

## 💡 Kluczowe koncepty

- Każdy klocek może być ułożony na **3 sposoby** (wybór wysokości)
- Sortowanie według **powierzchni podstawy** (malejąco)
- Użycie **programowania dynamicznego** do znalezienia optymalnego rozwiązania

## 🔗 Powiązanie z wykładem

To zadanie **bezpośrednio** implementuje przykład z wykładu (slajdy 52-60):
- Zamiast klasy `Osoba` z polami `name` i `age`
- Mamy klasę `Klocek` z polami `szerokosc`, `glebokosc`, `wysokosc`
- Używamy tej samej struktury: `implements Comparable`, `compareTo()`, `Arrays.sort()`
