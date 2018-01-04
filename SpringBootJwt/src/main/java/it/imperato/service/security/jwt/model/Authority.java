package it.imperato.service.security.jwt.model;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author Francesco
 */

//@Entity
//@Table(name="Authority")
public class Authority implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	//    @Id
//    @Column(name="id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

//    @Column(name="name")
    String name;

    @Override
    public String getAuthority() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public String getName() {
        return name;
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
