/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Controller.ChartController;
import Controller.StudentCrud;
import Dao.EducationDao;
import Dao.HibernateUtil;
import Dao.LocationDao;
import Model.Education;
import Model.Location;
import Model.Student;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Benite
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//         HibernateUtil.getSessionFactory().openSession();
//      List<String> Kigali = Arrays.asList("Gasabo", "Kicukiro", "Nyarugenge");
//        List<String> North = Arrays.asList("Gicumbi", "Gakenke", "Burera", "Rulindo", "Musanze");
//        List<String> West = Arrays.asList("Rubavu", "Nyamasheke", "Rusizi", "Rutsiro", "Nyabihu", "Ngororero", "Karongi");
//        List<String> East = Arrays.asList("Nyagatare", "Gatsibo", "Rwamagana", "Ngoma", "Kayonza", "Kirehe", "Bugesera");
//        List<String> South = Arrays.asList("Huye", "Gisagara", "Nyanza", "Ruhango", "Nyaruguru", "Nyamagabe", "Muhanga", "Kamonyi");
//
//        Map<String, List<String>> map = new HashMap<>();
//        map.put("KIGALI", Kigali);
//        map.put("NORTH", North);
//        map.put("WEST", West);
//        map.put("EAST", East);
//        map.put("SOUTH", South);
//
//        for (Map.Entry<String, List<String>> mm : map.entrySet()) {
//            Location p = new Location();
//            p.setLocationName(mm.getKey());
//            p.setLocationType("PROVINCE");
//            new LocationDao().create(p);
//
//            for (String instring : mm.getValue()) {
//                Location loc = new Location();
//                loc.setLocationName(instring);
//                loc.setLocationType("DISTRICT");
//                loc.setLocation(p);
//                new LocationDao().create(loc);
//
//            }
//        }
    List<String> IT = Arrays.asList("Networks", "Software Eng", "Info");
        List<String> Business = Arrays.asList("Marketing", "Accounting");
        List<String> Theology = Arrays.asList("Bible");
       

        Map<String, List<String>> map = new HashMap<>();
        map.put("IT", IT);
        map.put("BUSINESS", Business);
        map.put("THEOLOGY", Theology);
      

        for (Map.Entry<String, List<String>> mm : map.entrySet()) {
            Education e = new Education();
            e.setEducationName(mm.getKey());
            e.setEducationType("FACULTY");
            new EducationDao().create(e);

            for (String instring : mm.getValue()) {
                Education edu = new Education();
                edu.setEducationName(instring);
                edu.setEducationType("DEPARTMENT");
                edu.setEducation(e);
                new EducationDao().create(edu);

            }
        }
   
    }
}
