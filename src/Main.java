import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int earnings = 0;
        int spendings = 0;

        while (true) {
            System.out.println("Выберите операцию и введите её номер:");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать систему налогообложения");
            System.out.println("Для завершения программы введите \"end\" ");

            String input = sc.nextLine();

            if (input.equals("end")) {
                break;
            }

            int operation = Integer.parseInt(input);


            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    String moneyEarn = sc.nextLine();
                    int money = Integer.parseInt(moneyEarn);
                    earnings += money;
                    break;
                case 2:
                    System.out.println("Введите сумму расхода:");
                    String moneySpend = sc.nextLine();
                    int moneyS = Integer.parseInt(moneySpend);
                    spendings += moneyS;
                    break;
                case 3:
                    taxOutput(earnings, spendings);
                    break;
                default:
                    System.out.println("Такой операции нет");
            }

        }
        System.out.println("Программа завершена!");
    }



    public static int taxEarningsMinusSpendings(int earnings, int spendings){
        int tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }

    public static int taxEarningsPercent(int earnings){
        int tax = earnings * 6 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }

    public static void taxOutput(int earnings, int spendings){
        int taxEarnPers = taxEarningsPercent(earnings);
        int taxEarnMinusSpend = taxEarningsMinusSpendings(earnings,spendings);
        int deference = taxEarnPers - taxEarnMinusSpend;

        if(deference > 0){
            System.out.println("---------------------------------------------------------");
            System.out.println("Мы советуем вам УСН доходы минус расходы");
            System.out.println("Ваш налог составит " + taxEarnMinusSpend + " рублей");
            System.out.println("Налог на другой системе " + taxEarnPers + " рублей");
            System.out.println("Экономия " + (taxEarnPers - taxEarnMinusSpend)  + " рублей");
            System.out.println("---------------------------------------------------------");
        }
        else if(deference < 0){
            System.out.println("---------------------------------------------------------");
            System.out.println("Мы советуем вам УСН доходы ");
            System.out.println("Ваш налог составит " + taxEarnPers + " рублей");
            System.out.println("Налог на другой системе " + taxEarnMinusSpend + " рублей");
            System.out.println("Экономия " + (taxEarnMinusSpend - taxEarnPers)  + " рублей");
            System.out.println("---------------------------------------------------------");
        }
        else{
            System.out.println("Можете выбрать любую систему налогообложения ");
        }
    }
}