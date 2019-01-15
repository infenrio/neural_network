package lv.infenrio.common.errors;

public class ValidationError extends RuntimeException {

    private ErrorCode errorCode;
    private String description;
    private ErrorEmitter errorEmitter;

    public ValidationError(ErrorCode errorCode,
                           String description,
                           ErrorEmitter errorEmitter) {
        this.errorCode = errorCode;
        this.description = description;
        this.errorEmitter = errorEmitter;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public String getDescription() {
        return description;
    }

    public ErrorEmitter getErrorEmitter() {
        return errorEmitter;
    }

}
