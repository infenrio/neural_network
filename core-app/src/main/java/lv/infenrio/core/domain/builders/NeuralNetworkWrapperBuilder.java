package lv.infenrio.core.domain.builders;

import lv.infenrio.core.domain.NeuralNetwork;
import lv.infenrio.core.domain.NeuralNetworkWrapper;
import lv.infenrio.core.domain.Neuron;
import lv.infenrio.core.domain.Synapse;

import java.util.HashMap;

public class NeuralNetworkWrapperBuilder {

    private NeuralNetwork neuralNetwork;
    private HashMap<Integer, Neuron> inputNeurons;
    private HashMap<Integer, Neuron> hiddenNeurons;
    private HashMap<Integer, Neuron> outputNeurons;
    private HashMap<Integer, Synapse> inputHiddenSynapses;
    private HashMap<Integer, Synapse> hiddenOutputSynapses;

    private NeuralNetworkWrapperBuilder() {}

    public static NeuralNetworkWrapperBuilder createNeuralNetworkWrapper() {
        return new NeuralNetworkWrapperBuilder();
    }

    public NeuralNetworkWrapper build() {
        NeuralNetworkWrapper neuralNetworkWrapper = new NeuralNetworkWrapper();
        neuralNetworkWrapper.setNeuralNetwork(neuralNetwork);
        neuralNetworkWrapper.setInputNeurons(inputNeurons);
        neuralNetworkWrapper.setHiddenNeurons(hiddenNeurons);
        neuralNetworkWrapper.setOutputNeurons(outputNeurons);
        neuralNetworkWrapper.setInputHiddenSynapses(inputHiddenSynapses);
        neuralNetworkWrapper.setHiddenOutputSynapses(hiddenOutputSynapses);
        return neuralNetworkWrapper;
    }

    public NeuralNetworkWrapperBuilder withNeuralNetwork(NeuralNetwork neuralNetwork) {
        this.neuralNetwork = neuralNetwork;
        return this;
    }

    public NeuralNetworkWrapperBuilder withInputNeurons(HashMap<Integer, Neuron> inputNeurons) {
        this.inputNeurons = inputNeurons;
        return this;
    }

    public NeuralNetworkWrapperBuilder withHiddenNeurons(HashMap<Integer, Neuron> hiddenNeurons) {
        this.hiddenNeurons = hiddenNeurons;
        return this;
    }

    public NeuralNetworkWrapperBuilder withOutputNeurons(HashMap<Integer, Neuron> outputNeurons) {
        this.outputNeurons = outputNeurons;
        return this;
    }

    public NeuralNetworkWrapperBuilder withInputHiddenSynapses(HashMap<Integer, Synapse> inputHiddenSynapses) {
        this.inputHiddenSynapses = inputHiddenSynapses;
        return this;
    }

    public NeuralNetworkWrapperBuilder withHiddenOutputSynapses(HashMap<Integer, Synapse> hiddenOutputSynapses) {
        this.hiddenOutputSynapses = hiddenOutputSynapses;
        return this;
    }
}
