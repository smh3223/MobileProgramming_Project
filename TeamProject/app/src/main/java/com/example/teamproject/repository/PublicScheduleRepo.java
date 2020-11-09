package com.example.teamproject.repository;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.teamproject.model.PublicSchedule;
import com.example.teamproject.viewmodel.ScheduleViewModel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class PublicScheduleRepo {
    PublicSchedule Schedule;
    List<PublicSchedule> PublicScheduleList;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    private void loadSchedule(){
        PublicScheduleList= new ArrayList<>();

        //파베연동
        db.collection("date")
                .add(PublicScheduleList)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot written with ID: " + documentReference.getId());

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });
        //
        ScheduleViewModel.saveSchedule(Schedule);
    }
}
