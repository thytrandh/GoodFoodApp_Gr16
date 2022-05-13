package hcmute.edu.vn.foodapp_16;

import java.io.Serializable;

public class PopularFood implements Serializable {
    private int image;
    private String name;
    private String price;
    private String rating;

    public PopularFood(int image, String name, String price, String rating){
        this.image = image;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
