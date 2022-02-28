package ca.bnc.demo.api;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class HelloWorld {
    private String id;
    private String message;
   // private Date lastModified;

    public HelloWorld() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HelloWorld(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public void setLastModified(Date lastModified) {
      //  this.lastModified = lastModified;
    }

   // public Date getLastModified() {
        //return lastModified;
    //    return null;
    //}
}