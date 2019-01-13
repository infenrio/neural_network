package lv.infenrio.core.domain.builders;

import lv.infenrio.core.domain.NeuralNetwork;
import lv.infenrio.core.domain.Neuron;
import lv.infenrio.core.domain.Synapse;

public class SynapseBuilder {

    private int id;
    private NeuralNetwork neuralNetwork;
    private Neuron neuronIn;
    private Neuron neuronOut;
    private double weight;
    private String type;

    private SynapseBuilder() {}

    public static SynapseBuilder createSynapse() {
        return new SynapseBuilder();
    }

    public Synapse build() {
        Synapse synapse = new Synapse();
        synapse.setId(id);
        synapse.setNeuralNetwork(neuralNetwork);
        synapse.setNeuronIn(neuronIn);
        synapse.setNeuronOut(neuronOut);
        synapse.setWeight(weight);
        synapse.setType(type);
        return synapse;
    }

    public SynapseBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public SynapseBuilder withNeuralNetwork(NeuralNetwork neuralNetwork) {
        this.neuralNetwork = neuralNetwork;
        return this;
    }

    public SynapseBuilder withNeuronIn(Neuron neuronIn) {
        this.neuronIn = neuronIn;
        return this;
    }

    public SynapseBuilder withNeuronOut(Neuron neuronOut) {
        this.neuronOut = neuronOut;
        return this;
    }

    public SynapseBuilder withWeight(double weight) {
        this.weight = weight;
        return this;
    }

    public SynapseBuilder withType(String type) {
        this.type = type;
        return this;
    }
}
