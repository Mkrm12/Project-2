import java.util.*;

public class SavingsScheme {

    static class Person {
        String name;
        String moneyGroup;
        int randomNum;
        int balance;

        public Person(String name, String moneyGroup, int initialBalance) {
            this.name = name;
            this.moneyGroup = moneyGroup;
            this.balance = initialBalance;
        }
    }

    public static void main(String[] args) {
        List<Person> peopleData = new ArrayList<>();

        // Populate peopleData with some dummy data including initial balances
        peopleData.add(new Person("Alice", "£1000", 10000));
        peopleData.add(new Person("Bob", "£1000", 5000));
        peopleData.add(new Person("Charlie", "£1000", 8000));
        peopleData.add(new Person("David", "£1000", 12000));
        peopleData.add(new Person("Eva", "£1000", 15000));
        peopleData.add(new Person("Frank", "£1000", 9000));
        peopleData.add(new Person("Grace", "£1000", 11000));
        peopleData.add(new Person("Harry", "£1000", 7000));
        peopleData.add(new Person("Ivy", "£1000", 13000));
        peopleData.add(new Person("Jack", "£1000", 1000));

        // Call the savingsScheme method
        savingsScheme(peopleData);
    }

    public static void savingsScheme(List<Person> people) {
        List<Integer> assignedNumbers = new ArrayList<>();

        // Print initial money and assign unique random numbers between 1 and 10
        for (Person person : people) {
            System.out.println(person.name + " - Initial Balance: £" + person.balance);
            int randomNum;
            do {
                randomNum = new Random().nextInt(10) + 1;
            } while (assignedNumbers.contains(randomNum));
            person.randomNum = randomNum;
            assignedNumbers.add(randomNum);
            System.out.println(person.name + " - Assigned Random Number: " + person.randomNum);
        }

        // Collect £1000 from the group and give it to the person with the corresponding random number
        int totalContribution = 0;
        for (int month = 1; month <= 10; month++) {
            System.out.println("\nMonth " + month + " - Group Contribution:");

            // Deduct £100 from each person's balance
            for (Person person : people) {
                person.balance -= 100;
                System.out.println(" £100 taken from " + person.name + " - New Balance: £" + person.balance);
            }

            for (Person person : people) {
                if (person.randomNum == month) {
                    person.balance += 1000;
                    totalContribution += 1000;
                    System.out.println(" £1000 added to " + person.name + "'s balance - New Balance: £" + person.balance + " (Random Number: " + person.randomNum + ")");
                }
            }
            System.out.println("Total Contribution so far for Month " + month + ": £" + totalContribution);

        }

    }
}
