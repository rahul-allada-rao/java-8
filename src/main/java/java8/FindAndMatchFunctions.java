package main.java.java8;

import main.java.java8.dish.Dish;

import java.util.Arrays;
import java.util.List;

public class FindAndMatchFunctions {

  public static void main(String[] args) {

    // allMatch, anyMatch, noneMatch, findFirst, and findAny methods
    List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.VEG),
            new Dish("rice", true, 350, Dish.Type.VEG),
            new Dish("season fruit", true, 120, Dish.Type.VEG),
            new Dish("pizza", true, 550, Dish.Type.VEG),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH));

    // allMatch, anyMatch, noneMatch --> these return a boolean type --> these are terminal operations in stream.
    vegDishPresent(menu);
    meatDishPresent(menu);
    ketoDishPresent(menu);

  }

  private static void vegDishPresent(List<Dish> menu) {
    if (menu.stream().allMatch(dish -> Dish.Type.VEG.equals(dish.getType()))) {
      System.out.println("The menu is completely Veg !!!");
    }
  }

  private static void meatDishPresent(List<Dish> menu) {
    if (menu.stream().anyMatch(dish -> Dish.Type.MEAT.equals(dish.getType()))) {
      System.out.println("There are some meaty options present !!!");
    }
  }

  private static void ketoDishPresent(List<Dish> menu) {
    if (menu.stream().noneMatch(dish -> Dish.Type.KETO.equals(dish.getType()))) {
      System.out.println("Keto dishes are not on the menu !!!");
    }
  }


}
