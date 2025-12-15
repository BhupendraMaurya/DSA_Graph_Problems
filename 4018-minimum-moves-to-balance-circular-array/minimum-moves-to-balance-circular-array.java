class Solution {
    public long minMoves(int[] arr) {
        int n = arr.length;
        long moves = 0;
        int negIdx = -1;
        long total = 0;

        for (int i = 0; i < n; i++) {
            total += arr[i];
            if (arr[i] < 0) {
                negIdx = i;
            }
        }

        if (total < 0) return -1;
        if (negIdx == -1) return 0;

        // distance from negative idx
        int d = 1;
        while(arr[negIdx] < 0){
            // finding the prev and next element of current (negative) element,
            // basically, going to left and right at equal pace.
            int prev = (negIdx - d%n + n)%n;
            int next = (negIdx + d)%n;

            // summation of prev and next element.
            long sum = arr[prev] + arr[next];

            // Finding that how much we have to transfer from current summation,
            long transfer = Math.min((-1)*arr[negIdx], sum);

            // whatever you have transfered, simply add that in the total moves.
            moves += transfer * d;

            // updating the negative element by adding that element by which u increased your moves.
            arr[negIdx] += transfer;

            d++;
        }

        return moves;
    }
}
