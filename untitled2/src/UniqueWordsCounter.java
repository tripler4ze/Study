import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class UniqueWordsCounter {

    private static final int CHUNK_SIZE = 1024;

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java UniqueWordsCounter <url>");
            System.exit(1);
        }

        try {
            // Получаем путь до сайта
            String urlStr = args[0];

            // Читаем страницу кусками
            StringBuilder contentBuilder = new StringBuilder();
            URL url = new URL(urlStr);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            char[] buffer = new char[CHUNK_SIZE];
            int bytesRead;
            while ((bytesRead = reader.read(buffer)) != -1) {
                contentBuilder.append(buffer, 0, bytesRead);
            }
            reader.close();
            String pageContent = contentBuilder.toString();

            // Разбиваем текст на слова
            String[] words = pageContent.split("[^A-Za-zА-Яа-я0-9]+");

            // Считаем количество уникальных слов
            Map<String, Integer> wordsCount = new HashMap<>();
            for (String word : words) {
                if (!word.isEmpty()) {
                    wordsCount.merge(word.toLowerCase(), 1, Integer::sum);
                }
            }

            // Сортируем слова по количеству вхождений в обратном порядке
            Map<String, Integer> sortedWordsCount = wordsCount.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

            // Выводим результаты
            sortedWordsCount.forEach((word, count) -> System.out.println(word + " - " + count));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
