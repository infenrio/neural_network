package lv.infenrio.core.services.neuralnetwork;

import lv.infenrio.common.dtos.NeuralNetworkDTO;
import lv.infenrio.core.api.commands.neuralnetwork.CreateNeuralNetworkCommand;
import lv.infenrio.core.api.commands.neuralnetwork.CreateNeuralNetworkResult;
import lv.infenrio.core.domain.NeuralNetwork;
import lv.infenrio.core.services.DomainCommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateNeuralNetworkCommandHandler implements DomainCommandHandler<CreateNeuralNetworkCommand, CreateNeuralNetworkResult> {

    @Autowired private NeuralNetworkFactory neuralNetworkFactory;
    @Autowired private NeuralNetworkConverter neuralNetworkConverter;

    @Override
    public CreateNeuralNetworkResult execute(CreateNeuralNetworkCommand command) {
        NeuralNetwork neuralNetwork = neuralNetworkFactory.create(
                command.getName(),
                command.getEpochCount(),
                command.getMaxError(),
                command.getLearningRate(),
                command.getMomentum(),
                command.getInputCount(),
                command.getHiddenCount(),
                command.getOutputCount()
        );
        NeuralNetworkDTO neuralNetworkDTO = neuralNetworkConverter.convert(neuralNetwork);
        return new CreateNeuralNetworkResult(neuralNetworkDTO);
    }

    @Override
    public Class getCommandType() {
        return CreateNeuralNetworkCommand.class;
    }
}
