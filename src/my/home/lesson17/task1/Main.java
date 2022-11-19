package my.home.lesson17.task1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        String ip = readFromConsole();
        System.out.println(ip);

        boolean isValid = isValid(ip);

        System.out.println(isValid);


    }

    public static String readFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter IP:");
        String ip = scanner.nextLine();

        scanner.close();
        return ip;


    }

    public static boolean isValid(String ip) {
        String regex = "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ip);
        return matcher.matches();
    }
}