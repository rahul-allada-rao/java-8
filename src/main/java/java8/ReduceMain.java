package main.java.java8;

import java.io.IOException;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;

public class ReduceMain {

  public static void main(String[] args) {

    // sum of all integers in an array
    int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int sum = Arrays.stream(numbers).reduce(0, (a,b)-> a+b);
//    int sum = Arrays.stream(numbers).reduce(0, Integer::sum);
    System.out.println("Expected Sum : 55 ; Actual Sum : " + sum);

    int maxElement = Arrays.stream(numbers).reduce(0, Integer::max);
    System.out.println("Max element : " + maxElement);

    OptionalInt minElement = Arrays.stream(numbers).reduce(Integer::min);
    System.out.println("Min element : " + minElement.getAsInt());

    // join string elements with a pipe character |
    String[] strings = {"a", "b", "c", "d", "e"};
    String finalString = Arrays.stream(strings).reduce("", (a,b) -> a + "|" + b);
    System.out.println(finalString);
  }
}
