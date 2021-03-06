package lv.infenrio.core.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="synapse")
public class Synapse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name="id", nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name="neural_network_idref", nullable = false)
    private NeuralNetwork neuralNetwork;

    @ManyToOne
    @JoinColumn(name="neuron_in_idref", nullable = false)
    private Neuron neuronIn;

    @ManyToOne
    @JoinColumn(name="neuron_out_idref", nullable = false)
    private Neuron neuronOut;

    @Column(name="weight", nullable = false)
    private double weight;

    @Column(name="type", nullable = false)
    private String type;

    @Transient
    private double tempValue;

    @Transient
    private double deltaWeight;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NeuralNetwork getNeuralNetwork() {
        return neuralNetwork;
    }

    public void setNeuralNetwork(NeuralNetwork neuralNetwork) {
        this.neuralNetwork = neuralNetwork;
    }

    public Neuron getNeuronIn() {
        return neuronIn;
    }

    public void setNeuronIn(Neuron neuronIn) {
        this.neuronIn = neuronIn;
    }

    public Neuron getNeuronOut() {
        return neuronOut;
    }

    public void setNeuronOut(Neuron neuronOut) {
        this.neuronOut = neuronOut;
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

    public double getTempValue() {
        return tempValue;
    }

    public void setTempValue(double tempValue) {
        this.tempValue = tempValue;
    }

    public double getDeltaWeight() {
        return deltaWeight;
    }

    public void setDeltaWeight(double deltaWeight) {
        this.deltaWeight = deltaWeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Synapse synapse = (Synapse) o;

        if (id != synapse.id) return false;
        if (Double.compare(synapse.weight, weight) != 0) return false;
        if (!neuralNetwork.equals(synapse.neuralNetwork)) return false;
        if (!neuronIn.equals(synapse.neuronIn)) return false;
        if (!neuronOut.equals(synapse.neuronOut)) return false;
        return type.equals(synapse.type);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + neuralNetwork.hashCode();
        result = 31 * result + neuronIn.hashCode();
        result = 31 * result + neuronOut.hashCode();
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + type.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Synapse{" +
                "id=" + id +
                ", neuralNetwork=" + neuralNetwork +
                ", neuronIn=" + neuronIn +
                ", neuronOut=" + neuronOut +
                ", weight=" + weight +
                ", type='" + type + '\'' +
                '}';
    }
}
