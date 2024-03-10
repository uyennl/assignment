package model.entity;

public class Dish {

    private int idDish;
    private String title;
    private String subTitle;
    private float price;
    private String image; // Thêm thuộc tính ảnh dưới dạng chuỗi String
    private boolean status; // Trường trạng thái kiểu boolean
    private Category category;

    public Dish(int idDish, String title, String subTitle, float price, String image, boolean status, Category category) {
        this.idDish = idDish;
        this.title = title;
        this.subTitle = subTitle;
        this.price = price;
        this.image = image;
        this.status = status;
        this.category = category;
    }

    public Dish(String title, String subTitle, float price, String image, boolean status, Category category) {
        this.title = title;
        this.subTitle = subTitle;
        this.price = price;
        this.image = image;
        this.status = status;
        this.category = category;
    }

    public Dish() {
    }

    @Override
    public String toString() {
        return "Dish{" + "idDish=" + idDish + ", title=" + title + ", subTitle=" + subTitle + ", price=" + price + ", image=" + image + ", status=" + status + ", category=" + category + '}';
    }

    public int getIdDish() {
        return idDish;
    }

    public void setIdDish(int idDish) {
        this.idDish = idDish;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
