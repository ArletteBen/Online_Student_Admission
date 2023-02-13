/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.EducationDao;
import Dao.GeneralDao;
import Dao.HibernateUtil;
import Dao.LocationDao;

import Model.Department;
import Model.District;
import Model.Education;
import Model.Faculty;
import Model.Location;
import Model.Province;
import Model.StaffAc;
import Model.Student;
import Model.StudentAc;
import Model.enums.Gender;
import Model.enums.Program;
import Model.enums.YearLevel;
import SessionListener.OnlineUsersCounter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Query;
import org.hibernate.SQLQuery;

import org.hibernate.Session;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author Benite
 */
@ManagedBean(name="pers")
@SessionScoped
public class StudentCrud {
   
  
    private Student student = new Student();
//private Faculty fac=new Faculty();
//private Department dep=new Department();
private StudentAc sa=new StudentAc();
private StaffAc staffac=new StaffAc();

   




   

    public StaffAc getStaffac() {
        return staffac;
    }

    public void setStaffac(StaffAc staffac) {
        this.staffac = staffac;
    }

  
    

  
  

  

   


    public Student getStudent() {
        return student;
    }

  

    public List<String> getGenders() {
          List<String> gender = new ArrayList<>();
        for (Gender g : Gender.values()) {
            gender.add(g.toString());
        }
        return gender;
       
    }

    public List<String> getYears() {
        List<String> year=new ArrayList<>();
        for(YearLevel y:YearLevel.values()){
            year.add(y.toString());
        }
        return year;
    }
    public List<String> getPrograms() {
        List<String> program=new ArrayList<>();
        for(Program y:Program.values()){
            program.add(y.toString());
        }
        return program;
    }
    
public List<Faculty> getFacs(){
    GeneralDao<Faculty> fdao=new GeneralDao();
     return fdao.findAll(Faculty.class);
} 
  public List<Department> getDeps(){
  
     return new GeneralDao<Department>().findAll(Department.class);
}  
 
  

  
 
 
  public List<Province> getProvinces(){
  GeneralDao<Province> pdao=new GeneralDao();
  return pdao.findAll(Province.class);
 }
  public List<District> getDists(){
  
  return new GeneralDao<District>().findAll(District.class);
 }

 
 

        //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("failed to save because of"+" "+e));

  
  

    public StudentAc getSa() {
        return sa;
    }
/* public StudentAc login() throws IOException{
     StudentAc ac=new StudentAc();
     FacesMessage message=null;
     message=new FacesMessage(FacesMessage.SEVERITY_INFO,"wlcm",display);
     FacesContext context=FacesContext.getCurrentInstance();
     context.getExternalContext().redirect("/newfodler/personalInfo.xhtml");
     return ac.userLogin(ac.getUsername(), ac.getPassword());
     
 }*/
    private String password2=new String();
    private String username=new String();
    private String password=new String();
 private String staffId=new String();
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
    
    public void checkPass(){
       try{
        if(sa.getPassword().equals(password2)){
              GeneralDao<StudentAc> sadao=new GeneralDao();
      sadao.create(sa);
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("successfully created"));
            
        }
        else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("passwords don't match")); 
        }
       }
        catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("failed to save because of"+" "+e)); 
            
        }
    }
     public void checkAdminPass(){
       try{
        if(staffac.getPassword().equals(password2)){
              GeneralDao<StaffAc> sadao=new GeneralDao();
      sadao.create(staffac);
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("successfully created"));
            
        }
        else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("passwords don't match")); 
        }
       }
        catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("failed to save because of"+" "+e)); 
            
        }
    }
 public  int getStudents(){
    List<Student> sts=new GeneralDao<Student>().findAll(Student.class);
    return sts.size();
 }  
 
 private List<String> data=null;
 private List<String> result=null;
 private String display="";

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public List<String> getResult() {
        return result;
    }

    public void setResult(List<String> result) {
        this.result = result;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }
    
    
     List<Location> location=new LocationDao().findAll(Location.class);
     List<Education> education=new EducationDao().findAll(Education.class);
    
    private List<Location> prov = new ArrayList<>();
    private List<Location> dis = new ArrayList<>();
    
        private List<Education> fac = new ArrayList<>();
    private List<Education> dep = new ArrayList<>();

  private String ProvId = new String();
    private String DistId = new String();
    
       
    private String FacId = new String();
    private String DepId = new String();
     List<Student> stList=new GeneralDao<Student>().findAll(Student.class);

    public List<Location> getLocation() {
        return location;
    }

    public void setLocation(List<Location> location) {
        this.location = location;
    }

    public List<Education> getEducation() {
        return education;
    }

    public void setEducation(List<Education> education) {
        this.education = education;
    }

    public List<Location> getProv() {
        return prov;
    }

    public void setProv(List<Location> prov) {
        this.prov = prov;
    }

    public List<Location> getDis() {
        return dis;
    }

    public void setDis(List<Location> dis) {
        this.dis = dis;
    }

    public List<Education> getFac() {
        return fac;
    }

    public void setFac(List<Education> fac) {
        this.fac = fac;
    }

    public List<Education> getDep() {
        return dep;
    }

    public void setDep(List<Education> dep) {
        this.dep = dep;
    }

    public String getProvId() {
        return ProvId;
    }

    public void setProvId(String ProvId) {
        this.ProvId = ProvId;
    }

    public String getDistId() {
        return DistId;
    }

    public void setDistId(String DistId) {
        this.DistId = DistId;
    }

    public String getFacId() {
        return FacId;
    }

    public void setFacId(String FacId) {
        this.FacId = FacId;
    }

    public String getDepId() {
        return DepId;
    }

    public void setDepId(String DepId) {
        this.DepId = DepId;
    }

    public List<Student> getStList() {
        return stList;
    }

    public void setStList(List<Student> stList) {
        this.stList = stList;
    }

 
    
 @PostConstruct
 public void init(){
     data=new ArrayList<>();
     result=new ArrayList<>();
    /*Session s=HibernateUtil.getSessionFactory().openSession();
     SQLQuery q=s.createSQLQuery("select depname from Department");
       q.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List d=q.list();
        for(Object i:data){
            Map m=(Map) i;
          data.add(m.get("depname").toString());
        }
   
     s.close();*/
   data.add("Software Engineering");
   data.add("Information management");
   data.add("Networking");
      
        
   
   prov = new ArrayList<>();
        for (Location loc : location) {
            if (loc.getLocationType().equals("PROVINCE")) {
                prov.add(loc);
            }
        }
        
                fac = new ArrayList<>();
        for (Education edu : education) {
            if (edu.getEducationType().equals("FACULTY")) {
                fac.add(edu);
            }
        }
         
 }
 public void distrPro() {
        dis = new ArrayList<>();
        for (Location loc : location) {
            if (loc.getLocation() != null && loc.getLocation().getLId().equals(ProvId)) {
                dis.add(loc);
            }
        }
    }
  public Location finalLoc() {
        for (Location loc : location) {
            if (loc.getLId().equals(DistId)) {
                return loc;
            }
        }
        return null;
    }

    
     public void depPro() {
        dep = new ArrayList<>();
        for (Education edu : education) {
            if (edu.getEducation()!= null && edu.getEducation().getEId().equals(FacId)) {
                dep.add(edu);
            }
        }
    }

    public Education finalEdu() {
        for (Education edu : education) {
            if (edu.getEId().equals(DepId)) {
                return edu;
            }
        }
        return null;
    }
     public void create(){
      try{
      GeneralDao<Student> sdao=new GeneralDao();
       student.setLocation(finalLoc());
      student.setEducation(finalEdu());
      sdao.create(student);
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("successfully registered,you should wait for the approval or rejection"));
      }catch(Exception e){
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("failed to register because of"+" "+e));  
      }
  }

    
 public void search(){
     result.clear();
     for(String d:data){
         if(d.toUpperCase().startsWith(display.toLowerCase())){
             result.add(d);
         }
     }
     if(result.isEmpty()){
         result.add("NOT FOUND");
     }
 }
 public String checkLogin(){
  
         Session s=HibernateUtil.getSessionFactory().openSession();
         Query q=s.createQuery("from StudentAc where username=:username and password=:password");
         q.setString("username", username);
         q.setString("password", password);
         List<StudentAc> lst=q.list();
         if(lst.size()==1){
             s.close();
             return "result";
             
         }else{
             s.close();
              FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("username or password incorrect"));
             return "Myaccount";
         }
        
 }
 public String checkAdminLogin(){
  
         Session s=HibernateUtil.getSessionFactory().openSession();
         Query q=s.createQuery("from StaffAc where staffId=:staffId and password=:password");
         q.setString("staffId",staffId);
         q.setString("password", password);
         List<StudentAc> lst=q.list();
         if(lst.size()==1){
             s.close();
             

             return "Dashboard";
             
         }else{
             s.close();
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("username or password incorrect"));

             return "Admin";
         }
        
 }
public String logout(){
    System.out.println("log out is invoked");
    FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    return "App";
      
}
 public int getSessionCount() {
        System.out.println("session count getter invoked");
        return OnlineUsersCounter.getNumberOfUsersOnline();
    }
public List<Student> getAllStudents(){
    return new GeneralDao<Student>().findAll(Student.class);
}

private String studId=new String();

    public String getStudId() {
        return studId;
    }

    public void setStudId(String studId) {
        this.studId = studId;
    }

public Student getOneStudent(){
    Session s=HibernateUtil.getSessionFactory().openSession();
    SQLQuery q=s.createSQLQuery("select studId,fname,lname,approval_appId from Student where studId=:studId");
    q.setString("studId", studId);
    Student st=(Student) q.uniqueResult();
    return st;
    
}
private String depCode=new String();

    public String getDepCode() {
        return depCode;
    }

    public void setDepCode(String depCode) {
        this.depCode = depCode;
    }

 

public void countStudInDeps(){
     Session s=HibernateUtil.getSessionFactory().openSession();
    SQLQuery q=s.createSQLQuery("select depCode_depId from Student where depCode_depId=:depCode");
    q.setString("depCode", depCode);
    List<Student> st=q.list();
    if( st.size()>100){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("department is full"));
    }
    else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("department is not yet full"));
    }
}
public void approve(Student s){
    try{
  
   s.setSchoolstatus("Approved");
    GeneralDao<Student> stdao=new GeneralDao();
       stdao.update(s);
           
 
    }catch(Exception e){
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("failed because of"+" "+e));  
    }
}
public void reject(Student s){
    try{
  
   s.setSchoolstatus("Rejected");
    GeneralDao<Student> stdao=new GeneralDao();
       stdao.update(s);
           
 
    }catch(Exception e){
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("failed because of"+" "+e));  
    }
}
public List<Student> approved(){
    
    Session s=HibernateUtil.getSessionFactory().openSession();
    Query q=s.createQuery("from Student where schoolstatus='Approved'");
  
    List<Student> st=q.list();    
  out.println("Their total is"+st.size());
   return st;
}       
public int rejected(){
    
    Session s=HibernateUtil.getSessionFactory().openSession();
    Query q=s.createQuery("from Student where schoolstatus='Rejected'");
  
    List<Student> st=q.list();    
  
   return st.size();
}     



}
