import java.util.ArrayList;
import java.util.Scanner;

// домашнее задание по теме «Коллекции List»
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> cart = new ArrayList<>();
        while (true) {
            System.out.println("Выберите операцию:");
            System.out.println("1. Добавить");
            System.out.println("2. Показать");
            System.out.println("3. Удалить");
            System.out.println("4. Найти");
            String input = scanner.nextLine();
            try {
                int number = Integer.parseInt(input);
                switch (number) {
                    case 1:
                        System.out.println("Какую покупку хотите добавить?");
                        cart.add(scanner.nextLine());
                        System.out.println(String.format("Итого в списке покупок: %s", cart.size()));
                        break;
                    case 2:
                        printCart(cart);
                        break;
                    case 3:
                        printCart(cart);
                        System.out.println("Какую хотите удалить? Введите номер или название");
                        String inp = scanner.nextLine();
                        try {
                            int n = Integer.parseInt(inp);
                            cart.remove(n - 1);
                            System.out.println("Покупка удалена");
                            printCart(cart);
                        } catch (NumberFormatException e) {
                            cart.remove(inp);
                            System.out.println("Покупка удалена");
                            printCart(cart);
                        }
                        break;
                    case 4:
                        System.out.println("Введите текст для поиска:");
                        String target = scanner.nextLine().toLowerCase();
                        System.out.println("Найдено:");
                        for (int i = 0; i < cart.size(); i++) {
                            String product = cart.get(i).toLowerCase();
                            if (product.contains(target)) {
                                System.out.println(String.format("%s. %s", i + 1, cart.get(i)));
                            }
                        }
                        break;
                    default:
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели не число. Попробуйте снова");
            }
        }
    }

    // метод вывода списка покупок
    public static void printCart(ArrayList<String> cart) {
        System.out.println("Список покупок:");
        for (int i = 0; i < cart.size(); i++) {
            System.out.println(String.format("%s. %s", i + 1, cart.get(i)));
        }
    }
}
