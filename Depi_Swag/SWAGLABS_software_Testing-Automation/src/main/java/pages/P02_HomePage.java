package pages;
import actions.CustomDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.Utility;
import java.util.ArrayList;
import java.util.List;

public class P02_HomePage {
    WebDriver driver;

    public P02_HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By items = By.xpath("(//div)[@class='inventory_item']");
    private final By addToCart = By.xpath("div[3]/button");
    private final By itemPrice = By.xpath("div[3]/div");
    private final By cartIcon = By.id("shopping_cart_container");

    List<WebElement> listOfItems = new ArrayList<>();
    List<Double> listPrices = new ArrayList<>();

    public P02_HomePage addItemToCart() {
        Utility utility = new Utility();

        List<WebElement> list = driver.findElements(items);
        // Select Random number from 0 to the list length
        int numberOfItems = utility.selectRandomInteger(list.size());
        // looping to the random number that appear before (for example if it will be 2, so it will loop two times
        for (int i = 0; i < numberOfItems; i++) {
            // looping to know which index i will select for every looping,
            // so if it will loop twice it can select 1 & 5, it will be second element and 6th element
            int index = utility.selectRandomInteger(list.size());
            // I want to check if this item indeed is "add to cart" button or remove from cart
            if (list.get(index).findElement(addToCart).getText().contains("ADD TO CART")) {
                // if yes, I will get this item
                WebElement addToCartItem = list.get(index).findElement(addToCart);
                // Add it to empty List
                listOfItems.add(addToCartItem);
                // Click on it
                addToCartItem.click();
                // I will remove from the string the dollar sign then change the string to double
                String price = driver.findElements(items).get(index).findElement(itemPrice).getText().substring(1);
                double specificItemPrice = Double.parseDouble(price);
                // Add the double price to empty list
                listPrices.add(specificItemPrice);
            } else {
                // So it will not be an "Add to cart button" nothing will happen
                System.out.println("Another index");
            }
        }
        return this;
    }

    public P02_HomePage enterCartPage() {
        new CustomDecorator(driver, cartIcon, 5000).click();
        return this;
    }

    By removeItem = By.xpath("(//button)[text()='REMOVE']");
    public P02_HomePage removeItemFromCart() {
        Utility utility = new Utility();
        // Check the total list in home page
        List<WebElement> list = driver.findElements(items);
        // check the total items that selected and have remove from cart text
        List<WebElement> itemsInCart = driver.findElements(removeItem);
        // if the list is not empty, now I can remove items from cart
        if(!itemsInCart.isEmpty())
        {
            // Depend on the list length, I will select random number
            int index = utility.selectRandomInteger(itemsInCart.size());
            // Depend on a random integer that is selected, I will loop to reach it
            for (int i = 0 ; i < itemsInCart.size() ; i ++)
            {
                if(i == index){
                    itemsInCart.get(i).click();
                }
            }
            // For loop to collect the list of prices after removing items
            for (WebElement webElement : list) {
                if (webElement.findElement(addToCart).getText().contains("REMOVE")) {
                    listPrices.add(Double.parseDouble(webElement.findElement(itemPrice).getText().substring(1)));
                }
            }
        }

        return this;
    }

    public double getTotalPrice() {
        System.out.println(listPrices + " total price ");
        System.out.println("The total list of prices is : " + listPrices);
        return  listPrices.stream().mapToDouble(Double::doubleValue).sum();
    }


}
