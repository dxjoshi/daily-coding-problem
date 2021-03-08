import java.util.*;

public class Q1_TwoSum {
    public static void main(String[] args) {
/*
        Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
        For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
        Bonus: Can you do this in one pass?
*/
        List<Integer> list = Arrays.asList(10, 15, 3, 7);
        Integer k = 12;
        boolean result = solve1(list, k);
        System.out.println(String.format("Result is: %b", result));

    }

    public static boolean solve2(List<Integer> list, Integer k) {
        // 2. For one pass: for each element, maintain a list that contains (k - element) and
        // if not found store (k-element) in the list
        boolean result = false;
        Set<Integer> diffs = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            if (diffs.contains(list.get(i))) {
                result = true;
                break;
            }
            if (k >= list.get(i)) {
                diffs.add(k- list.get(i));
            }
        }
        return result;
    }

    public static boolean solve1(List<Integer> list, Integer k) {
        // 1. O(NlogN) sort the original list and filter out until we find the pair that sum to k
        boolean result = false;
        int curr;
        for (int i = 0; i < list.size(); i++) {
            curr = list.get(i);
            if (list.contains(k - curr)) {
                System.out.println(String.format("%s", curr));
                result = true;
                break;
            }
            // list.remove(Integer.valueOf(list.get(i)));
        }
        return result;
    }
}
