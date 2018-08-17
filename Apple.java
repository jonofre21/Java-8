package lab3;

public class Apple {
	
	 private int weight = 0;
    private String color = "";
    private double price =0;

    public Apple(int weight, String color, double price){
        this.weight = weight;
        this.color = color;
        this.price = price;
    }

    public Integer getWeight() {
        return weight;
    }

    
    
    public Double getPrice() {
        return price;
    }

    

    public String getColor() {
        return color;
    }

    

    public String toString() {
        return "Apple{" +
               "color='" + color + '\'' +
               ", weight=" + weight + ", price="+price+
               '}';
    }
	
}



