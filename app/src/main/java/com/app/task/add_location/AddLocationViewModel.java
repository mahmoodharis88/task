package com.app.task.add_location;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.app.task.add_location.models.AddAddressResponse;
import com.app.task.add_location.models.Addresses;
import com.app.task.add_location.models.Params;


public class AddLocationViewModel extends ViewModel {

    private MutableLiveData<Boolean> IsUpdating;
    private MutableLiveData<String> buildingName;
    private MutableLiveData<String> appartmentName;
    private MutableLiveData<String> streetName;
    private MutableLiveData<String> areaId;
    private MutableLiveData<String> cityId;

    private MutableLiveData<Addresses> addressesMutableLiveData;
    private MutableLiveData<AddAddressResponse> responseMutableLiveData;


    public MutableLiveData<Boolean> getIsUpdating() {
        if (IsUpdating == null) {
            IsUpdating = new MutableLiveData<>();
        }
        return IsUpdating;
    }


    public MutableLiveData<String> getBuildingName() {
        if (buildingName == null) {
            buildingName = new MutableLiveData<>();
        }
        return buildingName;
    }

    public MutableLiveData<String> getAppartmentName() {
        if (appartmentName == null) {
            appartmentName = new MutableLiveData<>();
        }
        return appartmentName;
    }

    public MutableLiveData<String> getStreetName() {
        if (streetName == null) {
            streetName = new MutableLiveData<>();
        }
        return streetName;
    }

    public MutableLiveData<String> getAreaId() {
        if (areaId == null) {
            areaId = new MutableLiveData<>();
        }
        return areaId;
    }

    public MutableLiveData<String> getCityId() {
        if (cityId == null) {
            cityId = new MutableLiveData<>();
        }
        return cityId;
    }

    public MutableLiveData<Addresses> getAddressesMutableLiveData() {
        if (addressesMutableLiveData == null) {
            addressesMutableLiveData = new MutableLiveData<>();
        }
        return addressesMutableLiveData;
    }




    public MutableLiveData<AddAddressResponse> getResponseMutableLiveData() {
        if (responseMutableLiveData == null) {
            responseMutableLiveData = new MutableLiveData<>();
        }
        return responseMutableLiveData;
    }

    public void callAddressesAPI() {
        IsUpdating.setValue(true);

        AddLocationRepository.getInstance().callAddressesAPI("123", "en")
                .observeForever(addresses -> {
                    addressesMutableLiveData.setValue(addresses);
                    IsUpdating.setValue(false);
                });

    }


    public void callAddAddressesAPI(Params params) {
        IsUpdating.setValue(true);

        AddLocationRepository.getInstance().callAddAddressesAPI(params)
                .observeForever(addresses -> {
                    responseMutableLiveData.setValue(addresses);
                    IsUpdating.setValue(false);
                });

    }
}


