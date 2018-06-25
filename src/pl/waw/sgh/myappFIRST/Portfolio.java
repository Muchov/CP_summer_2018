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

    /*
    Here we create a stock with given ID
    */

    public boolean addStockID(int id, Money price, int qty) {

        if (this.stock.containsKey(id)) {
            return false;

        } else {
            this.stock.put(id, new Stock(id, price, qty));
            return true;
        }
    }

    /*
    Here we can add more quantity to a given StockID
    */

    public boolean addStock(int id, int howMany) {

        if (!this.stock.containsKey(id)) {
            return false;
        }

        this.stock.get(id).addStock(howMany);
        return true;

    }

    /*
    Here we can reduce quantity of a given StockID
    */

    public boolean reduceStock(int id, int howMany) {

        if (!this.stock.containsKey(id)) {
            return false;
        }

        return this.stock.get(id).removeStock(howMany);
    }

    /*
    Here we can remove a given StockID from our portfolio.
    */

    public boolean removeStockID(int id) {

        if (!this.stock.containsKey(id)) {
            return false;
        }
        this.stock.remove(id);
        return true;
    }

    /*
    Here we can print total value of a given StockID
    */

    public void printTotalValueStockID(int id) {

        if (!this.stock.containsKey(id)) {
            System.out.println("No stock of given ID found!");

        } else {
            System.out.println("Stock id: " + id +
                    " Total value: " + this.stock.get(id).getTotalValue() + " $");
        }
    }

    /*
    Here we can print information about a given StockID
    */

    public void printStockInformation(int id) {

        if (!this.stock.containsKey(id)) {
            System.out.println("No stock of given ID found!");

        } else {
            System.out.println("Stock id: " + id +
                    " Available: " + this.stock.get(id).getQty() +
                    " Price: " + this.stock.get(id).getPrice() + " $");
        }
    }

    /*
    Total value of our portfolio.
    */

    public void printTotalValueOfOurPortfolio() {
        Money total = new Money(0, 0);

        for (Stock aProduct : this.stock.values()) {
            total = total.plus(aProduct.getTotalValue());
        }

        System.out.println("Total value of all stocks: " + total + " $");
    }
}
