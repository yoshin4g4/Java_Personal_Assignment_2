package library;

import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList list = new LinkedList();
        int pilihan;

        System.out.println("============================================");
        System.out.println("     SISTEM MANAJEMEN BUKU PERPUSTAKAAN    ");
        System.out.println("============================================");

        do {
            System.out.println("\n===== SISTEM DATA BUKU =====");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Cari Buku");
            System.out.println("4. Lihat Semua Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            pilihan = scanner.nextInt();
            scanner.nextLine(); // buang newline sisa nextInt

            System.out.println();

            switch (pilihan) {
                case 1: // Tambah buku (push ke akhir)
                    System.out.print("Masukkan Kode Buku (maks. 5 karakter): ");
                    String kode = scanner.nextLine().trim();
                    System.out.print("Masukkan Judul: ");
                    String judul = scanner.nextLine().trim();
                    System.out.print("Masukkan Penulis: ");
                    String penulis = scanner.nextLine().trim();

                    if (list.push(kode, judul, penulis)) {
                        System.out.println("Data berhasil ditambahkan!");
                        System.out.println("Total buku saat ini: " + list.getSize());
                    }
                    break;

                case 2: // Hapus buku terakhir (pop)
                    list.pop();
                    break;

                case 3: // Cari buku berdasarkan kode
                    System.out.print("Masukkan Kode Buku yang dicari: ");
                    String cariKode = scanner.nextLine().trim();
                    Node hasil = list.cari(cariKode);

                    if (hasil != null) {
                        System.out.println("Buku ditemukan:");
                        System.out.println("Kode: " + hasil.kodeBuku
                                + " | Judul: " + hasil.judul
                                + " | Penulis: " + hasil.penulis);
                    } else {
                        System.out.println("Buku tidak ditemukan.");
                    }
                    break;

                case 4: // Tampilkan semua buku
                    list.tampilkan();
                    break;

                case 5: // Keluar
                    System.out.println("Terima kasih! Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid! Masukkan angka 1-5.");
            }

        } while (pilihan != 5);

        scanner.close();
    }
}
