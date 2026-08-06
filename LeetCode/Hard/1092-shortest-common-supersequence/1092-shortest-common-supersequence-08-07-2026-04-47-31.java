class Solution {

    public int[][] buildLCS(String s1, String s2){
        
        int l1 = s1.length();
        int l2 = s2.length();

        int res[][] = new int[l1+1][l2+1];

        for(int i=1; i<=l1; i++){
            for(int j=1; j<=l2; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    res[i][j] = res[i-1][j-1]+1;
                }
                else res[i][j] = Math.max(res[i-1][j], res[i][j-1]);
            }
        }
        return res;

    }

    public String shortestCommonSupersequence(String str1, String str2) {
        
        int matrix[][] = buildLCS(str1, str2);
        StringBuilder sb = new StringBuilder("");

        int n1 = matrix.length-1;
        int l1 = n1;
        int n2 = matrix[0].length-1;
        int l2 = n2;

        while(n1 > 0 && n2>0){


                if(str1.charAt(n1-1) == str2.charAt(n2-1)){
                    sb.insert(0, str1.charAt(n1-1));
                    n1--;
                    n2--;
                    l1--;
                    l2--;
                }

                else if(matrix[n1-1][n2] > matrix[n1][n2-1]){
                    sb.insert(0, str1.charAt(--n1));
                    l1--;
                }

                else{
                    sb.insert(0, str2.charAt(--n2));
                    l2--;
                }

            
        } 

        sb.insert(0, str1.substring(0, l1));
        sb.insert(0, str2.substring(0, l2));
        return sb.toString();
    }
}