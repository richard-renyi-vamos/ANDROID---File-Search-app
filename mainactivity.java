import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileSearch {

    public List<File> searchFiles(String directoryPath, String query) {
        List<File> fileList = new ArrayList<>();
        File directory = new File(directoryPath);

        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        fileList.addAll(searchFiles(file.getAbsolutePath(), query));
                    } else if (file.getName().toLowerCase().contains(query.toLowerCase())) {
                        fileList.add(file);
                    }
                }
            }
        }

        return fileList;
    }
}
