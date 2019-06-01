package win.towert.colibri.feature.login.repository;

import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import win.towert.colibri.common.api.ApiManager;
import win.towert.colibri.common.util.DebugUtil;
import win.towert.colibri.common.util.NetworkUtil;
import win.towert.colibri.feature.login.model.LoginRequestModel;
import win.towert.colibri.feature.login.model.LoginResponseModel;

public class LoginRepository {
    private LoginRequestModel mRequestModel = new LoginRequestModel();
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    private MutableLiveData<LoginResponseModel> mResponseModel;
    private String mRequestRoute;

    public LoginRepository(MutableLiveData<LoginResponseModel> responseModel, String requestRoute) {
        this.mResponseModel = responseModel;
        this.mRequestRoute = requestRoute;
    }

    public void request(Activity activity) {
        ApiManager apiManager = new ApiManager<>(this.mRequestModel, this.mRequestRoute);

        if(NetworkUtil.isNetworkConnected(activity)) {
            this.mCompositeDisposable.add(apiManager.request().getObjectSingle(LoginResponseModel.class)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSuccess(response -> this.mResponseModel.setValue(response))
                .doOnError(err -> {
                    throw new RuntimeException(err.getMessage());
                })
                .subscribe());
        }
        else {
            DebugUtil.debug(activity, "Network is not connected");
        }
    }

}
