/**
 * 
 */
package com.ag04.danubewebshop.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @author Lukša Kraljević, Srce
 *
 */
@Entity
@Table(name="tbl_user")
@EntityListeners(AuditingEntityListener.class)
public class User {
	@Id
	@GeneratedValue
	private Integer id;

	@NotEmpty
	@NotNull
	private String username;
	
	private String password;
	
   private boolean enabled;

	@ManyToMany(cascade = { CascadeType.ALL } )
	@JoinTable(name = "user_has_roles", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "role_id") })
	private Set<Role> hasRoles = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public boolean isEnabled() {
      return enabled;
   }

   public void setEnabled(boolean enabled) {
      this.enabled = enabled;
   }

   public Set<Role> getHasRoles() {
		return hasRoles;
	}

	public void setHasRoles(Set<Role> hasRoles) {
		this.hasRoles = hasRoles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hasRoles == null) ? 0 : hasRoles.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (hasRoles == null) {
			if (other.hasRoles != null)
				return false;
		} else if (!hasRoles.equals(other.hasRoles))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

   @Override
   public String toString() {
      return "User [id=" + id + ", username=" + username + ", hasRoles= + hasRoles + ]";
   }

	
}
