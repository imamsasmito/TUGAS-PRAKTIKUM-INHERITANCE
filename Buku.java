package TokoBuku;

/**
 * Parent Class: Buku
 * Menyimpan atribut dasar sebuah buku
 */
public class Buku {

    protected String judul;
    protected String nama_pengarang;
    protected String penerbit;

    // Constructor
    public Buku() {}

    public Buku(String judul, String nama_pengarang, String penerbit) {
        this.judul          = judul;
        this.nama_pengarang = nama_pengarang;
        this.penerbit       = penerbit;
    }

    // Getter & Setter
    public String getJudul()             { return judul; }
    public void   setJudul(String j)     { this.judul = j; }

    public String getNamaPengarang()         { return nama_pengarang; }
    public void   setNamaPengarang(String n) { this.nama_pengarang = n; }

    public String getPenerbit()          { return penerbit; }
    public void   setPenerbit(String p)  { this.penerbit = p; }

    // Method tampil — akan di-override oleh child
    public void tampilInfo() {
        System.out.println("Judul          : " + judul);
        System.out.println("Nama Pengarang : " + nama_pengarang);
        System.out.println("Penerbit       : " + penerbit);
    }
}
