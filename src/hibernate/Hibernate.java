package hibernate;

import com.sun.corba.se.spi.logging.CORBALogDomains;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.pojo.posts.Posts;
import org.util.HibernateUtil;


public class Hibernate {

    private HibernateUtil util;
    
    public static void main(String[] args) {

     Hibernate hibernate = new Hibernate();
     
     // INSERT
     hibernate.addPost("Post title 3", "Post Content 3");
     
     // SELECT *
     hibernate.listPosts();
     
     // SELECT 
     hibernate.getPost(1);
     
     // UPDATE
     hibernate.updatePost(1, "post title 1", "post content 1");
     
     // DELETE
     hibernate.deletePost(3);
   
    }
    
    public void addPost(String title, String content){
       
        Posts post = new Posts("post title 3", "post content 3");
        util = new HibernateUtil();
        Session session = util.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(post);
        session.getTransaction().commit();
        session.close();
    
    }
    
    public void listPosts(){
    
        Session session = util.getSessionFactory().openSession();
        session.beginTransaction();
        List posts = session.createQuery("FROM Posts").list();
        for (Iterator iterator = posts.iterator(); iterator.hasNext();){
            Posts p = (Posts) iterator.next(); 
            System.out.println("|" + p.getId() + "|" + p.getTitle() + "|" + p.getContent());
        }
        session.getTransaction().commit();
        session.close();
        
    }
    
    public void getPost(int id){
    
        Session session = util.getSessionFactory().openSession();
        session.beginTransaction();
        Posts p = (Posts) session.get(Posts.class, id);
        System.out.println("|" + p.getId() + "|" + p.getTitle() + "|" + p.getContent());
        session.getTransaction().commit();
        session.close();
    }
    
    public void updatePost(int id, String title, String content){
     
        Session session = util.getSessionFactory().openSession();
        session.beginTransaction();
        Posts p = (Posts) session.get(Posts.class, id);
        p.setTitle(title);
        p.setContent(content);
        session.update(p);
        session.getTransaction().commit();
        session.close();
        
    }
    
    public void deletePost(int id){
     
        Session session = util.getSessionFactory().openSession();
        session.beginTransaction();
        Posts p = (Posts) session.get(Posts.class, id);
        session.delete(p);
        session.getTransaction().commit();
        session.close();
    
    }
    
}
