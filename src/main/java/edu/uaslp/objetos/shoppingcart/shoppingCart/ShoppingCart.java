package edu.uaslp.objetos.shoppingcart.shoppingCart;

import edu.uaslp.objetos.shoppingcart.Exceptions.EmptyShoppingCartException;
import edu.uaslp.objetos.shoppingcart.Exceptions.InvalidDataException;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class ShoppingCart {
    List<Item> shoppingCart = new LinkedList<>();
    private BigDecimal TotalCost;

    public boolean isEmpty() {
        if(shoppingCart.size()==0){
            return true;
        }else {
            return false;
        }

    }

    public BigDecimal getTotalCost() {
        BigDecimal totalCost = BigDecimal.ZERO;

        for(Item item: shoppingCart){
            totalCost = totalCost.add(item.getUnitCost().multiply(BigDecimal.valueOf(item.getQuantity())));
        }
        if (shoppingCart.size()==0){
            throw new EmptyShoppingCartException();
        }

        return totalCost;
    }

    public void addItem(Item item){
        shoppingCart.add(item);
    }

    //Exceptions
    /*public void addItem(Item item) {
        if(shoppingCart.size()>0 || shoppingCart.size()<5){
            if (item.getProviderCode()!=null || item.getProviderCode()!=""){
                shoppingCart.add(item);
            }
                throw new InvalidDataException("Null or empty string not allowed for item code");


        }else{
            throw new InvalidDataException("Quantity must be greater than zero and lower than 5");
        }

    }*/

    public int getItemsCount() {
        return shoppingCart.size();
    }

    public List<Item> getItems() {
        return shoppingCart;
    }

    public void removeItem(String itemCode1) {
        int i;
        for (i=0; i<shoppingCart.size(); i++){
            if (shoppingCart.get(i).getCode() == itemCode1){
                shoppingCart.remove(i);
            }
        }
    }
}

