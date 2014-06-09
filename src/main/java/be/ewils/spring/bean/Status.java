package be.ewils.spring.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * a Pojo representing the status of a Jenkin's job
 *
 * @author antoine
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Status {

    //--------------------------------------------------------------------------
    // Private fields
    //--------------------------------------------------------------------------    
    private String displayName;
    private Build lastCompletedBuild;
    private Build lastUnstableBuild;

    //--------------------------------------------------------------------------
    // Getters and setters
    //--------------------------------------------------------------------------
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Build getLastCompletedBuild() {
        return lastCompletedBuild;
    }

    public void setLastCompletedBuild(Build lastCompletedBuild) {
        this.lastCompletedBuild = lastCompletedBuild;
    }

    public Build getLastUnstableBuild() {
        return lastUnstableBuild;
    }

    public void setLastUnstableBuild(Build lastUnstableBuild) {
        this.lastUnstableBuild = lastUnstableBuild;
    }   
}
