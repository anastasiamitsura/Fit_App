package com.example.fit_app;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.os.Vibrator;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;

import com.example.fit_app.databinding.FragmentHomeScBinding;
import com.example.fit_app.databinding.FragmentScanerBinding;
import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.io.IOException;


public class ScanerFragment extends Fragment {

    private FragmentScanerBinding binding;
    public static String name = "";

    CameraSource cameraSource;
    BarcodeDetector barcodeDetector;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState
    ) {
        binding = FragmentScanerBinding.inflate(inflater, container, false);

        barcodeDetector = new BarcodeDetector.Builder(requireContext()).setBarcodeFormats(Barcode.ALL_FORMATS).build();

        cameraSource = new CameraSource.Builder(requireContext(), barcodeDetector).setRequestedPreviewSize(640, 480).setAutoFocusEnabled(true).build();

        binding.scanview.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(@NonNull SurfaceHolder holder) {
                if (ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                try{
                    cameraSource.start(holder);
                }
                catch (IOException e){
                    e.printStackTrace();
                }

            }

            @Override
            public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
                cameraSource.stop();

            }
        });

        barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
            @Override
            public void release() {

            }

            @Override
            public void receiveDetections(@NonNull Detector.Detections<Barcode> detections) {
                SparseArray<Barcode> qrCodes = detections.getDetectedItems();

                if(qrCodes.size() != 0){
                    binding.scantxt.post(() -> {
                        name = qrCodes.valueAt(0).displayValue;
                        if(name.equals("шоколад милка") || name.equals("молоко простоквашино") || name.equals("сырок чудо")){
                            binding.scantxt.setText(name);
                            getParentFragmentManager().
                                    beginTransaction().
                                    replace(R.id.container, new HomeSc())
                                    .commit();
                        }
                    });
                }
            }
        });

        return binding.getRoot();
    }
}