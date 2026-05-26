package TokoBuku;

/**
 * Child Class: BukuDetail
 * Mewarisi Buku dan menambahkan atribut tahun_cetak & kategori
 */
public class BukuDetail extends Buku {

    private int    tahun_cetak;
    private String kategori;   // su=Semua Umur, r=Remaja, d=Dewasa, a=Anak

    // Constructor
    public BukuDetail() {}

    public BukuDetail(String judul, String nama_pengarang, String penerbit,
                      int tahun_cetak, String kategori) {
        // Memanggil constructor parent
        super(judul, nama_pengarang, penerbit);
        this.tahun_cetak = tahun_cetak;
        this.kategori    = kategori;
    }

    // Getter & Setter
    public int  getTahunCetak()        { return tahun_cetak; }
    public void setTahunCetak(int t)   { this.tahun_cetak = t; }

    public String getKategori()        { return kategori; }
    public void   setKategori(String k){ this.kategori = k; }

    /**
     * Mengubah kode kategori menjadi label yang mudah dibaca
     */
    public String getLabelKategori() {
        switch (kategori.toLowerCase()) {
            case "su": return "Semua Umur";
            case "r":  return "Remaja";
            case "d":  return "Dewasa";
            case "a":  return "Anak-anak";
            default:   return "Tidak Diketahui";
        }
    }

    /**
     * Override method tampilInfo() dari parent class Buku
     * Menampilkan seluruh informasi buku termasuk data tambahan
     */
    @Override
    public void tampilInfo() {
        // Memanggil tampilInfo() milik parent
        super.tampilInfo();
        System.out.println("Tahun Cetak    : " + tahun_cetak);
        System.out.println("Kategori       : " + getLabelKategori());
    }
}
