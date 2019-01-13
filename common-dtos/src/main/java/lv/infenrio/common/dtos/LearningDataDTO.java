package lv.infenrio.common.dtos;

import java.util.List;

public class LearningDataDTO {

    private List<SingleLearningDataDTO> data;

    public List<SingleLearningDataDTO> getData() {
        return data;
    }

    public void setData(List<SingleLearningDataDTO> data) {
        this.data = data;
    }
}
