package pageUIs;

public class ShoppingCartUI {
	public static final String PRODUCT_NAME = "//a[@class='product-name']";
	public static final String WISHLIST_LINK = "//a[@class='ico-wishlist']";
	public static final String INPUT_QUANTITY = "//td[@class='product']/a[contains(text(), 'Apple MacBook Pro 13-inch')]/ancestor::tr/td[@class='quantity']/input";
	public static final String UPDATE_SHOPPING_CART_BUTTON = "//button[@id='updatecart']";
	public static final String REMOVE_PRODUCT_BUTTON = "//button[@class='remove-btn']";
	public static final String EMPTY_CART_MESSAGE = "//div[@class='page-body']";
}
