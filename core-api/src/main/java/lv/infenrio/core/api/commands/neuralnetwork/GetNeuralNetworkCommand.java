package lv.infenrio.core.api.commands.neuralnetwork;

import lv.infenrio.core.api.commands.DomainCommand;

public class GetNeuralNetworkCommand implements DomainCommand<GetNeuralNetworkResult> {

    private String name;

    public GetNeuralNetworkCommand(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
