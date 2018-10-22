public class test {
    public static void main(String[] args) {
        Runtime i = Runtime.getRuntime();
        System.out.println(i.totalMemory() - i.freeMemory());
        int[] x = new int[1000000];
        System.out.println(i.totalMemory());
    }
}
