package es.jcs.subjects.pmdm.helloworld_android;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

        // Suscripción al evento onClick de btnHelloWorld utilizando OnClickListener
        findViewById(R.id.btnHelloWorld).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findViewById(R.id.textHelloWorld).setVisibility(View.VISIBLE);
                // Mostrar un mensaje Toast de corta duración cuando el botón es clickeado
                Toast.makeText(MainActivity.this, "¡Botón clickeado!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}