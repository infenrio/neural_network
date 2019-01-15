package lv.infenrio.core.jms;

import lv.infenrio.common.errors.InternalServerError;
import lv.infenrio.common.errors.ValidationException;
import lv.infenrio.common.jms.JMSRequest;
import lv.infenrio.common.jms.JMSResponse;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public interface JMSRequestExecutor {
    JMSResponse execute(JMSRequest request);
}

@Component
class JMSRequestExecutorImpl implements JMSRequestExecutor {

    private static final Logger log = getLogger(JMSRequestExecutorImpl.class);

    @Autowired private List<JMSRequestHandler> requestHandlers;
    @Autowired private JMSResponseBuilder responseBuilder;

    @Override
    public JMSResponse execute(JMSRequest request) {
        try {
            String payload = selectHandlerAndProcessRequest(request);
            return responseBuilder.buildSuccess(request, payload);
        } catch (ValidationException e) {
            log.error("Validation exception", e);
            return responseBuilder.buildFail(request, e);
        } catch (InternalServerError e) {
            log.error("Internal Server exception", e);
            return responseBuilder.buildFail(request, e);
        } catch (RuntimeException e) {
            log.error("Runtime exception", e);
            return responseBuilder.buildFail(request, e);
        }
    }

    private String selectHandlerAndProcessRequest(JMSRequest request) {
        return requestHandlers.stream()
                .filter(ch -> ch.canProcess(request))
                .findFirst()
                .orElseThrow(InternalServerError::new)
                .process(request);
    }

}
