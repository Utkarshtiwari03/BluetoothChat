package com.utkarsh.bluetoothchat.data.chat

import android.bluetooth.BluetoothDevice
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build

/***
 * class will retrieve the broadcast fired by android device when new bluetooth device found
 ***/
class FoundDeviceReceiver(
    private val onDeviceFound: (BluetoothDevice) -> Unit
): BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        when(p1?.action) {
            //action when android find device
            BluetoothDevice.ACTION_FOUND -> {
                val device = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    p1?.getParcelableExtra(
                        BluetoothDevice.EXTRA_DEVICE,
                        BluetoothDevice::class.java
                    )
                } else {
                    p1.getParcelableExtra(BluetoothDevice.EXTRA_NAME)
                }
                //when device exist we call onDevice lambda function
                device?.let(onDeviceFound)
            }
        }
    }
}