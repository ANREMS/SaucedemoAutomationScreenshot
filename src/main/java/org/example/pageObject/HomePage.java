package org.example.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
    public static WebDriver webDriver;

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }

    @FindBy(id = "react-burger-menu-btn")
    private WebElement buttonburgerMenu;

    @FindBy(id = "inventory_sidebar_link")
    private WebElement linkSideAllItems;

    @FindBy(id = "react-burger-cross-btn")
    private WebElement buttonCloseBurgerMenu;

    @FindBy(css = ".shopping_cart_link")
    private WebElement buttonCart;

    @FindBy(id = "back-to-products")
    private WebElement buttonBackToProduct;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement selectFilter;

    public void clickAddToCart(String str) {
        webDriver.findElement(By.xpath("//*[text()='" + str + "']//ancestor::div[@class='inventory_item_label']//following-sibling::div[@class='pricebar']//button")).click();
    }

    public void filterItem(String filterSelect)  {
        Select filter = new Select(this.selectFilter);
        filter.selectByVisibleText(filterSelect);
    }
}
