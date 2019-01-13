package lv.infenrio.common.dtos;

public class NeuronDTO {

    private int id;
    private int neuralNetworkId;
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
