package com.example.navigationdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavArgument;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.NavOptions;
import androidx.navigation.NavType;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.Window;

import com.example.navigationdemo.bean.FirstBean;
import com.example.navigationdemo.fragment.FirstFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.jaeger.library.StatusBarUtil;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "MainActivity---" + "onCreate");
        //去掉标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        StatusBarUtil.setTranslucent(this);
//        StatusBarUtil.setLightMode(this);//设置通知栏字体为黑色
        setContentView(R.layout.activity_main);

        /**
         * 动态加载 Navigation
         */
        FragmentManager fragmentManager = getSupportFragmentManager();
        NavHostFragment navHostFragment = (NavHostFragment) fragmentManager.findFragmentById(R.id.frag_nav_simple);//activity布局中fragment的id
        NavGraph navGraph = navHostFragment.getNavController().getNavInflater().inflate(R.navigation.navigation);//navigation布局id
        NavDestination navDestination = navGraph.findNode(R.id.firstFragment);//第一个fragment的id
        FirstBean bean = new FirstBean("初始化成功", 0);
        NavArgument navArgument = new NavArgument.Builder().setDefaultValue(bean).build();
        navDestination.addArgument("firstArg", navArgument);
        navHostFragment.getNavController().setGraph(navGraph);
        /**
         * 与 Toolbar 结合
         */
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        NavController navController = navHostFragment.getNavController();
        NavigationUI.setupActionBarWithNavController(MainActivity.this, navController);
        /**
         * 与BottomNavigationView结合
         */
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation_bottom);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "MainActivity---" + "onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "MainActivity---" + "onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "MainActivity---" + "onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "MainActivity---" + "onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "MainActivity---" + "onDestroy");

    }

    @Override
    public boolean onSupportNavigateUp() {
        Log.e(TAG, "MainActivity---" + "onSupportNavigateUp");
        return Navigation.findNavController(this, R.id.frag_nav_simple).navigateUp();
    }
}
