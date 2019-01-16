package lv.infenrio.core.services.neuralnetwork;

import lv.infenrio.common.dtos.LearningResultDTO;
import lv.infenrio.core.api.commands.neuralnetwork.LearnOnInputCommand;
import lv.infenrio.core.api.commands.neuralnetwork.LearnOnInputResult;
import lv.infenrio.core.services.DomainCommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LearnOnInputCommandHandler implements DomainCommandHandler<LearnOnInputCommand, LearnOnInputResult> {

    @Autowired
    NeuralNetworkService neuralNetworkService;

    @Override
    public LearnOnInputResult execute(LearnOnInputCommand command) {
        LearningResultDTO result = neuralNetworkService.learnOnInput(command.getName(), command.getData());
        return new LearnOnInputResult(result);
    }

    @Override
    public Class getCommandType() {
        return LearnOnInputCommand.class;
    }
}
