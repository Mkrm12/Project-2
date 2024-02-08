import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {

    @Test
    void testEligibility1k() {
        assertEquals("Eligible", calculateEligibility(120, 100));
        assertEquals("Not Eligible", calculateEligibility(80, 100));
    }

    @Test
    void testEligibility3k() {
        assertEquals("Eligible", calculateEligibility(350, 300));
        assertEquals("Not Eligible", calculateEligibility(250, 300));
    }

    @Test
    void testEligibility5k() {
        assertEquals("Eligible", calculateEligibility(600, 500));
        assertEquals("Not Eligible", calculateEligibility(450, 500));
    }

    private String calculateEligibility(double monthlySalary, double eligibilityAmount) {
        return (monthlySalary > eligibilityAmount) ? "Eligible" : "Not Eligible";
    }
}
