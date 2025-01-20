package intermediate.src.week1_labs.concurrency;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ImageProcessing implements Runnable {
    private final String imageName;
    
    public ImageProcessing (String imageName) {
        this.imageName = imageName;
    }
    
    @Override
    public void run () {
        // Simulating image processing
        System.out.println( "Processing image: " + imageName );
        try {
            Thread.sleep( 1000 ); // Simulate time taken to process the image
        } catch ( InterruptedException e ) {
            Thread.currentThread().interrupt(); // Restore interrupt status
            System.out.println( "Image processing interrupted for: " + imageName );
        }
        System.out.println( "Finished processing image: " + imageName );
    }
}

class ImageProcessingDemo {
    public static void main (String[] args) {
        // Create a fixed thread pool
        ExecutorService executorService = Executors.newFixedThreadPool( 5 );
        List<String> imageNames = List.of( "image1.jpg", "image2.jpg", "image3.jpg", "image4.jpg", "image5.jpg" );
        
        // Submit tasks for processing images
        for ( String imageName : imageNames ) {
            executorService.submit( new ImageProcessing( imageName ) );
        }
        
        executorService.shutdown(); // Shutdown the executor service
    }
}
