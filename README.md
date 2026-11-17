
# TP10 - Character Manager Sprint #4
## Theming, Properti Komponen & Analisis MVC

**Nama:** Arini Balqis  
**NIM:** 253303621263  
**Kelas:** 3 Pagi B  
**Mata Kuliah:** Java Visual (SIH-6406)  
**Universitas:** Universitas Prima Indonesia

---

## 1. Deskripsi Project

Pada TP10, aplikasi Character Manager dikembangkan
dengan menambahkan sistem tema menggunakan class
AppTheme.java.

Pengaturan warna, font, dan border dipisahkan dari
MainWindow.java agar tampilan aplikasi lebih terorganisir
dan mudah dikembangkan.

Aplikasi menggunakan Java Swing untuk menampilkan
enam karakter dengan warna kartu berbeda berdasarkan
role masing-masing karakter.

## 2. Fitur TP10

1. AppTheme.java sebagai pengaturan tema aplikasi.
2. Minimal tiga warna utama.
3. Minimal tiga jenis font.
4. Pengaturan border melalui AppTheme.
5. Method colorFor() untuk menentukan warna berdasarkan role.
6. Kartu karakter memiliki warna sesuai role.
7. Level minimal 5 ditampilkan dengan teks emas dan tebal.
8. Menggunakan pack() untuk mengatur ukuran jendela.
9. Menggunakan tooltip untuk informasi karakter.
10. Border kartu berbeda berdasarkan role.

## 3. Data Karakter

| ID | Nama | Level | Role |
|---|---|---:|---|
| 1 | Arthur | 5 | WARRIOR |
| 2 | Merlin | 10 | MAGE |
| 3 | Robin | 3 | ARCHER |
| 4 | Arjuna | 12 | ASSASSIN |
| 5 | Leon | 15 | WARRIOR |
| 6 | Freya | 7 | MAGE |

## 4. Mini-Challenge

Program memiliki konstanta:

HIGHLIGHT_LEVEL_THRESHOLD = 5

Karakter dengan level minimal 5 akan ditampilkan
menggunakan teks berwarna emas dan font tebal.

Konstanta digunakan agar batas level dapat diubah
dengan mudah tanpa mencari angka yang tersebar
di seluruh kode.

## 5. Properti Tambahan

### A. Tooltip

Tooltip menampilkan informasi nama, level, role,
dan HP ketika pengguna mengarahkan kursor ke kartu
karakter.

Alasan: mempermudah pengguna mendapatkan informasi
karakter tanpa memenuhi tampilan utama.

### B. Border Berdasarkan Role

Setiap kartu memiliki border yang warnanya mengikuti
role karakter.

Alasan: membantu membedakan kelompok karakter
secara visual dan membuat tampilan lebih terorganisir.

## 6. Mengapa Warna Disimpan di AppTheme?

Warna disimpan di AppTheme karena warna merupakan
bagian dari tampilan aplikasi, bukan data utama karakter.

Dengan memisahkan pengaturan tema dari Character,
kode menjadi lebih terorganisir dan mudah dipelihara.

Jika warna ingin diubah, pengembang cukup mengubah
AppTheme tanpa mengubah class Character.

Pemisahan ini juga menjaga prinsip MVC karena
pengaturan tampilan ditempatkan pada layer View.

## 7. Screenshot Program

## 8. Google Docs - Analisis Properti & MVC

Link Google Docs:

[(https://docs.google.com/document/d/1XYF6heQZkCtV-_6eRr6Ozkwap8r4VWcENli-8Owduys/edit?usp=sharing)]

---

## 9. Teknologi yang Digunakan

- Java
- Java Swing
- Object-Oriented Programming
- Model-View-Controller (MVC)
- Visual Studio Code
- Git
- GitHub

---

## 10. Pengembang

**Arini Balqis**
Universitas Prima Indonesia
