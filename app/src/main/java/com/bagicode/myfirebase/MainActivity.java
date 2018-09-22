package com.bagicode.myfirebase;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.bagicode.myfirebase.model.Requests;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "tamvan";
    private DatabaseReference database;

    private EditText etNama, etEmail, etDesk;
    private ProgressDialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = FirebaseDatabase.getInstance().getReference();

        etNama = findViewById(R.id.et_name);
        etEmail = findViewById(R.id.et_email);
        etDesk = findViewById(R.id.et_desk);

        findViewById(R.id.btn_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Snama = etNama.getText().toString();
                String Semail = etEmail.getText().toString();
                String Sdesk = etDesk.getText().toString();

                if (Snama.equals("")) {
                    etNama.setError("Silahkan masukkan nama");
                    etNama.requestFocus();
                } else if (Semail.equals("")) {
                    etEmail.setError("Silahkan masukkan email");
                    etEmail.requestFocus();
                } else if (Sdesk.equals("")) {
                    etDesk.setError("Silahkan masukkan desk");
                    etDesk.requestFocus();
                } else {
                    loading = ProgressDialog.show(MainActivity.this,
                            null,
                            "Please wait...",
                            true,
                            false);

                    submitUser(new Requests(
                            Snama.toLowerCase(),
                            Semail.toLowerCase(),
                            Sdesk.toLowerCase()));

                }

            }
        });
    }

    private void submitUser(Requests requests) {
        database.child("Request")
                .child("request_satu")
//                .push()
                .setValue(requests)
                .addOnSuccessListener(this, new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {

                        loading.dismiss();

                        etNama.setText("");
                        etEmail.setText("");
                        etDesk.setText("");

                        Toast.makeText(MainActivity.this,
                                "Data Berhasil ditambahkan",
                                Toast.LENGTH_SHORT).show();

                    }

                });
    }
}
