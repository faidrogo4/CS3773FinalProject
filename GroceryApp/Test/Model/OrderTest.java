package Model;

import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Observable;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    private Customer cust;
    private int prodNum;
    @BeforeEach
    void setUp() {
        prodNum = 3;
        try {
            cust = new Customer("Test","Test");
        }catch(IncorrectPasswordException e){
            e.printStackTrace();
        }
        for(int i = 0;i<prodNum;i++)
            cust.getOrder().addProduct( new Product("prod"+(1+i),1+i,1.00,1,0));

    }

    @Test
    void addProduct() {
        cust.getOrder().addProduct(new Product("newProd",4,1,1,0));
        assertEquals("newProd",cust.getOrder().getListByPrice(true).get(3).getName());
    }

    @Test
    void getProductCount() {
        assertEquals(3, cust.getOrder().getProductCount());
    }

    @Test
    void deleteProduct() {
        Product delete = cust.getOrder().getObservable().get(0);
        cust.getOrder().deleteProduct(delete);
        assertEquals(prodNum-1, cust.getOrder().getProductCount());
    }

    @Test
    void getListByPrice() {
        int num = 0;
        cust.getOrder().p.forEach((a)->{
            double price = a.getPrice();
            a.setPrice(price + (.5*a.getId()));
        });
        assertEquals("prod3", cust.getOrder().getListByPrice(false).get(0).getName());
    }

    @Test
    void getListByName() {
        assertEquals("prod3",cust.getOrder().getListByName(false).get(0).getName());
    }

    @Test
    void getObservable() {
        assertTrue(cust.getOrder().getObservable() != null && !cust.getOrder().getObservable().isEmpty());
    }

    @Test
    void getCust() {
        assertEquals(cust, cust.getOrder().getCust());
    }

    @Test
    void getOrderNum() {
        assertEquals(1,cust.getOrder().getOrderNum());
    }
}