import java.time.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Random;
//import java.util.random;


public class Order {
    private Pizza pizza = new Pizza();
    private ArrayList<Pizza> items;
    private OrderStatus OrderStatus;
    private LocalDateTime time;
    private LocalDateTime pickupTime;
    private ArrayList<Pizza> orderList;
    private int id;
    private double total = 0.0;

    public Order() {
        this.id = id;
        this.items = items;
        this.OrderStatus = OrderStatus.IN_PROGRESS;
        this.pickupTime = pickupTime;
        this.orderList = new ArrayList<>();


    }

    public void addPizzaToOrder(int pizzaNummer) {
        for (int i = 0; i < pizza.getPizzas().size(); i++) {
            orderList.add(pizza.getPizzas().get(pizzaNummer - 1));
            System.out.println("Ordrer hedder nu: " + orderList);
            break;
        }

        // calculateFullPrice(arrayList<Pizza> item)
    }
    public double calculateFullPrice() {
        for (Pizza pizza : orderList) {
            total += pizza.getPrice();
        }
        return total;
    }

    // + method : calculatePickupTime(dateTime time)
    public void calculatePuckupTime(int inputTime) {
        time = LocalDateTime.now();
        pickupTime = time.plus(inputTime, ChronoUnit.MINUTES);
        LocalDateTime.parse(pickupTime.toString());
        System.out.println("pickup " + pickupTime);

    }
    public int OrdreNumberGenerator() {
    Random random = new Random();
    int number = random.nextInt(900000) + 100000;
        return number;

    //skal tjekke om ordrenummer tidligere er blevet brugt
    }




    //item : arrayslist<Pizza>

// orderStatus : orderstatus

// time : DateTime

// pickupTime : DateTime



//

//    // + createOrder(arrayList<Pizza>item, DateTime pickupTime)
//
//    // +cancelOrder
//
//        if (OrderStatus != OrderStatus.COMPLETED && OrderStatus != OrderStatus.CANCEL) {
//            this.OrderStatus = OrderStatus.CANCEL;
//            System.out.println ("Order" + id + " is cancelled");
//        } else {
//            System.out.println ("Order" + id  + " cannot be cancelled. Status: + orderStatus");
//        }
//
//        //modifyOrder(int id)
//
//
//    }
//

//
//
//    // Mark Order as Completed - Order Status
//
//    public void completeOrder() {
//        this.orderStatus = OrderStatus.COMPLETED;
//        System.out.println("Order" + id "is completed and ready!");
//    }
//




}




