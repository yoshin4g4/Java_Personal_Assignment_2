package library;

// Implementasi Single Linked List untuk menyimpan daftar buku
public class LinkedList {
    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    // Push: tambah buku baru di akhir daftar
    public boolean push(String kodeBuku, String judul, String penulis) {
        if (kodeBuku.length() > 5) {
            System.out.println("Validasi gagal: Kode buku maksimal 5 karakter!");
            return false;
        }

        Node newNode = new Node(kodeBuku, judul, penulis);

        if (head == null) {
            head = newNode;
        } else {
            // Traversal ke node terakhir
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        size++;
        return true;
    }

    // Pop: hapus buku terakhir dari daftar
    public boolean pop() {
        if (head == null) {
            System.out.println("Tidak ada data untuk dihapus.");
            return false;
        }

        if (size <= 5) {
            System.out.println("Peringatan: Menghapus buku ini akan membuat jumlah buku di bawah minimum (5).");
        }

        String hapusKode;

        if (head.next == null) {
            // Hanya ada satu node
            hapusKode = head.kodeBuku;
            head = null;
        } else {
            // Traversal ke node kedua dari terakhir
            Node current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            hapusKode = current.next.kodeBuku;
            current.next = null;
        }

        size--;
        System.out.println("Buku dengan kode \"" + hapusKode + "\" berhasil dihapus.");
        return true;
    }

    // Cari buku berdasarkan kodeBuku
    public Node cari(String kodeBuku) {
        Node current = head;
        while (current != null) {
            if (current.kodeBuku.equalsIgnoreCase(kodeBuku)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Tampilkan seluruh daftar buku beserta total
    public void tampilkan() {
        if (head == null) {
            System.out.println("Daftar buku kosong.");
            return;
        }

        System.out.println("Daftar Buku:");
        System.out.println("----------------------------------------------------------");

        Node current = head;
        while (current != null) {
            System.out.println("Kode: " + current.kodeBuku
                    + " | Judul: " + current.judul
                    + " | Penulis: " + current.penulis);
            current = current.next;
        }

        System.out.println("----------------------------------------------------------");
        System.out.println("Total Buku: " + size);
        if (size < 5) {
            System.out.println("(Peringatan: Jumlah buku belum memenuhi minimum 5 buku)");
        }
    }

    public int getSize() {
        return size;
    }
}
