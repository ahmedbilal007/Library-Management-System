public abstract class User {
    private String name;
    private String address;
    private String contact;
    private String email;

    public User(String name, String address, String contact, String email) {
        this.name = name;
        this.address = address;
        this.contact = contact;
        setEmail(email);
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

    public String setEmail(String email) {
        if (Library.isEmailValid(email) == true) {
            this.email = email;
            return "EMAIL SET";
        }
        else return "INVALID EMAIL.";
    }


    @Override
    public String toString() {
        return String.format("Name: %s\nAddress: %s\nEmail: %s\nContact: %s", this.getName(), this.getAddress(), this.getEmail(), this.getContact());
    }
 }
