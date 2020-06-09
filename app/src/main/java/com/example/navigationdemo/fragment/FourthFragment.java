package com.example.navigationdemo.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.navigationdemo.R;

public class FourthFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            String msg = bundle.getString("msg");
            if (!TextUtils.isEmpty(msg))
                Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fourth, container, false);
        onClick(view);
        return view;
    }

    private void onClick(View view) {
        Button btnBackFristFrag = view.findViewById(R.id.btn_back_first_fragment);
        btnBackFristFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).popBackStack(R.id.firstFragment, false);
                Navigation.findNavController(v).navigateUp();
                Navigation.findNavController(v).popBackStack();
            }
        });
    }
}
