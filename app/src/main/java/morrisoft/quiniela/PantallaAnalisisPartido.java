package morrisoft.quiniela;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;


public class PantallaAnalisisPartido extends Activity {
  private ArrayList<String> data = new ArrayList<String>();
  private int numeroEquipos = 0;
  private int numeroEquipos2 = 0;
  private Bundle bundle;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.pantalla_analisis_partido);

    AdView mAdView = (AdView) findViewById(R.id.adView1);
    AdRequest adRequest = new AdRequest.Builder().build();
    mAdView.loadAd(adRequest);

    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitNetwork().build();
    StrictMode.setThreadPolicy(policy);

    // Cargar datos primera división

    String html = "http://www.lfp.es/liga-bbva";
    try {
      Document doc = Jsoup.connect(html).timeout(10000).get();
      Elements info = doc.select("table");

      Elements tableRowElements = info.select(":not(thead) tr");

      for (int i = 0; i < tableRowElements.size(); i++) {
        Element row = tableRowElements.get(i);
        Elements rowItems = row.select("td");

        for (int j = 0; j < rowItems.size(); j++) {
          if (j > 1) {
            data.add(rowItems.get(j).text());
          }
          if (j == 0)
            numeroEquipos = Integer.parseInt(rowItems.get(j).text());
        }
      }

    } catch (IOException e) {
      e.printStackTrace();
    }

    // Cargar datos segunda division

    html = "http://www.lfp.es/liga-adelante";
    try {
      Document doc = Jsoup.connect(html).timeout(10000).get();
      Elements info = doc.select("table");

      Elements tableRowElements = info.select(":not(thead) tr");

      for (int i = 0; i < tableRowElements.size(); i++) {
        Element row = tableRowElements.get(i);
        Elements rowItems = row.select("td");

        for (int j = 0; j < rowItems.size(); j++) {
          if (j > 1) {
            data.add(rowItems.get(j).text());
          }
          if (j == 0)
            numeroEquipos2 = Integer.parseInt(rowItems.get(j).text());
        }
      }

    } catch (IOException e) {
      e.printStackTrace();
    }

    Spinner dropdown1 = (Spinner) findViewById(R.id.textView9);
    if (numeroEquipos2 + numeroEquipos == 42) {
      String[] items = new String[numeroEquipos + numeroEquipos2 + 1];
      items[0] = "Anfitrion:";
      for (int k = 0; k < numeroEquipos + numeroEquipos2; k++) {
        items[k + 1] = data.get(k * 8);
      }
      ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);
      adapter1.setDropDownViewResource
          (android.R.layout.simple_spinner_dropdown_item);
      dropdown1.setAdapter(adapter1);
    } else {
      String[] items = new String[2];
      items[0] = "Anfitrion:";
      items[1] = "Error de conexion";
      ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);
      adapter1.setDropDownViewResource
          (android.R.layout.simple_spinner_dropdown_item);
      dropdown1.setAdapter(adapter1);
    }


    Spinner dropdown2 = (Spinner) findViewById(R.id.textView10);
    if (numeroEquipos2 + numeroEquipos == 42) {
      String[] items2 = new String[numeroEquipos + numeroEquipos2 + 1];
      items2[0] = "Visitante:";
      for (int k = 0; k < numeroEquipos + numeroEquipos2; k++) {
        items2[k + 1] = data.get(k * 8);
      }

      ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items2);
      adapter2.setDropDownViewResource
          (android.R.layout.simple_spinner_dropdown_item);
      dropdown2.setAdapter(adapter2);
    } else {
      String[] items2 = new String[2];
      items2[0] = "Visitante:";
      items2[1] = "Error de conexion";
      ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items2);
      adapter2.setDropDownViewResource
          (android.R.layout.simple_spinner_dropdown_item);
      dropdown2.setAdapter(adapter2);
    }

    dropdown1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position > 0) {
          EditText campo1 = (EditText) findViewById(R.id.editText);
          campo1.setText(data.get((position - 1) * 8 + 1).toString(), TextView.BufferType.EDITABLE);
          EditText campo2 = (EditText) findViewById(R.id.editText3);
          campo2.setText(data.get((position - 1) * 8 + 2).toString(), TextView.BufferType.EDITABLE);
          EditText campo3 = (EditText) findViewById(R.id.editText5);
          campo3.setText(data.get((position - 1) * 8 + 3).toString(), TextView.BufferType.EDITABLE);
          EditText campo4 = (EditText) findViewById(R.id.editText7);
          campo4.setText(data.get((position - 1) * 8 + 4).toString(), TextView.BufferType.EDITABLE);
          EditText campo5 = (EditText) findViewById(R.id.editText9);
          campo5.setText(data.get((position - 1) * 8 + 5).toString(), TextView.BufferType.EDITABLE);
          EditText campo6 = (EditText) findViewById(R.id.editText11);
          campo6.setText(data.get((position - 1) * 8 + 6).toString(), TextView.BufferType.EDITABLE);
          EditText campo7 = (EditText) findViewById(R.id.editText13);
          campo7.setText(data.get((position - 1) * 8 + 7).toString(), TextView.BufferType.EDITABLE);
        }
      }

      @Override
      public void onNothingSelected(AdapterView<?> parent) {

      }
    });

    dropdown2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position > 0) {
          EditText campo1 = (EditText) findViewById(R.id.editText2);
          campo1.setText(data.get((position - 1) * 8 + 1).toString(), TextView.BufferType.EDITABLE);
          EditText campo2 = (EditText) findViewById(R.id.editText14);
          campo2.setText(data.get((position - 1) * 8 + 2).toString(), TextView.BufferType.EDITABLE);
          EditText campo3 = (EditText) findViewById(R.id.editText4);
          campo3.setText(data.get((position - 1) * 8 + 3).toString(), TextView.BufferType.EDITABLE);
          EditText campo4 = (EditText) findViewById(R.id.editText6);
          campo4.setText(data.get((position - 1) * 8 + 4).toString(), TextView.BufferType.EDITABLE);
          EditText campo5 = (EditText) findViewById(R.id.editText8);
          campo5.setText(data.get((position - 1) * 8 + 5).toString(), TextView.BufferType.EDITABLE);
          EditText campo6 = (EditText) findViewById(R.id.editText10);
          campo6.setText(data.get((position - 1) * 8 + 6).toString(), TextView.BufferType.EDITABLE);
          EditText campo7 = (EditText) findViewById(R.id.editText12);
          campo7.setText(data.get((position - 1) * 8 + 7).toString(), TextView.BufferType.EDITABLE);
        }
      }

      @Override
      public void onNothingSelected(AdapterView<?> parent) {

      }
    });

    Button siguiente = (Button) findViewById(R.id.button);

    bundle = this.getIntent().getExtras();

    siguiente.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {


        Spinner spinner = (Spinner) findViewById(R.id.textView9);
        String e1 = spinner.getSelectedItem().toString();

        String e1c1 = ((EditText) findViewById(R.id.editText)).getText().toString();
        String e1c2 = ((EditText) findViewById(R.id.editText3)).getText().toString();
        String e1c3 = ((EditText) findViewById(R.id.editText5)).getText().toString();
        String e1c4 = ((EditText) findViewById(R.id.editText7)).getText().toString();
        String e1c5 = ((EditText) findViewById(R.id.editText9)).getText().toString();
        String e1c6 = ((EditText) findViewById(R.id.editText11)).getText().toString();
        String e1c7 = ((EditText) findViewById(R.id.editText13)).getText().toString();


        Spinner spinner2 = (Spinner) findViewById(R.id.textView10);
        String e2 = spinner2.getSelectedItem().toString();
        String e2c1 = ((EditText) findViewById(R.id.editText2)).getText().toString();
        String e2c2 = ((EditText) findViewById(R.id.editText14)).getText().toString();
        String e2c3 = ((EditText) findViewById(R.id.editText4)).getText().toString();
        String e2c4 = ((EditText) findViewById(R.id.editText6)).getText().toString();
        String e2c5 = ((EditText) findViewById(R.id.editText8)).getText().toString();
        String e2c6 = ((EditText) findViewById(R.id.editText10)).getText().toString();
        String e2c7 = ((EditText) findViewById(R.id.editText12)).getText().toString();
        String e1c8 = "";
        String e2c8 = "";

        try {

          e1c8 = String.valueOf(Integer.parseInt(e1c5) - Integer.parseInt(e1c6));
          e2c8 = String.valueOf(Integer.parseInt(e2c5) - Integer.parseInt(e2c6));

        } catch (NumberFormatException e) {
          e.printStackTrace();
        }

        bundle.putString("E1", e1);
        bundle.putString("E2", e2);
        bundle.putString("P1E1C1", e1c1);
        bundle.putString("P1E1C2", e1c2);
        bundle.putString("P1E1C3", e1c3);
        bundle.putString("P1E1C4", e1c4);
        bundle.putString("P1E1C5", e1c5);
        bundle.putString("P1E1C6", e1c6);
        bundle.putString("P1E1C7", e1c7);
        bundle.putString("P1E1C8", e1c8);
        bundle.putString("P1E2C1", e2c1);
        bundle.putString("P1E2C2", e2c2);
        bundle.putString("P1E2C3", e2c3);
        bundle.putString("P1E2C4", e2c4);
        bundle.putString("P1E2C5", e2c5);
        bundle.putString("P1E2C6", e2c6);
        bundle.putString("P1E2C7", e2c7);
        bundle.putString("P1E2C8", e2c8);

        bundle.putStringArrayList("data", data);
        bundle.putString("numeroEquipos", String.valueOf(numeroEquipos + numeroEquipos2 + 1));
        Boolean noHaySuficientesDatos =  (e1c2.equals("")) || (e2c2.equals("")) || (Integer.parseInt(e2c2) == 0) ||  (Integer.parseInt(e1c2) == 0) ;


        if ( noHaySuficientesDatos ) {
          AlertDialog.Builder dialog = new AlertDialog.Builder(PantallaAnalisisPartido.this);
          dialog.setTitle("Atención").setCancelable(false);
          dialog.setMessage("Uno de los dos equipos no ha jugado ningún partido esta temporada, la predicción perdera precisión.");
          dialog.setPositiveButton("Volver",
              new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                  dialog.dismiss();
                }
              });
          dialog.setNegativeButton("Continuar",
              new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                  Intent intent = new Intent(PantallaAnalisisPartido.this, PantallaResultadoPartido.class);
                  intent.putExtras(bundle);
                  startActivity(intent);
                }
              });
          dialog.show();
        }
        else {
          Intent intent = new Intent(PantallaAnalisisPartido.this, PantallaResultadoPartido.class);
          intent.putExtras(bundle);
          startActivity(intent);
        }

      }
    });
  }


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_pantalla_analisis1, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}
