package com.quan.gamebaucua;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Handler.Callback;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends Activity {
	GridView gridView;
	Custom_GridView_BanCo adapter;
	Integer[] dsHinh = { R.drawable.nai, R.drawable.bau, R.drawable.ga, R.drawable.ca, R.drawable.cua, R.drawable.tom };
	AnimationDrawable cdXiNgau1, cdXiNgau2, cdXiNgau3;
	ImageView hinhXiNgau1, hinhXiNgau2, hinhXiNgau3;
	Random randomXiNgau;
	int giaTriXiNgau1, giaTriXiNgau2, giaTriXiNgau3;
	public static Integer[] gtDatCuoc = new Integer[6];
	Timer timer = new Timer();
	Handler handler;
	SoundPool amThanhXiNgau = new SoundPool(1 ,AudioManager.STREAM_MUSIC, 0);
	int tienThuong, id_amthanh;
	Callback callback = new Callback() {

		@Override
		public boolean handleMessage(Message msg) {
			RandomXiNgau1();
			RandomXiNgau2();
			RandomXiNgau3();
			for(int i = 0; i < gtDatCuoc.length; i++){
				if(gtDatCuoc[i] != 0){
					if(i == giaTriXiNgau1){
						tienThuong += gtDatCuoc[i];
					}
					if(i == giaTriXiNgau2){
						tienThuong += gtDatCuoc[i];
					}
					if(i == giaTriXiNgau3){
						tienThuong += gtDatCuoc[i];
					}
					if(i != giaTriXiNgau1 && i != giaTriXiNgau2 && i != giaTriXiNgau3){
						tienThuong -= gtDatCuoc[i];
					}
				}
			
			}
			Log.d("KetQua", " " + tienThuong);
			return false;
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		hinhXiNgau1 = (ImageView) findViewById(R.id.xiNgau1);
		hinhXiNgau2 = (ImageView) findViewById(R.id.xiNgau2);
		hinhXiNgau3 = (ImageView) findViewById(R.id.xiNgau3);
		gridView = (GridView) findViewById(R.id.gv_BanCo);
		adapter = new Custom_GridView_BanCo(this, R.layout.custom_banco, dsHinh);
		gridView.setAdapter(adapter);
		id_amthanh = amThanhXiNgau.load(this, R.raw.untilyou, 1);
		handler = new Handler(callback);
	}

	public void LacXiNgau(View v) {
		hinhXiNgau1.setImageResource(R.drawable.hinhdongxingau);
		hinhXiNgau2.setImageResource(R.drawable.hinhdongxingau);
		hinhXiNgau3.setImageResource(R.drawable.hinhdongxingau);

		cdXiNgau1 = (AnimationDrawable) hinhXiNgau1.getDrawable();
		cdXiNgau2 = (AnimationDrawable) hinhXiNgau2.getDrawable();
		cdXiNgau3 = (AnimationDrawable) hinhXiNgau3.getDrawable();
		amThanhXiNgau.play(id_amthanh, 1.0f,1.0f,1,0,1.0f);

		cdXiNgau1.start();
		cdXiNgau2.start();
		cdXiNgau3.start();
		
		tienThuong = 0;

		timer.schedule(new LacXiNgau1(), 2000);
	}

	class LacXiNgau1 extends TimerTask {

		@Override
		public void run() {
			handler.sendEmptyMessage(0);
		}

	}

	private void RandomXiNgau1() {
		randomXiNgau = new Random();
		int rd = randomXiNgau.nextInt(6);
		switch (rd) {
		case 0:
			hinhXiNgau1.setImageResource(dsHinh[0]);
			giaTriXiNgau1 = rd;
			break;
		case 1:
			hinhXiNgau1.setImageResource(dsHinh[1]);
			giaTriXiNgau1 = rd;

			break;
		case 2:
			hinhXiNgau1.setImageResource(dsHinh[2]);
			giaTriXiNgau1 = rd;

			break;
		case 3:
			hinhXiNgau1.setImageResource(dsHinh[3]);
			giaTriXiNgau1 = rd;

			break;
		case 4:
			hinhXiNgau1.setImageResource(dsHinh[4]);
			giaTriXiNgau1 = rd;

			break;
		case 5:
			hinhXiNgau1.setImageResource(dsHinh[5]);
			giaTriXiNgau1 = rd;

			break;
		}
	}

	private void RandomXiNgau2() {
		randomXiNgau = new Random();
		int rd = randomXiNgau.nextInt(6);
		switch (rd) {
		case 0:
			hinhXiNgau2.setImageResource(dsHinh[0]);
			giaTriXiNgau2 = rd;
			break;
		case 1:
			hinhXiNgau2.setImageResource(dsHinh[1]);
			giaTriXiNgau2 = rd;

			break;
		case 2:
			hinhXiNgau2.setImageResource(dsHinh[2]);
			giaTriXiNgau2 = rd;

			break;
		case 3:
			hinhXiNgau2.setImageResource(dsHinh[3]);
			giaTriXiNgau2 = rd;

			break;
		case 4:
			hinhXiNgau2.setImageResource(dsHinh[4]);
			giaTriXiNgau2 = rd;

			break;
		case 5:
			hinhXiNgau2.setImageResource(dsHinh[5]);
			giaTriXiNgau2 = rd;

			break;
		}
	}

	private void RandomXiNgau3() {
		randomXiNgau = new Random();
		int rd = randomXiNgau.nextInt(6);
		switch (rd) {
		case 0:
			hinhXiNgau3.setImageResource(dsHinh[0]);
			giaTriXiNgau3 = rd;
			break;
		case 1:
			hinhXiNgau3.setImageResource(dsHinh[1]);
			giaTriXiNgau3 = rd;

			break;
		case 2:
			hinhXiNgau3.setImageResource(dsHinh[2]);
			giaTriXiNgau3 = rd;

			break;
		case 3:
			hinhXiNgau3.setImageResource(dsHinh[3]);
			giaTriXiNgau3 = rd;

			break;
		case 4:
			hinhXiNgau3.setImageResource(dsHinh[4]);
			giaTriXiNgau3 = rd;

			break;
		case 5:
			hinhXiNgau3.setImageResource(dsHinh[5]);
			giaTriXiNgau3 = rd;

			break;
		}
	}
}