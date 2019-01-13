package lv.infenrio.core.services.neuralnetwork;

import lv.infenrio.common.dtos.NeuralNetworkDTO;
import lv.infenrio.core.domain.NeuralNetwork;
import org.springframework.stereotype.Component;

import static lv.infenrio.common.dtos.NeuralNetworkDTOBuilder.createNeuralNetworkDTO;

@Component
public class NeuralNetworkConverter {

    public NeuralNetworkDTO convert(NeuralNetwork neuralNetwork) {
        return createNeuralNetworkDTO()
                .withId(neuralNetwork.getId())
                .withName(neuralNetwork.getName())
                .withEpochCount(neuralNetwork.getEpochCount())
                .withMaxError(neuralNetwork.getMaxError())
                .withLearningRate(neuralNetwork.getLearningRate())
                .withMomentum(neuralNetwork.getMomentum())
                .withInputCount(neuralNetwork.getInputCount())
                .withHiddenCount(neuralNetwork.getHiddenCount())
                .withOutputCount(neuralNetwork.getOutputCount()).build();
    }
}
