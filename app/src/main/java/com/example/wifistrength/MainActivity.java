package com.example.wifistrength;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Formatter;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    public void getInfo(View v){
        WifiManager wm = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        WifiInfo wi = wm.getConnectionInfo();

        int ip = wi.getIpAddress();
        String macAdd = wi.getMacAddress();
        String bssid =wi.getBSSID();
        int rssi = wi.getRssi();
        int linkSpeed = wi.getLinkSpeed();
        String ssid = wi.getSSID();
        int network_ID = wi.getNetworkId();
        String ipAdd = Formatter.formatIpAddress(ip);
        int strength = wm.calculateSignalLevel(rssi , 5);

        String output =
                "\n SSID : " +ssid+
                        "\n Ip Address : " +ipAdd+
                        "\n Mac Address : " +macAdd+
                        "\n SSID : " +ssid+
                        "\n RSSI : " +rssi+
                        "\n Link Speed : " +linkSpeed+
                        "\n Strength : " +strength+"/5"+
                        "\n Network Id : " +network_ID;
        TextView txt = (TextView) findViewById(R.id.textView);
        txt.setText(output);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
