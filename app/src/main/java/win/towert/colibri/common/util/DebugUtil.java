package win.towert.colibri.common.util;

import android.app.Activity;
import android.util.Log;

public abstract class DebugUtil {

    public static void debug(Activity activity, String message) {
        Log.d("DebugUtil" + activity.getLocalClassName(), message);
    }

}
