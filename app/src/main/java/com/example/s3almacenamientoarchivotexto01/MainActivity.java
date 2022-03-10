package com.example.s3almacenamientoarchivotexto01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    EditText texto;
    Button btnGuardar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto= findViewById(R.id.txtTexto);
        btnGuardar=findViewById(R.id.btnGuardar);

        String archivos[] = fileList();
        if (ArchivoExiste(archivos ,"libreta.txt")){
            InputStreamReader archivo = null;
            try {
                archivo = new InputStreamReader(openFileInput("libreta.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            BufferedReader br = new BufferedReader(archivo);
            String linea = null;
            try {
                linea = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String cadenaCompleta ="";
            while (linea != null){
                cadenaCompleta = cadenaCompleta +linea + "\n";

            }
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                archivo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            texto.setText(cadenaCompleta);
        }
    }

    private boolean ArchivoExiste(String[] archivos, String s) {
        for (int i = 0; i < archivos.length; i++) {
            if (s.equals(archivos[i])) {
                return true;

            } else {
                return false;
            }
        }
        return false;
    }
}