# 🔨 Budowanie Prezentacji - index.html

## 📋 Co To Jest?

Prezentacja ma **2 wersje**:

### 1. **Wersja Modularna** (dla edycji)
- Slajdy w osobnych plikach: `slides/slide-XX.html`
- Wczytywane dynamicznie przez `fetch()`
- **Wymaga serwera HTTP** (nie działa przez `file://`)
- Używaj tego do edycji pojedynczych slajdów

### 2. **Wersja Standalone** (do uruchomienia)
- Wszystkie slajdy w jednym `index.html`
- **Działa przez `file://`** - wystarczy kliknąć dwukrotnie!
- Budowana automatycznie ze slajdów modularnych

---

## 🚀 Jak Zbudować index.html?

### Sposób 1: Python (Automatycznie)

```bash
# Uruchom skrypt budujący
python build_standalone.py
```

**Gotowe!** Skrypt:
1. Wczytuje wszystkie slajdy z `slides/`
2. Łączy je w jeden plik `index.html`
3. Dodaje style CSS i JavaScript
4. Zapisuje gotowy plik

### Sposób 2: Ręcznie (Jeśli Python nie działa)

Nie zalecane - użyj skryptu!

---

## ✏️ Workflow - Jak Edytować Prezentację?

### Krok 1: Edytuj Slajd

```bash
# Otwórz slajd który chcesz zmienić
notepad slides/slide-05-dlaczego-zle.html

# Edytuj HTML
# Zapisz
```

### Krok 2: Przebuduj index.html

```bash
# Uruchom skrypt
python build_standalone.py
```

### Krok 3: Testuj

```bash
# Kliknij dwukrotnie na index.html
# lub
start index.html
```

**Gotowe!** Zmiany są widoczne!

---

## 📂 Struktura Plików

```
Prezentacja/
├── index.html                 ← Wygenerowany (NIE edytuj ręcznie!)
├── build_standalone.py        ← Skrypt budujący
├── slides/                    ← Edytuj te pliki!
│   ├── slide-00-tytul.html
│   ├── slide-01-problem.html
│   ├── slide-02-kod-start.html
│   └── ...
├── index-modular-backup.html  ← Backup wersji modularnej
└── BUILD_README.md            ← Ten plik
```

---

## ⚠️ WAŻNE!

### ❌ NIE edytuj `index.html` ręcznie!

**Dlaczego?**
- `index.html` jest **generowany automatycznie**
- Każde uruchomienie `build_standalone.py` **nadpisuje** index.html
- Twoje ręczne zmiany **zostaną utracone**!

### ✅ Edytuj pliki w `slides/`

```bash
# DOBRZE
notepad slides/slide-03-analiza.html

# ŹLE
notepad index.html  # Zostanie nadpisany!
```

---

## 🔄 Jak Dodać Nowy Slajd?

### Krok 1: Stwórz plik slajdu

```bash
notepad slides/slide-17-nowy-slajd.html
```

### Krok 2: Napisz HTML

```html
<section>
  <h3>Mój Nowy Slajd</h3>
  <p>Treść...</p>
</section>
```

### Krok 3: Dodaj do build_standalone.py

Otwórz `build_standalone.py` i dodaj do listy `SLIDE_FILES` (linia ~11):

```python
SLIDE_FILES = [
    "slide-00-tytul.html",
    # ... (pozostałe)
    "slide-16-dziekuje.html",
    "slide-17-nowy-slajd.html",  # ← DODAJ TUTAJ
]
```

### Krok 4: Przebuduj

```bash
python build_standalone.py
```

**Gotowe!** Nowy slajd jest w `index.html`!

---

## 🛠️ Rozwiązywanie Problemów

### Problem: "python: command not found"

**Rozwiązanie:**
- Zainstaluj Python: https://www.python.org/downloads/
- Lub użyj `py` zamiast `python`:
  ```bash
  py build_standalone.py
  ```

### Problem: Slajd nie pojawia się w prezentacji

**Sprawdź:**
1. Czy plik istnieje w `slides/`?
2. Czy nazwa pliku jest w `SLIDE_FILES` w `build_standalone.py`?
3. Czy uruchomiłeś `python build_standalone.py` po zmianach?

### Problem: Animacje nie działają

**Sprawdź:**
1. Czy slajd ma poprawne `id` (np. `id="code-slide-start"`)?
2. Czy inicjalizacja jest w footer HTML w `build_standalone.py`?
3. Czy JSON `steps-*` jest poprawny?

---

## 📊 Statystyki

Po uruchomieniu `build_standalone.py` zobaczysz:

```
[OK] Gotowe! Utworzono index.html (37401 znakow)
[*] Slajdow: 17
```

**Rozmiar:** ~37 KB (wszystkie slajdy + style + JavaScript)

---

## 💡 Tips

### Szybka przebudowa

Stwórz plik `build.bat` (Windows):

```batch
@echo off
python build_standalone.py
start index.html
```

Potem wystarczy kliknąć dwukrotnie `build.bat`!

### Git

Dodaj do `.gitignore`:

```
index.html
```

Dlaczego? Bo `index.html` jest generowany, nie potrzebujesz go w repozytorium.
Commituj tylko `slides/` i `build_standalone.py`.

---

## 🎯 Podsumowanie

| Co robisz | Gdzie edytujesz | Co uruchamiasz |
|-----------|-----------------|----------------|
| **Zmiana slajdu** | `slides/slide-XX.html` | `python build_standalone.py` |
| **Nowy slajd** | `slides/slide-XX.html` + `build_standalone.py` | `python build_standalone.py` |
| **Zmiana stylu** | `build_standalone.py` (HEADER) | `python build_standalone.py` |
| **Zmiana JavaScript** | `build_standalone.py` (FOOTER) | `python build_standalone.py` |

---

## ✅ Checklist

Przed edycją:
- [ ] Wiem który slajd chcę zmienić
- [ ] Otwieram plik w `slides/`

Po edycji:
- [ ] Zapisałem zmiany
- [ ] Uruchomiłem `python build_standalone.py`
- [ ] Otworzyłem `index.html` i przetestowałem

---

**Gotowe!** Teraz wiesz jak edytować i budować prezentację! 🚀

---

*Utworzono: 2025-10-22*
*Lokalizacja: F:\Studia\Studiowanie\Sem8\Java\LAB\Lab3\Zadania\Fabryka\Prezentacja*
