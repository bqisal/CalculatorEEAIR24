import java.util.Scanner;

/**
 * Программа для шифрования и дешифрования текста с использованием шифра Цезаря и шифра Виженера.
 */
public class StringEncryption {

    /**
     * Шифрует текст с использованием шифра Цезаря.
     *
     * @param text  Исходный текст.
     * @param shift Величина сдвига.
     * @return Зашифрованный текст.
     */
    public static String caesarEncrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        shift = shift % 26;
        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                result.append((char) (base + (ch - base + shift) % 26));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static String caesarDecrypt(String text, int shift) {
        return caesarEncrypt(text, 26 - (shift % 26)); // Дешифровка через обратный сдвиг
    }


    public static String vigenereEncrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        key = key.toLowerCase();
        int keyIndex = 0;
        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                int shift = key.charAt(keyIndex) - 'a'; // Определяем сдвиг по ключу
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                result.append((char) (base + (ch - base + shift) % 26));
                keyIndex = (keyIndex + 1) % key.length(); // Переход к следующему символу ключа
            } else {
                result.append(ch); // Неалфавитные символы остаются без изменений
            }
        }
        return result.toString();
    }

    public static String vigenereDecrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        key = key.toLowerCase();
        int keyIndex = 0;
        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                int shift = key.charAt(keyIndex) - 'a';
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                result.append((char) (base + (ch - base - shift + 26) % 26)); // Дешифровка через обратный сдвиг
                keyIndex = (keyIndex + 1) % key.length();
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    /**
     * Основной метод программы.
     *
     * @param args Аргументы командной строки (не используются).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nВыберите операцию:");
            System.out.println("1: Шифрование Цезаря");
            System.out.println("2: Дешифрование Цезаря");
            System.out.println("3: Шифрование Виженера");
            System.out.println("4: Дешифрование Виженера");
            System.out.println("5: Выход");
            System.out.print("Ваш выбор: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Некорректный выбор. Пожалуйста, введите число от 1 до 5.");
                continue;
            }

            if (choice == 5) {
                System.out.println("Выход из программы...");
                break;
            }

            System.out.print("Введите текст: ");
            String text = scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введите значение сдвига: ");
                    int shiftEncrypt = Integer.parseInt(scanner.nextLine());
                    System.out.println("Зашифрованный текст: " + caesarEncrypt(text, shiftEncrypt));
                    break;
                case 2:
                    System.out.print("Введите значение сдвига: ");
                    int shiftDecrypt = Integer.parseInt(scanner.nextLine());
                    System.out.println("Дешифрованный текст: " + caesarDecrypt(text, shiftDecrypt));
                    break;
                case 3:
                    System.out.print("Введите ключ (строку): ");
                    String keyEncrypt = scanner.nextLine();
                    System.out.println("Зашифрованный текст: " + vigenereEncrypt(text, keyEncrypt));
                    break;
                case 4:
                    System.out.print("Введите ключ (строку): ");
                    String keyDecrypt = scanner.nextLine();
                    System.out.println("Дешифрованный текст: " + vigenereDecrypt(text, keyDecrypt));
                    break;
                default:
                    System.out.println("Некорректный выбор. Пожалуйста, выберите от 1 до 5.");
                    break;
            }
        }
        scanner.close();
    }
}