public abstract class User {
    private String name;
    private String address;
    private String contact;
    private String email;

    public User(String name, String address, String contact, String email) {
        this.name = name;
        this.address = address;
        this.contact = contact;
        if (isEmailValid(email) == true) this.email = email;
        else {
            System.out.println("Invalid Email Address.");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEmailValid(String email) {
        return email.endsWith("@gmail.com");
    }

    @Override
    public String toString() {
        return String.format("Name: %s\nAddress: %s\nEmail: %s\nContact: %s", this.getName(), this.getAddress(), this.getEmail(), this.getContact());
    }
 }
