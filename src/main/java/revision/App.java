package revision;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public final class App {
    private App() {
    }

    public static void main(String[] args) throws IOException{

        if(args.length >0){

            if(args[0].equalsIgnoreCase("kill")){
                System.out.println("Ending program");
                System.exit(0);
            }
        }

        String dirName = "day08data";
        String fileName = "data.txt";
        String dirFileName = dirName + File.separator + fileName;
        FileService fs = new FileService();
        Boolean directoryCreated = fs.createDirectory(dirName);

        if(directoryCreated){
            System.out.println("directory created: " + dirName);
        } else {
            System.err.printf("directory %s already exists\n", dirName);
        }
       
        Boolean fileCreated;
        try {
            fileCreated = fs.createFile(dirName,fileName);
            if(fileCreated){
                System.out.println("file created: " + fileName);
            } else {
                System.out.printf("file %s already exists\n", fileName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Pass in full path to FileOutputStream

        try{
            FileOutputStream fos = new FileOutputStream(dirFileName);

            // for (int i = 0; i < 20; i++){
            //     // writing string in byte array
            //     fos.write(Integer.toString(i).getBytes());
            //     fos.write('\n');

            // }

            EmployeeService es = new EmployeeService();
            List<Employee> empList = es.generateEmployees();
            
            // clear the outputstream
            // force data to store to file
            fos.flush();
            fos.close();

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }


    }
}
