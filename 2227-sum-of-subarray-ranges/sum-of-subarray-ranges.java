class Solution {

    // Next Smaller Element
    public void nse(int arr[], int ans[]) {
        Stack<Integer> st = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            ans[i] = st.isEmpty() ? arr.length : st.peek();
            st.push(i);
        }
    }

    // Previous Smaller or Equal Element
    public void psee(int arr[], int ans[]) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
    }

    // Sum of Subarray Minimums (NO MOD)
    public long sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int next[] = new int[n];
        int prev[] = new int[n];

        nse(arr, next);
        psee(arr, prev);

        long sum = 0;

        for (int i = 0; i < n; i++) {
            long left = i - prev[i];
            long right = next[i] - i;
            sum += (long) arr[i] * left * right;
        }

        return sum;
    }

    // Next Greater Element
    public void nge(int arr[], int ans[]) {
        Stack<Integer> st = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }

            ans[i] = st.isEmpty() ? arr.length : st.peek();
            st.push(i);
        }
    }

    // Previous Greater or Equal Element
    public void pgee(int arr[], int ans[]) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }

            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
    }

    // Sum of Subarray Maximums (NO MOD)
    public long sumSubarrayMax(int[] arr) {
        int n = arr.length;
        int next[] = new int[n];
        int prev[] = new int[n];

        nge(arr, next);
        pgee(arr, prev);

        long sum = 0;

        for (int i = 0; i < n; i++) {
            long left = i - prev[i];
            long right = next[i] - i;
            sum += (long) arr[i] * left * right;
        }

        return sum;
    }

    // Final answer
    public long subArrayRanges(int[] nums) {
        return sumSubarrayMax(nums) - sumSubarrayMins(nums);
    }
}
