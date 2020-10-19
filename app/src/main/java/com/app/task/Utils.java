package com.app.task;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.view.ViewGroup;
import android.view.Window;

public class Utils {
    public static Dialog progressDialog(Context context) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Loading");
        progressDialog.show();
        return progressDialog;
    }
}
