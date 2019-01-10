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

    /**
     * Initialize the network with  a list of the number of neurons in each layer.
     * layers[0] should be the inputs, and layer[layer.length - 1] should be the outputs
     * @param layers
     */
    public void NeuralNetwork(int ...layers) {
        for (int i = 1; i < layers.length; i++) {
            this.layers.add(new Layer(layers[i - 1], layers[i]));
        }
    }

    /**
     * Initialize the network with  a list of the number of neurons in each layer and specify the activation functions for each layer.
     * layers[0] should be the inputs, and layer[layer.length - 1] should be the outputs
     * @param layers
     */
    public void NeuralNetwork(String[] activationFunctions, int ...layers) {
        for (int i = 1; i < layers.length; i++) {
            this.layers.add(new Layer(layers[i - 1], layers[i], activationFunctions[i - 1]));
        }
    }

    /**
     * Add a layer onto the end of the network.
     * @param inputs
     * @param neurons
     * @param activationFunctionName
     */
    public void add(int inputs, int neurons, String activationFunctionName) {
        layers.add(new Layer(inputs, neurons, activationFunctionName));
    }

    /**
     * Add a layer onto the end of the network. Don't specify the activation function.
     * @param inputs
     * @param neurons
     */
    public void add(int inputs, int neurons) {
        layers.add(new Layer(inputs, neurons));
    }


    /**
     * Feed the inputs through the network.
     * @param inputs
     * @return
     */
    public Matrix feedforward(Matrix inputs, int index) {
        // TODO: FIX

        return feedforward(layers.get(index).feedforward(inputs), index+1);

    }

}
