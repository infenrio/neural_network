package lv.infenrio.common.dtos;

import java.util.List;

public class SingleInputDataDTOBuilder {

    private List<Integer> data;

    private SingleInputDataDTOBuilder() {}

    public static SingleInputDataDTOBuilder createSingleInputDataDTO() {
        return new SingleInputDataDTOBuilder();
    }

    public SingleInputDataDTO build() {
        SingleInputDataDTO inputData = new SingleInputDataDTO();
        inputData.setData(data);
        return inputData;
    }

    public SingleInputDataDTOBuilder withData(List<Integer> data) {
        this.data = data;
        return this;
    }
}
