class Solution {
    public int reachNumber(int target) {
    
        long t = Math.abs(target);

        long steps = (long)(Math.ceil((-1 + Math.sqrt(1 + 8*t))/ 2.0));
        long i = steps+1;
        long total = (steps*steps + steps)/2;
        while((total-t)%2 != 0){
            total+=i;
            steps++;
            i++;
        }
        return  (int)(steps);
    
    }
}