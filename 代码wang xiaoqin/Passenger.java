import java.util.regex.Pattern;

public class Passenger extends Person {
    private String email;
    private String phoneNumber;
    private String cardNumber;
    private Integer securityCode;
    private String passport;

    // Patterns used to check the information
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("^\\+?[0-9. ()-]{7,25}$"); // Updated for broader international support
    private static final Pattern PASSPORT_PATTERN = Pattern.compile("^\\w{1,9}$");

    public Passenger(String firstName, String secondName, Integer age, String gender, String email, String phoneNumber, String passport, String cardNumber, Integer securityCode) {
        super(firstName, secondName, age, gender);
        setEmail(email);
        setPhoneNumber(phoneNumber); // Phone number is now optional
        setPassport(passport); // Passport is now optional
        setCardNumber(cardNumber);
        setSecurityCode(securityCode);
    }

    public String getEmail() {
        return email;
    }

    public String getPassport() {
        return passport;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getSecurityCode() {
        return securityCode;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setEmail(String email) {
        if (email != null && EMAIL_PATTERN.matcher(email).matches()) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Email address is invalid.");
        }
    }

    public void setCardNumber(String cardNumber) {
        if (cardNumber == null) {
            throw new IllegalArgumentException("Card number cannot be null.");
        }
        if (isValidCreditCard(cardNumber)) {
            this.cardNumber = cardNumber;
        } else {
            throw new IllegalArgumentException("Invalid credit card number.");
        }
    }

    private boolean isValidCreditCard(String number) {
        int[] digits = new int[number.length()];
        for (int i = 0; i < number.length(); i++) {
            digits[i] = number.charAt(i) - '0';
        }
        for (int i = digits.length - 2; i >= 0; i -= 2) {
            digits[i] *= 2;
            if (digits[i] > 9) digits[i] -= 9;
        }
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum % 10 == 0;
    }

    public void setSecurityCode(Integer securityCode) {
        if (securityCode == null) {
            throw new IllegalArgumentException("Security code cannot be null.");
        }
        if (String.valueOf(securityCode).matches("\\d{3,4}")) {
            this.securityCode = securityCode;
        } else {
            throw new IllegalArgumentException("Security code must be 3 or 4 digits.");
        }
    }

    public void setPassport(String passport) {
        if (passport != null && PASSPORT_PATTERN.matcher(passport).matches()) {
            this.passport = passport;
        } else if (passport != null) {
            throw new IllegalArgumentException("Passport number must be 9 characters or less.");
        }
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber != null && PHONE_PATTERN.matcher(phoneNumber).matches()) {
            this.phoneNumber = phoneNumber;
        } else if (phoneNumber != null) {
            throw new IllegalArgumentException("Phone number is invalid.");
        }
    }

    @Override
    public String toString() {
        return "Passenger{" + " Fullname= " + super.getFirstName() + " " + super.getSecondName() +
                ", email='" + getEmail() +  "'" +
                (phoneNumber != null ? ", phoneNumber='" + getPhoneNumber() + "'" : "") +
                (passport != null ? ", passport='" + getPassport() + "'" : "") +
                '}';
    }

    @Override
    public int getAge() {
        return super.getAge();
    }

    @Override
    public String getGender() {
        return super.getGender();
    }
}
