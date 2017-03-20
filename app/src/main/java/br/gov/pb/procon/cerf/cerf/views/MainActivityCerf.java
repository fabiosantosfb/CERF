package br.gov.pb.procon.cerf.cerf.views;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import br.gov.pb.procon.cerf.cerf.R;
import br.gov.pb.procon.cerf.cerf.controller.AutoSearchComplete;
import br.gov.pb.procon.cerf.cerf.model.Empresa;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.Optional;

public class MainActivityCerf extends AppCompatActivity {
    @Optional
    @InjectView(R.id.autoCompleteTextView)
    protected AutoCompleteTextView search;
    @Optional
    @InjectView(R.id.textViewLinkProcon)
    protected TextView link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_search);

        ButterKnife.inject(this);

        new Empresa(null, null, null, null, null);
        new AutoSearchComplete(getBaseContext(), search);
    }

    public void onClickList(View v) {
        Intent intent = new Intent(MainActivityCerf.this, ListarEmpresaActivity.class);
        startActivity(intent);
    }

    public void onClickSearch(View v) {
        if(!this.search.getText().toString().trim().isEmpty()){

            Intent intent = new Intent(MainActivityCerf.this, ListarEmpresaActivity.class);
            intent.putExtra("empresa",this.search.getText().toString());
            startActivity(intent);
        } else {
            Toast.makeText(this, "Digite Nome da Empresa!",Toast.LENGTH_LONG).show();
        }
    }

    public void onClickUrl(View v){
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://procon.pb.gov.br"));
        startActivity(myIntent);
    }

}
