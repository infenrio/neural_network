package lv.infenrio.core.services.neuralnetwork;

import lv.infenrio.common.dtos.SynapseDTO;
import lv.infenrio.core.domain.Synapse;
import org.springframework.stereotype.Component;

import static lv.infenrio.common.dtos.SynapseDTOBuilder.createSynapseDTO;

@Component
public class SynapseConverter {

    public SynapseDTO convert(Synapse synapse) {
        return createSynapseDTO()
                .withId(synapse.getId())
                .withNeuralNetworkId(synapse.getNeuralNetwork().getId())
                .withNeuronInId(synapse.getNeuronIn().getId())
                .withNeuronOutId(synapse.getNeuronOut().getId())
                .withWeight(synapse.getWeight())
                .withType(synapse.getType()).build();
    }
}
