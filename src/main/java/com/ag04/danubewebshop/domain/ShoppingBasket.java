/**
 * 
 */
package com.ag04.danubewebshop.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * @author Lukša Kraljević, Srce
 *
 */
@Data
@Entity
public class ShoppingBasket {
   
   @Id
   @GeneratedValue
   private Integer id;
   
   @NotNull
   @ManyToOne(cascade = CascadeType.ALL)
   private User user;
   
   @NotNull
   @ManyToOne(cascade = CascadeType.ALL)
   private Item item;
   
   private Date time;

}
