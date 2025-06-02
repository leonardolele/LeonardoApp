package com.example.leonardoapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Kakulatorleonardo extends AppCompatActivity {

    EditText edit1, edit2;
    Button buttonTambah, buttonKali, buttonBagi;
    TextView textViewHasil, textViewJudul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kakulatorleonardo);

        // Inisialisasi komponen
        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        buttonTambah = findViewById(R.id.button);
        buttonKali = findViewById(R.id.button2);
        buttonBagi = findViewById(R.id.button3);
        textViewHasil = findViewById(R.id.textView3);
        textViewJudul = findViewById(R.id.textView);

        // Tombol Tambah
        buttonTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung("tambah");
            }
        });

        // Tombol Kali
        buttonKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung("kali");
            }
        });

        // Tombol Bagi
        buttonBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung("bagi");
            }
        });
    }

    // Fungsi hitung berdasarkan operasi
    private void hitung(String operasi) {
        String input1 = edit1.getText().toString();
        String input2 = edit2.getText().toString();

        if (input1.isEmpty() || input2.isEmpty()) {
            textViewHasil.setText("Harap isi kedua nilai.");
            return;
        }

        try {
            double angka1 = Double.parseDouble(input1);
            double angka2 = Double.parseDouble(input2);
            double hasil = 0;

            switch (operasi) {
                case "tambah":
                    hasil = angka1 + angka2;
                    break;
                case "kali":
                    hasil = angka1 * angka2;
                    break;
                case "bagi":
                    if (angka2 == 0) {
                        textViewHasil.setText("Tidak bisa dibagi dengan nol.");
                        return;
                    }
                    hasil = angka1 / angka2;
                    break;
            }

            textViewHasil.setText("Hasil: " + hasil);
        } catch (NumberFormatException e) {
            textViewHasil.setText("Masukkan angka yang valid.");
        }
    }
}
