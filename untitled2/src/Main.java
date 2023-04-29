import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите URL-адрес страницы: ");
        String urlAddress = scanner.nextLine();

        // считываем HTML-страницу по URL-адресу
        String html = getHtmlFromUrl(urlAddress);

        // разбиваем текст на слова и заносим их в мапу (словарь)
        Map<String, Integer> wordCountMap = new HashMap<>();
        String[] words = html.split("[^\\w-]+");
        for (String word : words) {
            if (wordCountMap.containsKey(word)) {
                wordCountMap.put(word, wordCountMap.get(word) + 1);
            } else {
                wordCountMap.put(word, 1);
            }
        }

        // сортируем мапу по значениям (количеству вхождений слов) в порядке убывания
        List<Map.Entry<String, Integer>> list = new LinkedList<>(wordCountMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        // выводим результаты
        System.out.println("Статистика слов на странице " + urlAddress + ":");
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    // метод для считывания HTML-страницы по URL-адресу
    private static String getHtmlFromUrl(String urlAddress) {
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL(urlAddress);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line).append("\n");
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Не удалось загрузить страницу " + urlAddress);
        }
        return result.toString();}}

