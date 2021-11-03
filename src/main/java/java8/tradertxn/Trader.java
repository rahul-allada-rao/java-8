package main.java.java8.tradertxn;

import java.io.IOException;
import java.util.Scanner;

public class Trader {
  private final String name;
  private final String city;

  public Trader(String name, String city) {
    this.name = name;
    this.city = city;
  }

  public String getName() {
    return this.name;
  }

  public String getCity() {
    return this.city;
  }

  public String toString() {
    return "Trader:" + this.name + " in " + this.city;
  }
}