package lv.infenrio.app.rest;

import lv.infenrio.app.jms.JMSRequestProcessor;
import lv.infenrio.common.dtos.*;
import lv.infenrio.common.jms.requests.neuralnetwork.JMSCreateNeuralNetworkRequest;
import lv.infenrio.common.jms.requests.neuralnetwork.JMSLearnOnInputRequest;
import lv.infenrio.common.jms.requests.neuralnetwork.JMSProcessSingleInputRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
@RequestMapping(
        value = "/api",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
)
public class NeuralNetworkRestController {

    @Autowired private JMSRequestProcessor jmsRequestProcessor;

    @PostMapping("/networks")
    public DeferredResult<ResponseEntity> create(@RequestBody NeuralNetworkDTO neuralNetworkDTO) {
        JMSCreateNeuralNetworkRequest jmsRequest = new JMSCreateNeuralNetworkRequest();
        jmsRequest.setNeuralNetwork(neuralNetworkDTO);
        return jmsRequestProcessor.process(jmsRequest);
    }

    @PostMapping("/ask/{name}")
    public DeferredResult<ResponseEntity> process(@PathVariable("name") String name, @RequestBody SingleInputDataDTO inputData) {
        JMSProcessSingleInputRequest jmsRequest = new JMSProcessSingleInputRequest();
        jmsRequest.setName(name);
        jmsRequest.setData(inputData);
        return jmsRequestProcessor.process(jmsRequest);
    }

    @PostMapping("/learn/{name}")
    public DeferredResult<ResponseEntity> learn(@PathVariable("name") String name, @RequestBody LearningDataDTO data) {
        JMSLearnOnInputRequest jmsRequest = new JMSLearnOnInputRequest();
        jmsRequest.setName(name);
        jmsRequest.setData(data);
        return jmsRequestProcessor.process(jmsRequest);
    }

}
