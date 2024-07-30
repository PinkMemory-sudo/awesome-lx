import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        List<String> list = Stream.of(null, "1", "2", "5", "3", "6").collect(Collectors.toList());
        list.sort(Comparator.comparing(String::valueOf));
        list.sort(Comparator.comparing(String::valueOf));
        System.out.println(list);
        for (String s : list) {
//            System.out.println(s.length());
        }
    }

}
