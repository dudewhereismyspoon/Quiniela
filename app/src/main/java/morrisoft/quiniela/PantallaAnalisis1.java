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
import java.util.HashMap;


public class PantallaAnalisis1 extends Activity {
  private ArrayList<String> data = new ArrayList<String>();
  private ArrayList<String> matches = new ArrayList<String>();
  private int numeroEquipos = 0;
  private int numeroEquipos2 = 0;
  private int numeroPartidos = 0;
  private Bundle bundle;
  private HashMap<String,String> map = new HashMap<String,String>();



  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.pantalla_analisis1);

    map.put("FC Barcelona FCB","FCB");
    map.put("FC Barcelona","FCB");
    map.put("Barcelona","FCB");
    map.put("Real Madrid RMA","RMA");
    map.put("Real Madrid","RMA");
    map.put("Atlético Madrid ATM","ATM");
    map.put("Atlético Madrid","ATM");
    map.put("Atletico Madrid","ATM");
    map.put("Villarreal CF VIL","VIL");
    map.put("Villarreal CF","VIL");
    map.put("Villarreal","VIL");
    map.put("Athletic Club ATH","ATH");
    map.put("Athletic Club","ATH");
    map.put("RC Celta CEL","CEL");
    map.put("RC Celta","CEL");
    map.put("RC Celta Vigo","CEL");
    map.put("Celta","CEL");
    map.put("Celta Vigo","CEL");
    map.put("Sevilla FC SFC","SFC");
    map.put("Sevilla FC","SFC");
    map.put("Sevilla","SFC");
    map.put("Málaga CF MCF","MCF");
    map.put("Málaga CF","MCF");
    map.put("Malaga CF","MCF");
    map.put("Málaga","MCF");
    map.put("Malaga","MCF");
    map.put("Real Sociedad RSO","RSO");
    map.put("Real Sociedad","RSO");
    map.put("Real Betis RBB","RBB");
    map.put("Real Betis","RBB");
    map.put("Betis","RBB");
    map.put("UD Las Palmas LPA","LPA");
    map.put("UD Las Palmas","LPA");
    map.put("Las Palmas","LPA");
    map.put("Palmas","LPA");
    map.put("Valencia CF VCF","VCF");
    map.put("Valencia CF","VCF");
    map.put("Valencia","VCF");
    map.put("RCD Espanyol ESP","ESP");
    map.put("RCD Espanyol","ESP");
    map.put("RCD Español","ESP");
    map.put("Espanyol","ESP");
    map.put("Español","ESP");
    map.put("SD Eibar EIB","EIB");
    map.put("SD Eibar","EIB");
    map.put("Eibar","EIB");
    map.put("RC Deportivo RCD","RCD");
    map.put("RC Deportivo","RCD");
    map.put("Deportivo","RCD");
    map.put("Granada CF GCF","GCF");
    map.put("Granada CF","GCF");
    map.put("Granada","GCF");
    map.put("R. Sporting RSG","RSG");
    map.put("R. Sporting","RSG");
    map.put("Sporting","RSG");
    map.put("Sporting Gijón","RSG");
    map.put("Rayo Vallecano RVM","RVM");
    map.put("Rayo Vallecano","RVM");
    map.put("Getafe CF GET","GET");
    map.put("Getafe CF","GET");
    map.put("Getafe","GET");
    map.put("Levante UD LUD","LUD");
    map.put("Levante UD","LUD");
    map.put("Levante","LUD");
    map.put("D. Alavés ALV","ALV");
    map.put("D. Alavés","ALV");
    map.put("D. Alaves","ALV");
    map.put("Alavés","ALV");
    map.put("Alaves","ALV");
    map.put("CD Leganés LEG","LEG");
    map.put("CD Leganés","LEG");
    map.put("CD Leganes","LEG");
    map.put("Leganés","LEG");
    map.put("Leganes","LEG");
    map.put("Nàstic NAS","NAS");
    map.put("Nastic","NAS");
    map.put("Nàstic","NAS");
    map.put("Gimnàstic","NAS");
    map.put("Gimnastic","NAS");
    map.put("R. Zaragoza RZA","RZA");
    map.put("R. Zaragoza","RZA");
    map.put("Zaragoza","RZA");
    map.put("Córdoba CF CCF","CCF");
    map.put("Córdoba CF","CCF");
    map.put("Córdoba","CCF");
    map.put("Cordoba","CCF");
    map.put("Girona FC GIR","GIR");
    map.put("Girona FC","GIR");
    map.put("Girona","GIR");
    map.put("At Osasuna OSA","OSA");
    map.put("At Osasuna","OSA");
    map.put("Osasuna","OSA");
    map.put("AD Alcorcón ADA","ADA");
    map.put("AD Alcorcón","ADA");
    map.put("Alcorcón","ADA");
    map.put("Alcorcon","ADA");
    map.put("R. Oviedo ROV","ROV");
    map.put("R. Oviedo","ROV");
    map.put("Oviedo","ROV");
    map.put("Elche CF ECF","ECF");
    map.put("Elche CF","ECF");
    map.put("Elche","ECF");
    map.put("CD Tenerife CDT","CDT");
    map.put("CD Tenerife","CDT");
    map.put("Tenerife","CDT");
    map.put("CD Numancia NUM","NUM");
    map.put("CD Numancia","NUM");
    map.put("Numancia","NUM");
    map.put("CD Lugo LUG","LUG");
    map.put("CD Lugo","LUG");
    map.put("Lugo","LUG");
    map.put("CD Mirandés CDM","CDM");
    map.put("CD Mirandés","CDM");
    map.put("CD Mirandes","CDM");
    map.put("Mirandés","CDM");
    map.put("Mirandes","CDM");
    map.put("SD Huesca HUE","HUE");
    map.put("SD Huesca","HUE");
    map.put("Huesca","HUE");
    map.put("R. Valladolid CF VLL","VLL");
    map.put("R. Valladolid CF","VLL");
    map.put("R. Valladolid","VLL");
    map.put("Valladolid","VLL");
    map.put("UD Almería UDA","UDA");
    map.put("UD Almería","UDA");
    map.put("UD Almeria","UDA");
    map.put("Almería","UDA");
    map.put("Almeria","UDA");
    map.put("SD Ponferradina SDP","SDP");
    map.put("SD Ponferradina","SDP");
    map.put("Ponferradina","SDP");
    map.put("RCD Mallorca MLL","MLL");
    map.put("RCD Mallorca","MLL");
    map.put("Mallorca","MLL");
    map.put("UE Llagostera LLA","LLA");
    map.put("UE Llagostera","LLA");
    map.put("Llagostera","LLA");
    map.put("Albacete B. ABP","ABP");
    map.put("Albacete B.","ABP");
    map.put("Albacete","ABP");
    map.put("Bilbao Athletic BAT","BAT");
    map.put("Bilbao Athletic","BAT");
    map.put("Athletic Bilbao","BAT");
    map.put("Bilbao","BAT");

    AdView mAdView = (AdView) findViewById(R.id.adView1);
    AdRequest adRequest = new AdRequest.Builder().build();
    mAdView.loadAd(adRequest);

    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitNetwork().build();
    StrictMode.setThreadPolicy(policy);

    bundle = this.getIntent().getExtras();

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

    // Cargar datos Quiniela

    html = "http://www.quiniela15.com/pronostico-quiniela";
    try {
      Document doc = Jsoup.connect(html).timeout(10000).get();
      Elements info = doc.select("table");

      Elements tableRowElements = info.select(":not(thead) tr");

      if ( tableRowElements.size() > 15 )
        numeroPartidos = 15;

      for (int i = 0; i < tableRowElements.size(); i++) {
        Element row = tableRowElements.get(i);
        Elements rowItems = row.select("td");

        if (rowItems.size() > 8) {
          for (int j = 0; j <= 2; j++) {
            matches.add(rowItems.get(j).text());
            System.out.println(rowItems.get(j).text());
          }
        }

      }

    } catch (IOException e) {
      e.printStackTrace();
    }

    // Si todas las paginas se han cargado
    if (numeroEquipos+numeroEquipos2+numeroPartidos == 57) {
      int haySuficientesDatos = -1;
      for (int i = 0; i < numeroPartidos; i++) {
        String equipo1 = matches.get((i) * 3 + 1).toString();
        String equipo2 = matches.get((i) * 3 + 2).toString();
        haySuficientesDatos = writeStats(getPosition(equipo1), getPosition(equipo2), i);
        if (haySuficientesDatos == -1)
			i = numeroPartidos;
		else {
			bundle.putString("P" + String.valueOf(i+1) + "E1C0", equipo1);
			bundle.putString("P" + String.valueOf(i+1) + "E2C0", equipo2);
		}
      }
      if (haySuficientesDatos == 0) {
		  
        Intent intent = new Intent(PantallaAnalisis1.this, PantallaResultados.class);
        intent.putExtras(bundle);
        startActivity(intent);
      }
    }



    dropdown1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position > 0 && numeroEquipos + numeroEquipos2 == 42) {
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
        if (position > 0 && numeroEquipos + numeroEquipos2 == 42) {
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

    siguiente.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        String e1c1 = ((EditText) findViewById(R.id.editText)).getText().toString();
        String e1c2 = ((EditText) findViewById(R.id.editText3)).getText().toString();
        String e1c3 = ((EditText) findViewById(R.id.editText5)).getText().toString();
        String e1c4 = ((EditText) findViewById(R.id.editText7)).getText().toString();
        String e1c5 = ((EditText) findViewById(R.id.editText9)).getText().toString();
        String e1c6 = ((EditText) findViewById(R.id.editText11)).getText().toString();
        String e1c7 = ((EditText) findViewById(R.id.editText13)).getText().toString();

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
          AlertDialog.Builder dialog = new AlertDialog.Builder(PantallaAnalisis1.this);
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
                  Intent intent = new Intent(PantallaAnalisis1.this, PantallaAnalisis2.class);
                  intent.putExtras(bundle);
                  startActivity(intent);
                }
              });
          dialog.show();
        }
        else {
          Intent intent = new Intent(PantallaAnalisis1.this, PantallaAnalisis2.class);
          intent.putExtras(bundle);

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

  public String getCode(String nombre) {

    return map.get(nombre);

  }

  public int getPosition(String nombre) {
    String arr[] = nombre.split(" \\(", 2);
    String equipo = arr[0];
    int posicion = -1;
    for (int i = 0;i < data.size(); i++) {
      String temp = data.get(i).toString();
      if (getCode(temp).equals(getCode(equipo)))
        posicion = i;
      i+=7;
    }
    return posicion;
  }

  public int writeStats(int position1, int position2, int num) {
    String campo1 = "";
    String campo2 = "";
    if (position1 == -1 || position2 == -1) {
      for (int i = 0; i < 7; i++) {
        // TODO Mostrar datos parciales, si un partido no tiene datos no marcar nada
        campo1 = "0";
        campo2 = "0";
        bundle.putString("P" + String.valueOf(num+1) + "E1C" + String.valueOf(i), campo1);
        bundle.putString("P" + String.valueOf(num+1) + "E2C" + String.valueOf(i), campo2);

      }
      return 0;

    }
    else {
      for (int i = 0; i < 7; i++) {
        campo1 = data.get(position1 + i).toString();
        campo2 = data.get(position2 + i).toString();
        bundle.putString("P" + String.valueOf(num+1) + "E1C" + String.valueOf(i), campo1);
        bundle.putString("P" + String.valueOf(num+1) + "E2C" + String.valueOf(i), campo2);

      }
      return 0;
    }
  }


}

