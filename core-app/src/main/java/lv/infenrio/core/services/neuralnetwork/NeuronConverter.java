package lv.infenrio.core.services.neuralnetwork;

import lv.infenrio.common.dtos.NeuronDTO;
import lv.infenrio.core.domain.Neuron;
import org.springframework.stereotype.Component;

import static lv.infenrio.common.dtos.NeuronDTOBuilder.createNeuronDTO;

@Component
public class NeuronConverter {

    public NeuronDTO convert(Neuron neuron) {
        return createNeuronDTO()
                .withId(neuron.getId())
                .withNeuralNetworkId(neuron.getNeuralNetwork().getId())
                .withWeight(neuron.getWeight())
                .withType(neuron.getType()).build();
    }
}
