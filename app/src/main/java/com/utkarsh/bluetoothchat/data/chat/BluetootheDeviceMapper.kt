package com.utkarsh.bluetoothchat.data.chat

import android.bluetooth.BluetoothDevice
import com.utkarsh.bluetoothchat.domain.chat.BluetoothDeviceDomain

fun BluetoothDevice.toBluetoothDeviceDomain(): BluetoothDeviceDomain {
    return BluetoothDeviceDomain(
        name = name,
        address = address
    )
}