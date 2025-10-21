# 🎓 jGRASP - Lokalna wizualizacja Java

## 📥 Instalacja

### Windows:
1. Pobierz: https://www.jgrasp.org/
2. Wybierz "jGRASP + OpenJDK" (wszystko w jednym!)
3. Instaluj jak normalny program
4. Gotowe! Działa offline

### Linux/Mac:
```bash
# Pobierz ZIP
wget https://spider.eng.auburn.edu/user-cgi/grasp/grasp.pl?dl=download_jgrasp.html

# Rozpakuj
unzip jgrasp*.zip

# Uruchom
./jgrasp
```

## 🎯 Jak używać do wizualizacji?

### 1. Otwórz swój kod Java w jGRASP

```java
public class ArrayDemo {
    public static void main(String[] args) {
        int[] arr = new int[5];
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;

        System.out.println("Done");
    }
}
```

### 2. Ustaw breakpoint (kliknij linię)

### 3. Kliknij "Debug" (ikona robaka)

### 4. Kliknij prawym na zmienną → "View in Viewer Canvas"

**BOOM!** Widzisz tablicę wizualnie:
```
┌────┬────┬────┬────┬────┐
│ 10 │ 20 │ 30 │ 0  │ 0  │
└────┴────┴────┴────┴────┘
  [0]  [1]  [2]  [3]  [4]
```

### 5. Klikaj "Step" aby wykonywać krok po kroku

## 🌟 Zaawansowane funkcje

### Wizualizacja struktur danych:

**ArrayList:**
```java
ArrayList<Integer> list = new ArrayList<>();
list.add(5);
list.add(10);
// Viewer Canvas pokazuje: [5, 10] + capacity
```

**LinkedList:**
```java
LinkedList<String> list = new LinkedList<>();
list.add("A");
list.add("B");
// Viewer pokazuje węzły ze strzałkami: [A]→[B]→null
```

**HashMap:**
```java
HashMap<String, Integer> map = new HashMap<>();
map.put("Alice", 25);
// Viewer pokazuje buckets + hash collisions!
```

**Drzewa binarne:**
```java
TreeNode root = new TreeNode(10);
root.left = new TreeNode(5);
root.right = new TreeNode(15);
// Viewer rysuje drzewo graficznie!
```

## 📊 Viewer Canvas

**Dragging & Dropping:**
- Przeciągnij zmienną z debuggera na canvas
- Viewer automatycznie wybiera najlepszą wizualizację
- Możesz mieć wiele obiektów jednocześnie

**Typy wizualizacji:**
- Arrays → Prostokąty z indeksami
- Objects → Diagramy z polami
- Lists → Łańcuchy węzłów
- Trees → Graficzne drzewa
- Graphs → Węzły + krawędzie

## 🎓 Użycie w nauczaniu

### Scenariusz 1: Wykład
1. Otwórz jGRASP na projektorze
2. Napisz kod na żywo
3. Uruchom w debuggerze
4. Przeciągnij zmienne na canvas
5. Studenci widzą co się dzieje w pamięci!

### Scenariusz 2: Laboratorium
1. Studenci instalują jGRASP (5 minut)
2. Piszą kod zadania
3. Sami wizualizują swoje struktury
4. Rozumieją błędy patrząc na pamięć

### Scenariusz 3: Zdalne nauczanie
1. Nagraj screencast z jGRASP
2. Wyeksportuj wizualizacje jako screenshoty
3. Wstaw do prezentacji Reveal.js

## 💡 Porównanie z innymi narzędziami

| Cecha | jGRASP | Python Tutor | VisuAlgo |
|-------|--------|--------------|----------|
| Offline | ✅ TAK | ❌ Nie | ❌ Nie |
| Własny kod | ✅ TAK | ✅ TAK | ❌ Nie |
| Struktury danych | ✅ TAK | ✅ TAK | ✅ TAK |
| Debugger | ✅ TAK | ❌ Nie | ❌ Nie |
| Darmowe | ✅ TAK | ✅ TAK | ✅ TAK |
| Instalacja | 5 min | 30+ min | 0 min |

## 🔧 Tips & Tricks

**1. Export wizualizacji do obrazu:**
- File → Print Viewer Canvas → Save as PDF/PNG
- Użyj w prezentacjach!

**2. Custom viewers dla własnych klas:**
```java
// Dodaj toString() i jGRASP automatycznie wyświetli
public String toString() {
    return "MyObject[" + field + "]";
}
```

**3. Automatyczne diagramy UML:**
- Tools → Create UML Class Diagram
- Generuje diagramy ze struktur klas!

## 📚 Dodatkowe zasoby

- Tutorial: https://www.jgrasp.org/tutorials.html
- Dokumentacja: https://www.jgrasp.org/docs.html
- Video tutorials: YouTube "jGRASP tutorial"

## ✅ Podsumowanie

**jGRASP to:**
- ✅ CAŁKOWICIE OFFLINE
- ✅ Darmowe
- ✅ Standalone (nie wymaga instalacji JDK jeśli pobierzesz bundle)
- ✅ Idealne do nauczania Java
- ✅ Wizualizacje lepsze niż Python Tutor (dla Java)

**Polecam na 100% dla nauczania!** 🎉
