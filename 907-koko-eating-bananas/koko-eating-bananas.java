class Solution {
    public int findMaxi(int piles[]){
        int maxi = Integer.MIN_VALUE;

        for(int i = 0; i < piles.length; i++){
            maxi = Math.max(piles[i], maxi);
        }

        return maxi;
    }

    public int findHours(int piles[], int hourly){
        
        int totalHours = 0;
        for(int i = 0; i < piles.length; i++){
            totalHours += Math.ceil((double)piles[i] / hourly);
        }

        return totalHours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int maxi = findMaxi(piles);

        int ans = -1;
        int low = 1;
        int high = maxi;
        while(low <= high){
            int mid = low + (high - low) / 2;

            if(findHours(piles, mid) <= h){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return ans;
    }
}