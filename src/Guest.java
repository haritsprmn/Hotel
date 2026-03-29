public class Guest extends Person {

    // ── Atribut ──────────────────────────────────────────────────────────────
    private String NIK;
    private String domicile;

    // ── Konstruktor ───────────────────────────────────────────────────────────
    public Guest() {
        super();
        this.NIK      = "";
        this.domicile = "";
    }

    /**
     * @param NIK         Nomor Induk Kependudukan (16 digit)
     * @param domicile    Kota/alamat domisili tamu
     * @param name        Nama lengkap
     * @param dateOfBirth Tanggal lahir (yyyy-MM-dd)
     * @param gender      Jenis kelamin
     * @param phoneNumber Nomor telepon
     */
    public Guest(String NIK, String domicile, String name,
                 String dateOfBirth, String gender, String phoneNumber) {
        super(name, dateOfBirth, gender, phoneNumber, domicile);
        this.NIK      = NIK;
        this.domicile = domicile;
    }

    // ── Selector ──────────────────────────────────────────────────────────────
    public String getNIK()      { return NIK; }
    public String getDomicile() { return domicile; }

    // ── Tambahan: override displayProfile ─────────────────────────────────────
    @Override
    public void displayProfile() {
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║        PROFIL TAMU           ║");
        System.out.println("╚══════════════════════════════╝");
        System.out.printf("  %-14s : %s%n", "Nama",       name);
        System.out.printf("  %-14s : %s%n", "NIK",        NIK);
        System.out.printf("  %-14s : %s%n", "Domisili",   domicile);
        System.out.printf("  %-14s : %s%n", "Tgl. Lahir", dateOfBirth);
        System.out.printf("  %-14s : %d tahun%n", "Usia", countAge());
        System.out.printf("  %-14s : %s%n", "Gender",     gender);
        System.out.printf("  %-14s : %s%n", "No. Telpon", phoneNumber);
    }
}
