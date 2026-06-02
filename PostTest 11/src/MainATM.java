public class MainATM {
    public static void main(String[] args) {
        // Inisialisasi akun nasabah (Bagas) dan akun tujuan (Toko Online)
        AkunBank akunBagas = new AkunBank("105224049", 5000000); // Saldo awal Rp 5 Juta
        AkunBank akunTujuan = new AkunBank("987654321", 1000000);

        System.out.println("=== SIMULASI ATM DIGITAL ===");
        System.out.println("No Rekening: " + akunBagas.getNomorRekening());
        System.out.println("Saldo Awal : Rp " + akunBagas.getSaldo() + "\n");

        try {
            // Skenario 1: Menarik uang dalam jumlah wajar
            System.out.println("--- Mencoba Tarik Tunai Rp 2.000.000 ---");
            akunBagas.tarikTunai(2000000);

            // Skenario 2: Menarik uang hingga saldo habis / melewati batas
            System.out.println("\n--- Mencoba Tarik Tunai Rp 4.000.000 (Melebihi Sisa Saldo) ---");
            akunBagas.tarikTunai(4000000); 

            System.out.println("\n--- Mencoba Transfer Rp 11.000.000 (Melebihi Limit Harian) ---");
            akunBagas.transfer(akunTujuan, 11000000);

        } catch (SaldoTidakMencukupiException e) {
            System.out.println("\n[CATCH] Menangani SaldoTidakMencukupiException:");
            System.out.println("Pesan Error: " + e.getMessage());
            System.out.println("Anda kekurangan dana sebesar: Rp " + e.getNominalKekurangan());
        } catch (BatasTransferHarianException e) {
            System.out.println("\n[CATCH] Menangani BatasTransferHarianException:");
            System.out.println("Pesan Error: " + e.getMessage());
        } finally {
            System.out.println("\n=================================================================");
            System.out.println("STRUK DIGITAL:");
            System.out.println("Sesi transaksi ATM Anda telah diakhiri. Kartu dikeluarkan otomatis.");
            System.out.println("===================================================================");
        }
    }
}