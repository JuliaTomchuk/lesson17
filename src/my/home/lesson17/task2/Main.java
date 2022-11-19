package my.home.lesson17.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        String pathFolder = "src//my//home//lesson17//task2//files//";
        int limitOfFiles = 8;

        List<Path> paths = null;

        try {
            paths = getAllPaths(pathFolder, limitOfFiles);
            if(paths.size()==0){
                System.out.println("Folder is empty or there are no txt files in the folder");
            }
        } catch (IOException e) {
            System.out.print("Error");
        }


        int counter = paths.size();

        List<Document> documents = createListOfDocuments(counter);
        Map<String, Document> docInfo = new HashMap<>();


        for (int i = 0; i < paths.size(); i++) {
            Path path = paths.get(i);
            List<String> file = null;
            try {
                file = readFile(path);
            } catch (IOException e) {
                System.out.println("Error");
            }
            List<String> phones = findAtDocument(file, "\\+\\(\\d{2}\\)\\d{7}");
            List<String> numbers = findAtDocument(file, "\\b\\d{4}\\-[a-zA-Zа-яА-Я]{3}\\-\\d{4}\\-[a-zA-Zа-яА-Я]{3}\\-\\d[a-zA-Zа-яА-Я]\\d[a-zA-Zа-яА-Я]\\b");
            List<String> emails = findAtDocument(file, "\\b\\w+\\.*\\w*\\@\\w+\\.[a-z]{2,4}\\b");
            documents.get(i).setTelephoneNumbers(phones);
            documents.get(i).setNumbersOfDocument(numbers);
            documents.get(i).setEmails(emails);
            docInfo.put(path.getFileName().toString().split("\\.")[0], documents.get(i));


        }
        System.out.println(docInfo);
        System.out.println(docInfo.size() + " documents have been processed");

        try {
            System.out.println("Total number of files:" + countAllTypesOfFiles(pathFolder));
        } catch (IOException e) {
            System.out.println("Error");
        }


    }

    private static List<Document> createListOfDocuments(int counter) {
        List<Document> documents = new ArrayList<>();
        while (counter > 0) {
            documents.add(new Document());
            counter--;
        }

        return documents;
    }

    public static List<Path> getAllPaths(String pathFolder, int limitOfFiles) throws IOException {
        List<Path> paths = Files.walk(Paths.get(pathFolder)).filter(Files::isRegularFile).filter(p -> p.toString().endsWith(".txt")).limit(limitOfFiles).collect(Collectors.toList());

        return paths;
    }

    public static List<String> readFile(Path path) throws IOException {

        return Files.readAllLines(path);
    }

    public static List<String> findAtDocument(List<String> file, String regex) {

        String str = file.stream().reduce((s1, s2) -> s1 + " " + s2).toString();
        List<String> numbers = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            numbers.add(matcher.group());
        }


        return numbers;
    }

    public static long countAllTypesOfFiles(String pathFolder) throws IOException {
        long counter = Files.walk(Paths.get(pathFolder)).filter(Files::isRegularFile).count();
        return counter;
    }


}



