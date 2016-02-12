package com.ccm.Bluetooth;

import java.util.Set;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import android.bluetooth.*;
import android.util.Log;
import android.widget.Toast;


public class CCMBluetooth extends CordovaPlugin {

	public CCMBluetooth() {
	}

	@Override
	public boolean execute(final String action, JSONArray args,
			CallbackContext callbackContext) throws JSONException {

		if (action != null && action != "" && action.equals("findMac")) {
			try {
				String printerMac = "";

				BluetoothAdapter mBluetoothAdapter = BluetoothAdapter
						.getDefaultAdapter();
				Set<BluetoothDevice> pairedDevices = mBluetoothAdapter
						.getBondedDevices();

				for (BluetoothDevice device : pairedDevices) {
					if (device != null) {
						printerMac = device.getAddress();
					}
				}
				callbackContext.success(printerMac);
			} catch (Exception e) {
				Toast.makeText(cordova.getActivity().getApplicationContext(), "Unable to find Bluetooth MAC.", Toast.LENGTH_SHORT).show();
				callbackContext.error("Unable to find the MAC Address.");
				return false;
			}
		}
		return true;
	}
}