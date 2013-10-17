package jarroba.larutlla.listado;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.LinearLayout;
import com.google.ads.*;



/** Listado.
 * @author Ramon Invarato Menndez
 * www.jarroba.es
 */
public class MainActivity extends Activity {
	
	private ListView lista; 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listado);

        AdView adView = new AdView(this, AdSize.SMART_BANNER, "ca-app-pub-9494751952909106/6013922277");
        LinearLayout layout = (LinearLayout)findViewById(R.id.anuncio);
        layout.addView(adView);
        adView.loadAd(new AdRequest());
        
        ArrayList<Lista_entrada> datos = new ArrayList<Lista_entrada>();  
        
        datos.add(new Lista_entrada(R.drawable.im_borraja, "BORRAJA, BORRATXA", "Planta depurativa que es fa servir per alleugerir simptomes del refredat com ara la tos."));
        datos.add(new Lista_entrada(R.drawable.im_dent, "DENT DE LLEÓ", "La infusió de les flors, així com la melmelada d'aquestes, és usada per al mal de gola, menjada directament o ensucrant una infusió o llet calenta, igual que la mel."));
        datos.add(new Lista_entrada(R.drawable.im_espigol, "ESPÍGOL, LAVANDA", "Elimina la sensació de nervis i ansietat. També es fa servir per mals de cap i té propietats cicatritzants."));
        datos.add(new Lista_entrada(R.drawable.im_farigola, "FARIGOLA, FRIGOLA", "Les seves propiestats principals serien ajudar al tractament de dolors musculars i estimulant digestiu. Es fa servir en malaties com ara fibromialgia i anorexia."));
        datos.add(new Lista_entrada(R.drawable.im_fonoll, "FONOLL", "Afavoreix l'eliminació de líquids corporals, sent molt recomenda en casos d'obesitat o malalties reumàtiques. Dues gotes d'essència dissoltes en sucre tenen propietats expectorants i antitusives"));
        datos.add(new Lista_entrada(R.drawable.im_malva, "MALVA", "Recomanada per problemes de carraspera o afonia a la veu. També es fa servir per curar ferides a la pell i llagues."));
        datos.add(new Lista_entrada(R.drawable.im_menta, "MENTA", "Es recomana per problemes digestius i com a remei per a la flatulencia. L'oli esencial pot provocar, en persones sensibles, insomni i nerviosisme."));
        datos.add(new Lista_entrada(R.drawable.im_romani, "ROMANÍ", "Les fulles es fan servir per tractar afeccions del fetge i dolors musculars entre d'altres. També se li atribueixen propietats en la millora del cabell."));
        datos.add(new Lista_entrada(R.drawable.im_rosella, "ROSELLA", "Les llavors d'aquesta planta redueixen el temps d'inducció a la son. Planta sedant i rica en àcids grassos el que aporta un gran valor nutricional."));
        datos.add(new Lista_entrada(R.drawable.im_salvia, "SÀLVIA", "Se li atribueixen propietats de millora de la memoria.Afavoreix la producció de testosterona el que la fa aliada de la fertilitat. A l'antiguetat es feia servir com afrodisíac."));
        datos.add(new Lista_entrada(R.drawable.im_tarongina, "TARONGINA, MELISSA", "Recomenda per tractar problemes de nervis, estrés o insomni. És un relaxant natural."));


        lista = (ListView) findViewById(R.id.ListView_listado);
        lista.setAdapter(new Lista_adaptador(this, R.layout.entrada, datos){
			@Override
			public void onEntrada(Object entrada, View view) {
		        if (entrada != null) {
		            TextView texto_superior_entrada = (TextView) view.findViewById(R.id.textView_superior); 
		            if (texto_superior_entrada != null) 
		            	texto_superior_entrada.setText(((Lista_entrada) entrada).get_textoEncima()); 
		              
		            TextView texto_inferior_entrada = (TextView) view.findViewById(R.id.textView_inferior); 
		            if (texto_inferior_entrada != null)
		            	texto_inferior_entrada.setText(((Lista_entrada) entrada).get_textoDebajo()); 
		              
		            ImageView imagen_entrada = (ImageView) view.findViewById(R.id.imageView_imagen); 
		            if (imagen_entrada != null)
		            	imagen_entrada.setImageResource(((Lista_entrada) entrada).get_idImagen());
		        }
			}
		});
        
        lista.setOnItemClickListener(new OnItemClickListener() { 
			@Override
			public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
				Lista_entrada elegido = (Lista_entrada) pariente.getItemAtPosition(posicion); 
                
                CharSequence texto = elegido.get_textoDebajo();
                Toast toast = Toast.makeText(MainActivity.this, texto, Toast.LENGTH_LONG);
                toast.show();
			}
        });
        
        
        
    }
    
}

