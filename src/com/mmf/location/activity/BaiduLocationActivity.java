package com.mmf.location.activity;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.mmf.location.R;
import com.mmf.location.baidu.LocationUtil;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class BaiduLocationActivity extends Activity implements
		BDLocationListener {
	private LocationUtil locationUtil;
	private TextView tvLocCity;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		tvLocCity = (TextView) findViewById(R.id.tv_loc_city);
		locationUtil = new LocationUtil(getApplicationContext());
		locationUtil.setListener(this);
		locationUtil.start() ;
	}

	@Override
	public void onReceiveLocation(BDLocation location) {
		if (location != null) {
			//显示定位结果并停止定位
			if (locationUtil.isSuccess(location.getLocType())) {
				Toast.makeText(this, location.getCity(), Toast.LENGTH_SHORT)
						.show();
				tvLocCity.setText(location.getCity());
				locationUtil.stopLocationAndRemoveListener(this);
			}
		}
	}

}
