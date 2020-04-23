package guru.springframework;

public class Sum implements Expression {

    Expression augmend;
    Expression addmend;

    public Sum(Expression augmend, Expression addmend) {
        this.augmend = augmend;
        this.addmend = addmend;
    }

    @Override
    public Money reduce(Bank bank, String currency) {
        int amount = augmend.reduce(bank, currency).amount + addmend.reduce(bank, currency).amount;
        return new Money(amount, currency);
    }

    @Override
    public Expression plus(Expression addend) {
        return null;
    }
}
