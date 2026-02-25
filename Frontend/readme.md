# Quiroga Law Office, PLLC — Website

> **"We are a law firm for immigrants, by immigrants."**

---

## Screenshot

![Quiroga Law Office website screenshot](images/Quiroga-Law-Office-PLLC-–-We-are-a-law-firm-for-immigrants-by-immigrants-02-25-2026_06_12_AM.png)

---

## About the Project

This is a responsive, multi-section marketing website for **Quiroga Law Office, PLLC**, an immigration law firm founded and staffed by first-generation immigrants. The firm serves clients across **Washington, Nevada, and Querétaro, México**, with offices in Spokane, Tri Cities, Wenatchee, Vancouver, Tacoma, Las Vegas, and México.

The site is built as a pure front-end project using **HTML5, CSS3 (via SCSS)**, and no JavaScript frameworks — focused on clean semantics, accessibility, and a professional visual identity that reflects the firm's mission.

---

## Key Sections

| Section | Description |
|---|---|
| **Announcement Banner** | Scrolling marquee warning about scams, with a prominent phone number |
| **Header / Navigation** | Logo, main nav links (Visas, Residency, Waivers, Blog…), and a bilingual CTA button |
| **Hero** | Headline with office locations, firm tagline, call/text/team CTAs, and a stat counter |
| **About the Firm** | Mission statement, practice areas overview, and core pillars |
| **Meet Our Team** | Attorney profiles highlighting the immigrant-led team |
| **Blog / Articles** | Immigration law news and resources |
| **Contact** | Contact form and office location details |

---

## Tech Stack

- **HTML5** — semantic markup with ARIA roles for accessibility
- **SCSS** — modular architecture with variables, card, button, and layout partials compiled to `css/style.css`
- **Google Fonts** — Lora (serif headings) + Open Sans (body)
- **Responsive Design** — mobile-first layout supporting all screen sizes

---

## Project Structure

```
Frontend/
├── index.html          # Main HTML page
├── css/
│   └── style.css       # Compiled CSS output
├── scss/
│   ├── main.scss       # Entry point — imports all partials
│   ├── _variables.scss # Colors, fonts, spacing tokens
│   ├── _layout.scss    # Grid, container, section helpers
│   ├── _cards.scss     # Card component styles
│   └── _buttons.scss   # Button variants (primary, outline, secondary)
└── images/             # Logos and site images
```

---

## Getting Started

1. Clone or download the repository.
2. Open `index.html` directly in a browser **or** use a local dev server (e.g., VS Code Live Server).
3. To edit styles, modify the `.scss` files and compile via your preferred SCSS tool:
   ```bash
   sass scss/main.scss css/style.css --watch
   ```

---

## Contact

**Quiroga Law Office, PLLC**  
Phone: [(509) 927-3840](tel:+15099273840)  
Languages: English & Español
