/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Education {
       @Id
    private String EId=UUID.randomUUID().toString();
    private String EducationName;
    private String EducationType;
    @ManyToOne
    private Education education;

    @Override
    public String toString() {
        return EducationName;
    }

    public String getEId() {
        return EId;
    }

    public void setEId(String EId) {
        this.EId = EId;
    }

    public String getEducationName() {
        return EducationName;
    }

    public void setEducationName(String EducationName) {
        this.EducationName = EducationName;
    }

    public String getEducationType() {
        return EducationType;
    }

    public void setEducationType(String EducationType) {
        this.EducationType = EducationType;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }
    
    
    
}
