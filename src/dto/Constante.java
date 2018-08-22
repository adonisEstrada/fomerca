/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Adonis
 */
public class Constante {

    private int constanteId;
    private String key;
    private String value;
    private Boolean activo;

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Constante() {
    }

    public Constante(String key, String value, Boolean activo) {
        this.key = key;
        this.value = value;
        this.activo = activo;
    }

    public Constante(int constanteId, String key, String value) {
        this.constanteId = constanteId;
        this.key = key;
        this.value = value;
    }

    public int getConstanteId() {
        return constanteId;
    }

    public void setConstanteId(int constanteId) {
        this.constanteId = constanteId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
