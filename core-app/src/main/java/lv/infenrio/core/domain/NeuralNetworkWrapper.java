package lv.infenrio.core.domain;

import lv.infenrio.common.dtos.LearningDataDTO;
import lv.infenrio.common.dtos.SingleInputDataDTO;
import lv.infenrio.common.dtos.SingleOutputDataDTO;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class NeuralNetworkWrapper {

    private NeuralNetwork neuralNetwork;
    private HashMap<Integer, Neuron> inputNeurons;
    private HashMap<Integer, Neuron> hiddenNeurons;
    private HashMap<Integer, Neuron> outputNeurons;
    private HashMap<Integer, Synapse> inputHiddenSynapses;
    private HashMap<Integer, Synapse> hiddenOutputSynapses;

    private Neuron[] inputNeuronsArray;
    private HashMap<Integer, Integer> inputNeuronsArrayIndexMapper;
    private Neuron[] hiddenNeuronsArray;
    private HashMap<Integer, Integer> hiddenNeuronsArrayIndexMapper;
    private Neuron[] outputNeuronsArray;
    private HashMap<Integer, Integer> outputNeuronsArrayIndexMapper;
    private Synapse[][] inputHiddenSynapsesArray;
    private Synapse[][] hiddenOutputSynapsesArray;

    public NeuralNetwork getNeuralNetwork() {
        return neuralNetwork;
    }

    public void setNeuralNetwork(NeuralNetwork neuralNetwork) {
        this.neuralNetwork = neuralNetwork;
    }

    public HashMap<Integer, Neuron> getInputNeurons() {
        return inputNeurons;
    }

    public void setInputNeurons(HashMap<Integer, Neuron> inputNeurons) {
        this.inputNeurons = inputNeurons;
    }

    public HashMap<Integer, Neuron> getHiddenNeurons() {
        return hiddenNeurons;
    }

    public void setHiddenNeurons(HashMap<Integer, Neuron> hiddenNeurons) {
        this.hiddenNeurons = hiddenNeurons;
    }

    public HashMap<Integer, Neuron> getOutputNeurons() {
        return outputNeurons;
    }

    public void setOutputNeurons(HashMap<Integer, Neuron> outputNeurons) {
        this.outputNeurons = outputNeurons;
    }

    public HashMap<Integer, Synapse> getInputHiddenSynapses() {
        return inputHiddenSynapses;
    }

    public void setInputHiddenSynapses(HashMap<Integer, Synapse> inputHiddenSynapses) {
        this.inputHiddenSynapses = inputHiddenSynapses;
    }

    public HashMap<Integer, Synapse> getHiddenOutputSynapses() {
        return hiddenOutputSynapses;
    }

    public void setHiddenOutputSynapses(HashMap<Integer, Synapse> hiddenOutputSynapses) {
        this.hiddenOutputSynapses = hiddenOutputSynapses;
    }

    public void prepareNetwork() {
        inputNeuronsArray = new Neuron[neuralNetwork.getInputCount()];
        inputNeuronsArrayIndexMapper = new HashMap<>();
        int index = 0;
        for(Map.Entry<Integer, Neuron> pair : inputNeurons.entrySet()) {
            inputNeuronsArray[index] = pair.getValue();
            inputNeuronsArrayIndexMapper.put(pair.getKey(), index);
            index++;
        }
        hiddenNeuronsArray = new Neuron[neuralNetwork.getHiddenCount()];
        hiddenNeuronsArrayIndexMapper = new HashMap<>();
        index = 0;
        for(Map.Entry<Integer, Neuron> pair : hiddenNeurons.entrySet()) {
            hiddenNeuronsArray[index] = pair.getValue();
            hiddenNeuronsArrayIndexMapper.put(pair.getKey(), index);
            index++;
        }
        outputNeuronsArray = new Neuron[neuralNetwork.getOutputCount()];
        outputNeuronsArrayIndexMapper = new HashMap<>();
        index = 0;
        for(Map.Entry<Integer, Neuron> pair : outputNeurons.entrySet()) {
            outputNeuronsArray[index] = pair.getValue();
            outputNeuronsArrayIndexMapper.put(pair.getKey(), index);
            index++;
        }
        inputHiddenSynapsesArray = new Synapse[neuralNetwork.getInputCount()][neuralNetwork.getHiddenCount()];
        for(Map.Entry<Integer, Synapse> pair : inputHiddenSynapses.entrySet()) {
            int indexIn = inputNeuronsArrayIndexMapper.get(pair.getValue().getNeuronIn().getId());
            int indexOut = hiddenNeuronsArrayIndexMapper.get(pair.getValue().getNeuronOut().getId());
            inputHiddenSynapsesArray[indexIn][indexOut] = pair.getValue();
        }
        hiddenOutputSynapsesArray = new Synapse[neuralNetwork.getHiddenCount()][neuralNetwork.getOutputCount()];
        for(Map.Entry<Integer, Synapse> pair : hiddenOutputSynapses.entrySet()) {
            int indexIn = hiddenNeuronsArrayIndexMapper.get(pair.getValue().getNeuronIn().getId());
            int indexOut = outputNeuronsArrayIndexMapper.get(pair.getValue().getNeuronOut().getId());
            hiddenOutputSynapsesArray[indexIn][indexOut] = pair.getValue();
        }
    }

    public SingleOutputDataDTO processSingleInput(SingleInputDataDTO singleInput) {
        SingleOutputDataDTO result = new SingleOutputDataDTO();
        List<Double> resultData = new ArrayList<>();
        for(int i=0; i<neuralNetwork.getInputCount(); i++) {
            for(int j=0; j<neuralNetwork.getHiddenCount(); j++) {
                inputHiddenSynapsesArray[i][j].setTempValue(
                        singleInput.getData().get(i) * inputHiddenSynapsesArray[i][j].getWeight());
            }
        }
        for(int i=0; i<neuralNetwork.getHiddenCount(); i++) {
            double tempSum = hiddenNeuronsArray[i].getWeight();
            for(int j=0; j<neuralNetwork.getInputCount(); j++) {
                tempSum += inputHiddenSynapsesArray[j][i].getTempValue();
            }
            tempSum = 1.0/(1.0 + Math.exp(-tempSum));
            hiddenNeuronsArray[i].setTempValue(tempSum);
            for(int j=0; j<neuralNetwork.getOutputCount(); j++) {
                hiddenOutputSynapsesArray[i][j].setTempValue(
                        tempSum * hiddenOutputSynapsesArray[i][j].getWeight());
            }
        }
        for(int i=0; i<neuralNetwork.getOutputCount(); i++) {
            double tempSum = outputNeuronsArray[i].getWeight();
            for(int j=0; j<neuralNetwork.getOutputCount(); j++) {
                tempSum += hiddenOutputSynapsesArray[j][i].getTempValue();
            }
            resultData.add(i,1.0/(1.0 + Math.exp(-tempSum)) );
        }
        result.setData(resultData);
        return result;
    }

    public int learnOnInput(LearningDataDTO learningData) {
        prepareNetwork();
        int[][] input = new int[learningData.getData().size()][];
        int[][] targetOutput = new int[learningData.getData().size()][];
        for(int i=0; i<learningData.getData().size(); i++) {
            input[i] = learningData.getData().get(i).getInputData().getData().stream().mapToInt(j->j).toArray();
            targetOutput[i] = learningData.getData().get(i).getOutputData().getData().stream().mapToInt(j->j.intValue()).toArray();
        }
        int result = neuralNetwork.getEpochCount();
        for(int epoch=0; epoch<neuralNetwork.getEpochCount(); epoch++) {
            shuffleLearningData(input, targetOutput);
            double error = 0.0;
            for (int p = 0; p < input.length; p++) {
                SingleInputDataDTO singleInputData = new SingleInputDataDTO();
                List<Integer> inputDataList = new ArrayList<>();
                for (int i = 0; i < input[p].length; i++) {
                    inputDataList.add(input[p][i]);
                }
                singleInputData.setData(inputDataList);
                double[] output = processSingleInput(singleInputData).getData().stream().mapToDouble(j -> j).toArray();
                for (int i = 0; i < neuralNetwork.getOutputCount(); i++) {
                    error += 0.5 * (targetOutput[p][i] - output[i]) * (targetOutput[p][i] - output[i]);
                    outputNeuronsArray[i].setDeltaTempValue((targetOutput[p][i] - output[i]) * output[i] * (1.0 - output[i]));
                }
                double[] sumDeltaOutput = new double[neuralNetwork.getHiddenCount()];
                for (int i = 0; i < neuralNetwork.getHiddenCount(); i++) {
                    sumDeltaOutput[i] = 0.0;
                    for (int j = 0; j < neuralNetwork.getOutputCount(); j++) {
                        sumDeltaOutput[i] += hiddenOutputSynapsesArray[i][j].getWeight() * outputNeuronsArray[j].getDeltaTempValue();
                    }
                    hiddenNeuronsArray[i].setDeltaTempValue(sumDeltaOutput[i] * hiddenNeuronsArray[i].getTempValue() * (1.0 - hiddenNeuronsArray[i].getTempValue()));
                }
                for (int i = 0; i < neuralNetwork.getHiddenCount(); i++) {
                    hiddenNeuronsArray[i].setDeltaInitialWeight(neuralNetwork.getLearningRate() * hiddenNeuronsArray[i].getDeltaTempValue() + neuralNetwork.getMomentum() * hiddenNeuronsArray[i].getDeltaInitialWeight());
                    hiddenNeuronsArray[i].setWeight(hiddenNeuronsArray[i].getWeight() + hiddenNeuronsArray[i].getDeltaInitialWeight());
                    for (int j = 0; j < neuralNetwork.getInputCount(); j++) {
                        inputHiddenSynapsesArray[j][i].setDeltaWeight(neuralNetwork.getLearningRate() * input[p][j] * hiddenNeuronsArray[i].getDeltaTempValue() + neuralNetwork.getMomentum() * inputHiddenSynapsesArray[j][i].getDeltaWeight());
                        inputHiddenSynapsesArray[j][i].setWeight(inputHiddenSynapsesArray[j][i].getWeight() + inputHiddenSynapsesArray[j][i].getDeltaWeight());
                    }
                }
                for (int i = 0; i < neuralNetwork.getOutputCount(); i++) {
                    outputNeuronsArray[i].setDeltaInitialWeight(neuralNetwork.getLearningRate() * outputNeuronsArray[i].getDeltaTempValue() + neuralNetwork.getMomentum() * outputNeuronsArray[i].getDeltaInitialWeight());
                    outputNeuronsArray[i].setWeight(outputNeuronsArray[i].getWeight() + outputNeuronsArray[i].getDeltaInitialWeight());
                    for (int j = 0; j < neuralNetwork.getHiddenCount(); j++) {
                        hiddenOutputSynapsesArray[j][i].setDeltaWeight(neuralNetwork.getLearningRate() * hiddenNeuronsArray[j].getTempValue() * outputNeuronsArray[i].getDeltaTempValue() + neuralNetwork.getMomentum() * hiddenOutputSynapsesArray[j][i].getDeltaWeight());
                        hiddenOutputSynapsesArray[j][i].setWeight(hiddenOutputSynapsesArray[j][i].getWeight() + hiddenOutputSynapsesArray[j][i].getDeltaWeight());
                    }
                }
            }
            if (error < neuralNetwork.getMaxError()) {
                System.out.println(epoch);
                result = epoch;
                break;
            }
        }
        return result;
    }

    public void updateNetwork() {

    }

    // Implementing Fisher-Yates shuffle
    private void shuffleLearningData(int[][] input, int[][] targetOutput) {
        Random rnd = ThreadLocalRandom.current();
        for(int i = input.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            int[] tempInput = input[index];
            int[] tempTargetOutput = targetOutput[index];
            input[index] = input[i];
            targetOutput[index] = targetOutput[i];
            input[i] = tempInput;
            targetOutput[i] = tempTargetOutput;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NeuralNetworkWrapper that = (NeuralNetworkWrapper) o;

        if (!neuralNetwork.equals(that.neuralNetwork)) return false;
        if (!inputNeurons.equals(that.inputNeurons)) return false;
        if (!hiddenNeurons.equals(that.hiddenNeurons)) return false;
        if (!outputNeurons.equals(that.outputNeurons)) return false;
        if (!inputHiddenSynapses.equals(that.inputHiddenSynapses)) return false;
        return hiddenOutputSynapses.equals(that.hiddenOutputSynapses);
    }

    @Override
    public int hashCode() {
        int result = neuralNetwork.hashCode();
        result = 31 * result + inputNeurons.hashCode();
        result = 31 * result + hiddenNeurons.hashCode();
        result = 31 * result + outputNeurons.hashCode();
        result = 31 * result + inputHiddenSynapses.hashCode();
        result = 31 * result + hiddenOutputSynapses.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "NeuralNetworkWrapper{" +
                "neuralNetwork=" + neuralNetwork +
                ", inputNeurons=" + inputNeurons +
                ", hiddenNeurons=" + hiddenNeurons +
                ", outputNeurons=" + outputNeurons +
                ", inputHiddenSynapses=" + inputHiddenSynapses +
                ", hiddenOutputSynapses=" + hiddenOutputSynapses +
                '}';
    }
}
