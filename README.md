# 🛠️ Workshop Rekayasa Ulang Kode - Week 6 (2025)

## 📚 Topik Minggu Ini
**Advanced Clean Code Principles & Design Patterns**
- **OCP (Open-Closed Principle) & SRP (Single Responsibility Principle)**
- **Design by Contract (DbC)**
- **Liskov Substitution Principle (LSP)**
- **Law of Demeter (LoD)**

## 📁 Struktur Folder
```
6th Week/
├── README.md
├── 1-OCP-SRP/
│   ├── original/
│   │   └── ShapeCalculator.java    # Monolithic calculator
│   ├── Shape.java                  # Interface definition
│   ├── Rectangle.java              # Concrete implementation
│   ├── Circle.java                 # Concrete implementation
│   ├── Cube.java                   # Concrete implementation
│   └── ShapeCalculator.java        # Refactored calculator
├── 2-DbC/
│   ├── SoalA/
│   │   ├── original/
│   │   │   └── MathCalculator.java # No validation
│   │   └── MathCalculator.java     # With preconditions/postconditions
│   └── SoalB/
│       ├── original/
│       │   └── User.java           # Empty validation
│       └── User.java               # Input validation implemented
├── 3-LSP/
│   ├── original/
│   │   └── ShapeCalculator.java    # Same as OCP original
│   ├── Shape.java                  # Polymorphic interface
│   ├── Rectangle.java              # LSP compliant
│   ├── Cube.java                   # LSP compliant
│   └── ShapeCalculator.java        # Polymorphic calculator
└── 4-LoD/
    ├── original/
    │   ├── Car.java                # Exposes internal structure
    │   ├── Engine.java             # Chain of getters
    │   ├── Piston.java             # End component
    │   └── Main.java               # Method chaining violation
    ├── Car.java                    # Proper encapsulation
    ├── Engine.java                 # Delegated responsibility
    ├── Piston.java                 # Unchanged
    └── Main.java                   # Clean method calls
```

## 🎯 Analisis Code Smells & Refactoring

### 1. **OCP & SRP Violation → Clean Architecture**

**🔍 Code Smells Original:**
- **God Method**: `calculateAreaOrVolume()` melakukan terlalu banyak hal
- **Long Parameter List**: 5 parameter dengan logika kompleks
- **Switch Statement**: Hard-coded shape types, sulit extend
- **Magic Numbers**: PI = 3.14 instead of Math.PI
- **Violates OCP**: Harus modifikasi class untuk tambah shape baru

**✅ Refactoring Applied:**
```java
// SEBELUM - Monolithic approach
public double calculateAreaOrVolume(int dimension, String idShape, 
    double factor1, double factor2, double factor3)

// SESUDAH - Polymorphic approach  
public double calculate(Shape shape)
```

**🎯 Benefits:**
- ✅ **Open for Extension**: Tambah shape baru tanpa ubah existing code
- ✅ **Closed for Modification**: Core calculator tidak perlu diubah
- ✅ **Single Responsibility**: Setiap class punya satu tanggung jawab

---

### 2. **Design by Contract Implementation**

**🔍 Missing Contracts Original:**
- **No Preconditions**: Input validation tidak ada
- **No Error Handling**: Crash potential dengan invalid input
- **Silent Failures**: Method berjalan dengan hasil salah

**✅ DbC Implementation:**

**Soal A - MathCalculator:**
```java
// Precondition checks
if (number < 0) throw new IllegalArgumentException("Non-negative required");
if (divisor == 0) throw new IllegalArgumentException("Non-zero divisor required");
```

**Soal B - User Validation:**
```java
// Input contracts with regex validation
private boolean isValidEmail(String email)
private boolean isValidFacebookURL(String url)
```

**🎯 Benefits:**
- ✅ **Fail Fast**: Error detection di entry point
- ✅ **Clear Expectations**: Contract explicit untuk client
- ✅ **Robust Code**: Predictable behavior dengan invalid input

---

### 3. **Liskov Substitution Principle**

**🔍 LSP Compliance Analysis:**
Refactoring yang sama dengan OCP, tapi fokus pada **substitutability**:

```java
// Semua implementasi Shape bisa disubstitusi
Shape rectangle = new Rectangle(5, 10);
Shape cube = new Cube(3);
calculator.calculate(rectangle); // Works seamlessly
calculator.calculate(cube);      // Works seamlessly
```

**🎯 LSP Requirements Met:**
- ✅ **Behavioral Consistency**: Semua Shape.calculate() return double
- ✅ **No Strengthened Preconditions**: Interface contract sama untuk semua
- ✅ **No Weakened Postconditions**: Semua return valid calculation

---

### 4. **Law of Demeter - "Don't Talk to Strangers"**

**🔍 LoD Violations Original:**
- **Method Chaining**: `car.getEngine().getPiston().move()`
- **Inappropriate Intimacy**: Main class tahu internal Car structure
- **Tight Coupling**: Change di Engine/Piston break Main code
- **Exposed Implementation**: Getter chains reveal architecture

**✅ LoD Refactoring:**
```java
// SEBELUM - Chain of knowledge
car.getEngine().getPiston().move();

// SESUDAH - Proper delegation
car.movePiston(); // Car handles internal coordination
```

**🔧 Delegation Pattern:**
- **Car** delegates to **Engine**
- **Engine** delegates to **Piston**  
- **Main** only knows **Car** interface

**🎯 Benefits:**
- ✅ **Loose Coupling**: Changes internal tidak affect client
- ✅ **Better Encapsulation**: Internal structure hidden
- ✅ **Easier Maintenance**: Modify implementation tanpa break client

## 📋 Learning Outcomes

**🎯 Prinsip yang Dipelajari:**
1. **OCP**: Extension tanpa modification
2. **SRP**: One class, one responsibility  
3. **DbC**: Explicit contracts & validation
4. **LSP**: Safe object substitution
5. **LoD**: Minimal knowledge coupling

**🔧 Refactoring Techniques:**
- Extract Interface pattern
- Delegation pattern  
- Polymorphism over conditionals
- Input validation strategies
- Encapsulation improvement

## 📌 Mekanisme Pengerjaan
- Mahasiswa **mengerjakan setiap task** (refactoring & clean code) di editor Java (VS Code atau IntelliJ).  
- Setelah selesai, mahasiswa wajib membuat **laporan singkat** berisi:
  1. **Analisis**: Code smells dan violations yang ditemukan
  2. **Perbaikan**: Principle mana yang diterapkan dan bagaimana
  3. **Hasil akhir**: Kode yang sudah clean dengan penjelasan

- Laporan dikumpulkan sesuai instruksi dosen (format `PDF/DOCX`).

## 🔍 Tips Refactoring
- Identifikasi responsibility setiap class dulu
- Gunakan IDE refactoring tools (Extract Interface, Extract Method)
- Test behavior sebelum dan sesudah refactoring
- Focus pada coupling reduction dan cohesion improvement
- Document contract expectations clearly

---
*📚 Advanced clean code principles untuk software yang maintainable dan extensible* 🚀