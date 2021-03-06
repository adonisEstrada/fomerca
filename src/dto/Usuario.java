package dto;
// Generated 03/08/2018 12:14:52 AM by Hibernate Tools 4.3.1

/**
 * User generated by hbm2java
 */
public class Usuario implements java.io.Serializable {

    private int usuarioId;
    private Perfil perfil;
    private String name;
    private String pass;
    private Boolean activo;

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Usuario() {
    }

    public Usuario(Perfil perfil, String name, String pass, Boolean activo) {
        this.perfil = perfil;
        this.name = name;
        this.pass = pass;
        this.activo = activo;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Perfil getPerfil() {
        return this.perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return this.pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Usuario other = (Usuario) obj;
        if (this.usuarioId != other.usuarioId) {
            return false;
        }
        return true;
    }

}
