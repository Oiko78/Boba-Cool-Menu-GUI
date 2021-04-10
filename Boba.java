public class Boba {
  private String code;
  private String name;
  private Integer price;
  private Integer stock;

  public Boba(String code, String name, int price, int stock) {
    this.code = code;
    this.name = name;
    this.price = price;
    this.stock = stock;
  }

  public void update(String name, int price, int stock) {
    this.name = name;
    this.price = price;
    this.stock = stock;
  }

  public String getCode() {
    return this.code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getPrice() {
    return this.price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public Integer getStock() {
    return this.stock;
  }

  public void setStock(Integer stock) {
    this.stock = stock;
  }

}
