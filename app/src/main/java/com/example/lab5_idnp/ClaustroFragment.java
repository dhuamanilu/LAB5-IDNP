package com.example.lab5_idnp;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ClaustroFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_claustro, container, false);

        ImageView imageView = view.findViewById(R.id.claustroImage);
        ImageUtils.applyCircularMask(imageView, R.drawable.claustro_image, getResources());

        return view;
    }
}
