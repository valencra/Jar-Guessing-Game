import java.util.Random;

public class Jar {
  private String itemType;
  private final int MAX_AMOUNT;
  private int itemNumber;
  
  public Jar(String itemType, int maxAmount) {
    // construct a jar instance
    this.itemType = itemType;
    this.MAX_AMOUNT = maxAmount;
  }
  
  public void fill() {
    // fill with random items
    Random random = new Random();
    this.itemNumber = random.nextInt(this.MAX_AMOUNT) + 1;
  }
  
  public int getItemNumber() {
    // get number of items
    return this.itemNumber;
  }
}