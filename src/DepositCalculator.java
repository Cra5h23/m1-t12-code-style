import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double depositAmount, double yearRate, int depositPeriod) {
        double amount = depositAmount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return calculateTotal(amount, 2);
    }

    double calculateSimplePercent(double depositAmount, double yearRate, int depositPeriod) {
        return calculateTotal(depositAmount + depositAmount * yearRate * depositPeriod, 2);
    }

    double calculateTotal(double amount, int arg) {
        double degree = Math.pow(10, arg);
        return Math.round(amount * degree) / degree;
    }

    void calculateDeposit() {
        int depositPeriod;
        int depositType;
        int depositAmount;
        double totalAmount = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:") ;
        depositAmount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:") ;
        depositPeriod = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        depositType = scanner.nextInt();
        if (depositType == 1) {
            totalAmount = calculateSimplePercent(depositAmount, 0.06, depositPeriod);
        } else if (depositType == 2) {
            totalAmount = calculateComplexPercent(depositAmount, 0.06, depositPeriod);
        }
        System.out.println("Результат вклада: " + depositAmount + " за "
                + depositPeriod + " лет превратятся в " + totalAmount);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateDeposit();
    }
}
