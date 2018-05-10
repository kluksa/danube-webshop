/**
 * 
 */
package com.ag04.danube-webshop.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
public class Role {
   @Id
   @GeneratedValue
   private Integer id;
   
   @NotEmpty
   @NotNull
   private String roleName;
   
   @ManyToMany(mappedBy = "roles")
   private Set<User> users = new HashSet<>();
}
