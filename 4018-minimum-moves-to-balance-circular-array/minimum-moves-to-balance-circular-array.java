class Solution {
    public long minMoves(int[] arr) {
        int n = arr.length;
        long moves = 0;
        int negIdx = -1;
        long total = 0;

        // Calculate total balance and find the index with negative balance (only one possible)
        for (int i = 0; i < n; i++) {
            total += arr[i];
            if (arr[i] < 0) {
                negIdx = i;
            }
        }

        // If total balance is negative, it is impossible to make all balances non-negative
        if (total < 0) return -1;

        // If there is no negative balance, no moves are needed
        if (negIdx == -1) return 0;

        // Distance from the negative index; we expand outward step by step
        int d = 1;

        // Keep fixing the negative balance until it becomes non-negative
        while (arr[negIdx] < 0) {

            // Find left and right neighbors at distance d (circular array)
            int prev = (negIdx - d % n + n) % n;
            int next = (negIdx + d) % n;

            // Total balance available at this distance
            long available = arr[prev] + arr[next];

            // Transfer only what is needed or what is available (minimum of both)
            long transfer = Math.min(-arr[negIdx], available);

            // Each unit transferred from distance d costs d moves
            moves += transfer * d;

            // Update the negative balance after transfer
            arr[negIdx] += transfer;

            // Move to the next farther distance
            d++;
        }

        return moves;
    }
}
