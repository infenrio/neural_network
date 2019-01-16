package lv.infenrio.core.services.neuralnetwork;

import lv.infenrio.common.dtos.LearningDataDTO;
import lv.infenrio.common.dtos.LearningResultDTO;
import lv.infenrio.common.dtos.SingleInputDataDTO;
import lv.infenrio.common.dtos.SingleOutputDataDTO;
import lv.infenrio.core.api.commands.neuralnetwork.LearnOnInputResult;
import lv.infenrio.core.database.NeuralNetworkRepository;
import lv.infenrio.core.database.NeuronRepository;
import lv.infenrio.core.database.SynapseRepository;
import lv.infenrio.core.domain.NeuralNetwork;
import lv.infenrio.core.domain.NeuralNetworkWrapper;
import lv.infenrio.core.domain.Neuron;
import lv.infenrio.core.domain.Synapse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lv.infenrio.core.domain.builders.NeuralNetworkWrapperBuilder.createNeuralNetworkWrapper;

@Component
public class NeuralNetworkService {

    @Autowired private NeuralNetworkRepository neuralNetworkRepository;
    @Autowired private NeuronRepository neuronRepository;
    @Autowired private SynapseRepository synapseRepository;

    public NeuralNetworkWrapper get(String name) {
        NeuralNetwork neuralNetwork = neuralNetworkRepository.findByName(name).get(0);
        List<Neuron> neurons = neuronRepository.findByNeuralNetwork(neuralNetwork);
        List<Synapse> synapses = synapseRepository.findByNeuralNetwork(neuralNetwork);
        HashMap<Integer, Neuron> inputNeurons = new HashMap<>();
        HashMap<Integer, Neuron> hiddenNeurons = new HashMap<>();
        HashMap<Integer, Neuron> outputNeurons = new HashMap<>();
        HashMap<Integer, Synapse> inputHiddenSynapses = new HashMap<>();
        HashMap<Integer, Synapse> hiddenOutputSynapses = new HashMap<>();
        for(Neuron neuronTemp : neurons) {
            if(neuronTemp.getType().equals("IN")) {
                inputNeurons.put(neuronTemp.getId(), neuronTemp);
            } else if(neuronTemp.getType().equals("HID")) {
                hiddenNeurons.put(neuronTemp.getId(), neuronTemp);
            } else if(neuronTemp.getType().equals("OUT")) {
                outputNeurons.put(neuronTemp.getId(), neuronTemp);
            }
        }
        for(Synapse synapseTemp : synapses) {
            if(synapseTemp.getType().equals("HID")) {
                inputHiddenSynapses.put(synapseTemp.getId(), synapseTemp);
            } else if(synapseTemp.getType().equals("OUT")) {
                hiddenOutputSynapses.put(synapseTemp.getId(), synapseTemp);
            }
        }
        return createNeuralNetworkWrapper()
                .withNeuralNetwork(neuralNetwork)
                .withInputNeurons(inputNeurons)
                .withHiddenNeurons(hiddenNeurons)
                .withOutputNeurons(outputNeurons)
                .withInputHiddenSynapses(inputHiddenSynapses)
                .withHiddenOutputSynapses(hiddenOutputSynapses).build();
    }

    public SingleOutputDataDTO processSingleInput(String name, SingleInputDataDTO singleInput) {
        NeuralNetworkWrapper neuralNetworkWrapper = get(name);
        neuralNetworkWrapper.prepareNetwork();
        return neuralNetworkWrapper.processSingleInput(singleInput);
    }

    public LearningResultDTO learnOnInput(String name, LearningDataDTO learningData) {
        NeuralNetworkWrapper neuralNetworkWrapper = get(name);
        int epoch = neuralNetworkWrapper.learnOnInput(learningData);
        LearningResultDTO learningResult = new LearningResultDTO();
        learningResult.setEpoch(epoch);
        for(Map.Entry<Integer, Neuron> pair : neuralNetworkWrapper.getInputNeurons().entrySet()) {
            neuronRepository.save(pair.getValue());
        }
        for(Map.Entry<Integer, Neuron> pair : neuralNetworkWrapper.getHiddenNeurons().entrySet()) {
            neuronRepository.save(pair.getValue());
        }
        for(Map.Entry<Integer, Neuron> pair : neuralNetworkWrapper.getOutputNeurons().entrySet()) {
            neuronRepository.save(pair.getValue());
        }
        for(Map.Entry<Integer, Synapse> pair : neuralNetworkWrapper.getInputHiddenSynapses().entrySet()) {
            synapseRepository.save(pair.getValue());
        }
        for(Map.Entry<Integer, Synapse> pair : neuralNetworkWrapper.getHiddenOutputSynapses().entrySet()) {
            synapseRepository.save(pair.getValue());
        }
        return learningResult;
    }
}
