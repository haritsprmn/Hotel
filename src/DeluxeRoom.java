import java.util.List;

public class DeluxeRoom extends Room {

    // ── Atribut ──────────────────────────────────────────────────────────────
    private double serviceFee;

    // ── Konstruktor ───────────────────────────────────────────────────────────
    public DeluxeRoom() {
        super();
        this.serviceFee = 0;
    }

    /**
     * Konstruktor dengan service fee saja; roomNumber & basePrice diset via setter.
     * 
     * @param serviceFee Biaya layanan per malam
     */
    public DeluxeRoom(double serviceFee) {
        super();
        this.serviceFee = serviceFee;
    }

    /**
     * Konstruktor lengkap (direkomendasikan untuk penggunaan normal).
     * 
     * @param roomNumber Nomor kamar
     * @param basePrice  Harga dasar per malam
     * @param facilities Daftar fasilitas
     * @param serviceFee Biaya layanan per malam
     */
    public DeluxeRoom(String roomNumber, double basePrice,
            List<String> facilities, double serviceFee) {
        super(roomNumber, basePrice, facilities);
        this.serviceFee = serviceFee;
    }

    // ── Mutator ───────────────────────────────────────────────────────────────
    public void setServiceFee(double serviceFee) {
        this.serviceFee = serviceFee;
    }

    // ── Selector ──────────────────────────────────────────────────────────────
    public double getServiceFee() {
        return serviceFee;
    }

    // ── Tambahan: override calculateTax, calculateTotal, displayRoomInfo ──────

    /**
     * Deluxe room: pajak dihitung dari (basePrice + serviceFee).
     */
    @Override
    public double calculateTax() {
        return (basePrice + serviceFee) * TAX_RATE;
    }

    /**
     * Total = basePrice + serviceFee + pajak.
     */
    @Override
    public double calculateTotal() {
        return basePrice + serviceFee + calculateTax();
    }

    @Override
    public void displayRoomInfo() {
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║        DELUXE ROOM           ║");
        System.out.println("╚══════════════════════════════╝");
        System.out.printf("  %-14s : %s%n", "No. Kamar", roomNumber);
        System.out.printf("  %-14s : %s%n", "Status", roomStatus);
        System.out.printf("  %-14s : Rp %,.2f%n", "Harga Dasar", basePrice);
        System.out.printf("  %-14s : Rp %,.2f%n", "Service Fee", serviceFee);
        System.out.printf("  %-14s : Rp %,.2f (%.0f%%)%n",
                "Pajak", calculateTax(), TAX_RATE * 100);
        System.out.printf("  %-14s : Rp %,.2f%n", "Total/malam", calculateTotal());
        System.out.printf("  %-14s : %s%n", "Fasilitas", facilities);
    }
}
