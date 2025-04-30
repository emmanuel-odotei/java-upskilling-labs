package week1.concurrency;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

// Task to compute one row of the result matrix
public class MatrixMultiplicationTask extends RecursiveAction {
    private static final int THRESHOLD = 100; // Rows per task
    
    private final double[][] A;
    private final double[][] B;
    private final double[][] result;
    private final int rowStart;
    private final int rowEnd;
    
    public MatrixMultiplicationTask (double[][] A, double[][] B, double[][] result, int rowStart, int rowEnd) {
        this.A = A;
        this.B = B;
        this.result = result;
        this.rowStart = rowStart;
        this.rowEnd = rowEnd;
    }
    
    @Override
    protected void compute () {
        int rowCount = rowEnd - rowStart;
        
        if ( rowCount <= THRESHOLD ) {
            multiplyRows();
        } else {
            int mid = rowStart + rowCount / 2;
            MatrixMultiplicationTask task1 = new MatrixMultiplicationTask( A, B, result, rowStart, mid );
            MatrixMultiplicationTask task2 = new MatrixMultiplicationTask( A, B, result, mid, rowEnd );
            invokeAll( task1, task2 ); // Fork both subtasks
        }
    }
    
    private void multiplyRows () {
        int colsB = B[ 0 ].length;
        int colsA = A[ 0 ].length;
        
        for ( int i = rowStart; i < rowEnd; i++ ) {
            for ( int j = 0; j < colsB; j++ ) {
                double sum = 0;
                for ( int k = 0; k < colsA; k++ ) {
                    sum += A[ i ][ k ] * B[ k ][ j ];
                }
                result[ i ][ j ] = sum;
            }
        }
    }
    
    public static void main (String[] args) {
        int rowsA = 1000;
        int colsA = 1000;
        int colsB = 1000;
        
        double[][] A = generateMatrix( rowsA, colsA );
        double[][] B = generateMatrix( colsA, colsB );
        double[][] result = new double[ rowsA ][ colsB ];
        
        ForkJoinPool pool = new ForkJoinPool();
        
        System.out.println( "Starting parallel matrix multiplication..." );
        
        long startTime = System.currentTimeMillis();
        MatrixMultiplicationTask task = new MatrixMultiplicationTask( A, B, result, 0, A.length );
        pool.invoke( task );
        long endTime = System.currentTimeMillis();
        
        System.out.println( "Matrix multiplication complete." );
        System.out.println( "Time taken: " + ( endTime - startTime ) + "ms" );
        
        System.out.println( "First 5 rows of the result matrix:" );
        printMatrix( Arrays.copyOf( result, 5 ) );
        
        pool.shutdown();
    }
    
    private static double[][] generateMatrix (int rows, int cols) {
        Random rand = new Random();
        double[][] matrix = new double[ rows ][ cols ];
        
        for ( int i = 0; i < rows; i++ )
            for ( int j = 0; j < cols; j++ )
                matrix[ i ][ j ] = rand.nextDouble() * 10; // Values between 0 and 10
        
        return matrix;
    }
    
    private static void printMatrix (double[][] matrix) {
        for ( double[] row : matrix ) {
            for ( double value : row ) {
                System.out.printf( "%8.2f ", value );
            }
            System.out.println();
        }
    }
}
