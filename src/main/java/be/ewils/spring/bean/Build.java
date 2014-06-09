package be.ewils.spring.bean;

import java.net.URL;

/**
 * A pojo representing a Jenkins build
 * 
 * @author antoine
 */
public class Build {
    //--------------------------------------------------------------------------
    // Private fields
    //--------------------------------------------------------------------------
    private Integer number;
    private URL url;

    //--------------------------------------------------------------------------
    // Getters and setters
    //--------------------------------------------------------------------------    
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }
}
