public class Mahasiswa {
    private int sksMaksimal;
    public int sisaSks = 20;

    public void setSksMaksimal(int sks) {
        if (sks < 2 || sks > 24) {
            throw new IllegalArgumentException("Kesalahan sistem: Batas SKS tidak valid (harus antara 2 - 24 SKS)!");
        }
        this.sksMaksimal = sks;
        System.out.println("SKS Maksimal berhasil diatur: " + sks);
    }

    public void ambilMataKuliah(String namaMatkul, int bebanSks) {
        if (bebanSks > sisaSks) {
            throw new SksTidakCukupException("Kesalahan mahasiswa: SKS tidak cukup untuk mengambil " + namaMatkul);
        }
        sisaSks -= bebanSks;
        System.out.println("Berhasil mengambil matkul " + namaMatkul + " (" + bebanSks + " SKS). Sisa SKS: " + sisaSks);
    }
}