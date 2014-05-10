/*
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
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
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		if (null == intervals || intervals.size() <= 1) return intervals;
		Interval tmp = intervals.get(0);
		Interval pivot = new Interval(Integer.MAX_VALUE, Integer.MAX_VALUE);
		intervals.add(pivot);
		ArrayList<Interval> rst = new ArrayList<Interval>();
		Interval iel;
		for (int i = 1; i < intervals.size(); i++) {
			iel = intervals.get(i);
			if (tmp.end < iel.start || tmp.start > iel.end) {
				rst.add(tmp);
				tmp = iel;
			} else {
				if (tmp.end <= iel.end) {
					if (tmp.start > iel.start) {
						tmp.start = iel.start;
					}
					tmp.end = iel.end;
				} else {
					if (tmp.start <= iel.end) {
						if (tmp.start >= iel.start) {
							tmp.start = iel.start;
						}
					}
				}
			}
		}
		return rst;
	}
}