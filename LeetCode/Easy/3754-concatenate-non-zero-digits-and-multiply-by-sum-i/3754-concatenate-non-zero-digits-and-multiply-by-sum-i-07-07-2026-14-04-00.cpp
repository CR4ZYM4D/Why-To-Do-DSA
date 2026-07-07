class Solution {
public:
    long long sumAndMultiply(int n) {
        string s = to_string(n);
        long long x = 0;
        long long sum = 0;
        for(int i=0; i<s.size(); i++){
            int d = s[i] - '0';

            if(d>0){x*=10;
            x+=d;
            sum+=d;}
        }
        return x*sum;
    }
};