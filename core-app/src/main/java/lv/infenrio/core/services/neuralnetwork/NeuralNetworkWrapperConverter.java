package lv.infenrio.core.services.neuralnetwork;

import lv.infenrio.common.dtos.NeuralNetworkWrapperDTO;
import lv.infenrio.common.dtos.NeuronDTO;
import lv.infenrio.common.dtos.SynapseDTO;
import lv.infenrio.core.domain.NeuralNetworkWrapper;
import lv.infenrio.core.domain.Neuron;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static lv.infenrio.common.dtos.NeuralNetworkWrapperDTOBuilder.createNeuralNetworkWrapperDTO;

@Component
public class NeuralNetworkWrapperConverter {

    @Autowired NeuralNetworkConverter neuralNetworkConverter;
    @Autowired NeuronConverter neuronConverter;
    @Autowired SynapseConverter synapseConverter;

    public NeuralNetworkWrapperDTO convert(NeuralNetworkWrapper neuralNetworkWrapper) {
        HashMap<Integer, NeuronDTO> inputNeurons = new HashMap<>();
        HashMap<Integer, NeuronDTO> hiddenNeurons = new HashMap<>();
        HashMap<Integer, NeuronDTO> outputNeurons = new HashMap<>();
        HashMap<Integer, SynapseDTO> inputHiddenSynapses = new HashMap<>();
        HashMap<Integer, SynapseDTO> hiddenOutputSynapses = new HashMap<>();
        neuralNetworkWrapper.getInputNeurons().forEach((k, v) -> inputNeurons.put(k, neuronConverter.convert(v)));
        neuralNetworkWrapper.getHiddenNeurons().forEach((k, v) -> hiddenNeurons.put(k, neuronConverter.convert(v)));
        neuralNetworkWrapper.getOutputNeurons().forEach((k, v) -> outputNeurons.put(k, neuronConverter.convert(v)));
        neuralNetworkWrapper.getInputHiddenSynapses().forEach((k, v) -> inputHiddenSynapses.put(k, synapseConverter.convert(v)));
        neuralNetworkWrapper.getHiddenOutputSynapses().forEach((k, v) -> hiddenOutputSynapses.put(k, synapseConverter.convert(v)));

        return createNeuralNetworkWrapperDTO()
                .withNeuralNetwork(neuralNetworkConverter.convert(neuralNetworkWrapper.getNeuralNetwork()))
                .withInputNeurons(inputNeurons)
                .withHiddenNeurons(hiddenNeurons)
                .withOutputNeurons(outputNeurons)
                .withInputHiddenSynapses(inputHiddenSynapses)
                .withHiddenOutputSynapses(hiddenOutputSynapses)
                .build();

    }
}
