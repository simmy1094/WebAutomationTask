package browser_Start_Up;

import Utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.util.logging.Logger;

public class InitialSetUp extends Driver {

        @Before
        public void startBrowser() { super.initialize("chrome");
            driver.get("https://testscriptdemo.com/");
        }
        @After
        public void quitBrowser(){ driver.close();
            Logger Log = Logger.getLogger(org.seleniumhq.jetty9.util.log.Log.class.getName());
            Log.info("Browser session is closed");
        }
    }
