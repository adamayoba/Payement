package com.example.payement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;


import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;




public class MainActivity extends AppCompatActivity implements SimpleDialogListener {

    /*Button frag_simple_btn;
    Button frag_alert_btn;
    Button frag_date_btn;
    Button frag_progress_btn;*/
    Button carte;
    Button paypal;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        carte = findViewById(R.id.carte);
        paypal = findViewById(R.id.paypal);

        carte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager frag = getSupportFragmentManager();
                CarteFragment carteFragment = CarteFragment.newInstance("Titre");
                carteFragment.show(frag,"fragment_carte");
            }
        });
        paypal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   // getSupportFragmentManager().beginTransaction().add(R.id.container,new PaypalFragment()).commit();
                FragmentManager fm = getSupportFragmentManager();
                PaypalFragment paypalFragment = PaypalFragment.newInstance("Titre");
                paypalFragment.show(fm, "fragment_paypal");
            }
        });
       /* frag_simple_btn = findViewById(R.id.frag_simple_btn);
        frag_simple_btn = findViewById(R.id.frag_simple_btn);
        frag_alert_btn = findViewById(R.id.frag_alert_btn);
        frag_date_btn = findViewById(R.id.frag_date_btn);
        frag_progress_btn = findViewById(R.id.frag_progress_btn);



        frag_simple_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSimpleDialog();

            }
        });
        frag_alert_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog();

            }
        });
        frag_date_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { showDatePickerDialog(frag_date_btn);
            }
        });
        frag_progress_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProgressDialog();

            }
        });*/


    }


    private void showSimpleDialog() {

        FragmentManager fm = getSupportFragmentManager();
        PaypalFragment paypalFragment = PaypalFragment.newInstance("Titre");
        paypalFragment.show(fm, "fragment_simple_dialog");

    }

    private void showAlertDialog() {

        FragmentManager fm = getSupportFragmentManager();
        AlertDialogFragment alertDialog = AlertDialogFragment.newInstance("Some title");
        alertDialog.show(fm, "fragment_alert");

    }

    // Afficher le DatePicker

   /* public void showDatePickerDialog(View v) {

        DatePickerFragment datePickerFragment = new DatePickerFragment();
        datePickerFragment.show(getSupportFragmentManager(), "datePicker");

    }*/

    // onDateSet est appellé automatiquement après avoir choisir la date
   /* @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

        // stocker les valeurs sélectionnées dans une instance de type Calendar
        final Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, monthOfYear);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        Toast.makeText(this, c.getTime().toString(), Toast.LENGTH_SHORT).show();

    }*/

    public void showProgressDialog() {

        final ProgressDialog progressDialog = new ProgressDialog(this);

        progressDialog.setTitle("Loading...");
        progressDialog.setMessage("Please wait.");
        progressDialog.setCancelable(true);
        progressDialog.setCancelable(false);
        progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                progressDialog.dismiss();
            }
        });

        progressDialog.show();
    }


    // Cette méthode est appellée dans l'activité quand le listener est déclanché
    // Les données sont passées en paramétres


    @Override
    public void onOkClickDialog(String username, String password) {
        Toast.makeText(this, "Bonjour , " + username, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onOkClickDialog1(String inputText, String input, String input1, String input2,Button date1) {
        Toast.makeText(this, "Merci "+input+" "+inputText, Toast.LENGTH_SHORT).show();
    }
}

