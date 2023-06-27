// Using backtracking and recursion. Choose and not choose.
//Time complexity = O(2^m+n)
//Space Complexity = O(2^m+n)-- I've doubt regarding this
// Worked well in Leetcode.

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //doing by recursion, extensive solution
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(candidates,0,target,path, result);
        return result;
    }

    private void helper(int[] candidates, int idx, int target,
                        List<Integer> path , List<List<Integer>> result){
        //base
        if(idx==candidates.length || target<0)return;
        if(target==0){
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        //not choose
        helper(candidates,idx+1, target,path,result);
        //choose
        //action
        path.add(candidates[idx]);
        //recurse
        helper(candidates,idx, target-candidates[idx],path,result);
        //backtrack
        // System.out.println(path);
        path.remove(path.size() - 1);
        // System.out.println(path);
    }

}