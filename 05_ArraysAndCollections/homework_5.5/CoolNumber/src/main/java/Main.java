import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class Main {
    public static final String BEAUTIFUL_NUMBER = "А777АА163";

    public static void main(String[] args) {
        String found;
        String string;
        List<String> list = CoolNumbers.generateCoolNumbers();

        Utils.begin();
        found = isFound(CoolNumbers.bruteForceSearchInList(list, BEAUTIFUL_NUMBER));
        Utils.end();
        string = String.format("Поиск перебором: номер %s, поиск занял %dнс", found, Utils.duration());
        System.out.println(string);

        Collections.sort(list);
        Utils.begin();
        found = isFound(CoolNumbers.binarySearchInList(list, BEAUTIFUL_NUMBER));
        Utils.end();
        string = String.format("Бинарный поиск: номер %s, поиск занял %dнс", found, Utils.duration());
        System.out.println(string);

        HashSet<String> hashSet = new HashSet<>(list);
        Utils.begin();
        found = isFound(CoolNumbers.searchInHashSet(hashSet, BEAUTIFUL_NUMBER));
        Utils.end();
        string = String.format("Поиск в HashSet: номер %s, поиск занял %dнс", found, Utils.duration());
        System.out.println(string);

        TreeSet<String> treeSet = new TreeSet<>(list);
        Utils.begin();
        found = isFound(CoolNumbers.searchInTreeSet(treeSet, BEAUTIFUL_NUMBER));
        Utils.end();
        string = String.format("Поиск в TreeSet: номер %s, поиск занял %dнс", found, Utils.duration());
        System.out.println(string);
    }

    private static String isFound(boolean found) {
        return found ? "найден" : "не найден";
    }
}