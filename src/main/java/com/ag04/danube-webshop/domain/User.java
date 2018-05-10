/**
 * 
 */
package com.ag04.danube-webshop.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * @author Lukša Kraljević, Srce
 *
 */
@Data
@Entity
public class User {
   @Id
   @GeneratedValue
   private Integer id;
   
   @NotEmpty
   @NotNull
   private String username;
   
   @ManyToMany( cascade = {CascadeType.ALL} )
   @JoinTable( name= "user_has_roles", joinColumns = {@JoinColumn(name="user_id")}, inverseJoinColumns = { @JoinColumn(name = "role_id")})
   private Set<Role> hasRoles = new HashSet<>();
   
}
