package com.yago.Hestia.modules.item_lista.exceptions;

public class UserFoundException extends RuntimeException{
    public UserFoundException(){
        super("Usuario ja existente!");
    }
}
