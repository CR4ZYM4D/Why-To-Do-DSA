class Solution {

    int count = 0;

    public int findOverlaps(int[][] img1, int[][] img2, int n, int rowOffset, int colOffset){
        count = 0;
        for(int i1=0; i1<n; i1++){
            
            int i2 = i1+rowOffset;
            
            for(int j1=0; j1<n; j1++){
                
                int j2 = j1+colOffset;
                
                if(i2<0 || i2>=n || j2<0 || j2>=n)
                    continue;
        
                if(img1[i1][j1]==1 && img2[i2][j2]==1)
                    count++;
            }
        }
        return count;
    }

    public int largestOverlap(int[][] img1, int[][] img2) {
        
        // we can assume 1 image to be fixed and the other to be moving
        // the image offset moves from -(n-1) to n-1 with -n+1 
        // being the right/bottom most possible overlaps and the left/top
        // most having offsets n-1 this allow us to get the row and column
        // indexes of moving grid as row+rowOffset and col+colOffset
        int n = img1.length;
        int maxCount=0;
        int c=0;
        for(int i=-n+1; i<=n-1; i++){
            for(int j=-n+1; j<=n-1; j++){
                c= findOverlaps(img1, img2, n, i, j);
                maxCount = Math.max(c, maxCount);
            }
        }

        return maxCount;

    }
}