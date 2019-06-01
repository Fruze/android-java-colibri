package win.towert.colibri.common.base;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import win.towert.colibri.common.app.App;
import win.towert.colibri.common.di.component.AppComponent;
import win.towert.colibri.feature.navigation.NavigationService;

public abstract class BaseActivity<Binding extends ViewDataBinding, ViewModel extends BaseViewModel> extends AppCompatActivity implements BaseActivityInterface {
    protected Binding mBinding;
    protected ViewModel mViewModel;
    protected AppComponent mAppComponent;
    protected NavigationService mNavigationService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        App application = (App) getApplication();
        this.mAppComponent = application.getAppComponent();
        this.mNavigationService = application.getNavigationService();
    }

    protected void startIntent(Intent intent) {
        this.startActivity(intent);
    }

    protected void instantiateBinding(Activity activity, int layout) {
        this.mBinding = DataBindingUtil.setContentView(activity, layout);
        this.mBinding.setLifecycleOwner(this);
    }
}
