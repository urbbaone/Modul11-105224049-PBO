import java.util.Scanner;
import java.util.InputMismatchException;

// Menggunakan konsep OOP dengan membuat class Kalkulator
class KalkulatorPembagian {
    
    public void jalankan() {
        // Inisialisasi Scanner di luar try agar bisa diakses di finally
        Scanner input = new Scanner(System.in);
        
        try {
            System.out.print("Masukkan angka pembilang: ");
            int angka1 = input.nextInt(); // Potensi InputMismatchException

            System.out.print("Masukkan angka penyebut: ");
            int angka2 = input.nextInt(); // Potensi InputMismatchException

            // Operasi pembagian
            int hasil = angka1 / angka2; // Potensi ArithmeticException jika angka2 = 0
            System.out.println("Hasil pembagian: " + hasil);

        } catch (InputMismatchException e) {
            // Menangani input yang bukan angka
            System.out.println("Peringatan: Input harus berupa angka bulat!");
        } catch (ArithmeticException e) {
            // Menangani pembagian dengan nol
            System.out.println("Peringatan: Tidak dapat membagi angka dengan nol!");
        } finally {
            // Menutup resource scanner dan mencetak pesan penutup
            input.close();
            System.out.println("Proses kalkulasi selesai dan resource memori telah dibersihkan.");
        }
    }
}