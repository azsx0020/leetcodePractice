给定一棵树的前序遍历preorder 与中序遍历 inorder。请构造二叉树并返回其根节点。



**示例 1:**

```
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
```
**示例 2:**
```
Input: preorder = [-1], inorder = [-1]
Output: [-1]
```

**提示:**

* 1 <= preorder.length <= 3000
* inorder.length == preorder.length
* -3000 <= preorder[i], inorder[i] <= 3000
* preorder和inorder均无重复元素
* inorder均出现在preorder
* preorder保证为二叉树的前序遍历序列
* inorder保证为二叉树的中序遍历序列

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。