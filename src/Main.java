import java.util.ArrayList;
import java.util.List;

// Класс User для хранения информации о пользователе
class User {
    private String name;
    private String email;
    private String role;

    public User(String name, String email, String role) {
        this.name = name;
        this.email = email;
        this.role = role;
    }

    // Геттеры и сеттеры для доступа к полям
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', email='" + email + "', role='" + role + "'}";
    }
}

// Класс UserManager для управления пользователями
class UserManager {
    private List<User> users = new ArrayList<>();

    // Добавление нового пользователя
    public void addUser(String name, String email, String role) {
        users.add(new User(name, email, role));
        System.out.println("Пользователь добавлен: " + name);
    }

    // Удаление пользователя по email
    public void removeUser(String email) {
        users.removeIf(user -> user.getEmail().equals(email));
        System.out.println("Пользователь с email " + email + " удален");
    }

    // Обновление информации о пользователе по email
    public void updateUser(String email, String newName, String newRole) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                user.setName(newName);
                user.setRole(newRole);
                System.out.println("Пользователь с email " + email + " обновлен");
                return;
            }
        }
        System.out.println("Пользователь с email " + email + " не найден");
    }

    // Вывод всех пользователей
    public void printAllUsers() {
        if (users.isEmpty()) {
            System.out.println("Список пользователей пуст.");
        } else {
            System.out.println("Список пользователей:");
            for (User user : users) {
                System.out.println(user);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Создание экземпляра менеджера пользователей
        UserManager userManager = new UserManager();

        // Добавление пользователей
        userManager.addUser("John Doe", "john@example.com", "Admin");
        userManager.addUser("Jane Smith", "jane@example.com", "User");

        // Вывод всех пользователей
        userManager.printAllUsers();

        // Обновление пользователя
        userManager.updateUser("jane@example.com", "Jane Doe", "Admin");

        // Удаление пользователя
        userManager.removeUser("john@example.com");

        // Вывод всех пользователей после изменений
        userManager.printAllUsers();
    }
}
