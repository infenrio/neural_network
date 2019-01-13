package lv.infenrio.common.dtos;

public class SynapseDTOBuilder {

    private int id;
    private int neuralNetworkId;
    private int neuronInId;
    private int neuronOutId;
    private double weight;
    private String type;

    private SynapseDTOBuilder() {}

    public static SynapseDTOBuilder createSynapseDTO() {
        return new SynapseDTOBuilder();
    }

    public SynapseDTO build() {
        SynapseDTO synapse = new SynapseDTO();
        synapse.setId(id);
        synapse.setNeuralNetworkId(neuralNetworkId);
        synapse.setNeuronInId(neuronInId);
        synapse.setNeuronOutId(neuronOutId);
        synapse.setWeight(weight);
        synapse.setType(type);
        return synapse;
    }

    public SynapseDTOBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public SynapseDTOBuilder withNeuralNetworkId(int neuralNetworkId) {
        this.neuralNetworkId = neuralNetworkId;
        return this;
    }

    public SynapseDTOBuilder withNeuronInId(int neuronInId) {
        this.neuronInId = neuronInId;
        return this;
    }

    public SynapseDTOBuilder withNeuronOutId(int neuronOutId) {
        this.neuronOutId = neuronOutId;
        return this;
    }

    public SynapseDTOBuilder withWeight(double weight) {
        this.weight = weight;
        return this;
    }

    public SynapseDTOBuilder withType(String type) {
        this.type = type;
        return this;
    }
}
