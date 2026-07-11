class Solution {
    public int minimumTotal(List<List<Integer>> list) {
        
        int n = list.size();
        
        for(int i=n-2; i>-1; i--){
            int s = list.get(i).size();
            for(int j=0; j<s; j++){
                int og = list.get(i).get(j);
                int bottom = list.get(i+1).get(j);
                int diag = list.get(i+1).get(j+1);
                list.get(i).set(j, og + Math.min(diag, bottom));
            }
        }

        return list.get(0).get(0);
    }
}