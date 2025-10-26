class Solution {
    public boolean lemonadeChange(int[] bills) {
        int countOfFive = 0;
        int countOfTen = 0;

        for(int i = 0; i < bills.length; i++){
            if(bills[i] == 5){
                countOfFive++;
            }
            else if(bills[i] == 10){
                countOfTen++;
                if(countOfFive > 0){
                    countOfFive--;
                }
                else{
                    return false;
                }
            }
            else{
                if(countOfTen > 0 && countOfFive > 0){
                    countOfTen--;
                    countOfFive--;
                }
                else if(countOfFive > 2){
                    countOfFive -= 3;
                }
                else{
                    return false;
                }
            }
        }

        return true;
    }
}