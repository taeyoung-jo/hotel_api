const fs = require("fs");

// db.json 읽기
const rawData = fs.readFileSync("db.json");
const data = JSON.parse(rawData);

// 도쿄 호텔 필터
const tokyoHotels = data.hotels.filter(hotel => hotel.city === "Tokyo");

// rating만 추출
const tokyoRatings = tokyoHotels.map(hotel => hotel.rating);

console.log(tokyoRatings);

