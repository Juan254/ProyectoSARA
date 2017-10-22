package co.edu.uniquindio.android.electiva.saramonitor.vo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Juan on 21/10/2017.
 */

public class Citas implements Parcelable{


    private String nombre, semestre, linea,cedula, estado, fecha_cita;


    public Citas(String fecha_cita, String nombre, String semestre, String linea, String cedula, String estado) {
        this.fecha_cita = fecha_cita;
        this.nombre = nombre;
        this.semestre = semestre;
        this.linea = linea;
        this.cedula = cedula;
        this.estado = estado;
    }

    public static final Creator<Citas> CREATOR = new Creator<Citas>() {
        @Override
        public Citas createFromParcel(Parcel in) {
            return new Citas(in);
        }

        @Override
        public Citas[] newArray(int size) {
            return new Citas[size];
        }
    };

    public Citas(Parcel in) {
        nombre = in.readString();
        cedula = in.readString();
        semestre = in.readString();
        estado = in.readString();
        linea = in.readString();
        fecha_cita = in.readString();
    }

    public String getFecha_cita() {
        return fecha_cita;
    }

    public void setFecha_cita(String fecha_cita) {
        this.fecha_cita = fecha_cita;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Citas{" +
                "fecha_cita=" + fecha_cita +
                ", nombre='" + nombre + '\'' +
                ", semestre='" + semestre + '\'' +
                ", linea='" + linea + '\'' +
                ", cedula='" + cedula + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nombre);
        parcel.writeString(cedula);
        parcel.writeString(semestre);
        parcel.writeString(estado);
        parcel.writeString(linea);
        parcel.writeString(fecha_cita);
    }
}
