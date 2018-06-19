/*
This class is about a concept of portfolio. I define portfolio as a set of Stocks. Each stock has a price
and quantity. This class allows to add or remove STOCKS and add or remove their QUANTITY, which is unfortunately
the same word - stocks :)
*/

package pl.waw.sgh.myappFIRST;

import java.util.HashMap;
import java.util.Map;

public class Portfolio {
    private final Map<Integer, Stock> stock;

    public Portfolio() {
        this.stock = new HashMap<>();
    }

    public boolean addProduct(int id, Money price, int qty) {
        if (this.stock.containsKey(id)) {
            return false;
        } else {
            this.stock.put(id, new Stock(id, price, qty));
            return true;
        }
    }

    public boolean addStock(int id, int howMany) {
        if (!this.stock.containsKey(id)) {
            return false;
        }

        this.stock.get(id).addStock(howMany);
        return true;

    }

    public boolean reduceStock(int id, int howMany) {
        if (!this.stock.containsKey(id)) {
            return false;
        }

        return this.stock.get(id).removeStock(howMany);
    }

    public boolean removeProduct(int id) {
        if (!this.stock.containsKey(id)) {
            return false;
        }
        this.stock.remove(id);
        return true;
    }

    public void printTotalValueStock(int id) {
        if (!this.stock.containsKey(id)) {
            System.out.println("No product found.");
        } else {
            System.out.println("Product id: " + id +
                    " Available: " + this.stock.get(id).getQty() +
                    " Total value: " + this.stock.get(id).getTotalValue());
        }
    }

    public void printTotalValueNoOfStocks() {
        Money total = new Money(0, 0);

        for (Stock aProduct : this.stock.values()) {
            total = total.plus(aProduct.getTotalValue());
        }

        System.out.println("Total value of all stocks: " + total);
    }
}
