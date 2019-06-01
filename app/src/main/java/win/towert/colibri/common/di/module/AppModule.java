package win.towert.colibri.common.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import win.towert.colibri.feature.navigation.NavigationService;

@Module
public abstract class AppModule {

    @Provides
    @Singleton
    static NavigationService provideNavigationService(){
        return new NavigationService();
    }

}
