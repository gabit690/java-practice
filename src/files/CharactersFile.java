package files;

import java.io.*;

public class CharactersFile {

    public static void main(String[] args) {

        printContent("src/files/test.txt");

        appendContent("src/files/new.txt", "One Line");
    }

    public static void printContent(String path) {

        try {

            FileReader fileFlow = new FileReader(path);

            BufferedReader myBuffer = new BufferedReader(fileFlow);

            String line = "";

            while (line != null) {

                line = myBuffer.readLine();

                if (line != null)

                    System.out.println(line);
            }

            fileFlow.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void appendContent(String filePath, String content) {

        try {

            FileWriter fileFlow = new FileWriter(filePath, true);

            BufferedWriter myBuffer = new BufferedWriter(fileFlow);

            myBuffer.write(content.concat("\n"));

            myBuffer.flush();

            fileFlow.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
