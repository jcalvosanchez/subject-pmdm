# Hello World en Android

![Build Status](https://img.shields.io/badge/build-passing-brightgreen)
![Java Version](https://img.shields.io/badge/Java-11-blue)
![Android Version](https://img.shields.io/badge/Android-API%2028%2B-blue)

Este es un proyecto que nos guía a través de las funcionalidades más básicas de desarrollo en **Android** utilizando **Java**.

## Prerequisitos

Antes de comenzar, asegúrate de tener instalados los siguientes programas y herramientas:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) (versión 11 o superior)
- [Android Studio](https://developer.android.com/studio) (versión más reciente)
- [SDK de Android](https://developer.android.com/studio) (puedes instalarlo junto con Android Studio)
- Conexión a Internet para descargar dependencias y herramientas necesarias

## Nuevo Proyecto "Hello World" en Android

Queremos mostrar un mensaje "Hello World" en la pantalla para demostrar que hemos configurado todo correctamente.

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
package es.jcs.subjects.pmdm.helloworld_android;

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
## Eventos en Android y Programación Orientada a Eventos

La SDK de Android utiliza **Inversión de Control** y la **Programación Orientada a Eventos**. Es decir, en lugar de que el programa ejecute instrucciones de manera secuencial, los eventos (como pulsar botones, deslizar pantallas o recibir mensajes) disparan la ejecución de código en respuesta a las acciones del usuario. Android utiliza un sistema basado en **listeners** y **event handlers** para manejar estos eventos, para permitir a los desarrolladores subscribirse a los eventos y definir el comportamiento a ejecutar cuando se detecte un evento.

### ¿Qué es un Evento en Android?

Un **evento** en Android se refiere a una acción realizada por el usuario o el sistema que puede desencadenar una respuesta del programa. Los eventos más comunes en aplicaciones Android son interacciones de la interfaz de usuario, como hacer clic en un botón, mover un dedo por la pantalla (gestos táctiles), o escribir en un campo de texto.

Por ejemplo, en el código del ejemplo anterior [Hello World en android](#hello-world-en-android), el método `onCreate` se ejecutará cuando un evento de creación sobre la actividad `MainActivity` sea detectado.

## Evento `onClick` en un Botón

Queremos ejecutar algún código cuando el usuario hace clic en un botón, por ejemplo mostrar un mensaje "Adiós" utilizando un `Toast` (Un `Toast` proporciona mensajes de feedback al usuario sin interrumpir la experiencia del usuario, es decir, no requiere que el usuario interactúe con el mensaje).

### **Definir un Botón en el Layout**

Vamos a modificar el archivo `activity_main.xml`:
- Modificamos el texto existente
  - Añadimos un `android:id` para que podamos referenciarlo desde Java.
  - Ocultamos este elemento (`android:visibility="gone"`) para que al arrancar no se vea. 
- Definimos un botón que el usuario puede presionar.
  - Definimos un `android:id` para que podamos referenciarlo desde Java.
  - Podemos utilizar `android:onClick` para referenciar un método de la actividad `MainActivity` que será ejecutado, pero en su lugar es más recomendable subscribirse a un escuchador para no acoplar la estructura de la interfaz con su comportamiento.
- No es necesario, pero por comodidad
  - Cambiamos `ConstraintLayout` por un `LinearLayout` para facilitar el diseño y centrado de los elementos.
  - añadimos `orientation` con valor `vertical`
  - añadimos `gravity` con valor `center`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center"
    android:orientation="vertical"
    tools:context=".MainActivity">

    <TextView
        android:id="@+id/textHelloWorld"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:visibility="gone"
        android:text="Hello World!"/>

    <Button
        android:id="@+id/btnClickMe"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Click Me" />

</LinearLayout>
```

### Subscripción al Evento

Para subscribirte al evento [`onClick`](https://developer.android.com/reference/android/view/View.OnClickListener) del botón que hemos creado con el id `btnHelloWorld`, añadimos dentro de la función `onCreate()` de la clase `MainActivity` el siguiente código:

```java
// Suscripción al evento onClick de btnHelloWorld utilizando OnClickListener
findViewById(R.id.btnHelloWorld).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        findViewById(R.id.textHelloWorld).setVisibility(View.VISIBLE);
        // Mostrar un mensaje Toast de corta duración cuando el botón es clickeado
        Toast.makeText(MainActivity.this, "¡Botón clickeado!", Toast.LENGTH_SHORT).show();
    }
});
```

### Prueba manual

En este punto, podemos ejecutar la aplicación. Veremos en la pantalla un Botón con el texto `Click me`, y al hacer click en el veremos un breve mensaje `¡Botón clickeado!` como esperamos, así como vemos que se hace visible otro elemento en la pantalla con el texto `"Hello World!"`.

### Prueba automática

Resulta difícil realizar una prueba instrumentalizada para comprobar que un `Toast` se ha mostrado, ya que su duración es corta y no deja rastro visible. Por eso, nos centraremos en el elemento de texto `txtHelloWorld`.

Añadimos el test instrumentalizado `MainActivityTest`.

```java
package es.jcs.subjects.pmdm.helloworld_android;

import static org.junit.Assert.assertEquals;

import android.view.View;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testButtonClick() {
        activityRule.getScenario()
                .onActivity(activity -> {
                    // Verificar que el TextView está inicialmente oculto
                    assertEquals("El TextView debería estar inicialmente oculto",
                            View.GONE, activity.findViewById(R.id.textHelloWorld).getVisibility());

                    // Simulamos el clic en el botón
                    activity.findViewById(R.id.btnHelloWorld).performClick();

                    // Verificar que el TextView se hace visible después del clic
                    assertEquals("El TextView debería ser visible después del clic",
                            View.VISIBLE, activity.findViewById(R.id.textHelloWorld).getVisibility());
                }
        );
    }

}
```

### Para saber más

- [Documentación oficial de Android sobre eventos y listeners](https://developer.android.com/develop/ui/views/touch-and-input/input-events?hl=es-419)
- [Toast](https://developer.android.com/reference/android/widget/Toast)

## Nuevo Intent Explícito "Bye World" en Android

