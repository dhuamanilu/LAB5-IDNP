package com.example.lab5_idnp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class EdificacionesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edificaciones, container, false);

        // Configurar onClick para la Catedral de Arequipa
        view.findViewById(R.id.catedralLayout).setOnClickListener(v -> openCatedralFragment());

        // Configurar onClick para el Claustro de la Compañía
        view.findViewById(R.id.claustroLayout).setOnClickListener(v -> openCatedralFragment());

        return view;
    }

    private void openCatedralFragment() {
        Fragment catedralFragment = new CatedralFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, catedralFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
