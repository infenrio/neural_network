package lv.infenrio.core.jms;

import lv.infenrio.common.jms.JMSQueues;
import lv.infenrio.common.jms.JMSRequest;
import lv.infenrio.common.jms.JMSResponse;
import lv.infenrio.core.commons.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

@Component
class JMSRequestReceiver {

    @Autowired private JMSRequestExecutor jmsRequestExecutor;
    @Autowired private JsonMapper jsonMapper;
    @Autowired private JMSResponseSender jmsResponseSender;

    @JmsListener(destination = JMSQueues.PUBLIC_APP_REQUEST_QUEUE,
            concurrency = "${jms.client.request.listener.concurrency:10}")
    public void onMessage(TextMessage inMessage) throws JMSException {
        processRequest(inMessage);
    }

    protected void processRequest(TextMessage inMessage) throws JMSException {
        String messageText = inMessage.getText();
        JMSRequest request = jsonMapper.mapToObject(messageText, JMSRequest.class);
        JMSResponse response = jmsRequestExecutor.execute(request);
        jmsResponseSender.send(response, inMessage.getJMSCorrelationID());
    }

}
