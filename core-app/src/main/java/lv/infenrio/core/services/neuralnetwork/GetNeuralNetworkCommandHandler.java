package lv.infenrio.core.services.neuralnetwork;

import lv.infenrio.common.dtos.NeuralNetworkWrapperDTO;
import lv.infenrio.core.api.commands.neuralnetwork.GetNeuralNetworkCommand;
import lv.infenrio.core.api.commands.neuralnetwork.GetNeuralNetworkResult;
import lv.infenrio.core.domain.NeuralNetworkWrapper;
import lv.infenrio.core.services.DomainCommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetNeuralNetworkCommandHandler implements DomainCommandHandler<GetNeuralNetworkCommand, GetNeuralNetworkResult> {

    @Autowired NeuralNetworkService neuralNetworkService;
    @Autowired NeuralNetworkWrapperConverter neuralNetworkWrapperConverter;

    @Override
    public GetNeuralNetworkResult execute(GetNeuralNetworkCommand command) {
        NeuralNetworkWrapper neuralNetworkWrapper = neuralNetworkService.get(command.getName());
        NeuralNetworkWrapperDTO neuralNetworkWrapperDTO = neuralNetworkWrapperConverter.convert(neuralNetworkWrapper);
        return new GetNeuralNetworkResult(neuralNetworkWrapperDTO);
    }

    @Override
    public Class getCommandType() {
        return GetNeuralNetworkCommand.class;
    }
}
