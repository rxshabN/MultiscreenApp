package com.example.multiscreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.multiscreen.EXTRA_MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void placeOrder(View view){
        Intent intent = new Intent(this, OrderActivity.class);
        EditText edittext = findViewById(R.id.editTextText);
        EditText edittext2 = findViewById(R.id.editTextText2);
        EditText edittext3 = findViewById(R.id.editTextText3);
        String message = "Order for " + edittext.getText().toString() + ", " + edittext2.getText().toString() + " & " + edittext3.getText().toString() + " has been succesfuly placed.";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}