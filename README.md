# Neural Network 
A simple neural network library built from scratch in Java.

## Use
1. Clone the repository: ```$ git clone https://github.com/dannydenenberg/simple_nn_in_java.git```
2. Go into the source: ```$ cd simple_nn_in_java/src```
3. Pick out the libraries you want to use and copy the file into your code base

Example code for using the neural network: 
```java
...
public static void main(String[] args) { 
    NeuralNetwork nn = new NeuralNetwork();
    
    // Add new layers
    nn.add(2, 7, "sigmoid");
    nn.add(7, 1, "sigmoid");
    
    // Do a feedforward pass through the network using a random matrix 
    nn.feedforward(Matrix.random(new Shape(1, 2))).show();
}
...
```

Example code for using the matrix library: 
```
...
public static void main(String[] args) {
    /**** Initializing Matrices ****/
    
    // Simply give it a 2d array
    Matrix m = new Matrix([[1,2,3],[4,5,6],[7,8,9]]);
    
    // Populate a matrix with zeros, ones, tens, or any arbitrary value, given a shape
    Matrix m2 = Matrix.zeros(new Shape(1,2));
    Matrix m3 = Matrix.ones(new Shape(1,2));
    Matrix m4 = Matrix.tens(new Shape(1,2));
    Matrix m5 = Matrix.zeros(new Shape(1,2), 4444); // a 1x2 matrix where each element is 4444
    Matrix m6 = Matrix.random(new Shape(1,2)); // give it random values between 0 and 1 for each element
    
    
    
}
...
```

## Files
### Matrix.java
 * This is a matrix library built from scratch in Java. 
 * Includes all basic element wise operations as well as dot product, transpose, print functions, and more.

### Shape.java
 * A simple class to represent the shape of a matrix.
 
### ActivationFunction.java
 * Represents a single activation function.
 * During initialization, specify the activation function you want to use, and when you call ```activate(double number)```, it will use the specified function
 
### Layer.java
 * A single layer in the network.
 * Has its own weights, biases, and activation functions.
 
