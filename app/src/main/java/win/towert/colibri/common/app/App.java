package win.towert.colibri.common.app;

import android.app.Application;

import javax.inject.Inject;

import win.towert.colibri.common.di.component.AppComponent;
import win.towert.colibri.common.di.component.DaggerAppComponent;
import win.towert.colibri.feature.navigation.NavigationService;

public class App extends Application {
    @Inject public NavigationService mNavigationService;

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        this.mAppComponent = DaggerAppComponent.create();
        this.mAppComponent.inject(this);
    }

    public AppComponent getAppComponent() {
        return this.mAppComponent;
    }
    public NavigationService getNavigationService() {
        return this.mNavigationService;
    }
}
