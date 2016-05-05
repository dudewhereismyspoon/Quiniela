package morrisoft.quiniela;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class PantallaInicial extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.pantalla_inicial);
    final SharedPreferences settings =
        getSharedPreferences("localPreferences", MODE_PRIVATE);
    if (settings.getBoolean("isFirstRun", true)) {
      new AlertDialog.Builder(PantallaInicial.this)
          .setTitle("Politica de privacidad")
          .setMessage("En este sitio se usan identificadores de dispositivo para personalizar el contenido y los anuncios, con el fin de ofrecer funciones de medios sociales y para analizar el tr?fico. Adem?s, compartimos estos identificadores y otra informaci?n sobre su dispositivo con nuestros partners de publicidad y de an?lisis web.")
          .setNeutralButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              settings.edit().putBoolean("isFirstRun", false).commit();
            }
          })
          .show();
    }


    Button botonAnalisis = (Button) findViewById(R.id.botonAnalisisAvanzado);
    Button botonPartido = (Button) findViewById(R.id.botonAnalisisSimple);

    botonAnalisis.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Bundle bundle = new Bundle();
        Intent intent = new Intent(PantallaInicial.this, PantallaAnalisis1.class);
        bundle.putString("TIPO", "Analisis");
        intent.putExtras(bundle);
        startActivity(intent);
      }
    });

    botonPartido.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Bundle bundle = new Bundle();
        Intent intent = new Intent(PantallaInicial.this, PantallaAnalisisPartido.class);
        bundle.putString("TIPO", "Partido");
        intent.putExtras(bundle);
        startActivity(intent);
      }
    });
  }


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_pantalla_inicial, menu);
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
