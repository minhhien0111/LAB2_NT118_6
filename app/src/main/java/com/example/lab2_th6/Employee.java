package com.example.lab2_th6;

public class Employee {
    private String id;
    private String name;
    private boolean isManager;

    public Employee(String id, String name, boolean isManager)
    {
        this.id = id;
        this.name = name;
        this.isManager = isManager;
    }
    public String getID(){
        return id;
    }
    public String getFullName() {
        return name;
    }

    public boolean isManager() {
        return isManager;
    }

    public void setFullName(String name){
        this.name = name;
    }
    public void setId(String Id)
    {
        this.id = Id;
    }
    public void setIsManager(boolean check)
    {
        this.isManager = check;
    }
}
