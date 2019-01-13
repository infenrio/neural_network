package lv.infenrio.core.services.neuralnetwork;

import lv.infenrio.core.database.NeuralNetworkRepository;
import lv.infenrio.core.database.NeuronRepository;
import lv.infenrio.core.database.SynapseRepository;
import lv.infenrio.core.domain.NeuralNetwork;
import lv.infenrio.core.domain.Neuron;
import lv.infenrio.core.domain.Synapse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Random;

import static lv.infenrio.core.domain.builders.NeuralNetworkBuilder.createNeuralNetwork;
import static lv.infenrio.core.domain.builders.NeuronBuilder.createNeuron;
import static lv.infenrio.core.domain.builders.SynapseBuilder.createSynapse;

@Component
public class NeuralNetworkFactory {

    @Autowired private NeuralNetworkRepository neuralNetworkRepository;
    @Autowired private NeuronRepository neuronRepository;
    @Autowired private SynapseRepository synapseRepository;

    public NeuralNetwork create(String name, int epochCount, double maxError,
                                double learningRate, double momentum,
                                int inputCount, int hiddenCount,
                                int outputCount) {
        NeuralNetwork neuralNetwork = createNeuralNetwork()
                .withName(name)
                .withEpochCount(epochCount)
                .withMaxError(maxError)
                .withLearningRate(learningRate)
                .withMomentum(momentum)
                .withInputCount(inputCount)
                .withHiddenCount(hiddenCount)
                .withOutputCount(outputCount).build();
        NeuralNetwork result = neuralNetworkRepository.save(neuralNetwork);
        Neuron neuronTemp;
        Random random = new Random();
        HashMap<Integer, Neuron> inputNeurons = new HashMap();
        for(int i=0; i<inputCount; i++) {
            neuronTemp = createNeuron()
                    .withNeuralNetwork(result)
                    .withWeight(0)
                    .withType("IN").build();
            neuronTemp = neuronRepository.save(neuronTemp);
            inputNeurons.put(neuronTemp.getId(), neuronTemp);
        }
        HashMap<Integer, Neuron> hiddenNeurons = new HashMap();
        for(int i=0; i<hiddenCount; i++) {
            neuronTemp = createNeuron()
                    .withNeuralNetwork(result)
                    .withWeight(random.nextDouble() - 0.5)
                    .withType("HID").build();
            neuronTemp = neuronRepository.save(neuronTemp);
            hiddenNeurons.put(i, neuronTemp);
        }
        HashMap<Integer, Neuron> outputNeurons = new HashMap();
        for(int i=0; i<outputCount; i++) {
            neuronTemp = createNeuron()
                    .withNeuralNetwork(result)
                    .withWeight(random.nextDouble() - 0.5)
                    .withType("OUT").build();
            neuronTemp = neuronRepository.save(neuronTemp);
            outputNeurons.put(neuronTemp.getId(), neuronTemp);
        }
        Synapse synapseTemp;
        for(int i=0; i<inputCount; i++) {
            for(int j=0; j<hiddenCount; j++) {
                synapseTemp = createSynapse()
                        .withNeuralNetwork(result)
                        .withNeuronIn(inputNeurons.get(i))
                        .withNeuronOut(hiddenNeurons.get(j))
                        .withWeight(random.nextDouble() - 0.5)
                        .withType("HID").build();
                synapseTemp = synapseRepository.save(synapseTemp);
            }
        }
        for(int i=0; i<hiddenCount; i++) {
            for(int j=0; j<outputCount; j++) {
                synapseTemp = createSynapse()
                        .withNeuralNetwork(result)
                        .withNeuronIn(hiddenNeurons.get(i))
                        .withNeuronOut(outputNeurons.get(j))
                        .withWeight(random.nextDouble() - 0.5)
                        .withType("OUT").build();
                synapseTemp = synapseRepository.save(synapseTemp);
            }
        }
        return result;
    }
}
