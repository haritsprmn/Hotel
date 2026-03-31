import java.util.ArrayList;
import java.util.List;

public abstract class Room implements Taxable {

    // ATTRIBUT
    protected String roomNumber;
    protected double basePrice;
    protected List<String> facilities;
    protected RoomStatus roomStatus;

    // METHOD
    public Room() {
        this.roomNumber = "";
        this.basePrice = 0;
        this.facilities = new ArrayList<>();
        this.roomStatus = RoomStatus.AVAILABLE;
    }

    public Room(String roomNumber, double basePrice, List<String> facilities) {
        this.roomNumber = roomNumber;
        this.basePrice = basePrice;
        this.facilities = (facilities != null) ? new ArrayList<>(facilities) : new ArrayList<>();
        this.roomStatus = RoomStatus.AVAILABLE;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public void setFacilities(List<String> facilities) {
        this.facilities = facilities;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

    public void addFacility(String facility) {
        this.facilities.add(facility);
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public List<String> getFacilities() {
        return facilities;
    }

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public boolean isAvailable() {
        return roomStatus == RoomStatus.AVAILABLE;
    }

    @Override
    public double calculateTax() {
        return basePrice * TAX_RATE;
    }

    public abstract double calculateTotal();

    public abstract void displayRoomInfo();
}