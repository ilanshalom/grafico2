package com.example.exemplografico2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    private MinhaView mView;
    private EditText editatipo;
    private Button botao,outrobotao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            mView = (MinhaView) findViewById(R.id.minha_view);
            mView.setFocusable(true); //para que a View receba o foco em modo touch
            editatipo = (EditText) findViewById(R.id.edita_text);
            botao = (Button) findViewById(R.id.teste_botao);
            outrobotao = (Button) findViewById(R.id.outro_graf_botao);
        }
        catch(Exception e){
            Toast.makeText(getApplicationContext(),
                    "\nErro.\n" + e.getMessage() + "\n" , Toast.LENGTH_LONG).show();
        }
        botao.setOnClickListener (new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "\nLegal! Evento click normal atendido...\n", Toast.LENGTH_LONG).show();
            }
        });

        outrobotao.setOnClickListener (new View.OnClickListener() {
            public void onClick(View v) {
                int tipo = 1;
                try {
                    tipo = Integer.parseInt(editatipo.getText().toString());
                } catch(Exception ew1){}
                mView.setTipoPaintv02(tipo);
                mView.invalidate();
            }
        });

    }

}
