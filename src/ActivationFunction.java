/**
 * Represents the activation function used in our NN. This way, we can use activation functions within the matrix library.
 */
public class ActivationFunction {
    private String name;

    public ActivationFunction(String name) {
        this.name = name;
    }

    /**
     * A function which returns the appropriate activation function on an integer based on the
     * value of this.activationFunctionName.
     * @param number
     * @return
     */
    public double activate(double number) {
        if (name.equals("sigmoid")) {
            return sigmoid(number);
        } else if (name.equals("relu")) {
            return relu(number);
        }

        throw new java.lang.RuntimeException("Error: Unknown activation function. IN CLASS: LAYER.");
    }

    /**
     * The sigmoid activation function.
     * @param x
     * @return
     */
    private double sigmoid(double x) {
        return 1 / (1 + Math.exp(-x));
    }

    /**
     * The Relu activation function. Used withing the function `activation(double number)`
     * @param x
     * @return
     */
    private double relu(double x) {
        return Math.max(x, 0);
    }
}
