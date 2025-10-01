const axios = require("axios");
const fs = require("fs");

// 랜덤 데이터 생성 함수
//랜덤 가격
function getRandomPrice(min = 30000, max = 800000) {
    const price = Math.floor(Math.random() * ((max - min) / 100 + 1) + min / 100) * 100;
    return `${price.toLocaleString()}`;
}
//랜덤 평점
function getRandomRating() {
    const min = 1;
    const max = 5;
    return (Math.random() * (max - min) + min).toFixed(1);
}

// 도시 리스트
const cities = [
    { name: "Tokyo", country: "JP" },
    { name: "Osaka", country: "JP" },
    { name: "Okinawa", country: "JP" },
    { name: "Seoul", country: "KR" },
    { name: "New York", country: "US" },
    { name: "Paris", country: "FR" },
    { name: "London", country: "GB" },
    { name: "Berlin", country: "DE" },
    { name: "Rome", country: "IT" },
    { name: "Barcelona", country: "ES" }
];

const allHotels = [];

async function fetchHotels() {
    for (let city of cities) {
        try {
            const response = await axios.get("https://serpapi.com/search", {
                params: {
                    api_key: "e15e6945f39593ad861b977e8869c7a74582854008a3ad3a51fb6cbabbd88874",
                    engine: "google_hotels",
                    q: `${city.name} hotels`,
                    location: `${city.name}, ${city.country}`,
                    check_in_date: "2025-10-10",   // YYYY-MM-DD
                    check_out_date: "2025-10-12"
                }
            });

            const hotels = response.data.properties.map((hotel, index) => ({
                id: allHotels.length + index + 1,
                name: hotel.name,
                city: city.name,
                country: city.country,
                image: hotel.images ? hotel.images[0].image_url : "N/A",
                price: getRandomPrice(),           // 한국어 랜덤 가격
                rating: getRandomRating()  // 랜덤 평점
            }));

            allHotels.push(...hotels);
        } catch (err) {
            console.error(`Error fetching hotels for ${city.name}:`, err.message);
        }
    }

    fs.writeFileSync("hoteldb.json", JSON.stringify({ hotels: allHotels }, null, 2));
    console.log("hoteldb.json 생성 완료!");
}

fetchHotels();

