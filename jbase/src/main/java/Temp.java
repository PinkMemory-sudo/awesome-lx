import java.util.stream.IntStream;

public class Temp {
    public static void main(String[] args) {

        int[] cost = {1570, 220, (24 + 8 + 12) * 30};
        System.out.println(IntStream.of(cost).boxed().reduce(Integer::sum));
        System.out.println((24 + 8 + 12) * 30);
        System.out.println((24 + 8 + 12) * 30 + 220);
    }
}
