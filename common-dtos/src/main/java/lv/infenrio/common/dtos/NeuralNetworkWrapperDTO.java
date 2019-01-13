package lv.infenrio.common.dtos;

import java.util.HashMap;

public class NeuralNetworkWrapperDTO {

    private NeuralNetworkDTO neuralNetwork;
    private HashMap<Integer, NeuronDTO> inputNeurons;
    private HashMap<Integer, NeuronDTO> hiddenNeurons;
    private HashMap<Integer, NeuronDTO> outputNeurons;
    private HashMap<Integer, SynapseDTO> inputHiddenSynapses;
    private HashMap<Integer, SynapseDTO> hiddenOutputSynapses;

    public NeuralNetworkDTO getNeuralNetwork() {
        return neuralNetwork;
    }

    public void setNeuralNetwork(NeuralNetworkDTO neuralNetwork) {
        this.neuralNetwork = neuralNetwork;
    }

    public HashMap<Integer, NeuronDTO> getInputNeurons() {
        return inputNeurons;
    }

    public void setInputNeurons(HashMap<Integer, NeuronDTO> inputNeurons) {
        this.inputNeurons = inputNeurons;
    }

    public HashMap<Integer, NeuronDTO> getHiddenNeurons() {
        return hiddenNeurons;
    }

    public void setHiddenNeurons(HashMap<Integer, NeuronDTO> hiddenNeurons) {
        this.hiddenNeurons = hiddenNeurons;
    }

    public HashMap<Integer, NeuronDTO> getOutputNeurons() {
        return outputNeurons;
    }

    public void setOutputNeurons(HashMap<Integer, NeuronDTO> outputNeurons) {
        this.outputNeurons = outputNeurons;
    }

    public HashMap<Integer, SynapseDTO> getInputHiddenSynapses() {
        return inputHiddenSynapses;
    }

    public void setInputHiddenSynapses(HashMap<Integer, SynapseDTO> inputHiddenSynapses) {
        this.inputHiddenSynapses = inputHiddenSynapses;
    }

    public HashMap<Integer, SynapseDTO> getHiddenOutputSynapses() {
        return hiddenOutputSynapses;
    }

    public void setHiddenOutputSynapses(HashMap<Integer, SynapseDTO> hiddenOutputSynapses) {
        this.hiddenOutputSynapses = hiddenOutputSynapses;
    }
}
