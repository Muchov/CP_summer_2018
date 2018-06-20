/*
Business is about money. Stocks definitely rely on the concept of money, so we need
to create a class that will define for us what money actually is. I will use here
dollars and cents, to mark a price for our stocks. We also define here what cents are,
as we know: 1 dollar equals 100 cents so we need to tell java what to do if we have for example
32132 cents. It should be translated into 321.32 dollars
*/

package pl.waw.sgh.myappFIRST;

public class Money {

    private final int dollars;
    private final int cents;

    /*
    Definition of what money is. It consists of dollars and cents.
    */

    public Money(int dollars, int cents) {
        this.dollars = dollars;
        this.cents = cents;

    }

    /*
    Dollar definition
    */

    public int dollars() {
        return dollars;
    }

    /*
    What are cents
    */

    public int cents() {
        return cents;
    }

    /*
    A problem was encountered and here is the fix. As we know, if we have one dollar and one cent,
    we write : 1.01$ not 1.1$. Code was creating the "1.1$" number. So we need to fix it. An idea is
    that if we have cents below 10, we add zero before the number of cents. If its higher than 10,
    then we have no problem.
    */

    @Override
    public String toString() {
        String zero = "";
        if (cents < 10) {
            zero = "0";
        }

        return dollars + "." + zero + cents;

    }

    /*
    Another problem with defining money is our money system. 100 cents equals 1 dollar.
    Computer don't really know that, so we need to tell him to do so. If we type for example 150 cents,
    it will add 1 to the dollar and subtract 100 from cents. If we type e.g. 5000,
    it wil change it to 50 dollars performing iterations.
    */

    public Money plus(Money added) {

        int dollars_helper = 0;
        int cent_helper = 0;

        if ((this.cents() + added.cents()) > 100) {
            dollars_helper = 1;
            cent_helper = (this.cents() + added.cents()) - 100;

        } else

            cent_helper = this.cents() + added.cents();

        return new Money(this.dollars() + added.dollars() + dollars_helper,
                cent_helper);
    }

    /*
    Stock multiplication code
    */

    public Money multiplyBy(int qty) {
        Money total = new Money(this.dollars, this.cents);

        for (int i = 1; i < qty; i++) {
            total = total.plus(this);

        }

        return total;

    }

}

