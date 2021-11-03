package main.java.java8.tradertxn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TraderTransactionMain {

  public static void main(String[] args) {
    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");

    List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    // 1. Find all transactions in the year 2011 and sort them by value (small to high).
    System.out.println("\nFind all transactions in the year 2011 and sort them by value (small to high)");
    List<Transaction> transactionByYear = transactions.stream()
            .filter(txn -> txn.getYear() == 2011)
            .sorted(Comparator.comparing(Transaction::getValue))
            .collect(Collectors.toList());
    transactionByYear.forEach(System.out::println);

    // 2. What are all the unique cities where the traders work?
    System.out.println("\nWhat are all the unique cities where the traders work?");
    List<String> uniqueCities = transactions.stream()
            .map(transaction -> transaction.getTrader().getCity())
            .distinct()
            .collect(Collectors.toList());
    uniqueCities.forEach(System.out::println);

    // 3. Find all traders from Cambridge and sort them by name.
    System.out.println("\nFind all traders from Cambridge and sort them by name.");
    List<Trader> tradersFromCambridge = transactions.stream()
            .map(Transaction::getTrader)
            .filter(trader -> "Cambridge".equals(trader.getCity()))
            .distinct()
            .sorted(Comparator.comparing(Trader::getName))
            .collect(Collectors.toList());
    tradersFromCambridge.forEach(System.out::println);

    // 4. Return a string of all traders’ names sorted alphabetically.
    System.out.println("\nReturn a string of all traders’ names sorted alphabetically.");
    String traderNameSorted = transactions.stream()
            .map(txn -> txn.getTrader().getName())
            .distinct()
            .sorted()
            .collect(Collectors.joining());

    String traderNameSortedWithTab = transactions.stream()
            .map(txn -> txn.getTrader().getName())
            .distinct()
            .sorted()
            .reduce("", (name1, name2) -> name1 + "\t" + name2);
    System.out.println(traderNameSorted);
    System.out.println(traderNameSortedWithTab);

    // 5. Are any traders based in Milan?
    System.out.println("Are any traders based in Milan?");
    if ( transactions.stream().anyMatch(txn -> txn.getTrader().getCity().equals("Milan")) ){
      System.out.println("Yes, there are traders based out of Milan");
    }

    // 6. Print all transactions’ values from the traders living in Cambridge.
    System.out.println("Print all transactions’ values from the traders living in Cambridge.");
    transactions.stream()
            .filter(txn -> txn.getTrader().getCity().equals("Cambridge"))
            .map(Transaction::getValue).forEach(System.out::println);

    // 7. What’s the highest value of all the transactions?
    System.out.println("What’s the highest value of all the transactions?");
    Optional<Integer> maxTxn = transactions.stream()
            .map(Transaction::getValue)
            .reduce(Integer::max);
//    transactions.stream().min(Comparator.comparing(Transaction::getValue));
    System.out.println("Max transaction value : " + maxTxn.get());

    // 8. Find the transaction with the smallest value.
    System.out.println("Find the transaction with the smallest value.");
    Optional<Integer> min = transactions.stream()
            .map(Transaction::getValue)
            .reduce(Integer::min);
    System.out.println("Min transaction value : " + min.get());
  }
}
