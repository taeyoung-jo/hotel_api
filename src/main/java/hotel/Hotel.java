package hotel;

import java.util.List;

public class Hotel {
    private int id;
    private String name;
    private String city;
    private String country;
    private String image;
    private String price;       // "₩123,456" 형태
    private double rating;
    private List<Review> reviews;

    // 생성자
    public Hotel(int id, String name, String city, String country, String image, String price, double rating, List<Review> reviews) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.country = country;
        this.image = image;
        this.price = price;
        this.rating = rating;
        this.reviews = reviews;
    }

    // 기본 생성자
    public Hotel() {}

    // Getter / Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public String getPrice() { return price; }
    public void setPrice(String price) { this.price = price; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }

    public List<Review> getReviews() { return reviews; }
    public void setReviews(List<Review> reviews) { this.reviews = reviews; }

    // 내부 Review 클래스
    public static class Review {
        private String user;
        private String comment;
        private int score;

        public Review() {}
        public Review(String user, String comment, int score) {
            this.user = user;
            this.comment = comment;
            this.score = score;
        }

        public String getUser() { return user; }
        public void setUser(String user) { this.user = user; }

        public String getComment() { return comment; }
        public void setComment(String comment) { this.comment = comment; }

        public int getScore() { return score; }
        public void setScore(int score) { this.score = score; }
    }
}
