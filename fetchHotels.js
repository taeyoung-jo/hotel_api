const axios = require("axios");
const fs = require("fs");

// 랜덤 데이터 생성 함수
function getRandomPrice(min = 30000, max = 500000) {
    return `₩${Math.floor(Math.random() * (max - min + 1) + min).toLocaleString()}`;
}

function getRandomRating() {
    return (Math.random() * 5).toFixed(1);
}

const sampleReviews = [
    "위치가 아주 좋아요!",
    "조식이 만족스러웠습니다.",
    "객실 청결도가 최고예요.",
    "직원 친절하지만, 방이 조금 좁아요.",
    "다시 머물고 싶어요!"
];

const surnames = ["김","이","박","최","정","강","조","윤","장","임"];
const givenNames = ["민수","지현","서준","하은","도윤","수아","현우","예린","준호","세영"];

function getRandomUser() {
    const surname = surnames[Math.floor(Math.random() * surnames.length)];
    const givenName = givenNames[Math.floor(Math.random() * givenNames.length)];
    return surname + givenName;
}

function getRandomReviews() {
    const reviews = [];
    const count = Math.floor(Math.random() * 3) + 1; // 1~3개
    for (let i = 0; i < count; i++) {
        const comment = sampleReviews[Math.floor(Math.random() * sampleReviews.length)];
        reviews.push({
            user: getRandomUser(),
            comment,
            score: Math.floor(Math.random() * 5) + 1
        });
    }
    return reviews;
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
                    check_in_date: "2025-12-24",
                    check_out_date: "2025-12-30",
                    num: 5
                }
            });

            const hotels = response.data.properties.map((hotel, index) => ({
                id: allHotels.length + index + 1,
                name: hotel.name,
                city: city.name,
                country: city.country,
                image: hotel.images ? hotel.images[0].image_url : "N/A",
                price: getRandomPrice(),           // 한국어 랜덤 가격
                rating: getRandomRating(),         // 랜덤 평점
                reviews: getRandomReviews()        // 한국어 랜덤 리뷰
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
