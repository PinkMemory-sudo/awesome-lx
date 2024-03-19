package collection;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionTest {
    public static void main(String[] args) {
        System.out.println(Arrays.toString("08,".split(",")));
        System.out.println("08,".split(",").length);
        List<Integer> integerList = Stream.of(1, 2, 3, 4, 5, 6, 7).collect(Collectors.toList());
        boolean b = integerList.removeIf(it -> it % 2 == 0);
        System.out.println(integerList);
//        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>(integerList);
//
//        for (Integer i : copyOnWriteArrayList) {
//            integerList.remove(i);
//        }
//        System.out.println(integerList);

        // ConcurrentModificationException
        System.out.println(integerList);
        for (Integer i : integerList) {
            integerList.remove(i);
        }
        System.out.println(integerList);
    }
}
