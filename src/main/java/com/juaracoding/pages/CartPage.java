package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    private WebDriver driver;

    public CartPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h3/a[(@href='https://shop.demoqa.com/product/tokyo-talkies/')]")//memilih produk Tokyo
    WebElement produkTokyo;
    @FindBy(css = "button[class='single_add_to_cart_button button alt wp-element-button']")//menambahkan produk
    WebElement addCart;

    @FindBy(css = "div[role='alert']")//mengambil teks sebagai tanda barang sudah ditambahkan
    WebElement cartText;


    public void cart(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1800)");
    produkTokyo.click();
        System.out.println("produk Tokyo Talkies dipilih");
        js.executeScript("window.scrollBy(0,1000)");
    addCart.click();
        System.out.println("menambahkan barang Tokyo Talkies");
        String cartName = cartText.getText();
        if (cartName.contains("has been added to your cart.")) {
            System.out.println("barang berhasil ditambahkan ke keranjang");
        } else {
            System.out.println("gagal");
        }
    }
}
