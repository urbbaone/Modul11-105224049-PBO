class SaldoTidakMencukupiException extends Exception {
    private double nominalKekurangan;

    public SaldoTidakMencukupiException(String pesan, double nominalKekurangan) {
        super(pesan);
        this.nominalKekurangan = nominalKekurangan;
    }

    public double getNominalKekurangan() {
        return nominalKekurangan;
    }
}