package com.example.lab5_idnp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Bundle;
import android.widget.ImageView;

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

        // Aquí comienza el código para aplicar la máscara circular al ImageView
        ImageView imageView = findViewById(R.id.catedralImage);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.catedral_image);

        // Ajustar el tamaño del bitmap al tamaño deseado (asumiendo un tamaño cuadrado)
        int size = Math.min(bitmap.getWidth(), bitmap.getHeight());
        Bitmap resultBitmap = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(resultBitmap);

        // Crear un Path circular
        Path path = new Path();
        float radius = size / 2f;
        path.addCircle(radius, radius, radius, Path.Direction.CW);

        // Dibujar la imagen original dentro del path circular
        canvas.clipPath(path);
        canvas.drawBitmap(bitmap, null, new RectF(0, 0, size, size), new Paint(Paint.ANTI_ALIAS_FLAG));

        // Asignar el bitmap resultante al ImageView
        imageView.setImageBitmap(resultBitmap);
    }
}