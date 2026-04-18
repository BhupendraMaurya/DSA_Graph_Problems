class Solution {
    public void generate(int i, int k, int n, List<List<Integer>> list,  List<Integer> store, int size, int sum){
        if(i == 10){
            if(size == k && n == sum){
                list.add(new ArrayList<>(store));
            }
            return;
        }
        // taking current element.
        if(i <= n && sum <= n){
            store.add(i);
            generate(i+1, k, n, list, store, size + 1, sum+i);
            store.remove(store.size()-1);
        }
        // not taking the current value. 
        generate(i+1, k, n, list, store, size, sum);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();

        List<Integer> store = new ArrayList<>();
        int size = 0;
        int sum = 0;
        generate(1, k, n, list, store, size, sum);
        return list;
    }
}