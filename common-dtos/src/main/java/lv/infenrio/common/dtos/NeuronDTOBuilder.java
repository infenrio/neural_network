package lv.infenrio.common.dtos;

public class NeuronDTOBuilder {

    private int id;
    private int neuralNetworkId;
    private double weight;
    private String type;

    private NeuronDTOBuilder() {}

    public static NeuronDTOBuilder createNeuronDTO() {
        return new NeuronDTOBuilder();
    }

    public NeuronDTO build() {
        NeuronDTO neuron = new NeuronDTO();
        neuron.setId(id);
        neuron.setNeuralNetworkId(neuralNetworkId);
        neuron.setWeight(weight);
        neuron.setType(type);
        return neuron;
    }

    public NeuronDTOBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public NeuronDTOBuilder withNeuralNetworkId(int neuralNetworkId) {
        this.neuralNetworkId = neuralNetworkId;
        return this;
    }

    public NeuronDTOBuilder withWeight(double weight) {
        this.weight = weight;
        return this;
    }

    public NeuronDTOBuilder withType(String type) {
        this.type = type;
        return this;
    }
}
