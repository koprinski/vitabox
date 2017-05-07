
import com.omisoft.vitafu.opensubtitlesapi.impl.OpenSubtitlesImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Test;

import java.net.URL;

public class OpenSubtitlesImplTest {

    private static final Logger logger = LoggerFactory.getLogger(OpenSubtitlesImplTest.class);

    @Test
    public void printServerInfo() throws Exception {

        OpenSubtitlesImpl os = new OpenSubtitlesImpl(new URL("http://api.opensubtitles.org/xml-rpc"));
        os.login("en", "OSTestUserAgent");

        logger.info("Server information : " + os.serverInfo().toString());
        logger.info("Open subtitles = " + os.searchSubtitles("bul", "2310332")); // 120347

        os.logout();

    }
}