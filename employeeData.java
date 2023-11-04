package employeemanagementsystem;

import java.sql.Date;

public class employeeData {
    
    private Integer customerId;
    private String firstName;
    private String email;
    private String favourite;
    private String phoneNum;
    private String group;
    private Date date;
    private Double salary;
    
    public employeeData(Integer customerId, String firstName, String email, String favourite, String phoneNum, String group, Date date){
        this.customerId = customerId;
        this.firstName = firstName;
        this.email = email;
        this.favourite = favourite;
        this.phoneNum = phoneNum;
        this.group = group;
        this.date = date;
    }
    public employeeData(Integer customerId, String firstName, String email,String group, Double salary){
        this.customerId = customerId;
        this.firstName = firstName;
        this.email = email;
        this.group = group;
        this.salary = salary;
    }
    
    public Integer getCustomerId(){
        return customerId;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getEmail(){
        return email;
    }
    public String getFavourite(){
        return favourite;
    }
    public String getPhoneNum(){
        return phoneNum;
    }    
    public String getGroup(){
        return group;
    }
    public Date getDate(){
        return date;
    }
    public Double getSalary(){
        return salary;
    }
}