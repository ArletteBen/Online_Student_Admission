/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.enums.Gender;
import Model.enums.Program;
import Model.enums.YearLevel;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Benite
 */
@Entity
public class Student {
 
    @Id
      
   @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int studId;
    private String fname;
    private String lname;
    private Gender gender;
    private YearLevel yearLevel;

    private String email;
    private String phone;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dob;
   
  
    private String ALevel;
    private String Olevel;
      private String Prim;
  private String comment;
    private String ALevelFromTill;
    private String OlevelFromTil;
    private String primaryFromTil;
    private String guardian;
  
   // private String talents;
    private String OtherTalents;
   
   // private String sports;
    private String otherSports;
    private String Scholarship;
    private String sponsor;
private Program program;
  private String schoolstatus;  



    
@ManyToOne
private Location location;

@ManyToOne
private Education education;  

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }
 
 
public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }


    public int getStudId() {
        return studId;
    }

    public void setStudId(int studId) {
        this.studId = studId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public YearLevel getYearLevel() {
        return yearLevel;
    }

    public void setYearLevel(YearLevel yearLevel) {
        this.yearLevel = yearLevel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getALevel() {
        return ALevel;
    }

    public void setALevel(String ALevel) {
        this.ALevel = ALevel;
    }

    public String getOlevel() {
        return Olevel;
    }

    public void setOlevel(String Olevel) {
        this.Olevel = Olevel;
    }

    public String getPrim() {
        return Prim;
    }

    public void setPrim(String Prim) {
        this.Prim = Prim;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getALevelFromTill() {
        return ALevelFromTill;
    }

    public void setALevelFromTill(String ALevelFromTill) {
        this.ALevelFromTill = ALevelFromTill;
    }

    public String getOlevelFromTil() {
        return OlevelFromTil;
    }

    public void setOlevelFromTil(String OlevelFromTil) {
        this.OlevelFromTil = OlevelFromTil;
    }

    public String getPrimaryFromTil() {
        return primaryFromTil;
    }

    public void setPrimaryFromTil(String primaryFromTil) {
        this.primaryFromTil = primaryFromTil;
    }

    public String getGuardian() {
        return guardian;
    }

    public void setGuardian(String guardian) {
        this.guardian = guardian;
    }

    public String getOtherTalents() {
        return OtherTalents;
    }

    public void setOtherTalents(String OtherTalents) {
        this.OtherTalents = OtherTalents;
    }

    public String getOtherSports() {
        return otherSports;
    }

    public void setOtherSports(String otherSports) {
        this.otherSports = otherSports;
    }

    public String getScholarship() {
        return Scholarship;
    }

    public void setScholarship(String Scholarship) {
        this.Scholarship = Scholarship;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public String getSchoolstatus() {
        return schoolstatus;
    }

    public void setSchoolstatus(String schoolstatus) {
        this.schoolstatus = schoolstatus;
    }

   


    

}
