package main.java.java8.dish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
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
            new Dish("prawns", false, 300, Dish.Type.SEA_FOOD),
            new Dish("salmon", false, 450, Dish.Type.SEA_FOOD));

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

    // count how many dishes are present
    System.out.println("count how many dishes are present");
    Long collect = menu.stream().collect(Collectors.counting());
    System.out.println("No. of dishes present in the menu are : " + collect);

    //group menu by dish type
    System.out.println("\n Group menu by dish type");
    Map<Dish.Type, List<Dish>> menuByType = menu.stream().collect(Collectors.groupingBy(Dish::getType));
    menuByType.forEach((key, value) -> System.out.println(key.name() + value));

    //group menu by caloric level
    /*
      For instance, you could decide to classify as “diet” all dishes with 400 calories or fewer, set to
     “normal” the dishes having between 400 and 700 calories, and set to “fat” the ones with more
     than 700 calories.
   */
    System.out.println("\n Group menu by caloric level");
    Map<Dish.CaloricLevel, List<Dish>> menuByCaloricLevel = menu.stream().collect(Collectors.groupingBy(dish -> {
      if (dish.getCalories() <= 400) {
        return Dish.CaloricLevel.DIET;
      } else if (dish.getCalories() > 400 && dish.getCalories() <= 700) {
        return Dish.CaloricLevel.NORMAL;
      } else {
        return Dish.CaloricLevel.FAT;
      }
    }));

    for (Map.Entry entry : menuByCaloricLevel.entrySet()) {
      System.out.println("For Caloric Level = " + entry.getKey());
      System.out.println("Dishes are : ");
      List<Dish> dishes = (List) entry.getValue();
      dishes.forEach(dish -> System.out.println(dish.getName() + "\t" + dish.getCalories()));
    }

    // multi-level grouping - grouping both by their type and by calories
    Map<Dish.Type, Map<Dish.CaloricLevel, List<Dish>>> menuByDishTypeAndCaloricType =
            menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.groupingBy(dish -> {
              if (dish.getCalories() <= 400) {
                return Dish.CaloricLevel.DIET;
              } else if (dish.getCalories() > 400 && dish.getCalories() <= 700) {
                return Dish.CaloricLevel.NORMAL;
              } else {
                return Dish.CaloricLevel.FAT;
              }
            })));

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
