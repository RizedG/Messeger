package com.example.messeger;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ViewModels.BasicWindowViewModel;

public class BasicWindow extends Fragment {

    private BasicWindowViewModel mViewModel;

    public static BasicWindow newInstance() {
        return new BasicWindow();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_basic_window, container, false);
    }

}