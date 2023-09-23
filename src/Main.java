import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Converter converter = new Converter();
        StepTracker stepTracker = new StepTracker(scanner, converter);
        while (true) {
            printMenu();
            int i = scanner.nextInt();
            if (i == 1) {
                stepTracker.addNewNumberStepsPerDay();
            } else if (i == 2) {
                stepTracker.changeStepGoal();
            } else if (i == 3) {
                stepTracker.printStatistic();
            } else if (i == 4) {
                System.out.println("Пока!");
                scanner.close();
                return;
            } else {
                System.out.println("Такой команды нет");
            }

        }

    }
    static void printMenu(){
        System.out.println("Выберите необходимую команду:");
        System.out.println("1. Ввести количество шагов за определённый день");
        System.out.println("2. Изменить цель по количеству шагов в день");
        System.out.println("3. Напечатать статистику за определённый месяц");
        System.out.println("4. выйти из приложения");
    }
}