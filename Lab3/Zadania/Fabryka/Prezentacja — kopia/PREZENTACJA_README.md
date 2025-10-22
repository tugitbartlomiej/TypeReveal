# 🎯 Prezentacja: Wzorce Factory - Salon Bajtazara

## 📍 Lokalizacja

`F:\Studia\Studiowanie\Sem8\Java\LAB\Lab3\Zadania\Fabryka\Prezentacja\index.html`

---

## 📂 Nowa Struktura - Każdy Slajd w Osobnym Pliku! ⭐

**✅ Od teraz każdy slajd jest w osobnym pliku HTML!**

```
Prezentacja/
├── index.html              ← Główny plik (style + JavaScript)
├── slides/                 ← 17 slajdów jako osobne pliki
│   ├── slide-00-tytul.html
│   ├── slide-01-problem.html
│   ├── slide-02-kod-start.html (z animacją)
│   ├── ...
│   └── slide-16-dziekuje.html
└── README_SLAJDY.md        ← Instrukcja edycji slajdów
```

**💡 Zalety:**
- ✅ Łatwa edycja - każdy slajd osobno
- ✅ Przejrzysty kod
- ✅ Łatwe kopiowanie slajdów między prezentacjami
- ✅ Git-friendly

**📖 Jak edytować?** Zobacz `README_SLAJDY.md`

---

## 🚀 Jak Uruchomić?

**WAŻNE:** Prezentacja używa `fetch()` do wczytywania slajdów, więc **wymaga serwera HTTP**.

### ❌ NIE ZADZIAŁA: `file://`

```bash
# To NIE zadziała (brak dostępu do fetch):
start index.html
```

### ✅ ZADZIAŁA: Serwer HTTP

**Opcja 1: Python (zalecane)**

```bash
# Przejdź do folderu prezentacji
cd "F:\Studia\Studiowanie\Sem8\Java\LAB\Lab3\Zadania\Fabryka\Prezentacja"

# Uruchom serwer HTTP
python -m http.server 8000

# Otwórz w przeglądarce:
# http://localhost:8000/index.html
```

**Opcja 2: Live Server (VS Code)**

1. Zainstaluj rozszerzenie "Live Server" w VS Code
2. Kliknij prawym na `index.html` → "Open with Live Server"
3. Prezentacja otworzy się automatycznie w przeglądarce

**Opcja 3: Inny serwer HTTP**

Użyj dowolnego serwera HTTP (np. `http-server` z Node.js):

```bash
npx http-server -p 8000
```

---

## 🎮 Sterowanie Prezentacją

### Nawigacja:

- **→** lub **Spacja** - Następny slajd / Następny fragment kodu
- **←** - Poprzedni slajd
- **Home** - Pierwszy slajd
- **End** - Ostatni slajd
- **ESC** - Przegląd wszystkich slajdów

### Animowane pisanie kodu:

- **→** lub **Spacja** - Następny fragment kodu
- **Przycisk "Następny fragment"** - To samo
- **Przycisk "Cofnij"** - Cofa ostatni fragment
- **Przycisk "Reset"** - Reset slajdu
- **Suwak "Prędkość"** - Zmienia szybkość pisania

---

## 📚 Struktura Prezentacji

### Slajdy (16 total):

1. **Slajd 0:** Tytuł - Wzorce Factory
2. **Slajd 1:** Wprowadzenie - Problem (4 samochody)
3. **Slajd 2:** Kod START - Animowane pisanie (Problem)
4. **Slajd 3:** Analiza - Co jest złego?
5. **Slajd 4:** If-else - Animowane pisanie (Zła próba)
6. **Slajd 5:** Dlaczego if-else to ZŁE?
7. **Slajd 6:** Interfejs - Animowane pisanie (Rozwiązanie 1)
8. **Slajd 7:** Kluczowa koncepcja: `pokazSpecjalneFunkcje()`
9. **Slajd 8:** Nadal problem (potrzeba fabryki)
10. **Slajd 9:** Factory Method - Animowane pisanie (Wzorzec!)
11. **Slajd 10:** Wizualizacja Factory Method (diagram)
12. **Slajd 11:** Porównanie rozwiązań (tabela)
13. **Slajd 12:** Abstract Factory - Wprowadzenie
14. **Slajd 13:** Abstract Factory - Diagram
15. **Slajd 14:** Kiedy używać którego wzorca?
16. **Slajd 15:** Podsumowanie
17. **Slajd 16:** Dziękuję!

---

## 🎨 Kluczowe Funkcje

### 1. Animowane Pisanie Kodu (INTERAKTYWNE!)

Kod Java pisze się **znak po znaku** jak na żywo!

- Slajd 2: Problem (START) **← Z INTERAKCJĄ!**
- Slajd 4: If-else
- Slajd 6: Interfejs
- Slajd 9: Factory Method

**Sterowanie:**
- Klikaj → lub spację aby dopisać kolejny fragment
- Suwak kontroluje prędkość pisania
- Przycisk "Cofnij" cofa ostatni fragment

**🎓 ĆWICZENIE DLA STUDENTÓW (Slajd 2):**

Na slajdzie START kod najpierw pisze się **BEZ typu zmiennej**:
```java
marka = "BMW M5";
```

**STOP tutaj!** Zapytaj studentów:
> "Jakiego typu jest ta zmienna?"

Po odpowiedzi studentów, kliknij → i kod **automatycznie kasuje** starą linię i przepisuje z typem:
```java
String marka = "BMW M5";
```

To samo dzieje się z `cena`!

**Sekwencja:**
1. Kod pisze: `marka = "BMW M5";`
2. **STOP** - pytasz: "Jakiego typu?"
3. Studenci odpowiadają: "String!"
4. Klikasz → - kod kasuje i przepisuje: `String marka = "BMW M5";`
5. Kod pisze: `cena = 300000;`
6. **STOP** - pytasz: "Jakiego typu?"
7. Studenci: "int!"
8. Klikasz → - kod kasuje i przepisuje: `int cena = 300000;`

**To samo dla klasy Koenigsegg!**

### 2. Diagramy i Wizualizacje

- **Slajd 7:** Przed/Po - porównanie z/bez interfejsu
- **Slajd 10:** Diagram Factory Method (przepływ)
- **Slajd 11:** Tabela porównawcza (START → IF-ELSE → INTERFEJS → FACTORY)
- **Slajd 13:** Diagram Abstract Factory (rodziny produktów)

### 3. Kolorowe Boxy

- **Problem box** (czerwony) - pokazuje problemy
- **Solution box** (zielony) - pokazuje rozwiązania
- **Tabele** - porównania z ✅/❌

---

## 📖 Scenariusz Wykładu

### Rekomendowany przepływ (45-50 minut):

#### Faza 1: Problem (10 min)
- **Slajd 0-1:** Intro - Salon Bajtazara
- **Slajd 2:** Pokaz kod START (animacja) **← INTERAKTYWNE!**
  - Klikaj fragment po fragmencie
  - **STOP po `marka = "BMW M5";`** ← WAŻNE!
  - Zapytaj: "Jakiego typu jest marka?"
  - Studenci: "String!"
  - Kliknij → - kod kasuje i dopisuje `String`
  - **STOP po `cena = 300000;`** ← WAŻNE!
  - Zapytaj: "Jakiego typu jest cena?"
  - Studenci: "int!"
  - Kliknij → - kod kasuje i dopisuje `int`
  - To samo dla Koenigsegg!
  - Podkreśl: Koenigsegg ma 3 metody!
- **Slajd 3:** Analiza - co jest złego

#### Faza 2: Zła próba (10 min)
- **Slajd 4:** Pokaz if-else (animacja)
  - Podkreśl: duplikacja w 3 miejscach!
- **Slajd 5:** Dlaczego to złe (tabela)
  - Dodanie Ferrari = 10 miejsc do zmiany

#### Faza 3: Rozwiązanie - Interfejs (10 min)
- **Slajd 6:** Pokaz interfejs (animacja)
  - **KLUCZOWE:** `pokazSpecjalneFunkcje()` - jedna metoda!
  - Koenigsegg wywołuje 3 funkcje automatycznie!
- **Slajd 7:** Wyjaśnij polimorfizm
  - Przed: 3 różne metody
  - Po: 1 metoda, różne implementacje

#### Faza 4: Factory Method (10 min)
- **Slajd 8:** Nadal problem - "new BMW()"
- **Slajd 9:** Pokaz Factory Method (animacja)
  - **KLUCZOWE:** Zwraca `Samochod`, nie `BMW`!
- **Slajd 10:** Diagram Factory
- **Slajd 11:** Porównanie (tabela)

#### Faza 5: Abstract Factory (5-7 min)
- **Slajd 12:** Problem - para aut
- **Slajd 13:** Abstract Factory diagram
- **Slajd 14:** Kiedy używać której fabryki

#### Faza 6: Podsumowanie (3-5 min)
- **Slajd 15:** Recap + SOLID
- **Slajd 16:** Q&A

---

## 💡 Kluczowe Momenty "AHA!"

### Moment 1: pokazSpecjalneFunkcje() (Slajd 6-7)
```java
class Koenigsegg implements Samochod {
    public void pokazSpecjalneFunkcje() {
        // Wywołuje WSZYSTKIE 3 automatycznie!
        System.out.println("TRYB 1600 KM!");
        System.out.println("NITRO!");
        System.out.println("Prędkość: 483 km/h!");
    }
}
```

**Mówisz:** "Jedna metoda w interfejsie → różne implementacje! To jest polimorfizm!"

### Moment 2: Fabryka zwraca interfejs (Slajd 9-10)
```java
public static Samochod stworzSamochod(String marka)
                ↑
          ZWRACA INTERFEJS!
```

**Mówisz:** "Zwraca Samochod, nie BMW czy Jaguar! To pozwala na polimorfizm!"

### Moment 3: Porównanie (Slajd 11)

**Tabela pokazuje:**
- IF-ELSE: Dodanie Ferrari = 10 miejsc
- FACTORY: Dodanie Ferrari = 2 miejsca (klasa + case)

**Mówisz:** "If-else w JEDNYM miejscu vs if-else WSZĘDZIE!"

---

## 🎯 Tips dla Prowadzącego

### 1. Użyj Animacji Świadomie

**NIE klikaj automatycznie!**

Przy każdym fragmencie kodu:
1. Poczekaj aż się wypisze
2. Przeczytaj głośno co się pojawiło
3. Skomentuj ("Widzicie? 3 metody!")
4. Dopiero potem klikaj →

### 2. Podkreślaj Kluczowe Rzeczy

**Używaj wskaźnika laserowego / kursora:**
- `pokazSpecjalneFunkcje()` - tu jest klucz!
- `public static Samochod` - zwraca interfejs!
- Koenigsegg z 3 metodami

### 3. Zadawaj Pytania

**Przykłady:**
- "Co jest WSPÓLNE dla wszystkich aut?"
- "Dlaczego if-else to zły pomysł?"
- "Jak Koenigsegg może mieć 3 metody skoro interfejs ma jedną?"

### 4. Używaj Pauzy

**Po kluczowych slajdach:**
- Slajd 7 (polimorfizm) - pauza, pytania
- Slajd 11 (porównanie) - pauza, dyskusja
- Slajd 15 (podsumowanie) - pauza, recap

---

## 🔧 Dostosowywanie Prezentacji

### Zmiana prędkości pisania:

W kodzie HTML znajdź:
```html
<input id="speed-start" type="range" min="5" max="100" value="20">
```

Zmień `value="20"` na np. `value="10"` (szybciej) lub `value="40"` (wolniej)

### Dodanie nowych slajdów:

Skopiuj strukturę istniejącego slajdu:
```html
<section>
  <h3>Twój Tytuł</h3>
  <p>Treść...</p>
</section>
```

### Zmiana motywu:

W `<link>` znajdź:
```html
<link rel="stylesheet" href="https://unpkg.com/reveal.js/dist/theme/black.css" id="theme">
```

Zmień `black.css` na: `white.css`, `league.css`, `sky.css`, itp.

---

## ⚠️ Wymagania

### Minimalne:

- **Przeglądarka:** Chrome, Firefox, Edge (wersja aktualna)
- **Internet:** Tak (do załadowania Reveal.js, Prism.js z CDN)
- **JavaScript:** Włączony

### Opcjonalne:

- Pełny ekran (F11) dla lepszego efektu
- Duży ekran / projektor
- Wskaźnik laserowy

---

## 📦 Co Jest W Środku?

### Technologie:

- **Reveal.js** - framework prezentacji
- **Prism.js** - kolorowanie kodu Java
- **Custom JavaScript** - animowane pisanie kodu

### Funkcje:

✅ Animowane pisanie kodu (znak po znaku)
✅ Kontrola prędkości pisania
✅ Cofanie fragmentów kodu
✅ Diagramy i wizualizacje
✅ Kolorowe boxy (problem/rozwiązanie)
✅ Tabele porównawcze
✅ Gradient backgrounds
✅ Nawigacja klawiaturą

---

## 🐛 Troubleshooting

### Problem: Animacja nie działa

**Rozwiązanie:** Sprawdź konsolę (F12). Upewnij się że:
1. Prism.js załadował się (sprawdź Network w DevTools)
2. Nie ma błędów JavaScript w konsoli

### Problem: Kod się nie koloruje

**Rozwiązanie:** Upewnij się że:
1. Masz `class="language-java"` w `<code>`
2. Prism.js załadował się z CDN

### Problem: Slajdy się nie przełączają

**Rozwiązanie:**
- Użyj przycisków na dole zamiast strzałek
- Sprawdź czy nie jesteś na slajdzie z animacją (dokończ animację)

---

## 📞 Pytania?

Jeśli masz pytania lub problemy:
1. Sprawdź dokumentację Reveal.js: https://revealjs.com/
2. Sprawdź ten plik README
3. Otwórz konsolę (F12) i szukaj błędów

---

## ✅ Checklist Przed Wykładem

- [ ] Przetestowałem prezentację w przeglądarce
- [ ] Sprawdziłem że animacje działają
- [ ] Przeczytałem scenariusz wykładu
- [ ] Przygotowałem wskaźnik laserowy
- [ ] Wiem które slajdy są kluczowe
- [ ] Wiem gdzie są momenty "AHA!"
- [ ] Przygotowałem przykładowe pytania dla studentów

---

**Powodzenia na wykładzie!** 🚀

---

*Prezentacja utworzona: 2025-10-22*
*Temat: Wzorce Factory - Salon Bajtazara*
*Autor: [Twoje imię]*
