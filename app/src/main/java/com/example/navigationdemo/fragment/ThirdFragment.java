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
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;

import com.example.navigationdemo.R;

public class ThirdFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null){
            String msg = bundle.getString("msg");
            if (!TextUtils.isEmpty(msg)) Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third, container, false);
        onClick(view);
        return view;
    }

    private void onClick(View view) {
        Button btnBackFristFrag = view.findViewById(R.id.btn_to_fourth_fragment);
        btnBackFristFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("msg", "第三个fragment跳转到第四个fragment ");
                NavOptions options = new NavOptions.Builder()
                        .setEnterAnim(R.anim.fragment_open_enter)
                        .setExitAnim(R.anim.fragment_open_exit)
                        .setPopEnterAnim(R.anim.fragment_open_enter)
                        .setPopExitAnim(R.anim.fragment_open_exit)
                        .build();
                Navigation.findNavController(v).navigate(R.id.fourthFragment, bundle, options);
            }
        });
    }
}
