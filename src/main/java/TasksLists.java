import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TasksLists {

    public void execute() {
        List<String> removedDuplicates = removeDuplicates(getListOfString());
        System.out.println("Removed duplicates: " + removedDuplicates);

        String concatenatedString = concatenateStrings(getListOfString());
        System.out.println("Concatenated : " + concatenatedString);

        List<String> filteredByPrefix = filterByPrefix(getListOfString(), "Level-2");
        System.out.println("Filtered by prefix: " + filteredByPrefix);

        List<String> filteredBySuffix = filterBySuffix(getListOfString(), "String-7");
        System.out.println("Filtered by suffix: " + filteredBySuffix);

        Map<Long, List<String>> groupedByLevelValue = groupByLevelValue(getListOfString());
        System.out.println("Grouped by level value: " + groupedByLevelValue);
    }

    private List<String> removeDuplicates(List<String> listOfString) {
        return listOfString.stream().distinct().collect(Collectors.toList());
    }

    private String concatenateStrings(List<String> listOfString) {
        return listOfString.stream().reduce(String::concat).get();
    }

    private List<String> filterByPrefix(List<String> listOfString, String prefix) {
        return listOfString.stream().filter(val -> val.startsWith(prefix)).collect(Collectors.toList());
    }

    private List<String> filterBySuffix(List<String> listOfString, String suffix) {
        return listOfString.stream().filter(val -> val.endsWith(suffix)).collect(Collectors.toList());
    }

    private Map<Long,List<String>> groupByLevelValue(List<String> listOfString) {
        return listOfString.stream().filter(val -> val.startsWith("Level")).collect(Collectors.groupingBy(val -> Long.parseLong(val.substring(6,7)), Collectors.toList()));
    }

    private List<String> getListOfString() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                list.add("Level-" + i + ":String-" + j);
            }
        }
        list.add("Duplicate-1");
        list.add("Duplicate-1");
        list.add("Duplicate-2");
        list.add("Duplicate-2");
        list.add("Duplicate-2");
        return list;
    }

}
