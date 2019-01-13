package lv.infenrio.common.dtos;

public class SingleLearningDataDTO {

    private SingleInputDataDTO inputData;
    private SingleOutputDataDTO outputData;

    public SingleInputDataDTO getInputData() {
        return inputData;
    }

    public void setInputData(SingleInputDataDTO inputData) {
        this.inputData = inputData;
    }

    public SingleOutputDataDTO getOutputData() {
        return outputData;
    }

    public void setOutputData(SingleOutputDataDTO outputData) {
        this.outputData = outputData;
    }
}
