package lv.infenrio.core.rest;

import lv.infenrio.common.dtos.NeuralNetworkDTO;
import lv.infenrio.core.api.CommandExecutor;
import lv.infenrio.core.api.commands.neuralnetwork.CreateNeuralNetworkCommand;
import lv.infenrio.core.api.commands.neuralnetwork.CreateNeuralNetworkResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(
        value = "/api",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
)
public class NeuralNetworkRestController {
    private CommandExecutor commandExecutor;

    @Autowired
    public NeuralNetworkRestController(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    @RequestMapping(method = RequestMethod.POST, value="/clients")
    @ResponseBody
    public NeuralNetworkDTO create(NeuralNetworkDTO neuralNetworkDTO) {
        CreateNeuralNetworkCommand command = new CreateNeuralNetworkCommand(
                neuralNetworkDTO.getName(),
                neuralNetworkDTO.getEpochCount(),
                neuralNetworkDTO.getMaxError(),
                neuralNetworkDTO.getLearningRate(),
                neuralNetworkDTO.getMomentum(),
                neuralNetworkDTO.getInputCount(),
                neuralNetworkDTO.getHiddenCount(),
                neuralNetworkDTO.getOutputCount()
        );
        CreateNeuralNetworkResult result = commandExecutor.execute(command);
        return result.getNeuralNetwork();
    }

//    @GetMapping("/clients/{clientId}")
//    @ResponseBody
//    public ClientDTO get(@PathVariable("clientId") Long clientId) {
//        GetClientCommand command = new GetClientCommand(clientId);
//        GetClientResult result = commandExecutor.execute(command);
//        return result.getClient();
//    }
}
