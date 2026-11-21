class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> ans = new ArrayList<>();
        boolean calculating = false;
        boolean inserted = false;
        
        for(int[] interval : intervals){
            if(interval[1]<newInterval[0] || interval[0]>newInterval[1]){
                if(calculating){
                    ans.add(newInterval);
                    calculating=false;
                    inserted=true;
                }
                if(!inserted && interval[0] > newInterval[1]){
                    ans.add(newInterval);
                    inserted = true;
                }
                ans.add(interval);   
            }else{
                calculating=true;
                newInterval[0]=Math.min(newInterval[0],interval[0]);
                newInterval[1]=Math.max(newInterval[1],interval[1]);    
            }
        }

        if(calculating){
            ans.add(newInterval);
            inserted=true;
        }

        if(!inserted){
            ans.add(newInterval);
        }

        return ans.toArray(new int[ans.size()][]);                     
    }
}
