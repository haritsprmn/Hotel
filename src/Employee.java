import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;

public class Employee extends Person {

    // ATTRIBUT
    private String id;
    private double salary;
    private String position;
    private String hireDate; // format: yyyy-MM-dd

    // METHOD
    public Employee() {
        super();
        this.id = "";
        this.salary = 0;
        this.position = "";
        this.hireDate = "";
    }

    public Employee(String id, double salary, String position, String hireDate,
            String name, String dateOfBirth, String gender,
            String phoneNumber, String address) {
        super(name, dateOfBirth, gender, phoneNumber, address);
        this.id = id;
        this.salary = salary;
        this.position = position;
        this.hireDate = hireDate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }

    public String getHireDate() {
        return hireDate;
    }

    public int getYearsOfService() {
        try {
            LocalDate hire = LocalDate.parse(hireDate);
            return Period.between(hire, LocalDate.now()).getYears();
        } catch (DateTimeParseException e) {
            System.out.println("Format hireDate tidak valid: " + hireDate);
            return -1;
        }
    }

    public double calculateTax(double salary) {
        return salary * 0.05;
    }

    @Override
    public void displayProfile() {
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║      PROFIL KARYAWAN         ║");
        System.out.println("╚══════════════════════════════╝");
        System.out.printf("  %-14s : %s%n", "ID", id);
        System.out.printf("  %-14s : %s%n", "Nama", name);
        System.out.printf("  %-14s : %s%n", "Jabatan", position);
        System.out.printf("  %-14s : Rp %,.2f%n", "Gaji", salary);
        System.out.printf("  %-14s : Rp %,.2f%n", "Pajak", calculateTax(salary));
        System.out.printf("  %-14s : %s%n", "Tgl. Lahir", dateOfBirth);
        System.out.printf("  %-14s : %d tahun%n", "Usia", countAge());
        System.out.printf("  %-14s : %s%n", "Gender", gender);
        System.out.printf("  %-14s : %s%n", "No. Telpon", phoneNumber);
        System.out.printf("  %-14s : %s%n", "Alamat", address);
        System.out.printf("  %-14s : %s%n", "Tgl. Masuk", hireDate);
        System.out.printf("  %-14s : %d tahun%n", "Masa Kerja", getYearsOfService());
    }
}
