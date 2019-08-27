import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Vector;
import java.util.Map;

public class ParseLog {
    String input, output;
    Integer value;
    public ParseLog (String inputFile, String outputFile) {
        this.input = inputFile;
        this.output = outputFile;
    }
    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        System.out.println("Расположение первого файла (введите)");
        String location = bufferedReader.readLine(); //читаем строку с клавиатуры
        System.out.println("Расположение второго файла (введите)");
        String location1= bufferedReader.readLine(); //читаем строку с клавиатуры

        ParseLog log1=new ParseLog(location, location1);
        Map<String, Integer> map= new HashMap<String, Integer>();
        parse(log1, map);
        Print(map, log1);
    }
    public static void parse(ParseLog log1, Map<String, Integer> map) { //а удобно =)
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(log1.input), StandardCharsets.UTF_8))){
            String line;
            while ((line = reader.readLine()) != null) {
                Integer count = map.get(line);
                map.put(line, (count == null) ? 1 : count + 1);
            }
        } catch (IOException e) {
            System.err.println("AAAAAAAAAAAAA");
            e.printStackTrace();
        }
        Print(map, log1);
    }

    public static void Print(Map<String, Integer> map, ParseLog log1) {

            try(FileWriter writer = new FileWriter(log1.output, false))
            {
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    writer.write("Строка: " + entry.getKey() + ", Повторений: " + entry.getValue());
                    writer.append('\n');
            }
        } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
