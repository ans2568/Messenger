package com.example.login;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements GoogleMap.OnMyLocationButtonClickListener, GoogleMap.OnMyLocationClickListener, OnMapReadyCallback {

    private GoogleMap mMap;
    private int MY_LOCATION_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults){
        if(requestCode == MY_LOCATION_REQUEST_CODE){
            if(permissions.length==1&&
            permissions[0]== Manifest.permission.ACCESS_FINE_LOCATION&& grantResults[0]== PackageManager.PERMISSION_GRANTED){
                if(checkCallingPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                checkCallingPermission(Manifest.permission.ACCESS_COARSE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[]{
                            Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION
                    }, 1);
                }
                mMap.setMyLocationEnabled(true);
            }
        }
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if(checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) !=
                        PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION
            }, 1);
        }
        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.setMyLocationEnabled(true);
        mMap.setOnMyLocationButtonClickListener(this);
        mMap.setOnMyLocationClickListener(this);

        LatLng tour = new LatLng(37.8685400643104, 127.74078450958523);
        mMap.addMarker(new MarkerOptions().position(tour).title("백록관")
        .snippet("중앙 동아리와 학식을 먹을 수 있는 곳"));

        tour = new LatLng(37.8707090778516, 127.74476025193714);
        mMap.addMarker(new MarkerOptions().position(tour).title("중앙도서관")
        .snippet("미래광장에 위치한 도서관"));

        tour = new LatLng(37.8657562331585, 127.74316594057426);
        mMap.addMarker(new MarkerOptions().position(tour).title("BTL")
        .snippet("기숙사"));

        tour = new LatLng(37.87132566131394, 127.74338734307196);
        mMap.addMarker(new MarkerOptions().position(tour).title("천지관")
        .snippet("우체국과 서점, 미용실, 맘스터치, 복사실이 위치해있고, 학식을 먹을 수 있는 곳"));

        tour = new LatLng(37.86991909989185, 127.7447574160572);
        mMap.addMarker(new MarkerOptions().position(tour).title("나래관")
        .snippet("정신 상담 센터와 BMI, 재학증명서 출력 가능한 곳"));

        tour = new LatLng(37.86821152453195, 127.73880944789751);
        mMap.addMarker(new MarkerOptions().position(tour).title("공대 5호관")
        .snippet("공과대학 5호관으로 5층으로 구성되어 있고, 1층(강의실, IT대 학생회실), 2층,5층(전기전자공학과), 3층(에너지자원공학과), 4층(환경공학과)가 위치"));

        tour = new LatLng(37.86838977600911, 127.74317892102812);
        mMap.addMarker(new MarkerOptions().position(tour).title("대운동장")
        .snippet("학교 운동장으로 넓은 축구장과 농구대가 위치"));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(tour));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tour, 16));
    }

    @Override
    public boolean onMyLocationButtonClick() {
        return false;
    }

    @Override
    public void onMyLocationClick(@NonNull Location location) {

    }
}