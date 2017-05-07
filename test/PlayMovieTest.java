import com.omisoft.vitafu.constants.MimeTypes;
import controllers.PlayMovie;
import org.junit.Test;
import play.Logger;
import play.mvc.Result;

import java.util.Enumeration;

import static play.test.Helpers.*;

import controllers.routes;
import org.junit.*;
import play.libs.Json;
import play.mvc.*;
import play.test.FakeRequest;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;


/**
 * Tests Play Movie Controller
 * Created by dido on 11/13/14.
 */
public class PlayMovieTest {
    @Test
    public void callLoadMovie() {
        running(fakeApplication(new FakeGlobal()), new Runnable() {
            public void run() {
                PlayMovie playMovie = new PlayMovie();
                Result result = route(fakeRequest(GET, "/movies/playMovie?movieId=1"));
                //Result result = callAction(playMovie.loadMovie("1","1","1"), fakeRequest(GET, "/movies/playMovie/1"));

                assertThat(status(result)).
                        isEqualTo(OK);

                assertThat(contentType(result)).
                        isEqualTo(MimeTypes.JSON.getType());
                String content = contentAsString(result);
                Logger.info(contentAsString(result));
                assertThat(Json.parse(content).get("movieId").asText()).isEqualTo("1");

            }



        });

    }

}
