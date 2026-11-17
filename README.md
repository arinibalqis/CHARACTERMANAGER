
# TP8 - Character Manager Sprint #3
## MainWindow, Data Dinamis & Analisis MVC

**Nama:** Arini Balqis  
**NIM:** 253303621263  
**Kelas:** 3 Pagi B  
**Mata Kuliah:** Java Visual (SIH-6406)  
**Universitas:** Universitas Prima Indonesia

---

## 1. Deskripsi Project

Pada TP8, aplikasi Character Manager dikembangkan dari
program berbasis console menjadi aplikasi Graphical User
Interface (GUI) menggunakan Java Swing.

Aplikasi ini menggunakan MainWindow untuk menampilkan
data karakter secara dinamis melalui perulangan (loop).
Selain itu, aplikasi dilengkapi dengan statistik jumlah
karakter dan rata-rata level karakter.

## 2. Fitur Implementasi

1. MainWindow menggunakan JFrame.
2. Menggunakan JLabel untuk menampilkan data karakter.
3. Menampilkan data karakter secara dinamis menggunakan loop.
4. Menambahkan minimal lima karakter.
5. Menampilkan total jumlah karakter.
6. Menghitung rata-rata level karakter.
7. Menggunakan SwingUtilities.invokeLater().
8. Menerapkan konsep Model-View-Controller (MVC).

## 3. Data Karakter

| ID | Nama | Level | Tipe |
|---|---|---:|---|
| 1 | Arthur | 5 | WARRIOR |
| 2 | Merlin | 10 | MAGE |
| 3 | Robin | 8 | ARCHER |
| 4 | Arjuna | 12 | ASSASSIN |
| 5 | Leon | 15 | WARRIOR |

## 4. Hasil Statistik

- Total karakter: 5
- Total level: 50
- Rata-rata level: 10.00

## 5. Struktur Folder

```text
CHARACTERMANAGER/
│
├── src/
│   └── com/
│       └── unpri/
│           └── charactermanager/
│               │
│               ├── model/
│               │   ├── Character.java
│               │   ├── CharacterType.java
│               │   └── CharacterManager.java
│               │
│               ├── view/
│               │   └── MainWindow.java
│               │
│               └── Main.java
│
├── screenshots/
│   ├── TP8-sebelum.png
│   └── TP8-sesudah.png
│
└── README.md
```

## 6. Penjelasan Alur MVC

Alur program dimulai dari Main.java yang membuat objek
CharacterManager dan memasukkan data karakter.

CharacterManager bertugas menyimpan serta mengelola data
karakter. Selanjutnya, MainWindow mengambil data dari
CharacterManager dan menampilkannya ke dalam GUI
menggunakan JLabel.

Dengan demikian, data dan tampilan program dipisahkan
sehingga struktur kode lebih terorganisir dan mudah
dikembangkan.

## 7. Screenshot Program

### A. Screenshot Sebelum Perubahan

before tp8.png

### B. Screenshot Sesudah Perubahan

after tp8.png
## 8. Google Docs - Analisis GUI & MVC

Link Google Docs:

(https://docs.google.com/document/d/1GW5QQ2DsBKiOWNkFsy8MwOIQVPapip_UMeQ-sIxsrjw/edit?usp=sharing)

---

## 9. Teknologi yang Digunakan

- Java
- Java Swing
- Object-Oriented Programming (OOP)
- Model-View-Controller (MVC)
- Visual Studio Code
- Git dan GitHub

---

## 10. Pengembang

**Arini Balqis**  
Universitas Prima Indonesia
