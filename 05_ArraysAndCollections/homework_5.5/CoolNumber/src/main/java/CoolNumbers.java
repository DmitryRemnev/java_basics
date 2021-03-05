import java.util.*;

public class CoolNumbers {

    public static List<String> generateCoolNumbers() {
        List<String> list = new ArrayList<>();
        GenerationCarNumbers generationCarNumbers = new GenerationCarNumbers();

        for (int i = 0; i <= 2000000; i++) {
            list.add(generationCarNumbers.getCarNumber());
        }

        return list;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {

        for (String item : list) {
            if (item.equals(number)) {
                return true;
            }
        }

        return false;
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {

        for (String item : sortedList) {
            if (item.equals(number)) {
                return true;
            }
        }

        return false;
    }

    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        return hashSet.contains(number);
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        return treeSet.contains(number);
    }
}