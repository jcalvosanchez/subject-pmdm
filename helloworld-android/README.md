# Hello World en Android

![Build Status](https://img.shields.io/badge/build-passing-brightgreen)
![Java Version](https://img.shields.io/badge/Java-11-blue)
![Android Version](https://img.shields.io/badge/Android-API%2028%2B-blue)

Este es un proyecto simple de Android que muestra un mensaje "Hello World" en la pantalla.

## Prerequisitos

Antes de comenzar, asegúrate de tener instalados los siguientes programas y herramientas:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) (versión 11 o superior)
- [Android Studio](https://developer.android.com/studio) (versión más reciente)
- [SDK de Android](https://developer.android.com/studio) (puedes instalarlo junto con Android Studio)
- Conexión a Internet para descargar dependencias y herramientas necesarias

## Nuevo Proyecto "Hello World" en Android

### Pasos

1. Abre Android Studio y selecciona **"Start a new Android Studio project"**.
2. Elige **"Empty Activity"** y haz clic en **"Next"**.
3. En la pantalla de configuración del proyecto:
    - Nombra tu proyecto (por ejemplo, `HelloWorld`).
    - Dale un nombre a los paquetes (por ejemplo, `es.jcs.subjects.pmdm.helloworld_android`)
    - Elige el lenguaje **Java**.
    - Elige la **versión mínima de Android** (por ejemplo, API 24).
4. Haz clic en **"Finish"**.

### Ejecutar la Aplicación

1. Conecta un dispositivo Android a tu computadora o usa un emulador de Android.
2. Haz clic en el botón Run (el icono de un triángulo verde) en Android Studio.
3. Espera a que la aplicación se compile y se ejecute en el dispositivo o emulador.
4. Deberías ver la pantalla con el texto "Hello World".

En este punto, Android Studio habrá creado

- una clase `MainActivity.java` que extiende de `Activity` dentro de `app/src/main/java/es/jcs/subjects/pmdm/helloworld_android`.
- una layout `activity_main.xml` dentro de `app/src/main/res/layout`.
- un archivo `AndroidManifest.xml` dentro de `app/src/main` declarando la Actividad Principal.

```java
package tu.ruta.paquetes;

import android.os.Bundle;

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
    }
}
```

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World!"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
xmlns:tools="http://schemas.android.com/tools">

    <application
        android:allowBackup="true"
        android:dataExtractionRules="@xml/data_extraction_rules"
        android:fullBackupContent="@xml/backup_rules"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/Theme.Helloworldandroid"
        tools:targetApi="31">
        <activity
            android:name=".MainActivity"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
```
