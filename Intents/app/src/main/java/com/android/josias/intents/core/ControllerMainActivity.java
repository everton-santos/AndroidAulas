package com.android.josias.intents.core;

/**
 * Created by Josias on 19/01/2015.
 */
public class ControllerMainActivity {

    private static ControllerMainActivity instance = null;

    private String value;

    private ControllerMainActivity(){}

    public static ControllerMainActivity getInstance(){
        if (instance == null){
            instance = new ControllerMainActivity();
        }
        return instance;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
