package lv.infenrio.core.database;

import lv.infenrio.core.domain.NeuralNetwork;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NeuralNetworkRepository extends JpaRepository<NeuralNetwork, Long> {
    List<NeuralNetwork> findByName(String name);
}
