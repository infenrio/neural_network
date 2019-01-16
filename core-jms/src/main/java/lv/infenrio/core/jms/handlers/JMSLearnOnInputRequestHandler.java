package lv.infenrio.core.jms.handlers;

import lv.infenrio.common.jms.JMSRequest;
import lv.infenrio.common.jms.SupportedCommandId;
import lv.infenrio.common.jms.requests.neuralnetwork.JMSLearnOnInputRequest;
import lv.infenrio.common.jms.requests.neuralnetwork.JMSLearnOnInputResponse;
import lv.infenrio.core.api.commands.neuralnetwork.LearnOnInputCommand;
import lv.infenrio.core.api.commands.neuralnetwork.LearnOnInputResult;
import lv.infenrio.core.jms.JMSRequestHandler;
import org.springframework.stereotype.Component;

@Component
public class JMSLearnOnInputRequestHandler extends JMSRequestHandler {
    @Override
    public String getSupportedCommandId() {
        return SupportedCommandId.LEARN_ON_INPUT;
    }

    @Override
    public String process(JMSRequest request) {
        JMSLearnOnInputRequest jmsCommand = mapRequest(request, JMSLearnOnInputRequest.class);

        LearnOnInputCommand coreCommand = new LearnOnInputCommand(
                jmsCommand.getName(),
                jmsCommand.getData()
        );
        LearnOnInputResult coreResult = executeCoreCommand(coreCommand);

        JMSLearnOnInputResponse jmsResponse = new JMSLearnOnInputResponse();
        jmsResponse.setResult(coreResult.getResult());
        return buildPayload(jmsResponse);
    }
}
