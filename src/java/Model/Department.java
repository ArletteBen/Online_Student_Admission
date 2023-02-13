/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Benite
 */
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "depId", updatable = false, nullable = false)
   private int depId;
   private String depname;
 
   @ManyToOne
     @JoinColumn(name = "facid")
   private Faculty facid=new Faculty();
  
    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
        this.depId = depId;
    }

    public Faculty getFacid() {
        return facid;
    }

    public void setFacid(Faculty facid) {
        this.facid = facid;
    }

   
    public String getDepname() {
        return depname;
    }

    public void setDepname(String depname) {
        this.depname = depname;
    }

    

    public Faculty getFac() {
        return facid;
    }

    public void setFac(Faculty fac) {
        this.facid = fac;
    }

    

    @Override
    public String toString() {
        return depname ;
    } 
}
