import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        List<File> folderList = Arrays.asList(
                new File("D:// Games"),
                new File("D:// Games//src"),
                new File("D:// Games//src//main"),
                new File("D:// Games//src//test"),
                new File("D://Games//res"),
                new File("D://Games//res//drawables"),
                new File("D://Games//res//vectors"),
                new File("D://Games//res//icons"),
                new File("D://Games//savegames"),
                new File("D://Games//temp"));

        List<File> fileList = Arrays.asList(
                new File("D:// Games//src//main//Main.java"),
                new File("D:// Games//src//main//Utils.java"),
                new File("D://Games//temp//temp.txt"));

        folderList.stream().forEach(folder -> {
            if ((folder.mkdir())) {
                sb.append("Каталог" + folder + "создан\n");
            } else {
                sb.append("Каталог" + folder + " не создан\n");
            }
        });
        for (File file : fileList) {
            try {
                if (file.createNewFile()) sb.append("Файл" + file + "создан\n");
                else sb.append("Файл" + file + "не создан\n");
            } catch (IOException e) {
                sb.append(e.getMessage() + '\n');
            }
        }
        try (FileWriter fw = new FileWriter("D://Games//temp//temp.txt", false)) {
            fw.write(sb.toString());
            fw.flush();
        } catch (IOException e) {
            sb.append(e.getMessage());
            sb.append("\n");
        }
        try (BufferedReader br = new BufferedReader(new FileReader("D://Games//temp//temp.txt"))) {
            String s;
            while ((s = br.readLine()) != null) ;
            System.out.println(s);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
