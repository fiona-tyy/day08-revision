package revision;

import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class App {
    private App() {
    }
    
    public static String dirName = "day08data";
    public static String fileName = "data.txt";
    public static String dirFileName = dirName + File.separator + fileName;
    public static String idiomFileName = "idioms.txt";
    public static String idiomDirFileName = dirName + File.separator + idiomFileName;

    public static void main(String[] args) throws IOException{

        if(args.length >0){

            if(args[0].equalsIgnoreCase("kill")){
                System.out.println("Ending program");
                System.exit(0);
            }
        }
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

        Console cons = System.console();
        String consInput = "";
        IdiomService idiomSvc = new IdiomService();
        List<String> idioms = null;
        ProfileService ps = new ProfileService();

        while(!consInput.equalsIgnoreCase("Q")){
            displayMenu();
            consInput = cons.readLine("Enter your selection: ");

            switch(consInput){
                case "1":
                    CSVExample();
                    break;
                case "2":
                // cannot instantiate IdiomService class here; must do at class level
                    idioms = new ArrayList<>();
                    idioms = idiomSvc.readFile(idiomDirFileName);
                    break;
                case "3":
                    String randomIdiom = idiomSvc.randomIdiom(idioms);
                    message(randomIdiom);
                    break;
                case "4":
                    idiomSvc.showAllIdioms(idioms);
                    break;
                case "5":
                    ps.readFile();
                    break;
                case "Q":
                case "q":
                    message("Bye... bye...");
                default:
                    break;
            }
    
        }

    }

    public static void CSVExample() throws IOException{
        // Pass in full path to FileOutputStream
        
        try{
            // FileOutputStream fos = new FileOutputStream(dirFileName);
        
            // for (int i = 0; i < 20; i++){
            //     // writing string in byte array
            //     fos.write(Integer.toString(i).getBytes());
            //     fos.write('\n');
        
            // }
            // clear the outputstream
            // force data to store to file
            // fos.flush();
            // fos.close();
        
            EmployeeService es = new EmployeeService();
            List<Employee> empList = es.generateEmployees();
        
            CSVService csvSvc = new CSVService();
            // write list of employee to CSV
            csvSvc.writeToCSV(empList, dirFileName);
        
            // read list of employee from CSV
            List<Employee> csvEmpList = csvSvc.readFromCSV(dirFileName);
            csvEmpList.forEach(emp -> System.out.println(emp));
        
            
        
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
    public static void displayMenu(){
        message("Welcome to My App");
        message("===========================");
        message("1. CSV Read and Write Test");
        message("2. Read Idioms File");
        message("3. Pick an idiom randomly");
        message("4. List all idioms");
        message("5. Read txt file and check for word");
        message("Q Quit the program");
    }

    public static void message(String line){
        System.out.println(line);
    }
}
