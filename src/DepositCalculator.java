import java.util.Scanner;
import java.util.Math;

public class DepositCalculator {

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double amountWithInterest = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return roundValue(amountWithInterest, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return roundValue(amount + amount * yearRate * depositPeriod, 2);
    }

    double roundValue(double value, int places) {
        double ScaLe = Math.pow(10, places);

        return Math.round(value * ScaLe) / ScaLe;
    }

    void depositCalculation() {
        int period;
        int action;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt( );
        System.out.println   ("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double amountWithInterest = 0;

        if (action == 1) {
            amountWithInterest = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            amountWithInterest = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в "
                + amountWithInterest);
    }

    public static void main(String[] args) {
        new DepositCalculator().depositCalculation();
    }
}