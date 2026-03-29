import java.util.Arrays;
import java.util.List;

/**
 * Main.java — Demo Hotel Management System
 * Menunjukkan penggunaan seluruh class dalam sistem.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║    HOTEL MANAGEMENT SYSTEM - OOP     ║");
        System.out.println("╚══════════════════════════════════════╝");

        // ── 1. Membuat Hotel ──────────────────────────────────────────────────
        Hotel hotel = new Hotel("Grand Nusantara", "Jl. Merdeka No. 1, Semarang");
        hotel.displayHotelInfo();

        // ── 2. Membuat dan mendaftarkan Kamar ─────────────────────────────────
        System.out.println("\n─── Pendaftaran Kamar ───");

        List<String> stdFasilitas = Arrays.asList("AC", "TV", "WiFi", "Kamar Mandi");
        StandardRoom kamar101 = new StandardRoom("101", 350_000, stdFasilitas);

        StandardRoom kamar102 = new StandardRoom("102", 350_000, stdFasilitas);

        List<String> dlxFasilitas = Arrays.asList("AC", "TV 55\"", "WiFi", "Bathtub",
                                                    "Minibar", "Safe Box", "City View");
        DeluxeRoom kamarD201 = new DeluxeRoom("D-201", 800_000, dlxFasilitas, 150_000);
        DeluxeRoom kamarD202 = new DeluxeRoom("D-202", 800_000, dlxFasilitas, 150_000);

        hotel.addRoom(kamar101);
        hotel.addRoom(kamar102);
        hotel.addRoom(kamarD201);
        hotel.addRoom(kamarD202);

        // ── 3. Menampilkan seluruh kamar ──────────────────────────────────────
        hotel.displayAllRooms();

        // ── 4. Membuat tamu (Guest) ───────────────────────────────────────────
        System.out.println("\n─── Data Tamu ───");

        Guest tamu1 = new Guest(
            "3374011234560001",  // NIK
            "Semarang",          // domicile
            "Budi Santoso",      // name
            "1990-05-15",        // dateOfBirth
            "Laki-laki",         // gender
            "081234567890"       // phoneNumber
        );
        tamu1.displayProfile();

        System.out.println();
        Guest tamu2 = new Guest(
            "3374019876540002",
            "Yogyakarta",
            "Sari Dewi",
            "1995-11-20",
            "Perempuan",
            "082345678901"
        );
        tamu2.displayProfile();

        // ── 5. Membuat karyawan (Employee) ────────────────────────────────────
        System.out.println("\n─── Data Karyawan ───");

        Employee emp1 = new Employee(
            "EMP-001",           // id
            5_000_000,           // salary
            "Resepsionis",       // position
            "2020-03-01",        // hireDate
            "Andi Wijaya",       // name
            "1998-07-10",        // dateOfBirth
            "Laki-laki",         // gender
            "081122334455",      // phoneNumber
            "Jl. Anggrek No. 5, Semarang" // address
        );
        emp1.displayProfile();
        hotel.addEmployee(emp1);

        // ── 6. Membuat Reservasi ──────────────────────────────────────────────
        System.out.println("\n─── Pembuatan Reservasi ───");

        // Cari kamar yang tersedia
        Room kamarDipesan = hotel.findRoom("101");
        Room kamarDeluxe  = hotel.findRoom("D-201");

        Reservation res1 = new Reservation(
            "RES-2025-001",
            tamu1,
            kamarDipesan,
            "2025-07-10",
            "2025-07-13",
            ReservationStatus.CONFIRMED
        );

        Reservation res2 = new Reservation(
            "RES-2025-002",
            tamu2,
            kamarDeluxe,
            "2025-07-12",
            "2025-07-15",
            ReservationStatus.CONFIRMED
        );

        hotel.addReservation(res1);
        hotel.addReservation(res2);

        // ── 7. Menampilkan detail reservasi ───────────────────────────────────
        System.out.println();
        res1.reservationDetail();
        System.out.println();
        res2.reservationDetail();

        // ── 8. Mencari reservasi & menampilkan kamar tersedia ─────────────────
        System.out.println("\n─── Pencarian & Status Kamar ───");

        Reservation found = hotel.findReservation("RES-2025-001");
        if (found != null) {
            System.out.println("[OK] Reservasi ditemukan: " + found.getReservationId()
                    + " — " + found.getGuest().getName());
        }

        System.out.println("\nKamar tersedia setelah booking:");
        List<Room> tersedia = hotel.getAvailableRooms();
        if (tersedia.isEmpty()) {
            System.out.println("  Tidak ada kamar tersedia.");
        } else {
            for (Room r : tersedia) {
                System.out.println("  → " + r.getRoomNumber()
                        + " (" + r.getClass().getSimpleName() + ")"
                        + " — Rp " + String.format("%,.0f", r.calculateTotal()) + "/malam");
            }
        }

        // ── 9. Info hotel final ───────────────────────────────────────────────
        hotel.displayHotelInfo();

        // ── 10. Demo polymorphism Taxable ─────────────────────────────────────
        System.out.println("\n─── Demo Polimorfisme (Taxable) ───");
        Room[] semuaKamar = {kamar101, kamarD201};
        for (Room r : semuaKamar) {
            System.out.printf("  Kamar %-6s | Base: Rp %,8.0f | Pajak: Rp %,8.2f | Total: Rp %,8.2f%n",
                    r.getRoomNumber(), r.getBasePrice(), r.calculateTax(), r.calculateTotal());
        }

        System.out.println("\n[Program selesai]");
    }
}
