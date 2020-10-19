package com.app.task.add_location;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.app.task.add_location.models.AddAddressResponse;
import com.app.task.add_location.models.Addresses;
import com.app.task.add_location.models.Params;
import com.app.task.network.ApiClient;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddLocationRepository {
    private static final String TAG = "LoginRepository";


    private AddLocationRepository() {
    }

    private static class SingletonHelper {
        private static final AddLocationRepository INSTANCE = new AddLocationRepository();
    }

    public static AddLocationRepository getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public MutableLiveData<Addresses> callAddressesAPI(String device_id, String lang) {
        final MutableLiveData<Addresses> data = new MutableLiveData<>();
        ApiClient.getInstance().getAddresses(device_id, lang, new Callback<Addresses>() {
            @Override
            public void onResponse(Call<Addresses> call, Response<Addresses> response) {
                Log.e(TAG, "onResponse :" + response);
                if(response.isSuccessful()){
                    data.setValue(response.body());
                }

            }

            @Override
            public void onFailure(Call<Addresses> call, Throwable t) {
                Log.e(TAG, "onFailure :" + t.getMessage());
                data.setValue(null);
            }
        });
        return data;
    }



    public MutableLiveData<AddAddressResponse> callAddAddressesAPI(Params params) {
        final MutableLiveData<AddAddressResponse> data = new MutableLiveData<>();
        ApiClient.getInstance().addAddress(params, new Callback<AddAddressResponse>() {
            @Override
            public void onResponse(Call<AddAddressResponse> call, Response<AddAddressResponse> response) {
                Log.e(TAG, "onResponse :" + response);
                if(response.isSuccessful()){
                    data.setValue(response.body());
                }

            }

            @Override
            public void onFailure(Call<AddAddressResponse> call, Throwable t) {
                Log.e(TAG, "onFailure :" + t.getMessage());
                data.setValue(null);
            }
        });
        return data;
    }
}