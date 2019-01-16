package lv.infenrio.common.jms.requests.neuralnetwork;

import com.fasterxml.jackson.annotation.JsonProperty;
import lv.infenrio.common.dtos.LearningResultDTO;

public class JMSLearnOnInputResponse {

    @JsonProperty("result")
    private LearningResultDTO result;

    public LearningResultDTO getResult() {
        return result;
    }

    public void setResult(LearningResultDTO result) {
        this.result = result;
    }
}
