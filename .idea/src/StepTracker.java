import java.util.Scanner;

public class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    int goalByStepsPerDay =10000;
    Converter converter;

    StepTracker(Scanner scan, Converter conv) {
        scanner = scan;
        converter = conv;
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }
    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца");
        // ввод и проверка номера месяца
        int month = scanner.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Указанный месяц не существует"); return;}

        System.out.println("Введите день от 1 до 30 (включительно)");
        int numberDay = scanner.nextInt();
        if (numberDay < 0 || numberDay > 31) {
           System.out.println("Указанный день не существует"); return;}

        System.out.println("Введите количество шагов");
        int numberStep = scanner.nextInt();
        if (numberStep < 1) {
            System.out.println("Указанный количество шагов не существует"); return;}

        // Получение соответствующего объекта MonthData из массива
        MonthData monthData = monthToData[month-1];
        // Сохранение полученных данных
        monthData.days[numberDay - 1] = numberStep;
    }
    void changeStepGoal(){
        System.out.println("Введите цель шагов за день");
        int goalByStepsPerDayTemp = scanner.nextInt();
        if (goalByStepsPerDayTemp > 0) {
            goalByStepsPerDay = goalByStepsPerDayTemp;}
        else {
            System.out.println("Данное количество шагов не существует"); return;}
    }

    void printStatistic() {
        System.out.println("Введите число месяца");
        // ввод и проверка номера месяца
            int month = scanner.nextInt();
            if (month < 1 || month > 12){
                System.out.println("Введенный месяц не существует");    return;
            }
        MonthData monthData = monthToData[month - 1];// получение соответствующего месяца
        int sumSteps = monthData.sumStepsFromMonth();// получение суммы шагов за месяц
        monthData.printDaysAndStepsFromMonth(); // вывод общей статистики по дням
        System.out.println("Сумма шагов за месяц: " + sumSteps);  // вывод суммы шагов за месяц
        System.out.println("Максимальное количество шагов за месяц : " + monthData.maxSteps());// вывод максимального пройденного количества шагов за месяц
        System.out.println("Среднее количество шагов в среднем за месяц : " + sumSteps / 30);// вывод среднего пройденного количества шагов за месяц
        System.out.println("За месяц км пройдено : " + converter.convertToKm(sumSteps));  // вывод пройденной за месяц дистанции в км
        System.out.println("Килокалорий сожжено за месяц : " + converter.convertStepsToKilocalories(sumSteps)); // вывод количества сожжённых килокалорий за месяц
        System.out.println("Лучшая серия по шагам: " + monthData.bestSeries(goalByStepsPerDay));       // вывод лучшей серии
        System.out.println(); //дополнительный перенос строки
    }
}
