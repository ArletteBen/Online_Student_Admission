/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Benite
 */
@Entity
public class Faculty {
    
   @Id
    
   
  private String facId;
private String facname;

@OneToMany(mappedBy="facid",fetch=FetchType.EAGER)
private List<Department> depId=new ArrayList<>();

    public String getFacId() {
        return facId;
    }

    public void setFacId(String facId) {
        this.facId = facId;
    }

   

   

    public String getFacname() {
        return facname;
    }

    public void setFacname(String facname) {
        this.facname = facname;
    }

   /* public String getFacDesc() {
        return facDesc;
    }

    public void setFacDesc(String facDesc) {
        this.facDesc = facDesc;
    }*/ 

    public List<Department> getDepId() {
        return depId;
    }

    public void setDepId(List<Department> depId) {
        this.depId = depId;
    }

    @Override
    public String toString() {
        return facname;
    }  
}
