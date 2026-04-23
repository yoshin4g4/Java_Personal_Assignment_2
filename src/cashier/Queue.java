package cashier;

// Queue (FIFO) untuk antrian pelanggan
public class Queue {
    private Node front; // pointer ke pelanggan paling depan
    private Node rear;  // pointer ke pelanggan paling belakang
    private int size;

    public Queue() {
        front = null;
        rear = null;
        size = 0;
    }

    // Enqueue: tambah pelanggan baru di belakang antrian (maks. 5)
    public void enqueue(String nomorAntrian, String namaPelanggan, double totalBelanja) {
        if (size >= 5) {
            System.out.println("Antrian penuh! Maksimal 5 pelanggan dalam antrian.");
            return;
        }

        Node newNode = new Node(nomorAntrian, namaPelanggan, totalBelanja);

        if (rear == null) {
            // Antrian kosong, front dan rear menunjuk ke node yang sama
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        size++;
        System.out.println("Data pelanggan ditambahkan ke antrian!");
        System.out.println("Total antrian saat ini: " + size + "/5");
    }

    // Dequeue: ambil pelanggan dari depan antrian (selesai dilayani)
    public Node dequeue() {
        if (front == null) {
            System.out.println("Antrian kosong, tidak ada pelanggan yang bisa dilayani.");
            return null;
        }

        Node dilayani = front;
        front = front.next;

        if (front == null) {
            rear = null; // antrian jadi kosong
        }

        size--;
        dilayani.next = null; // isolasi node dari chain lama
        return dilayani;
    }

    // Tampilkan seluruh antrian saat ini
    public void tampilkan() {
        if (front == null) {
            System.out.println("Antrian kosong.");
            return;
        }

        System.out.println("Antrian Pelanggan Saat Ini:");
        System.out.println("----------------------------------------------------------");

        Node current = front;
        int urutan = 1;
        while (current != null) {
            System.out.printf("%-3d. No: %-6s | Nama: %-15s | Total: Rp%,.0f%n",
                    urutan, current.nomorAntrian, current.namaPelanggan, current.totalBelanja);
            current = current.next;
            urutan++;
        }

        System.out.println("----------------------------------------------------------");
        System.out.println("Total antrian: " + size + " pelanggan");
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return front == null;
    }
}
