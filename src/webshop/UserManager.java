package webshop;

import java.util.HashMap;
import java.util.Map;
import util.Address;
import util.Name;
import util.Rights;

/**
 * @author Niels
 */
public class UserManager {
    
    private Map<String, User> usersMap;
    
    public UserManager() {
        usersMap = new HashMap<>();
        User testUser = new User("niels", "kode", "12345678", "email@email.dk",
                new Name("Niels", "Heltner"), new Address("55", "Campusvej",
                        "5000", "Odense", "Danmark"), Rights.Customer, "20", "03", "1996");
        usersMap.put(testUser.getUsername(), testUser);
    }
    
    public boolean validate(String username, String password) {
        User user = findUser(username);
        if(user == null) {
            return false;
        }
        else {
            boolean validated = user.getPassword().equals(password);
            user.setLoggedIn(validated);
            return validated;
        }
    }
    
    public void logout(String username) {
        findUser(username).setLoggedIn(false);
    }
    
    public void createOrder(String username, int orderID) {
        findUser(username).createOrder(orderID);
    }
    
    public boolean hasBasket(String username) {
        return findUser(username).findShoppingBasket() != null;
    }
    
    public void addItem(String username, Product product, int quantity) {
        findUser(username).addItem(product, quantity);
    }
    
    public void changeQuantity(String username, Item item, int quantity) {
        findUser(username).changeQuantity(quantity, item);
    }
    
    public void removeItem(String username, Item item) {
        findUser(username).removeItem(item);
    }
    
    public String getFirstName(String username) {
        return findUser(username).getName().getFirstName();
    }
    
    private User findUser(String username) {
        return usersMap.get(username);
    }
    
}
