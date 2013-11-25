import java.util.HashSet;

/*
 * Max Points on a Line
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 */
public class Solution64 {
	static class Point {
		int x;
		int y;
		Point() { x = 0; y = 0; }
		Point(int a, int b) {
			x = a;
			y = b;
		}
	}
	//aX+bY+Z = 0
	static class Line {
		int x;
		int y;
		int z;
		Line(int a, int b, int c) {
			x = a;
			y = b;
			z = c;
		}
		@Override
		public boolean equals(Object o) {
			if (o == null) return false;
			if (o == this) return true;
			if (o instanceof Line) {
				Line l = (Line) o;
				if (x == l.x && y == l.y && z == l.z)
					return true;
				else
					return false;
			} else
				return false;
		}
		
		@Override
		public int hashCode() {
			final int PRIME = 31;
			int result = 1;
			result = (((PRIME * result + x) * PRIME) + y) * PRIME + z;
			return result;
		}
	}
	
	public int gcd(int x, int y) {
		if (y == 0) return x;
		return gcd(y, x % y);
	}
	public int maxPoints(Point[] points) {
		if (points == null) return 0;
		if (points.length <= 2) return points.length;
		HashSet<Line> record = new HashSet<Line>();
		int cnt = 2, len = points.length;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (j == i) continue;
				Point p1 = points[i], p2 = points[j];
				int a = p1.y - p2.y, b = p2.x - p1.x;
				int c = -b * p1.y - a * p1.x;
				if (a == 0 && b == 0 && c == 0) continue;
				if (a != 0 || b != 0 || c != 0) {
					int temp = gcd(Math.abs(a), Math.abs(b));
					temp = gcd(Math.abs(c), temp);
					a /= temp;
					b /= temp;
					c /= temp;
				}
				if (a < 0) {
					a = -a;
					b = -b;
					c = -c;
				} else if (a == 0 && b < 0) {
					b = -b;
					c = -c;
				} else if (a == 0 && b == 0 && c < 0)
					c = -c;
				Line l = new Line(a, b, c);
				record.add(l);
			}
		}
		if (record.isEmpty()) return len;
		for (Line l : record) {
			int temp = 0;
			for (Point p : points) {
				if (p.x*l.x+p.y*l.y+l.z == 0)
					temp++;
			}
			if (cnt < temp)
				cnt = temp;
		}
		return cnt;
	}
	
	public static void main(String ...args) {
		Solution64 s64 = new Solution64();
		Point p1 = new Point();
		Point p2 = new Point(84,250);
		Point p3 = new Point(1,0);
		Point p4 = new Point(0,-70);
		Point p5 = new Point(0,-70);
		Point p6 = new Point(1,-1);
		Point p7 = new Point(21, 10);
		Point p8 = new Point(42, 90);
		Point p9 = new Point(-42, -230);
		Point[] points = {p1, p2, p3, p4, p5, p6, p7, p8, p9};
		System.out.println(s64.maxPoints(points));
	}
}
