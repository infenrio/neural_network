package lv.infenrio.core.api.commands.neuralnetwork;

import lv.infenrio.common.dtos.NeuralNetworkDTO;
import lv.infenrio.core.api.commands.DomainCommandResult;

public class CreateNeuralNetworkResult implements DomainCommandResult {

    private NeuralNetworkDTO neuralNetwork;

    public CreateNeuralNetworkResult(NeuralNetworkDTO neuralNetwork) {
        this.neuralNetwork = neuralNetwork;
    }

    public NeuralNetworkDTO getNeuralNetwork() {
        return neuralNetwork;
    }
}
