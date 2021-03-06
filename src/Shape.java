/**
 * This class will be used to represent the shape of a matrix.
 * @author Daniel Denenberg
 * @date January 8, 2019
 */
public class Shape {
    public int rows;
    public int cols;

    /**
     * Initialization is pretty straightforward. Just enter the shape (rows, columns).
     * @param r
     * @param c
     */
    public Shape(int r, int c) {
        rows = r;
        cols = c;
    }
}
