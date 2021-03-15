/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoiceGenerator.model;

import invoiceGenerator.model.Identity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author tnebes
 */

@Entity(name = "operator")
public class Operator extends Identity {
    
    @NotNull(message = "A password is required.")
    @NotEmpty(message = "A password is required.")
    private String password;

    @NotNull(message = "An email is required.")
    @NotEmpty(message = "An email is required.")
    private String email;

    @Column(name = "first_name")
    @Size(max = 50)
    private String firstName;

    @Size(max = 50)
    @Column(name = "last_name")
    private String lastName;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getFirstLastName() {
        return firstName + " " + lastName; 
    }
      
    
}
