/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.size()==0){
            return 0;
        }
        Collections.sort(intervals,(a,b)->Integer.compare(a.start,b.start));
        List<Integer> endTimes = new ArrayList<>();
        endTimes.add(intervals.get(0).end);

        for(int i=1;i<intervals.size();i++){
            int j=0;
            while(j<endTimes.size()){
                if(intervals.get(i).start>=endTimes.get(j)){
                    endTimes.set(j,intervals.get(i).end);
                    break;
                }
                j++;
            }
            if(j==endTimes.size()){
                endTimes.add(intervals.get(i).end);
            }
        }

        return endTimes.size();
    }
}
