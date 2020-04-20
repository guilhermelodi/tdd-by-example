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

    @Override
    public Money reduce(Bank bank, String toCurrency) {
        int rate = bank.rate(this.currency, toCurrency);

        return new Money(amount / rate, toCurrency);
    }

    public Expression plus(Money addend) {
        return new Sum(this, addend);
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Money money = (Money) object;
        return amount == money.amount
                && currency.equals(money.currency);
    }
}
