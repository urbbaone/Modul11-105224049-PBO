// Unchecked Exception untuk validasi data personal (NIK)
public class DataPenumpangTidakValidException extends RuntimeException {
    public DataPenumpangTidakValidException(String message) {
        super(message);
    }
}