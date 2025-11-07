# 📱 Android Calculator App

A simple yet functional **Calculator Application** built with **Java** and **XML** using **Android Studio**.  
This app performs standard arithmetic operations and includes basic **memory functions**, providing a clean UI and smooth user experience.

---

## 🚀 Features

- 🧮 **Basic Arithmetic** — Addition, Subtraction, Multiplication, Division  
- 💾 **Memory Operations** — MC (Memory Clear), MR (Memory Recall), M+, M−  
- 🔢 **Digit Input & Decimal Support**  
- ✅ **Square Root**, **Sign Toggle (±)**, **Clear**, and **Backspace** Controls  
- 🎨 **Modern Layout** — Built with ConstraintLayout and GridLayout  
- 🌈 **Custom Colors & Themes** using XML-defined resources

---

## 🧠 Project Structure

```
com.example.calculator/
│
├── MainActivity.java          # Core logic and click event handling
├── res/
│   ├── layout/
│   │   └── activity_main.xml  # User interface layout
│   ├── values/
│   │   ├── colors.xml         # App color palette
│   │   ├── strings.xml        # UI text labels
│   │   └── styles.xml         # Theme definitions
│
└── AndroidManifest.xml        # Application configuration
```

---

## 🛠️ Technologies Used

| Component | Description |
|------------|--------------|
| **Language** | Java |
| **IDE** | Android Studio |
| **Layout** | ConstraintLayout, GridLayout |
| **Target SDK** | 33+ |
| **Build Tool** | Gradle |

---

## 💡 How It Works

1. **MainActivity.java** handles button click events:  
   - `onDigitClick()` → Adds digits and decimals to display  
   - `onOpClick()` → Stores operator and prepares operands  
   - `onEqClick()` → Calculates result  
   - `onControlClick()` → Handles backspace, clear, and sign toggle  
   - `onMemoryClick()` → Manages memory storage and recall

2. **activity_main.xml** defines a responsive layout with buttons arranged in a 4×6 grid for clean visual organization.

3. **AndroidManifest.xml** sets `MainActivity` as the launcher with the app icon and label.

---

## ⚙️ Setup & Installation

1. Clone this repository:
   ```bash
   git clone https://github.com/MubaraqYusuf/AndroidCalculator.git
   ```
2. Open the project in **Android Studio**.
3. Sync Gradle and build the project.
4. Run the app on an **emulator** or **Android device**.

---

## 🧩 Possible Improvements

- Add **percentage (%)** and **power (x²)** operations  
- Add **history view** for past calculations  
- Implement **dark/light theme toggle**  
- Add **vibration feedback** on button press  

---

## 👨‍💻 Author

**Mubaraq Yusuf**  
🎓 Student | 💻 Android & Java Developer  

---

## 📝 License

This project is licensed under the **MIT License** — feel free to use and modify it for educational purposes.

---
