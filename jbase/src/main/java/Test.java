public class Test {
    public static void main(String[] args) {
        System.out.println(Math.pow(0.96, 5));
        get("kc50", 1.086, 3, 8);
        get("kc100", 1.008, 2, 7);
        get("nazhi", 2.118, 0, 5);
    }

    private static double get(String name, double x, int start, int stop) {
        int[] ints = {1000, 1000, 2000, 3000, 5000, 8000, 13000, 21000};
        double sum100 = 0;
        System.out.println("============================" + name + "============================");
        for (int i = start; i < stop; i++) {
            x = x * 0.96;
            System.out.print(x);
            System.out.print("\t");
            double t100 = x * ints[i];
            sum100 += t100;
            System.out.print(t100);
            System.out.print("\t");
            System.out.println(sum100);
        }
        return sum100;
    }

}
