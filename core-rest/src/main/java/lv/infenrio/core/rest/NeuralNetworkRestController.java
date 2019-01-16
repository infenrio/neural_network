package lv.infenrio.core.rest;

import lv.infenrio.common.dtos.*;
import lv.infenrio.core.api.CommandExecutor;
import lv.infenrio.core.api.commands.neuralnetwork.*;
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

    @PostMapping("/networks")
    public NeuralNetworkDTO create(@RequestBody NeuralNetworkDTO neuralNetworkDTO) {
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

    @PostMapping("/ask/{name}")
    public SingleOutputDataDTO process(@PathVariable("name") String name, @RequestBody SingleInputDataDTO inputData) {
        ProcessSingleInputCommand command = new ProcessSingleInputCommand(
                name,
                inputData
        );
        ProcessSingleInputResult result = commandExecutor.execute(command);
        return result.getSingleOutput();
    }

    @PostMapping("/learn/{name}")
    public LearningResultDTO learn(@PathVariable("name") String name, @RequestBody LearningDataDTO data) {
        LearnOnInputCommand command = new LearnOnInputCommand(
                name,
                data
        );
        LearnOnInputResult result = commandExecutor.execute(command);
        return result.getResult();
    }
}
