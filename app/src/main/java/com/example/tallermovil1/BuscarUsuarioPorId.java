package com.example.tallermovil1;

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

public class BuscarUsuarioPorId extends AppCompatActivity {

    EditText editTextId,editTextNombre,editTextApellido,editTextDocumento,editTextEdad,editTextTelefono,editTextDireccion,editTextNacimiento,editTextEmail,editTextPeliculaFav,editTextColorFav,editTextComidaFav,editTextLibroFav,editTextCancionFav,editTextDescPersonal;
    TextView equipoDeFutFavorito;
    RadioButton rBGeneroMasculino,rBGeneroFemenino,rBEstadoCivilCasado,rBEstadoCivilSoltero;
    CheckBox checkBoxMusica,checkBoxDeporte,checkBoxCine,checkBoxComida,checkBoxViajes,checkBoxLibros;

    ArrayList<Usuario> usuarios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_buscar_usuario_por_id);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        usuarios = (ArrayList<Usuario>) getIntent().getSerializableExtra("usuarios");

        editTextNombre = findViewById(R.id.buscarEditTextNombre);
        editTextApellido = findViewById(R.id.buscarEditTextApellido);
        editTextDocumento = findViewById(R.id.buscarEditTextDocumento);
        editTextEdad = findViewById(R.id.buscarEditTextEdad);
        editTextTelefono = findViewById(R.id.buscarEditTextTelefono);
        editTextDireccion = findViewById(R.id.buscarEditTextDireccion);
        editTextNacimiento = findViewById(R.id.buscarEditTextNacimiento);
        editTextEmail = findViewById(R.id.buscarEditTextEmail);
        editTextPeliculaFav = findViewById(R.id.buscarEditTextPeliculaFav);
        editTextColorFav = findViewById(R.id.buscarEditTextColorFav);
        editTextComidaFav = findViewById(R.id.buscarEditTextComidaFav);
        editTextLibroFav = findViewById(R.id.buscarEditTextLibroFav);
        editTextCancionFav = findViewById(R.id.buscarEditTextCancionFav);
        editTextDescPersonal = findViewById(R.id.buscarEditTextDescripcion);
        editTextId = findViewById(R.id.buscarEditTextId);

        equipoDeFutFavorito = findViewById(R.id.equipoFutFav);

// Inicializar RadioButtons
        rBGeneroMasculino = findViewById(R.id.buscarRButtonMasculino);
        rBGeneroFemenino = findViewById(R.id.buscarRButtonFemenino);
        rBEstadoCivilCasado = findViewById(R.id.buscarRButtonCasado);
        rBEstadoCivilSoltero = findViewById(R.id.buscarRButtonSoltero);

// Inicializar CheckBox
        checkBoxMusica = findViewById(R.id.buscarCheckBoxMusica);
        checkBoxDeporte = findViewById(R.id.buscarCheckBoxDeporte);
        checkBoxCine = findViewById(R.id.buscarCheckBoxCine);
        checkBoxComida = findViewById(R.id.buscarCheckBoxComida);
        checkBoxViajes = findViewById(R.id.buscarCheckBoxViajes);
        checkBoxLibros = findViewById(R.id.buscarCheckBoxLibros);


    }


    public void setWidgetsConInformacion(View view) {
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
                    equipoDeFutFavorito.setText(usuarios.get(i).getEquipoFav());
                    existe = true;
                }
            }
            if(existe){
                Toast.makeText(this, "Usuario encontrado", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "Usuario no encontrado", Toast.LENGTH_SHORT).show();
                editTextNombre.setText("Nombre");
                editTextApellido.setText("Apellido");
                editTextDocumento.setText("Documento");
                editTextEdad.setText("Edad");
                editTextTelefono.setText("Telefono");
                editTextDireccion.setText("Direccion");
                editTextNacimiento.setText("Nacimiento");
                editTextEmail.setText("Email");
                editTextPeliculaFav.setText("Pelicula favorita");
                editTextColorFav.setText("Color favorito");
                editTextComidaFav.setText("Comida favorita");
                editTextLibroFav.setText("Libro favorito");
                editTextCancionFav.setText("Cancion favorita");
                editTextDescPersonal.setText("Descripcion Personal ....");

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

                equipoDeFutFavorito.setText("Equipo de futbol favorito");
            }

        }catch (Exception e){
            Log.e("Error setear", "Error al setear usuarios", e);
        }

    }
}