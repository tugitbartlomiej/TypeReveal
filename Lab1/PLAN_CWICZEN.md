# PLAN PRZEPROWADZENIA ĆWICZEŃ - LABORATORIUM JAVA

## STRUKTURA ZAJĘĆ (2 godziny)

### CZĘŚĆ 1: WPROWADZENIE (15 min)

#### 1. Powitanie i przedstawienie środowiska
- Pokaż IntelliJ IDEA (lub inne IDE)
- Wyjaśnij podstawową strukturę: projekt → folder → plik .java
- Pokaż jak utworzyć nowy plik Java
- Pokaż jak uruchomić program (zielona strzałka / Run)

#### 2. Podstawowe pojęcia
```
- Klasa = kontener na kod
- main() = punkt startowy programu
- System.out.println() = wypisywanie na ekran
```

---

### CZĘŚĆ 2: ĆWICZENIE 1 - HELLO WORLD (10 min)

#### Demonstracja (5 min)
1. Otwórz `01_hello/HelloWorld.java`
2. Przeczytaj komentarze na głos
3. Uruchom program
4. Pokaż wynik w konsoli

#### Zadanie dla studentów (5 min)
```
ZADANIE: Zmodyfikuj program tak, aby wyświetlał:
- Twoje imię
- Twój numer albumu
- Nazwę uczelni

Przykład:
Hello World!
Mam na imię Jan Kowalski
Numer albumu: 12345
Studiuję na Politechnice
```

**Pomoc dla studentów:**
- Skopiuj linię `System.out.println("tekst");`
- Zmień tekst między cudzysłowami
- Uruchom program

---

### CZĘŚĆ 3: ĆWICZENIE 2 - SCANNER (15 min)

#### Demonstracja (7 min)
1. Otwórz `02_scanner_strings/ScannerStrings.java`
2. Wyjaśnij krok po kroku:
   - `import Scanner` = importowanie narzędzia
   - `new Scanner(System.in)` = utworzenie "czytnika" klawiatury
   - `nextLine()` = wczytaj całą linię tekstu
   - `+` = sklejanie tekstów

3. Uruchom i przetestuj na żywo z losowym imieniem

#### Zadanie dla studentów (8 min)
```
ZADANIE: Rozszerz program o pytania:
- O wiek
- O ulubiony kolor
- O miasto zamieszkania

Wyświetl podsumowanie w jednej linii:
"Jan ma 20 lat, lubi niebieski i mieszka w Warszawie"
```

**Wskazówki:**
- Dodaj kolejne `System.out.print("pytanie: ");`
- Dodaj kolejne zmienne typu String
- Użyj `+` do sklejenia wszystkiego

---

### CZĘŚĆ 4: ĆWICZENIE 3 - RZUTOWANIE (20 min)

#### Demonstracja (10 min)
1. Otwórz `03_scanner_casting/ScannerCasting.java`
2. **KLUCZOWE WYJAŚNIENIE:**
   - Scanner wczytuje ZAWSZE tekst (String)
   - Jeśli chcemy liczyć, musimy zamienić tekst na liczbę
   - `Integer.parseInt()` = zamiana tekstu na int
   - `Double.parseDouble()` = zamiana tekstu na double

3. Uruchom i pokaż:
   - Co się stanie gdy wpiszemy "5"
   - Co się stanie gdy wpiszemy "3.14"
   - Co się stanie przy rzutowaniu 3.9 → int (wynik: 3)

#### Zadanie dla studentów (10 min)
```
ZADANIE: Kalkulator wieku
Wczytaj:
1. Rok urodzenia (jako String)
2. Obecny rok (jako String)

Oblicz i wyświetl wiek:
"Masz X lat"

BONUS: Oblicz ile dni to w przybliżeniu (wiek * 365)
```

**Kod startowy:**
```java
String rokUrodzenia = scanner.nextLine();
int rokInt = Integer.parseInt(rokUrodzenia);
// ... dalej samodzielnie
```

---

### CZĘŚĆ 5: ĆWICZENIE 4 - ARYTMETYKA (20 min)

#### Demonstracja (8 min)
1. Otwórz `04_arithmetic/Arithmetic.java`
2. Wyjaśnij każdą operację:
   - `+, -, *, /` = podstawowe działania
   - `Math.pow()` = potęgowanie
   - `Math.sqrt()` = pierwiastek
   - `Math.abs()` = wartość bezwzględna
   - `Math.max/min()` = większa/mniejsza liczba

3. Przetestuj z liczbami: 10 i 3

#### Zadanie dla studentów (12 min)
```
ZADANIE: Mini kalkulator BMI

Wczytaj:
- Wzrost w metrach (np. 1.75)
- Wagę w kilogramach (np. 70)

Oblicz BMI = waga / (wzrost * wzrost)

Wyświetl:
"Twoje BMI wynosi: X"

BONUS: Dodaj interpretację:
- BMI < 18.5 → "Niedowaga"
- BMI 18.5-24.9 → "Waga prawidłowa"
- BMI >= 25 → "Nadwaga"
```

**Wskazówki:**
- Użyj `Math.pow(wzrost, 2)` lub `wzrost * wzrost`
- Do BONUSU użyj `if (bmi < 18.5) { ... }`

---

### CZĘŚĆ 6: ĆWICZENIE 5 - OPERACJE BITOWE (25 min)

#### Demonstracja (12 min)
1. Otwórz `05_bitwise/Bitwise.java`
2. **WIZUALIZACJA NA TABLICY:**
   ```
   Liczba 5 w systemie dziesiętnym = 101 w binarnym

   Przesunięcie w lewo (<<):
   101 → 1010 = 10 w dziesiętnym (5 * 2)

   Przesunięcie w prawo (>>):
   101 → 10 = 2 w dziesiętnym (5 / 2)
   ```

3. Uruchom z liczbą 8 i pokaż:
   - 8 * 2 = 16 (bez użycia *)
   - 8 / 2 = 4 (bez użycia /)
   - Reprezentację binarną

4. **ANALOGIA:** "To jak przesuwanie liczby w systemie dziesiętnym: 15 → 150 (mnożenie przez 10)"

#### Zadanie dla studentów (13 min)
```
ZADANIE: Szybkie obliczenia

Wczytaj liczbę całkowitą.

Oblicz i wyświetl BEZ użycia * i /:
1. Liczba × 16
2. Liczba × 32
3. Liczba ÷ 16
4. Liczba ÷ 32

Podpowiedź:
× 16 = przesunięcie o 4 bity w lewo
× 32 = przesunięcie o 5 bitów w lewo
÷ 16 = przesunięcie o 4 bity w prawo
÷ 32 = przesunięcie o 5 bitów w prawo
```

**Dla chętnych - matematyka:**
```
Dlaczego << 4 to × 16?
Bo 2^4 = 16
Każde przesunięcie to × 2
```


x=b0⋅20 + b1​⋅21+b2​⋅22+… 
---

### CZĘŚĆ 7: ĆWICZENIE 6 - DEBUGGING (15 min)

#### Demonstracja (5 min)
1. **Najpierw pokaż BŁĘDNY kod** (skopiuj z komentarza w pliku)
2. Stwórz nowy plik `BladyDemo.java` i wklej błędny kod
3. Spróbuj skompilować - pokaż błędy kompilacji
4. Wyjaśnij każdy błąd po kolei

#### Zadanie dla studentów (10 min)
```
ZADANIE: Znajdź i popraw błędy

Kod z błędami:
public class CwiczenieBledow {
    public static void main() {
        string x = "10";
        string y = "20";
        int suma = x + y;
        System.out.println("Suma: " + suma)
    }
}

Błędy do znalezienia:
1. ??? (brak String[] args)
2. ??? (string zamiast String)
3. ??? (nie można dodawać String do int)
4. ??? (brak średnika)

Popraw wszystkie błędy!
```

---

## ZAKOŃCZENIE ZAJĘĆ (10 min)

### Podsumowanie
1. **Co dzisiaj przeszliśmy:**
   - Podstawowa struktura programu Java
   - Wyświetlanie tekstu (System.out.println)
   - Wczytywanie danych (Scanner)
   - Typy danych (String, int, double)
   - Konwersja typów (parseInt, parseDouble, rzutowanie)
   - Operacje matematyczne
   - Operacje bitowe
   - Znajdowanie i poprawianie błędów

2. **Pytania studentów** (5 min)

3. **Zadanie domowe (opcjonalne):**
```
Napisz program "Super Kalkulator":
- Wczytaj 3 liczby
- Wyświetl: sumę, różnicę, iloczyn, iloraz
- Wyświetl największą i najmniejszą
- Wyświetl średnią arytmetyczną
- BONUS: Oblicz pierwszą liczbę * 8 używając operacji bitowych
```

---

## WSKAZÓWKI DLA PROWADZĄCEGO

### Przed zajęciami:
- [ ] Upewnij się, że Java i IDE są zainstalowane na wszystkich komputerach
- [ ] Skopiuj folder z ćwiczeniami na wspólny dysk/pendrive
- [ ] Przygotuj tablicę/slajd z podstawową składnią

### Podczas zajęć:
- **Mów wolno** - studenci muszą przepisywać/notować
- **Powtarzaj** - te same pojęcia wielokrotnie
- **Pokazuj błędy** - celowo popełniaj drobne błędy i naprawiaj
- **Zachęcaj do pytań** - nie ma głupich pytań!
- **Chodź między studentami** - pomagaj indywidualnie

### Częste problemy studentów:
| Problem | Rozwiązanie |
|---------|------------|
| "Nie kompiluje się" | Sprawdź: nazwę klasy = nazwa pliku, średniki, nawiasy |
| "InputMismatchException" | Wyjaśnij różnicę między next() a nextLine() |
| "Dziwne znaki polskie" | Ustaw kodowanie UTF-8 w IDE |
| "Nie wiem co wpisać" | Pokaż przykładowe dane wejściowe |

### Timing - jak zarządzać czasem:
- Jeśli studenci są szybsi → dodaj zadania BONUS
- Jeśli studenci się gubią → pomiń część o operacjach bitowych na później
- Zachowaj 15 min bufor na problemy techniczne

---

## MATERIAŁY DODATKOWE

### Ściągawka dla studentów
```java
// Wyświetlanie
System.out.println("tekst");

// Wczytywanie
Scanner scanner = new Scanner(System.in);
String tekst = scanner.nextLine();

// Konwersja
int liczba = Integer.parseInt(tekst);
double liczba2 = Double.parseDouble(tekst);

// Matematyka
int suma = a + b;
double pierwiastek = Math.sqrt(liczba);

// Operacje bitowe
int razy2 = liczba << 1;  // mnożenie × 2
int przez2 = liczba >> 1; // dzielenie ÷ 2
```

### Linki przydatne:
- Dokumentacja Java: https://docs.oracle.com/javase/tutorial/
- Ćwiczenia online: https://www.w3schools.com/java/
- Kompilator online (do szybkiego testowania): https://www.jdoodle.com/online-java-compiler/

---

## OCENA I FEEDBACK

### Jak oceniać studentów:
- **Uczestnictwo** - czy próbują rozwiązywać zadania?
- **Zrozumienie** - czy potrafią wyjaśnić co robi ich kod?
- **Samodzielność** - czy radzą sobie z zadaniami BONUS?

### Po zajęciach:
- Poproś o feedback (co było trudne? co pomóc?)
- Zanotuj problemy, żeby poprawić na kolejnych zajęciach
- Udostępnij studentom rozwiązania

---

**Powodzenia! 🚀**
