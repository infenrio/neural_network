package lv.infenrio.core.api.commands.neuralnetwork;

import lv.infenrio.core.api.commands.DomainCommand;

public class CreateNeuralNetworkCommand implements DomainCommand<CreateNeuralNetworkResult> {

    private String name;
    private int epochCount;
    private double maxError;
    private double learningRate;
    private double momentum;
    private int inputCount;
    private int hiddenCount;
    private int outputCount;

    public CreateNeuralNetworkCommand(String name, int epochCount, double maxError, double learningRate, double momentum, int inputCount, int hiddenCount, int outputCount) {
        this.name = name;
        this.epochCount = epochCount;
        this.maxError = maxError;
        this.learningRate = learningRate;
        this.momentum = momentum;
        this.inputCount = inputCount;
        this.hiddenCount = hiddenCount;
        this.outputCount = outputCount;
    }

    public String getName() {
        return name;
    }

    public int getEpochCount() {
        return epochCount;
    }

    public double getMaxError() {
        return maxError;
    }

    public double getLearningRate() {
        return learningRate;
    }

    public double getMomentum() {
        return momentum;
    }

    public int getInputCount() {
        return inputCount;
    }

    public int getHiddenCount() {
        return hiddenCount;
    }

    public int getOutputCount() {
        return outputCount;
    }
}
