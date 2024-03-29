package morrisoft.quiniela;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.ads.*;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.InterstitialAd;

import java.util.Random;


public class PantallaResultadoPartido extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_pantalla_resultado_partido);
    final InterstitialAd interstitialAd;
    Random rn = new Random();
    final int flag = rn.nextInt(9);
    interstitialAd = new InterstitialAd(this);
    if (flag > 6) {

      interstitialAd.setAdUnitId(getResources().getString(R.string.inter_ad_unit_id));


      interstitialAd.setAdListener(new AdListener() {
        @Override
        public void onAdClosed() {
          Intent intent = new Intent(PantallaResultadoPartido.this, PantallaInicial.class);
          startActivity(intent);
        }
      });

      AdRequest adRequest = new AdRequest.Builder().build();

      interstitialAd.loadAd(adRequest);
    }
    final Bundle datos = this.getIntent().getExtras();

    ProgressBar barraIzquierda = (ProgressBar) findViewById(R.id.progressBar);
    ProgressBar barraDerecha = (ProgressBar) findViewById(R.id.progressBar2);
    ProgressBar barraIzquierda2 = (ProgressBar) findViewById(R.id.progressBar3);
    ProgressBar barraDerecha2 = (ProgressBar) findViewById(R.id.progressBar4);

    TextView visitante = (TextView) findViewById(R.id.textView27);
    TextView anfitrion = (TextView) findViewById(R.id.textView28);

    visitante.setText(datos.getString("E2"));
    anfitrion.setText(datos.getString("E1"));

    barraIzquierda.setRotation(180);
    barraIzquierda2.setRotation(180);

    // Red para X

    // 20x16
    double[] capaInicial = {
        -0.026197, -0.046067, -0.0014403, -0.021876, -0.022751, -0.037509, 0.0017288, -0.039238, 0.0069937, -0.028735, 0.0089588, -0.019883, -0.035227, 0.065805, -0.0059304, 0.071735,
        -0.045921, 0.032323, -0.02249, 0.02155, 0.033264, -0.032392, 0.056446, -0.088839, 0.074561, 0.035151, 0.022679, 0.0065244, 0.003115, 0.02325, -0.0051619, 0.028412,
        -0.0013493, 0.015569, -0.0032493, 0.0083986, 0.010419, -0.0021555, 0.02132, -0.023475, 0.034329, 0.016949, 0.0097922, 0.0049519, 0.00087612, 0.019671, 0.0079099, 0.011761,
        -0.086523, -0.049112, -0.022055, -0.020357, -0.0067001, -0.05392, -0.033097, -0.020823, 0.036814, -0.04492, 0.025069, -0.038392, -0.035929, 0.057069, -0.052855, 0.10992,
        -0.018842, 0.023488, -0.011262, 0.014945, 0.019805, -0.0021022, 0.035186, -0.037288, 0.060532, 0.02436, 0.0171, 0.0092329, -0.0027875, 0.031267, 0.0067105, 0.024556,
        -0.080331, -0.033845, -0.024719, -0.0061745, -0.0029511, -0.05042, -0.026382, -0.024039, 0.016883, -0.032683, 0.010741, -0.01534, -0.029302, 0.010116, -0.046456, 0.056572,
        -0.036877, 0.035883, -0.021318, 0.027077, 0.030124, -0.034332, 0.049495, -0.083827, 0.063147, 0.042799, 0.017469, 0.010741, 0.0077711, 0.023271, 0.0030017, 0.02027,
        -0.08664, -0.036645, -0.026684, -0.0065874, -0.0033731, -0.056047, -0.025382, -0.030666, 0.021026, -0.036424, 0.012189, -0.015541, -0.033353, 0.013735, -0.040955, 0.05469,
        -0.031913, 0.0083388, -0.0067396, -0.011695, 0.026773, 0.0036605, 0.014656, -0.010995, -0.0065018, 0.0043062, -0.0035285, 0.0040838, 0.0078943, -0.025412, 0.029507, -0.054919,
        0.044804, -0.034091, 0.022363, -0.022284, -0.03417, 0.03066, -0.054273, 0.084934, -0.070995, -0.038901, -0.02091, -0.0082648, -0.0049273, -0.020391, 0.0060205, -0.026411,
        -0.094004, 0.044411, -0.043803, 0.037406, 0.050808, -0.02355, 0.092879, -0.11643, 0.11504, 0.049247, 0.038693, -0.0010373, 0.0068166, 0.019196, -0.022005, 0.041201,
        0.024465, -0.033201, 0.015991, -0.023506, -0.025685, 0.0029987, -0.04365, 0.046649, -0.089191, -0.035917, -0.025345, -0.013157, 0.0053755, -0.041947, 0.0069381, -0.048885,
        -0.02293, 0.0013914, -0.0040484, -0.010784, 0.016224, 0.017731, 0.019479, -0.0017474, -0.0092171, -0.0025144, -0.0048058, 0.0052002, 0.00098283, -0.024239, -0.00074177, -0.023497,
        -0.0053891, -0.012856, 0.00060912, -0.0072164, -0.0062489, -0.0072305, -0.018601, 0.01137, -0.039245, -0.014524, -0.011782, -0.0038995, 0.0027683, -0.027754, -0.003691, -0.024063,
        0.028359, 0.076042, 5.8661e-05, 0.028183, 0.0478, 0.070092, 0.0092302, 0.060862, -0.0010791, 0.033926, -0.010552, 0.030578, 0.056035, -0.11317, -0.011918, -0.10126,
        0.034688, -0.043783, 0.01958, -0.024053, -0.03931, 0.02765, -0.052454, 0.080104, -0.025422, -0.064749, -0.0038855, -0.013765, -0.026241, 0.026031, -0.013324, 0.039355,
        -0.039851, -0.0021974, -0.008947, -0.01301, 0.019759, 0.025194, 0.055702, -0.030508, 0.027746, -0.009695, 0.0077143, 0.0046031, -0.014753, 0.0024057, -0.026276, 0.028682,
        -0.079248, -0.033031, -0.024114, -0.0069057, -0.002011, -0.048573, -0.023806, -0.024767, 0.017968, -0.031916, 0.010018, -0.012086, -0.031035, 0.0055899, -0.046001, 0.051591,
        0.043553, 0.067182, 0.011853, 0.0079926, 0.047336, 0.079291, 0.051194, 0.028096, 0.0061589, 0.056306, -0.0012654, 0.009955, 0.058799, -0.1014, -0.13285, 0.031446,
        -1.607e-05, 0.010633, -0.0017379, 0.0051977, 0.0071728, -0.00013579, 0.01678, -0.016915, 0.020813, 0.01142, 0.0060955, 0.0025261, 0.0020167, 0.015286, 0.01247, 0.0028159
    };


    // 19x20
    double[] capaDos = {
        0.024809, 0.033203, 0.0085806, 0.042933, 0.021448, 0.039941, 0.031604, 0.042146, -0.025655, -0.031851, 0.063735, -0.036401, -0.015926, -0.006942, -0.055809, -0.032941, -0.030759, 0.040176, -0.057356, 0.003916,
        -0.013965, -0.018211, -0.0053498, -0.02444, -0.011423, -0.021416, -0.017155, -0.022714, 0.013212, 0.017441, -0.033707, 0.019883, 0.010102, 0.0035514, 0.030886, 0.018151, 0.014257, -0.020783, 0.03084, -0.0025836,
        0.015282, 0.019967, 0.0058023, 0.026722, 0.012537, 0.023509, 0.018814, 0.024925, -0.014562, -0.019117, 0.037042, -0.021799, -0.010977, -0.0039121, -0.033837, -0.019886, -0.015838, 0.02289, -0.033861, 0.0027905,
        0.015288, 0.019949, 0.0059977, 0.026972, 0.012511, 0.02349, 0.018779, 0.024927, -0.014439, -0.019116, 0.036874, -0.021851, -0.011351, -0.0038858, -0.034003, -0.019903, -0.015317, 0.022661, -0.033889, 0.0028899,
        0.012174, 0.015821, 0.0049046, 0.021563, 0.0099076, 0.018587, 0.014887, 0.019745, -0.011297, -0.015178, 0.029086, -0.017348, -0.0092265, -0.00305, -0.027048, -0.01582, -0.011713, 0.017759, -0.026807, 0.0023849,
        0.033308, 0.046368, 0.013025, 0.061182, 0.032117, 0.05902, 0.045266, 0.06216, -0.037693, -0.045491, 0.093813, -0.053032, -0.022233, -0.010448, -0.080684, -0.046798, -0.046911, 0.058431, -0.084541, 0.0055516,
        0.016456, 0.021519, 0.0063525, 0.028948, 0.013513, 0.025368, 0.020266, 0.026905, -0.015684, -0.020611, 0.0399, -0.023551, -0.012044, -0.0042167, -0.036602, -0.021445, -0.016867, 0.024605, -0.036592, 0.0030475,
        -0.032861, -0.045755, -0.012548, -0.059773, -0.031809, -0.058261, -0.044811, -0.061311, 0.037313, 0.044935, -0.092869, 0.052249, 0.021072, 0.010358, 0.07914, 0.046197, 0.047271, -0.057986, 0.083193, -0.0053413,
        -0.0043816, -0.0057972, -9.2395e-05, -0.0056814, -0.0035758, -0.0066509, -0.005519, -0.0068674, 0.005035, 0.005352, -0.011491, 0.0056752, 0.0004311, 0.0012174, 0.0082286, 0.0054351, 0.0082175, -0.0081467, 0.009213, -9.6915e-06,
        0.03103, 0.042543, 0.011551, 0.055699, 0.028566, 0.052854, 0.041012, 0.055716, -0.033912, -0.041288, 0.084122, -0.047798, -0.020564, -0.0093274, -0.073042, -0.042563, -0.041371, 0.052703, -0.075936, 0.0050397,
        -0.032204, -0.044466, -0.012255, -0.058416, -0.030271, -0.055845, -0.043097, -0.058845, 0.03577, 0.043354, -0.088829, 0.050356, 0.021426, 0.009876, 0.076811, 0.044649, 0.044019, -0.055517, 0.080145, -0.0052862,
        -0.013421, -0.017467, -0.005362, -0.023748, -0.010943, -0.020538, -0.016437, -0.021809, 0.012531, 0.01675, -0.032169, 0.019148, 0.010112, 0.0033787, 0.029836, 0.017452, 0.013088, -0.019685, 0.029626, -0.0025987,
        -0.014703, -0.019195, -0.0055918, -0.025703, -0.012047, -0.022588, -0.018086, -0.023951, 0.013974, 0.018379, -0.035582, 0.020952, 0.01057, 0.0037543, 0.032527, 0.019122, 0.01517, -0.021975, 0.032528, -0.0026939,
        -0.017734, -0.023262, -0.0066452, -0.031, -0.014645, -0.027469, -0.021933, -0.029105, 0.017135, 0.022266, -0.043358, 0.025413, 0.012605, 0.0046026, 0.039398, 0.023143, 0.018881, -0.026888, 0.039585, -0.0031682,
        -0.014998, -0.019597, -0.0056206, -0.026123, -0.012307, -0.023067, -0.018472, -0.024447, 0.014325, 0.018756, -0.036395, 0.021364, 0.010628, 0.0038451, 0.033129, 0.019506, 0.015722, -0.022535, 0.033197, -0.0027031,
        0.010235, 0.013263, 0.0043156, 0.018334, 0.008302, 0.015575, 0.012472, 0.016569, -0.0093287, -0.012748, 0.024242, -0.014606, -0.0080763, -0.002533, -0.022846, -0.013306, -0.009305, 0.014659, -0.022489, 0.0021107,
        -0.011045, -0.014352, -0.0043475, -0.019419, -0.0089888, -0.016845, -0.013513, -0.017884, 0.010283, 0.01376, -0.02643, 0.01569, 0.0081694, 0.0027722, 0.024421, 0.014335, 0.010855, -0.016196, 0.024256, -0.0021166,
        0.015544, 0.020303, 0.0060021, 0.027314, 0.012742, 0.023912, 0.019121, 0.025363, -0.01476, -0.019447, 0.037606, -0.022207, -0.011362, -0.0039688, -0.034514, -0.020238, -0.015856, 0.023177, -0.034475, 0.0028874,
        0.014426, 0.018798, 0.0057318, 0.025515, 0.011781, 0.022119, 0.01769, 0.023482, -0.013536, -0.018021, 0.034669, -0.020606, -0.010831, -0.0036464, -0.032096, -0.018771, -0.014207, 0.021248, -0.031916, 0.0027701
    };


    // 1x19
    double[] capaTres = {
        -0.1644, 0.087473, -0.096115, -0.096063, -0.075841, -0.24459, -0.10384, 0.24095, 0.027038, -0.21884, 0.23138, 0.083872, 0.092307, 0.11253, 0.094273, -0.06348, 0.068674, -0.097798, -0.0904
    };


    // 20x1
    double[] biasInput = {


        -0.0091529,
        0.0002839,
        0.00065311,
        0.0025315,
        -0.0013503,
        0.0059736,
        0.0007816,
        0.0069457,
        0.00044011,
        0.00016896,
        -0.0082365,
        0.0043798,
        0.0011464,
        -0.00018658,
        0.020933,
        0.0012492,
        -0.0020315,
        0.0062516,
        0.00042569,
        0.00013531
    };


    // 19x1
    double[] biasDos = {

        -0.0074712,
        0.0045317,
        -0.0049398,
        -0.0049611,
        -0.0039816,
        -0.0086594,
        -0.0053146,
        0.008494,
        0.0013868,
        -0.0085987,
        0.0086736,
        0.0043788,
        0.0047601,
        0.0056815,
        0.004844,
        -0.0033667,
        0.0036102,
        -0.0050316,
        -0.0046964
    };

    double biasTres = 0.078684;

    // Red para 1-2

    // 40x16
    double[] capa1 = {
        0.93479, 0.012387, 25.022, 0.5904, -0.17774, 0.6893, 0.064862, 0.24901, 0.10845, -0.016383, 0.51689, -0.50996, -0.41905, -0.0013343, -0.073745, -0.68873,
        0.001684, -0.033325, 0.10353, -0.1612, 0.015387, -0.038422, -0.14835, 0.27257, -0.062896, -0.038715, -0.32235, -0.59433, 0.45835, -0.025106, -0.02108, -0.50206,
        0.11089, 0.068096, 0.050567, 0.26093, 0.085167, 0.20374, 0.21637, -0.31107, -0.1047, 0.031973, -0.15815, 1.3892, 0.41855, 0.0066685, 0.27335, -0.568,
        -0.13569, -0.55841, -0.035957, 0.41226, 1.0642, -0.016166, 0.38542, -0.081856, 0.51715, -0.58198, -0.61368, -0.11957, -0.75094, 0.37097, -0.74095, -0.1223,
        0.031132, 0.027579, 0.094404, 0.037273, -0.01658, -0.031297, 0.027322, 0.69391, 0.011747, 0.0047234, -0.02368, 0.15247, 0.098782, 0.032936, -0.0016793, -0.094845,
        0.060719, -0.018041, 0.16555, 0.0029569, -0.75808, -0.013488, -0.023244, 0.18071, -0.14327, 0.016023, 0.058649, -0.13351, 0.00063591, 0.045498, 6.1004e-05, 0.010479,
        -0.10198, 0.066757, -0.1349, 1.2074, 1.5466, 0.089646, 0.23894, -0.27877, 0.23065, 0.054622, -1.1494, 0.20063, -0.45374, 0.20372, 0.034884, 0.1649,
        0.7602, 0.053511, -24.308, -0.10251, 0.065772, -0.12414, -0.016477, -0.30164, -0.045333, 0.038349, -0.042556, -0.22073, 0.23334, 0.013781, -0.06045, 0.093482,
        0.13561, -0.099578, 0.14476, -0.14958, -0.042973, 0.15191, 0.029909, 0.32112, -0.1925, -0.1429, -0.65473, -0.050443, -0.12274, 0.0135, 0.11178, -0.077095,
        -0.045952, 0.054936, -0.059754, -0.23949, 0.10643, -0.062107, 0.035129, 0.17366, 0.064989, 0.088299, 0.12142, 0.022353, -0.13888, 0.045967, 0.066737, 0.4176,
        0.024315, -0.064794, 0.14934, 0.17744, 0.034134, -0.082205, 0.034644, -0.68417, 0.12756, -0.0075205, 0.21375, -0.15644, -0.1173, 0.04257, -0.033322, 0.45884,
        -0.40651, -0.043491, 5.9682, -0.72552, -1.3428, -5.6503, -1.2967, 0.4173, 0.12306, -0.045394, -0.8734, 2.2024, -43.455, 2.1169, 0.81284, 0.2136,
        -0.13653, 0.11784, -0.14466, 4.1809, -0.88491, 0.11397, 0.26888, 0.10573, 0.19006, 0.14335, 0.013216, 1.1788, 0.17788, -0.56021, 0.41464, -0.01106,
        -0.005223, -0.04294, 0.015936, -0.16612, -0.044629, -0.0093412, -0.020227, -0.20483, -0.015674, -0.025419, 0.022636, 0.036511, -0.040902, -0.025723, 0.0032126, 0.23855,
        0.017105, 0.02506, 0.41574, 0.12394, 0.025998, 0.010082, 0.03996, 0.23108, 0.055317, 0.039214, -0.0016008, 0.19803, -0.054735, 0.064697, -0.0046522, -0.19397,
        -0.029279, -0.20989, -4.8938, 0.64175, -7.1544, 0.14031, 0.0059116, -2.7332, -0.029679, -0.19184, 0.80872, -1.6252, -0.25459, 0.3365, -0.17684, 0.50843,
        0.27097, -0.052273, 0.28694, -0.52918, 0.06761, -0.11607, -0.087622, -0.33963, -0.090804, -0.081635, -0.17931, -0.91672, 0.12474, -0.086596, -0.099823, -0.33695,
        -0.40379, 0.02108, -1.9671, 2.1881, -0.52258, 0.004284, 0.099699, -0.14607, 0.010629, 0.017629, 0.061597, 1.1793, -5.7213, 0.050166, -0.19397, -0.1247,
        -0.076278, -0.25761, 0.30245, -3.0041, 0.77832, -0.032251, -0.27234, 0.50733, -0.33238, -0.21033, -1.9072, -0.84412, 0.32018, -0.21384, -0.13562, -0.94317,
        0.48204, 0.28309, -2.6353, 1.5422, -0.11858, 0.10706, 0.11221, 0.13509, 0.10367, 0.32077, 0.12944, 0.92613, 22.369, 0.11791, 0.32812, -0.73778,
        -0.15071, -0.039176, -0.52597, -0.81239, -0.086537, -0.12207, -0.072446, -0.025349, -0.019961, -0.059423, 0.0075925, -0.45176, -1.7319, -0.017259, -0.18805, 0.15561,
        -2.0265, 0.53929, 1.2921, -1.5536, 0.098104, 0.57407, 0.042289, 0.38404, 0.10315, 0.54528, 0.14041, -2.9681, -1.3463, 0.10055, 0.6175, 0.048691,
        -0.43853, -0.44384, -0.41224, 1.4974, -0.33632, 0.40642, -0.15707, 0.17438, -0.00061162, -0.41776, 0.024686, -1.9908, -3.1621, -0.011604, 0.053405, 0.63121,
        0.29664, -0.017579, 0.18114, 0.99842, -0.017957, -0.23331, 0.0021833, 0.0064795, 0.033227, -0.029179, -0.15859, 0.29169, 0.36027, -0.18741, -0.016142, -0.39197,
        0.22152, 0.07543, 0.2222, 0.077133, 0.016559, 0.05754, -0.1359, -0.13116, -0.14535, 0.049433, -0.11705, -0.044417, -0.085734, -0.053542, -0.066, 0.089382,
        -0.022449, -0.030674, 0.10012, -0.24494, 0.22161, -0.023109, -0.001795, 0.13241, -0.014228, -0.021136, -0.010427, -0.0089085, -0.055566, -0.0019383, -0.026861, -0.46229,
        -0.055078, -0.10396, 1.6693, 0.86776, 0.34958, -0.32248, -0.12893, 0.024741, -0.08375, -0.1241, -0.11239, 2.4207, -3.3135, -0.16027, -0.15468, 0.45752,
        -0.015888, -0.018673, -0.012748, -0.025615, 0.0064825, -0.023379, 0.013609, 0.097468, 0.088174, 0.01411, 0.029, 0.22966, 0.0081849, -0.011744, -0.0008082, -0.068199,
        0.019102, 0.034079, -0.012452, 1.9199, 0.19698, 0.018527, 0.069975, -0.57844, 0.17164, 0.059048, 0.16706, 0.52634, -0.23524, 0.060457, 0.058012, 0.044243,
        -0.21268, -0.16105, -0.15618, -0.21185, -0.016459, -0.13363, -0.11381, 0.066187, 0.0082258, -0.094893, 0.043591, 0.2967, -0.52921, 0.091243, -0.23829, 0.33341,
        -0.021707, 0.0049897, 0.0056841, 0.23107, 0.049673, -0.021287, 0.045271, -0.07344, 0.042454, 0.0050727, 0.068598, 0.046007, -0.011572, 0.037295, -0.049169, -0.16786,
        -0.030533, -0.061492, -0.068326, -0.30504, -0.015221, -0.036742, -0.037411, 0.42352, -0.027806, -0.050758, -0.033672, -0.061421, 0.038749, -0.00054269, -0.0034571, -0.61119,
        -0.047164, -0.42858, 1.7703, 0.52889, 1.8175, -0.064215, 0.080685, -0.026644, -0.34653, -0.4409, -1.492, -3.1696, 0.45397, -0.087986, -0.22209, 0.32742,
        -0.062565, -0.090047, -0.045382, -0.0033744, -0.026447, -0.076496, 0.068486, -0.47607, -0.023796, -0.035852, -0.075334, 0.067666, -0.52607, -0.055587, -0.088829, 0.72496,
        0.18151, -0.040479, -1.2129, 0.87261, -0.84556, 0.46037, -0.041734, -0.15918, -0.14066, -0.044848, -0.16914, -0.08528, 0.035538, -0.12756, -0.056212, -0.1405,
        0.023554, 0.055275, 0.066762, -0.029737, -0.058905, -0.040486, 0.03635, -0.037334, -0.055351, 0.020579, 0.031799, 0.13714, 0.058192, -0.07541, -0.075016, -0.41596,
        -0.14527, -0.012427, -0.22669, -0.03175, -0.13069, -0.13703, -0.044319, 0.59691, -0.057981, -0.059027, 0.010378, 0.27653, -0.4861, -0.055913, 0.11686, -1.3061,
        -0.25499, -4.7076, -0.34547, -0.96087, -10.002, -4.8417, -9.4349, -0.90064, -4.5035, -4.7453, -0.14836, -0.90524, -5.91, -7.224, -5.8686, 2.4511,
        -0.0084696, -0.082715, -0.10633, 0.38772, -0.10016, -0.066741, -0.040755, 0.17397, -0.086979, -0.04174, 0.76454, -0.4283, 0.027967, -0.091729, -0.026921, -0.085993,
        -0.02926, 4.9695, -1.3852, 3.9578, 10.616, 0.31949, 22.149, 0.23376, 0.35462, 4.9987, 0.38114, -0.0086582, 13.327, 4.8075, 3.4224, -3.393
    };

    // 20x40
    double[] capa2 = {
        1.3327, 0.46319, 1.4638, -0.64453, -0.28094, 0.11084, 0.1073, -0.12275, 0.31384, 0.31336, 0.44564, 0.11031, -0.019801, -0.39042, 0.69848, 0.010496, 0.50629, -2.9313, -0.44648, 0.056114, -2.1146, -0.50836, 0.0263, -0.30983, 0.39853, 0.22811, -0.046649, -1.0883, 0.31738, 0.12686, -0.049512, -0.42595, -0.98474, -0.77721, -0.27489, 0.13654, -0.23865, -0.043702, -0.2835, -0.40305,
        0.57534, -0.1767, 0.39818, -0.33871, -0.11153, -0.0097718, 0.31811, 0.4089, -0.20844, 1.1508, -0.39496, 0.19106, 0.085094, 0.12843, -0.40252, 0.37952, -0.44128, -0.13886, -0.48174, 0.46426, -0.35619, 0.06092, 0.28059, -0.084891, 0.30137, -0.30911, -0.11408, 1.4146, 0.42512, 0.23209, 0.21815, 0.35554, -0.067576, -0.37669, 0.50623, -0.23194, 0.33037, 0.29985, -0.33892, -0.023913,
        -0.0036041, 1.2785, 0.40513, -0.28488, -0.24234, 0.020884, -0.10906, 0.19784, -0.12835, 1.4222, 0.54049, -0.079537, 0.11941, -0.036101, -0.34953, -0.18981, -0.16042, -0.39268, -0.2265, 0.077822, 0.33638, 0.25316, 0.097094, -0.20819, -0.10119, -0.67132, 0.16673, 0.45469, 0.48132, 0.39074, -0.24757, -0.13621, -0.36481, 0.42707, 0.13068, -0.078104, 0.19405, 0.32054, -0.80465, 0.25389,
        0.67532, -0.15238, 0.085366, 2.5092, -2.1128, 0.94585, -0.096512, 0.34709, 0.29403, 1.0009, -1.2316, -0.43001, 0.28431, 0.41708, -0.40037, 0.31703, -0.05611, 0.69921, -0.72827, -0.058544, -0.81706, -1.0426, 0.088541, 0.27494, 0.18605, 0.23918, 0.30912, 4.3047, -0.14025, -0.18912, 0.38668, -0.034306, -0.41903, 0.21692, 0.7983, -0.38794, -1.1133, -0.18559, -0.72344, -0.23798,
        0.48815, -0.079513, -0.17343, -0.34211, 0.024802, 0.36281, 3.3148, -0.58771, -0.92866, 0.78237, -0.041894, -0.20297, 0.79838, -0.37568, 0.16886, 0.10894, 0.24555, 0.18052, 1.3818, 0.59103, 0.13282, 0.47857, -0.86482, 0.93459, 0.93895, 0.27809, -0.99015, -0.23021, 0.52277, 0.014559, 0.21635, 0.067664, -0.19388, 0.34939, 0.054085, 0.14755, -0.67734, -0.83314, 0.12534, 0.48543,
        -0.36212, -0.39762, -0.43259, 0.26541, -0.0093682, 1.4491, 0.084954, -0.46867, 0.33611, -2.8502, -1.0258, -0.27765, 0.24154, 0.14088, -0.22059, -0.31774, 0.23062, -0.044924, -0.08354, 0.43166, -0.34305, 0.41521, -0.043765, -0.41128, 0.94214, 0.074883, 0.26354, 0.12583, -0.034867, 0.17792, -0.06286, 0.30817, 0.19534, 0.14522, -0.45763, -0.18664, -0.19944, -0.43897, 0.062267, 0.058025,
        -0.043381, -0.26617, -0.57022, -0.39641, 0.044611, 0.48973, 0.32368, 0.0794, -0.53041, -1.8303, -0.16345, -0.1657, -0.42279, -0.11383, 0.14492, -0.37526, -0.12812, -0.12525, 0.24623, -0.32275, -0.35133, -0.034986, -0.32047, 1.2181, -0.37485, -0.035753, -0.42175, -1.5877, 0.64632, -0.30852, -0.11983, 0.31576, 0.031629, 0.35308, -1.2182, 1.0783, -0.16964, 0.067808, 0.035415, 0.29853,
        -0.26055, 1.6334, -1.2357, 0.014883, 2.4648, -0.41155, -0.063496, -0.22106, -0.11453, -0.40074, 0.71667, 0.35506, 0.22675, -0.0032165, 0.27322, -0.077769, 0.27907, -0.74055, 2.2955, -0.39199, 0.38444, 0.69481, -0.38927, 0.32584, -0.20554, -1.6749, 0.0086824, -7.8022, -0.75093, -0.27154, -0.051613, -0.11314, -0.18467, -0.027497, -0.10282, 0.058862, 1.3592, 0.29253, -3.1613, 0.27348,
        -0.0076356, -0.019613, 0.042427, -0.27676, -0.29361, -0.38414, -0.10386, 0.082816, 0.12286, 0.37064, 0.029228, -0.36323, 0.047251, 0.58585, -0.43767, 0.37844, -0.27009, -0.020543, -1.1371, -0.30461, 0.38734, 0.26235, 0.23263, 0.42405, 0.35772, 0.12753, -0.31177, 0.23105, -0.25681, 0.31891, -0.17483, -0.1042, -0.19725, 0.22974, 0.57093, -0.20489, -0.029673, 0.067082, -0.010623, -0.10162,
        -0.54303, 0.036429, -0.32848, 0.5753, -1.0378, -0.52974, -0.1254, 0.30876, 0.18808, 0.3716, 0.0011685, -0.023762, 0.45791, 0.9437, -0.36303, 0.088133, 0.23299, -0.41417, 0.6195, 0.23088, 0.72444, -0.31978, 0.20825, 0.91737, -0.42999, -0.36332, 0.089982, 0.081241, 0.38742, 0.11862, 0.20552, -0.17246, 0.090032, 0.069604, -0.056696, 0.96308, -0.48415, -0.29308, -0.60217, -0.21188,
        0.46131, 0.50405, 1.738, -1.1751, -1.9352, 0.27428, -0.15783, -0.081746, -0.087143, 0.021483, -0.38121, -1.0525, -0.2694, -1.815, 3.1409e-05, -0.2874, -0.337, -0.20579, -0.010896, 0.40296, 0.309, 0.72394, -0.36832, 0.90105, 0.18267, -0.30059, 1.3268, 0.5795, 0.39371, 0.73647, -0.083699, 0.19019, -0.56058, 0.31139, 0.048671, 0.59469, 0.16038, 0.25349, -1.2464, 0.47448,
        -0.27439, 0.2314, -0.065884, -0.45849, 0.11917, -3.9358, -0.064752, -0.20215, 0.84863, -3.5816, 0.61878, -0.54542, -0.19475, 0.096167, 0.48859, -0.61969, -0.20957, -0.18118, -0.041613, 0.38272, -0.28827, 0.3942, -0.35198, 0.1313, 1.3781, -0.8457, 0.099699, -0.093998, 0.34693, -0.096195, 0.16404, -1.1456, -0.021089, 0.61965, -0.22693, -2.8938, 1.9959, -0.27409, 0.2154, 0.47305,
        -2.426, 0.10163, -0.77853, 0.93905, 0.0055108, -0.61391, -0.57737, 0.16813, 0.16807, 0.042278, 0.36636, -0.24671, 0.42524, 0.12751, -1.3411, -0.43081, 0.055671, 0.059191, 0.25112, -0.56281, 2.8717, -0.058187, 0.32698, -0.49331, 0.41849, 0.48471, 0.287, -1.5732, 0.12567, 0.20937, -0.40028, 0.36272, 1.0185, 0.29816, -0.41919, -0.72979, 0.87083, 0.084962, 0.31488, -0.026163,
        -0.37316, 0.41041, -0.44125, 0.16413, 0.47187, 1.9962, 0.37356, -0.22327, -1.3338, -1.1787, -0.64283, 0.2605, 0.2359, 0.025367, -0.16535, -0.43474, 0.092103, -0.43348, 0.054563, 0.22675, 0.35779, 0.46308, 0.016565, -0.079349, -0.2927, 1.0027, 0.27171, -0.30976, 0.43645, 0.55124, -0.20119, 1.5092, 0.3602, 0.13471, -0.040557, 0.18713, -0.47745, -0.27745, 0.38086, 0.37057,
        -0.22868, -0.11354, 0.23356, 0.24052, 0.38139, 0.079559, -0.12095, -0.17765, 0.12189, -0.23835, 0.11299, -0.19074, 0.093086, 0.27774, -0.2193, 0.21254, 0.42589, -0.083313, -0.26161, 0.18919, -0.10151, 0.44681, -0.444, 0.47402, -0.12927, 0.26838, -0.31198, -0.071646, -0.059381, 0.17851, 0.050206, 0.84425, -0.098476, 0.028397, -0.37432, 0.45095, -0.39551, -0.0038344, 0.43484, 0.12379,
        0.020208, 0.58183, 0.28192, -0.26949, -0.96188, -0.072951, 0.2177, -0.31363, -0.14416, 0.99344, 0.6202, -0.0344, 0.082518, 0.29646, -0.018998, 0.12984, 0.17135, 0.75996, -0.63651, -0.12542, 0.33205, 0.038284, -0.19466, 0.35537, -0.059265, -0.41652, -0.16198, 0.0028703, 0.53493, -0.28254, -0.40658, 0.068126, -0.23188, 0.21853, 0.1803, -0.25486, -0.020414, 0.10903, 0.12586, 0.16555,
        0.30487, -0.3326, 0.2279, 0.023387, 0.095252, 0.23906, -0.13587, 0.38843, 23.009, -16.125, -0.53476, -0.038009, -0.36799, 0.63692, 0.25214, -0.088772, 0.26072, -0.3331, 0.3853, -0.29473, -0.33276, -0.5101, -0.092083, -0.3724, 0.46939, 1.5805, 0.10723, -0.07511, -0.69075, -0.65988, -0.0022687, -0.17826, 0.31186, -0.25677, -0.2989, -0.53872, 1.329, 0.50082, -0.40187, -0.34062,
        -0.3655, -0.20501, 0.22119, 0.033463, -0.67007, -0.40871, 0.4226, 0.28055, 0.13003, -0.33068, -0.098513, 0.017933, 0.0056244, 0.0096274, 0.30363, 0.20169, 0.25778, -0.35711, -0.39988, 0.10335, 0.48188, -0.59954, -0.17633, 0.18533, -0.038306, 0.0003345, 0.17318, -0.279, -0.15647, -0.064992, 0.19997, -0.79978, 0.25091, 0.55024, 0.25235, 0.16444, -0.23487, -0.40031, -0.16754, 0.40261,
        -0.082391, 0.66222, -0.11337, 0.67519, -0.28079, -0.28195, 0.28722, -0.26143, -0.6509, -0.99146, 1.3603, -0.3305, -0.27152, 0.0018015, 0.033719, -0.29029, 0.10555, -0.0028472, 0.019989, 0.066235, 0.546, -0.0072638, 0.041585, -0.23804, 0.27991, 0.48426, -0.47055, 1.0242, 0.17583, 0.069614, -0.32312, 0.2689, -0.27916, 0.1102, -0.056736, 0.18193, -0.81349, -0.059948, -1.643, -0.13493,
        -0.039751, 2.5918, -0.17389, 0.14976, -2.2992, -0.023525, 0.026148, -0.47318, 0.12105, -0.35075, -2.5109, 0.01574, -0.015389, -0.10265, -0.17618, -0.11846, 1.7464, 1.7273, 1.8318, 0.28774, 0.13687, 0.21731, -0.36876, 0.13578, 0.26281, -0.95189, 0.28444, -1.9184, -0.3865, 0.34045, 0.09972, 0.6235, 0.89472, 0.76667, -0.10746, 0.096744, 0.57915, -0.38004, 2.0134, 0.28327
    };

    // 16x20
    double[] capa3 = {
        0.64009, -0.3621, 0.28075, -0.25234, -0.43359, -0.48729, -0.031632, 0.13667, 0.20874, 0.055708, -0.7732, 0.27891, 0.86323, -0.51327, 0.10875, 0.21501, -0.50398, 0.37041, 0.051395, 0.13419,
        0.030527, -0.37523, -0.0001396, 0.41231, 0.51603, 0.58112, 0.55595, -0.24918, -0.015714, 0.061785, 0.80283, 0.54686, -0.57325, 0.73654, -0.23383, 0.98326, 0.17382, -0.21987, 0.26904, 0.44896,
        -0.0040342, 2.2674, 6.6552, -4.6444, 0.16735, -0.59628, -0.16719, -3.3878, 0.93323, -0.010264, -0.39601, 0.7415, 0.0042409, -5.3039, -0.75463, 0.15947, -0.55192, 4.2568, 1.0895, 0.29504,
        -0.33094, -3.8717, -0.50082, 3.0182, 0.30942, 0.64282, 0.43288, -0.414, -0.78768, 0.41039, -0.15307, 1.0737, -0.26075, 0.46872, 2.4436, -5.2488, 0.13597, 0.70782, -4.9187, 0.34074,
        -0.22812, 2.0459, 0.87329, -0.41689, 0.46571, -0.086947, -0.42991, 1.6998, -0.10119, 0.11086, -0.53621, -0.85705, -0.034567, 1.0153, 0.26649, -0.45804, 1.6524, 0.65733, -2.4426, 0.2738,
        -0.50794, 0.56162, 1.2462, -4.7573, 0.025878, -1.77, -0.071147, 0.3957, 0.084912, -3.6166, -0.40677, 1.7374, -0.030839, 0.19669, -16.024, -0.26735, -0.070725, -0.18292, 5.3297, 0.44511,
        -0.22355, -0.68833, -0.46552, 0.56186, -0.37183, 0.41588, 0.424, 0.097657, 0.001062, -0.19723, -0.45019, 0.32448, -0.49242, -0.00097003, -0.069511, 0.81343, 0.28853, 0.52653, -0.00026453, 0.45827,
        -0.24473, -4.9792, 0.42021, -0.32736, 0.19087, 0.1675, 0.71076, 0.1223, -22.054, -0.34896, 0.59622, 0.23156, 0.13828, 0.32415, 0.53037, -0.27712, -0.31756, 1.0631, -0.18158, -0.39703,
        -0.16107, -1.297, -1.1928, 0.13229, 0.46499, 0.013067, 0.2407, 0.81362, 2.4266, 0.55501, 0.36885, -0.53084, -0.18011, -0.017236, -0.18351, 0.58612, 0.46735, 0.32815, -1.0117, 0.46734,
        0.3558, 33.824, -2.2832, 0.27576, 0.38441, 7.3551, -0.92276, 0.14463, 1.0704, 2.1533, 0.57975, -0.024135, 0.55049, 0.0076347, -0.79097, -0.68049, -0.17376, -1.7077, -0.78327, -0.45488,
        0.1424, 1.0636, 0.15629, 4.4776, 0.39037, 2.3768, 0.29094, -0.24404, -0.31561, -0.8865, -0.75406, 0.90565, -0.84823, -1.1979, 1.0339, -0.26544, -0.46533, -0.78505, -1.1012, 0.2729,
        -0.10845, -2.2164, 0.3463, 2.3245, 0.37703, -0.36784, 1.0514, 0.1544, -2.2194, -0.8491, 0.11797, 0.39438, -0.62954, 0.016755, 1.6363, 0.82556, 0.75742, 2.373, -0.12555, -0.42922,
        0.40304, -1.457, -0.51417, 0.42085, 0.067867, 0.57326, -0.08883, -0.040183, 0.12251, 1.4015, -0.26738, 0.37664, 0.49545, -0.49332, -2.3537, -0.18698, 0.0019899, -3.1425, -0.70484, -0.33485,
        -0.55736, -0.0060251, 0.53903, -0.014982, 0.28046, 0.54779, 0.49642, -0.29047, 0.093927, 0.47334, -0.65845, 0.17367, -0.4456, -0.39786, -0.13445, -0.084938, -0.28811, -0.61504, -0.66947, -0.18208,
        1.4988, 2.4116, 1.6894, -1.6411, 0.14756, 0.056349, 0.12749, -2.0661, 0.1797, 0.34026, 0.68871, 1.2382, -0.31041, -0.22049, -0.48671, 0.41928, -1.5808, 0.092518, 0.95385, -1.5927,
        -0.3434, -2.8397, -0.47912, -0.35304, 0.52568, 0.67158, 0.031049, -0.017699, 0.027524, -0.69058, 0.11852, 1.3399, -0.43543, 0.32851, 0.394, -5.2192, -0.67078, 0.59411, -1.148, 0.016351
    };

    // 1x16
    double[] capa4 = {
        0.89306, -0.75661, -0.73653, 0.41188, 0.48568, -0.451, 0.67504, 0.82279, -0.24397, -0.42026, 0.60218, -0.56288, -0.63194, -1.2537, 0.41639, -1.172
    };

    double[] bias1 = {
        -2.6257,
        -0.030477,
        -2.5298,
        -2.4379,
        -0.086481,
        0.57136,
        3.1983,
        -3.0839,
        -4.8865,
        -3.9068,
        -1.3911,
        2.3994,
        3.5849,
        -2.1043,
        -0.89955,
        -2.7106,
        -0.81117,
        -0.35291,
        2.4044,
        4.8346,
        1.1608,
        2.713,
        -1.7653,
        3.1126,
        -3.0684,
        -1.6676,
        -2.4577,
        -0.54092,
        -0.81373,
        2.1893,
        1.9444,
        3.3832,
        2.1681,
        2.492,
        -3.425,
        2.6101,
        3.3531,
        -5.3378,
        1.5744,
        6.1881
    };

    double[] bias2 = {
        1.5376,
        -1.3517,
        1.1031,
        0.98285,
        -0.28048,
        0.82354,
        -0.53296,
        -0.42889,
        0.1818,
        -0.035135,
        0.21554,
        0.036622,
        -0.61977,
        -0.52983,
        -0.59986,
        -0.92638,
        0.72999,
        -1.0842,
        -1.4005,
        -1.4259
    };

    double[] bias3 = {
        -1.5999,
        -1.4033,
        1.2257,
        0.97338,
        0.81017,
        0.54771,
        0.33021,
        0.11212,
        -0.10456,
        0.27547,
        0.55216,
        0.75282,
        1.0044,
        -1.2267,
        1.2244,
        -1.6153
    };

    double bias4 = 0.46616;

    double test;


    for (int n = 1; n <= 1; n++) {

      for (int j = 1; j <= 8; j++) {
        for (int k = 1; k <= 2; k++) {
          try {
            test = Double.parseDouble(datos.getString("P" + String.valueOf(n) + "E" + String.valueOf(k) + "C" + String.valueOf(j)));
          } catch (Exception e) {
            datos.putString("P" + String.valueOf(n) + "E" + String.valueOf(k) + "C" + String.valueOf(j), "0");
          }
        }
      }

      // Input test

      double[] input = {
          Double.parseDouble(datos.getString("P" + String.valueOf(n) + "E1C1")),
          Double.parseDouble(datos.getString("P" + String.valueOf(n) + "E1C2")),
          Double.parseDouble(datos.getString("P" + String.valueOf(n) + "E1C3")),
          Double.parseDouble(datos.getString("P" + String.valueOf(n) + "E1C4")),
          Double.parseDouble(datos.getString("P" + String.valueOf(n) + "E1C5")),
          Double.parseDouble(datos.getString("P" + String.valueOf(n) + "E1C6")),
          Double.parseDouble(datos.getString("P" + String.valueOf(n) + "E1C7")),
          Double.parseDouble(datos.getString("P" + String.valueOf(n) + "E1C8")),
          Double.parseDouble(datos.getString("P" + String.valueOf(n) + "E2C1")),
          Double.parseDouble(datos.getString("P" + String.valueOf(n) + "E2C2")),
          Double.parseDouble(datos.getString("P" + String.valueOf(n) + "E2C3")),
          Double.parseDouble(datos.getString("P" + String.valueOf(n) + "E2C4")),
          Double.parseDouble(datos.getString("P" + String.valueOf(n) + "E2C5")),
          Double.parseDouble(datos.getString("P" + String.valueOf(n) + "E2C6")),
          Double.parseDouble(datos.getString("P" + String.valueOf(n) + "E2C7")),
          Double.parseDouble(datos.getString("P" + String.valueOf(n) + "E2C8")),
      };

      double[] inputLayerOutput = new double[20];
      for (int i = 0; i < 20; i++) {
        inputLayerOutput[i] = biasInput[i];
        for (int j = 0; j < 16; j++)
          inputLayerOutput[i] += capaInicial[(16 * i) + j] * input[j];
        inputLayerOutput[i] = tansig(inputLayerOutput[i]);
      }

      double[] hiddenLayerOutput = new double[19];
      for (int i = 0; i < 19; i++) {
        hiddenLayerOutput[i] = biasDos[i];
        for (int j = 0; j < 20; j++)
          hiddenLayerOutput[i] += capaDos[(20 * i) + j] * inputLayerOutput[j];
        hiddenLayerOutput[i] = tansig(hiddenLayerOutput[i]);
      }

      double output = biasTres;
      for (int i = 0; i < 19; i++)
        output += capaTres[i] * hiddenLayerOutput[i];


      double[] inputLayerOutput12 = new double[40];
      for (int i = 0; i < 40; i++) {
        inputLayerOutput12[i] = bias1[i];
        for (int j = 0; j < 16; j++)
          inputLayerOutput12[i] += capa1[(16 * i) + j] * input[j];
        inputLayerOutput12[i] = tansig(inputLayerOutput12[i]);
      }

      double[] hiddenLayerOutput12 = new double[20];
      for (int i = 0; i < 20; i++) {
        hiddenLayerOutput12[i] = bias2[i];
        for (int j = 0; j < 40; j++)
          hiddenLayerOutput12[i] += capa2[(40 * i) + j] * inputLayerOutput12[j];
        hiddenLayerOutput12[i] = tansig(hiddenLayerOutput12[i]);
      }

      double[] hiddenLayer2Output12 = new double[16];
      for (int i = 0; i < 16; i++) {
        hiddenLayer2Output12[i] = bias3[i];
        for (int j = 0; j < 20; j++)
          hiddenLayer2Output12[i] += capa3[(20 * i) + j] * hiddenLayerOutput12[j];
        hiddenLayer2Output12[i] = tansig(hiddenLayer2Output12[i]);
      }

      double output12 = bias4;
      for (int i = 0; i < 16; i++)
        output12 += capa4[i] * hiddenLayer2Output12[i];

      // Mostrar Resultados

      Double progress = output - 0.1;
      progress *= 100;
	  
	  int prediccionPrincipal = 0;
	  int prediccionSecundaria = 0;
	  int prediccionAuxiliar = 0;

      if (progress >= 0) {
		if (progress > 28) {
          progress = progress*2;
		}
        if (progress < 23) {
          progress = progress/2;
		}
        barraIzquierda.setProgress((int) Math.round(progress));
        barraDerecha.setProgress(0);
      } else {
        if (-progress > 10)
          progress = progress*4;
        barraDerecha.setProgress((int) Math.round(-progress));
        barraIzquierda.setProgress(0);
      }

      Double outputFinal = -output12;
      progress = outputFinal;
      progress *= 100;

      if (progress >= 0) {
        barraIzquierda2.setProgress((int) Math.round(progress));
        barraDerecha2.setProgress(0);
      } else {
        barraDerecha2.setProgress((int) Math.round(-progress));
        barraIzquierda2.setProgress(0);
      }

      String decisionFija = "";

      if (output > 0.26) {
        decisionFija = "1";
		prediccionPrincipal = 1;
      } else {
        if (output < 0.1) {
          decisionFija = "2";
		  prediccionPrincipal = -1;
        } else {
          decisionFija = "X";
		  prediccionPrincipal = 0;
        }
      }
	  
      int valor1 = 0, valor2 = 0, valorX = 0;

      Double outputTest = Math.abs(outputFinal);

	  if (outputTest > 0.8) {
		  prediccionSecundaria = 1;
	  }
	  else if (outputTest < -1) {
		  prediccionSecundaria = -1;
	  } else {
		  prediccionSecundaria = 0;
	  }
	  

      if (outputFinal < 0) {
        int temp = valor1;
        valor1 = valor2;
        valor2 = temp;
      }

      double e1 = (input[2] / input[1] + input[12] / input[9])/2;
      e1 *=100;
      double eX = (input[3] / input[1] + input[11] / input[9])/2;
      eX*=100;
      double e2 = (input[4] / input[1] + input[10] / input[9])/2;
      e2*=100;
      
	  if (e1 > e2 && e1 > eX) {
		  prediccionAuxiliar = 1;
	  } else if (e2 > e1 && e2 > eX) {
		  prediccionAuxiliar = -1;
	  } else {
		  prediccionAuxiliar = 0;
	  }
	  
	  int resultadoProbable = 0;
	  int resultadoPosible = 0;
	  
	  if (prediccionPrincipal == prediccionSecundaria && prediccionSecundaria == prediccionAuxiliar) {
		  resultadoProbable = prediccionPrincipal;
		  resultadoPosible = prediccionPrincipal;
	  } else if ( prediccionPrincipal == prediccionSecundaria && prediccionPrincipal != prediccionAuxiliar ) {
		  resultadoProbable = prediccionPrincipal;
		  resultadoPosible = prediccionAuxiliar;
	  } else if ( prediccionPrincipal != prediccionSecundaria && prediccionPrincipal == prediccionAuxiliar) {
		  resultadoProbable = prediccionPrincipal;
		  resultadoPosible = prediccionSecundaria;
	  } else if ( prediccionPrincipal != prediccionSecundaria && prediccionSecundaria == prediccionAuxiliar) {
		  resultadoProbable = prediccionSecundaria;
		  resultadoPosible = prediccionPrincipal;
	  } else {
		  resultadoProbable = prediccionPrincipal;
		  resultadoPosible = prediccionSecundaria;
	  }

    }


    Button volver = (Button) findViewById(R.id.button3);

    volver.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (flag > 5) {
          if (interstitialAd.isLoaded()) {
            interstitialAd.show();
          } else {
            Intent intent = new Intent(PantallaResultadoPartido.this, PantallaInicial.class);
            startActivity(intent);
          }
        }
        else{
          Intent intent = new Intent(PantallaResultadoPartido.this, PantallaInicial.class);
          startActivity(intent);
        }
      }
    });

  }


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_pantalla_resultados, menu);
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

  public double tansig(double n) {
    return Math.tanh(n);
  }

}
