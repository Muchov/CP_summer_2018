/*
Here we define what stock is. Stock is a financial asset. It has an ID and price.
Concept of value, as given quantity times price is also defined.
*/

package pl.waw.sgh.myappFIRST;

public class Stock {

    private final int id;
    private Money price;
    private int qty;

    public Stock(int id, Money price, int qty) {
        this.id = id;
        this.price = price;
        this.qty = qty;
    }

    public void addStock(int howMany) {
        this.qty += howMany;
    }

    public boolean removeStock(int howMany) {
        if (howMany > this.qty) {
            return false;
        } else {
            this.qty -= howMany;
            return true;
        }
    }

    public int getId() {
        return id;
    }

    public Money getTotalValue() {
        return this.price.multiplyBy(this.qty);
    }

    public void updatePrice(Money newPrice) {
        this.price = newPrice;
    }

    public int getQty() {
        return qty;
    }

}



