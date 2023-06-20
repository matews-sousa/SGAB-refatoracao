package sgab.model.exception;

public class PersistenciaException extends RuntimeException {

    public PersistenciaException(String msg, Exception exception) {
        super(msg, exception);
    }

    public PersistenciaException(String msg) {
        super(msg);
    }
}
