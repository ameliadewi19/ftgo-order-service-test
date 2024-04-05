package net.chrisrichardson.ftgo.orderservice.domain;

public class InvalidQuantityException extends RuntimeException {
    public InvalidQuantityException(String menuItemId) {
        super("Invalid quantity for Menu Item " + menuItemId + ". Quantity cannot be zero.");
    }
}
