package com.hzy.algorithm.recursion;

/**
 * 在给定的地图上寻找路径问题
 * 使用递归方案解决
 * 初始的边界 均使用1 表示
 * 正常通过的路径 使用 2 表示
 * 已走过的不通的路径 使用 3 表示
 * 其中指定探路 策略为 下-》右-》上-》左
 */
public class MazeToFindRoute {

    public static void main(String[] args) {
        int[][] map = new int[8][8];
        // 绘制上下左右边界
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][7] = 1;
            map[0][i] = 1;
            map[7][i] = 1;
        }
        // 绘制障碍点
        map[3][1] = 1;
        map[3][2] = 1;
        map[3][3] = 1;
        findRoute(map, 4, 1);
        printMap(map);
    }

    /**
     * 查找路径方法，传入地图，和起始位置坐标
     *
     * @param map 地图
     * @param x   横坐标
     * @param y   数座标
     * @return 成功路径返回 true 失败返回false
     */
    public static boolean findRoute(int[][] map, int x, int y) {
        // 如果最后终点位置已经设置为通过，则直接返回true
        if (map[6][6] == 2) {
            return true;
        } else {
            // 如果当前位置已经标记为非通路，直接返回
            if (map[x][y] != 0){
                return false;
            }
            // 先设置当前位置为2通过
            map[x][y] = 2;
            // 尝试向四周移动
            if (findRoute(map, x + 1, y)) {
                // 向下移动
                return true;
            } else if (findRoute(map, x, y + 1)) {
                // 向右移动
                return true;
            } else if (findRoute(map, x - 1, y)) {
                // 向上移动
                return true;
            } else if (findRoute(map, x, y - 1)) {
                // 向左移动
                return true;
            } else {
                // 上下左右都走不通，返回false，同时将该点设置为死路 3
                map[x][y] = 3;
                return false;
            }
        }
    }

    /**
     * 打印地图
     */
    public static void printMap(int[][] map) {
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt + "  ");
            }
            System.out.println();
        }
    }


}
