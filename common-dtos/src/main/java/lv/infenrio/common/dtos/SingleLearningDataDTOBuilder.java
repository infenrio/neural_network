package lv.infenrio.common.dtos;

public class SingleLearningDataDTOBuilder {

    private SingleInputDataDTO inputData;
    private SingleOutputDataDTO outputData;

    private SingleLearningDataDTOBuilder() {}

    public static SingleLearningDataDTOBuilder createSingleLearningDataDTO() {
        return new SingleLearningDataDTOBuilder();
    }

    public SingleLearningDataDTO build() {
        SingleLearningDataDTO singleLearningData = new SingleLearningDataDTO();
        singleLearningData.setInputData(inputData);
        singleLearningData.setOutputData(outputData);
        return singleLearningData;
    }

    public SingleLearningDataDTOBuilder withInputData(SingleInputDataDTO inputData) {
        this.inputData = inputData;
        return this;
    }

    public SingleLearningDataDTOBuilder withOutputData(SingleOutputDataDTO outputData) {
        this.outputData = outputData;
        return this;
    }
}
