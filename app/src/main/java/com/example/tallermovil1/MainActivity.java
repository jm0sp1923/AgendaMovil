package com.example.tallermovil1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {

    EditText editTextNombre,editTextApellido,editTextDocumento,editTextEdad,editTextTelefono,editTextDireccion,editTextNacimiento,editTextEmail,editTextPeliculaFav,editTextColorFav,editTextComidaFav,editTextLibroFav,editTextCancionFav,editTextDescPersonal;
    RadioButton rBGeneroMasculino,rBGeneroFemenino,rBEstadoCivilCasado,rBEstadoCivilSoltero;
    CheckBox checkBoxMusica,checkBoxDeporte,checkBoxCine,checkBoxComida,checkBoxViajes,checkBoxLibros;
    Spinner spinner;
    String[] equiposDeFutbol  = {"America", "Millonarios", "Cali", "Boca","River"};
    Usuario usuario;
    ArrayList<Usuario> usuarios;
    int contador = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Persistencia de datos
        usuarios = new ArrayList<>();

        //Inicializar editText
        editTextNombre = findViewById(R.id.editTextNombre);
        editTextApellido = findViewById(R.id.editTextApellido);
        editTextDocumento = findViewById(R.id.editTextDocumento);
        editTextEdad = findViewById(R.id.editTextEdad);
        editTextTelefono = findViewById(R.id.editTextTelefono);
        editTextDireccion = findViewById(R.id.editTextDireccion);
        editTextNacimiento = findViewById(R.id.editTextNacimiento);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPeliculaFav = findViewById(R.id.editTextPeliculaFav);
        editTextColorFav = findViewById(R.id.editTextColorFav);
        editTextComidaFav = findViewById(R.id.editTextComidaFav);
        editTextLibroFav = findViewById(R.id.editTextLibroFav);
        editTextCancionFav = findViewById(R.id.editTextCancionFav);
        editTextDescPersonal = findViewById(R.id.editTextDescripcion);

        //Inicializar RadioButtons
        rBGeneroMasculino = findViewById(R.id.rButtonMasculino);
        rBGeneroFemenino = findViewById(R.id.rButtonFemenino);
        rBEstadoCivilCasado = findViewById(R.id.rButtonCasado);
        rBEstadoCivilSoltero = findViewById(R.id.rButtonSoltero);

        //Inicializar CheckBox
        checkBoxMusica = findViewById(R.id.checkBoxMusica);
        checkBoxDeporte = findViewById(R.id.checkBoxDeporte);
        checkBoxCine = findViewById(R.id.checkBoxCine);
        checkBoxComida = findViewById(R.id.checkBoxComida);
        checkBoxViajes = findViewById(R.id.checkBoxViajes);
        checkBoxLibros = findViewById(R.id.checkBoxLibros);

        //Adaptador Spinner
        {
        spinner = findViewById(R.id.equipoDefutSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, equiposDeFutbol);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        }
    }


    public void guardar(View view) {
        try {
            usuario = new Usuario();
            usuario.setId(contador);
            usuario.setNombre(editTextNombre.getText().toString());
            usuario.setApellido(editTextApellido.getText().toString());
            usuario.setDocumento(Integer.parseInt(editTextDocumento.getText().toString()));
            usuario.setEdad(Integer.parseInt(editTextEdad.getText().toString()));
            usuario.setTelefono(editTextTelefono.getText().toString());
            usuario.setDireccion(editTextDireccion.getText().toString());
            usuario.setNacimiento(editTextNacimiento.getText().toString());
            usuario.setEmail(editTextEmail.getText().toString());
            usuario.setPeliculaFav(editTextPeliculaFav.getText().toString());
            usuario.setColorFav(editTextColorFav.getText().toString());
            usuario.setComidaFav(editTextComidaFav.getText().toString());
            usuario.setLibroFav(editTextLibroFav.getText().toString());
            usuario.setCancionFav(editTextCancionFav.getText().toString());
            usuario.setDescPersonal(editTextDescPersonal.getText().toString());

            if (rBEstadoCivilCasado.isChecked()) {
                usuario.setEstadoCivil("casado");
            }
            if (rBEstadoCivilSoltero.isChecked()) {
                usuario.setEstadoCivil("soltero");
            }
            if (rBGeneroFemenino.isChecked()) {
                usuario.setGenero("femenino");
            }
            if (rBGeneroMasculino.isChecked()) {
                usuario.setGenero("masculino");
            }

            ArrayList<String> gustos = new ArrayList<>();

            if (checkBoxMusica.isChecked()) {
                gustos.add(checkBoxMusica.getText().toString());
            }
            if (checkBoxDeporte.isChecked()) {
                gustos.add(checkBoxDeporte.getText().toString());
            }
            if (checkBoxCine.isChecked()) {
                gustos.add(checkBoxCine.getText().toString());
            }
            if (checkBoxComida.isChecked()) {
                gustos.add(checkBoxComida.getText().toString());
            }
            if (checkBoxViajes.isChecked()) {
                gustos.add(checkBoxViajes.getText().toString());
            }
            if (checkBoxLibros.isChecked()) {
                gustos.add(checkBoxLibros.getText().toString());
            }

            usuario.setGustos(gustos);
            usuario.setEquipoFav(spinner.getSelectedItem().toString());

            usuarios.add(usuario);

            contador+=1;
            Toast.makeText(this, "Usuario guardado con id: " + usuario.getId(), Toast.LENGTH_SHORT).show();

            editTextNombre.setText("");
            editTextApellido.setText("");
            editTextDocumento.setText("");
            editTextEdad.setText("");
            editTextTelefono.setText("");
            editTextDireccion.setText("");
            editTextNacimiento.setText("");
            editTextEmail.setText("");
            editTextPeliculaFav.setText("");
            editTextColorFav.setText("");
            editTextComidaFav.setText("");
            editTextLibroFav.setText("");
            editTextCancionFav.setText("");
            editTextDescPersonal.setText("");

            rBGeneroMasculino.setChecked(false);
            rBGeneroFemenino.setChecked(false);
            rBEstadoCivilCasado.setChecked(false);
            rBEstadoCivilSoltero.setChecked(false);

            checkBoxMusica.setChecked(false);
            checkBoxDeporte.setChecked(false);
            checkBoxCine.setChecked(false);
            checkBoxComida.setChecked(false);
            checkBoxViajes.setChecked(false);
            checkBoxLibros.setChecked(false);

            spinner.setSelection(0);

        } catch (Exception e) {
            Log.e("ErrorGuardarUsuario", "Error al guardar usuario", e);
            Toast.makeText(this, "Por favor ingrese todos los datos correctamente", Toast.LENGTH_SHORT).show();
        }
    }

    public void buscarUsuario(View view){
        Intent intent = new Intent(this,BuscarUsuarioPorId.class);
        intent.putExtra("usuarios", usuarios);
        startActivity(intent);
    }

    public void modificarUsuario(View view){
        Intent intent = new Intent(this, ModificarUsuario.class);
        intent.putExtra("usuarios", usuarios);
        startActivityForResult(intent, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            if (resultCode == MainActivity.RESULT_OK && data != null) {
                usuarios = (ArrayList<Usuario>) data.getSerializableExtra("usuarios");
            }
        }
    }
}