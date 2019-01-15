package lv.infenrio.common.jms.requests.neuralnetwork;

import com.fasterxml.jackson.annotation.JsonProperty;
import lv.infenrio.common.dtos.NeuralNetworkDTO;

public class JMSCreateNeuralNetworkResponse {

    @JsonProperty("neuralNetwork")
    private NeuralNetworkDTO neuralNetwork;


    public NeuralNetworkDTO getNeuralNetwork() {
        return neuralNetwork;
    }

    public void setNeuralNetwork(NeuralNetworkDTO neuralNetwork) {
        this.neuralNetwork = neuralNetwork;
    }
}
