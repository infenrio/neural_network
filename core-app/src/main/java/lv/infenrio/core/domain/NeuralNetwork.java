package lv.infenrio.core.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="neural_network")
public class NeuralNetwork {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name="id", nullable = false)
    private int id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="epoch_count", nullable = false)
    private int epochCount;

    @Column(name="max_error", nullable = false)
    private double maxError;

    @Column(name="learning_rate", nullable = false)
    private double learningRate;

    @Column(name="momentum", nullable = false)
    private double momentum;

    @Column(name="input_count", nullable = false)
    private int inputCount;

    @Column(name="hidden_count", nullable = false)
    private int hiddenCount;

    @Column(name="output_count", nullable = false)
    private int outputCount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEpochCount() {
        return epochCount;
    }

    public void setEpochCount(int epochCount) {
        this.epochCount = epochCount;
    }

    public double getMaxError() {
        return maxError;
    }

    public void setMaxError(double maxError) {
        this.maxError = maxError;
    }

    public double getLearningRate() {
        return learningRate;
    }

    public void setLearningRate(double learningRate) {
        this.learningRate = learningRate;
    }

    public double getMomentum() {
        return momentum;
    }

    public void setMomentum(double momentum) {
        this.momentum = momentum;
    }

    public int getInputCount() {
        return inputCount;
    }

    public void setInputCount(int inputCount) {
        this.inputCount = inputCount;
    }

    public int getHiddenCount() {
        return hiddenCount;
    }

    public void setHiddenCount(int hiddenCount) {
        this.hiddenCount = hiddenCount;
    }

    public int getOutputCount() {
        return outputCount;
    }

    public void setOutputCount(int outputCount) {
        this.outputCount = outputCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NeuralNetwork that = (NeuralNetwork) o;

        if (id != that.id) return false;
        if (epochCount != that.epochCount) return false;
        if (Double.compare(that.maxError, maxError) != 0) return false;
        if (Double.compare(that.learningRate, learningRate) != 0) return false;
        if (Double.compare(that.momentum, momentum) != 0) return false;
        if (inputCount != that.inputCount) return false;
        if (hiddenCount != that.hiddenCount) return false;
        if (outputCount != that.outputCount) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + epochCount;
        temp = Double.doubleToLongBits(maxError);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(learningRate);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(momentum);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + inputCount;
        result = 31 * result + hiddenCount;
        result = 31 * result + outputCount;
        return result;
    }

    @Override
    public String toString() {
        return "NeuralNetwork{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", epochCount=" + epochCount +
                ", maxError=" + maxError +
                ", learningRate=" + learningRate +
                ", momentum=" + momentum +
                ", inputCount=" + inputCount +
                ", hiddenCount=" + hiddenCount +
                ", outputCount=" + outputCount +
                '}';
    }
}
