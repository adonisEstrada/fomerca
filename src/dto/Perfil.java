package dto;
// Generated 03/08/2018 12:14:52 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Perfil generated by hbm2java
 */
public class Perfil  implements java.io.Serializable {


     private int perfilId;
     private String description;
     private Set users = new HashSet(0);

    public Perfil() {
    }

	
    public Perfil(int perfilId) {
        this.perfilId = perfilId;
    }
    public Perfil(int perfilId, String description, Set users) {
       this.perfilId = perfilId;
       this.description = description;
       this.users = users;
    }

    public Perfil(int perfilId, String description) {
        this.perfilId = perfilId;
        this.description = description;
    }
   
    public int getPerfilId() {
        return this.perfilId;
    }
    
    public void setPerfilId(int perfilId) {
        this.perfilId = perfilId;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public Set getUsers() {
        return this.users;
    }
    
    public void setUsers(Set users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Perfil other = (Perfil) obj;
        if (this.perfilId != other.perfilId) {
            return false;
        }
        return true;
    }
    
    
}


