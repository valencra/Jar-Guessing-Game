import java.util.Scanner;

public class Prompter {
  private Jar jar;
  private Scanner scanner;
  private String itemType;
  private int maxAmount;
  
  public Prompter() {
    // construct prompter instance
    this.scanner = new Scanner(System.in);
  }
  
  public void setup() {
    // setup guessing game
    System.out.printf("SETUP PHASE %n" +
                      "=========== %n");
    
    // get jar parameters from user
    System.out.printf("What type of item? ");
    this.itemType = this.scanner.nextLine();
    System.out.printf("What is the maximum amount of %s? ", this.itemType);
    this.maxAmount = this.scanner.nextInt();
    
    // instantiate a jar based on parameters
    this.jar = new Jar(itemType, maxAmount);
    this.jar.fill();
  }
  
  public void guess() {
    // start guessing game
    System.out.printf("%n" + 
                      "GUESSING PHASE %n" +
                      "============== %n");
    System.out.printf("How many %s are in the jar? Pick a number between 1 and %d? %n", this.itemType, this.maxAmount);
    int guessedAmount;
    int guessCount = 0;
    
    // ask user to guess until correct amount is provided
    do {
      guessCount++;
      
      // ensure user guesses are less than or equal to max amount
      do {
        System.out.printf("Guess %d: ", guessCount);
        guessedAmount = this.scanner.nextInt();
        
        // warn user if guess exceeds max amount
        if (guessedAmount > this.maxAmount) {
          System.out.printf("Your guess must be less than %d.%n", this.maxAmount);
        }
      } while (guessedAmount > this.maxAmount);
      
      // display guess difference directionality
      this.differenceDirection(guessedAmount);
      
    } while (guessedAmount != this.jar.getItemNumber());
    
    // notify user of success
    System.out.printf("%nCongratulations! You guessed that there are %d %s in the jar. It took you %d attempts to get it right.%n",
                      this.jar.getItemNumber(),
                      this.itemType,
                      guessCount);
  }
  
  private void differenceDirection(int guessedAmount) {
    // hint user with directionality of a guess' difference from the actual value
    if (guessedAmount > this.jar.getItemNumber()) {
      System.out.printf("Your guess is too high.%n");
    }
    else if (guessedAmount < this.jar.getItemNumber()) {
      System.out.printf("Your guess is too low.%n");
    }
    else {
    }
  }
}