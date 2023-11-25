import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите логин: ");
        String login = scanner.nextLine();
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();
        System.out.print("Введите повторный пароль: ");
        String confirmPassword = scanner.nextLine();

        try {
            boolean result = results (login, password, confirmPassword);
            System.out.println(result);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.err.println(e.getMessage());
        }
    }

    //я могу и тут все прописать
    public static boolean results (String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (login.length() > 20 || !login.matches("[a-zA-Z0-9_]+")) {
            throw new WrongLoginException("Неверный логин!");
        }
        if (password.length() > 20 || !password.matches("[a-zA-Z0-9_]+") || !password.equals(confirmPassword)) {
            throw new WrongPasswordException("Неверный пароль!");
        }
        return true;
    }
}