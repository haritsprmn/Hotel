public class Guest extends Person {

    // ATTRIBUT
    private String NIK;
    private String domicile;

    // METHOD
    public Guest() {
        super();
        this.NIK = "";
        this.domicile = "";
    }

    public Guest(String NIK, String domicile, String name,
            String dateOfBirth, String gender, String phoneNumber) {
        super(name, dateOfBirth, gender, phoneNumber, domicile);
        this.NIK = NIK;
        this.domicile = domicile;
    }

    public String getNIK() {
        return NIK;
    }

    public String getDomicile() {
        return domicile;
    }

    @Override
    public void displayProfile() {
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║        PROFIL TAMU           ║");
        System.out.println("╚══════════════════════════════╝");
        System.out.printf("  %-14s : %s%n", "Nama", name);
        System.out.printf("  %-14s : %s%n", "NIK", NIK);
        System.out.printf("  %-14s : %s%n", "Domisili", domicile);
        System.out.printf("  %-14s : %s%n", "Tgl. Lahir", dateOfBirth);
        System.out.printf("  %-14s : %d tahun%n", "Usia", countAge());
        System.out.printf("  %-14s : %s%n", "Gender", gender);
        System.out.printf("  %-14s : %s%n", "No. Telpon", phoneNumber);
    }
}
