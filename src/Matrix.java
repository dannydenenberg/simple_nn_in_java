/*
 * @author Daniel Denenberg
 * @date January 8, 2019
 */

import java.util.ArrayList;

/**
 * A simple matrix class implemented from scratch.
 */
public class Matrix {
    // the inner matrice that will be operated on
    private double[][] mat;
    private String name;

    /**
     * Convert the class to an array by returning the private matrix.
     * @return
     */
    public double[][] toArray() {
        return mat;
    }

    /**
     * Returns the shape of the inner matrix: `mat`.
     * @return
     */
    public Shape getShape() {
        return new Shape(mat.length, mat[0].length);
    }

    /**
     * Sets the `name` variable. This will be used when printing out this object.
     * The name will be used to specify this class.
     * @param s
     */
    public void setName(String s) {
        this.name = s;
    }

    /**
     * Initialization functions
     */

    /**
     * Simple initialization. Just sets the inner matrix to be the one inputed in the parameter.
     * @param matrix
     */
    public Matrix(double[][] matrix) {
        mat = matrix;
    }

    /**
     * Easy initialization of an array full of zeros.
     * @param s
     * @return
     */
    public static Matrix zeros(Shape s) {
        return new Matrix(fillShapeWithValue(s, 0));
    }

    public static Matrix ones(Shape s) {
        return new Matrix(fillShapeWithValue(s, 1));
    }

    public static Matrix tens(Shape s) {
        return new Matrix(fillShapeWithValue(s, 10));
    }

    /**
     * Fills the matrix of specified shape with a specific value.
     * @param s
     * @param value
     * @return
     */
    public static Matrix fillWithVal(Shape s, double value) {
        return new Matrix(fillShapeWithValue(s, value));
    }


    /**
     * Generates a matrix of the specified shape filled with random double values between 0 and 1.
     * @param s
     * @return
     */
    public static Matrix random(Shape s) {
        double[][] matrix = new double[s.rows][s.cols];

        for (int i = 0; i < s.rows; i++) {
            for (int j = 0; j < s.cols; j++) {
                matrix[i][j] = Math.random();
            }
        }

        return new Matrix(matrix);
    }

    /**
     * Multiplies each value in this matrix with a scalar value and then rounds all of the values.
     * @param scalar
     */
    public Matrix multiplyAndConvertToInts(double scalar) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] = Math.round(mat[i][j] * scalar);
            }
        }
        return this;
    }

    /**
     * Helper function for the `fillWithVal(Shape, double)` function specified before.
     * @param s
     * @param val
     * @return
     */
    private static double[][] fillShapeWithValue(Shape s, double val) {
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
     * Each function returns the matrix for ease of initialization. There is no need to create a new matrix object after one is created even though these functions return `this`;
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

    /**
     * Adds one number to every element in the matrix
     * @param scalar
     * @return
     */
    public Matrix add(double scalar) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] += scalar;
            }
        }
        return this;
    }

    /**
     * Subtracts one value from every element in the matrix.
     * @param scalar
     * @return
     */
    public Matrix sub(double scalar) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] -= scalar;
            }
        }
        return this;
    }

    /**
     * Divides one number with every element in the matrix
     * @param scalar
     * @return
     */
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


    /**
     * Returns the element wise addition of two matrices.
     * @param matrix
     * @param matrixOther
     * @return
     */
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

    /**
     * Returns the element wise subtraction of two matrices.
     * @param matrix
     * @param matrixOther
     * @return
     */
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

    /**
     * Returns the element wise division of two matrices.
     * @param matrix
     * @param matrixOther
     * @return
     */
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
     * Returns the transposition of the inputed matrix (rows become columns, columns become rows).
     * @param mat
     * @return
     */
    public static Matrix transpose(Matrix mat) {
        // in the new shape, the rows are the columns and the columns are the rows
        Shape resultingMatrixShape = new Shape(mat.getShape().cols, mat.getShape().rows);
        double[][] resultingArray = new double[resultingMatrixShape.rows][resultingMatrixShape.cols];

        // loop through the columns of the old matrix (rows of the new matrix), and add that column to the rows of the new matrix
        for (int i = 0; i < resultingMatrixShape.rows; i++) {
            resultingArray[i] = getColumnAtIndex(i, mat.toArray());
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
     * Applies the specified activation function to each element in the matrix.
     * Will throw an error if the specified function is not in the ActivationFunction class
     * @param name
     */
    public Matrix applyActivationToEachElement(String name) {
        ActivationFunction af = new ActivationFunction(name);

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] = af.activate(mat[i][j]);
            }
        }

        return this;
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

    /**
     * Helper function.
     * Turns an array into a string representing the array


     EX:
        [1, 2, 3, 4]


     * @param arr
     * @return
     */
    private String createArrayLineForPrinting(double[] arr) {
        String out = "[" + arr[0];
        for (int i = 1; i < arr.length; i++) {
            out += ", " + arr[i];
        }

        out += "]";
        return out;

    }
}
