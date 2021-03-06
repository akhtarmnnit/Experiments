/* Java program to demonstrate how to implement static and non-static
 classes in a java program. */
class OuterClass {
	private static String msg = "GeeksForGeeks";
	static int i;

	// Static nested class
	public static class NestedStaticClass {

		// Only static members of Outer class is directly accessible in nested
		// static class
		public void printMessage() {
			i++;
			// Try making 'message' a non-static variable, there will be
			// compiler error
			System.out.println("Message from nested static class: " + msg);
		}
	}

	// non-static nested class - also called Inner class
	public class InnerClass {

		// Both static and non-static members of Outer class are accessible in
		// this Inner class
		public void display() {
			i++;
			System.out.println("Message from non-static nested class: " + msg);
		}
	}
}