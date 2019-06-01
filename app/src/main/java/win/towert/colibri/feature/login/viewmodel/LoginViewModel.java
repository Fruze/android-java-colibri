package win.towert.colibri.feature.login.viewmodel;

import android.arch.lifecycle.MutableLiveData;

import win.towert.colibri.common.api.ApiRoute;
import win.towert.colibri.common.base.BaseViewModel;
import win.towert.colibri.feature.login.model.LoginResponseModel;
import win.towert.colibri.feature.login.repository.LoginRepository;
import win.towert.colibri.feature.login.view.LoginActivity;

public class LoginViewModel extends BaseViewModel {
    private LoginRepository mRepository;

    private MutableLiveData<LoginResponseModel> mResponseModel = new MutableLiveData<>();
    private MutableLiveData<Integer> mViewStatus = new MutableLiveData<>();
    private MutableLiveData<String> mLoginCode = new MutableLiveData<>();

    public LoginViewModel() {
        this.mRepository = new LoginRepository(this.mResponseModel, ApiRoute.getApiLogin());
    }

    public void loadRemote(LoginActivity activity) {
        this.mResponseModel.observe(activity, this::changed);
        this.mRepository.request(activity);
    }

    private void changed(LoginResponseModel model) {
        this.mLoginCode.setValue(model.code);

        this.mViewStatus.setValue(1);
    }

    public MutableLiveData<Integer> getViewStatus() { return this.mViewStatus; }
    public MutableLiveData<String> getLoginCode() {
        return this.mLoginCode;
    }
}
