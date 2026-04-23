package cashier;

// Stack (LIFO) untuk menyimpan riwayat transaksi pelanggan
public class Stack {
    private Node top; // pointer ke transaksi paling baru
    private int size;

    public Stack() {
        top = null;
        size = 0;
    }

    // Push: simpan transaksi pelanggan yang baru selesai dilayani
    public void push(Node node) {
        // Transaksi terbaru diletakkan di atas (LIFO)
        node.next = top;
        top = node;
        size++;
    }

    // Tampilkan riwayat transaksi dari terbaru ke terlama
    public void tampilkan() {
        if (top == null) {
            System.out.println("Belum ada riwayat transaksi.");
            return;
        }

        System.out.println("Riwayat Transaksi (Terbaru ke Terlama):");
        System.out.println("----------------------------------------------------------");

        Node current = top;
        int urutan = 1;
        while (current != null) {
            System.out.printf("%-3d. No: %-6s | Nama: %-15s | Total: Rp%,.0f%n",
                    urutan, current.nomorAntrian, current.namaPelanggan, current.totalBelanja);
            current = current.next;
            urutan++;
        }

        System.out.println("----------------------------------------------------------");
        System.out.println("Total transaksi: " + size);
    }

    public int getSize() {
        return size;
    }
}
