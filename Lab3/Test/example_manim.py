"""
Przykładowe animacje Manim do prezentacji Java
Uruchom: manim -pql example_manim.py NazwaSceny
"""

from manim import *

class BubbleSortAnimation(Scene):
    """Animacja sortowania bąbelkowego"""
    def construct(self):
        # Nagłówek
        title = Text("Bubble Sort", font_size=48)
        title.to_edge(UP)
        self.play(Write(title))

        # Tablica do posortowania
        arr = [5, 2, 8, 1, 9]

        # Tworzenie wizualnych elementów
        squares = VGroup()
        numbers = VGroup()

        for i, val in enumerate(arr):
            square = Square(side_length=1)
            square.set_fill(BLUE, opacity=0.5)
            square.shift(RIGHT * (i * 1.2 - 2.4))

            num = Text(str(val), font_size=36)
            num.move_to(square.get_center())

            squares.add(square)
            numbers.add(num)

        self.play(Create(squares), Write(numbers))
        self.wait(1)

        # Animacja sortowania
        n = len(arr)
        for i in range(n):
            for j in range(0, n - i - 1):
                # Podświetl porównywane elementy
                self.play(
                    squares[j].animate.set_fill(YELLOW, opacity=0.8),
                    squares[j+1].animate.set_fill(YELLOW, opacity=0.8),
                    run_time=0.3
                )

                if arr[j] > arr[j + 1]:
                    # Zamiana
                    arr[j], arr[j+1] = arr[j+1], arr[j]

                    self.play(
                        squares[j].animate.shift(RIGHT * 1.2),
                        squares[j+1].animate.shift(LEFT * 1.2),
                        numbers[j].animate.shift(RIGHT * 1.2),
                        numbers[j+1].animate.shift(LEFT * 1.2),
                        run_time=0.5
                    )

                    # Zamień w grupach
                    squares[j], squares[j+1] = squares[j+1], squares[j]
                    numbers[j], numbers[j+1] = numbers[j+1], numbers[j]

                # Przywróć kolor
                self.play(
                    squares[j].animate.set_fill(BLUE, opacity=0.5),
                    squares[j+1].animate.set_fill(BLUE, opacity=0.5),
                    run_time=0.2
                )

            # Oznacz posortowany element jako zielony
            self.play(
                squares[n-i-1].animate.set_fill(GREEN, opacity=0.7),
                run_time=0.3
            )

        self.wait(2)


class ArrayMemory(Scene):
    """Wizualizacja tablicy w pamięci"""
    def construct(self):
        title = Text("Tablica w pamięci", font_size=48)
        title.to_edge(UP)
        self.play(Write(title))

        # Kod Java
        code = Code(
            code="""int[] arr = new int[5];
arr[0] = 10;
arr[1] = 20;
arr[2] = 30;""",
            language="java",
            font="Monospace",
            font_size=24,
            background="window"
        )
        code.to_edge(LEFT).shift(UP * 0.5)
        self.play(Create(code))
        self.wait(1)

        # Wizualizacja pamięci
        memory_boxes = VGroup()
        memory_values = VGroup()

        for i in range(5):
            box = Rectangle(width=1, height=0.8)
            box.shift(RIGHT * (i * 1.1 + 1) + DOWN * 1)

            index = Text(f"[{i}]", font_size=20, color=GRAY)
            index.next_to(box, UP, buff=0.1)

            value = Text("0", font_size=28)
            value.move_to(box.get_center())

            memory_boxes.add(VGroup(box, index))
            memory_values.add(value)

        self.play(Create(memory_boxes))
        self.play(Write(memory_values))
        self.wait(1)

        # Wypełnianie wartościami
        values = [10, 20, 30, 0, 0]
        for i, val in enumerate(values[:3]):
            new_val = Text(str(val), font_size=28, color=YELLOW)
            new_val.move_to(memory_values[i].get_center())

            self.play(
                memory_boxes[i][0].animate.set_fill(BLUE, opacity=0.3),
                Transform(memory_values[i], new_val),
                run_time=0.5
            )
            self.wait(0.3)

        self.wait(2)


class RecursionVisualization(Scene):
    """Wizualizacja rekurencji - Fibonacci"""
    def construct(self):
        title = Text("Rekurencja: Fibonacci", font_size=48)
        title.to_edge(UP)
        self.play(Write(title))

        # Kod
        code = Code(
            code="""int fib(int n) {
    if (n <= 1) return n;
    return fib(n-1) + fib(n-2);
}""",
            language="java",
            font="Monospace",
            font_size=28
        )
        code.shift(UP * 1.5)
        self.play(Create(code))
        self.wait(1)

        # Drzewo wywołań dla fib(4)
        def create_call_tree(n, pos, scale=1):
            node = Circle(radius=0.4 * scale, color=BLUE)
            node.move_to(pos)
            text = Text(f"fib({n})", font_size=int(24 * scale))
            text.move_to(pos)

            group = VGroup(node, text)
            return group

        # Główne wywołanie
        root = create_call_tree(4, DOWN * 1)
        self.play(Create(root))
        self.wait(0.5)

        # Gałęzie
        left_child = create_call_tree(3, DOWN * 2 + LEFT * 2, 0.8)
        right_child = create_call_tree(2, DOWN * 2 + RIGHT * 2, 0.8)

        arrow_left = Arrow(root.get_bottom(), left_child.get_top(), buff=0.1)
        arrow_right = Arrow(root.get_bottom(), right_child.get_top(), buff=0.1)

        self.play(
            Create(arrow_left),
            Create(left_child),
            run_time=0.5
        )
        self.play(
            Create(arrow_right),
            Create(right_child),
            run_time=0.5
        )

        self.wait(2)


class ComplexityChart(Scene):
    """Wykres złożoności Big O"""
    def construct(self):
        title = Text("Złożoność obliczeniowa: Big O", font_size=40)
        title.to_edge(UP)
        self.play(Write(title))

        # Osie
        axes = Axes(
            x_range=[0, 10, 1],
            y_range=[0, 100, 10],
            x_length=10,
            y_length=6,
            axis_config={"color": GRAY}
        )

        labels = axes.get_axis_labels(x_label="n", y_label="czas")

        self.play(Create(axes), Write(labels))

        # Funkcje
        o1 = axes.plot(lambda x: 1, color=GREEN)
        ologn = axes.plot(lambda x: np.log2(x + 1) * 5, color=BLUE)
        on = axes.plot(lambda x: x * 5, color=YELLOW)
        on2 = axes.plot(lambda x: (x ** 2) / 2, color=RED, x_range=[0, 10])

        # Legendy
        legend = VGroup(
            VGroup(Line(LEFT * 0.3, RIGHT * 0.3, color=GREEN), Text("O(1)", font_size=20)).arrange(RIGHT),
            VGroup(Line(LEFT * 0.3, RIGHT * 0.3, color=BLUE), Text("O(log n)", font_size=20)).arrange(RIGHT),
            VGroup(Line(LEFT * 0.3, RIGHT * 0.3, color=YELLOW), Text("O(n)", font_size=20)).arrange(RIGHT),
            VGroup(Line(LEFT * 0.3, RIGHT * 0.3, color=RED), Text("O(n²)", font_size=20)).arrange(RIGHT),
        ).arrange(DOWN, aligned_edge=LEFT, buff=0.2)
        legend.to_corner(UR)

        self.play(
            Create(o1),
            Create(legend[0]),
            run_time=1
        )
        self.wait(0.5)

        self.play(
            Create(ologn),
            Create(legend[1]),
            run_time=1
        )
        self.wait(0.5)

        self.play(
            Create(on),
            Create(legend[2]),
            run_time=1
        )
        self.wait(0.5)

        self.play(
            Create(on2),
            Create(legend[3]),
            run_time=1
        )

        self.wait(2)


# Instrukcje uruchomienia:
"""
Renderuj pojedynczą scenę:
    manim -pql example_manim.py BubbleSortAnimation
    manim -pql example_manim.py ArrayMemory
    manim -pql example_manim.py RecursionVisualization
    manim -pql example_manim.py ComplexityChart

Jakość:
    -ql  = niska jakość (szybkie podglądy)
    -qm  = średnia jakość
    -qh  = wysoka jakość (do prezentacji)

Po wyrenderowaniu, pliki MP4 będą w:
    media/videos/example_manim/480p15/NazwaSceny.mp4

Przenieś je do folderu animations/:
    cp media/videos/example_manim/480p15/BubbleSortAnimation.mp4 animations/sorting.mp4
"""
