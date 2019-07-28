package com.company.examplefortests.secondexample;

public class SecurityService {

    private Door door;
    private Window window;

    public SecurityService(Door door, Window window) {
        this.door = door;
        this.window = window;
    }

    public void securityOn() {
        window.open();
        door.open();
    }

    public void securityOff() {
        window.close();
        door.close();
    }
}
