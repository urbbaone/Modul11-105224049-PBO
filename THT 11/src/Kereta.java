// Model data untuk objek Kereta Api
public class Kereta {
    private String kodeKereta;
    private String namaKereta;
    private String rute;
    private int sisaKursi;

    public Kereta(String kodeKereta, String namaKereta, String rute, int sisaKursi) {
        this.kodeKereta = kodeKereta;
        this.namaKereta = namaKereta;
        this.rute = rute;
        this.sisaKursi = sisaKursi;
    }

    public String getKodeKereta() { return kodeKereta; }
    public String getNamaKereta() { return namaKereta; }
    public String getRute() { return rute; }
    public int getSisaKursi() { return sisaKursi; }

    public void kurangiKursi(int jumlah) {
        this.sisaKursi -= jumlah;
    }
}