import java.util.ArrayList;

public class Matrix {
    private double[][] mat;
    private String name;

    /**
     * Convert the class to an array by returning the private matrix.
     * @return
     */
    public double[][] toArray() {
        return mat;
    }

    public Shape getShape() {
        return new Shape(mat.length, mat[0].length);
    }

    public void setName(String s) {
        this.name = s;
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

    public void multiplyAndConvertToInts(double scalar) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] = Math.round(mat[i][j] * scalar);
            }
        }
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

    /**
     * Here are the simple matrix with scalar operations.
     * Each function returns the matrix for ease of initialization.
     EX:
        Matrix mat = Matrix.random(new Shape(3,4)).mul(10); // random values from 0 to 10
     * @param scalar
     * @return
     */

    public Matrix mul(double scalar) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] *= scalar;
            }
        }
        return this;
    }

    public Matrix add(double scalar) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] += scalar;
            }
        }
        return this;
    }

    public Matrix sub(double scalar) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] -= scalar;
            }
        }
        return this;
    }

    public Matrix div(double scalar) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] /= scalar;
            }
        }
        return this;
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


    public static Matrix add(Matrix matrix, Matrix matrixOther) {
        double[][] mat = matrixOther.toArray();
        double[][] otherArray = matrix.toArray();

        double[][] newMatrix = new double[mat.length][mat[0].length];


        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                newMatrix[i][j] = mat[i][j] + otherArray[i][j];
            }
        }

        return new Matrix(newMatrix);
    }


    public static Matrix sub(Matrix matrix, Matrix matrixOther) {
        double[][] mat = matrixOther.toArray();
        double[][] otherArray = matrix.toArray();

        double[][] newMatrix = new double[mat.length][mat[0].length];


        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                newMatrix[i][j] = mat[i][j] - otherArray[i][j];
            }
        }

        return new Matrix(newMatrix);
    }

    public static Matrix div(Matrix matrix, Matrix matrixOther) {
        double[][] mat = matrixOther.toArray();
        double[][] otherArray = matrix.toArray();

        double[][] newMatrix = new double[mat.length][mat[0].length];


        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                newMatrix[i][j] = mat[i][j] / otherArray[i][j];
            }
        }

        return new Matrix(newMatrix);
    }


    /**
     * Returns the dot product of two Matrices
     * @param first
     * @param second
     * @return
     */
    public static Matrix dot(Matrix first, Matrix second) {
        // set the resulting shape to be the rows from the first matrix and the columns from the second matrix
        Shape resultShape = new Shape(first.getShape().rows,second.getShape().cols);

        // create the matrix that will store the resulting dot product
        Matrix resultMatrix = zeros(resultShape);
        double[][] resultingArray = new double[resultShape.rows][resultShape.cols];

        // create the underlying arrays in the first and second parameters
        double[][] firstArray = first.toArray();
        double[][] secondArray = second.toArray();

        // set up some variables for clarity
        int rowsInFirst = firstArray.length;
        int columnsInSecond = secondArray[0].length;

        // for every row in the first, take the dot product of the whole row and each column
        for (int i = 0; i < rowsInFirst; i++) {
            for (int j = 0; j < columnsInSecond; j++) {
                // for every column in the second array, add the dot product of that column and
                //   the current row from first to the current row in the resultingArray
                resultingArray[i][j] = vectorDotProduct(firstArray[i], getColumnAtIndex(j,secondArray));
            }
        }

        return new Matrix(resultingArray);
    }


    /**
     * Helper function.
     * Returns the dot product of two vectors. (1-dimensional matrices)
     * @param first
     * @param second
     * @return
     *
     * NOTE** Both of the arrays should be of the same size.
     */
    private static double vectorDotProduct(double[] first, double[] second) {
        double resultingNumber = 0;

        for (int i = 0; i < first.length; i++) {
            resultingNumber += first[i] * second[i];
        }

        return resultingNumber;
    }

    /**
     * Helper function.
     * Returns the column at the column index specified.
     * @param index
     * @param arr
     * @return
     */
    private static double[] getColumnAtIndex(int index, double[][] arr) {
        double[] column = new double[arr.length];

        for (int i = 0; i < arr.length; i++) {
            column[i] = arr[i][index];
        }

        return column;
    }


    /**
     * Just some print functions to help with visuals.
     */
    public void show() {
        if (name != null) System.out.println("\n" + name + ":");
        System.out.print("[");
        for (int i = 0; i < mat.length; i++) {
            System.out.print(createArrayLineForPrinting(this.mat[i]));
            if (i != mat.length - 1) {
                System.out.print(",\n");
            }
        }
        System.out.print("]");
    }

    private String createArrayLineForPrinting(double[] arr) {
        String out = "[" + arr[0];
        for (int i = 1; i < arr.length; i++) {
            out += ", " + arr[i];
        }

        out += "]";
        return out;

    }
}
