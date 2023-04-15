package assignment3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Spin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rowNum = scanner.nextInt();
        int colNum = scanner.nextInt();
        String ori = scanner.next();
        String s = step1(ori);
        char[][] nu = step2(rowNum, colNum);
        step3(nu.length - 2, 1, s, nu, 1);
    }

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
            for (int j = 0; j < in.get(i); j++) {
                stringBuilder.append(ch.get(i));
            }
        }
        System.out.println(ch);
        System.out.println(stringBuilder);
        return stringBuilder.toString();
    }

    public static char[][] step2(int row, int col) {
        char[][] arr = new char[row + 2][col + 2];
        for (char[] chars : arr) {
            Arrays.fill(chars, '#');
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = '$';
            arr[i][arr[0].length - 1] = '$';
        }
        for (int i = 0; i < arr[0].length; i++) {
            arr[0][i] = '$';
            arr[arr.length - 1][i] = '$';
        }
        return arr;
    }

    public static boolean step3(int x, int y, String s, char[][] arr, int k) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        arr[arr.length - 1][0] = s.charAt(0);
        for (char[] chars : arr) {
            for (char aChar : chars) {
                if (aChar == '#') {
                    count++;
                }
            }
        }
        if (count == 0) {
            char[][] res = new char[arr.length - 2][arr[1].length - 2];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = arr[i + 1][j + 1];
                }
            }
            arr = res;
            for (char[] re : arr) {
                for (char c : re) {
                    System.out.print(c);
                }
                System.out.println();
            }
            return true;
        } else {
            if (right(arr, x, y)) {
                arr[x][y + 1] = s.charAt(k);
                return step3(x, y + 1, s, arr, k + 1);
            } else if (left(arr, x, y)) {
                arr[x][y - 1] = s.charAt(k);
                return step3(x, y - 1, s, arr, k + 1);
            } else if (down(arr, x, y)) {
                arr[x + 1][y] = s.charAt(k);
                return step3(x + 1, y, s, arr, k + 1);
            } else if (up(arr, x, y)) {
                arr[x - 1][y] = s.charAt(k);
                return step3(x - 1, y, s, arr, k + 1);
            } else {
                return false;
            }
        }
    }

    public static boolean right(char[][] arr, int x, int y) {
        boolean judge = (arr[x - 1][y] == '#') && (arr[x + 1][y] != '#') && (arr[x][y - 1] != '#') && (arr[x][y + 1] == '#');
        boolean case2 = arr[x][y + 1] == '#' && arr[x - 1][y] != '#' && arr[x + 1][y] != '#' && arr[x][y - 1] != '#';
        boolean constrain = x >= 1 && x < arr.length - 1 && y >= 1 && y + 1 < arr[1].length;
        return constrain && (judge || case2);
    }

    public static boolean left(char[][] arr, int x, int y) {
        boolean case2 = arr[x][y + 1] != '#' && arr[x - 1][y] != '#' && arr[x + 1][y] != '#' && arr[x][y - 1] == '#';
        boolean judge = (arr[x + 1][y] == '#') && (arr[x - 1][y] != '#') && (arr[x][y + 1] != '#') && (arr[x][y - 1] == '#');
        boolean constrain = x >= 1 && x < arr.length - 1 && y >= 1 && y + 1 < arr[1].length;
        return constrain && (judge || case2);
    }

    public static boolean down(char[][] arr, int x, int y) {
        boolean case2 = arr[x][y + 1] != '#' && arr[x - 1][y] != '#' && arr[x + 1][y] == '#' && arr[x][y - 1] != '#';
        boolean judge = (arr[x + 1][y] == '#') && (arr[x - 1][y] != '#') && (arr[x][y + 1] == '#') && (arr[x][y - 1] != '#');
        boolean constrain = x >= 1 && x < arr.length - 1 && y >= 1 && y + 1 < arr[1].length;
        return constrain && (judge || case2);
    }

    public static boolean up(char[][] arr, int x, int y) {
        boolean case2 = arr[x][y + 1] != '#' && arr[x - 1][y] == '#' && arr[x + 1][y] != '#' && arr[x][y - 1] != '#';
        boolean judge = (arr[x + 1][y] != '#') && (arr[x - 1][y] == '#') && (arr[x][y + 1] != '#') && (arr[x][y - 1] == '#');
        boolean constrain = x >= 1 && x < arr.length - 1 && y >= 1 && y + 1 < arr[1].length;
        return constrain && (judge || case2);
    }
}
