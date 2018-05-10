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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * @author Lukša Kraljević, Srce
 *
 */
@Data
@Entity
public class Item {
   @Id
   @GeneratedValue
   private Integer id;
   
   
   @NotNull
   @NotEmpty
   private String productName;

   @NotNull
   @ManyToOne(cascade = CascadeType.ALL)
   private ProductCategory productCategory;
   
   @NotNull
   @NotEmpty
   private String description;
   
   private String pictureUrl;
   
   private String picture;

   
   @NotNull
   @ManyToOne(cascade = CascadeType.ALL)
   private User author;
   
   private Date timestamp;
   

}
