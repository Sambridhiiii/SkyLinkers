package com.Skylinker.model;

/**
 * CustomerModel represents a customer entity with personal details.
 * It includes information such as name, email, phone, and password (create).
 */
public class CustomerModel {
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String create; // Usually used for password creation

    /**
     * Constructs a CustomerModel with all attributes.
     *
     * @param firstname customer's first name
     * @param lastname  customer's last name
     * @param email     customer's email address
     * @param phone     customer's phone number
     * @param create    password or created credential
     */
    public CustomerModel(String firstname, String lastname, String email, String phone, String create) {
        super();
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.create = create;
    }

    /**
     * Constructs a CustomerModel with only email and create (password).
     *
     * @param email  customer's email address
     * @param create password or created credential
     */
    public CustomerModel(String email, String create) {
        super();
        this.email = email;
        this.create = create;
    }

    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCreate() {
        return create;
    }
    public void setCreate(String create) {
        this.create = create;
    }
}
