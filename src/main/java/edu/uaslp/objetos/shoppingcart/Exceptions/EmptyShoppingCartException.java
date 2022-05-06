package edu.uaslp.objetos.shoppingcart.Exceptions;

public class EmptyShoppingCartException extends RuntimeException{
    public EmptyShoppingCartException() {
        super("Exception, Invalid Data");
    }
}

