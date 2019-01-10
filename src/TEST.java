public class TEST {
    public static void main(String[] args) {
        Matrix m = Matrix.random(new Shape(1, 2));
        Layer l = new Layer(m.getShape().cols, 3);


        Matrix output = l.feedforward(m);
        output.setName("OUTPUT");
        output.show();


    }
}
