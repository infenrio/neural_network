package lv.infenrio.common.dtos;

import java.util.HashMap;

public class NeuralNetworkWrapperDTOBuilder {

    private NeuralNetworkDTO neuralNetwork;
    private HashMap<Integer, NeuronDTO> inputNeurons;
    private HashMap<Integer, NeuronDTO> hiddenNeurons;
    private HashMap<Integer, NeuronDTO> outputNeurons;
    private HashMap<Integer, SynapseDTO> inputHiddenSynapses;
    private HashMap<Integer, SynapseDTO> hiddenOutputSynapses;

    private NeuralNetworkWrapperDTOBuilder() {}

    public static NeuralNetworkWrapperDTOBuilder createNeuralNetworkWrapperDTO() {
        return new NeuralNetworkWrapperDTOBuilder();
    }

    public NeuralNetworkWrapperDTO build() {
        NeuralNetworkWrapperDTO neuralNetworkWrapper = new NeuralNetworkWrapperDTO();
        neuralNetworkWrapper.setNeuralNetwork(neuralNetwork);
        neuralNetworkWrapper.setInputNeurons(inputNeurons);
        neuralNetworkWrapper.setHiddenNeurons(hiddenNeurons);
        neuralNetworkWrapper.setOutputNeurons(outputNeurons);
        neuralNetworkWrapper.setInputHiddenSynapses(inputHiddenSynapses);
        neuralNetworkWrapper.setHiddenOutputSynapses(hiddenOutputSynapses);
        return neuralNetworkWrapper;
    }

    public NeuralNetworkWrapperDTOBuilder withNeuralNetwork(NeuralNetworkDTO neuralNetwork) {
        this.neuralNetwork = neuralNetwork;
        return this;
    }

    public NeuralNetworkWrapperDTOBuilder withInputNeurons(HashMap<Integer, NeuronDTO> inputNeurons) {
        this.inputNeurons = inputNeurons;
        return this;
    }

    public NeuralNetworkWrapperDTOBuilder withHiddenNeurons(HashMap<Integer, NeuronDTO> hiddenNeurons) {
        this.hiddenNeurons = hiddenNeurons;
        return this;
    }

    public NeuralNetworkWrapperDTOBuilder withOutputNeurons(HashMap<Integer, NeuronDTO> outputNeurons) {
        this.outputNeurons = outputNeurons;
        return this;
    }

    public NeuralNetworkWrapperDTOBuilder withInputHiddenSynapses(HashMap<Integer, SynapseDTO> inputHiddenSynapses) {
        this.inputHiddenSynapses = inputHiddenSynapses;
        return this;
    }

    public NeuralNetworkWrapperDTOBuilder withHiddenOutputSynapses(HashMap<Integer, SynapseDTO> hiddenOutputSynapses) {
        this.hiddenOutputSynapses = hiddenOutputSynapses;
        return this;
    }
}
