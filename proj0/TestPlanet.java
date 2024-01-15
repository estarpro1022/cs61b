public class TestPlanet {
    public static void main(String[] args) {
        Planet a = new Planet(1, 2, 3, 4, 10, "hello.jpg");
        Planet b = new Planet(5, 4, 8, 10, 20, "clock.jpg");
        checkForce(6.67e-10, a.calcForceExertedBy(b), 0.01);
    }

    private static void checkForce(double expect, double actual, double eps) {
        double tolerance = (Math.abs(expect) + Math.abs(actual)) / 2 * eps;
        if (Math.abs(expect - actual) < tolerance) {
            System.out.println("PASS: expect: " + expect + " actual: " + actual);
        } else {
            System.out.println("FAIL: expect: " + expect + " actual: " + actual);
        }
    }
}
