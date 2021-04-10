public class Boba {
  private String code;
  private String name;
  private int price;
  private int stock;

  public Boba(String code, String name, int price, int stock) {
    this.code = code;
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

  public int getPrice() {
    return this.price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getStock() {
    return this.stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

}
