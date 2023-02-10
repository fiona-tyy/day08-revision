package revision;

import java.io.File;
import java.io.IOException;

public class FileService {

    // to check whether directory exist and create dir if does not exist
    public Boolean createDirectory(String directoryName){
        File directory = new File(directoryName);
        Boolean directoryCreated = directory.mkdir();
        return directoryCreated;
    }

    // Create new file
    // must enter full directory path as directory name
    public Boolean createFile(String directoryName, String fileName) throws IOException{
        File newFile = new File(directoryName + File.separator + fileName);
        Boolean fileCreated = newFile.createNewFile();
        return fileCreated;
    }
    
    // List all files in the directory
    public void listDirectoryFiles(String directoryName) throws IOException{
        File fileDirectory = new File(directoryName);

        // If directory exists, list all files within the directory
        if (fileDirectory.exists()){
            File[] fileList = fileDirectory.listFiles();

            for(File file : fileList){
                System.out.println(file.getPath() + File.separator + file.getCanonicalFile().toString());
            }
        } else {
            System.err.println("Directory " + directoryName + "does not exist.");
        }
    }
}
