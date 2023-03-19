package tsmod;

public class Toy {
    protected int id;
    protected String name;
    protected int quantity; // amount
    protected double rate; // drop rate

    public Toy(String name, int quantity, double rate) {
        this.name = name;
        this.quantity = quantity;
        this.rate = rate;
    }

    // public Toy(int id, String name, int quantity, double rate) {
    //     this.id = id;
    //     this.name = name;
    //     this.quantity = quantity;
    //     this.rate = rate;
    // }

    public Toy(Toy item) {
        this.id = item.id;

        this.name = item.name;
        this.quantity = item.quantity;
        this.rate = item.rate;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.name;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getRate() {
        return this.rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {

        // return String.format("%s %s %s %s", this.id, this.name, this.quantity, this.rate);
        return String.format("%s\t%s\t%s\t%s", this.id, this.name, this.quantity, this.rate);
    }
}