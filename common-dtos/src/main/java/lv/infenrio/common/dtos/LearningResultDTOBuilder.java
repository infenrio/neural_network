package lv.infenrio.common.dtos;

public class LearningResultDTOBuilder {

    private int epoch;

    private LearningResultDTOBuilder() {}

    public static LearningResultDTOBuilder createLearningResultDTO() {
        return new LearningResultDTOBuilder();
    }

    public LearningResultDTO build() {
        LearningResultDTO result = new LearningResultDTO();
        result.setEpoch(epoch);
        return result;
    }

    public LearningResultDTOBuilder withEpoch(int epoch) {
        this.epoch = epoch;
        return this;
    }
}
