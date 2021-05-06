package Model;


import java.util.Stack;

public class History {
    private Stack<Order> orderHistory;

    public History(){
        orderHistory =new Stack<>();
    }
    public History(Stack<Order> a){
        this.orderHistory = a;
    }
    public Stack<Order> getClone(){
        return (Stack<Order>) this.orderHistory.clone();
    }

    public Order getLastOrder(){
        return orderHistory.peek();
    }

    public void addOrder(Order current){
        orderHistory.push(current);
    }
    public Order popOrder(){
        if(!orderHistory.empty()) {
            return orderHistory.pop();
        }
        return null;
    }

}
