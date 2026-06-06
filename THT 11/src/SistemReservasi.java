import java.util.ArrayList;

// Pusat kontrol reservasi dan logika bisnis sistem
public class SistemReservasi {
    private ArrayList<Kereta> daftarKereta;

    public SistemReservasi() {
        daftarKereta = new ArrayList<>();
        initData();
    }

    // Mengisi data awal ke memori secara otomatis
    private void initData() {
        daftarKereta.add(new Kereta("K01", "Argo Bromo", "JKT - SBY", 50));
        daftarKereta.add(new Kereta("K02", "Parahyangan", "JKT - BDG", 15));
    }

    public void tampilkanJadwal() {
        System.out.println("\n=== JADWAL KERETA JAVA EXPRESS ===");
        System.out.printf("%-12s %-15s %-15s %-10s\n", "KODE KERETA", "NAMA KERETA", "RUTE", "SISA KURSI");
        System.out.println("---------------------------------------------------------");
        for (Kereta k : daftarKereta) {
            System.out.printf("%-12s %-15s %-15s %-10d\n", 
                    k.getKodeKereta(), k.getNamaKereta(), k.getRute(), k.getSisaKursi());
        }
    }

    // Metode pemesanan tiket dengan deklarasi 'throws' secara eksplisit
    public void pesanTiket(String kode, String nik, String nama, int jumlahTiket) 
            throws RuteTidakDitemukanException, TiketHabisException {
        
        // Validasi NIK (Must be 16 digits of numbers)
        if (nik.length() != 16) {
            throw new DataPenumpangTidakValidException("Format NIK Salah: Harus tepat 16 karakter!");
        }
        if (!nik.matches("[0-9]+")) {
            throw new DataPenumpangTidakValidException("Format NIK Salah: NIK hanya boleh berisi angka!");
        }

        // Cari kereta berdasarkan kode
        Kereta keretaDipilih = null;
        for (Kereta k : daftarKereta) {
            if (k.getKodeKereta().equalsIgnoreCase(kode)) {
                keretaDipilih = k;
                break;
            }
        }

        if (keretaDipilih == null) {
            throw new RuteTidakDitemukanException("Error: Kereta dengan kode \"" + kode + "\" tidak ditemukan!");
        }

        // Validasi ketersediaan kursi
        if (jumlahTiket > keretaDipilih.getSisaKursi()) {
            throw new TiketHabisException(keretaDipilih.getNamaKereta(), keretaDipilih.getSisaKursi());
        }

        // Proses modifikasi data jika semua validasi lolos
        keretaDipilih.kurangiKursi(jumlahTiket);
        System.out.println("\n=============================================");
        System.out.println("      RESERVASI TIKET BERHASIL DICATAT!       ");
        System.out.println("=============================================");
        System.out.println("Nama Penumpang : " + nama);
        System.out.println("Kereta Api     : " + keretaDipilih.getNamaKereta());
        System.out.println("Rute Perjalanan: " + keretaDipilih.getRute());
        System.out.println("Jumlah Tiket   : " + jumlahTiket + " kursi");
        System.out.println("Sisa Kursi Kini: " + keretaDipilih.getSisaKursi());
        System.out.println("=============================================");
    }
}