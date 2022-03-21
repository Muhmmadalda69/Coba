package com.example.myhope;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;
    private TextView tvDateResult;
    private EditText btDatePicker;

    EditText ETtinggi,ETberat, Enama, Eusia;
    TextView TVhasil;
    Button BTNsend, Breset;
    TextView IsiIMT;
    RadioGroup rgjk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Enama = (EditText) findViewById(R.id.enama);
        Eusia = (EditText) findViewById(R.id.eusia);

        rgjk = (RadioGroup) findViewById(R.id.jk);
        ETtinggi = (EditText) findViewById(R.id.tinggi);
        ETberat = (EditText) findViewById(R.id.berat);
        TVhasil = (TextView) findViewById(R.id.TVtampil);
        IsiIMT = (TextView) findViewById(R.id.IsiIMT);
        BTNsend = (Button) findViewById(R.id.btnkirim);
        Breset = (Button) findViewById(R.id.btnreset);

        BTNsend.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {

                String inputnama = String.valueOf(Enama.getText().toString());
                String inputusia = String.valueOf(Eusia.getText().toString());

                int gender = rgjk.getCheckedRadioButtonId();
                RadioButton jk = (RadioButton) findViewById(gender);
                String inputjk = String.valueOf(jk.getText().toString());


                float tinggi = Integer.parseInt(ETtinggi.getText().toString());
                float berat = Integer.parseInt(ETberat.getText().toString());

                float tinggi2 = tinggi/100;

                float hasil = berat/(tinggi2*tinggi2);

                String muncul;
                String IMT;

                if (hasil < 18.4)
                {
                    IMT = "IMT Anda : " + Math.ceil(hasil);
                    muncul = "Berat badan kurang";

                }
                else if(hasil >= 18.5 && hasil<24.9)
                {
                    IMT = "IMT Anda : " + Math.ceil(hasil);
                    muncul = "Berat badan ideal";
                }
                else if(hasil >= 25.0 && hasil<29.9)
                {
                    IMT = "IMT Anda : " + Math.ceil(hasil);
                    muncul = "Berat badan anda lebih";
                }
                else if(hasil >= 30.0 && hasil<39.9)
                {
                    IMT = "IMT Anda : " + Math.ceil(hasil);
                    muncul = "Gemuk";
                }
                else
                {
                    IMT = "IMT Anda : " + Math.ceil(hasil);
                    muncul = "Sangat Gemuk";
                }

                IsiIMT.setText(IMT);
                TVhasil.setText("Nama\t\t\t\t\t\t\t\t\t\t\t\t\t: " + inputnama + "\n" +
                        "Usia\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t: " + inputusia + " Tahun" + "\n"+
                        "Jenis Kelamin\t\t: " + inputjk + "\n" +
                        "- - - - - - - - - - - - - - - - - - - - - - - - - - - - " + "\n" +
                        "Keterangan\t\t\t\t\t\t: " +"\n" + muncul);
            }
        });

        Breset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Enama.setText("");
                Eusia.setText("");
                rgjk.clearCheck();
                ETberat.setText("");
                ETtinggi.setText("");
                IsiIMT.setText("IMT Anda :");
                TVhasil.setText("");
            }
        });

    }
}