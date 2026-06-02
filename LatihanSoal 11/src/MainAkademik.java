import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.FileNotFoundException;

public class MainAkademik {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // SOAL 1: Persiapan Sistem dan Kuota Kelas
        System.out.println("=== SOAL 1: INPUT KUOTA KELAS ===");
        int[] kuotaKelas = new int[3];
        
        // Loop sengaja dibuat 4 kali untuk memicu ArrayIndexOutOfBoundsException
        for (int i = 0; i < 4; i++) {
            try {
                System.out.print("Masukkan kuota mata kuliah ke-" + (i + 1) + ": ");
                kuotaKelas[i] = scanner.nextInt();
                System.out.println("Kuota berhasil disimpan.");
            } catch (InputMismatchException e) {
                System.out.println("Error: Input harus berupa angka bulat!");
                scanner.next(); // membersihkan buffer input yang salah
                i--; // mengulang perulangan untuk indeks yang sama
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: Batas array terlampaui! Anda mencoba mengisi indeks ke-" + i + " pada array ukuran 3.");
            }
        }

        // SOAL 2: Validasi Data Mahasiswa
        System.out.println("\n=== SOAL 2: VALIDASI MAHASISWA ===");
        Mahasiswa mhs = new Mahasiswa();
        try {
            // Uji coba memicu error dengan mengisi 26 SKS
            mhs.setSksMaksimal(26);
        } catch (IllegalArgumentException e) {
            System.out.println("Tertangkap Exception: " + e.getMessage());
        }

        // SOAL 3: Penambahan Mata Kuliah
        System.out.println("\n=== SOAL 3: AMBIL MATA KULIAH ===");
        try {
            // Sisa SKS mhs adalah 20, kita coba ambil matkul dengan beban 24 SKS
            mhs.ambilMataKuliah("Tugas Akhir Berbasis AI", 24);
        } catch (SksTidakCukupException e) {
            System.out.println("Tertangkap Custom Unchecked Exception: " + e.getMessage());
        }

        // SOAL 4: Pengecekan Ketersediaan Kelas
        System.out.println("\n=== SOAL 4: GABUNG KELAS ===");
        SistemAkademik sa = new SistemAkademik();
        try {
            // Simulasi kuota bernilai 0
            sa.gabungKelas("IF-301", 0);
        } catch (KelasPenuhException e) {
            System.out.println("Tertangkap Custom Checked Exception: " + e.getMessage());
        }

        // SOAL 5: Pencetakan Dokumen KRS
        System.out.println("\n=== SOAL 5: CETAK KRS ===");
        try {
            // Simulasi nama file salah untuk memicu error
            sa.cetakDokumenKrs("krs_palsu.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Tertangkap Exception: " + e.getMessage());
        } finally {
            // Blok yang selalu dijalankan di akhir proses KRS
            System.out.println("Sesi Sistem Rencana Studi telah ditutup. Koneksi database diputuskan.");
        }

        scanner.close();
    }
}