package common;

import java.util.HashMap;
import java.util.Map;

public class Constants {

    public static class URL {
        public static String SAUCELABS = "";
        public static String RAILWAYS = "";
    }

    public static class WAIT_TIME {
        public static int SHORT = 5;
    }

    public enum RUN_MODE{
        LOCAL, REMOTE;

        //Lookup table
        private static final Map<String, RUN_MODE> lookup = new HashMap<>();

        //Populate the lookup table on loading time
        static {
            for (RUN_MODE mode : RUN_MODE.values()) {
                lookup.put(mode.toString(), mode);
            }
        }

        //This method can be used for reverse lookup purpose
        public static RUN_MODE get(String mode) {
            return lookup.get(mode.toUpperCase());
        }
    }

    public enum BROWSER{
        CHROME, FIREFOX;

        //Lookup table
        private static final Map<String, BROWSER> lookup = new HashMap<>();

        //Populate the lookup table on loading time
        static {
            for (BROWSER browser : BROWSER.values()) {
                lookup.put(browser.toString(), browser);
            }
        }

        //This method can be used for reverse lookup purpose
        public static BROWSER get(String browser) {
            return lookup.get(browser.toUpperCase());
        }
    }
}
