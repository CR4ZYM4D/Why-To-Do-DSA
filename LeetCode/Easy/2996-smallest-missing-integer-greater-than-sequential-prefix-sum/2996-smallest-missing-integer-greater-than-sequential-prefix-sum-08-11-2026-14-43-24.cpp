class Solution {
public:
    int missingInteger(vector<int>& nums) {

        set<int> contains(nums.begin(), nums.end());
        int prev = nums[0];
        int sum = prev;

        for(int i=1; i<nums.size(); i++){
            if(nums[i]-prev == 1){
                sum += nums[i];
                prev = nums[i];
            }
            else break;
        }

        while(contains.find(sum) != contains.end()) sum++;

        return sum;

    }
};