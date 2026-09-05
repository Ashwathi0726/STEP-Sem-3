class Employee {

    private String empid;
    private String empName;
    private double salary;
    private boolean isIntern;

    public Employee(String empid, String empName, double salary) {
        this.empid = empid;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false; 
    }

    public Employee(String empid, String empName) {

        this(empid, empName, 0.0); 
        this.isIntern = true; 
    }

    public void printProfile() {
        System.out.println(empid + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee("E-101", "Divya", 65000.0);
        Employee emp2 = new Employee("E-102", "Arjun");

        emp1.printProfile();
        emp2.printProfile();
    }
}
