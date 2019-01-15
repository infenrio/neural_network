package lv.infenrio.app.rest;

import lv.infenrio.app.jms.JMSRequestProcessor;
import lv.infenrio.common.dtos.NeuralNetworkDTO;
import lv.infenrio.common.jms.requests.neuralnetwork.JMSCreateNeuralNetworkRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
@RequestMapping(
        value = "/api",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
)
public class NeuralNetworkRestController {

    @Autowired private JMSRequestProcessor jmsRequestProcessor;


//    @RequestMapping(method = RequestMethod.POST, value="/clients")
@PostMapping("/networks")
    public DeferredResult<ResponseEntity> create(@RequestBody NeuralNetworkDTO neuralNetworkDTO) {
        JMSCreateNeuralNetworkRequest jmsRequest = new JMSCreateNeuralNetworkRequest();
        jmsRequest.setNeuralNetwork(neuralNetworkDTO);
        return jmsRequestProcessor.process(jmsRequest);
    }

//    @GetMapping("/clients/{clientId}")
//    @ResponseBody
//    public DeferredResult<ResponseEntity> get(@PathVariable("clientId") Long clientId) {
//        JMSGetClientRequest jmsRequest = new JMSGetClientRequest();
//        jmsRequest.setClientId(clientId);
//        return jmsRequestProcessor.process(jmsRequest);
//    }

}
