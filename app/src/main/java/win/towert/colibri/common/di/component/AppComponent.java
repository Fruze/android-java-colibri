package win.towert.colibri.common.di.component;

import javax.inject.Singleton;

import dagger.Component;
import win.towert.colibri.common.app.App;
import win.towert.colibri.common.di.module.AppModule;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(App app);

}
