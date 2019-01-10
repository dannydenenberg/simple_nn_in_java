/**
 * @author Daniel Denenberg
 * @date January 8, 2019
 * This class represents a single layer in a neural network.
 * Think of it as just a function: it takes inputs and produces outputs (activations).
 * ---------
 * To feed-forward one should be able to chain the layers together with the previous layer's outputs being
 * the new layer's inputs.
 */
public class Layer {
    // some properties of a layer are the number of numberOfNeurons it has, the weights it has, and the number of inputs it takes
    private int inputNeuronsNumber;
    private int numberOfNeurons;
    private Matrix weights;
    private double bias;

    private String activationFunctionName;

    /**
     * Set instance data.
     * @param numInputNeurons
     * @param numNeurons
     */
    public Layer(int numInputNeurons, int numNeurons) {
        this.inputNeuronsNumber = numInputNeurons;
        this.numberOfNeurons = numNeurons;

        this.activationFunctionName = "sigmoid";

        // the dimensions of the weight matrix is the number of rows in
        // the inputs by the number of rows in the current layer (this)
        Shape weightsShape = new Shape(inputNeuronsNumber, numberOfNeurons);

        // create a randomly initialized matrix of the correct shape
        weights = Matrix.random(weightsShape);

        // randomly initialize the bias
        bias = Math.random();
    }

    /**
     * Same as the first constructor, but allows you to specify the activationFunctionName
     * @param numInputNeurons
     * @param numNeurons
     * @param activationFunctionName
     */
    public Layer(int numInputNeurons, int numNeurons, String activationFunctionName) {
        this.inputNeuronsNumber = numInputNeurons;
        this.numberOfNeurons = numNeurons;

        this.activationFunctionName = activationFunctionName;

        // the dimensions of the weight matrix is the number of rows in
        // the inputs by the number of rows in the current layer (this)
        Shape weightsShape = new Shape(inputNeuronsNumber, numberOfNeurons);

        // create a randomly initialized matrix of the correct shape
        weights = Matrix.random(weightsShape);
    }


    /**
     * Feeds the inputs through this layer. Produced the activated values of this layer.
     * @param inputs => this parameter is an array with shape (1, numberOfInputNeurons)
     * @return
     */
    public Matrix feedforward(Matrix inputs) {
        // the layer is represented as a vector of values
        Matrix activatedOuputs = Matrix.ones(new Shape(numberOfNeurons, 1));


        // TODO:
        /*
        1. Multiply inputs and weights into a vector.
        2. BIASES!!!!!!!!!!!!!!
        3. Activate the vector.
         */

        // multiply the inputs and weights into a matrix holding the unbias, un-activated values of the neurons
        Matrix inputsByWeights = Matrix.dot(inputs, weights);

        // add the bias to each element
        inputsByWeights.add(bias);

        // activate each element in the matrix
        inputsByWeights.applyActivationToEachElement(activationFunctionName);

        // return the activated array
        return Matrix.transpose(inputsByWeights);
    }
}
