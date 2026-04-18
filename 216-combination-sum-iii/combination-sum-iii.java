class Solution {
    public void generate(int i, int nums[], int k, int n, List<List<Integer>> list,  List<Integer> store, int size, int sum){
        if(i == nums.length){
            if(size == k && n == sum){
                list.add(new ArrayList<>(store));
            }
            return;
        }
        // taking current element.
        if(nums[i] <= n && sum <= n){
            store.add(nums[i]);
            generate(i+1, nums, k, n, list, store, size + 1, sum+nums[i]);
            store.remove(store.size()-1);
        }
        // not taking the current value. 
        generate(i+1, nums, k, n, list, store, size, sum);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        int arr[] = new int[9];
        for(int i = 0; i < 9; i++){
            arr[i] = i+1;
        }

        List<Integer> store = new ArrayList<>();
        int size = 0;
        int sum = 0;
        generate(0, arr, k, n, list, store, size, sum);
        return list;
    }
}