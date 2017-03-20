package br.gov.pb.procon.cerf.cerf.views;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import br.gov.pb.procon.cerf.cerf.R;
import br.gov.pb.procon.cerf.cerf.base.ToolbarActivity;
import br.gov.pb.procon.cerf.cerf.controller.AdapterListEmpresa;
import br.gov.pb.procon.cerf.cerf.controller.ListarEmpresa;
import br.gov.pb.procon.cerf.cerf.model.Empresa;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.Optional;

/**
 * Created by fabiano on 17/03/17.
 */

public class ListarEmpresaActivity extends ToolbarActivity {
    @Optional
    @InjectView(R.id.textViewMessage)
    protected TextView message;
    @Optional
    @InjectView(R.id.listView)
    protected ListView listView;
    @Optional
    @InjectView(R.id.autoCompleteTextView)
    protected AutoCompleteTextView search;

    private String nome = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagens);
        ButterKnife.inject(this);

        this.nome = getIntent().getStringExtra("empresa");

        if(this.nome != null) {
            exibirEmpresas(this.nome);
        } else if(this.nome == null) {

            listagensDeEmpresas();
        }
    }

    private void exibirEmpresas(String nome) {
        List<Empresa> empresa = ListarEmpresa.getInstanceListarEmpresa(getBaseContext()).searchEmpresa(nome);
        if(empresa != null) {
            ArrayAdapter<Empresa> adaptador = new AdapterListEmpresa(ListarEmpresaActivity.this, empresa);
            listView.setAdapter(adaptador);
        } else {
            message.setVisibility(TextView.VISIBLE);
        }
    }

    private void listagensDeEmpresas() {
        List<Empresa> empresa = ListarEmpresa.getInstanceListarEmpresa(getBaseContext()).getListarEmpresa();
        ArrayAdapter<Empresa> adaptador = new AdapterListEmpresa(ListarEmpresaActivity.this, empresa);
        listView.setAdapter(adaptador);
    }
}
