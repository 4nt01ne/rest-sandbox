package be.ewils.spring;

import be.ewils.spring.bean.Build;
import be.ewils.spring.bean.Status;
import com.google.common.base.Optional;
import java.net.MalformedURLException;
import java.net.URL;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@ComponentScan
@EnableAutoConfiguration
@EnableScheduling
public class Application {

    //-------------------------------------------------------------------------
    // Private fields
    //-------------------------------------------------------------------------
    private StatusPoller statusPoller = new StatusPoller();
    private static URL url;
    private Optional<Build> unstableBuild = Optional.absent();

    //-------------------------------------------------------------------------
    // Public methods
    //-------------------------------------------------------------------------    
    @Scheduled(fixedRate = 60000)
    public void scheduledPoll() {
        Optional<Status> status = Optional.absent();

        if (url != null) {
            status = statusPoller.poll(url);
        }

        if (!status.isPresent()) {
            System.out.println(String.format("not status found at url %s", url));
            return;
        }
            
        if(status.get().getLastUnstableBuild() == null) {
            System.out.println(String.format("no unstable build at url %s", url));
            return;
        }
        
        
        if(
            unstableBuild.isPresent() && 
            status.get().getLastUnstableBuild().getNumber() == unstableBuild.get().getNumber()) {
            System.out.println(String.format("build number %d unstability already reported", unstableBuild.get().getNumber()));
            return;
        }
        
        unstableBuild = Optional.of(status.get().getLastUnstableBuild());
        System.err.println(String.format("build %s unstable", unstableBuild.get().getNumber()));
    }

    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        String urlArg = args[0];
        url = new URL(urlArg);
        
        SpringApplication.run(Application.class, args);
        
        Thread.sleep(600000);
    }
}
