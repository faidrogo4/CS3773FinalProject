package Model;


import java.util.Stack;

public class History {
    private Stack<Order> orderHistory;
    public History(){
        orderHistory =null;
    }

    public Order getLastOrder(){
        return orderHistory.peek();
    }

    public void addOrder(Order current){
        orderHistory.push(current);
    }

}
