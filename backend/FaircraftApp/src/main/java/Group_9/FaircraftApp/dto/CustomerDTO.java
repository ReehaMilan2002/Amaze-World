package Group_9.FaircraftApp.dto;

public class CustomerDTO {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String contactMessage;

    // Constructors, getters, and setters

    // Default constructor
    public CustomerDTO() {
    }

    // Constructor with parameters
    public CustomerDTO(Long id, String name, String email,  String phoneNumber, String contactMessage) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.contactMessage = contactMessage;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

 

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getContactMessage() {
        return contactMessage;
    }

    public void setContactMessage(String contactMessage) {
        this.contactMessage = contactMessage;
    }

    @Override
    public String toString() {
        return "CustomerDTO [id=" + id + ", name=" + name + ", email=" + email + 
        		", phoneNumber=" + phoneNumber + ", contactMessage=" + contactMessage + "]";
    }
}
