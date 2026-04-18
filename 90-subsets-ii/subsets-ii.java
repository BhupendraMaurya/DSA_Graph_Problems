class Solution {
    public void generate(int i, int nums[], List<Integer> list, HashSet<List<Integer>> set){
        if(i == nums.length){
            set.add(new ArrayList<>(list));
            return;
        }

        generate(i+1, nums, list, set);
        list.add(nums[i]);
        generate(i+1, nums, list, set);
        list.remove(list.size()-1);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        generate(0, nums, list, set);

        List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> curr : set){
            ans.add(curr);
        }
        return ans;
    }
}