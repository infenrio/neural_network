package lv.infenrio.core.jms.handlers;

import lv.infenrio.common.jms.JMSRequest;
import lv.infenrio.common.jms.SupportedCommandId;
import lv.infenrio.common.jms.requests.neuralnetwork.JMSCreateNeuralNetworkRequest;
import lv.infenrio.common.jms.requests.neuralnetwork.JMSCreateNeuralNetworkResponse;
import lv.infenrio.core.api.commands.neuralnetwork.CreateNeuralNetworkCommand;
import lv.infenrio.core.api.commands.neuralnetwork.CreateNeuralNetworkResult;
import lv.infenrio.core.jms.JMSRequestHandler;
import org.springframework.stereotype.Component;

@Component
class JMSCreateNeuralNetworkRequestHandler extends JMSRequestHandler {

    @Override
    public String getSupportedCommandId() {
        return SupportedCommandId.CREATE_NEURAL_NETWORK;
    }

    @Override
    public String process(JMSRequest request) {
        JMSCreateNeuralNetworkRequest jmsCommand = mapRequest(request, JMSCreateNeuralNetworkRequest.class);

        CreateNeuralNetworkCommand coreCommand = new CreateNeuralNetworkCommand(
                jmsCommand.getNeuralNetwork().getName(),
                jmsCommand.getNeuralNetwork().getEpochCount(),
                jmsCommand.getNeuralNetwork().getMaxError(),
                jmsCommand.getNeuralNetwork().getLearningRate(),
                jmsCommand.getNeuralNetwork().getMomentum(),
                jmsCommand.getNeuralNetwork().getInputCount(),
                jmsCommand.getNeuralNetwork().getHiddenCount(),
                jmsCommand.getNeuralNetwork().getOutputCount()
        );
        CreateNeuralNetworkResult coreResult = executeCoreCommand(coreCommand);

        JMSCreateNeuralNetworkResponse jmsResponse = new JMSCreateNeuralNetworkResponse();
        jmsResponse.setNeuralNetwork(coreResult.getNeuralNetwork());
        return buildPayload(jmsResponse);
    }

}
