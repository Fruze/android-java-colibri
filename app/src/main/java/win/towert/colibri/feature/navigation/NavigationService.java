package win.towert.colibri.feature.navigation;

import android.content.Context;
import android.content.Intent;

import win.towert.colibri.Henson;

public class NavigationService {

    public Intent getLoginIntent(Context context) {
        return Henson.with(context).gotoLoginActivity().build();
    }

}
