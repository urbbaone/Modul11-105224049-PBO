// Soal 3: Unchecked Exception
class SksTidakCukupException extends RuntimeException {
    public SksTidakCukupException(String pesan) {
        super(pesan);
    }
}