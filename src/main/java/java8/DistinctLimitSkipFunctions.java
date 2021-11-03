package main.java.java8;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class DistinctLimitSkipFunctions {

  public static void main(String[] args) {

    //To find unique elements in resultant stream - distinct()
    System.out.println("Without using distinct()");
    Arrays.asList(1,2,3,2,4,5,6,4).stream().filter(i -> i%2 == 0).forEach(System.out::println);

    System.out.println("Using distinct()");
    Arrays.asList(1,2,3,2,4,5,6,4).stream().filter(i -> i%2 == 0).distinct().forEach(System.out::println);

    //To truncate n elements in resultant stream - limit(n)
    System.out.println("Using limit() to print out only the first 2 distinct even numbers");
    Arrays.asList(1,2,3,2,4,5,6,4).stream().filter(i -> i%2 == 0).distinct().limit(2).forEach(System.out::println);

    //To skip first n elements  in the resultant stream - skip(n)
    System.out.println("Using skip() to print out even numbers other than 2");
    Arrays.asList(1,2,3,2,4,5,6,4).stream().filter(i -> i%2 == 0).skip(2).distinct().forEach(System.out::println);
  }
}
