package Group_9.FaircraftApp.model;

import jakarta.persistence.*;

@Entity

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // This will be the auto-incremented user ID





	private String name;
    private String phoneNumber;
    private String contactMessage;
    
    
    
    @Column(unique = true)
    private String email;
    


    // Constructors, getters, and setters

    // Default constructor
    public Customer() {
    }

    // Constructor with parameters
    public Customer(String name, String email,  String phoneNumber ,String contactMessage) {
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

//    public String getname() {
//        return name;
//    }
//
//    public void setname(String name) {
//        this.name = name;
//    }
    

//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }

    public String getEmail() {
        return email;
    }
	public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
