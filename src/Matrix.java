import java.util.ArrayList;

public class Matrix {
    private double[][] mat;

    /**
     * Convert the class to an array by returning the private matrix.
     * @return
     */
    public double[][] toArray() {
        return mat;
    }

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


    public void mul(double scalar) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] *= scalar;
            }
        }
    }

    public void add(double scalar) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] += scalar;
            }
        }
    }

    public void sub(double scalar) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] -= scalar;
            }
        }
    }

    public void div(double scalar) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] /= scalar;
            }
        }
    }


    /**
     * Now, element wise operations.
     */


    /**
     * Return a new array that is the element wise multiplication of the two input Matrices.
     * @param matrix
     * @param matrixOther
     * @return
     */
    public static Matrix mul(Matrix matrix, Matrix matrixOther) {
        double[][] mat = matrixOther.toArray();
        double[][] otherArray = matrix.toArray();

        double[][] newMatrix = new double[mat.length][mat[0].length];


        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                newMatrix[i][j] = mat[i][j] * otherArray[i][j];
            }
        }

        return new Matrix(newMatrix);
    }


}
