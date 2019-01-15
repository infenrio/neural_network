package lv.infenrio.common.jms.requests.neuralnetwork;

import com.fasterxml.jackson.annotation.JsonProperty;
import lv.infenrio.common.dtos.NeuralNetworkDTO;
import lv.infenrio.common.jms.SupportedCommandId;
import lv.infenrio.common.jms.requests.JMSAPIRequest;

public class JMSCreateNeuralNetworkRequest implements JMSAPIRequest {

    @JsonProperty("neuralNetwork")
    private NeuralNetworkDTO neuralNetwork;


    @Override
    public String getCommandId() {
        return SupportedCommandId.CREATE_NEURAL_NETWORK;
    }

    public NeuralNetworkDTO getNeuralNetwork() {
        return neuralNetwork;
    }

    public void setNeuralNetwork(NeuralNetworkDTO neuralNetwork) {
        this.neuralNetwork = neuralNetwork;
    }
}
