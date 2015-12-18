/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package bradley4.gmail.com.backend;

import com.gmail.bradley4.gradle.jokes.Joker;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.com.gmail.bradley4",
                ownerName = "backend.com.gmail.bradley4",
                packagePath = ""
        )
)
public class MyEndpoint {

    @ApiMethod(name = "getJoke")
    public MyBean getJoke(@Named("name") String name) {
        MyBean response = new MyBean();
        Joker myJoker = new Joker();
        response.setData(myJoker.getJoke());
        return response;
    }

}
