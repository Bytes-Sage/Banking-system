package models;

public class Customer {
    private String customerId;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;

    public Customer(String customerId, String name, String email, String phoneNumber, String address){
        this.customerId= customerId;
        this.name=name;
        this.email=email;
        this.phoneNumber=phoneNumber;
        this.address=address;
    }

    public void updateContactInfo(String email, String phoneNumber, String address){
        if(email != null && !email.isEmpty()){
            this.email=email;
        }
        if(phoneNumber != null && !phoneNumber.isEmpty()){
            this.phoneNumber=phoneNumber;
        }
        if (address != null && !address.isEmpty()) {
            this.address=address;
        }
    }

    public String getCustomerId(){
        return customerId;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name =name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber =phoneNumber;
    }

    public String getAddress(){
        return address;
    }

    @Override 
    public String toString() {
        return String.format("Customer[ID = %s, Name=%s, Email=%s, Phone=%s]", customerId, name, email, phoneNumber);

    }
}

