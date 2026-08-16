class Solution {
    public int reachNumber(int target) {
    
        long t = Math.abs(target);
        int steps = (int)(Math.ceil((-1 + Math.sqrt(1 + 8*t))/ 2.0));
        int i = steps+1;
        long total = (steps*steps + steps)/2;
        while((total-t)%2 != 0){
            total+=i;
            steps++;
            i++;
        }
        return  steps;
    
    }
}