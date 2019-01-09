public class TEST {
    public static void main(String[] args) {

    }

    public static void testMatrix() {
        Matrix mat = Matrix.random(new Shape(2,2));
        mat.multiplyAndConvertToInts(5);
        mat.setName("Matrix #1");
        mat.show();


        Matrix mat2 = Matrix.random(new Shape(2,2));
        mat2.multiplyAndConvertToInts(5);
        mat2.setName("Matrix #2");
        mat2.show();

        System.out.println("\n\n\n");

        Matrix matDOtProduct = Matrix.dot(mat, mat2);
        matDOtProduct.setName("DOT PRODUCT");
        matDOtProduct.show();
    }
}
