import java.io.FileNotFoundException;

public class SistemAkademik {
    public void gabungKelas(String kodeKelas, int kuotaTersedia) throws KelasPenuhException {
        if (kuotaTersedia <= 0) {
            throw new KelasPenuhException("Kesalahan sistem: Kelas " + kodeKelas + " sudah penuh!");
        }
        System.out.println("Berhasil bergabung di kelas " + kodeKelas);
    }

    public void cetakDokumenKrs(String namaFile) throws FileNotFoundException {
        if (!namaFile.equals("krs_valid.txt")) {
            throw new FileNotFoundException("File '" + namaFile + "' tidak ditemukan di sistem.");
        }
        System.out.println("Dokumen KRS " + namaFile + " berhasil dicetak.");
    }
}