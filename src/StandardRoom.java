import java.util.List;

public class StandardRoom extends Room {

    // ATTRIBUTE

    // METHOD
    public StandardRoom() {
        super();
    }

    public StandardRoom(String roomNumber, double basePrice, List<String> facilities) {
        super(roomNumber, basePrice, facilities);
    }

    @Override
    public double calculateTax() {
        return basePrice * TAX_RATE;
    }

    @Override
    public double calculateTotal() {
        return basePrice + calculateTax();
    }

    @Override
    public void displayRoomInfo() {
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║       STANDARD ROOM          ║");
        System.out.println("╚══════════════════════════════╝");
        System.out.printf("  %-14s : %s%n", "No. Kamar", roomNumber);
        System.out.printf("  %-14s : %s%n", "Status", roomStatus);
        System.out.printf("  %-14s : Rp %,.2f%n", "Harga Dasar", basePrice);
        System.out.printf("  %-14s : Rp %,.2f (%.0f%%)%n",
                "Pajak", calculateTax(), TAX_RATE * 100);
        System.out.printf("  %-14s : Rp %,.2f%n", "Total/malam", calculateTotal());
        System.out.printf("  %-14s : %s%n", "Fasilitas", facilities);
    }
}
