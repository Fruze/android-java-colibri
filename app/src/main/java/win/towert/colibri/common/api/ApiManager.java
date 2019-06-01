package win.towert.colibri.common.api;

import com.androidnetworking.common.Priority;
import com.rx2androidnetworking.Rx2ANRequest;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import win.towert.colibri.common.base.BaseRequestModel;

public class ApiManager<RequestModel extends BaseRequestModel> {
    private RequestModel mApiRequest;
    private String mApiRoute;

    private Priority mApiPriority = Priority.MEDIUM;

    public ApiManager(RequestModel apiRequest, String apiRoute) {
        this.mApiRequest = apiRequest;
        this.mApiRoute = apiRoute;
    }

    public Rx2ANRequest request() {
        return Rx2AndroidNetworking.post(this.mApiRoute)
                .addBodyParameter(this.mApiRequest)
                .setTag(this.mApiRoute)
                .setPriority(this.mApiPriority)
                .build();
    }

}