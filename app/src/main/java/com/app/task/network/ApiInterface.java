package com.app.task.network;

import com.app.task.add_location.models.AddAddressResponse;
import com.app.task.add_location.models.Addresses;
import com.app.task.add_location.models.Params;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

import static com.app.task.network.Constants.GET_USER_ADDRESSES;
import static com.app.task.network.Constants.SEND_ADDRESS;

public interface ApiInterface {

    @GET(GET_USER_ADDRESSES)
    Call<Addresses> getUserAddresses(@Query("device_id") String device_id, @Query("lang") String lang);

    @POST(SEND_ADDRESS)
    Call<AddAddressResponse> sendAddress(@Body Params params);


}