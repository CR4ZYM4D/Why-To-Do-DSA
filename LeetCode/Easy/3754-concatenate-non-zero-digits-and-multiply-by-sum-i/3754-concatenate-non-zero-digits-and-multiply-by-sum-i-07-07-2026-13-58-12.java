class Solution {
    public long sumAndMultiply(int n) {

        String s = String.valueOf(n);
        long x =0;
        long sum = 0;
        for(int i=0; i<s.length();i++){
            long c =s.charAt(i) -48;
            if(c>=1){
                x = x*10 + c;
                sum+=c;
            }
        }

        return (x*sum);
        
    }
}