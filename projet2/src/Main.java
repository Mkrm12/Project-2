import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        // Create a HashMap to store first name, surname, and yearly salary
        Map<String, String[]> dataMap = new HashMap<>();

        // Read data from CSV file and populate the dataMap
        try (BufferedReader br = new BufferedReader(new FileReader("src/Projet2.csv"))) {
            String line;
            br.readLine(); // Skip the first line
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                // Check if the array has the expected length
                if (values.length >= 3) {
                    String fullName = values[0] + " " + values[1];
                    int yearlySalary = Integer.parseInt(values[2].replaceAll(",", "").replace("\"", " ")); // Remove commas and replace quotes with space

                    dataMap.put(fullName, new String[]{values[0], values[1], String.valueOf(yearlySalary)});
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Calculate monthly salaries and print information
        for (Map.Entry<String, String[]> entry : dataMap.entrySet()) {
            String fullName = entry.getKey();
            String[] values = entry.getValue();

            // Check if the array has the expected length
            if (values.length >= 3) {
                int yearlySalary = Integer.parseInt(values[2]);
                double monthlySalary = yearlySalary / 12.0;

                // Check eligibility for packages
                String eligibility1k = (monthlySalary > 100) ? "Eligible" : "Not Eligible";
                String eligibility3k = (monthlySalary > 300) ? "Eligible" : "Not Eligible";
                String eligibility5k = (monthlySalary > 500) ? "Eligible" : "Not Eligible";

                // Print information
                System.out.println("Full Name: " + fullName);
                System.out.println("Yearly Salary: £" + String.format("%,d", yearlySalary));
                System.out.println("Monthly Salary: £" + String.format("%.2f", monthlySalary));
                System.out.println("Eligibility for £1k Package: " + eligibility1k);
                System.out.println("Eligibility for £3k Package: " + eligibility3k);
                System.out.println("Eligibility for £5k Package: " + eligibility5k);
                System.out.println();
            }
        }
    }
}
