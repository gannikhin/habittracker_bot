import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // создаем экземпляры наших обработчиков
        TextHandler upperHandler = new UpperCaseHandler();
        TextHandler habitHandler = new HabitStreakHandler();

        // по умолчанию стартуем с трекера привычек
        TextHandler activeHandler = habitHandler;

        System.out.println("бот запущен! введите 'exit' для выхода.");
        System.out.println("команды переключения: /upper или /habit");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();

            // проверка на выход
            if ("exit".equalsIgnoreCase(input.trim())) {
                System.out.println("выход из программы...");
                break;
            }

            // логика переключения обработчиков
            if (input.startsWith("/upper")) {
                activeHandler = upperHandler;
                System.out.println("[переключено на UPPERCASE]");
                continue;
            } else if (input.startsWith("/habit")) {
                activeHandler = habitHandler;
                System.out.println("[переключено на трекер привычек]");
                continue;
            }

            //вызываем метод у текущего обработчика
            String result = activeHandler.handle(input);
            System.out.println(result);
        }

        scanner.close();
    }
}