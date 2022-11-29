package common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class ReadInputUtil {

    public static String getInputAsCommaSeparatedString(String fileName) {
        InputStream resourceAsStream = ReadInputUtil.class.getClassLoader().getResourceAsStream(fileName);
        assert resourceAsStream != null;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            try {
                if (!bufferedReader.ready()) break;
                stringBuilder.append(bufferedReader.readLine()).append(",");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringBuilder.toString();
    }

    public static List<String> readLines(String fileName) {
        try {
            return Files.readAllLines(Paths.get("src/main/resources/"+ fileName), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<String> getInputAsLineList(String fileName) {
        return Arrays.asList(getInputAsCommaSeparatedString(fileName).split(","));
    }

}
