package org.summer.leetcode.medium;

import java.util.*;

/**
 * 2353. 设计食物评分系统
 * 设计一个支持下述操作的食物评分系统：
 * <p>
 * 修改 系统中列出的某种食物的评分。
 * 返回系统中某一类烹饪方式下评分最高的食物。
 * 实现 FoodRatings 类：
 * <p>
 * FoodRatings(String[] foods, String[] cuisines, int[] ratings) 初始化系统。食物由 foods、cuisines 和 ratings 描述，长度均为 n 。
 * foods[i] 是第 i 种食物的名字。
 * cuisines[i] 是第 i 种食物的烹饪方式。
 * ratings[i] 是第 i 种食物的最初评分。
 * void changeRating(String food, int newRating) 修改名字为 food 的食物的评分。
 * String highestRated(String cuisine) 返回指定烹饪方式 cuisine 下评分最高的食物的名字。如果存在并列，返回 字典序较小 的名字。
 * 注意，字符串 x 的字典序比字符串 y 更小的前提是：x 在字典中出现的位置在 y 之前，也就是说，要么 x 是 y 的前缀，或者在满足 x[i] != y[i] 的第一个位置 i 处，x[i] 在字母表中出现的位置在 y[i] 之前。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["FoodRatings", "highestRated", "highestRated", "changeRating", "highestRated", "changeRating", "highestRated"]
 * [[["kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"], ["korean", "japanese", "japanese", "greek", "japanese", "korean"], [9, 12, 8, 15, 14, 7]], ["korean"], ["japanese"], ["sushi", 16], ["japanese"], ["ramen", 16], ["japanese"]]
 * 输出
 * [null, "kimchi", "ramen", null, "sushi", null, "ramen"]
 * <p>
 * 解释
 * FoodRatings foodRatings = new FoodRatings(["kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"], ["korean", "japanese", "japanese", "greek", "japanese", "korean"], [9, 12, 8, 15, 14, 7]);
 * foodRatings.highestRated("korean"); // 返回 "kimchi"
 * // "kimchi" 是分数最高的韩式料理，评分为 9 。
 * foodRatings.highestRated("japanese"); // 返回 "ramen"
 * // "ramen" 是分数最高的日式料理，评分为 14 。
 * foodRatings.changeRating("sushi", 16); // "sushi" 现在评分变更为 16 。
 * foodRatings.highestRated("japanese"); // 返回 "sushi"
 * // "sushi" 是分数最高的日式料理，评分为 16 。
 * foodRatings.changeRating("ramen", 16); // "ramen" 现在评分变更为 16 。
 * foodRatings.highestRated("japanese"); // 返回 "ramen"
 * // "sushi" 和 "ramen" 的评分都是 16 。
 * // 但是，"ramen" 的字典序比 "sushi" 更小。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 2 * 104
 * n == foods.length == cuisines.length == ratings.length
 * 1 <= foods[i].length, cuisines[i].length <= 10
 * foods[i]、cuisines[i] 由小写英文字母组成
 * 1 <= ratings[i] <= 108
 * foods 中的所有字符串 互不相同
 * 在对 changeRating 的所有调用中，food 是系统中食物的名字。
 * 在对 highestRated 的所有调用中，cuisine 是系统中 至少一种 食物的烹饪方式。
 * 最多调用 changeRating 和 highestRated 总计 2 * 104 次
 */
public class Solution_2353 {

    static class FoodRatings {

        static class FoodInfo {
            private final String food;
            private final String cuisine;
            private int rating;

            public FoodInfo(String food, String cuisine, int rating) {
                this.food = food;
                this.cuisine = cuisine;
                this.rating = rating;
            }

            public void setRating(int rating) {
                this.rating = rating;
            }

            public int getRating() {
                return rating;
            }

            public String getFood() {
                return food;
            }

            public String getCuisine() {
                return cuisine;
            }

            @Override
            public int hashCode() {
                return Objects.hash(food, cuisine, rating);
            }

            @Override
            public boolean equals(Object obj) {
                if (!(obj instanceof FoodInfo o)) {
                    return false;
                }
                return hashCode() == obj.hashCode() && food.equals(o.food) && cuisine.equals(o.cuisine) && rating == o.rating;
            }
        }

        private final HashMap<String, FoodInfo> foodMap;

        /**
         * 某种烹饪方式可以烹饪的食物，评分最高字节序最小的放置在第一位
         */
        private final HashMap<String, TreeSet<FoodInfo>> cuisineMap;

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            int n = foods.length;
            foodMap = new HashMap<>(n);
            cuisineMap = new HashMap<>(n);
            for (int i = 0; i < n; i++) {
                FoodInfo foodInfo = new FoodInfo(foods[i], cuisines[i], ratings[i]);
                foodMap.put(foods[i], foodInfo);
                TreeSet<FoodInfo> valueFoods = cuisineMap.computeIfAbsent(cuisines[i],
                        k -> new TreeSet<>((o1, o2) -> o1.rating != o2.rating ? (o2.rating - o1.rating) : o1.food.compareTo(o2.food)));
                valueFoods.add(foodInfo);
            }
        }



        /**
         * 修改名字为 food 的食物的评分为newRating。
         */
        public void changeRating(String food, int newRating) {
            FoodInfo info = foodMap.get(food);
            assert info != null;
            // 改变列表中的评分及顺序
            String cuisine = info.cuisine;
            TreeSet<FoodInfo> foodInfos = cuisineMap.get(cuisine);
            foodInfos.remove(info);
            info.setRating(newRating);
            foodInfos.add(info);

        }

        /**
         * 返回指定烹饪方式 cuisine 下评分最高的食物的名字。如果存在并列，返回 字典序较小 的名字。
         */
        public String highestRated(String cuisine) {
            TreeSet<FoodInfo> foods = cuisineMap.get(cuisine);
            if (foods == null || foods.isEmpty()) {
                return null;
            }
            return foods.first().food;
        }
    }

    public static void main(String[] args) {
        /*FoodRatings foodRatings = new FoodRatings(new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"},
                new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"}, new int[]{9, 12, 8, 15, 14, 7});
        System.out.println(foodRatings.highestRated("korean"));
        System.out.println(foodRatings.highestRated("japanese"));
        foodRatings.changeRating("sushi", 16);
        System.out.println(foodRatings.highestRated("japanese"));
        foodRatings.changeRating("ramen", 16);
        System.out.println(foodRatings.highestRated("japanese"));*/

        FoodRatings foodRatings = new FoodRatings(new String[]{"czopaaeyl","lxoozsbh","kbaxapl"},
                new String[]{"dmnuqeatj","dmnuqeatj","dmnuqeatj"}, new int[]{11,2,15});
        foodRatings.changeRating("czopaaeyl",12);
        System.out.println(foodRatings.highestRated("dmnuqeatj"));
        foodRatings.changeRating("kbaxapl",8);
        foodRatings.changeRating("lxoozsbh",5);
        System.out.println(foodRatings.highestRated("dmnuqeatj"));
    }
    // czopaaeyl dmnuqeatj  12
    // lxoozsbh  dmnuqeatj  2
    // kbaxapl   dmnuqeatj  8
}
