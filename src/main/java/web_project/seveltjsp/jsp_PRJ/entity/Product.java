package web_project.seveltjsp.jsp_PRJ.entity;


import lombok.Getter;
import lombok.Setter;

//model
@Setter
@Getter
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

}
