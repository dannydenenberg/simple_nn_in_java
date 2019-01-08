import java.util.ArrayList;

public class Matrix {
    private double[][] mat;

    /**
     * Initialization functions
     */

    public Matrix(double[][] matrix) {
        mat = matrix;
    }

    public static Matrix zeros(Shape s) {
        return new Matrix(fillShapeWithValue(s, 0));
    }

    public static Matrix ones(Shape s) {
        return new Matrix(fillShapeWithValue(s, 1));
    }

    public static Matrix tens(Shape s) {
        return new Matrix(fillShapeWithValue(s, 10));
    }

    public static Matrix fillWithVal(Shape s, double value) {
        return new Matrix(fillShapeWithValue(s, value));
    }

    public static Matrix random(Shape s) {
        double[][] matrix = new double[s.rows][s.cols];

        for (int i = 0; i < s.rows; i++) {
            for (int j = 0; j < s.cols; j++) {
                matrix[i][j] = Math.random();
            }
        }

        return new Matrix(matrix);
    }

    public static double[][] fillShapeWithValue(Shape s, double val) {
        double[][] matrix = new double[s.rows][s.cols];

        for (int i = 0; i < s.rows; i++) {
            for (int j = 0; j < s.cols; j++) {
                matrix[i][j] = val;
            }
        }

        return matrix;
    }

    /***************************************************************************/




    


}
