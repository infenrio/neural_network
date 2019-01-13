package lv.infenrio.common.dtos;

public class SynapseDTO {

    private int id;
    private int neuralNetworkId;
    private int neuronInId;
    private int neuronOutId;
    private double weight;
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNeuralNetworkId() {
        return neuralNetworkId;
    }

    public void setNeuralNetworkId(int neuralNetworkId) {
        this.neuralNetworkId = neuralNetworkId;
    }

    public int getNeuronInId() {
        return neuronInId;
    }

    public void setNeuronInId(int neuronInId) {
        this.neuronInId = neuronInId;
    }

    public int getNeuronOutId() {
        return neuronOutId;
    }

    public void setNeuronOutId(int neuronOutId) {
        this.neuronOutId = neuronOutId;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
