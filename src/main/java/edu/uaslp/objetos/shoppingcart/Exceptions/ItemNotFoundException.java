package edu.uaslp.objetos.shoppingcart.Exceptions;

public class ItemNotFoundException extends Exception{
    public ItemNotFoundException() {
        super("Exception, Item not found");
    }
}
