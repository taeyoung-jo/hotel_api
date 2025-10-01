package test;

import hotel.Hotel;
import hotel.HotelService;

import java.util.List;

public class HotelTest {
    public static void main(String[] args) {
        HotelService hotelService = new HotelService();

        // 서울 호텔만 조회
        List<Hotel> seoulHotels = hotelService.getHotelsByCity("Seoul");

        System.out.println("서울 호텔 개수: " + seoulHotels.size());
        System.out.println("------ 서울 호텔 리스트 ------");
        for (Hotel h : seoulHotels) {
            System.out.println("호텔 이름: " + h.getName());
            System.out.println("도시: " + h.getCity());
            System.out.println("가격: " + h.getPrice());
            System.out.println("평점: " + h.getRating());
            System.out.println("----------------------------");
        }
        
    }
}