package hotel;

import java.util.List;

public class HotelService {

    private HotelRepository hotelRepository = new HotelRepository();

    // 전체 호텔 리스트 반환
    public List<Hotel> getAllHotels() {
        return hotelRepository.getAllHotels();
    }

}