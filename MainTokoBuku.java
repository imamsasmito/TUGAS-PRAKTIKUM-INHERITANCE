package TokoBuku;

import java.util.Scanner;

/**
 * Main Class: MainTokoBuku
 * Aplikasi sederhana entri dan tampil data buku
 * Mendemonstrasikan konsep Inheritance: Buku (parent) -> BukuDetail (child)
 */
public class MainTokoBuku {

    // Array untuk menyimpan 3 data buku
    static BukuDetail[] daftarBuku = new BukuDetail[3];
    static Scanner input           = new Scanner(System.in);

    // ---------------------------------------------------------------
    // Method: entriData — mengisi data ke objek BukuDetail
    // ---------------------------------------------------------------
    static void entriData() {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║         ENTRI DATA BUKU              ║");
        System.out.println("╚══════════════════════════════════════╝");

        for (int i = 0; i < 3; i++) {
            System.out.println("\n--- Buku ke-" + (i + 1) + " ---");

            // Menggunakan setter (bukan constructor) untuk mendemonstrasikan
            // penggunaan getter/setter yang diwarisi dari parent class
            BukuDetail buku = new BukuDetail();

            System.out.print("Judul          : ");
            buku.setJudul(input.nextLine());           // setter dari parent

            System.out.print("Nama Pengarang : ");
            buku.setNamaPengarang(input.nextLine());   // setter dari parent

            System.out.print("Penerbit       : ");
            buku.setPenerbit(input.nextLine());        // setter dari parent

            System.out.print("Tahun Cetak    : ");
            buku.setTahunCetak(Integer.parseInt(input.nextLine()));

            System.out.println("Kategori (su=Semua Umur | r=Remaja | d=Dewasa | a=Anak) :");
            System.out.print("Pilih          : ");
            buku.setKategori(input.nextLine());

            daftarBuku[i] = buku;
            System.out.println("✔ Data buku ke-" + (i + 1) + " berhasil disimpan.");
        }
    }

    // ---------------------------------------------------------------
    // Method: tampilSemuaBuku — menampilkan semua data yang dientri
    // Menggunakan Virtual Method Invocation (VMI):
    //   Buku ref = new BukuDetail() -> ref.tampilInfo() memanggil
    //   override method milik BukuDetail, bukan Buku
    // ---------------------------------------------------------------
    static void tampilSemuaBuku() {
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║         DAFTAR BUKU TOKO             ║");
        System.out.println("╚══════════════════════════════════════╝");

        for (int i = 0; i < daftarBuku.length; i++) {
            System.out.println("\n[ Buku #" + (i + 1) + " ]");
            System.out.println("----------------------------------------");

            // VMI: referensi tipe parent (Buku), objek sebenarnya BukuDetail
            // Java akan memanggil tampilInfo() versi BukuDetail (override)
            Buku refBuku = daftarBuku[i];
            refBuku.tampilInfo();

            System.out.println("----------------------------------------");
        }
    }

    // ---------------------------------------------------------------
    // MAIN METHOD
    // ---------------------------------------------------------------
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║     SELAMAT DATANG DI APLIKASI          ║");
        System.out.println("║          TOKO BUKU JAVA                 ║");
        System.out.println("╚══════════════════════════════════════════╝");
        System.out.println("Konsep: Inheritance (Buku ← BukuDetail)\n");

        boolean lanjut = true;

        while (lanjut) {
            System.out.println("\n====== MENU UTAMA ======");
            System.out.println("1. Entri Data Buku");
            System.out.println("2. Tampilkan Semua Buku");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu : ");

            String pilihan = input.nextLine();

            switch (pilihan) {
                case "1":
                    entriData();
                    break;
                case "2":
                    // Cek apakah data sudah diisi
                    if (daftarBuku[0] == null) {
                        System.out.println("⚠ Belum ada data! Silakan entri data terlebih dahulu.");
                    } else {
                        tampilSemuaBuku();
                    }
                    break;
                case "3":
                    System.out.println("Terima kasih. Program selesai.");
                    lanjut = false;
                    break;
                default:
                    System.out.println("⚠ Pilihan tidak valid. Coba lagi.");
            }
        }

        input.close();
    }
}
