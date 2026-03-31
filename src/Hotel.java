import java.util.ArrayList;
import java.util.List;

public class Hotel {

    // ATTRIBUTE
    private String hotelName;
    private String address;
    private List<Room> rooms;
    private List<Reservation> reservations;
    private List<Employee> employees;

    // METHOD
    public Hotel() {
        this.hotelName = "";
        this.address = "";
        this.rooms = new ArrayList<>();
        this.reservations = new ArrayList<>();
        this.employees = new ArrayList<>();
    }

    public Hotel(String hotelName, String address) {
        this.hotelName = hotelName;
        this.address = address;
        this.rooms = new ArrayList<>();
        this.reservations = new ArrayList<>();
        this.employees = new ArrayList<>();
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getAddress() {
        return address;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addRoom(Room room) {
        rooms.add(room);
        System.out.println("[+] Kamar " + room.getRoomNumber() + " berhasil ditambahkan.");
    }

    public List<Room> findRoom(double basePrice, List<String> facilities, boolean isCheaper) {
        List<Room> result = new ArrayList<>();

        for (Room room : rooms) {
            boolean priceMatch = isCheaper
                    ? room.getBasePrice() < basePrice
                    : room.getBasePrice() >= basePrice;

            boolean facilityMatch = room.getFacilities().containsAll(facilities);

            if (priceMatch && facilityMatch) {
                result.add(room);
            }
        }

        if (result.isEmpty()) {
            System.out.println("[!] Tidak ada kamar yang sesuai kriteria.");
        }

        return result;
    }

    public List<Room> getAvailableRooms() {
        List<Room> available = new ArrayList<>();
        for (Room room : rooms) {
            if (room.isAvailable()) {
                available.add(room);
            }
        }
        return available;
    }

    public void displayAllRooms() {
        System.out.println("\n══════════════════════════════════");
        System.out.println("  DAFTAR KAMAR HOTEL " + hotelName.toUpperCase());
        System.out.println("══════════════════════════════════");
        if (rooms.isEmpty()) {
            System.out.println("  Belum ada kamar yang terdaftar.");
            return;
        }
        for (Room room : rooms) {
            room.displayRoomInfo();
            System.out.println();
        }
        System.out.println("  Total kamar      : " + rooms.size());
        System.out.println("  Kamar tersedia   : " + getAvailableRooms().size());
        System.out.println("══════════════════════════════════");
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
        if (reservation.getRoom() != null) {
            reservation.getRoom().setRoomStatus(RoomStatus.OCCUPIED);
        }
        System.out.println("[+] Reservasi " + reservation.getReservationId() + " berhasil dibuat.");
    }

    public Reservation findReservation(String reservationId) {
        for (Reservation res : reservations) {
            if (res.getReservationId().equalsIgnoreCase(reservationId)) {
                return res;
            }
        }
        System.out.println("[!] Reservasi " + reservationId + " tidak ditemukan.");
        return null;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("[+] Karyawan " + employee.getName() + " berhasil didaftarkan.");
    }

    public Employee findEmployee(String id) {
        for (Employee emp : employees) {
            if (emp.getId().equalsIgnoreCase(id)) {
                return emp;
            }
        }
        System.out.println("[!] Karyawan dengan ID " + id + " tidak ditemukan.");
        return null;
    }

    public void displayHotelInfo() {
        System.out.println("\n══════════════════════════════════");
        System.out.println("       INFORMASI HOTEL");
        System.out.println("══════════════════════════════════");
        System.out.printf("  %-18s : %s%n", "Nama Hotel", hotelName);
        System.out.printf("  %-18s : %s%n", "Alamat", address);
        System.out.printf("  %-18s : %d%n", "Total Kamar", rooms.size());
        System.out.printf("  %-18s : %d%n", "Kamar Tersedia", getAvailableRooms().size());
        System.out.printf("  %-18s : %d%n", "Total Reservasi", reservations.size());
        System.out.printf("  %-18s : %d%n", "Total Karyawan", employees.size());
        System.out.println("══════════════════════════════════");
    }
}
