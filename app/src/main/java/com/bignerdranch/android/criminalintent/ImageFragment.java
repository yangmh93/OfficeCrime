package com.bignerdranch.android.criminalintent;


import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

/**
 * Created by Michael on 10/9/2016.
 */
public class ImageFragment extends DialogFragment
{
    private static final String DIALOG_IMAGE = "dialog_image";
    public static ImageFragment newInstance(File photoFile)
    {
        Bundle args = new Bundle();
        args.putSerializable(DIALOG_IMAGE, photoFile);

        ImageFragment fragment = new ImageFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        super.onCreateDialog(savedInstanceState);

        File photoFile = (File) getArguments().getSerializable(DIALOG_IMAGE);

        Bitmap image = PictureUtils.getScaledBitmap(photoFile.getPath(), getActivity());

        View v =  LayoutInflater.from(getActivity()).inflate(R.layout.dialog_image, null);

        ImageView imageView = (ImageView) v.findViewById(R.id.dialog_image);
        imageView.setImageBitmap(image);

        return new AlertDialog.Builder(getActivity()).setView(imageView).create();

    }
}
