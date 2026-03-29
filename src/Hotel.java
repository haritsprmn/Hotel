import java.util.ArrayList;
import java.util.List;

public class Hotel {

    // ── Atribut ──────────────────────────────────────────────────────────────
    private String            hotelName;
    private String            address;
    // Koleksi data operasional hotel
    private List<Room>        rooms;
    private List<Reservation> reservations;
    private List<Employee>    employees;

    // ── Konstruktor ───────────────────────────────────────────────────────────
    public Hotel() {
        this.hotelName    = "";
        this.address      = "";
        this.rooms        = new ArrayList<>();
        this.reservations = new ArrayList<>();
        this.employees    = new ArrayList<>();
    }

    /**
     * @param hotelName Nama hotel
     * @param address   Alamat hotel
     */
    public Hotel(String hotelName, String address) {
        this.hotelName    = hotelName;
        this.address      = address;
        this.rooms        = new ArrayList<>();
        this.reservations = new ArrayList<>();
        this.employees    = new ArrayList<>();
    }

    // ── Mutator ───────────────────────────────────────────────────────────────
    public void setHotelName(String hotelName) { this.hotelName = hotelName; }
    public void setAddress(String address)     { this.address = address; }

    // ── Selector ──────────────────────────────────────────────────────────────
    public String            getHotelName()    { return hotelName; }
    public String            getAddress()      { return address; }
    public List<Room>        getRooms()        { return rooms; }
    public List<Reservation> getReservations() { return reservations; }
    public List<Employee>    getEmployees()    { return employees; }

    // ── Tambahan: manajemen kamar ─────────────────────────────────────────────

    /** Menambahkan kamar baru ke hotel. */
    public void addRoom(Room room) {
        rooms.add(room);
        System.out.println("[+] Kamar " + room.getRoomNumber() + " berhasil ditambahkan.");
    }

    /**
     * Mencari kamar berdasarkan nomor kamar.
     * @param roomNumber Nomor kamar yang dicari
     * @return objek Room jika ditemukan, null jika tidak ada
     */
    public Room findRoom(String roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber().equalsIgnoreCase(roomNumber)) {
                return room;
            }
        }
        System.out.println("[!] Kamar " + roomNumber + " tidak ditemukan.");
        return null;
    }

    /**
     * Mengambil daftar semua kamar dengan status AVAILABLE.
     * @return List kamar yang tersedia
     */
    public List<Room> getAvailableRooms() {
        List<Room> available = new ArrayList<>();
        for (Room room : rooms) {
            if (room.isAvailable()) {
                available.add(room);
            }
        }
        return available;
    }

    /** Menampilkan semua kamar beserta informasinya. */
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

    // ── Tambahan: manajemen reservasi ─────────────────────────────────────────

    /** Menambahkan reservasi baru dan mengubah status kamar menjadi OCCUPIED. */
    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
        if (reservation.getRoom() != null) {
            reservation.getRoom().setRoomStatus(RoomStatus.OCCUPIED);
        }
        System.out.println("[+] Reservasi " + reservation.getReservationId() + " berhasil dibuat.");
    }

    /**
     * Mencari reservasi berdasarkan ID.
     * @param reservationId ID reservasi yang dicari
     * @return objek Reservation jika ditemukan, null jika tidak ada
     */
    public Reservation findReservation(String reservationId) {
        for (Reservation res : reservations) {
            if (res.getReservationId().equalsIgnoreCase(reservationId)) {
                return res;
            }
        }
        System.out.println("[!] Reservasi " + reservationId + " tidak ditemukan.");
        return null;
    }

    // ── Tambahan: manajemen karyawan ──────────────────────────────────────────

    /** Mendaftarkan karyawan baru ke hotel. */
    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("[+] Karyawan " + employee.getName() + " berhasil didaftarkan.");
    }

    /**
     * Mencari karyawan berdasarkan ID.
     * @param id ID karyawan
     * @return objek Employee jika ditemukan, null jika tidak ada
     */
    public Employee findEmployee(String id) {
        for (Employee emp : employees) {
            if (emp.getId().equalsIgnoreCase(id)) {
                return emp;
            }
        }
        System.out.println("[!] Karyawan dengan ID " + id + " tidak ditemukan.");
        return null;
    }

    /** Menampilkan ringkasan informasi hotel. */
    public void displayHotelInfo() {
        System.out.println("\n══════════════════════════════════");
        System.out.println("       INFORMASI HOTEL");
        System.out.println("══════════════════════════════════");
        System.out.printf("  %-18s : %s%n", "Nama Hotel",       hotelName);
        System.out.printf("  %-18s : %s%n", "Alamat",           address);
        System.out.printf("  %-18s : %d%n", "Total Kamar",      rooms.size());
        System.out.printf("  %-18s : %d%n", "Kamar Tersedia",   getAvailableRooms().size());
        System.out.printf("  %-18s : %d%n", "Total Reservasi",  reservations.size());
        System.out.printf("  %-18s : %d%n", "Total Karyawan",   employees.size());
        System.out.println("══════════════════════════════════");
    }
}
