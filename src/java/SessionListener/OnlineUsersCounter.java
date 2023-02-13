/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionListener;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author Benite
 */
@WebListener
public class OnlineUsersCounter implements HttpSessionListener{
   /* private List<String> sessions=new ArrayList<>();
    public static final String counter="session-counter";
    public void sessionCreated(HttpSessionEvent event){
        System.out.println("SessionCounter.sessionCreate");
        HttpSession session=event.getSession();
        sessions.add(session.getId());
        session.setAttribute(OnlineUsersCounter.counter,this);
    
 }
    public void sessionDestroyed(HttpSessionEvent event){
        System.out.println("SessionCounter.sessionDestroyed");
        HttpSession session=event.getSession();
        sessions.remove(session.getId());
        session.setAttribute(OnlineUsersCounter.counter,this);
    
 }
    public int getActiveSessionNumber(){
        return sessions.size();
    }*/
 private static int numberOfUsersOnline;

    public OnlineUsersCounter() {
        numberOfUsersOnline=0;
    }

    
 public void sessionCreated(HttpSessionEvent event){
     System.out.println("session created:"+event.getSession().getId());
     synchronized(this){
          numberOfUsersOnline++;
     }
 }
 public void sessionDestroyed(HttpSessionEvent event){
     System.out.println("session destroyed:"+event.getSession().getId()); 
    synchronized(this){
          numberOfUsersOnline--;
     }
 }
 public static int getNumberOfUsersOnline() {
        return numberOfUsersOnline;
    }
}
