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

    public Money(int dollars, int cents) {
        this.dollars = dollars;
        this.cents = cents;

    }

    public int dollars() {
        return dollars;
    }

    public int cents() {
        return cents;
    }

    @Override
    public String toString() {
        String zero = "";
        if (cents < 10) {
            zero = "0";
        }

        return dollars + "." + zero + cents;
    }

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

    public boolean less(Money compared) {
        if (this.dollars() < compared.dollars())
            return true;
        else if (this.dollars() > compared.dollars())
            return false;
        else {
            return this.cents() < compared.cents();
        }
    }

    public Money minus(Money decremented) {
        int dollars_helper = 0;
        int cent_helper = 0;
        if (this.less(decremented))
            return new Money(0, 0);
        else {
            if (this.cents() < decremented.cents()) {
                dollars_helper = -1;
                cent_helper = (100 + this.cents()) - decremented.cents();
            } else
                cent_helper = this.cents() - decremented.cents();

            dollars_helper += (this.dollars() - decremented.dollars());
            return new Money(dollars_helper, cent_helper);
        }
    }

    public Money multiplyBy(int qty) {
        Money total = new Money(this.dollars, this.cents);

        for (int i = 1; i < qty; i++) {
            total = total.plus(this);
        }
        return total;
    }


}

