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
        if(shoppingCart.isEmpty()){
            throw new EmptyShoppingCartException();
        }

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
        if (item.getCode() == null){
            throw new InvalidDataException("Null or empty string not allowed for item code");
        }if (item.getProviderCode().isEmpty()){
            throw new InvalidDataException("Null or empty string not allowed for provider code");
        }if (item.getUnitCost().compareTo(BigDecimal.ZERO) < 0){
            throw new InvalidDataException("Cost must be greater than zero");
        }if (item.getQuantity() < 1 || item.getQuantity() > 5){
            throw new InvalidDataException("Quantity must be greater than zero and lower than 5");
        }

        for(Item existentItem: shoppingCart){
            if(existentItem.getCode().equals(item.getCode())  &&  existentItem.getUnitCost().compareTo(item.getUnitCost())==0){
                existentItem.setQuantity(existentItem.getQuantity()+item.getQuantity());
                return;
            }
        }

        shoppingCart.add(item);
    }

    //Exceptions
    /*public void addItem(Item item) {
        if(shoppingCart.size()>0 || shoppingCart.size()<5){
            if (item.getProviderCode()!=null || item.getProviderCode()!=""){
                shoppingCart.add(item);
            }
                throw new InvalidDataException();


        }else{
            throw new InvalidDataException("Quantity must be greater than zero and lower than 5");
        }

    }*/

    public int getItemsCount() {
        int count=0;
        for(Item item: shoppingCart) {
            count+=item.getQuantity();
        }
        return count;
    }

    public List<Item> getItems() {
        return shoppingCart;
    }

    public void removeItem(String itemCode1) {
        for (Item item : shoppingCart){
            if (item.getCode().equals(itemCode1)){
                item.setQuantity(item.getQuantity()-1);

                if (item.getQuantity()==0){
                    shoppingCart.remove(item);
                }

                return;
            }
        }
    }
}

