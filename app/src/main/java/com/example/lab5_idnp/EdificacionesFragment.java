package com.example.lab5_idnp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class EdificacionesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edificaciones, container, false);

        ImageView catedralImage = view.findViewById(R.id.catedralImage);
        ImageUtils.applyCircularMask(catedralImage, R.drawable.catedral_image, getResources());


        ImageView claustroImage = view.findViewById(R.id.claustroImage);
        ImageUtils.applyCircularMask(claustroImage, R.drawable.claustro_image, getResources());

        view.findViewById(R.id.catedralLayout).setOnClickListener(v -> openCatedralFragment());


        view.findViewById(R.id.claustroLayout).setOnClickListener(v -> openClaustroFragment());

        return view;
    }

    private void openCatedralFragment() {
        Fragment catedralFragment = new CatedralFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, catedralFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    private void openClaustroFragment() {
        Fragment claustroFragment = new ClaustroFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, claustroFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
