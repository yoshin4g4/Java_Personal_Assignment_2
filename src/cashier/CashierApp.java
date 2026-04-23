package cashier;

import java.util.Scanner;

public class CashierApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue queue = new Queue();
        Stack stack = new Stack();
        int pilihan;

        System.out.println("============================================");
        System.out.println("         SISTEM KASIR TOKO                 ");
        System.out.println("============================================");

        do {
            System.out.println("\n=== SISTEM KASIR TOKO ===");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Layani Pelanggan");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Lihat Riwayat Transaksi");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            pilihan = scanner.nextInt();
            scanner.nextLine(); // buang newline sisa nextInt

            System.out.println();

            switch (pilihan) {
                case 1: // Tambah pelanggan ke antrian (enqueue)
                    System.out.print("Masukkan Nomor Antrian: ");
                    String nomor = scanner.nextLine().trim();
                    System.out.print("Masukkan Nama Pelanggan: ");
                    String nama = scanner.nextLine().trim();
                    System.out.print("Masukkan Total Belanja: ");
                    double total = scanner.nextDouble();
                    scanner.nextLine();

                    queue.enqueue(nomor, nama, total);
                    break;

                case 2: // Layani pelanggan pertama (dequeue + push ke stack)
                    Node dilayani = queue.dequeue();

                    if (dilayani != null) {
                        System.out.println("Melayani pelanggan " + dilayani.nomorAntrian
                                + " (" + dilayani.namaPelanggan + ")");
                        System.out.printf("Total belanja: Rp%,.0f%n", dilayani.totalBelanja);
                        stack.push(dilayani);
                        System.out.println("Transaksi disimpan ke riwayat.");
                    }
                    break;

                case 3: // Tampilkan antrian saat ini
                    queue.tampilkan();
                    break;

                case 4: // Lihat riwayat transaksi dari terbaru (LIFO)
                    stack.tampilkan();
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
