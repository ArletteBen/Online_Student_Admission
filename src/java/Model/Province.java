/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Benite
 */
@Entity
public class Province {
     @Id
 private String code;
 private String name;
 @OneToMany(mappedBy="province",fetch=FetchType.EAGER)
private List<District> district;
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<District> getDistrict() {
        return district;
    }

    public void setDistrict(List<District> district) {
        this.district = district;
    }

    @Override
    public String toString() {
        return name ;
    }  
}
