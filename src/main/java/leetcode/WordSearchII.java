package leetcode;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {

    class Node {
        char ch;
        Node[] children;
        boolean isEOW;

        Node(char ch) {
            this.ch = ch;
            children = new Node[26];
            isEOW = false;
        }
    }

    Node root;

    public void add(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            if (curr.children[word.charAt(i) - 'a'] == null)
                curr.children[word.charAt(i) - 'a'] = new Node(word.charAt(i));
            curr = curr.children[word.charAt(i) - 'a'];
        }
        curr.isEOW = true;
    }

    List<String> ans;
    int r, c;

    public void recur(char[][] board, Node curr, int x, int y, String path) {
        if (x < 0 || x >= r || y < 0 || y >= c || board[x][y] == ' ') return;
        char c = board[x][y];
        if (curr.children[c - 'a'] == null) return;
        if (curr.children[c - 'a'].isEOW) ans.add(path + c);
        board[x][y] = ' ';
        recur(board, curr.children[c - 'a'], x + 1, y, path + c);
        recur(board, curr.children[c - 'a'], x, y + 1, path + c);
        recur(board, curr.children[c - 'a'], x, y - 1, path + c);
        recur(board, curr.children[c - 'a'], x - 1, y, path + c);
        board[x][y] = c;
    }

    public List<String> findWords(char[][] board, String[] words) {
        root = new Node('#');
        ans = new ArrayList<>();
        r = board.length;
        c = board[0].length;
        for (String word : words) add(word);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++)
                recur(board, root, i, j, "");
        }
        return ans;
    }

    public static void main(String[] args) {
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.println(new WordSearchII().findWords(board, words));

    }
}
