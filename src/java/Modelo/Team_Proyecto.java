/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author chris
 */
public class Team_Proyecto {
    private int Idteam;
    private int id_equipo;
    private int id_empleado_team;

    public Team_Proyecto() {
    }
 public Team_Proyecto(int Idteam) {
        this.Idteam = Idteam;
       
    }
    public Team_Proyecto(int Idteam, int id_equipo, int id_empleado_team) {
        this.Idteam = Idteam;
        this.id_equipo = id_equipo;
        this.id_empleado_team = id_empleado_team;
    }
    //setter

    public void setIdteam(int Idteam) {
        this.Idteam = Idteam;
    }

    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }

    public void setId_empleado_team(int id_empleado_team) {
        this.id_empleado_team = id_empleado_team;
    }
    //getter

    public int getIdteam() {
        return Idteam;
    }

    public int getId_equipo() {
        return id_equipo;
    }

    public int getId_empleado_team() {
        return id_empleado_team;
    }
    
}
