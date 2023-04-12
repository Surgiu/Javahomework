import java.util.ArrayList;

public class hw3p3 {
    public static void main(String[] args) {
        System.out.println(findIntegers("a1b3n5m7m56n34"));
    }

    public static ArrayList<Integer> findIntegers(String s) {
        ArrayList<Integer> in = new ArrayList<>();
        ArrayList<Character> ch = new ArrayList<>();

        int i = 0;
        int j = -1;
        do {
            if (Character.isDigit(s.charAt(i))) {
                j = i + 1;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    j++;
                }
                if (j < s.length() && Character.isDigit(s.charAt(j - 1))) {
                    j--;
                }
                int w = Integer.parseInt(s.substring(i, j));
                in.add(w);
                i = j;
            } else {
                i++;
            }
        } while (i < s.length());
        for (int k = 0; k < in.size(); k++) {

        }
    }
}
