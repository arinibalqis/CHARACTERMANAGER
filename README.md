# CHARACTER MANAGER
## Sprint #6 – TP14: Form Input, Validasi & Analisis MVC

**Mata Kuliah:** Java Visual  
**Nama:** Arini Balqis  
**NIM:** 253303621263  
**Kelas:** 3 Pagi B  
**Program Studi:** Sistem Informasi  
**Versi Aplikasi:** v0.6

---

## 1. Deskripsi Project

Character Manager merupakan aplikasi desktop berbasis Java Swing yang digunakan untuk mengelola data karakter dalam sebuah permainan. Aplikasi ini dikembangkan menggunakan konsep Object-Oriented Programming (OOP) dan pola arsitektur Model-View-Controller (MVC).

Pada Sprint #6 atau TP14, pengembangan aplikasi difokuskan pada pembuatan form input karakter, penerapan validasi data, penanganan kesalahan input, dan pemisahan tanggung jawab antara bagian View dan Model.

Pengguna dapat menambahkan karakter dengan mengisi nama, memilih role, dan menentukan level. Setelah data dinyatakan valid, karakter akan langsung ditampilkan pada daftar karakter tanpa harus menjalankan ulang aplikasi.

Selain meningkatkan fungsi aplikasi, tampilan Character Manager juga diperbarui menggunakan kombinasi warna yang berbeda untuk setiap role agar informasi karakter lebih mudah dikenali dan aplikasi terlihat lebih menarik.

## 2. Tujuan Pengembangan

Tujuan pengembangan Character Manager pada TP14 adalah:

1. Membuat form input karakter menggunakan komponen Java Swing.
2. Menerapkan validasi nama sebelum data diproses.
3. Mencegah penambahan karakter dengan nama yang sama.
4. Membatasi level karakter sesuai aturan yang ditentukan.
5. Menerapkan validasi pada View dan Model.
6. Menampilkan pesan kesalahan yang jelas kepada pengguna.
7. Memperbarui daftar karakter secara langsung setelah penambahan data.
8. Mempertahankan struktur program agar mudah dikembangkan kembali.

## 3. Fitur Aplikasi

Berikut fitur yang tersedia pada Character Manager v0.6:

- **Form Input Karakter:** Pengguna dapat memasukkan nama, memilih role, dan mengatur level karakter.
- **Validasi Nama:** Sistem memeriksa kelengkapan, panjang, format, dan keunikan nama.
- **Validasi Level:** Level karakter dibatasi dari 1 sampai 99.
- **Validasi Role MAGE:** Karakter dengan role MAGE tidak diperbolehkan memiliki level lebih dari 60.
- **Pencegahan Nama Duplikat:** Sistem menolak karakter yang menggunakan nama yang sudah terdaftar.
- **Pesan Validasi:** Sistem menampilkan pesan kesalahan atau keberhasilan berdasarkan hasil input.
- **Pembaruan Daftar Otomatis:** Karakter yang berhasil ditambahkan langsung muncul pada daftar.
- **Statistik Karakter:** Aplikasi menampilkan jumlah karakter, rata-rata level, dan karakter dengan serangan tertinggi.
- **Tampilan Berwarna:** Setiap role mempunyai warna yang berbeda untuk memudahkan identifikasi.

## 4. Aturan Validasi

Validasi diterapkan pada dua bagian, yaitu View dan Model.

### A. Validasi pada View

View bertugas memeriksa input pengguna sebelum data dikirimkan ke Model.

Urutan validasi nama:

1. **Kelengkapan:** Nama tidak boleh kosong.
2. **Panjang:** Nama harus terdiri dari 3 sampai 20 karakter.
3. **Format:** Nama hanya boleh berisi huruf dan spasi.
4. **Keunikan:** Nama tidak boleh sama dengan karakter yang sudah terdaftar.

Komponen input yang digunakan:

| Komponen | Fungsi |
|---|---|
| JTextField | Mengisi nama karakter |
| JComboBox | Memilih jenis role |
| JSpinner | Mengatur level karakter |
| JLabel | Menampilkan pesan validasi |
| JButton | Menjalankan proses penambahan karakter |

### B. Validasi pada Model

Model bertugas menjaga agar aturan data tetap berlaku meskipun data dibuat tanpa melalui form.

Aturan yang diterapkan:

- Nama karakter tidak boleh kosong.
- Nama harus memiliki panjang 3 sampai 20 karakter.
- Nama tidak boleh memiliki dua spasi berurutan.
- Role karakter tidak boleh bernilai null.
- Level karakter harus berada pada rentang 1 sampai 99.
- Karakter MAGE tidak boleh memiliki level lebih dari 60.
- Nama karakter tidak boleh digunakan lebih dari satu kali.

Jika data tidak memenuhi aturan, Model akan memberikan pesan melalui `IllegalArgumentException`.

## 5. Struktur Folder Project

Struktur folder project Character Manager:

```text
CHARACTERMANAGER/
│
├── screenshots/
│   ├── error-nama-kosong.png
│   ├── error-nama-duplikat.png
│   └── sukses-kartu-baru.png
│
├── src/
│   └── com/
│       └── unpri/
│           └── charactermanager/
│               │
│               ├── model/
│               │   ├── Character.java
│               │   ├── CharacterManager.java
│               │   └── CharacterType.java
│               │
│               ├── view/
│               │   ├── AppTheme.java
│               │   ├── CharacterFormPanel.java
│               │   └── MainWindow.java
│               │
│               └── Main.java
│
└── README.md
```

## 6. Teknologi yang Digunakan

| Teknologi | Kegunaan |
|---|---|
| Java | Bahasa pemrograman utama |
| Java Swing | Membuat tampilan aplikasi desktop |
| OOP | Mengatur objek dan class |
| MVC | Memisahkan Model dan View |
| ArrayList | Menyimpan kumpulan data karakter |
| VS Code | Menulis dan mengelola kode program |
| Git & GitHub | Mengelola versi dan menyimpan project |

## 7. Pengujian Aplikasi

Pengujian dilakukan untuk memastikan bahwa form input dan validasi berjalan sesuai aturan yang telah dibuat.

| No. | Input Pengujian | Hasil yang Diharapkan | Hasil Aktual |
|---|---|---|---|
| 1 | Nama kosong | Ditolak dengan pesan nama wajib diisi | Isi setelah diuji |
| 2 | Nama kurang dari 3 karakter | Ditolak karena panjang tidak sesuai | Isi setelah diuji |
| 3 | Nama lebih dari 20 karakter | Ditolak karena panjang tidak sesuai | Isi setelah diuji |
| 4 | Nama menggunakan angka | Ditolak karena format tidak sesuai | Isi setelah diuji |
| 5 | Nama yang sudah digunakan | Ditolak sebagai nama duplikat | Isi setelah diuji |
| 6 | Nama dengan dua spasi berurutan | Ditolak oleh Model | Isi setelah diuji |
| 7 | MAGE dengan level 61 | Ditolak oleh Model | Isi setelah diuji |
| 8 | Karakter dengan data valid | Berhasil ditambahkan ke daftar | Isi setelah diuji |
| 9 | Karakter dengan level 99 dan role WARRIOR | Berhasil ditambahkan | Isi setelah diuji |
| 10 | MAGE dengan level 60 | Berhasil ditambahkan | Isi setelah diuji |

**Catatan:** Kolom hasil aktual harus diisi berdasarkan hasil pengujian langsung pada aplikasi.

## 8. Dokumentasi Screenshot

Screenshot berikut digunakan sebagai bukti penerapan form input dan validasi pada aplikasi.

### A. Validasi Nama Kosong

Sistem menampilkan pesan kesalahan ketika pengguna menekan tombol tambah tanpa mengisi nama karakter.

![Validasi Nama Kosong](screenshots/error-nama-kosong.png)

### B. Validasi Nama Duplikat

Sistem menolak penambahan karakter apabila nama yang dimasukkan sudah digunakan oleh karakter lain.

![Validasi Nama Duplikat](screenshots/error-nama-duplikat.png)

### C. Penambahan Karakter Berhasil

Karakter berhasil ditambahkan setelah seluruh data memenuhi aturan validasi. Data baru langsung muncul pada daftar karakter.

![Penambahan Karakter Berhasil](screenshots/sukses-kartu-baru.png)

## 9. Analisis Penerapan MVC

Penerapan MVC pada Character Manager bertujuan memisahkan tanggung jawab pengelolaan data dan tampilan aplikasi.

**Model** bertanggung jawab menyimpan data karakter serta menerapkan aturan validasi. Class `Character` mengatur informasi dan aturan setiap karakter, sedangkan `CharacterManager` mengelola kumpulan karakter.

**View** bertanggung jawab menampilkan form input, daftar karakter, statistik, dan pesan validasi. Class `CharacterFormPanel` digunakan untuk menerima input pengguna, sedangkan `MainWindow` mengatur tampilan utama aplikasi.

Pada pengembangan TP14, View masih memanggil `CharacterManager` secara langsung untuk memproses penambahan karakter. Pendekatan ini digunakan sebagai kompromi sementara agar proses input dapat berjalan dengan baik tanpa menambahkan terlalu banyak class baru.

Pada pengembangan berikutnya, proses tersebut dapat dipindahkan ke Controller agar pemisahan tanggung jawab MVC menjadi lebih baik.

## 10. Catatan Pengembangan

Dalam pengembangan TP14 terdapat beberapa kompromi yang digunakan.

Pertama, penggunaan `ActionListener` pada tombol tambah dibuat secara sederhana menggunakan lambda expression. Cara ini mempermudah penanganan aksi tombol tanpa membuat class listener terpisah.

Kedua, `CharacterFormPanel` masih berkomunikasi langsung dengan `CharacterManager`. Hal ini membuat proses penambahan karakter lebih sederhana, tetapi belum sepenuhnya memisahkan View dari alur pengolahan data. Pada materi Controller berikutnya, komunikasi tersebut dapat diperbaiki dengan menambahkan class Controller sebagai penghubung.

## 11. Cara Menjalankan Aplikasi

Pastikan Java JDK sudah terpasang dan terminal berada pada folder utama project.

**Langkah 1 – Kompilasi program**

```powershell
javac -d out src\com\unpri\charactermanager\model\*.java src\com\unpri\charactermanager\view\*.java src\com\unpri\charactermanager\Main.java
```

**Langkah 2 – Menjalankan aplikasi**

```powershell
java -cp out com.unpri.charactermanager.Main
```

Setelah aplikasi berjalan, pengguna dapat mengisi form karakter, memilih role, menentukan level, dan menekan tombol Tambah Karakter.

## 12. Kesimpulan

Pengembangan Character Manager Sprint #6 berhasil dirancang untuk mendukung proses input dan validasi karakter menggunakan Java Swing. Penerapan validasi pada View dan Model membantu menjaga kualitas data serta mencegah kesalahan input. Selain itu, pembaruan tampilan dan penggunaan warna berdasarkan role membuat informasi karakter lebih mudah dikenali.

Project ini menjadi bagian dari proses pembelajaran OOP, Java Swing, validasi data, dan penerapan konsep MVC yang akan terus dikembangkan pada sprint berikutnya.

---

**Dokumentasi Tugas TP14 – Character Manager Sprint #6**  
Universitas Prima Indonesia  
Program Studi Sistem Informasi