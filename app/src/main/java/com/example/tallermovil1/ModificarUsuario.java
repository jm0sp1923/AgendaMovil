package com.example.tallermovil1;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ModificarUsuario extends AppCompatActivity {

    EditText editTextId,editTextNombre,editTextApellido,editTextDocumento,editTextEdad,editTextTelefono,editTextDireccion,editTextNacimiento,editTextEmail,editTextPeliculaFav,editTextColorFav,editTextComidaFav,editTextLibroFav,editTextCancionFav,editTextDescPersonal;
    RadioButton rBGeneroMasculino,rBGeneroFemenino,rBEstadoCivilCasado,rBEstadoCivilSoltero;
    CheckBox checkBoxMusica,checkBoxDeporte,checkBoxCine,checkBoxComida,checkBoxViajes,checkBoxLibros;
    Spinner spinner;
    String[] equiposDeFutbol  = {"America", "Millonarios", "Cali", "Boca","River"};
    ArrayList<Usuario> usuarios;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_modificar_usuario);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        usuarios = (ArrayList<Usuario>) getIntent().getSerializableExtra("usuarios");
        if(usuarios== null){
            Log.e("ModificarUsuario", "El ArrayList de usuarios es null");
        }
        editTextNombre = findViewById(R.id.modificarEditTextNombre);
        editTextApellido = findViewById(R.id.modificarEditTextApellido);
        editTextDocumento = findViewById(R.id.modificarEditTextDocumento);
        editTextEdad = findViewById(R.id.modificarEditTextEdad);
        editTextTelefono = findViewById(R.id.modificarEditTextTelefono);
        editTextDireccion = findViewById(R.id.modificarEditTextDireccion);
        editTextNacimiento = findViewById(R.id.modificarEditTextNacimiento);
        editTextEmail = findViewById(R.id.modificarEditTextEmail);
        editTextPeliculaFav = findViewById(R.id.modificarEditTextPeliculaFav);
        editTextColorFav = findViewById(R.id.modificarEditTextColorFav);
        editTextComidaFav = findViewById(R.id.modificarEditTextComidaFav);
        editTextLibroFav = findViewById(R.id.modificarEditTextLibroFav);
        editTextCancionFav = findViewById(R.id.modificarEditTextCancionFav);
        editTextDescPersonal = findViewById(R.id.modificarEditTextDescripcion);
        editTextId = findViewById(R.id.modificarEditTextId);
// Inicializar RadioButtons
        rBGeneroMasculino = findViewById(R.id.modificarRButtonMasculino);
        rBGeneroFemenino = findViewById(R.id.modificarRButtonFemenino);
        rBEstadoCivilCasado = findViewById(R.id.modificarRButtonCasado);
        rBEstadoCivilSoltero = findViewById(R.id.modificarRButtonSoltero);

// Inicializar CheckBox
        checkBoxMusica = findViewById(R.id.modificarCheckBoxMusica);
        checkBoxDeporte = findViewById(R.id.modificarCheckBoxDeporte);
        checkBoxCine = findViewById(R.id.modificarCheckBoxCine);
        checkBoxComida = findViewById(R.id.modificarCheckBoxComida);
        checkBoxViajes = findViewById(R.id.modificarCheckBoxViajes);
        checkBoxLibros = findViewById(R.id.modificarCheckBoxLibros);

        //Adaptador Spinner
        {
            spinner = findViewById(R.id.modificarEquipoDefutSpinner);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, equiposDeFutbol);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        }

    }


    public void MsetWidgetsConInformacion(View view) {
        boolean existe = false;
        // Setear los EditTexts con los datos del Usuario
        try {

            int idUsuariosBuscar = Integer.parseInt(editTextId.getText().toString());
            for (int i = 0; i < usuarios.size(); i++) {
                if(idUsuariosBuscar == usuarios.get(i).getId()){
                    editTextNombre.setText(usuarios.get(i).getNombre());
                    editTextApellido.setText(usuarios.get(i).getApellido());
                    editTextDocumento.setText(String.valueOf(usuarios.get(i).getDocumento()));
                    editTextEdad.setText(String.valueOf(usuarios.get(i).getEdad()));
                    editTextTelefono.setText(String.valueOf(usuarios.get(i).getTelefono()));
                    editTextDireccion.setText(usuarios.get(i).getDireccion());
                    editTextNacimiento.setText(usuarios.get(i).getNacimiento());
                    editTextEmail.setText(usuarios.get(i).getEmail());
                    editTextPeliculaFav.setText(usuarios.get(i).getPeliculaFav());
                    editTextColorFav.setText(usuarios.get(i).getColorFav());
                    editTextComidaFav.setText(usuarios.get(i).getComidaFav());
                    editTextLibroFav.setText(usuarios.get(i).getLibroFav());
                    editTextCancionFav.setText(usuarios.get(i).getCancionFav());
                    editTextDescPersonal.setText(usuarios.get(i).getDescPersonal());

                    // Setear los RadioButtons de acuerdo al género y estado civil
                    if (usuarios.get(i).getGenero().equals("masculino")) {
                        rBGeneroMasculino.setChecked(true);
                    } else if (usuarios.get(i).getGenero().equals("femenino")) {
                        rBGeneroFemenino.setChecked(true);
                    }

                    if (usuarios.get(i).getEstadoCivil().equals("casado")) {
                        rBEstadoCivilCasado.setChecked(true);
                    } else if (usuarios.get(i).getEstadoCivil().equals("soltero")) {
                        rBEstadoCivilSoltero.setChecked(true);
                    }

                    // Setear los CheckBoxes de acuerdo a los gustos
                    ArrayList<String> gustos = usuarios.get(i).getGustos();
                    checkBoxMusica.setChecked(gustos.contains(checkBoxMusica.getText().toString()));
                    checkBoxDeporte.setChecked(gustos.contains(checkBoxDeporte.getText().toString()));
                    checkBoxCine.setChecked(gustos.contains(checkBoxCine.getText().toString()));
                    checkBoxComida.setChecked(gustos.contains(checkBoxComida.getText().toString()));
                    checkBoxViajes.setChecked(gustos.contains(checkBoxViajes.getText().toString()));
                    checkBoxLibros.setChecked(gustos.contains(checkBoxLibros.getText().toString()));

                    // Setear el equipo de fútbol favorito
                    String equipoFavorito = usuarios.get(i).getEquipoFav();
                    int posicion = -1;

                    // Buscar la posición del equipo en el array equiposDeFutbol
                    for (int j = 0; j < equiposDeFutbol.length; j++) {
                        if (equiposDeFutbol[j].equalsIgnoreCase(equipoFavorito)) {
                            posicion = j;
                            break;
                        }
                    }
                    spinner.setSelection(posicion);
                    existe = true;
                }
                if(existe){
                    editTextId.setEnabled(false);
                }
            }
        }catch (Exception e){
            Log.e("Error setear", "Error al setear usuarios", e);
        }

    }


    public void modificarInformacionUsuario(View view){

        try {
            int idUsuariosBuscar = Integer.parseInt(editTextId.getText().toString());
            for (int i = 0; i < usuarios.size(); i++) {
                if(idUsuariosBuscar == usuarios.get(i).getId()) {
                    usuarios.get(i).setNombre(editTextNombre.getText().toString());
                    usuarios.get(i).setApellido(editTextApellido.getText().toString());
                    usuarios.get(i).setDocumento(Integer.parseInt(editTextDocumento.getText().toString()));
                    usuarios.get(i).setEdad(Integer.parseInt(editTextEdad.getText().toString()));
                    usuarios.get(i).setTelefono(editTextTelefono.getText().toString());
                    usuarios.get(i).setDireccion(editTextDireccion.getText().toString());
                    usuarios.get(i).setNacimiento(editTextNacimiento.getText().toString());
                    usuarios.get(i).setEmail(editTextEmail.getText().toString());
                    usuarios.get(i).setPeliculaFav(editTextPeliculaFav.getText().toString());
                    usuarios.get(i).setColorFav(editTextColorFav.getText().toString());
                    usuarios.get(i).setComidaFav(editTextComidaFav.getText().toString());
                    usuarios.get(i).setLibroFav(editTextLibroFav.getText().toString());
                    usuarios.get(i).setCancionFav(editTextCancionFav.getText().toString());
                    usuarios.get(i).setDescPersonal(editTextDescPersonal.getText().toString());

                    if (rBEstadoCivilCasado.isChecked()) {
                        usuarios.get(i).setEstadoCivil("casado");
                    }
                    if (rBEstadoCivilSoltero.isChecked()) {
                        usuarios.get(i).setEstadoCivil("soltero");
                    }
                    if (rBGeneroFemenino.isChecked()) {
                        usuarios.get(i).setGenero("femenino");
                    }
                    if (rBGeneroMasculino.isChecked()) {
                        usuarios.get(i).setGenero("masculino");
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

                    usuarios.get(i).setGustos(gustos);
                    usuarios.get(i).setEquipoFav(spinner.getSelectedItem().toString());

                    Toast.makeText(this, "Usuario moficado con id: " + usuarios.get(i).getId(), Toast.LENGTH_SHORT).show();
                    retornar(view);
                }
            }
        } catch (Exception e) {
            Log.e("ErrorGuardarUsuario", "Error al guardar usuario", e);
            Toast.makeText(this, "Por favor ingrese todos los datos correctamente", Toast.LENGTH_SHORT).show();
        }
    }

    public void retornar(View view){
        Intent intento = new Intent();
        intento.putExtra("usuarios",usuarios);
        setResult(Activity.RESULT_OK,intento);
        finish();
    }


}