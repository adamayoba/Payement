package com.example.payement;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;



public class PaypalFragment extends DialogFragment {


    private EditText mEditText, pEditText;
    private SimpleDialogListener listener;
    private Button btn;


    public PaypalFragment() {
        // le fragment est créé par la méthode newInstance
    }

    public static PaypalFragment newInstance(String title) {

        PaypalFragment frag = new PaypalFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_paypal, container);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        listener = (SimpleDialogListener) getActivity();

        mEditText = (EditText) view.findViewById(R.id.txt_utilisateur);
        pEditText = (EditText) view.findViewById(R.id.txt_motdepass);
        btn = (Button) view.findViewById(R.id.connecter);

        // quand le button est cliqué, l'activité est appellé,
        // la valeur mEditText est passeé à l'activité en paramètre

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onOkClickDialog(mEditText.getText().toString(),pEditText.getText().toString());
            }
        });

        String title1 = getArguments().getString("title1", "Votre nom_utilisateur");
        String title2 = getArguments().getString("title2", "Votre mot_de_pass");
        getDialog().setTitle(title1);
        mEditText.requestFocus();

        getDialog().getWindow().setSoftInputMode(

                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

    }


}
