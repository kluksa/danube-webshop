/**
 * 
 */
package com.ag04.danubewebshop.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@MappedSuperclass
public abstract class AuditableEntity implements Serializable {
	@Column(name = "created_at", nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	protected Date createdAt;

	@Column(name = "created_by", nullable = false, updatable = false)
	@CreatedBy
	protected String createdBy;
	
   @Column(name = "modified_at")
   @Temporal(TemporalType.TIMESTAMP)
   @LastModifiedDate
   protected Date modifiedAt;
   
   @Column(name = "modified_by")
   @LastModifiedBy
   protected String modifiedBy;

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public Date getModifiedAt() {
      return modifiedAt;
   }

   public void setModifiedAt(Date modifiedAt) {
      this.modifiedAt = modifiedAt;
   }

   public String getModifiedBy() {
      return modifiedBy;
   }

   public void setModifiedBy(String modifiedBy) {
      this.modifiedBy = modifiedBy;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
      result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
      result = prime * result + ((modifiedAt == null) ? 0 : modifiedAt.hashCode());
      result = prime * result + ((modifiedBy == null) ? 0 : modifiedBy.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      AuditableEntity other = (AuditableEntity) obj;
      if (createdAt == null) {
         if (other.createdAt != null)
            return false;
      } else if (!createdAt.equals(other.createdAt))
         return false;
      if (createdBy == null) {
         if (other.createdBy != null)
            return false;
      } else if (!createdBy.equals(other.createdBy))
         return false;
      if (modifiedAt == null) {
         if (other.modifiedAt != null)
            return false;
      } else if (!modifiedAt.equals(other.modifiedAt))
         return false;
      if (modifiedBy == null) {
         if (other.modifiedBy != null)
            return false;
      } else if (!modifiedBy.equals(other.modifiedBy))
         return false;
      return true;
   }
}
