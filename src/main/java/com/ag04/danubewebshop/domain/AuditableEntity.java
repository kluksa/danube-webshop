/**
 * 
 */
package com.ag04.danubewebshop.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

/**
 * @author Lukša Kraljević, Srce
 *
 */
public abstract class AuditableEntity implements Serializable{
   @Column(nullable = false, updatable = false)
   @Temporal(TemporalType.TIMESTAMP)
   @CreatedDate
   private Date createdAt;

   @Column(nullable = false)
   @Temporal(TemporalType.TIMESTAMP)
   @LastModifiedDate
   private Date updatedAt;

}
