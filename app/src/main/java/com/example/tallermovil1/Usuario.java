package com.example.tallermovil1;

import java.io.Serializable;
import java.util.ArrayList;

public class Usuario implements Serializable {


    int id;
    String nombre,apellido,direccion,nacimiento,email,equipoFav, peliculaFav,colorFav,comidaFav,libroFav,cancionFav,descPersonal,estadoCivil, genero,telefono;
    long documento,edad;
    ArrayList<String> gustos = new ArrayList();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEquipoFav() {
        return equipoFav;
    }

    public void setEquipoFav(String equipoFav) {
        this.equipoFav = equipoFav;
    }

    public String getPeliculaFav() {
        return peliculaFav;
    }

    public void setPeliculaFav(String peliculaFav) {
        this.peliculaFav = peliculaFav;
    }

    public String getColorFav() {
        return colorFav;
    }

    public void setColorFav(String colorFav) {
        this.colorFav = colorFav;
    }

    public String getComidaFav() {
        return comidaFav;
    }

    public void setComidaFav(String comidaFav) {
        this.comidaFav = comidaFav;
    }

    public String getCancionFav() {
        return cancionFav;
    }

    public void setCancionFav(String cancionFav) {
        this.cancionFav = cancionFav;
    }

    public String getLibroFav() {
        return libroFav;
    }

    public void setLibroFav(String libroFav) {
        this.libroFav = libroFav;
    }

    public String getDescPersonal() {
        return descPersonal;
    }

    public void setDescPersonal(String descPersonal) {
        this.descPersonal = descPersonal;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public long getDocumento() {
        return documento;
    }

    public void setDocumento(long documento) {
        this.documento = documento;
    }

    public long getEdad() {
        return edad;
    }

    public void setEdad(long edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ArrayList<String> getGustos() {
        return gustos;
    }

    public void setGustos(ArrayList<String> gustos) {
        this.gustos = gustos;
    }
}
