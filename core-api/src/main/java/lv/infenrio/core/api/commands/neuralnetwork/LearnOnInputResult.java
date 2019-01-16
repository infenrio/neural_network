package lv.infenrio.core.api.commands.neuralnetwork;

import lv.infenrio.common.dtos.LearningResultDTO;
import lv.infenrio.core.api.commands.DomainCommandResult;

public class LearnOnInputResult implements DomainCommandResult {

    private LearningResultDTO result;

    public LearnOnInputResult(LearningResultDTO result) {
        this.result = result;
    }

    public LearningResultDTO getResult() {
        return result;
    }
}
