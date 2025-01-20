package intermediate.src.week1_labs.oop.collections;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class InMemoryCacheCollection<K, V> {
    private final ConcurrentHashMap<K, CacheObject<V>> cache;
    private final long ttl;
    
    public InMemoryCacheCollection (long ttl) {
        this.cache = new ConcurrentHashMap<>();
        this.ttl = ttl;
    }
    
    // Add an item to the cache
    public void put (K key, V value) {
        CacheObject<V> cacheObject = new CacheObject<>( value, System.nanoTime() );
        cache.put( key, cacheObject );
    }
    
    // Retrieve an item from the cache
    public V get (K key) {
        CacheObject<V> cacheObject = cache.get( key );
        
        if ( cacheObject == null ) {
            return null;
        }
        
        // Check if item has expired
        if ( isExpired( cacheObject ) ) {
            cache.remove( key );
            return null;
        }
        
        return cacheObject.value();
    }
    
    // Remove an item from the cache
    public void remove (K key) {
        cache.remove( key );
    }
    
    // Check if the cache contains a key
    public boolean containsKey (K key) {
        return cache.containsKey( key );
    }
    
    // Clear the entire cache
    public void clear () {
        cache.clear();
    }
    
    // Helper method to check if a CacheObject has expired
    private boolean isExpired (CacheObject<V> cacheObject) {
        long currentTime = System.nanoTime();
        long timeElapsed = TimeUnit.NANOSECONDS.toSeconds( currentTime - cacheObject.creationTime() );
        return timeElapsed > ttl;
    }
    
    // Inner class to wrap the value with its creation time
    private record CacheObject<V>( V value, long creationTime ) {
    }
    
    public static void main (String[] args) throws InterruptedException {
        InMemoryCacheCollection<String, String> cache = new InMemoryCacheCollection<>( 5 ); // 5 seconds TTL
        
        cache.put( "key1", "value1" );
        System.out.println( "Retrieved: " + cache.get( "key1" ) ); // Output: value1
        
        Thread.sleep( 6000 ); // Wait for 6 seconds, more than the TTL
        
        System.out.println( "Retrieved after TTL: " + cache.get( "key1" ) ); // Output: null, as it has expired
        
        cache.put("key2", "value2" );
        System.out.println( "Retrieved: " + cache.get( "key2" ) ); // Output: value2
        
        cache.remove( "key2" );
        System.out.println( "Retrieved after removal: " + cache.get( "key2" ) ); // Output: null, as it has been removed
        
        cache.put( "key3", "value3" );
        System.out.println( "Retrieved: " + cache.get( "key3" ) ); // Output: value3
        
        System.out.println("Contains key3: "+ cache.containsKey( "key3" ));
        
        cache.clear();
        System.out.println( "Retrieved after clear: " + cache.get( "key3" ) ); // Output: null, as it has been removed
    }
}
