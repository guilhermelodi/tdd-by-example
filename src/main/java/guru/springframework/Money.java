package guru.springframework;

public class Money implements Expression {

    protected int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    public static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    protected String currency() {
        return currency;
    }

    public Money times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    public Money reduce(String toCurrency) {
        return this;
    }

    public Expression plus(Money addend) {
        return new Sum(this, addend);
    }

    public boolean equals(Object object) {
        Money money = (Money) object;

        return amount == money.amount
                && currency == money.currency;
    }
}
