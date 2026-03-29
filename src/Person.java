import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;

public abstract class Person {

    // ── Atribut ──────────────────────────────────────────────────────────────
    protected String name;
    protected String dateOfBirth; // format: yyyy-MM-dd
    protected String gender;
    protected String phoneNumber;
    protected String address;

    // ── Konstruktor ───────────────────────────────────────────────────────────
    public Person() {
        this.name        = "";
        this.dateOfBirth = "";
        this.gender      = "";
        this.phoneNumber = "";
        this.address     = "";
    }

    public Person(String name, String dateOfBirth, String gender,
                  String phoneNumber, String address) {
        this.name        = name;
        this.dateOfBirth = dateOfBirth;
        this.gender      = gender;
        this.phoneNumber = phoneNumber;
        this.address     = address;
    }

    // ── Mutator ───────────────────────────────────────────────────────────────
    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // ── Selector ──────────────────────────────────────────────────────────────
    public String getName()        { return name; }
    public String getDateOfBirth() { return dateOfBirth; }
    public String getGender()      { return gender; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getAddress()     { return address; }

    // ── Tambahan ──────────────────────────────────────────────────────────────

    /**
     * Menghitung usia berdasarkan tanggal lahir hingga hari ini.
     * @return usia dalam tahun, atau -1 jika format tanggal tidak valid
     */
    public int countAge() {
        try {
            LocalDate dob = LocalDate.parse(dateOfBirth);
            return Period.between(dob, LocalDate.now()).getYears();
        } catch (DateTimeParseException e) {
            System.out.println("Format tanggal tidak valid: " + dateOfBirth);
            return -1;
        }
    }

    public abstract void displayProfile();
}
