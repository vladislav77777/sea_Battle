package Task5;

public class Promotion {
    public static Salary salary;

    Promotion(Salary salary) {
        this.salary = salary;
        System.out.println("salary = " + salary);
        promote(); // 1
    }

    public static void promote() {
        salary.income += 1500;
    }

}
