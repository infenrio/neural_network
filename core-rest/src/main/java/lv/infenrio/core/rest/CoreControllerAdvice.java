package lv.infenrio.core.rest;

import lv.infenrio.common.errors.ErrorCode;
import lv.infenrio.common.errors.ErrorDTO;
import lv.infenrio.common.errors.ErrorEmitter;
import lv.infenrio.core.api.errors.CoreValidationError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice(assignableTypes = NeuralNetworkRestController.class)
public class CoreControllerAdvice {

    @ExceptionHandler(CoreValidationError.class)
    public ResponseEntity<ErrorDTO> handleValidationError(CoreValidationError error,
                                                          HttpServletRequest request) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setErrorCode(error.getErrorCode());
        errorDTO.setDescription(error.getDescription());
        errorDTO.setErrorEmitter(error.getErrorEmitter());
        return ResponseEntity.status(error.getErrorCode().getHttpCode()).body(errorDTO);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ErrorDTO> handleValidationError(Throwable error,
                                                          HttpServletRequest request) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setErrorCode(ErrorCode.INTERNAL);
        errorDTO.setDescription("Unexpected server error");
        errorDTO.setErrorEmitter(ErrorEmitter.CORE_APP);
        return ResponseEntity.status(ErrorCode.INTERNAL.getHttpCode()).body(errorDTO);
    }

}
