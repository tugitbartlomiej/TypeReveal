# 🎮 Interaktywna Wizualizacja Sortowania

## ✨ Co zostało dodane?

### Slajd 3: Sortowanie kontrolowane strzałkami!

Tak jak animowany kod - możesz kontrolować **każdy krok sortowania** używając strzałek!

## 🎯 Jak to działa?

### Sterowanie:
- **→ lub Spacja** - następny krok sortowania
- **Przycisk "Następny krok"** - to samo co strzałka
- **Przycisk "Reset"** - zacznij od początku
- **Przycisk "Auto play"** - automatyczne odtwarzanie (1 krok/sekundę)

### Kroki sortowania:
1. **Porównanie** (żółte elementy unoszą się) - porównujemy dwa elementy
2. **Zamiana** (czerwone elementy) - elementy się zamieniają
3. **Posortowane** (zielone elementy) - element już na swoim miejscu
4. **Zakończenie** - wszystko zielone ✓

### Przykładowa sekwencja:

```
Start: [5, 2, 8, 1, 9]

Krok 1: Porównuję 5 i 2 (żółte podświetlenie)
Krok 2: Zamieniam 5 ↔ 2 (czerwone)
Krok 3: Po zamianie: [2, 5, 8, 1, 9]

Krok 4: Porównuję 5 i 8 (żółte)
Krok 5: Bez zamiany (5 ≤ 8)

Krok 6: Porównuję 8 i 1 (żółte)
Krok 7: Zamieniam 8 ↔ 1 (czerwone)
...

Krok N: Element 9 na pozycji 4 jest posortowany ✓ (zielone)

Koniec: ✓ Sortowanie zakończone! [1, 2, 5, 8, 9]
```

## 🎨 Kolory:

- 🔵 **Niebieski** - element niesortowany
- 🟡 **Żółty (uniesiony)** - element porównywany
- 🔴 **Czerwony** - element zamieniany
- 🟢 **Zielony** - element posortowany

## 🆚 Różnice: Manim vs JavaScript

### Manim (Slajd 3b - wideo):
✅ Piękne, profesjonalne animacje
✅ Możesz eksportować do YT, PDF
❌ Brak kontroli - tylko odtwarzanie

### JavaScript (Slajd 3 - interaktywny):
✅ **Pełna kontrola krok po kroku**
✅ Studenci mogą eksperymentować
✅ Bez renderowania - działa natychmiast
❌ Prostsze graficznie niż Manim

## 💡 Rozszerzanie

Chcesz dodać inne algorytmy? Zmień funkcję `generateSortingSteps()`:

### Quick Sort:
```javascript
let array = [5, 2, 8, 1, 9];  // Zmień na dowolną tablicę

function generateSortingSteps() {
  // Twoja implementacja QuickSort krok po kroku
}
```

### Inne struktury danych:
- Stos (push/pop)
- Kolejka (enqueue/dequeue)
- Lista powiązana (insert/delete)
- Drzewo binarne (wstawianie)

## 🚀 Użycie na zajęciach

### Scenariusz 1: Wprowadzenie
1. Pokaż kod sortowania (Slajd 2 - animowany kod)
2. Uruchom **Auto play** na sortowaniu (Slajd 3)
3. Studenci widzą jak algorytm działa

### Scenariusz 2: Szczegółowe wyjaśnienie
1. Przejdź na Slajd 3
2. Wciskaj **→** po każdym kroku
3. Wyjaśniaj co się dzieje przy każdym porównaniu/zamianie
4. Studenci mogą zadawać pytania między krokami

### Scenariusz 3: Quiz
1. Pytanie: "Co się stanie w następnym kroku?"
2. Studenci zgadują
3. Wciskasz **→** i pokazujesz odpowiedź
4. Dyskusja

### Scenariusz 4: Praca domowa
1. Wyślij link do prezentacji
2. Studenci mogą sami krokować przez sortowanie
3. Eksperymentować z przyciskami

## 🎓 Edukacyjne korzyści

✅ **Wizualizacja** - studenci widzą co się dzieje
✅ **Interaktywność** - kontrolują tempo
✅ **Powtarzalność** - mogą wracać do trudnych kroków
✅ **Zaangażowanie** - aktywne uczestnictwo
✅ **Zrozumienie** - widzą każdy krok algorytmu

---

**Następny krok:** Dodaj własne algorytmy (Quick Sort, Merge Sort, Binary Search)!
