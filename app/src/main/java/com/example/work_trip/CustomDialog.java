package com.example.work_trip;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import com.example.work_trip.databinding.ActivityCustomDialogBinding;
import com.example.work_trip.databinding.ActivitySignUp01Binding;

public class CustomDialog  extends Dialog {
    private ActivityCustomDialogBinding binding;

    public CustomDialog(@NonNull Context context) {
        super(context);
        // binding = DataBindingUtil.setContentView(get, R.layout.activity_custom_dialog);

    }
}