# TypeReveal

> Interactive presentation engine with live typewriter-effect code animation powered by Reveal.js

TypeReveal is a presentation framework that brings code to life with character-by-character typing animations, creating an engaging live-coding experience for educational presentations and technical talks.

## Features

- **Typewriter Animation** - Code appears character-by-character with realistic typing effect
- **Step-by-Step Control** - Navigate through code changes with Next/Undo/Reset buttons
- **Keyboard Shortcuts** - Arrow keys and Space for quick navigation
- **Progress Slider** - Jump to any point in the animation instantly
- **Syntax Highlighting** - Powered by Prism.js with Java support
- **Auto-scroll** - Keeps the typing cursor visible at all times
- **Line Replacement** - Special `<<REPLACE_LINE>>` command for editing existing lines
- **Multiple Lessons** - Organized lesson system with easy switching
- **Responsive Design** - Works on desktop and mobile devices

## Quick Start

### 1. Clone or download this repository

```bash
git clone <your-repo-url>
cd Lab
```

### 2. Start a local web server

Since the slides are loaded dynamically, you need to run a web server:

```bash
# Using Python
python -m http.server 8000

# Or using npx
npx serve

# Or using Node.js http-server
npx http-server
```

### 3. Open in browser

Navigate to:
```
http://localhost:8000/Lab5/self_writing_code_lecture_template/
```

Or for Lab 4:
```
http://localhost:8000/Lab4/self_writing_code_lecture_template_ml_update/self_writing_code_lecture_template/
```

### 4. Select a lesson

Use the lesson selector at the top of the page to switch between available lessons (02, 03, 05).

## Branch Strategy

### EN

| Branch | Role |
| ------ | ---- |
| `main` | Stable snapshot shared with collaborators and slide authors; only verified engine & slide assets live here. |
| `engine-dev` | Working branch for the TypeReveal engine; merge into `main` after every finished iteration. |
| `engine-release/*` | Frozen release branches/tags (e.g., `engine-release/v1.0`) that other projects or presenters can pin to. |
| `slides-template` | Clean slide template plus assets; every new deck must branch off from here. |
| `slides-content` | Accumulates ready-to-use slide decks produced from the template. |

### PL

| Gałąź | Rola |
| ----- | ---- |
| `main` | Stabilny snapshot do udostępniania współautorom i twórcom slajdów. |
| `engine-dev` | Gałąź robocza silnika TypeReveal scalana cyklicznie do `main`. |
| `engine-release/*` | Zamrożone wydania silnika (np. `engine-release/v1.0`) jako punkt odniesienia. |
| `slides-template` | Czysty szablon slajdów wraz z assetami – od niego odchodzą nowe prezentacje. |
| `slides-content` | Gałąź z gotowymi prezentacjami tworzonymi na bazie szablonu. |

## Working with `slides-template`

### EN

1. Fetch the latest state:
   ```bash
   git fetch origin
   ```
2. Create your own branch from the template:
   ```bash
   git checkout origin/slides-template -b slides-<your-topic>
   ```
3. Update content inside `SlidesTemplate/`:
   - HTML slides in `SlidesTemplate/slides/`
   - Media in `SlidesTemplate/Pics/` (and the bundled video if needed)
   - Sample code in `SlidesTemplate/Code/`
4. Test locally:
   ```bash
   SlidesTemplate/uruchom_prezentacje.bat
   ```
   Make sure the presentation runs with all media.
5. Commit & push your branch:
   ```bash
   git add SlidesTemplate
   git commit -m "Slides: <your-topic>"
   git push origin slides-<your-topic>
   ```
6. Open a pull request:
   - Target `slides-content` for finished decks.
   - Target `slides-template` if you are improving the template itself.

Keeping `slides-template` untouched ensures every presentation starts from a clean baseline.

### PL

1. Zsynchronizuj repozytorium:
   ```bash
   git fetch origin
   ```
2. Utwórz własną gałąź startując z szablonu:
   ```bash
   git checkout origin/slides-template -b slides-<twoj-temat>
   ```
3. Wprowadź zmiany w katalogu `SlidesTemplate/`:
   - Treść HTML w `SlidesTemplate/slides/`
   - Obrazy/wideo w `SlidesTemplate/Pics/` (i ewentualnie `My BCA...mp4`)
   - Kod demonstracyjny w `SlidesTemplate/Code/`
4. Przetestuj lokalnie:
   ```bash
   SlidesTemplate/uruchom_prezentacje.bat
   ```
   Upewnij się, że wszystkie media i kroki działają w przeglądarce.
5. Zacommituj i wypchnij swoją gałąź:
   ```bash
   git add SlidesTemplate
   git commit -m "Slides: <twoj-temat>"
   git push origin slides-<twoj-temat>
   ```
6. Otwórz pull request:
   - Do `slides-content`, jeśli dodajesz gotową prezentację.
   - Do `slides-template`, jeśli poprawiasz szablon.

Szablon pozostaje wtedy czysty, a każda prezentacja ma własną historię zmian.

## How It Works

### Creating an Animated Slide

Each animated slide consists of:

1. **HTML Structure** (in `lessons/lesson-XX/slides/slide-YY.html`):

```html
<section id="code-slide-example">
  <h3>Your Slide Title</h3>

  <pre><code id="code-example" class="language-java"></code></pre>

  <div class="controls-local">
    <button id="next-example">Następny fragment</button>
    <button id="undo-example">Cofnij</button>
    <button id="reset-example">Reset</button>
  </div>

  <div style="margin-top: 15px; display: flex; align-items: center; gap: 10px;">
    <span style="font-size: 0.85rem; opacity: 0.8; min-width: 80px;">Postęp:</span>
    <input id="progress-example" type="range" min="0" max="100" value="0"
           style="flex: 1; cursor: pointer; height: 8px;">
    <span id="progress-label-example" style="font-size: 0.85rem; opacity: 0.8; min-width: 60px;">0 / 0</span>
  </div>

  <script type="application/json" id="steps-example">
  [
    "public class Example {",
    "\n    public static void main(String[] args) {",
    "\n        System.out.println(\"Hello, World!\");",
    "<<REPLACE_LINE>>        System.out.println(\"Hello, TypeReveal!\");",
    "\n    }",
    "\n}"
  ]
  </script>
</section>
```

2. **JavaScript Registration** (in `assets/js/main.js`):

```javascript
createAnimatedCodeSlide(
  'code-slide-example',      // section ID
  'code-example',            // code element ID
  'steps-example',           // steps JSON ID
  'next-example',            // next button ID
  'undo-example',            // undo button ID
  'reset-example',           // reset button ID
  'speed-example',           // (unused but required)
  'progress-example',        // progress slider ID
  'progress-label-example'   // progress label ID
);
```

3. **Add slide to lesson manifest** (in `assets/js/main.js`):

```javascript
const lessonSlideNames = {
  '05': [
    'slide-00-tytul.html',
    'slide-01-example.html',  // ← Add your slide here
    // ... other slides
  ]
};
```

### Animation Commands

- **Regular text**: Just write the code fragment - it will be typed character-by-character
- **`<<REPLACE_LINE>>`**: Deletes the last line and types a new one (useful for fixing "mistakes")

Example:
```json
[
  "int x = 5;",              // Types: int x = 5;
  "<<REPLACE_LINE>>int x = 10;",  // Deletes "int x = 5;" and types "int x = 10;"
]
```

## Keyboard Shortcuts

| Key | Action |
|-----|--------|
| `→` / `Space` | Type next code fragment |
| `Ctrl` + `←` | Undo last fragment |
| `Mouse drag` | Jump to specific step using progress slider |

## Project Structure

```
Lab/
├── Lab4/
│   └── self_writing_code_lecture_template_ml_update/
│       └── self_writing_code_lecture_template/
├── Lab5/
│   └── self_writing_code_lecture_template/
│       ├── index.html                    # Main entry point
│       ├── assets/
│       │   ├── js/
│       │   │   └── main.js              # Core animation engine
│       │   ├── css/
│       │   │   └── main.css             # Custom styles
│       │   └── vendor/
│       │       ├── reveal.js/           # Reveal.js library
│       │       └── prismjs/             # Syntax highlighting
│       └── lessons/
│           ├── lesson-02/               # Factory Pattern
│           ├── lesson-03/               # Generics, Recursion, HashMap
│           └── lesson-05/               # Lambda expressions
│               └── slides/
│                   ├── slide-00-tytul.html
│                   ├── slide-01-...html
│                   └── ...
```

## Available Lessons

### Lesson 02: Factory Pattern (Wzorce Fabryki)
Topics: Factory Method, Abstract Factory, Interfaces, Polymorphism
- Car dealership example ("Salon Bajtazara")
- Evolution from if-else to Factory patterns

### Lesson 03: Advanced Java Concepts
Topics: Generics, Recursion, HashMap
- Order management system
- Recursive algorithms with visualization
- HashMap operations

### Lesson 05: Lambda Expressions
Topics: Anonymous classes, Lambda syntax, Functional interfaces
- From anonymous classes to lambda expressions
- Functional programming in Java

## Technology Stack

- **[Reveal.js](https://revealjs.com/)** - HTML presentation framework
- **[Prism.js](https://prismjs.com/)** - Syntax highlighting
- **Vanilla JavaScript** - No build tools required
- **HTML5 + CSS3** - Modern web standards

## Customization

### Change Typing Speed

Edit `SPEED` constant in `assets/js/main.js` (line 208):
```javascript
const SPEED = 15; // milliseconds per character (lower = faster)
```

### Add New Language Support

1. Download Prism.js component from https://prismjs.com/download.html
2. Add to `assets/vendor/prismjs/components/`
3. Include in `index.html`
4. Use `class="language-<your-lang>"` on code blocks

### Change Theme

Replace Reveal.js theme in `index.html`:
```html
<link rel="stylesheet" href="assets/vendor/reveal.js/dist/theme/black.css">
```

Available themes: `black`, `white`, `league`, `sky`, `beige`, `simple`, `serif`, `blood`, `night`, `moon`, `solarized`

## Browser Support

- Chrome/Edge (recommended)
- Firefox
- Safari
- Mobile browsers (iOS Safari, Chrome Mobile)

## Tips for Creating Great Presentations

1. **Keep steps small** - Break code into logical chunks (not too long per step)
2. **Use `<<REPLACE_LINE>>`** - Great for showing "mistakes" and corrections
3. **Add comments** - Use comments to explain what's happening
4. **Test the flow** - Always preview your slides before presenting
5. **Use keyboard shortcuts** - Much smoother than clicking buttons during live demos

## Contributing

This is an educational project. Feel free to:
- Add new lessons
- Improve animations
- Fix bugs
- Enhance documentation

## License

Educational use - feel free to adapt for your own teaching materials.

## Credits

Created for Java programming laboratory courses at Technical University.

Built with:
- [Reveal.js](https://github.com/hakimel/reveal.js) by Hakim El Hattab
- [Prism.js](https://github.com/PrismJS/prism) by Lea Verou

---

**Happy teaching!** 🎓✨
