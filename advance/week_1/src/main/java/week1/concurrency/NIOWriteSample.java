package week1.concurrency;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class NIOWriteSample {
    public static void main(String[] args) {
        String data = "Hello from NIO FileChannel!";
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(data.getBytes()); // Fill buffer with data
        
        buffer.flip(); // Switch to read mode for writing to channel
        
        Path path = Path.of("output.txt"); // File to write to
        
        try ( FileChannel channel = FileChannel.open(path,
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE)) {
            
            channel.write(buffer); // Write buffer content to file
            System.out.println("Data written to file: " + path.toAbsolutePath());
            
        } catch ( IOException e) {
            System.out.println( "e = " + e );
        }
    }
}

class NIOFileCopy {
    public static void main(String[] args) {
        Path sourcePath = Path.of("output.txt");
        Path targetPath = Path.of("input.txt");
        
        try (
                FileChannel readChannel = FileChannel.open(sourcePath, StandardOpenOption.READ);
                FileChannel writeChannel = FileChannel.open(targetPath,
                        StandardOpenOption.CREATE,
                        StandardOpenOption.WRITE,
                        StandardOpenOption.TRUNCATE_EXISTING)
        ) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (readChannel.read(buffer) > 0) {
                buffer.flip(); // Prepare buffer for reading
                writeChannel.write(buffer); // Write buffer content to output
                buffer.clear(); // Clear buffer for next read
            }
            
            System.out.println("File copied from input.txt to output.txt");
            
        } catch (IOException e) {
            System.out.println( "e = " + e );
        }
    }
}
