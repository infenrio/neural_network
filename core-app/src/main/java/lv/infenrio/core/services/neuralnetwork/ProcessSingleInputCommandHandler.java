package lv.infenrio.core.services.neuralnetwork;

import lv.infenrio.common.dtos.SingleOutputDataDTO;
import lv.infenrio.core.api.commands.neuralnetwork.ProcessSingleInputCommand;
import lv.infenrio.core.api.commands.neuralnetwork.ProcessSingleInputResult;
import lv.infenrio.core.services.DomainCommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessSingleInputCommandHandler implements DomainCommandHandler<ProcessSingleInputCommand, ProcessSingleInputResult> {

    @Autowired NeuralNetworkService neuralNetworkService;

    @Override
    public ProcessSingleInputResult execute(ProcessSingleInputCommand command) {
        SingleOutputDataDTO singleOutput = neuralNetworkService.processSingleInput(command.getName(), command.getSingleInput());
        return new ProcessSingleInputResult(singleOutput);
    }

    @Override
    public Class getCommandType() {
        return ProcessSingleInputCommand.class;
    }
}
