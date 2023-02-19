/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) 
    {
        List<List<Integer>> list = new ArrayList();
        if(root==null)
            return list;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int flag = 0;
        while(!queue.isEmpty())
        {
            int sz = queue.size();
            ArrayList<Integer> alist = new ArrayList<>();
            if(flag == 0)
            {
                for(int i=0;i<sz;i++)
                {
                    TreeNode temp = queue.poll();
                    alist.add(temp.val);
                    if(temp.left != null)
                        queue.add(temp.left);
                    if(temp.right != null)
                        queue.add(temp.right);
                    
                }
                
                list.add(alist);
                //alist.clear();
                flag=1;
            }
            else if(flag==1)
            {
                for(int i=0;i<sz;i++)
                {
                    TreeNode temp = queue.poll();
                    alist.add(temp.val);
                    if(temp.left != null)
                        queue.add(temp.left);
                    if(temp.right != null)
                        queue.add(temp.right);
                    
                }
                Collections.reverse(alist);
                list.add(alist);
                //alist.clear();
                flag=0;
            }
            
        }
        return list;
    }
}