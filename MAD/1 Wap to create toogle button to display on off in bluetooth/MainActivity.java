package com.example.bluetoothtoggle;

import android.bluetooth.BluetoothAdapter;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    private TextView statusText;
    private Button toggleButton;
    private BluetoothAdapter bluetoothAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        statusText = findViewById(R.id.statusText);
        toggleButton = findViewById(R.id.toggleButton);
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        // Check if device supports Bluetooth
        if (bluetoothAdapter == null) {
            statusText.setText("Bluetooth not supported");
            toggleButton.setEnabled(false);
            return;
        }

        // Set initial state
        updateBluetoothStatus();

        // Set button click listener
        toggleButton.setOnClickListener(view -> toggleBluetooth());
    }

    private void toggleBluetooth() {
        if (bluetoothAdapter.isEnabled()) {
            bluetoothAdapter.disable();
            Toast.makeText(this, "Bluetooth turned OFF", Toast.LENGTH_SHORT).show();
        } else {
            bluetoothAdapter.enable();
            Toast.makeText(this, "Bluetooth turned ON", Toast.LENGTH_SHORT).show();
        }
        updateBluetoothStatus();
    }

    private void updateBluetoothStatus() {
        if (bluetoothAdapter.isEnabled()) {
            statusText.setText("Bluetooth Status: ON");
            toggleButton.setText("Turn OFF");
            toggleButton.setBackgroundTintList(ContextCompat.getColorStateList(this, android.R.color.holo_green_dark));
        } else {
            statusText.setText("Bluetooth Status: OFF");
            toggleButton.setText("Turn ON");
            toggleButton.setBackgroundTintList(ContextCompat.getColorStateList(this, android.R.color.holo_red_dark));
        }
    }
}