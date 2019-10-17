package com.action;
import java.util.ArrayList;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;

public class RadioButtonAction extends ActionSupport  {
    private static final String MALE = "M";
    private static final String FEMALE = "F";
    private List<String> genders;

    public RadioButtonAction(){

        genders = new ArrayList<String>();
        genders.add(MALE);
        genders.add(FEMALE);



    }



    public String display() {
        return NONE;
    }
}
