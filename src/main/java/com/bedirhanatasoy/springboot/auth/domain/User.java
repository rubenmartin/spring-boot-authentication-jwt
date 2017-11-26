package com.bedirhanatasoy.springboot.auth.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.bedirhanatasoy.springboot.auth.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
public class User implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;
	
    @Column(unique = true)
    private String username;
    
    @JsonIgnore
    private String password;
    
    private String firstName;
    
    private String lastName;
    

    @Column(unique = true)
    private String email;
    
    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Role> roles;
    
    private boolean accountNonExpired, accountNonLocked, credentialsNonExpired, enabled;

    public User() {
       this.accountNonExpired = true;
       this.accountNonLocked = true;
       this.credentialsNonExpired = true;
       this.enabled = true;
    }

 
    public void grantAuthority(Role authority) {
        if ( roles == null ) roles = new ArrayList<>();
        roles.add(authority);
    }
    
    @Override
    public List<GrantedAuthority> getAuthorities(){
        List<GrantedAuthority> authorities = new ArrayList<>();
        roles.forEach(role -> authorities.add(new SimpleGrantedAuthority(role.toString())));
        return authorities;
    }

	@JsonIgnore
	public String getPassword() {
		return password;
	}
	
	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		String string = String.format("User[%s]", id);
		string += String.format("\n username[%s]", username);
		string += String.format("\n firstName[%s]", firstName);
		string += String.format("\n lastName[%s]", lastName);
		string += String.format("\n email[%s]", email);
		return string;
	}

}
