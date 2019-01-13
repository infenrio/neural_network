package lv.infenrio.common.dtos;

import java.util.List;

public class LearningDataDTOBuilder {

    private List<SingleLearningDataDTO> data;

    private LearningDataDTOBuilder() {}

    public static LearningDataDTOBuilder createLearningDataDTO() {
        return new LearningDataDTOBuilder();
    }

    public LearningDataDTO build() {
        LearningDataDTO learningData = new LearningDataDTO();
        learningData.setData(data);
        return learningData;
    }

    public LearningDataDTOBuilder withData(List<SingleLearningDataDTO> data) {
        this.data = data;
        return this;
    }
}
