package Task5;

public class Salary {
    long income;

    Salary(long income) {
        this.income = income;
        System.out.println("Salary.Salary");
    }

    public static void main(String[] args) {
        Salary obj = new Salary(123L);
        Promotion obj2 = new Promotion(obj);
        Promotion.promote(); // 2
        System.out.println(obj.income);
    }

    @Override
    public String toString() {
        return "Salary{" +
                "income=" + income +
                '}';
    }
    }



