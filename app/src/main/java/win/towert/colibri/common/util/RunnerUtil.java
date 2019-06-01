package win.towert.colibri.common.util;

import android.os.Handler;

public abstract class RunnerUtil {
    
    public static void runnable(Runnable runnable, int timer) {
        final Handler handler = new Handler();
        handler.postDelayed(runnable, timer);
    }

}
