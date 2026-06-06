// Checked Exception untuk validasi kode/rute kereta
public class RuteTidakDitemukanException extends Exception {
    public RuteTidakDitemukanException(String message) {
        super(message);
    }
}