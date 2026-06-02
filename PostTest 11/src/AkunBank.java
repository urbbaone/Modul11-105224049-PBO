class AkunBank {
    private String nomorRekening;
    private double saldo;
    private double totalTransferHariIni;
    private final double LIMIT_HARIAN = 10000000.0; // Rp 10 Juta

    public AkunBank(String nomorRekening, double saldo) {
        this.nomorRekening = nomorRekening;
        this.saldo = saldo;
        this.totalTransferHariIni = 0;
    }

    // Getter untuk kebutuhan informasi di Main
    public String getNomorRekening() { return nomorRekening; }
    public double getSaldo() { return saldo; }

    // Metode Tarik Tunai
    public void tarikTunai(double nominal) throws SaldoTidakMencukupiException {
        if (nominal > saldo) {
            double kurang = nominal - saldo;
            throw new SaldoTidakMencukupiException("Transaksi Gagal: Saldo Anda tidak mencukupi.", kurang);
        }
        saldo -= nominal;
        System.out.println("Tarik tunai berhasil: Rp " + nominal + " | Sisa Saldo: Rp " + saldo);
    }

    // Metode Transfer ke Akun Lain
    public void transfer(AkunBank tujuan, double nominal) 
            throws SaldoTidakMencukupiException, BatasTransferHarianException {
        
        // Cek limit harian dulu
        if (totalTransferHariIni + nominal > LIMIT_HARIAN) {
            throw new BatasTransferHarianException("Transaksi Gagal: Transfer melebihi limit harian (Maks Rp 10.000.000).");
        }
        
        // Cek kecukupan saldo
        if (nominal > saldo) {
            double kurang = nominal - saldo;
            throw new SaldoTidakMencukupiException("Transaksi Gagal: Saldo tidak cukup untuk melakukan transfer.", kurang);
        }

        // Proses transfer berjalan jika lolos semua pengecekan
        this.saldo -= nominal;
        tujuan.saldo += nominal;
        this.totalTransferHariIni += nominal;
        
        System.out.println("Transfer ke " + tujuan.getNomorRekening() + " sebesar Rp " + nominal + " BERHASIL.");
        System.out.println("Total transfer hari ini: Rp " + totalTransferHariIni + " | Sisa Saldo: Rp " + saldo);
    }
}