package be.ewils.spring;

import be.ewils.spring.bean.Status;
import com.google.common.base.Optional;
import java.net.URL;
import org.springframework.web.client.RestTemplate;

/**
 * Poll on a regular base the status of the sanbox job on Jenkins
 *
 * @author antoine
 */
public class StatusPoller {

    //--------------------------------------------------------------------------
    // public methods
    //--------------------------------------------------------------------------
    /**
     * poll for a json response at the URL to must be a Jenkins REST API on a
     * job
     *
     * @param url the url to poll
     * @return the Status of the provide
     */
    public Optional<Status> poll(URL url) {

        RestTemplate restTemplate = new RestTemplate();
        return 
            Optional.
                fromNullable(
                    restTemplate.getForObject(url.toString(), Status.class));
    }
}
