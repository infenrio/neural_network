package lv.infenrio.app.jms.responsehandlers;

import lv.infenrio.app.common.JsonMapper;
import lv.infenrio.app.jms.JMSResponseHandler;
import lv.infenrio.common.jms.JMSResponse;
import lv.infenrio.common.jms.SupportedCommandId;
import lv.infenrio.common.jms.requests.neuralnetwork.JMSCreateNeuralNetworkResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
class JMSCreateNeuralNetworkResponseHandler implements JMSResponseHandler {

    @Autowired private JsonMapper jsonMapper;

    @Override
    public String getSupportedCommandId() {
        return SupportedCommandId.CREATE_NEURAL_NETWORK;
    }

    @Override
    public ResponseEntity process(JMSResponse jmsResponse) {
        String payload = jmsResponse.getPayload();
        JMSCreateNeuralNetworkResponse response = jsonMapper.mapToObject(
                payload, JMSCreateNeuralNetworkResponse.class
        );
        return ResponseEntity.ok(response.getNeuralNetwork());
    }

}
