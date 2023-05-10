package day39.demo1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/5/10 15:19
 */
public class demo1 {
    List<String> result = new ArrayList<>();
    StringBuilder stringBuilder = new StringBuilder();

    public List<String> binaryTreePaths1(TreeNode root) {

        backtracking(root);
        return result;
    }

    public void backtracking(TreeNode root) {
        if (root == null) {
            return;
        }

        int length = stringBuilder.length();
        stringBuilder.append(root.val);

        if (root.left == null && root.right == null) {
            result.add(stringBuilder.toString());
        }

        stringBuilder.append("->");
        backtracking(root.left);
        backtracking(root.right);

        stringBuilder.delete(length, stringBuilder.length());
    }


    public List<String> binaryTreePaths(TreeNode root) {

        find("", root);
        return result;
    }

    public void find(String path, TreeNode root) {
        if (root == null) return;
        path = path + root.val;

        if (root.left == null && root.right == null) {
            result.add(path);
        }

        find(path + "->", root.left);
        find(path + "->", root.right);
    }
}

