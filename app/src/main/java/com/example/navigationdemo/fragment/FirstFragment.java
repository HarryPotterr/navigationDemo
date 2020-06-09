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
import com.example.navigationdemo.bean.FirstBean;

public class FirstFragment extends Fragment {
    public static final String TAG = "Tag";

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.e(TAG, "FirstFragment---" + "onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        FirstBean bean = (FirstBean) bundle.getSerializable("firstArg");
        if (!TextUtils.isEmpty(bean.getMsg()))
            Toast.makeText(getContext(), bean.getMsg(), Toast.LENGTH_SHORT).show();
        Log.e(TAG, "FirstFragment---" +"onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        OnClick(view);
        Log.e(TAG, "FirstFragment---" +"onCreateView");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(TAG, "FirstFragment---" +"onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(TAG, "FirstFragment---" +"onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG, "FirstFragment---" +"onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e(TAG, "FirstFragment---" +"onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e(TAG, "FirstFragment---" +"onStop");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e(TAG, "FirstFragment---" +"onDestroyView");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "FirstFragment---" +"onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e(TAG, "FirstFragment---" +"onDetach");
    }

    private void OnClick(View view) {
        Button button = view.findViewById(R.id.firstFragment);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("msg", "第一个fragment跳转到第二个fragment ");
                NavOptions options = new NavOptions.Builder()
                        .setEnterAnim(R.anim.fragment_fade_enter)
                        .setExitAnim(R.anim.fragment_close_exit)
                        .setPopEnterAnim(R.anim.fragment_fade_enter)
                        .setPopExitAnim(R.anim.fragment_fade_exit)
                        .build();
                Navigation.findNavController(v).navigate(R.id.secondFragment, bundle, options);
            }
        });
    }
}
