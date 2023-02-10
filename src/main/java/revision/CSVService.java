package revision;

import java.io.FileWriter;
import java.io.IOException;

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
            fw.append(COMMA_DELIMITER)
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
        }


        fw.flush();
        fw.close()
    }
}
