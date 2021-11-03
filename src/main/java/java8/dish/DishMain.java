package main.java.java8.dish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DishMain {

  public static void main(String[] args) {
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

    // filter only those dishes which are of type MEAT -- using Predicate
    System.out.println("Using Predicate");
    List<Dish> meatDish = filter(menu, (Dish dish) -> Dish.Type.MEAT.equals(dish.getType()));
    meatDish.forEach(System.out::println);

    // filter only those dishes which are of type MEAT -- using Streams
    System.out.println("\n Using Streams");
    menu.stream().filter(menuItem -> Dish.Type.MEAT.equals(menuItem.getType())).forEach(System.out::println);

    // filter 5 dishes which are of high calorie (>300) and collect their names in a list-- using Streams
    System.out.println("\n Using Streams filter 5 dishes which are of high calorie (>300)");
    menu.stream().filter(menuItem -> menuItem.getCalories() > 300).map(Dish::getName)
            .limit(5).collect(Collectors.toList()).forEach(System.out::println);

  }


  private static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
    List<T> result = new ArrayList<T>();

    list.forEach(l -> {
      if (predicate.test(l)) {
        result.add(l);
      }
    });
    return result;
  }
}
