package main.java.java8.dish;

import java.io.IOException;
import java.util.Scanner;

public class Dish {

  private final String name;
  private final boolean vegetarian;
  private final int calories;
  private final Type type;

  public Dish(String name, boolean vegetarian, int calories, Type type) {
    this.name = name;
    this.vegetarian = vegetarian;
    this.calories = calories;
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public boolean isVegetarian() {
    return vegetarian;
  }

  public int getCalories() {
    return calories;
  }

  public Type getType() {
    return type;
  }

  @Override
  public String toString() {
    return name;
  }

  public enum Type {MEAT, SEA_FOOD, VEG, KETO}
  public enum CaloricLevel { DIET, NORMAL, FAT }
}
