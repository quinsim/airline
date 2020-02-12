package hw4.test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Provides utilities that are helpful when writing tests.
 */
public class Tests {
    /**
     * Runs all of the test methods in the class with the specified name. A
     * method is considered to be a test method if it is named starting with
     * "test", takes no parameters, and is static.
     *
     * @param className The name of the class that defines the test methods
     *                  to execute.
     */
    public static void runAllTests(String className) {
        try {
            runAllTests(Class.forName(className));
        } catch (ClassNotFoundException e) {
            // this happens when the JVM can't find the class with the
            // specified name.
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Runs all of the test methods in the specified class. A method is
     * considered to be a test method if it is named starting with "test",
     * takes no parameters, and is static.
     *
     * @param testClass The {@link Class} that defines the test methods to
     *                  execute.
     */
    public static void runAllTests(Class testClass) {
        Method[] methods = testClass.getDeclaredMethods();
        for(Method method : methods) {
            if(method.getName().startsWith("test") &&
                   Modifier.isStatic(method.getModifiers()) &&
                    method.getParameterCount() == 0) {
                try {
                    System.out.println("Running test '" +
                            testClass.getName() + "." + method.getName() +
                            "'");
                    method.invoke(null, null);
                } catch(Throwable e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }
        System.out.println("All tests passed!");
    }

    /**
     * Asserts that the expected and actual values are equal to each other.
     * This is true iff both are null, or if expected.equals(actual) is true.
     *
     * @param expected The expected value (may be null).
     * @param actual The actual value (may be null).
     */
    public static void assertEquals(Object expected, Object actual) {
        assertEquals(expected, actual, null);
    }

    /**
     * Asserts that the expected and actual values are equal to each other.
     * This is true iff both are null, or if expected.equals(actual) is true.
     *
     * @param expected The expected value (may be null).
     * @param actual The actual value (may be null).
     * @param errorMessage An additional error message (may be null).
     */
    public static void assertEquals(Object expected, Object actual,
                                    String errorMessage) {
        if(!checkEquals(expected, actual)) {
            String output = "Assert Equals failed!" +
                    "\nexpected: >" + expected + "<" +
                    "\nactual:   >" + actual + "<";
            output = errorMessage != null ?
                    output + "\n" + errorMessage : output;
            throw new AssertionError(output);
        }
    }

    /**
     * Asserts that the expected and actual values are not equal to each other.
     *
     * @param expected The expected value (may be null).
     * @param actual The actual value (may be null).
     */
    public static void assertNotEquals(Object expected, Object actual) {
        assertNotEquals(expected, actual, null);
    }

    /**
     * Asserts that the expected and actual values are not equal to each other.
     *
     * @param expected The expected value (may be null).
     * @param actual The actual value (may be null).
     * @param errorMessage An additional error message (may be null).
     */
    public static void assertNotEquals(Object expected, Object actual,
                                       String errorMessage) {
        if(checkEquals(expected, actual)) {
            String output = "Assert Not Equals failed!" +
                    "\nexpected: >" + expected + "<" +
                    "\nactual:   >" + actual + "<";
            output = errorMessage != null ?
                    output + "\n" + errorMessage : output;
            throw new AssertionError(output);
        }
    }

    /**
     * Helper method that compares two objects and returns true if they are
     * equal and false if not. Two objects are considered equal if they are
     * both null or expected.equals(actual) returns true.
     *
     * @param expected The expected value (may be null).
     * @param actual The actual value (may be null).
     * @return True if the two objects are equal, and false otherwise.
     */
    private static boolean checkEquals(Object expected, Object actual) {
        return (expected == null && actual == null) ||
                (expected != null && expected.equals(actual));
    }
}
