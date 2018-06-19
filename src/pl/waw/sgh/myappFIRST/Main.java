/*
MAIN is used in my app to be a class that aggregates other classes,
we use this class to launch our Portfolio Manager

How can this app be improved?
1. Create an abstract class "Stock". We can then manipulate this abstract class and
create stocks of different types, maybe as a kind of Indexes?
2. Create a GUI for our manager - a simple excel-like type gui would be ok.
3. User now don't really know what does he have in his portfolio. GUI with counter should solve this
4. The problem with my app is that it don't save portfolios of stocks. So a person that uses it
can't really manipulate his previous portfolios. An idea would be to save our portfolios into csv file and later
load them from there to allow app manipulate on them.
5. You can't alter the price of stocks. It pretty much works like a simple accounting program, we buy a stock
of ID "6" for 2,50$ and later it's saved as for 2,5$. We have to delete the stock to change it's price.
*/

package pl.waw.sgh.myappFIRST;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Portfolio stock = new Portfolio();
        boolean quitFlag = true;

        String qId = "Enter the stock id: ";
        String qQty = "Enter the product quantity: ";
        String qDollar = "Enter the price in tens of dollars: ";
        String qCents = "Enter the price in cents: ";
        String qMany = "How many stocks: ";

        System.out.println("Welcome to the PortfolioManager");

        while (quitFlag) {
            System.out.println("What do you want to do?");
            System.out.println("\n    Enter 1 to add a new stock.");
            System.out.println("    Enter 2 to add more stocks for a given stock ID.");
            System.out.println("    Enter 3 to reduce amount of stocks for a given stock ID");
            System.out.println("    Enter 4 to remove a stock from the portfolio.");
            System.out.println("    Enter 5 to calculate total value certain stock.");
            System.out.println("    Enter 6 to calculate overall value of the portfolio.");
            System.out.println("    Enter \"q\" to quit the PortfolioManager.");

            System.out.print(">>");
            String res = reader.nextLine();

            System.out.println();
            switch (res) {
                case "1":
                    int id1 = onlyCheckInt(reader, qId);
                    int qty1 = onlyCheckInt(reader, qQty);
                    System.out.println("Enter the price: ");
                    int dollar1 = onlyCheckInt(reader, qDollar);
                    int cent1 = onlyCheckInt(reader, qCents);
                    stock.addProduct(id1, new Money(dollar1, cent1), qty1);
                    break;

                case "2":
                    int id2 = onlyCheckInt(reader, qId);
                    int howMany2 = onlyCheckInt(reader, qMany);
                    boolean test2 = stock.addStock(id2, howMany2);
                    checkIdIfOnStock(test2);
                    break;

                case "3":
                    int id3 = onlyCheckInt(reader, qId);
                    int howMany3 = onlyCheckInt(reader, qMany);
                    boolean test3 = stock.reduceStock(id3, howMany3);
                    checkIdIfOnStock(test3);
                    break;

                case "4":
                    int id4 = onlyCheckInt(reader, qId);
                    boolean test4 = stock.removeProduct(id4);
                    checkIdIfOnStock(test4);
                    break;

                case "5":
                    int id5 = onlyCheckInt(reader, qId);
                    stock.printTotalValueStock(id5);
                    break;

                case "6":
                    stock.printTotalValueNoOfStocks();
                    break;

                case "q":
                    quitFlag = false;
                    break;
            }
        }
    }

    public static int onlyCheckInt(Scanner scan, String q) {
        int id;
        System.out.print(q);
        while (true) {
            try {
                id = Integer.parseInt(scan.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.print("Try again! " + q);
            }
        }
        return id;
    }

    public static void checkIdIfOnStock(boolean status) {
        if (!status) {
            System.out.println("No stock of given id found!");
        }
    }
}
