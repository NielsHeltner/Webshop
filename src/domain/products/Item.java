package domain.products;

/**
 *
 * @author Niels
 */
public class Item {

    private Product product;
    private int quantity;

    /**
     * 
     * @param product det produkt item'et skal knyttes til
     * @param quantity mængden af item'et
     */
    public Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * 
     * @param quantity den nye mængde af item'et
     */
    public void changeQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * 
     * @return den samlede pris på item'et ganget med antal af item'et
     */

    public double getSumPrice() {

        return product.getPrice() * quantity;

    }
    
    /**
     * 
     * @return mængden på det givne item
     */
    
    /**
     * 
     * @return antallet af item'et
     */
    public int getQuantity() {
        return quantity;
    }
    
    
    /**
     * @return produktet knyttet til item'et
     */

    public Product getProduct() {
        return product;
    }
}
