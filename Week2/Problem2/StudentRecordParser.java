public class StudentRecordParser {

    public static void parseStudentRecord(String csvLine) {
        if (csvLine == null) {
            System.out.println("Invalid Record");
            return;
        }
        
        String cleaned = csvLine.trim();
        if (cleaned.startsWith("\"") && cleaned.endsWith("\"")) {
            cleaned = cleaned.substring(1, cleaned.length() - 1);
        }
        
        String[] fields = cleaned.split(",");
        
        if (fields.length != 3) {
            System.out.println("Invalid Record");
        } else {

            String name = fields[0].trim();
            String rollNo = fields[1].trim();
            String dept = fields[2].trim();
            
            System.out.println("Name: " + name + " | Roll No: " + rollNo + " | Dept: " + dept);
        }
    }

    public static void main(String[] args) {
  
        System.out.println("--- Test Case 1 ---");
        String input1 = "\"Ananya Verma,RA2211003010123,CSE\"";
        parseStudentRecord(input1);

        System.out.println("\n--- Test Case 2 ---");
        String input2 = "\"Ananya Verma,CSE\"";
        parseStudentRecord(input2);
    }
}
