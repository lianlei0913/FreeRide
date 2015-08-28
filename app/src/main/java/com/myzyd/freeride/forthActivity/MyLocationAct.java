package com.myzyd.freeride.forthActivity;

import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.LocationManagerProxy;
import com.amap.api.location.LocationProviderProxy;
import com.myzyd.freeride.MainActivity;
import com.myzyd.freeride.R;

import java.util.Date;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by xiehehe on 15/7/30.
 */
public class MyLocationAct extends MainActivity {


    @InjectView(R.id.search_location)
    EditText searchLocation;
    @InjectView(R.id.locationBtn)
    TextView locationBtn;
    @InjectView(R.id.clear_location)
    TextView clearLocation;
    @InjectView(R.id.location1)
    TextView location_tv1;
    @InjectView(R.id.location2)
    TextView location_tv2;
    @InjectView(R.id.location3)
    TextView location_tv3;

    private ImageButton locationBack;
    private LocationManagerProxy aMapManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forth_location);
        ButterKnife.inject(this);
        LocationInitView();
    }

    private void LocationInitView() {

        locationBack = (ImageButton) findViewById(R.id.location_back);
        locationBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("返回个人中心");
                finish();
            }
        });
        locationBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startAmap();
            }
        });
    }

    private void startAmap() {
        aMapManager = LocationManagerProxy.getInstance(this);
		/*
		 * mAMapLocManager.setGpsEnable(false);
		 * 1.0.2版本新增方法，设置true表示混合定位中包含gps定位，false表示纯网络定位，默认是true Location
		 * API定位采用GPS和网络混合定位方式
		 * ，第一个参数是定位provider，第二个参数时间最短是2000毫秒，第三个参数距离间隔单位是米，第四个参数是定位监听者
		 */
        aMapManager.requestLocationUpdates(LocationProviderProxy.AMapNetwork, 2000, 10, mAMapLocationListener);
    }

    private void stopAmap() {
        if (aMapManager != null) {
            aMapManager.removeUpdates(mAMapLocationListener);
            aMapManager.destory();
        }
        aMapManager = null;
    }
    private AMapLocationListener mAMapLocationListener = new AMapLocationListener() {

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }

        @Override
        public void onLocationChanged(Location location) {

        }

        @Override
        public void onLocationChanged(AMapLocation location) {
            if (location != null) {
                Double geoLat = location.getLatitude();
                Double geoLng = location.getLongitude();
                String cityCode = "";
                String desc = "";
                Bundle locBundle = location.getExtras();
                if (locBundle != null) {
                    cityCode = locBundle.getString("citycode");
                    desc = locBundle.getString("desc");
                }
                String str = ("定位成功:(" + geoLng + "," + geoLat + ")"
                        + "\n精    度    :" + location.getAccuracy() + "米"
                        + "\n定位方式:" + location.getProvider() + "\n定位时间:"
                        + new Date(location.getTime()).toLocaleString() + "\n城市编码:"
                        + cityCode + "\n位置描述:" + desc + "\n省:"
                        + location.getProvince() + "\n市:" + location.getCity()
                        + "\n区(县):" + location.getDistrict() + "\n区域编码:" + location
                        .getAdCode());
                location_tv1.setText("高德定位\n" + str);
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopAmap();
    }
}
