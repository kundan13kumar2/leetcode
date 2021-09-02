package leetcode;

public class DungeonGame {

    class Node {
        int s;
        int f;

        public Node(int s, int f) {
            this.s = s;
            this.f = f;
        }
    }


    public int calculateMinimumHP(int[][] dungeon) {
        Node[][] nodes = new Node[dungeon.length][dungeon[0].length];
        int r = dungeon.length - 1;
        int c = dungeon[0].length - 1;
        for (int i = r; i >= 0; i--) {
            for (int j = c; j >= 0; j--) {
                int f = 1;
                int s = 1;
                int delta = dungeon[i][j];
                if (i == r && j == c) {
                    f = Math.max(1, 1 + delta);
                    s = Math.max(1, f - delta);

                } else if (i == r) {
                    Node node = nodes[i][j + 1];
                    f = node.s;
                    s = Math.max(1, f - delta);

                } else if (j == c) {
                    Node node = nodes[i + 1][j];
                    f = node.s;
                    s = Math.max(1, f - delta);

                } else {
                    f = 1;
                    if (nodes[i + 1][j].s < nodes[i][j + 1].s)
                        f = nodes[i + 1][j].s;
                    else
                        f = nodes[i][j + 1].s;
                    s = Math.max(1, f - delta);
                }
                nodes[i][j] = new Node(s, f);
            }
        }
        return nodes[0][0].s;
    }

    public static void main(String[] args) {
        int[][] dungeon = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        //int[][] dungeon = {{1000, 433, -142}, {200, -12, -42}, {654, -534, 42}, {123, 53, -234}, {123, -123, 32}, {-12, 43, -534}, {123, 53, -234}, {345, -234, 544}};
        //int[][] dungeon = {{-100}};
//        for (int i = 0; i < dungeon.length; i++)
//            for (int j = 0; j < dungeon[0].length; j++)
//                dungeon[i][j] *= -1;
        DungeonGame dg = new DungeonGame();
        System.out.println(dg.calculateMinimumHP(dungeon));
    }
}
