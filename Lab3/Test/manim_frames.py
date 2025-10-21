"""
Manim - generowanie PNG dla każdego kroku sortowania
Każdy krok = osobny obraz, potem kontrola w JS
"""

from manim import *

class BubbleSortStepByStep(Scene):
    """Generuje osobny PNG dla każdego kroku sortowania"""

    def construct(self):
        # Tytuł
        title = Text("Bubble Sort - Krok po kroku", font_size=40)
        title.to_edge(UP)
        self.add(title)

        # Tablica do posortowania
        arr = [5, 2, 8, 1, 9]
        n = len(arr)

        # Tworzenie wizualnych elementów
        squares = VGroup()
        numbers = VGroup()

        for i, val in enumerate(arr):
            square = Square(side_length=1.2)
            square.set_fill(BLUE, opacity=0.6)
            square.set_stroke(WHITE, width=2)
            square.shift(RIGHT * (i * 1.5 - 3))

            num = Text(str(val), font_size=48, color=WHITE, weight=BOLD)
            num.move_to(square.get_center())

            squares.add(square)
            numbers.add(num)

        self.add(squares, numbers)

        # KROK 0: Stan początkowy
        step_text = Text("Tablica początkowa: [5, 2, 8, 1, 9]", font_size=28)
        step_text.to_edge(DOWN)
        self.add(step_text)
        self.wait(0.1)  # Klatka dla kroku 0

        step_counter = 1

        # Główna pętla sortowania
        for i in range(n):
            for j in range(0, n - i - 1):

                # KROK: Podświetl porównywane elementy
                self.remove(step_text)
                step_text = Text(
                    f"Krok {step_counter}: Porównuję {arr[j]} i {arr[j+1]}",
                    font_size=28
                )
                step_text.to_edge(DOWN)
                self.add(step_text)

                self.play(
                    squares[j].animate.set_fill(YELLOW, opacity=0.9),
                    squares[j+1].animate.set_fill(YELLOW, opacity=0.9),
                    squares[j].animate.shift(UP * 0.3),
                    squares[j+1].animate.shift(UP * 0.3),
                    run_time=0.01  # Bardzo szybko - tylko dla klatki
                )
                self.wait(0.1)  # Generuje klatkę PNG
                step_counter += 1

                if arr[j] > arr[j + 1]:
                    # KROK: Zamiana
                    self.remove(step_text)
                    step_text = Text(
                        f"Krok {step_counter}: Zamiana {arr[j]} ↔ {arr[j+1]}",
                        font_size=28,
                        color=RED
                    )
                    step_text.to_edge(DOWN)
                    self.add(step_text)

                    self.play(
                        squares[j].animate.set_fill(RED, opacity=0.9),
                        squares[j+1].animate.set_fill(RED, opacity=0.9),
                        run_time=0.01
                    )
                    self.wait(0.1)  # Klatka zamiany
                    step_counter += 1

                    # Wykonaj animację zamiany
                    self.play(
                        squares[j].animate.shift(RIGHT * 1.5),
                        squares[j+1].animate.shift(LEFT * 1.5),
                        numbers[j].animate.shift(RIGHT * 1.5),
                        numbers[j+1].animate.shift(LEFT * 1.5),
                        run_time=0.01
                    )

                    # Zamień w tablicach
                    arr[j], arr[j+1] = arr[j+1], arr[j]
                    squares[j], squares[j+1] = squares[j+1], squares[j]
                    numbers[j], numbers[j+1] = numbers[j+1], numbers[j]

                    # KROK: Po zamianie
                    self.remove(step_text)
                    step_text = Text(
                        f"Krok {step_counter}: Po zamianie: [{', '.join(map(str, arr))}]",
                        font_size=28
                    )
                    step_text.to_edge(DOWN)
                    self.add(step_text)
                    self.wait(0.1)
                    step_counter += 1

                else:
                    # KROK: Bez zamiany
                    self.remove(step_text)
                    step_text = Text(
                        f"Krok {step_counter}: Bez zamiany ({arr[j]} ≤ {arr[j+1]})",
                        font_size=28,
                        color=GREEN
                    )
                    step_text.to_edge(DOWN)
                    self.add(step_text)
                    self.wait(0.1)
                    step_counter += 1

                # Przywróć pozycję i kolor
                self.play(
                    squares[j].animate.set_fill(BLUE, opacity=0.6).shift(DOWN * 0.3),
                    squares[j+1].animate.set_fill(BLUE, opacity=0.6).shift(DOWN * 0.3),
                    run_time=0.01
                )

            # KROK: Element posortowany
            self.remove(step_text)
            step_text = Text(
                f"Krok {step_counter}: Element {arr[n-i-1]} posortowany ✓",
                font_size=28,
                color=GREEN
            )
            step_text.to_edge(DOWN)
            self.add(step_text)

            self.play(
                squares[n-i-1].animate.set_fill(GREEN, opacity=0.8),
                run_time=0.01
            )
            self.wait(0.1)
            step_counter += 1

        # KROK KOŃCOWY
        self.remove(step_text)
        step_text = Text(
            f"✓ Sortowanie zakończone! [{', '.join(map(str, arr))}]",
            font_size=32,
            color=GREEN,
            weight=BOLD
        )
        step_text.to_edge(DOWN)
        self.add(step_text)
        self.wait(0.1)


# Instrukcje użycia:
"""
1. Generuj POJEDYNCZE KLATKI PNG (nie wideo!):

manim -sqh manim_frames.py BubbleSortStepByStep

2. Manim wygeneruje folder z PNG:
   media/images/manim_frames/

3. Każdy PNG = jeden krok sortowania

4. JavaScript wyświetli je krok po kroku z kontrolą strzałkami!

UWAGA:
- Użyj flagi -s (save last frame) + wait() przy każdym kroku
- Lepiej: użyj self.renderer.snapshot() dla każdego kroku (wymaga customizacji)
- Alternatywnie: wyrenderuj wideo i wyciągnij klatki ffmpeg
"""
