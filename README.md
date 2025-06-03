## 💻Info2025
Java (BlueJ) Projekt 2025

---

## 📚Inhalt
- [Konzept](#konzept)
- [Changelog](#changelog)
- [ToDo-Liste](#todo-liste)

---

## Konzept/Ideen

- Spiel besteht aus Feld/Acker (Landwirtschaft)
- wird befahren von Mähdrescher, der gelenkt werden muss
- Traktor erntet zufällig spawnende Feldfrüchte
- zusätzlich spawnen Vogelscheuchen und Strommasten, gegen die nicht gefahren werden darf => sonst vorbei, Spawnrate erhöht sich kontinuierlich
- werden die Feldfrüchte nicht geerntet, verderben diese nach einiger Zeit
- (Wetter beeinflusst das Spiel)

---

## ToDo-Liste

- [x] Getreide nicht überlappen   
- [x] Getreide Anzeige(oben rechts)
- [x] Mast einbauen
- [x] Game Over Screen
- [x] Hintergund einbauen
- [x] Nach dem despawnen von Getreide, spawned es irgendwo anders erneut
- [ ] Weniger For-Schleifen im Ticker, für bessere Performance
- [ ] Mähwerk anzeige einbauen
- [ ] Für Getreide, 2. Arrey, das dann neu spawn


---
## Changelog

### 06.05.2025
- Ideen-Sammlung
- Konzepterstellung

### 07.05.2025
- Beginn Programmierung & Design der Figuren
- Steuerung des Mähdreschers

### 13.05.2025
- richtige Anordnung der Rahmen
- Zufallsspawnen von Getreide
- Pixel-Art: Mähdrescher (mit Animation)

### 14.05.2025
- Problembehebung: Getreide spawnen, ohne Übnerlappung
- Anzeige, gesammeltes Getreide
- Pixel-Art: Getreide, Icon Getreideanzeige & Mast

### 20.05.2025
- Problembehebung: Verzerrung der Mähdrescherfigur
- Spawnen von Masten
- Pixel-Art: Hintergrund & Game Over Screen

### 21.05.2025
- Verschidene Problembehebungen
- Vorbereitung zum besseren spawnen von Getreide
- Pixel-Art: neues Getreide

### 27.05.2025
- Getreide & Masten werden bei Game Over auch ausgeblendet
- mehrere kleinere Fehlerbehebunge

### 28.05.2025
- Masten- & Getreidespawnen optimiert

### 03.06.2025
- Neue besser Funktion für den Mast
- Viele Versuche und Problembehebung beim Neuspawnen von Getreide -> neuner Ansatz
- Pixel-Art: Mähwerk-Icon

---

## Dokumentation

### Mastenreihe-Zufallsspawn
- x-Funktion Mast: 2i-15
- y-Funktion Mast: 1,5*(2i-15)
