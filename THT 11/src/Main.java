import java.util.InputMismatchException;
import java.util.Scanner;

// Kelas Utama untuk Interface CLI dan Penanganan Exception Utama
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SistemReservasi sistem = new SistemReservasi();
        int pilihanMenu = 0;

        System.out.println("Selamat Datang di Sistem Reservasi \"JAVA EXPRESS\"");

        do {
            System.out.println("\n========= MENU UTAMA =========");
            System.out.println("1. Lihat Jadwal & Sisa Kursi");
            System.out.println("2. Pesan Tiket Kereta");
            System.out.println("3. Keluar Aplikasi");
            System.out.print("Pilih menu (1-3): ");

            try {
                pilihanMenu = input.nextInt();
                input.nextLine(); // Bersihkan sisa newline di buffer

                switch (pilihanMenu) {
                    case 1:
                        sistem.tampilkanJadwal();
                        break;

                    case 2:
                        System.out.println("\n--- FORMULIR PEMESANAN TIKET ---");
                        System.out.print("Masukkan Kode Kereta (e.g. K01): ");
                        String kode = input.nextLine().trim();

                        System.out.print("Masukkan NIK Penumpang         : ");
                        String nik = input.nextLine().trim();

                        System.out.print("Masukkan Nama Penumpang        : ");
                        String nama = input.nextLine().trim();

                        System.out.print("Masukkan Jumlah Tiket          : ");
                        int jumlah = input.nextInt();
                        input.nextLine(); // Bersihkan buffer input setelah membaca angka

                        try {
                            sistem.pesanTiket(kode, nik, nama, jumlah);
                        } catch (DataPenumpangTidakValidException e) {
                            System.out.println("\n[KOSMETIK ERROR - UNCHECKED]");
                            System.out.println("Gagal Gara-gara Data: " + e.getMessage());
                        } catch (RuteTidakDitemukanException e) {
                            System.out.println("\n[KOSMETIK ERROR - CHECKED]");
                            System.out.println("Gagal Gara-gara Rute: " + e.getMessage());
                        } catch (TiketHabisException e) {
                            System.out.println("\n[KOSMETIK ERROR - CHECKED]");
                            System.out.println(e.getMessage());
                            System.out.println("Info Aktual -> Kereta: " + e.getNamaKereta() 
                                    + " | Sisa Kursi Tersedia: " + e.getSisaKursi() + " kursi.");
                        }
                        break;

                    case 3:
                        System.out.println("Memproses penutupan sesi sistem...");
                        break;

                    default:
                        System.out.println("Peringatan: Pilihan menu tidak valid! Silakan masukkan angka 1-3.");
                }

            } catch (InputMismatchException e) {
                System.out.println("\n[ERROR INPUT CRITICAL]");
                System.out.println("Waduh! Input harus berupa angka ya, jangan memasukkan huruf atau simbol.");
                input.nextLine(); // Penting: Membersihkan buffer input dari token salah agar terhindar dari infinite loop
            } finally {
                // Blok penanganan error/log penutupan yang dijamin pasti tereksekusi saat keluar
                if (pilihanMenu == 3) {
                    System.out.println("---------------------------------------------------------");
                    System.out.println("Blok Finally: Terhubung ke database... Sesi ditutup dengan aman.");
                    System.out.println("Terima kasih telah menggunakan layanan JAVA EXPRESS! Sampai jumpa.");
                    System.out.println("---------------------------------------------------------");
                }
            }

        } while (pilihanMenu != 3);

        input.close();
    }
}