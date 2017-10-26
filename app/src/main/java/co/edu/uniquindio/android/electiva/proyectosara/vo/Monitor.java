package co.edu.uniquindio.android.electiva.proyectosara.vo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by andre on 26/10/2017.
 */

public class Monitor implements Parcelable {

    private int cedula, numTelefono, semestre, horaInicio, horaFin;
    private String nombre, nombreUsuario, contrasenia, lugarAtencion, lineaMonitoria;
    private ArrayList<Cita> listaCitas;
    private boolean flagOcupado;

    public Monitor(int cedula, int numTelefono, int semestre, int horaInicio, int horaFin, String nombre,
                   String nombreUsuario, String contrasenia, String lugarAtencion, String lineaMonitoria,
                   ArrayList<Cita> listaCitas, boolean flagOcupado) {
        this.cedula = cedula;
        this.numTelefono = numTelefono;
        this.semestre = semestre;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.lugarAtencion = lugarAtencion;
        this.lineaMonitoria = lineaMonitoria;
        this.listaCitas = listaCitas;
        this.flagOcupado = flagOcupado;
    }


    protected Monitor(Parcel in) {
        cedula = in.readInt();
        numTelefono = in.readInt();
        semestre = in.readInt();
        horaInicio = in.readInt();
        horaFin = in.readInt();
        nombre = in.readString();
        nombreUsuario = in.readString();
        contrasenia = in.readString();
        lugarAtencion = in.readString();
        lineaMonitoria = in.readString();
        listaCitas = in.createTypedArrayList(Cita.CREATOR);
        flagOcupado = in.readByte() != 0;

    }

    public static final Creator<Monitor> CREATOR = new Creator<Monitor>() {
        @Override
        public Monitor createFromParcel(Parcel in) {
            return new Monitor(in);
        }

        @Override
        public Monitor[] newArray(int size) {
            return new Monitor[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(cedula);
        parcel.writeInt(numTelefono);
        parcel.writeInt(semestre);
        parcel.writeInt(horaInicio);
        parcel.writeInt(horaFin);
        parcel.writeString(nombre);
        parcel.writeString(nombreUsuario);
        parcel.writeString(contrasenia);
        parcel.writeString(lugarAtencion);
        parcel.writeString(lineaMonitoria);
        parcel.writeTypedList(listaCitas);
        parcel.writeByte((byte) (flagOcupado ? 1 : 0));

    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(int numTelefono) {
        this.numTelefono = numTelefono;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(int horaFin) {
        this.horaFin = horaFin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getLugarAtencion() {
        return lugarAtencion;
    }

    public void setLugarAtencion(String lugarAtencion) {
        this.lugarAtencion = lugarAtencion;
    }

    public String getLineaMonitoria() {
        return lineaMonitoria;
    }

    public void setLineaMonitoria(String lineaMonitoria) {
        this.lineaMonitoria = lineaMonitoria;
    }

    public ArrayList<Cita> getListaCitas() {
        return listaCitas;
    }

    public void setListaCitas(ArrayList<Cita> listaCitas) {
        this.listaCitas = listaCitas;
    }

    public boolean isFlagOcupado() {
        return flagOcupado;
    }

    public void setFlagOcupado(boolean flagOcupado) {
        this.flagOcupado = flagOcupado;
    }

    @Override
    public String toString() {
        return "Monitor{" +
                "cedula=" + cedula +
                ", numTelefono=" + numTelefono +
                ", semestre=" + semestre +
                ", horaInicio=" + horaInicio +
                ", horaFin=" + horaFin +
                ", nombre='" + nombre + '\'' +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", lugarAtencion='" + lugarAtencion + '\'' +
                ", lineaMonitoria='" + lineaMonitoria + '\'' +
                ", listaCitas=" + listaCitas +
                ", flagOcupado=" + flagOcupado +
                '}';
    }
}
