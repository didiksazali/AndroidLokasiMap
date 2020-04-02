package lokasimap.didiksazali.com.lokasimap;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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


        // Add a marker in Sydney and move the camera
        LatLng kampus = new LatLng(0.456737, 101.402230);

        LatLng tujuan = new LatLng(0.448493, 101.377977);

//        mMap.addMarker(new MarkerOptions().position(kampus).title("Marker in STMIK Amik Riau"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(kampus, 18));
        mMap.setMapType(googleMap.MAP_TYPE_SATELLITE);

        mMap.addPolyline(new PolylineOptions().add(
                tujuan,
                new LatLng(0.448353, 101.399564),
                new LatLng(0.448295, 101.400447),
                new LatLng(0.450899, 101.401694),
                new LatLng(0.452087, 101.401574),
                new LatLng(0.453192, 101.401209),
                new LatLng(0.452087, 101.401209),
                new LatLng(0.454506, 101.400688),
                new LatLng(0.455053, 101.402595),
                new LatLng(0.456737, 101.402230)

                )
                        .width(10)
                        .color(Color.BLUE)
        );

        mMap.addMarker(new MarkerOptions()
                .position(kampus)
                .title("STMIK Amik Riau")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.icon1)));

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);


    }
}
