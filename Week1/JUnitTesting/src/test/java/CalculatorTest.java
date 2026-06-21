import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    // ===== Ex 1: Setting Up JUnit =====
    // @BeforeEach — har test se pehle chalta hai
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        System.out.println("Calculator initialized");
    }

    // @AfterEach — har test ke baad chalta hai
    @AfterEach
    void tearDown() {
        calculator = null;
        System.out.println("Calculator destroyed");
    }

    // @BeforeAll — sirf ek baar, sabse pehle
    @BeforeAll
    static void initAll() {
        System.out.println("=== JUnit Tests Starting ===");
    }

    // @AfterAll — sirf ek baar, sabse baad mein
    @AfterAll
    static void tearDownAll() {
        System.out.println("=== JUnit Tests Finished ===");
    }

    // ===== Ex 3: Assertions in JUnit =====
    @Test
    void testAdd() {
        // assertEquals — expected vs actual
        assertEquals(5, calculator.add(2, 3), "2+3 should be 5");
    }

    @Test
    void testSubtract() {
        assertEquals(1, calculator.subtract(3, 2), "3-2 should be 1");
    }

    @Test
    void testMultiply() {
        assertEquals(6, calculator.multiply(2, 3), "2*3 should be 6");
    }

    @Test
    void testDivide() {
        assertEquals(4, calculator.divide(8, 2), "8/2 should be 4");
    }

    // assertNotEquals
    @Test
    void testAddNotEquals() {
        assertNotEquals(10, calculator.add(2, 3), "2+3 should not be 10");
    }

    // assertTrue / assertFalse
    @Test
    void testAddIsPositive() {
        assertTrue(calculator.add(2, 3) > 0, "Result should be positive");
    }

    // assertNull / assertNotNull
    @Test
    void testCalculatorNotNull() {
        assertNotNull(calculator, "Calculator should not be null");
    }

    // Exception testing
    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(10, 0);
        }, "Dividing by zero should throw ArithmeticException");
    }

    // ===== Ex 4: AAA Pattern =====
    @Test
    void testAddWithAAAPattern() {
        // ARRANGE — setup karo
        int a = 10;
        int b = 20;

        // ACT — action lo
        int result = calculator.add(a, b);

        // ASSERT — verify karo
        assertEquals(30, result, "10+20 should be 30");
    }

    @Test
    void testDivideWithAAAPattern() {
        // ARRANGE
        int dividend = 20;
        int divisor = 4;

        // ACT
        int result = calculator.divide(dividend, divisor);

        // ASSERT
        assertEquals(5, result, "20/4 should be 5");
    }
}