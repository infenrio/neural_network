package lv.infenrio.core.api.commands.neuralnetwork;

import lv.infenrio.common.dtos.LearningDataDTO;
import lv.infenrio.core.api.commands.DomainCommand;

public class LearnOnInputCommand implements DomainCommand<LearnOnInputResult> {

    private String name;
    private LearningDataDTO data;

    public LearnOnInputCommand(String name, LearningDataDTO data) {
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public LearningDataDTO getData() {
        return data;
    }
}
