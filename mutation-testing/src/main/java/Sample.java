//package test;

public class Sample {
	public int Power(int x, int y) {
		if (x == 1) {
			return 1;
		}
		if (y == 1) {
			return x;
		}
		int p = 1;
		int i = 1;
		while (i <= y) {
			p = p * x;
			i = i + 1;
		}
		return p;
	}
}
