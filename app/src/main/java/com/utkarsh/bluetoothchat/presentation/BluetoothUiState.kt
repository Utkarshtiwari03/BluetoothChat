package com.utkarsh.bluetoothchat.presentation

import com.utkarsh.bluetoothchat.domain.chat.BluetoothDevice

data class BluetoothUiState(
    val scannedDevices: List<BluetoothDevice> = emptyList(),
    val pairedDevices: List< BluetoothDevice> = emptyList()
)
