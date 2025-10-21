# 🎬 Prezentacja Java z Animacjami

## 📁 Struktura projektu

```
Test/
├── index.html           ← Główny plik prezentacji
├── animations/          ← Wideo z Manim (MP4)
├── images/              ← Statyczne obrazy i GIFy
├── videos/              ← Inne wideo
└── README.md            ← Ten plik
```

## 🎯 Co zostało dodane?

### Slajd 1: Tytuł
Podstawowy slajd tytułowy

### Slajd 2: Animowane pisanie kodu ✅
- Twój oryginalny slajd z animacją pisania
- Każda linia dopisuje się do poprzednich
- Kontrolki: Następny fragment, Cofnij, Prędkość

### Slajd 3: Wideo Manim 🎥
```html
<video width="800" controls autoplay loop muted>
  <source src="animations/sorting.mp4" type="video/mp4">
</video>
```
**Jak dodać:** Wygeneruj wideo Manim i wstaw do folderu `animations/`

### Slajd 4: Kod + GIF obok 📊
Dwie kolumny: kod Java po lewej, animowany GIF po prawej
```
[Kod Java]  |  [GIF wizualizacji]
```

### Slajd 5: Statyczny diagram 📈
Wykres złożoności Big O

### Slajd 6: Wideo jako tło 🌌
```html
<section data-background-video="animations/recursion.mp4">
```
Pełnoekranowa animacja jako tło slajdu

### Slajd 7: Trzy kolumny 📋
```
[Kod] | [Output] | [Animacja]
```
Kompletny przykład z wykonaniem

### Slajd 8: Interaktywne iframe 🔄
Osadzona strona VisuAlgo - studenci mogą klikać i eksperymentować

## 🚀 Jak używać z Manim?

### 1. Zainstaluj Manim
```bash
pip install manim
```

### 2. Stwórz animację
```python
# sorting_animation.py
from manim import *

class BubbleSort(Scene):
    def construct(self):
        arr = [5, 2, 8, 1, 9]
        squares = VGroup(*[
            Square().set_fill(BLUE, opacity=0.5).scale(0.5)
            for _ in arr
        ]).arrange(RIGHT)

        self.play(Create(squares))
        # ... twoja animacja sortowania
```

### 3. Wygeneruj wideo
```bash
manim -pqh sorting_animation.py BubbleSort
```

### 4. Przenieś do projektu
```bash
cp media/videos/sorting_animation/1080p60/BubbleSort.mp4 animations/sorting.mp4
```

## 📦 Przykładowe zasoby do dodania

Stwórz te pliki w odpowiednich folderach:

### `animations/`
- `sorting.mp4` - algorytmy sortowania
- `recursion.mp4` - wizualizacja rekurencji
- `tree_traversal.mp4` - przechodzenie drzewa

### `images/`
- `array_memory.gif` - alokacja pamięci
- `bubble_sort.gif` - krok po kroku
- `complexity_chart.png` - Big O notation

## 🎮 Sterowanie prezentacją

- **→ lub Spacja** - następny slajd/fragment
- **← lub Shift+Spacja** - poprzedni slajd
- **Esc** - widok wszystkich slajdów
- **F** - pełny ekran

## 💡 Przykładowe pomysły na animacje Manim

### Struktury danych:
- Stosy i kolejki (push/pop)
- Listy powiązane (insert/delete)
- Drzewa binarne (wstawianie/usuwanie)
- Grafy (DFS/BFS)

### Algorytmy:
- Sortowanie (bubble, quick, merge)
- Wyszukiwanie (binary search)
- Rekurencja (Fibonacci, factorial)
- Dynamiczne programowanie

### Koncepcje Java:
- Garbage Collection
- Polimorfizm
- Wątki i synchronizacja
- Streams API

## 🔧 Dostosowywanie

### Zmiana prędkości animacji kodu
```javascript
value="30"  // mniejsza wartość = szybciej
```

### Dodanie własnego slajdu z kodem
```html
<section id="my-slide">
  <h3>Mój przykład</h3>
  <pre><code id="my-code" class="language-java"></code></pre>

  <script type="application/json" id="my-steps">
  [
    "public class MyClass {",
    "\n    // Twój kod tutaj"
  ]
  </script>
</section>
```

## 📚 Dodatkowe zasoby

- [Manim Community](https://www.manim.community/)
- [Reveal.js Docs](https://revealjs.com/)
- [VisuAlgo](https://visualgo.net) - gotowe wizualizacje
- [Algorithm Visualizer](https://algorithm-visualizer.org/)

---

Stworzone dla zajęć z Javy - Sem8 🎓
