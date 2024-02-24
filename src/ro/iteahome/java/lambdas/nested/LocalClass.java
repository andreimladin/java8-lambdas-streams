package ro.iteahome.java.lambdas.nested;

import java.util.Arrays;
import java.util.List;

public class LocalClass {


    private static void localClass() {

        class Money {
            private long amount;
            private String currency;

            public Money(long amount, String currency) {
                this.amount = amount;
                this.currency = currency;
            }

            public long getAmount() {
                return amount;
            }

            public String getCurrency() {
                return currency;
            }

            @Override
            public String toString() {
                return "Money{" +
                        "amount=" + amount +
                        ", currency='" + currency + '\'' +
                        '}';
            }
        }

        MONEY_LIST.stream()
                .map(s -> {
                    String[] currentMoney = s.split(" ");
                    return new Money(Long.valueOf(currentMoney[0]), currentMoney[1]);
                }).forEach(System.out::println);
    }

    public static void main(String[] args) {
        localClass();
    }

    private final static List<String> MONEY_LIST = Arrays.asList("100 RON", "150 EUR", "1200 GBP");
}
