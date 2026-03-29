import java.util.ArrayList;
import java.util.List;

public abstract class Room implements Taxable {

    // ── Atribut ──────────────────────────────────────────────────────────────
    protected String       roomNumber;
    protected double       basePrice;
    protected List<String> facilities;
    protected RoomStatus   roomStatus;

    // ── Konstruktor ───────────────────────────────────────────────────────────
    public Room() {
        this.roomNumber = "";
        this.basePrice  = 0;
        this.facilities = new ArrayList<>();
        this.roomStatus = RoomStatus.AVAILABLE;
    }

    /**
     * @param roomNumber Nomor kamar (misal "101", "A-202")
     * @param basePrice  Harga dasar per malam
     * @param facilities Daftar fasilitas kamar
     */
    public Room(String roomNumber, double basePrice, List<String> facilities) {
        this.roomNumber = roomNumber;
        this.basePrice  = basePrice;
        this.facilities = (facilities != null) ? new ArrayList<>(facilities) : new ArrayList<>();
        this.roomStatus = RoomStatus.AVAILABLE;
    }

    // ── Mutator ───────────────────────────────────────────────────────────────
    public void setRoomNumber(String roomNumber)     { this.roomNumber = roomNumber; }
    public void setBasePrice(double basePrice)       { this.basePrice = basePrice; }
    public void setFacilities(List<String> facilities) { this.facilities = facilities; }
    public void setRoomStatus(RoomStatus roomStatus) { this.roomStatus = roomStatus; }

    /** Menambahkan satu fasilitas ke dalam daftar. */
    public void addFacility(String facility) {
        this.facilities.add(facility);
    }

    // ── Selector ──────────────────────────────────────────────────────────────
    public String       getRoomNumber() { return roomNumber; }
    public double       getBasePrice()  { return basePrice; }
    public List<String> getFacilities() { return facilities; }
    public RoomStatus   getRoomStatus() { return roomStatus; }

    // ── Tambahan ──────────────────────────────────────────────────────────────

    /** Mengecek apakah kamar tersedia untuk dipesan. */
    public boolean isAvailable() {
        return roomStatus == RoomStatus.AVAILABLE;
    }

    /**
     * Implementasi calculateTax dari interface Taxable.
     * Dihitung dari basePrice × TAX_RATE (11%).
     * Dapat di-override oleh subclass jika basis pajak berbeda.
     */
    @Override
    public double calculateTax() {
        return basePrice * TAX_RATE;
    }

    /** Total biaya per malam (basePrice + pajak + biaya tambahan). */
    public abstract double calculateTotal();

    /** Menampilkan informasi detail kamar. */
    public abstract void displayRoomInfo();
}
