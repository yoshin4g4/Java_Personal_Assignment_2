# Tugas Personal 2 — Data Structures and Algorithm Analysis
**Topik:** Linked List & Stack dan Queue  
**Mata Kuliah:** COSC6025 — Data Structures and Algorithm Analysis  
**Universitas:** BINUS University Online

---

## Struktur Proyek

```
src/
├── library/
│   ├── Node.java          # Node untuk menyimpan data buku
│   ├── LinkedList.java    # Implementasi Single Linked List
│   └── LibraryApp.java    # Main program perpustakaan
├── cashier/
│   ├── Node.java          # Node untuk menyimpan data pelanggan
│   ├── Queue.java         # Implementasi Queue (antrian pelanggan)
│   ├── Stack.java         # Implementasi Stack (riwayat transaksi)
│   └── CashierApp.java    # Main program kasir toko
└── App.java
```

---

## Soal Review — Linked List

### 1. Jelaskan konsep dasar Linked List dan perbedaannya dengan Array!

**Linked List** adalah struktur data linear yang terdiri dari sekumpulan *node*, di mana setiap node menyimpan dua hal: **data** dan **pointer** yang menunjuk ke node berikutnya. Node-node tersebut tidak disimpan pada lokasi memori yang berurutan (non-contiguous), melainkan tersebar di memori dan dihubungkan satu sama lain melalui pointer.

**Perbedaan dengan Array:**

| Aspek | Linked List | Array |
|---|---|---|
| Alokasi memori | Dinamis (dialokasikan saat dibutuhkan) | Statis (ditentukan di awal) |
| Lokasi memori | Tidak berurutan (tersebar) | Berurutan (contiguous) |
| Akses elemen | Sequential — harus traversal dari head | Random access — langsung via indeks `O(1)` |
| Ukuran | Fleksibel, bisa bertambah/berkurang | Tetap setelah dideklarasikan |
| Memori overhead | Lebih besar (menyimpan pointer) | Lebih efisien |
| Insert/Delete | Efisien di tengah `O(1)` setelah posisi ditemukan | Mahal — perlu menggeser elemen `O(n)` |

---

### 2. Sebutkan kelebihan dan kekurangan Linked List dibanding Array!

**Kelebihan Linked List:**
- **Ukuran dinamis** — tidak perlu menentukan kapasitas di awal; node dapat ditambah atau dihapus kapan saja tanpa realokasi memori besar.
- **Insert dan delete efisien** — menambah atau menghapus node di awal maupun di tengah hanya membutuhkan perubahan pointer, tidak perlu menggeser elemen lain seperti pada array.
- **Tidak ada pemborosan memori akibat kapasitas berlebih** — memori hanya dialokasikan sebesar data yang benar-benar ada.

**Kekurangan Linked List:**
- **Tidak mendukung random access** — untuk mengakses elemen ke-n, harus traversal dari head satu per satu sehingga kompleksitas akses adalah `O(n)`.
- **Overhead memori lebih besar** — setiap node menyimpan satu atau lebih pointer tambahan selain data itu sendiri.
- **Tidak cache-friendly** — karena node tersebar di memori, performa cache CPU lebih buruk dibanding array yang elemennya berurutan.
- **Pencarian lebih lambat** — tidak dapat menggunakan Binary Search karena tidak ada akses indeks langsung.

---

### 3. Jelaskan bagaimana operasi insert dan delete dilakukan pada Linked List!

**Operasi Insert (Tambah Data)**

Terdapat tiga skenario:

1. **Insert di awal (head):**
   - Buat node baru.
   - Arahkan pointer `next` node baru ke node `head` lama.
   - Ubah `head` menjadi node baru.
   - Kompleksitas: `O(1)`.

2. **Insert di akhir (tail):**
   - Buat node baru.
   - Traversal dari `head` hingga node terakhir (`node.next == null`).
   - Arahkan pointer `next` node terakhir ke node baru.
   - Kompleksitas: `O(n)` karena perlu traversal.

3. **Insert di tengah (setelah posisi tertentu):**
   - Traversal hingga posisi yang diinginkan.
   - Arahkan `next` node baru ke node setelahnya.
   - Arahkan `next` node sebelumnya ke node baru.
   - Kompleksitas: `O(n)` untuk traversal, `O(1)` untuk perubahan pointer.

**Operasi Delete (Hapus Data)**

Terdapat tiga skenario:

1. **Delete di awal:**
   - Simpan referensi node `head`.
   - Pindahkan `head` ke `head.next`.
   - Kompleksitas: `O(1)`.

2. **Delete di akhir:**
   - Traversal hingga node kedua dari terakhir (`node.next.next == null`).
   - Set `node.next = null`.
   - Kompleksitas: `O(n)`.

3. **Delete node tertentu (by value/key):**
   - Traversal sambil menyimpan referensi node sebelumnya (`prev`).
   - Saat node target ditemukan: `prev.next = target.next`.
   - Kompleksitas: `O(n)`.

---

## Soal Review — Stack dan Queue

### 1. Jelaskan perbedaan antara Stack dan Queue!

**Stack** dan **Queue** sama-sama struktur data linear, tetapi berbeda dalam cara elemen diakses:

| Aspek | Stack | Queue |
|---|---|---|
| Prinsip | **LIFO** — *Last In, First Out* | **FIFO** — *First In, First Out* |
| Elemen yang keluar pertama | Elemen yang **terakhir** masuk | Elemen yang **pertama** masuk |
| Ujung operasi | Satu ujung saja (top) | Dua ujung: rear (masuk) dan front (keluar) |
| Analogi | Tumpukan piring — piring teratas diambil duluan | Antrean loket — yang datang pertama dilayani pertama |
| Operasi utama | `push` (masuk) dan `pop` (keluar) | `enqueue` (masuk) dan `dequeue` (keluar) |

---

### 2. Sebutkan operasi utama dalam Stack dan Queue!

**Operasi Stack:**
| Operasi | Keterangan |
|---|---|
| `push(data)` | Menambahkan elemen baru ke bagian atas stack (top) |
| `pop()` | Menghapus dan mengembalikan elemen paling atas |
| `peek()` / `top()` | Melihat elemen paling atas tanpa menghapusnya |
| `isEmpty()` | Mengecek apakah stack kosong |
| `size()` | Mengembalikan jumlah elemen dalam stack |

**Operasi Queue:**
| Operasi | Keterangan |
|---|---|
| `enqueue(data)` | Menambahkan elemen baru di bagian belakang antrian (rear) |
| `dequeue()` | Menghapus dan mengembalikan elemen paling depan (front) |
| `peek()` / `front()` | Melihat elemen paling depan tanpa menghapusnya |
| `isEmpty()` | Mengecek apakah queue kosong |
| `size()` | Mengembalikan jumlah elemen dalam queue |

---

### 3. Berikan contoh penerapan nyata struktur data Stack dan Queue!

**Penerapan Stack dalam kehidupan nyata:**

| Contoh | Penjelasan |
|---|---|
| **Undo/Redo teks editor** | Setiap aksi disimpan di stack. Saat `Ctrl+Z` ditekan, aksi terakhir di-*pop* dan dibatalkan. |
| **Navigasi browser** | Halaman yang dikunjungi ditumpuk di stack. Tombol *Back* meng-*pop* halaman terakhir. |
| **Call stack pada program** | Saat fungsi memanggil fungsi lain, eksekusi ditumpuk. Fungsi yang terakhir dipanggil selesai duluan (return). |
| **Evaluasi ekspresi matematika** | Konversi dan evaluasi ekspresi infix/postfix menggunakan stack untuk menyimpan operator dan operand. |

**Penerapan Queue dalam kehidupan nyata:**

| Contoh | Penjelasan |
|---|---|
| **Antrian kasir / loket** | Pelanggan yang datang pertama dilayani pertama (seperti program kasir dalam tugas ini). |
| **Print queue** | Dokumen yang dikirim ke printer lebih dulu akan dicetak lebih dulu. |
| **Penjadwalan proses CPU** | Sistem operasi menggunakan queue untuk mengatur urutan proses yang akan dieksekusi. |
| **Buffer streaming video** | Data video di-*buffer* dalam queue sehingga diputar berurutan sesuai urutan datangnya paket data. |
