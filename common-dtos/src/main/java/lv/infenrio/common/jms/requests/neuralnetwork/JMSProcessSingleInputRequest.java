package lv.infenrio.common.jms.requests.neuralnetwork;

import com.fasterxml.jackson.annotation.JsonProperty;
import lv.infenrio.common.dtos.SingleInputDataDTO;
import lv.infenrio.common.jms.SupportedCommandId;
import lv.infenrio.common.jms.requests.JMSAPIRequest;

public class JMSProcessSingleInputRequest implements JMSAPIRequest {

    @JsonProperty("name")
    private String name;

    @JsonProperty("data")
    private SingleInputDataDTO data;

    @Override
    public String getCommandId() {
        return SupportedCommandId.PROCESS_SINGLE_INPUT;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SingleInputDataDTO getData() {
        return data;
    }

    public void setData(SingleInputDataDTO data) {
        this.data = data;
    }
}
