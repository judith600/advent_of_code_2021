package v2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Util {

    public static String getRawInput(String fileName) {
        InputStream resourceAsStream = Util.class.getClassLoader().getResourceAsStream(fileName);
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

}
