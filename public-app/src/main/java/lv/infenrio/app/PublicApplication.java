package lv.infenrio.app;

import lv.infenrio.common.dtos.NeuralNetworkDTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Scanner;

import static lv.infenrio.common.dtos.NeuralNetworkDTOBuilder.createNeuralNetworkDTO;

@SpringBootApplication
@ComponentScan(basePackages = {"lv.infenrio.app"})
public class PublicApplication {//implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(PublicApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Name:");
//        String name = sc.nextLine();
//        System.out.println("epochCount:");
//        int epochCount = Integer.parseInt(sc.nextLine());
//        System.out.println("maxError:");
//        double maxError = Double.parseDouble(sc.nextLine());
//        System.out.println("learningRate:");
//        double learningRate = Double.parseDouble(sc.nextLine());
//        System.out.println("momentum:");
//        double momentum = Double.parseDouble(sc.nextLine());
//        System.out.println("inputCount:");
//        int inputCount = Integer.parseInt(sc.nextLine());
//        System.out.println("hiddenCount:");
//        int hiddenCount = Integer.parseInt(sc.nextLine());
//        System.out.println("outputCount:");
//        int outputCount = Integer.parseInt(sc.nextLine());
//        NeuralNetworkDTO neuralNetwork = createNeuralNetworkDTO().withName(name)
//                .withEpochCount(epochCount)
//                .withMaxError(maxError)
//                .withLearningRate(learningRate)
//                .withMomentum(momentum)
//                .withInputCount(inputCount)
//                .withHiddenCount(hiddenCount)
//                .withOutputCount(outputCount).build();
//    }
}
