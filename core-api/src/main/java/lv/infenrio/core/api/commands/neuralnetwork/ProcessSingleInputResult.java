package lv.infenrio.core.api.commands.neuralnetwork;

import lv.infenrio.common.dtos.SingleOutputDataDTO;
import lv.infenrio.core.api.commands.DomainCommandResult;

public class ProcessSingleInputResult implements DomainCommandResult {

    private SingleOutputDataDTO singleOutput;

    public ProcessSingleInputResult(SingleOutputDataDTO singleOutput) {
        this.singleOutput = singleOutput;
    }

    public SingleOutputDataDTO getSingleOutput() {
        return singleOutput;
    }
}
