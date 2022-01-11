package com.system.services.exeptions;

public class ObjectNotFoundExeption  extends  RuntimeException{

    public ObjectNotFoundExeption(String message) {
        super(message);
    }

}
