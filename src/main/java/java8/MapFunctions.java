package main.java.java8;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MapFunctions {

  public static void main(String[] args) {

    findSquareOfNumbers(Arrays.asList(1, 2, 3, 4, 5));

    findPairsFromTwoLists(Arrays.asList(1, 2, 3), Arrays.asList(3, 4));

  }

  private static void findSquareOfNumbers(List<Integer> l1) {
    /*
      Given a list of numbers, how would you return a list of the square of each number? For
      example, given [1, 2, 3, 4, 5] you should return [1, 4, 9, 16, 25].
     */
    l1.stream().map(i -> i * i).collect(Collectors.toList()).forEach(System.out::println);
  }

  private static void findPairsFromTwoLists(List<Integer> l1, List<Integer> l2) {
    /*
      Given two lists of numbers, how would you return all pairs of numbers? For example, given a
      list [1, 2, 3] and a list [3, 4] you should return [(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]. For
      simplicity, you can represent a pair as an array with two elements.
     */

    l1.stream().flatMap(i -> l2.stream().map(j -> new int[]{i, j})).collect(Collectors.toList());

    // How would you extend the previous example to return only pairs whose sum is divisible by 3?
    // For example, (2, 4) and (3, 3) are valid

    List<int[]> pairs = l1.stream().flatMap(i -> l2.stream()
            .filter(j -> (i + j) % 3 == 0)
            .map(j -> new int[]{i, j}))
            .collect(Collectors.toList());
  }
}
