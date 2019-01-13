package lv.infenrio.core.domain.builders;

import lv.infenrio.core.domain.NeuralNetwork;
import lv.infenrio.core.domain.Neuron;

public class NeuronBuilder {

    private int id;
    private NeuralNetwork neuralNetwork;
    private double weight;
    private String type;

    private NeuronBuilder() {}

    public static NeuronBuilder createNeuron() {
        return new NeuronBuilder();
    }

    public Neuron build() {
        Neuron neuron = new Neuron();
        neuron.setId(id);
        neuron.setNeuralNetwork(neuralNetwork);
        neuron.setWeight(weight);
        neuron.setType(type);
        return neuron;
    }

    public NeuronBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public NeuronBuilder withNeuralNetwork(NeuralNetwork neuralNetwork) {
        this.neuralNetwork = neuralNetwork;
        return this;
    }

    public NeuronBuilder withWeight(double weight) {
        this.weight = weight;
        return this;
    }

    public NeuronBuilder withType(String type) {
        this.type = type;
        return this;
    }
}
