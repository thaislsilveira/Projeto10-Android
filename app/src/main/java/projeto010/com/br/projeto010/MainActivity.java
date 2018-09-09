package projeto010.com.br.projeto010;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    //declarar os atributos da Classe
    EditText edtNumero, edtNome, edtSalFixo, edtTotalVendas, edtPorcentagem ;
    Button btnCalcular, btnLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Atribuir os componentes visuais da activity_main
         * nos atributos da classe
         */

        edtNumero = (EditText) findViewById(R.id.edtNumero);
        edtNome = (EditText) findViewById(R.id.edtNome);
        edtSalFixo = (EditText) findViewById(R.id.edtSalFixo);
        edtTotalVendas = (EditText) findViewById(R.id.edtTotalVendas);
        edtPorcentagem = (EditText) findViewById(R.id.edtPorcentagem);

        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnLimpar = (Button) findViewById(R.id.btnLimpar);


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtNumero.getText().length() <= 0 ||
                        edtNome.getText().length() <= 0 ||
                        edtSalFixo.getText().length() <= 0 ||
                        edtTotalVendas.getText().length() <= 0 ||
                        edtPorcentagem.getText().length() <= 0) {
                    Toast.makeText(getBaseContext(), "Informe TODOS os campos!!!",
                            Toast.LENGTH_SHORT).show();
                    edtNumero.requestFocus();
                } else {

                    Double salfixo = Double.parseDouble(edtSalFixo.getText().toString());
                    Double totalvendas = Double.parseDouble(edtTotalVendas.getText().toString());
                    Double porcentagem = Double.parseDouble(edtPorcentagem.getText().toString());


                    Double salTotal = salfixo + (totalvendas * (porcentagem/100));

                    AlertDialog.Builder alerta = new
                            AlertDialog.Builder(MainActivity.this);

                    alerta.setTitle("SALÁRIO DO VENDEDOR");
                    alerta.setMessage("Número do vendedor : "
                            + edtNumero.getText().toString()
                            + ("\nNome :")
                            + edtNome.getText().toString()
                            + ("\nTem o salário total de : ")
                            + new DecimalFormat("0.00").format(salTotal));
                    alerta.setNeutralButton("Fechar", null);
                    alerta.show();
                }
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtNumero.setText("");
                edtNome.setText("");
                edtSalFixo.setText("");
                edtTotalVendas.setText("");
                edtPorcentagem.setText("");
                edtNumero.requestFocus();
            }
        });
    }
}
