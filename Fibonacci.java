import java.util.ArrayList;

class Fibonacci {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int first = 0;
        int second = 1;
        list.add(first);
        list.add(second);
        for (int i = 0; i < 98; i++) {
            int sum = first + second;
            list.add(sum);
            first = second;
            second = sum;
        }
        System.out.println(list);
    }
}
