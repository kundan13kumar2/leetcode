package daily;

import java.util.*;

public class FoodRatingSystem {

    public static void main(String[] args) {

        String[] foods ={"emgqdbo","jmvfxjohq","qnvseohnoe","yhptazyko","ocqmvmwjq"};
        String[] cuisines ={"snaxol","snaxol","snaxol","fajbervsj","fajbervsj"};
        int[] ratings = {2,6,18,6,5};

        FoodRatingSystem frs = new FoodRatingSystem(foods, cuisines, ratings);

    }

    Comparator<FoodRating> foodRatingComparator = new Comparator<FoodRating>() {
        @Override
        public int compare(FoodRating o1, FoodRating o2) {
            if (o1.rating!= o2.rating){
                return o2.rating-o1.rating;
            }
            return o1.food.compareTo(o2.food);
        }
    };

    Map<String, PriorityQueue<FoodRating>> foodRatingsPQ = new Hashtable<>();
    Hashtable<String, String> foodCuisines = new Hashtable<>();
    Hashtable<String, FoodRating> foodRatingTable = new Hashtable<>();

    static class FoodRating {
        String food;
        int rating;
        FoodRating(String food, int rating) {
            this.food = food;
            this.rating = rating;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            FoodRating foodRating = (FoodRating) o;
            return rating==foodRating.rating && food.equals(foodRating.food);
        }

        @Override
        public int hashCode() {
            return Objects.hash(food, rating);
        }

        @Override
        public String toString() {
            return food + " " + rating;
        }
    }



    public FoodRatingSystem(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            foodCuisines.put(foods[i], cuisines[i]);
        }

        for (int i = 0; i < foods.length; i++) {
            String cuisine = cuisines[i];
            FoodRating foodRating = new FoodRating(foods[i], ratings[i]);

            PriorityQueue<FoodRating> existingFoods = foodRatingsPQ.computeIfAbsent(cuisine, k -> new PriorityQueue<>(foodRatingComparator));
            existingFoods.add(foodRating);
            foodRatingsPQ.put(cuisine, existingFoods);
            foodRatingTable.put(foods[i], foodRating);
        }

    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodCuisines.get(food);
        PriorityQueue<FoodRating> existingFoods = foodRatingsPQ.get(cuisine);
        FoodRating oldFood = foodRatingTable.get(food);
        if (oldFood !=null) {
            existingFoods.remove(oldFood);
            FoodRating newFood = new FoodRating(food, newRating);
            existingFoods.add(newFood);
            foodRatingsPQ.put(cuisine, existingFoods);
            foodRatingTable.put(food, newFood);
        }

    }

    public String highestRated(String cuisine) {

        PriorityQueue<FoodRating> ratingPQ = foodRatingsPQ.getOrDefault(cuisine, new PriorityQueue<>());
        if (ratingPQ.isEmpty()) return "";
        return ratingPQ.peek().food;
    }
}
