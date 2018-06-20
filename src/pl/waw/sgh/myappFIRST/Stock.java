/*
Here we define what stock is. Stock is a financial asset. It has an ID and price.
Concept of value, as given quantity times price is also defined.
*/

package pl.waw.sgh.myappFIRST;

public class Stock {

    private final int id;
    private Money price;
    private int qty;

    /*
    Stock need to have several parameters: Its ID, Price and Quantity.
    */

    public Stock(int id, Money price, int qty) {
        this.id = id;
        this.price = price;
        this.qty = qty;
    }

    /*
    Here we can add more stocks for a given StockID
    */

    public void addStock(int howMany) {
        this.qty += howMany;
    }

    /*
    Here we can removes stocks from ID.
    */

    public boolean removeStock(int howMany) {
        if (howMany > this.qty) {
            return false;
        } else {
            this.qty -= howMany;
            return true;
        }
    }

    /*
    Here we can get a total value fo stocks of a given ID number.
    */

    public Money getTotalValue() {
        return this.price.multiplyBy(this.qty);
    }

    /*
    Here we can get how many stocks do we have.
    */

    public int getQty() {
        return qty;
    }

}



