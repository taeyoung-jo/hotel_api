package hotel;

import java.util.List;

public class HotelTest {
    public static void main(String[] args) {
        HotelService hotelService = new HotelService();
        List<Hotel> hotels = hotelService.getAllHotels();

        System.out.println("호텔 개수: " + hotels.size());
        for (Hotel h : hotels) {
            System.out.println(h.getName() + " | " + h.getCity() + " | " + h.getPrice());
        }
    }
}