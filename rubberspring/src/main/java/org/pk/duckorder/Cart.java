
package org.pk.duckorder;

import java.util.List;

/**
 * Cart class to put orders into 
 * Using the singleton pattern helps us to keep only one instance of a class at any time.
 *
 */
public class Cart {
	
	private static Cart myCart;
    /**
     * Create private constructor
     */
	// -----------------------------------------------------------
    //  Creates an empty shopping cart with a capacity of 25 items.
    // -----------------------------------------------------------
    private Cart()
    {
      capacity = 25;
      itemCount = 0;
      orders = null;
    }
    /**
     * Create a static method to get instance.
     */
    public static Cart getInstance(){
        if(myCart == null){
            myCart = new Cart();
        }
        return myCart;
    }

    private int itemCount;      // total number of items in the cart
    private int capacity;       // current cart capacity
    private List<Order> orders;

    
    
    public void addToCart(Order order)
    { 
        itemCount += order.getQuantity();
        orders.add(order);
    }

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Cart [itemCount=" + itemCount + ", capacity=" + capacity + "]";
	}


}
