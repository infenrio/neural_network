package lv.infenrio.app.jms.responsehandlers;

import lv.infenrio.app.common.JsonMapper;
import lv.infenrio.app.jms.JMSResponseHandler;
import lv.infenrio.common.jms.JMSResponse;
import lv.infenrio.common.jms.SupportedCommandId;
import lv.infenrio.common.jms.requests.neuralnetwork.JMSProcessSingleInputResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class JMSProcessSingleInputResponseHandler implements JMSResponseHandler {

    @Autowired private JsonMapper jsonMapper;

    @Override
    public String getSupportedCommandId() {
        return SupportedCommandId.PROCESS_SINGLE_INPUT;
    }

    @Override
    public ResponseEntity process(JMSResponse jmsResponse) {
        String payload = jmsResponse.getPayload();
        JMSProcessSingleInputResponse response = jsonMapper.mapToObject(
                payload, JMSProcessSingleInputResponse.class
        );
        return ResponseEntity.ok(response.getData());
    }
}
