package web_project.seveltjsp.jsp_PRJ.entity;



//model
public class Product {
    private String name;
    private String img;
    private int price;
    private int category;

    public Product() {
    }

    public Product(String name, String img, int price, int category) {
        this.name = name;
        this.img = img;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

}
