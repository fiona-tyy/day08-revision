package revision;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVService {
    public static final String FILE_HEADER = "staffNo,fullName,department,role,email,salary";
    public static final String COMMA_DELIMITER = ",";
    public static final String NEW_LINE = "\n";

    // For reading and writing CSV files
    public void writeToCSV(List<Employee> employees, String fullPathFileName) throws IOException{
        FileWriter fw = new FileWriter(fullPathFileName);

        // Write header
        fw.append(FILE_HEADER);
        fw.append(NEW_LINE);

        //  write into CSV record-by-record
        for(Employee emp : employees){
            fw.append(emp.getStaffNo());
            fw.append(COMMA_DELIMITER);
            fw.append(emp.getFullName());
            fw.append(COMMA_DELIMITER);
            fw.append(emp.getDepartment());
            fw.append(COMMA_DELIMITER);
            fw.append(emp.getRole());
            fw.append(COMMA_DELIMITER);
            fw.append(emp.getEmail());
            fw.append(COMMA_DELIMITER);
            fw.append(String.valueOf(emp.getSalary()));
            fw.append(COMMA_DELIMITER);
            fw.append(NEW_LINE);
        }
        fw.flush();
        fw.close();
    }

    public List<Employee> readFromCSV(String fullPathFileName) throws IOException{

        FileReader fr = new FileReader(fullPathFileName);
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        List<Employee> employees = new ArrayList<>();

        // Skip first row which is the header
        br.readLine();

        while((line = br.readLine()) != null){

            // splits each employee's data by comman
            String[] strEmployee = line.split(COMMA_DELIMITER);

            if (strEmployee.length > 0){
                // put info into an employee object
                Employee emp = new Employee(strEmployee[0], strEmployee[1], strEmployee[2], strEmployee[3], strEmployee[4], Integer.parseInt(strEmployee[5]));
                // add to employees list object
                employees.add(emp);
            }
        }

        br.close();
        fr.close();

        return employees;
    }
}
