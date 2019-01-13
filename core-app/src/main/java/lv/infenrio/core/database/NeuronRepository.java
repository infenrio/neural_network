package lv.infenrio.core.database;

import lv.infenrio.core.domain.NeuralNetwork;
import lv.infenrio.core.domain.Neuron;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NeuronRepository extends JpaRepository<Neuron, Long> {
    List<Neuron> findByNeuralNetwork(NeuralNetwork neuralNetwork);
}
