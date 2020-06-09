package com.example.navigationdemo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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

import static com.example.navigationdemo.fragment.FirstFragment.TAG;

public class SecondFragment extends Fragment {
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.e(TAG, "SecondFragment---" + "onAttach");

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "SecondFragment---" + "onCreate");
        Bundle bundle = getArguments();
        if (bundle != null){
            String msg = bundle.getString("msg");
            if (!TextUtils.isEmpty(msg)) Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        onClick(view);
        Log.e(TAG, "SecondFragment---" + "onCreateView");

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(TAG, "SecondFragment---" + "onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(TAG, "SecondFragment---" + "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG, "SecondFragment---" + "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e(TAG, "SecondFragment---" + "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e(TAG, "SecondFragment---" + "onStop");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e(TAG, "SecondFragment---" + "onDestroyView");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "SecondFragment---" + "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e(TAG, "SecondFragment---" + "onDetach");
    }

    private void onClick(View view) {
        Button gothird = view.findViewById(R.id.btn_back_first_fragment);
        gothird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("msg", "第二个fragment跳转到第三个fragment ");
                NavOptions options = new NavOptions.Builder()
                        .setEnterAnim(R.anim.nav_default_enter_anim)
                        .setExitAnim(R.anim.nav_default_exit_anim)
                        .setPopEnterAnim(R.anim.nav_default_pop_enter_anim)
                        .setPopExitAnim(R.anim.nav_default_pop_exit_anim)
                        .build();
                Navigation.findNavController(v).navigate(R.id.thirdFragment, bundle, options);
            }
        });
    }
}
