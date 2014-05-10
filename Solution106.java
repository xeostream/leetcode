/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
*/
/*
class Interval {
	int start;
	int end;
	Interval() {start = 0, end = 0;}
	Interval(int s, int e) {start = s; end = e;}
}
*/
public class Solution {
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		if (null == newInterval || newInterval.start > newInterval.end) return intervals;
        if (intervals.size()==0) {
            intervals.add(newInterval);
            return intervals;
        }
        int cnt = 0;
        for (Interval inter : intervals) {
            if (newInterval.end < inter.start) break;
            else {
                if (newInterval.end <= inter.end) {
                    if (newInterval.start > inter.start) {
                        newInterval.start = inter.start;
                    }
                    newInterval.end = inter.end;
                    cnt++;
                } else {
                    if (newInterval.start <= inter.end) {
                        if (newInterval.start >= inter.start) {
                            newInterval.start = inter.start;
                        }
                        cnt++;
                    }
                }
            }
        }
        if (cnt == 0) {
            if (newInterval.start > intervals.get(intervals.size()-1).end) {
                intervals.add(newInterval);
                return intervals;
            }
            if (newInterval.end < intervals.get(0).start) {
                intervals.add(0, newInterval);
                return intervals;
            }
            int i = 0;
            for (; i < intervals.size(); i++) {
                if (newInterval.end < intervals.get(i).start) {
                    break;
                }
            }
            intervals.add(i, newInterval);
            return intervals;
        } else {
            ArrayList<Interval> rst = new ArrayList<Interval>();
            int i = 0;
            for (; i < intervals.size(); i++) {
                if (newInterval.start > intervals.get(i).end) {
                    rst.add(intervals.get(i));
                } else if (newInterval.end < intervals.get(i).start) {
                    break;
                }
            }
            rst.add(newInterval);
            for (; i < intervals.size(); i++) {
                rst.add(intervals.get(i));
            }
            return rst;
        }
	}
}