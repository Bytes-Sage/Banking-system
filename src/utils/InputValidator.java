package utils;

import java.util.regex.Pattern;

public class InputValidator {
    private static final Pattern EMAIL_PATTERN =  
    Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    private static final Pattern PHONE_PATTERN = Pattern.compile("\\d{10}$");

    public static boolean isValidString(String input){
        return input != null && !input.trim().isEmpty();
    }

    public static boolean isValidEmail(String email){
        if(!isValidString(email)){
            return false;
        }
        return EMAIL_PATTERN.matcher(email).matches();

    }
    public static boolean isValidPhone(String phone){
        if(!isValidPhone(phone)){
            return false;
        }
        return PHONE_PATTERN.matcher(phone).matches();
    }

    public static boolean isValidAmount(double amount) {
        return amount >0;
    }

    public static boolean isValidAccountNumber(String accountNumber){
        if(!isValidString(accountNumber)){
            return false;
        }
        return accountNumber.matches("^[A-Za-z0-9]{8,12}$");
        
    }

    public static boolean isValidCustomerId(String customerId){
        if(!isValidString(customerId)){
            return false;
        }
        return customerId.matches("[A-Za-z0-9] {6,10}$");
    }
}
