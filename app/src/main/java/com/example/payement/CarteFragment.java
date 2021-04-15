package com.example.payement;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.Nullable;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

import static android.widget.Toast.*;

public class CarteFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {


    private EditText nEditText, pEditText,numEditText,codeEditText;
    private SimpleDialogListener listener;
    private Button btn,dateEdit;


    public CarteFragment() {
        // le fragment est créé par la méthode newInstance
    }

    public static CarteFragment newInstance(String title) {

        CarteFragment frag = new CarteFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_carte, container);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        listener = (SimpleDialogListener) getActivity();

        nEditText = (EditText) view.findViewById(R.id.txt_nom);
        pEditText = (EditText) view.findViewById(R.id.txt_prenom);
        numEditText = (EditText) view.findViewById(R.id.txt_num);
        codeEditText = (EditText) view.findViewById(R.id.txt_code);
        dateEdit = (Button)view.findViewById(R.id.date);
        btn = (Button) view.findViewById(R.id.valider);

        // quand le button est cliqué, l'activité est appellé,
        // la valeur mEditText est passeé à l'activité en paramètre

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onOkClickDialog1(nEditText.getText().toString(),pEditText.getText().toString(),numEditText.getText().toString(),codeEditText.getText().toString(),dateEdit);
            }
        });

        dateEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(dateEdit);
            }
        });


        String title = getArguments().getString("title", "Votre nom_utilisateur");

        getDialog().setTitle(title);
        nEditText.requestFocus();

        getDialog().getWindow().setSoftInputMode(

                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

    }
    public void showDatePickerDialog(View v) {

        DatePickerFragment datePickerFragment = new DatePickerFragment();
        datePickerFragment.show(getFragmentManager(), "datePicker");

    }



    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        // stocker les valeurs sélectionnées dans une instance de type Calendar
        final Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
       // Toast.makeText(this, c.getTime().toString(), Toast.LENGTH_SHORT).show();
    }


}