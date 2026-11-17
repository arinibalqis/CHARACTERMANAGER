# Character Manager

Aplikasi Character Manager merupakan project Java Swing yang dikembangkan menggunakan konsep Object-Oriented Programming (OOP) dan Model-View-Controller (MVC).

Project ini dikembangkan secara bertahap melalui beberapa sprint untuk mempelajari pengelolaan data karakter, tampilan antarmuka, dan penerapan layout pada Java Swing.

---

# TP12 – Character Manager Sprint #5

## Layout, UI Responsif & Analisis MVC

### A. Deskripsi

Pada Sprint #5, aplikasi Character Manager dikembangkan menjadi versi 0.5 dengan menggunakan beberapa Layout Manager pada Java Swing.

Pengembangan ini berfokus pada penggunaan BorderLayout, GridLayout, BoxLayout, FlowLayout, dan JScrollPane agar tampilan aplikasi lebih terstruktur serta dapat menyesuaikan ukuran jendela.

### B. Fitur yang Dikembangkan

1. Menggunakan BorderLayout sebagai layout utama.
2. Header aplikasi berada di bagian NORTH.
3. Daftar karakter ditampilkan pada bagian CENTER.
4. Daftar karakter menggunakan JScrollPane.
5. Legenda karakter ditampilkan pada bagian EAST.
6. Status bar berada pada bagian SOUTH.
7. Menambahkan panel statistik dengan GridLayout 2x2.
8. Menambahkan minimal 8 karakter dengan level dan role berbeda.
9. Menggunakan BoxLayout Y_AXIS untuk menyusun legenda.
10. Menampilkan tulisan status di kiri dan versi v0.5 di kanan.

### C. Wireframe Aplikasi

```text
+------------------------------------------------------+
|                  CHARACTER MANAGER                   |
|          Manage your characters and roles            |
+------------------------------------------------------+
| TOTAL CHARACTERS | AVERAGE LEVEL                      |
| HIGHEST LEVEL    | TOTAL ROLES                         |
+--------------------------------------+---------------+
|                                      |               |
|  CHARACTER CARD     CHARACTER CARD  | CHARACTER     |
|                                      | ROLES         |
|  CHARACTER CARD     CHARACTER CARD  |               |
|                                      | WARRIOR       |
|  CHARACTER CARD     CHARACTER CARD  | MAGE          |
|                                      | ARCHER        |
|  CHARACTER CARD     CHARACTER CARD  | ASSASSIN      |
|                                      |               |
+--------------------------------------+---------------+
| Character Manager is running                  v0.5   |
+------------------------------------------------------+
```

### D. Screenshot Aplikasi





Simpan screenshot dengan nama:

`tp12-small.png`

![Screenshot scrollbar](screenshots/tp12.png)

### E. Tabel Pengamatan Resize

| Kondisi | Prediksi | Hasil Pengamatan |
|---|---|---|
| Ukuran awal | Semua komponen terlihat | Isi sesuai hasil pengujian |
| Jendela dilebarkan | Ruang daftar karakter bertambah | Isi sesuai hasil pengujian |
| Jendela diperkecil | Daftar karakter membutuhkan scrollbar | Isi sesuai hasil pengujian |

### F. Struktur Panel Bersarang

Aplikasi menggunakan BorderLayout sebagai layout utama untuk membagi tampilan menjadi beberapa wilayah. Bagian NORTH berisi panel pembungkus yang terdiri dari header dan statistik. Bagian CENTER berisi JScrollPane yang membungkus panel daftar kartu karakter, sedangkan bagian EAST berisi legenda dengan BoxLayout. Bagian SOUTH digunakan sebagai status bar yang menampilkan informasi aplikasi dan versi v0.5.

### G. Alasan Pemilihan Layout

Panel statistik menggunakan GridLayout 2x2 karena membutuhkan susunan empat informasi dengan ukuran sel yang sama. GridLayout membuat setiap informasi memiliki pembagian ruang yang teratur.

BoxLayout Y_AXIS dipilih untuk legenda karena setiap role disusun secara vertikal. GridLayout tidak dipilih untuk legenda karena pembagian sel yang sama kurang fleksibel untuk susunan daftar vertikal dengan jarak tambahan.

Daftar kartu menggunakan GridLayout dengan dua kolom agar karakter dapat ditampilkan berdampingan dan mudah dibaca.

### H. Teknologi yang Digunakan

- Java
- Java Swing
- Object-Oriented Programming
- Model-View-Controller
- BorderLayout
- GridLayout
- BoxLayout
- FlowLayout
- JScrollPane

### I. Analisis Layout dan MVC

Dokumentasi analisis konseptual TP12:

[Masukkan link Google Docs analisis TP12 di sini]

### J. Kesimpulan

Melalui Sprint #5, aplikasi Character Manager dikembangkan dengan struktur layout yang lebih terorganisasi. Penggunaan beberapa Layout Manager membantu pengaturan komponen berdasarkan kebutuhan masing-masing panel. Penggunaan JScrollPane juga memungkinkan daftar karakter tetap dapat diakses ketika ruang tampilan terbatas. Pengujian resize dilakukan untuk mengevaluasi perilaku antarmuka pada berbagai ukuran jendela.