package lv.infenrio.core.database;

import lv.infenrio.core.domain.NeuralNetwork;
import lv.infenrio.core.domain.Synapse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SynapseRepository extends JpaRepository<Synapse, Long> {
    List<Synapse> findByNeuralNetwork(NeuralNetwork neuralNetwork);
}
