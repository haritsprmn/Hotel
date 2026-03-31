import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class Reservation {

    // ATTRIBUTE
    private String reservationId;
    private Guest guest;
    private Room room;
    private String checkInDate; // format: yyyy-MM-dd
    private String checkOutDate; // format: yyyy-MM-dd
    private ReservationStatus reservationStatus;

    // METHOD
    public Reservation() {
        this.reservationId = "";
        this.guest = null;
        this.room = null;
        this.checkInDate = "";
        this.checkOutDate = "";
        this.reservationStatus = ReservationStatus.PENDING;
    }

    public Reservation(String reservationId, Guest guest, Room room,
            String checkInDate, String checkOutDate,
            ReservationStatus reservationStatus) {
        this.reservationId = reservationId;
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.reservationStatus = reservationStatus;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public void setReservationStatus(ReservationStatus status) {
        this.reservationStatus = status;
    }

    public String getReservationId() {
        return reservationId;
    }

    public Guest getGuest() {
        return guest;
    }

    public Room getRoom() {
        return room;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public int calculateDuration() {
        try {
            LocalDate checkIn = LocalDate.parse(checkInDate);
            LocalDate checkOut = LocalDate.parse(checkOutDate);
            long nights = ChronoUnit.DAYS.between(checkIn, checkOut);
            return (int) Math.max(nights, 0);
        } catch (DateTimeParseException e) {
            System.out.println("Format tanggal tidak valid.");
            return 0;
        }
    }

    public double calculateTotalCost() {
        if (room == null)
            return 0;
        return room.calculateTotal() * calculateDuration();
    }

    public void reservationDetail() {
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║      DETAIL RESERVASI        ║");
        System.out.println("╚══════════════════════════════╝");
        System.out.printf("  %-16s : %s%n", "ID Reservasi", reservationId);
        System.out.printf("  %-16s : %s%n", "Status", reservationStatus);
        System.out.println();
        System.out.printf("  %-16s : %s%n", "Nama Tamu", guest != null ? guest.getName() : "-");
        System.out.printf("  %-16s : %s%n", "NIK", guest != null ? guest.getNIK() : "-");
        System.out.printf("  %-16s : %s%n", "Telpon", guest != null ? guest.getPhoneNumber() : "-");
        System.out.println();
        System.out.printf("  %-16s : %s%n", "No. Kamar", room != null ? room.getRoomNumber() : "-");
        System.out.printf("  %-16s : Rp %,.2f%n", "Harga/malam", room != null ? room.calculateTotal() : 0);
        System.out.println();
        System.out.printf("  %-16s : %s%n", "Check-in", checkInDate);
        System.out.printf("  %-16s : %s%n", "Check-out", checkOutDate);
        System.out.printf("  %-16s : %d malam%n", "Durasi", calculateDuration());
        System.out.printf("  %-16s : Rp %,.2f%n", "Total Biaya", calculateTotalCost());
    }
}
