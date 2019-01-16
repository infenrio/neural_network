package lv.infenrio.common.jms.requests.neuralnetwork;

import com.fasterxml.jackson.annotation.JsonProperty;
import lv.infenrio.common.dtos.LearningDataDTO;
import lv.infenrio.common.jms.SupportedCommandId;
import lv.infenrio.common.jms.requests.JMSAPIRequest;

public class JMSLearnOnInputRequest implements JMSAPIRequest {

    @JsonProperty("name")
    private String name;

    @JsonProperty("data")
    private LearningDataDTO data;

    @Override
    public String getCommandId() {
        return SupportedCommandId.LEARN_ON_INPUT;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LearningDataDTO getData() {
        return data;
    }

    public void setData(LearningDataDTO data) {
        this.data = data;
    }
}
