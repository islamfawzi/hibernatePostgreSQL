package org.pojo.posts;

import java.io.Serializable;

public class Posts  implements java.io.Serializable {
    
    private int id;
    private String title;
    private String content;

    public Posts() {
    }
     
   
    public Posts(String title, String content) {
       this.title = title;
       this.content = content;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }




}


