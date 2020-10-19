package com.app.task;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.app.task.add_location.AddLocation;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.SupportMapFragment;

public class GoogleMapFragment extends Fragment {

    protected GoogleMap mMap = null;
    private SupportMapFragment mapFragment = null;
    private Projection projection = null;
    Boolean flagPlaceSearch = false;
    Boolean flag = true;
    Location loc;
    ImageView locationButton = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);


        View view = inflater.inflate(R.layout.google_map_fragment, container, false);
        initData(view);

        view.findViewById(R.id.iv_centerMarker).setOnClickListener(view1 -> locationButton.callOnClick());
        view.findViewById(R.id.pick_location_btn).setOnClickListener(view12 -> {
            if (loc != null){
                Intent intent = new Intent(getActivity(), AddLocation.class);
                intent.putExtra("lat", loc.getLatitude());
                intent.putExtra("lng", loc.getLongitude());
                startActivity(intent);
            }
        });

        return view;


    }


    void initData(View v) {
        mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(googleMap -> {
            mMap = googleMap;
            mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

            mMap.getUiSettings().setIndoorLevelPickerEnabled(true);
            mMap.getUiSettings().setCompassEnabled(false);
            mMap.getUiSettings().setMyLocationButtonEnabled(true);
            if (ActivityCompat.checkSelfPermission(getActivity(),
                    Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                    ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            mMap.setMyLocationEnabled(true);

            if (mapFragment.getView() != null) {
                if ((mapFragment.getView().findViewById(Integer.parseInt("1"))) != null) {
                    if ((mapFragment.getView().findViewById(Integer.parseInt("1")).getParent()) != null) {
                        if (((View) mapFragment.getView().findViewById(Integer.parseInt("1"))
                                .getParent()).findViewById(Integer.parseInt("2")) != null) {
                            locationButton =
                                    ((View) mapFragment.getView().findViewById(Integer.parseInt("1")).getParent()).findViewById(
                                            Integer.parseInt("2"));
                            RelativeLayout.LayoutParams rlp = (RelativeLayout.LayoutParams) locationButton.getLayoutParams();
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                                rlp.removeRule(RelativeLayout.ALIGN_PARENT_TOP);
                            }
                            rlp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
                            rlp.addRule(RelativeLayout.ALIGN_PARENT_END, RelativeLayout.TRUE);
                            rlp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
                            rlp.addRule(RelativeLayout.CENTER_VERTICAL);
                            rlp.setMargins(0, 0, 0, 0);
                            locationButton.setVisibility(View.GONE);

                        }
                    }
                }
            }
            mMap.setOnMapLoadedCallback(() -> locationButton.callOnClick());
            mMap.setOnCameraIdleListener(() -> {
                if (!flagPlaceSearch)
                    flag = false;
                else
                    flagPlaceSearch = false;
            });

            mMap.setOnCameraMoveStartedListener(i -> {
                mMap.clear();
                if (flag) {
                    flag = false;
                } else {
                    loc = new Location("");
                    loc.setLatitude(mMap.getCameraPosition().target.latitude);
                    loc.setLongitude(mMap.getCameraPosition().target.longitude);

//                    Toast.makeText(getActivity(), loc.getLongitude() + "", Toast.LENGTH_LONG).show();
                }
            });
        });


    }
}


