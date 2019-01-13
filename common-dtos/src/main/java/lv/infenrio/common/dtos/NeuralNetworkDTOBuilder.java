package lv.infenrio.common.dtos;

public class NeuralNetworkDTOBuilder {

    private int id;
    private String name;
    private int epochCount;
    private double maxError;
    private double learningRate;
    private double momentum;
    private int inputCount;
    private int hiddenCount;
    private int outputCount;

    private NeuralNetworkDTOBuilder() {}

    public static NeuralNetworkDTOBuilder createNeuralNetworkDTO() {
        return new NeuralNetworkDTOBuilder();
    }

    public NeuralNetworkDTO build() {
        NeuralNetworkDTO neuralNetwork = new NeuralNetworkDTO();
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

    public NeuralNetworkDTOBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public NeuralNetworkDTOBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public NeuralNetworkDTOBuilder withEpochCount(int epochCount) {
        this.epochCount = epochCount;
        return this;
    }

    public NeuralNetworkDTOBuilder withMaxError(double maxError) {
        this.maxError = maxError;
        return this;
    }

    public NeuralNetworkDTOBuilder withLearningRate(double learningRate) {
        this.learningRate = learningRate;
        return this;
    }

    public NeuralNetworkDTOBuilder withMomentum(double momentum) {
        this.momentum = momentum;
        return this;
    }

    public NeuralNetworkDTOBuilder withInputCount(int inputCount) {
        this.inputCount = inputCount;
        return this;
    }

    public NeuralNetworkDTOBuilder withHiddenCount(int hiddenCount) {
        this.hiddenCount = hiddenCount;
        return this;
    }

    public NeuralNetworkDTOBuilder withOutputCount(int outputCount) {
        this.outputCount = outputCount;
        return this;
    }
}
