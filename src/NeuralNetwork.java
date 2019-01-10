import java.util.ArrayList;
import java.util.List;

/**
 * Represents an entire neural network.
 */
public class NeuralNetwork {
    private List<Layer> layers;

    public NeuralNetwork() {
        layers = new ArrayList<>();
    }

    public void newLayer(int inputs, int neurons) {
        layers.add(new Layer(inputs, neurons));
    }

    public void newLayer(int inputs, int neurons, String activationFunctionName) {
        layers.add(new Layer(inputs, neurons, activationFunctionName));
    }

    // add constructor where you can
    // input the number of neurons in each layer and
    // it will create the layer list for you
}
