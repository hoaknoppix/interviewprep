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
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int updatedIntervalEnd = -1;
        if (newInterval.end == newInterval.start) {
            if (intervals.size() == 0) {
                intervals.add(newInterval);
            }
            return intervals;
        }
        if (newInterval.end < newInterval.start) {
            int temp = newInterval.end;
            newInterval.end = newInterval.start;
            newInterval.start = temp;
        }
        int n = intervals.size() - 1;
        for (int i = 0; i <= n; ++i) {
            Interval interval = intervals.get(i);
            if (updatedIntervalEnd == -1 && newInterval.end < interval.start) {
                intervals.add(i, newInterval);
                break;
            }
            if (updatedIntervalEnd > -1) {
                Interval previousInterval = intervals.get(i-1);
                if (previousInterval.end < interval.start) {
                    return intervals;
                }
                if (previousInterval.end < interval.end) {
                    previousInterval.end = interval.end;
                    updatedIntervalEnd = interval.end;
                }
                intervals.remove(i);
                --i;
                --n;
                continue;
            }
            if (interval.start > newInterval.start) {
                if (interval.end < newInterval.end) {
                    interval.end = newInterval.end;
                    interval.start = newInterval.start;
                    updatedIntervalEnd = interval.end;
                }
                if (interval.start > newInterval.start) {
                    interval.start = newInterval.start;
                    break;
                }
                continue;
            }
            if (newInterval.end <= interval.end) {
                return intervals;
            }
            if (interval.end < newInterval.start) {
                if (i == n) {
                    intervals.add(newInterval);
                    break;
                }
                continue;
            }
            if (interval.end >= newInterval.start) {
                interval.end = newInterval.end;
                updatedIntervalEnd = interval.end;
            }
        }
        return intervals;
    }
}

