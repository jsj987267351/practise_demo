package month05.day10.demo1;

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

        backtracking1(root);
        return result;
    }

    public void backtracking1(TreeNode root) {
        if (root == null) {
            return;
        }

        int length = stringBuilder.length();
        stringBuilder.append(root.val);

        if (root.left == null && root.right == null) {
            result.add(stringBuilder.toString());
        }

        stringBuilder.append("->");
        backtracking1(root.left);
        backtracking1(root.right);

        stringBuilder.delete(length, stringBuilder.length());
    }


    public List<String> binaryTreePaths2(TreeNode root) {

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

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtracking(res,list,root);
        return res;
    }

    public void backtracking(List<String> res,List<Integer> list,TreeNode root){
        list.add(root.val);
        if (root.left ==null && root.right ==null){
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < list.size()-1; i++) {
                stringBuilder.append(list.get(i)).append("->");
            }
            stringBuilder.append(list.get(list.size()-1));
            res.add(stringBuilder.toString());
            return;
        }
        if (root.left!=null){
            backtracking(res,list,root.left);
            list.remove(list.size()-1);
        }
        if (root.right!=null){
            backtracking(res,list,root.right);
            list.remove(list.size()-1);
        }
    }
}

