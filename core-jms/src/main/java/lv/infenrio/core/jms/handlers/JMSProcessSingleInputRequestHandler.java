package lv.infenrio.core.jms.handlers;

import lv.infenrio.common.jms.JMSRequest;
import lv.infenrio.common.jms.SupportedCommandId;
import lv.infenrio.common.jms.requests.neuralnetwork.JMSProcessSingleInputRequest;
import lv.infenrio.common.jms.requests.neuralnetwork.JMSProcessSingleInputResponse;
import lv.infenrio.core.api.commands.neuralnetwork.ProcessSingleInputCommand;
import lv.infenrio.core.api.commands.neuralnetwork.ProcessSingleInputResult;
import lv.infenrio.core.jms.JMSRequestHandler;
import org.springframework.stereotype.Component;

@Component
public class JMSProcessSingleInputRequestHandler extends JMSRequestHandler {

    @Override
    public String getSupportedCommandId() {
        return SupportedCommandId.PROCESS_SINGLE_INPUT;
    }

    @Override
    public String process(JMSRequest request) {
        JMSProcessSingleInputRequest jmsCommand = mapRequest(request, JMSProcessSingleInputRequest.class);

        ProcessSingleInputCommand coreCommand = new ProcessSingleInputCommand(
                jmsCommand.getName(),
                jmsCommand.getData()
        );
        ProcessSingleInputResult coreResult = executeCoreCommand(coreCommand);

        JMSProcessSingleInputResponse jmsResponse = new JMSProcessSingleInputResponse();
        jmsResponse.setData(coreResult.getSingleOutput());
        return buildPayload(jmsResponse);
    }
}
