public class FileValidator {

    public static void main(String[] args) {

        System.out.println("Testing PDF: " + validateFileExtension("Assignment1.PDF"));
        System.out.println("Testing DOCX: " + validateFileExtension("report.Docx"));
        System.out.println("Testing ZIP: " + validateFileExtension("archive.zip"));
        System.out.println("Testing TXT: " + validateFileExtension("notes.txt"));
    }

    public static String validateFileExtension(String filename) {

        if (filename == null || !filename.contains(".")) {
            return "Rejected — invalid file type";
        }

        int lastDotIndex = filename.lastIndexOf('.');
        String extension = filename.substring(lastDotIndex + 1);

        if (extension.equalsIgnoreCase("pdf")) {
            return "Accepted";
        }
        
        if (extension.equalsIgnoreCase("docx")) {
            return "Accepted";
        }
        
        if (extension.equalsIgnoreCase("zip")) {
            return "Accepted";
        }

        return "Rejected: invalid file type";
    }
}
