package jarroba.ramon.listado;

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

        
        ArrayList<Lista_entrada> datos = new ArrayList<Lista_entrada>();  
        
        datos.add(new Lista_entrada(R.drawable.im_farigola, "FARIGOLA", "També anomenada timó, timonet o tomell (del llatí Thymus)."));
        datos.add(new Lista_entrada(R.drawable.im_menta, "MENTA", "Fa olor que t'hi cagues. I aixo es un text per a veure que passa quan afegim mes linies a la descripcio, perque clar, la idea es posar aqui una parrafada del copon, i com que no hi cabra, la gent hi clicara a sobre per poder veure la resta de text. Pero com molt be va fer notar el Joan, els pocs segons que el popup es visible potser no son suficientes per arribar a llegir-ho tot, i per tant hem de pensar una altra manguera de fer-ho, o afegir segons al tema... no se"));
        datos.add(new Lista_entrada(R.drawable.im_ginesta, "GINESTA", "Té un port al costat de Castelldefels."));
        datos.add(new Lista_entrada(R.drawable.im_fonoll, "FONOLL", "Ma avia sempre en tenia per casa."));
        datos.add(new Lista_entrada(R.drawable.im_card, "CARD", "Guapo guapo."));
        datos.add(new Lista_entrada(R.drawable.im_flordeneu, "FLOR DE NEU", "Quan les plantes fan bukkakes."));
        datos.add(new Lista_entrada(R.drawable.im_espa, "ESPARRAGUERA", "Poble quillo."));

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

