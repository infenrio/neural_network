package lv.infenrio.common.errors;

import lv.infenrio.common.ResponseStatus;

public class InternalServerError extends ApplicationException {

    public InternalServerError() {
        super(ResponseStatus.INTERNAL_SERVER_ERROR);
    }
}
