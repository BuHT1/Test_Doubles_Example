package com.company.examplefortests.secondexample;

public class Door {
    private boolean opened=true;

    public Boolean isOpened(){
        return opened;
    }

    public void open(){
        opened=true;
    }

    public void close(){
        opened=false;
    }

}
