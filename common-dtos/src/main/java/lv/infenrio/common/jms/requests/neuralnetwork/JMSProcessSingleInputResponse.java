package lv.infenrio.common.jms.requests.neuralnetwork;

import com.fasterxml.jackson.annotation.JsonProperty;
import lv.infenrio.common.dtos.SingleOutputDataDTO;

public class JMSProcessSingleInputResponse {

    @JsonProperty("data")
    private SingleOutputDataDTO data;

    public SingleOutputDataDTO getData() {
        return data;
    }

    public void setData(SingleOutputDataDTO data) {
        this.data = data;
    }
}
