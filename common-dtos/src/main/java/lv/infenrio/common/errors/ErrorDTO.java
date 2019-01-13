package lv.infenrio.common.errors;

public class ErrorDTO {

    private ErrorCode errorCode;
    private String description;
    private ErrorEmitter errorEmitter;

    public ErrorDTO() { }

    public ErrorDTO(ErrorCode errorCode,
                    String description,
                    ErrorEmitter errorEmitter) {
        this.errorCode = errorCode;
        this.description = description;
        this.errorEmitter = errorEmitter;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ErrorEmitter getErrorEmitter() {
        return errorEmitter;
    }

    public void setErrorEmitter(ErrorEmitter errorEmitter) {
        this.errorEmitter = errorEmitter;
    }
}
