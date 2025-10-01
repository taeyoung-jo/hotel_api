package hotel;

import java.util.ArrayList;
import java.util.List;

public class HotelService {

    private HotelRepository hotelRepository = new HotelRepository();

    // 전체 호텔 리스트 반환
    public List<Hotel> getAllHotels() {
        return hotelRepository.getAllHotels();
    }
    // 도시별 호텔리스트 가져오기
    public List<Hotel> getHotelsByCity(String city) {
        List<Hotel> hotels = hotelRepository.getAllHotels();
        List<Hotel> result = new ArrayList<>();

        for (Hotel h : hotels) {
            if (h.getCity().equalsIgnoreCase(city)) {
                result.add(h);
            }
        }

        return result;  // 해당 도시에 있는 호텔 리스트 반환
    }

}