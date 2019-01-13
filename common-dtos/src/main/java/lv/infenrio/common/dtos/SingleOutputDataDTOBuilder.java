package lv.infenrio.common.dtos;

import java.util.List;

public class SingleOutputDataDTOBuilder {

    private List<Double> data;

    private SingleOutputDataDTOBuilder() {}

    public static SingleOutputDataDTOBuilder createSingleOutputDataDTO() {
        return new SingleOutputDataDTOBuilder();
    }

    public SingleOutputDataDTO build() {
        SingleOutputDataDTO outputData = new SingleOutputDataDTO();
        outputData.setData(data);
        return outputData;
    }

    public SingleOutputDataDTOBuilder withData(List<Double> data) {
        this.data = data;
        return this;
    }
}
