package lv.infenrio.core.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="neuron")
public class Neuron {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name="id", nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name="neural_network_idref", nullable = false)
    private NeuralNetwork neuralNetwork;

    @Column(name="weight", nullable = false)
    private double weight;

    @Column(name="type", nullable = false)
    private String type;

    @Transient
    private double tempValue;

    @Transient
    private double deltaInitialWeight;

    @Transient
    private double deltaTempValue;

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

    public double getDeltaInitialWeight() {
        return deltaInitialWeight;
    }

    public void setDeltaInitialWeight(double deltaInitialWeight) {
        this.deltaInitialWeight = deltaInitialWeight;
    }

    public double getDeltaTempValue() {
        return deltaTempValue;
    }

    public void setDeltaTempValue(double deltaTempValue) {
        this.deltaTempValue = deltaTempValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Neuron neuron = (Neuron) o;

        if (id != neuron.id) return false;
        if (Double.compare(neuron.weight, weight) != 0) return false;
        if (!neuralNetwork.equals(neuron.neuralNetwork)) return false;
        return type.equals(neuron.type);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + neuralNetwork.hashCode();
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + type.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Neuron{" +
                "id=" + id +
                ", neuralNetwork=" + neuralNetwork +
                ", weight=" + weight +
                ", type='" + type + '\'' +
                '}';
    }
}
