class Solution {
    public int numberOfSubstrings(String s) {
        // n-r as all subsstrings post R contain all 3 at least once
        int freq[] = new int[3];
        int l =0;
        int n = s.length();
        int count = 0;

        for(int r=0; r<n; r++){
            char c = s.charAt(r);
            freq[c-'a']++;
            while(freq[0] > 0 && freq[1]>0 && freq[2]>0){
                count += n-r;
                freq[s.charAt(l++)-'a']--;
            }
        }

        return count;

    }
}