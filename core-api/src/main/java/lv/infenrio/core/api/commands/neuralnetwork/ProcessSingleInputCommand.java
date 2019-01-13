package lv.infenrio.core.api.commands.neuralnetwork;

import lv.infenrio.common.dtos.SingleInputDataDTO;
import lv.infenrio.core.api.commands.DomainCommand;

public class ProcessSingleInputCommand implements DomainCommand<ProcessSingleInputResult> {

    private String name;
    private SingleInputDataDTO singleInput;

    public ProcessSingleInputCommand(String name, SingleInputDataDTO singleInput) {
        this.name = name;
        this.singleInput = singleInput;
    }

    public String getName() {
        return name;
    }

    public SingleInputDataDTO getSingleInput() {
        return singleInput;
    }
}
