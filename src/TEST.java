public class TEST {
    public static void main(String[] args) {
        Matrix mat = Matrix.random(new Shape(4,3));
        mat.setName("mat");
        mat.show();
        mat.multiplyAndConvertToInts(10);
        mat.show();

        mat.mul(289);

        Matrix other = Matrix.random(new Shape(4,3)).mul(20);
        other.setName("other");

        Matrix newne = Matrix.mul(other, mat);
        newne.setName("newne");
        newne.show();
    }
}
