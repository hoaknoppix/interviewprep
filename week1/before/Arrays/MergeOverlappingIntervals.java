/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        intervals.sort((x, y) -> (x.start < y.start) ? -1: 1);
        for (int i = 1; i < intervals.size(); i++) {
            Interval previousInterval = intervals.get(i-1);
            Interval interval = intervals.get(i);
            if (previousInterval.end >= interval.start) {
                if (previousInterval.end < interval.end) {
                    previousInterval.end = interval.end;
                }
                intervals.remove(i);
                i--;
            }
        }
        return intervals;
    }
}

