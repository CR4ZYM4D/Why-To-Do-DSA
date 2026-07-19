class Solution {
    public String smallestSubsequence(String s) {

        // we store the number of occurence of each character in an array
        int occ[] = new int[26];
        char c;
        char z='a';
        int idx = 0;
        
        for(int i=0; i<s.length(); i++)
            occ[s.charAt(i)-97]++;

        StringBuilder sb = new StringBuilder("");


        for(int i=0; i<s.length(); i++){
            c = s.charAt(i);
            occ[c-97]--;

            // if a character has already been added to the list and it re-occurs skip
            if(sb.indexOf(Character.toString(c)) != -1) continue;
            
            idx = sb.length()-1;

            // if a character has no further occurences left then we fix it there
            // if it has then we pop all such charcaters from end index onwards
            // which appear later in the alphabet and still have at least 1
            // occurence left
            if(idx > -1)
            z = sb.charAt(idx);
            
            while(idx>-1 && c < z && occ[z-97] >= 1){
                sb.deleteCharAt(idx);
                idx--;
                if(idx>-1) z = sb.charAt(idx);
            }
            sb.append(c);
        }

        return sb.toString();
        
    }
}