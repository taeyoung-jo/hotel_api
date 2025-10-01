package tripPackage;

import hotel.Hotel;

public class TripPackage {
    private int id;
    private String packageName; // 패키지이름
    private Hotel hotel;
    //    private Flight flight;
    private String roomNumber; // 지정될 방번호
    private String roomType; // 지정될 방타입
    private int numPeople; // 인원수
    private int totalPrice; // 패키지가격
    private String location; // 지역
    private String deptFilght; //출발지
    private String arriveFilght; //도착지

    // Getter/Setter
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getPackageName() {return packageName;}
    public void setPackageName(String packageName) {this.packageName = packageName;}

    public Hotel getHotel() {return hotel;}
    public void setHotel(Hotel hotel) {this.hotel = hotel;}

    public String getRoomNumber() {return roomNumber;}
    public void setRoomNumber(String roomNumber) {this.roomNumber = roomNumber;}

    public String getRoomType() {return roomType;}
    public void setRoomType(String roomType) {this.roomType = roomType;}

    public int getNumPeople() {return numPeople;}
    public void setNumPeople(int numPeople) {this.numPeople = numPeople;}

    public int getTotalPrice() {return totalPrice;}
    public void setTotalPrice(int totalPrice) {this.totalPrice = totalPrice;}

    public String getArriveFilght() {return arriveFilght;}
    public void setArriveFilght(String arriveFilght) {this.arriveFilght = arriveFilght;}

    public String getDeptFilght() {return deptFilght;}
    public void setDeptFilght(String deptFilght) {this.deptFilght = deptFilght;}

    public String getLocation() {return location;}
    public void setLocation(String location) {this.location = location;}

    // 생성자
    public TripPackage(int id, String packageName, Hotel hotel, String roomNumber, String roomType, int numPeople, int totalPrice,  String location, String deptFilght, String arriveFilght) {
        this.id = id;
        this.packageName = packageName;
        this.hotel = hotel;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.numPeople = numPeople;
        this.totalPrice = totalPrice;
        this.location = location;
        this.deptFilght = deptFilght;
        this.arriveFilght = arriveFilght;
    }

    // 기본 생성자
    public TripPackage() {}
}
