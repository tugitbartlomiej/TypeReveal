# 📂 Struktura Prezentacji - Każdy Slajd w Osobnym Pliku

## 🎯 Nowa Struktura

```
Prezentacja/
├── index.html              ← Główny plik (style + JavaScript + logika wczytywania)
├── slides/                 ← Folder ze slajdami
│   ├── slide-00-tytul.html
│   ├── slide-01-problem.html
│   ├── slide-02-kod-start.html          (z animacją)
│   ├── slide-03-analiza.html
│   ├── slide-04-ifelse.html             (z animacją)
│   ├── slide-05-dlaczego-zle.html
│   ├── slide-06-interfejs.html          (z animacją)
│   ├── slide-07-kluczowa-koncepcja.html
│   ├── slide-08-nadal-problem.html
│   ├── slide-09-factory-method.html     (z animacją)
│   ├── slide-10-wizualizacja.html
│   ├── slide-11-porownanie.html
│   ├── slide-12-abstract-intro.html
│   ├── slide-13-abstract-diagram.html
│   ├── slide-14-kiedy-uzywac.html
│   ├── slide-15-podsumowanie.html
│   └── slide-16-dziekuje.html
└── README_SLAJDY.md        ← Ten plik
```

---

## ✏️ Jak Edytować Slajdy?

### Opcja 1: Edytuj tylko jeden slajd

```bash
# Otwórz slajd który chcesz zmienić:
notepad slides/slide-03-analiza.html

# Zapisz zmiany
# Odśwież przeglądarkę (F5)
# Gotowe!
```

### Opcja 2: Dodaj nowy slajd

1. **Stwórz nowy plik** w folderze `slides/`:
   ```bash
   notepad slides/slide-17-nowy-slajd.html
   ```

2. **Napisz HTML slajdu**:
   ```html
   <section>
     <h3>Mój Nowy Slajd</h3>
     <p>Treść slajdu...</p>
   </section>
   ```

3. **Dodaj do `index.html`** (linia 171-189):
   ```javascript
   const slideFiles = [
     'slides/slide-00-tytul.html',
     // ... (pozostałe)
     'slides/slide-16-dziekuje.html',
     'slides/slide-17-nowy-slajd.html'  // ← DODAJ TUTAJ
   ];
   ```

4. **Odśwież przeglądarkę** (F5)

---

## 🎨 Dostępne Style (Gotowe do Użycia)

Wszystkie style są w `index.html` i automatycznie działają na slajdach:

### 1. Problem Box (czerwony)
```html
<div class="problem-box">
  <h4>❌ Problem:</h4>
  <p>Opis problemu...</p>
</div>
```

### 2. Solution Box (zielony)
```html
<div class="solution-box">
  <h4>✅ Rozwiązanie:</h4>
  <p>Opis rozwiązania...</p>
</div>
```

### 3. Tabela Porównawcza
```html
<table class="comparison-table">
  <thead>
    <tr>
      <th>Kolumna 1</th>
      <th>Kolumna 2</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><span class="good">✅</span> Dobrze</td>
      <td><span class="bad">❌</span> Źle</td>
    </tr>
  </tbody>
</table>
```

### 4. Diagram Container
```html
<div class="diagram-container">
  <div class="diagram-box">Box 1</div>
  <div class="diagram-arrow">⬇️</div>
  <div class="diagram-box">Box 2</div>
</div>
```

### 5. Gradient Background
```html
<section data-background-gradient="linear-gradient(135deg, #667eea 0%, #764ba2 100%)">
  <h2>Slajd z gradientem</h2>
</section>
```

---

## 🔧 Slajdy z Animacją Kodu

4 slajdy mają animowany kod (pisanie znak po znaku):

1. **slide-02-kod-start.html** - Kod problemu
2. **slide-04-ifelse.html** - If-else (zła próba)
3. **slide-06-interfejs.html** - Rozwiązanie interfejsem
4. **slide-09-factory-method.html** - Factory Method

### Jak działa animacja?

Każdy slajd animowany ma:

```html
<section id="code-slide-start">
  <h3>Tytuł</h3>

  <!-- Kod będzie pisany tutaj -->
  <pre><code id="code-start" class="language-java"></code></pre>

  <!-- Przyciski sterowania -->
  <div class="controls-local">
    <button id="next-start">Następny fragment</button>
    <button id="undo-start">Cofnij</button>
    <button id="reset-start">Reset</button>
    <label>Prędkość:
      <input id="speed-start" type="range" min="5" max="100" value="20">
    </label>
  </div>

  <!-- JSON z krokami animacji -->
  <script type="application/json" id="steps-start">
  [
    "// Komentarz",
    "\nclass BMW {",
    "\n    String marka = \"BMW M5\";",
    // ...
  ]
  </script>
</section>
```

### Interaktywne zastępowanie linii (type-guessing):

Użyj prefiksu `<<REPLACE_LINE>>`:

```json
[
  "\n    marka = \"BMW M5\";",
  "<<REPLACE_LINE>>    String marka = \"BMW M5\";"
]
```

To:
1. Napisze: `marka = "BMW M5";`
2. Po naciśnięciu → **skasuje** tę linię i **przepisze** z typem: `String marka = "BMW M5";`

---

## 🚀 Jak Uruchomić Prezentację?

### 1. Lokalnie (potrzeba serwera HTTP)

**Ważne**: Ze względu na `fetch()` plik musi być otwarty przez serwer HTTP, nie `file://`.

**Python 3:**
```bash
cd "F:\Studia\Studiowanie\Sem8\Java\LAB\Lab3\Zadania\Fabryka\Prezentacja"
python -m http.server 8000
```

Potem otwórz: http://localhost:8000

**Live Server (VS Code):**
- Zainstaluj rozszerzenie "Live Server"
- Kliknij prawym na `index.html` → "Open with Live Server"

---

## 📝 Zalety Nowej Struktury

✅ **Łatwa edycja** - każdy slajd w osobnym pliku
✅ **Przejrzystość** - kod nie jest w jednym 1000+ linijkowym pliku
✅ **Git-friendly** - łatwo zobaczyć zmiany w konkretnym slajdzie
✅ **Reużywalność** - możesz kopiować slajdy między prezentacjami
✅ **Wszystkie style w jednym miejscu** - `index.html` zawiera całe CSS
✅ **Zachowana funkcjonalność** - animacje działają tak samo

---

## 🔍 Debugowanie

### Problem: Slajd nie ładuje się

**Sprawdź konsolę przeglądarki** (F12):
```
Błąd wczytywania slajdu: slides/slide-03-analiza.html
```

**Rozwiązanie:**
- Sprawdź czy plik istnieje
- Sprawdź czy nazwa w `index.html` (linia 171-189) jest poprawna
- Upewnij się że serwer HTTP jest uruchomiony (nie `file://`)

### Problem: Animacja nie działa

**Sprawdź:**
1. Czy slajd ma poprawne ID: `id="code-slide-start"`
2. Czy jest w `initializeAnimatedSlides()` w `index.html` (linia 362-405)
3. Czy JSON `steps-*` jest poprawny (brak przecinków na końcu)

---

## 📋 Checklist: Dodawanie Nowego Slajdu

- [ ] Stworzono plik `slides/slide-XX-nazwa.html`
- [ ] Dodano do `slideFiles[]` w `index.html` (linia 171-189)
- [ ] Jeśli animowany: dodano do `initializeAnimatedSlides()` (linia 362-405)
- [ ] Przetestowano w przeglądarce
- [ ] Nawigacja → i ← działa poprawnie

---

## 🎓 Edycja Treści Slajdów

### Zmiana tytułu slajdu:
```html
<!-- PRZED -->
<h3>Stary Tytuł</h3>

<!-- PO -->
<h3>Nowy Tytuł</h3>
```

### Zmiana kodu Java:
```html
<!-- W slajdzie animowanym edytuj JSON: -->
<script type="application/json" id="steps-start">
[
  "// Nowy komentarz",
  "\nclass NowaKlasa {",
  // ...
]
</script>
```

### Zmiana tekstu:
```html
<!-- PRZED -->
<p>Stary tekst</p>

<!-- PO -->
<p>Nowy tekst</p>
```

---

## 📞 Pytania?

- Wszystkie style są w **index.html** (linia 17-156)
- Wszystkie slajdy są w folderze **slides/**
- Logika animacji jest w **index.html** (linia 220-406)
- Lista slajdów do wczytania: **index.html** (linia 171-189)

**Powodzenia w edycji!** 🚀
