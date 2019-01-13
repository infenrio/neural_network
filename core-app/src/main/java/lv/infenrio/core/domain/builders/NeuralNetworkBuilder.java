package lv.infenrio.core.domain.builders;

import lv.infenrio.core.domain.NeuralNetwork;

public class NeuralNetworkBuilder {

    private int id;
    private String name;
    private int epochCount;
    private double maxError;
    private double learningRate;
    private double momentum;
    private int inputCount;
    private int hiddenCount;
    private int outputCount;

    private NeuralNetworkBuilder() {}

    public static NeuralNetworkBuilder createNeuralNetwork() {
        return new NeuralNetworkBuilder();
    }

    public NeuralNetwork build() {
        NeuralNetwork neuralNetwork = new NeuralNetwork();
        neuralNetwork.setId(id);
        neuralNetwork.setName(name);
        neuralNetwork.setEpochCount(epochCount);
        neuralNetwork.setMaxError(maxError);
        neuralNetwork.setLearningRate(learningRate);
        neuralNetwork.setMomentum(momentum);
        neuralNetwork.setInputCount(inputCount);
        neuralNetwork.setHiddenCount(hiddenCount);
        neuralNetwork.setOutputCount(outputCount);
        return neuralNetwork;
    }

    public NeuralNetworkBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public NeuralNetworkBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public NeuralNetworkBuilder withEpochCount(int epochCount) {
        this.epochCount = epochCount;
        return this;
    }

    public NeuralNetworkBuilder withMaxError(double maxError) {
        this.maxError = maxError;
        return this;
    }

    public NeuralNetworkBuilder withLearningRate(double learningRate) {
        this.learningRate = learningRate;
        return this;
    }

    public NeuralNetworkBuilder withMomentum(double momentum) {
        this.momentum = momentum;
        return this;
    }

    public NeuralNetworkBuilder withInputCount(int inputCount) {
        this.inputCount = inputCount;
        return this;
    }

    public NeuralNetworkBuilder withHiddenCount(int hiddenCount) {
        this.hiddenCount = hiddenCount;
        return this;
    }

    public NeuralNetworkBuilder withOutputCount(int outputCount) {
        this.outputCount = outputCount;
        return this;
    }
}
