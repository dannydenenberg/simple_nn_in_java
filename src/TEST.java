public class TEST {
    public static void main(String[] args) {
        NeuralNetwork nn = new NeuralNetwork();
        nn.add(2, 7, "sigmoid");
        nn.add(7, 1, "sigmoid");

       // nn.feedforward(Matrix.random(new Shape(1, 2))).show();

        Layer l = new Layer(2,7);
        l.feedforward(Matrix.random(new Shape(2,1))).show();



    }
}
