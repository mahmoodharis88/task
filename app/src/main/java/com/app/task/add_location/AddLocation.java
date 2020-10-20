package com.app.task.add_location;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.app.task.BaseActivity;
import com.app.task.R;
import com.app.task.Utils;
import com.app.task.adapters.AreaAdapter;
import com.app.task.adapters.CityAdapter;
import com.app.task.add_location.models.Addresses;
import com.app.task.add_location.models.Params;
import com.app.task.databinding.AddLocationDataBinding;

public class AddLocation extends BaseActivity {

    public AddLocationViewModel viewModel;
    AddLocationDataBinding binding;
    Params params;
    AreaAdapter areaAdapter;
    CityAdapter cityAdapter;

    int seletedAreaID = -1, selectedCityID = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_location);

        viewModel = ViewModelProviders.of(this).get(AddLocationViewModel.class);
        binding.setLocationViewModel(viewModel);


        // You can create an anonymous listener to handle the event when is selected an spinner item
        binding.area.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {
                // Here you get the current item (a User object) that is selected by its position
                Addresses.UserAddressBean userAddressBean = areaAdapter.getItem(position);
                // Here you can do the action you want to...
                seletedAreaID = userAddressBean.areaId;
//                setToast(seletedAreaID + "", AddLocation.this);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapter) {
            }
        });


        // You can create an anonymous listener to handle the event when is selected an spinner item
        binding.city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {
                // Here you get the current item (a User object) that is selected by its position
                Addresses.UserAddressBean userAddressBean = cityAdapter.getItem(position);
                // Here you can do the action you want to...
                selectedCityID = userAddressBean.cityId;
//                setToast(selectedCityID + "", AddLocation.this);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapter) {
            }
        });


        //progressbar
        viewModel.getIsUpdating().observe(this, aBoolean -> {
            if (aBoolean) {
                dialog = Utils.progressDialog(AddLocation.this);
            } else {
                dialog.dismiss();
            }
        });


        //callling api
        viewModel.callAddressesAPI();

        viewModel.getAddressesMutableLiveData().observe(this, addresses -> {
            if (addresses != null) {

                areaAdapter = new AreaAdapter(this,
                        android.R.layout.simple_spinner_item,
                        addresses.data.userAddress);
                binding.area.setAdapter(areaAdapter); // Set the custom adapter to the spinner


                cityAdapter = new CityAdapter(this,
                        android.R.layout.simple_spinner_item,
                        addresses.data.userAddress);
                binding.city.setAdapter(cityAdapter); // Set the custom adapter to the spinner

            } else {
                setToast("Somthing error Wrong", this);
            }
        });


        binding.submit.setOnClickListener(view -> {
            if (TextUtils.isEmpty(binding.buildingName.getText().toString().trim())) {
                setToast("Enter building name", this);
            } else if (TextUtils.isEmpty(binding.appartmentName.getText().toString().trim())) {
                setToast("Enter appartment name", this);
            } else if (TextUtils.isEmpty(binding.streetName.getText().toString().trim())) {
                setToast("Enter street name", this);
            } else if (selectedCityID == -1) {
                setToast("Select city", this);
            } else if (seletedAreaID == -1) {
                setToast("Select area", this);
            } else {
                viewModel.callAddAddressesAPI(new Params(getIntent().getDoubleExtra("lat", 0),
                        getIntent().getDoubleExtra("lng", 0),
                        binding.buildingName.getText().toString().trim(),
                        binding.appartmentName.getText().toString().trim(),
                        binding.streetName.getText().toString().trim(),
                        seletedAreaID, selectedCityID, "1234", "en"));
            }

        });


        viewModel.getResponseMutableLiveData().observe(this, response -> {
            if (response != null) {
                if (response.getMsg() != null) {
                    setToast(response.getMsg().get(0), this);
                    clearData();
                }

            } else {
                setToast("Somthing error Wrong", this);
            }
        });
    }

    private void clearData() {
        binding.appartmentName.setText("");
        binding.streetName.setText("");
        binding.buildingName.setText("");
        seletedAreaID = -1;
        selectedCityID = -1;
    }


}