import java.util.List;

public class DeluxeRoom extends Room {

    // ATTRIBUTE
    private double serviceFee;

    // METHOD
    public DeluxeRoom() {
        super();
        this.serviceFee = 0;
    }

    public DeluxeRoom(double serviceFee) {
        super();
        this.serviceFee = serviceFee;
    }

    public DeluxeRoom(String roomNumber, double basePrice,
            List<String> facilities, double serviceFee) {
        super(roomNumber, basePrice, facilities);
        this.serviceFee = serviceFee;
    }

    public void setServiceFee(double serviceFee) {
        this.serviceFee = serviceFee;
    }

    public double getServiceFee() {
        return serviceFee;
    }

    @Override
    public double calculateTax() {
        return (basePrice + serviceFee) * TAX_RATE;
    }

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
