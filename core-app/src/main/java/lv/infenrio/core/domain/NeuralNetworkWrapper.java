package lv.infenrio.core.domain;

import lv.infenrio.common.dtos.SingleInputDataDTO;
import lv.infenrio.common.dtos.SingleOutputDataDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
