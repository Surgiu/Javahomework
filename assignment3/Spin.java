package assignment3;

import java.util.ArrayList;
import java.util.Scanner;

public class Spin {

    public static String step1(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        s = stringBuilder.append("x").toString();
        ArrayList<Integer> in = new ArrayList<>();
        ArrayList<Character> ch = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            if (Character.isDigit(s.charAt(i))) {
                int index = 0;
                for (int j = i; j < s.length() - 1; j++) {
                    if (Character.isDigit(s.charAt(j))) {
                        index = j + 1;
                        break;
                    }
                }
                in.add(Integer.parseInt(s.substring(i, index)));
            } else if (Character.isLetter(s.charAt(i))) {
                ch.add(s.charAt(i));
            }
        }
        stringBuilder.delete(0, stringBuilder.length());
        for (int i = 0; i < ch.size(); i++) {
            stringBuilder.append(String.valueOf(ch.get(i)).repeat(Math.max(0, in.get(i))));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rowNum = scanner.nextInt();
        int colNum = scanner.nextInt();
        String s = step1(scanner.next());
        print(step2(s, new char[rowNum][colNum]));
    }


    public static char[][] step2(String s, char[][] arr) {
        int m = 1, n = 0;
        int xSteps = arr[0].length, k = 0, ySteps = arr.length;
        while (k < s.length()) {
            if (m > 1) {
                for (int i = m - 2; i < xSteps - m; i++) {
                    arr[ySteps - n - 1][i] = s.charAt(k++);
                }
            } else {
                for (int i = 0; i < arr[0].length - 1; i++) {
                    arr[arr.length - 1][i] = s.charAt(k++);
                }
            }
            for (int i = ySteps - n - 1; i > n; i--) {
                arr[i][xSteps - m] = s.charAt(k++);
            }
            for (int i = xSteps - m; i > m - 1; i--) {
                arr[n][i] = s.charAt(k++);
            }
            for (int i = n; i < ySteps - n - 2; i++) {
                arr[i][m - 1] = s.charAt(k++);
            }
            m++;
            n++;
        }
        return arr;
    }

    public static void print(char[][] a) {
        for (char[] chars : a) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }
}
