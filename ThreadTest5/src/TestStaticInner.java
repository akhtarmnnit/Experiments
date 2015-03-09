public class TestStaticInner {
	int i;
	static int j;

	class TestInner {
		int inner;

		void mymethod() {
			i = 3;
			j = 4;
		}
	}

	void check() {
		TestInner ob = new TestInner();
		ob.inner = 5;
	}
}
