/**
 * 
 */
package com.ag04.danubewebshop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author Lukša Kraljević, Srce
 *
 */
@Entity
@Data
public class ProductCategory {
   @Id
   @GeneratedValue
   private Integer id;
   
   @NotNull
   private String description;
}
