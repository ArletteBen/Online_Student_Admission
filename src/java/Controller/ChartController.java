/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.HibernateUtil;
import Model.Student;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import org.hibernate.Query;
import org.hibernate.Session;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author Benite
 */
@ManagedBean(name="pies")
public class ChartController {
    private PieChartModel pie;
    private PieChartModel pie1;

    public PieChartModel getPie() {
        return pie;
    }

    public void setPie(PieChartModel pie) {
        this.pie = pie;
    }

    public PieChartModel getPie1() {
        return pie1;
    }

    public void setPie1(PieChartModel pie1) {
        this.pie1 = pie1;
    }
    public List<Student> girls(){
       Session s=HibernateUtil.getSessionFactory().openSession();
       s.beginTransaction();
       Query q=s.createQuery("from Student where gender='Female' and schoolstatus='Approved'");
       List<Student> li=q.list();
       s.close();
       return li;
   }
      public List<Student> boys(){
       Session ss=HibernateUtil.getSessionFactory().openSession();
       ss.beginTransaction();
       Query q=ss.createQuery("from Student where gender='Male' and schoolstatus='Approved'");
       List<Student> li=q.list();
       ss.close();
       return li;
   }
       public List<Student> transGender(){
       Session ss=HibernateUtil.getSessionFactory().openSession();
       ss.beginTransaction();
       Query q=ss.createQuery("from Student where gender='TransGender' and schoolstatus='Approved'");
       List<Student> li=q.list();
       ss.close();
       return li;
   }
      
        public List<Student> dayStudent(){
       Session ss=HibernateUtil.getSessionFactory().openSession();
       ss.beginTransaction();
       Query q=ss.createQuery("from Student where program='Day' and schoolstatus='Approved'");
       List<Student> li=q.list();
       ss.close();
       return li;
   }
      public List<Student> eveningStudent(){
       Session ss=HibernateUtil.getSessionFactory().openSession();
       ss.beginTransaction();
       Query q=ss.createQuery("from Student where program='Evening' and schoolstatus='Approved'");
       List<Student> li=q.list();
       ss.close();
       return li;
   }
       
    private int approved=new StudentCrud().approved().size();
    private int boys=boys().size();
    
    /* @PostConstruct
   public void init(){
    pie=new PieChartModel();
        pie.set("Male", Math.round((boys / approved)*100));
        pie.set("Female", Math.round((girls().size() / approved)*100));
         pie.set("Female", Math.round((transGender().size() / approved)*100));
        pie.setLegendPosition("w");
        
         pie1=new PieChartModel();
        pie1.set("day", Math.round((dayStudent().size() / approved)*100));
        pie1.set("evening", Math.round((eveningStudent().size() / approved)*100));
      
        
        pie1.setLegendPosition("w");
   }*/
   private int girls=girls().size();
  private   int Nboys=boys().size();
   private  int trans=transGender().size();
   private  int day=dayStudent().size();
   private  int evening=eveningStudent().size();

    public int getGirls() {
        return girls;
    }

    public void setGirls(int girls) {
        this.girls = girls;
    }

    public int getNboys() {
        return Nboys;
    }

    public void setNboys(int Nboys) {
        this.Nboys = Nboys;
    }

    public int getTrans() {
        return trans;
    }

    public void setTrans(int trans) {
        this.trans = trans;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getEvening() {
        return evening;
    }

    public void setEvening(int evening) {
        this.evening = evening;
    }
     
  
}
