package com.example.lab5_idnp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CatedralFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_catedral, container, false);


        ImageView imageView = view.findViewById(R.id.catedralImage);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.catedral_image);

        // Ajustar el tamaño del bitmap
        int size = Math.min(bitmap.getWidth(), bitmap.getHeight());
        Bitmap resultBitmap = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(resultBitmap);

        // Crear un Path circular
        Path path = new Path();
        float radius = size / 2f;
        path.addCircle(radius, radius, radius, Path.Direction.CW);

        canvas.clipPath(path);
        canvas.drawBitmap(bitmap, null, new RectF(0, 0, size, size), new Paint(Paint.ANTI_ALIAS_FLAG));

        imageView.setImageBitmap(resultBitmap);

        return view;
    }
}
