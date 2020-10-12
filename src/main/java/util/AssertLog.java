package util;

import jdk.nashorn.internal.objects.NativeMath;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import java.util.logging.Level;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class AssertLog extends Assert {

   public static void assertTrue(boolean condition, String message) {
        if (!condition) {
            Assert.assertTrue(condition, "ERROR: No cumple con el criterio >"+message);
        }
        else{
            LOGGER.log(Level.WARNING, "STEP PASS: "+message);
        }

    }

}
