package co.edu.uniquindio.android.electiva.proyectosara.vo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by andre on 26/10/2017.
 */

public class Cita implements Parcelable{

    private int semestreEstudiante;
    private int horaAsesoria;
    private String nombreEstudiante, lineaMonitoria;

    public Cita(int cedulaEstudiante, int semestreEstudiante, int horaAsesoria, String nombreEstudiante, String lineaMonitoria) {
        this.cedulaEstudiante = cedulaEstudiante;
        this.semestreEstudiante = semestreEstudiante;
        this.horaAsesoria = horaAsesoria;
        this.nombreEstudiante = nombreEstudiante;
        this.lineaMonitoria = lineaMonitoria;
    }

    protected Cita(Parcel in) {
        cedulaEstudiante = in.readInt();
        semestreEstudiante = in.readInt();
        horaAsesoria = in.readInt();
        nombreEstudiante = in.readString();
        lineaMonitoria = in.readString();
    }

    public static final Creator<Cita> CREATOR = new Creator<Cita>() {
        @Override
        public Cita createFromParcel(Parcel in) {
            return new Cita(in);
        }

        @Override
        public Cita[] newArray(int size) {
            return new Cita[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(cedulaEstudiante);
        parcel.writeInt(semestreEstudiante);
        parcel.writeInt(horaAsesoria);
        parcel.writeString(nombreEstudiante);
        parcel.writeString(lineaMonitoria);
    }

    private int cedulaEstudiante;

    public int getCedulaEstudiante() {
        return cedulaEstudiante;
    }

    public void setCedulaEstudiante(int cedulaEstudiante) {
        this.cedulaEstudiante = cedulaEstudiante;
    }

    public int getSemestreEstudiante() {
        return semestreEstudiante;
    }

    public void setSemestreEstudiante(int semestreEstudiante) {
        this.semestreEstudiante = semestreEstudiante;
    }

    public int getHoraAsesoria() {
        return horaAsesoria;
    }

    public void setHoraAsesoria(int horaAsesoria) {
        this.horaAsesoria = horaAsesoria;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public String getLineaMonitoria() {
        return lineaMonitoria;
    }

    public void setLineaMonitoria(String lineaMonitoria) {
        this.lineaMonitoria = lineaMonitoria;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "cedulaEstudiante=" + cedulaEstudiante +
                ", semestreEstudiante=" + semestreEstudiante +
                ", horaAsesoria=" + horaAsesoria +
                ", nombreEstudiante='" + nombreEstudiante + '\'' +
                ", lineaMonitoria='" + lineaMonitoria + '\'' +
                '}';
    }

}
