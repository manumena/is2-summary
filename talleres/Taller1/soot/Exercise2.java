public class Exercise2 {
	public int exercise2(int a, int b) {
		int c = a + b;
		int d = a - b;
		int r;
		if (a < c) {
			r = c;
		} else {
			r = d;
		}
		return r;
	}
}