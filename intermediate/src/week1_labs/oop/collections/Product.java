package intermediate.src.week1_labs.oop.collections;

public record Product( String name, double price, int quantityInStock ) {
    
    @Override
    public String toString () {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantityInStock=" + quantityInStock +
                '}';
    }
}
