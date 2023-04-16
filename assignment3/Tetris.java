package assignment3;

import java.util.Scanner;

public class Tetris {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] map0 = generateMap(scanner);
        int[][] map1 = modify(scanner, map0);
        int[][] map2 = res(map1);
        printMap(map2);
    }

    public static int[][] generateMap(Scanner s) {
        //生成最上方有两排缓冲区，最下方全为1的初始地图
        int row = s.nextInt() + 3;
        int col = s.nextInt();
        int[][] map = new int[row][col];
        for (int i = 0; i < map[map.length - 1].length; i++) {
            map[map.length - 1][i] = 1;
        }
        //map[map.length-1][0]=2;
        return map;
    }

    public static int[][] modify(Scanner s, int[][] m) {
        int num = s.nextInt();//块的数量
        for (int i = 0; i < num; i++) {
            char target = s.next().charAt(0);//块的形状
            int position = s.nextInt();//块的最左端的坐标
            int rowIndex = 0;
            {
                if (target == 'I') {//目标块落入了地图
                    label:
                    for (int j = 2; j < m.length; j++) {
                        for (int k = position; k < 4; k++) {
                            if (m[j][k] == 1) {
                                rowIndex = j - 1;
                                break label;
                            }
                        }
                    }
                    for (int j = position; j < position + 4; j++) {
                        m[rowIndex][j] = 1;
                    }
                } else if (target == 'O') {
                    label:
                    for (int j = 2; j < m.length; j++) {
                        for (int k = position; k < position + 2; k++) {
                            if (m[j][k] == 1) {
                                rowIndex = j - 1;
                                break label;
                            }
                        }
                    }
                    for (int j = rowIndex - 1; j <= rowIndex; j++) {
                        for (int k = position; k < position + 2; k++) {
                            m[j][k] = 1;
                        }
                    }
                } else if (target == 'L') {
                    label:
                    for (int j = 2; j < m.length; j++) {
                        for (int k = position; k < position + 2; k++) {
                            if (m[j][k] == 1) {
                                rowIndex = j - 1;
                                break label;
                            }
                        }
                    }
                    m[rowIndex][position] = 1;
                    m[rowIndex][position + 1] = 1;
                    m[rowIndex - 1][position] = 1;
                    m[rowIndex - 2][position] = 1;
                } else if (target == 'J') {
                    l:
                    for (int j = 2; j < m.length; j++) {
                        for (int k = position; k < position + 2; k++) {
                            if (m[j][k] == 1) {
                                rowIndex = j - 1;
                                break l;
                            }
                        }
                    }
                    m[rowIndex][position] = 1;
                    m[rowIndex][position + 1] = 1;
                    m[rowIndex - 1][position + 1] = 1;
                    m[rowIndex - 2][position + 1] = 1;
                } else if (target == 'T') {
                    for (int j = 2; j < m.length; j++) {
                        if (m[j][position] == 1 || m[j + 1][position + 1] == 1 || m[j][position + 2] == 1) {
                            rowIndex = j - 1;
                            break;
                        }
                    }
                    for (int j = position; j < position + 3; j++) {
                        m[rowIndex][j] = 1;
                    }
                    m[rowIndex + 1][position + 1] = 1;
                } else if (target == 'S') {
                    for (int j = 2; j < m.length; j++) {
                        if (m[j][position] == 1 || m[j][position + 1] == 1 || m[j - 1][position + 2] == 1) {
                            rowIndex = j - 1;
                            break;
                        }
                    }
                    m[rowIndex][position] = 1;
                    m[rowIndex][position + 1] = 1;
                    m[rowIndex - 1][position] = 1;
                    m[rowIndex - 1][position + 1] = 1;
                } else if (target == 'Z') {
                    for (int j = 2; j < m.length; j++) {
                        if (m[j][position] == 1 || m[j + 1][position + 1] == 1 || m[j + 1][position + 2] == 1) {
                            rowIndex = j - 1;
                            break;
                        }
                    }
                    m[rowIndex][position] = 1;
                    m[rowIndex][position + 1] = 1;
                    m[rowIndex + 1][position + 1] = 1;
                    m[rowIndex + 1][position + 2] = 1;

                }
            }
            m = eliminate(m);
            if (checkEnd(m)) {//判断是否结束游戏
                return m;
            }
        }
        return m;
    }

    public static int[][] eliminate(int[][] a) {
        int r = 0;//待消去行的行标
        //int[][] b = new int[a.length][a[r].length];//覆盖后的新地图
        for (int i = 2; i < a.length - 1; i++) {//检测
            int count = 0;
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 1) {
                    count++;
                }
            }
            if (count == a[i].length) {
                r = i;
//                for (int k = r + 1; k < a.length-1; k++) {//拷贝待删行下方的地图
//                    for (int l = 0; l < a[k].length; l++) {
//                        a[k][l] = a[k][l];
//                    }
//                }
                for (int k = 1; k < r; k++) {//拷贝待删行上方的地图
                    for (int l = 0; l < a[k].length; l++) {
                        a[k][l] = a[k - 1][l];
                    }
                }
            }
        }
        return a;
    }

    public static boolean checkEnd(int[][] map) {
        int count = -1;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1) {
                    count++;
                }
            }
        }
        return count != -1;
    }

    public static int[][] res(int[][] map) {
        int[][] map2 = new int[map.length - 3][map[1].length];
        for (int i = 0; i < map2.length; i++) {
            for (int j = 0; j < map2[i].length; j++) {
                map2[i][j] = map[i + 2][j];
            }
        }
        return map2;
    }

    public static void printMap(int[][] result) {
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }
}


