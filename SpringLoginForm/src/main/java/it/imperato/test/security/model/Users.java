package it.imperato.test.security.model;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
@NamedQueries(
        @NamedQuery(name = Users.GET_BY_EMAIL,query = Users.GET_BY_EMAIL_QUERY)
)
public class Users extends BaseEntity implements Serializable {


    public static final String GET_BY_EMAIL="Users.findByEmail";
    public static final String GET_BY_EMAIL_QUERY="FROM Users u WHERE u.email= :email";

    @Id
    @GeneratedValue
    @Column(name = "idusers")
    private  int id;

    @Column(name = "fname")
    private String firstName;

    @Column(name = "lname")
    private String lastName;


    @Column(name = "email")
    private String email;

    @Column(name = "pnumber")
    private String mobileNumber;


    @JsonIgnore
    @Column(name = "password")
    private String password;

    @JsonIgnore
    @Transient
    private String confirmPassword;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('ROLE_CUSTOMER','ROLE_MANAGER','ROLE_ADMIN')")
    private Role role=Role.ROLE_CUSTOMER;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", role=" + role +
                '}';
    }
}
