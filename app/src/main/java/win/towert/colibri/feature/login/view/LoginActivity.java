package win.towert.colibri.feature.login.view;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.f2prateek.dart.HensonNavigable;

import win.towert.colibri.R;
import win.towert.colibri.databinding.ActivityLoginBinding;
import win.towert.colibri.common.base.BaseActivity;
import win.towert.colibri.feature.login.viewmodel.LoginViewModel;

@HensonNavigable
public class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginViewModel> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setViewModel();
        this.setBinding();
    }

    public void setViewModel() {
        this.mViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        this.mViewModel.loadRemote(this);
        this.mViewModel.getViewStatus().observe(this, status -> {
            if(status != null && status == 1) {
                this.mBinding.invalidateAll();
            }
        });
    }

    public void setBinding() {
        super.instantiateBinding(this, R.layout.activity_login);
        super.mBinding.setViewmodel(this.mViewModel);
    }

    public void goTo() {
        super.startIntent(this.mNavigationService.getLoginIntent(this.getBaseContext()));
        this.finish();
    }
}
