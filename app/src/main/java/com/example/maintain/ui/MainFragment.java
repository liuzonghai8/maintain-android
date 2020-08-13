package com.example.maintain.ui;



import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.maintain.R;
import com.example.maintain.basic.BasicFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainFragment extends BasicFragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //主导航
//        final NavController mainNavController = Navigation.findNavController(view);

        final NavController bottomNavController = Navigation.findNavController(requireActivity(),R.id.nav_bottomView);

        Log.d(TAG_LOG,"-----NavController bottomNavController----"+bottomNavController.toString());
       // AppBarConfiguration configuration=new AppBarConfiguration.Builder(bottomNavController.getGraph()).build();
       // NavigationUI.setupActionBarWithNavController((AppCompatActivity) requireActivity(),bottomNavController,configuration);
        BottomNavigationView navView = view.findViewById(R.id.bottom_nav);
        NavigationUI.setupWithNavController(navView, bottomNavController);

        //绑定model
       // LoginViewModel model= new ViewModelProvider(requireActivity()).get(LoginViewModel.class);

//        model.authenticationState.observe(getViewLifecycleOwner(),
//                new Observer<LoginViewModel.AuthenticationState>() {
//                    @Override
//                    public void onChanged(final LoginViewModel.AuthenticationState authenticationState) {
//                                switch (authenticationState) {
//                                    case AUTHENTICATED:
//                                        Log.d(TAG_LOG,"-----main fragment----");
//                                        break;
//                                    case UNAUTHENTICATED:
//                                        mainNavController.navigate(R.id.login_fragment);
//                                        break;
//                                }
//
//                            }
//                        });
//
                    }
}