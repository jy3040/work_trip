package com.example.work_trip;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.FragmentManager;

import com.example.work_trip.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class CategoryLoadgingActivity extends AppCompatActivity implements OnMapReadyCallback {
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_lodging);

        FragmentManager fragmentManager=getFragmentManager();
        MapFragment mapFragment=(MapFragment) fragmentManager.findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(@NonNull GoogleMap map) {
        LatLng loadging1=new LatLng(37.908731, 128.819568);
        LatLng loadging2=new LatLng(38.316925, 128.531037);
        LatLng loadging3=new LatLng(38.209743, 128.504643);
        LatLng loadging4=new LatLng(38.243015, 128.572388);
        LatLng loadging5=new LatLng(38.210484, 128.493718);

        MarkerOptions marker1=new MarkerOptions();
        MarkerOptions marker2=new MarkerOptions();
        MarkerOptions marker3=new MarkerOptions();
        MarkerOptions marker4=new MarkerOptions();
        MarkerOptions marker5=new MarkerOptions();

        marker1.position(loadging1);
        marker2.position(loadging2);
        marker3.position(loadging3);
        marker4.position(loadging4);
        marker5.position(loadging5);

        marker1.title("주문진리조트");
        marker2.title("오션투유");
        marker3.title("아이파크 콘도미니엄");
        marker4.title("(주)이랜드파크켄싱턴리조트설악비치");
        marker5.title("소노문 델피노");

        marker1.snippet("강원도 강릉시 주문진읍 해안로 2070");
        marker2.snippet("강원도 고성군 죽왕면 삼포해변길 9");
        marker3.snippet("강원도 고성군 토성면 고성대로 75-16, 아이파크콘도");
        marker4.snippet("강원도 고성군 토성면 동해대로 4800");
        marker5.snippet("강원도 고성군 토성면 미시령옛길 1153");

        BitmapDrawable bitmapDrawable=(BitmapDrawable)getResources().getDrawable(R.drawable.marker_blue_fill);
        Bitmap b=bitmapDrawable.getBitmap();
        Bitmap smallMarker=Bitmap.createScaledBitmap(b, 100, 100, false);
        marker1.icon(BitmapDescriptorFactory.fromBitmap(smallMarker));
        marker2.icon(BitmapDescriptorFactory.fromBitmap(smallMarker));
        marker3.icon(BitmapDescriptorFactory.fromBitmap(smallMarker));
        marker4.icon(BitmapDescriptorFactory.fromBitmap(smallMarker));
        marker5.icon(BitmapDescriptorFactory.fromBitmap(smallMarker));


        map.addMarker(marker1);
        map.addMarker(marker2);
        map.addMarker(marker3);
        map.addMarker(marker4);
        map.addMarker(marker5);

        map.moveCamera(CameraUpdateFactory.newLatLng(loadging3));
        map.animateCamera(CameraUpdateFactory.zoomTo(10));
    }
}
