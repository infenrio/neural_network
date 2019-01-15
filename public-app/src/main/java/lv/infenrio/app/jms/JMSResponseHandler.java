package lv.infenrio.app.jms;

import lv.infenrio.common.jms.JMSResponse;
import org.springframework.http.ResponseEntity;

public interface JMSResponseHandler {

    String getSupportedCommandId();

    default boolean canProcess(JMSResponse response) {
        return response.getCommandId().equals(getSupportedCommandId());
    }

    ResponseEntity process(JMSResponse jmsResponse);

}
