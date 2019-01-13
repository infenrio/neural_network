package lv.infenrio.core.api.commands.neuralnetwork;

import lv.infenrio.common.dtos.NeuralNetworkWrapperDTO;
import lv.infenrio.core.api.commands.DomainCommandResult;

public class GetNeuralNetworkResult implements DomainCommandResult {

    private NeuralNetworkWrapperDTO neuralNetwork;

    public GetNeuralNetworkResult(NeuralNetworkWrapperDTO neuralNetwork) {
        this.neuralNetwork = neuralNetwork;
    }

    public NeuralNetworkWrapperDTO getNeuralNetwork() {
        return neuralNetwork;
    }
}
