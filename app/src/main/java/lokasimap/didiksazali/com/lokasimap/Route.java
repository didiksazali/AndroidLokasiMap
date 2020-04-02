package lokasimap.didiksazali.com.lokasimap;

import lokasimap.didiksazali.com.lokasimap.Distance;
import lokasimap.didiksazali.com.lokasimap.Duration;
import com.google.android.gms.maps.model.LatLng;
import java.util.List;

public class Route {
    public Distance distance;
    public Duration duration;
    public String endAddress;
    public LatLng endLocation;
    public String startAddress;
    public LatLng startLocation;
    public List<LatLng> points;
}
