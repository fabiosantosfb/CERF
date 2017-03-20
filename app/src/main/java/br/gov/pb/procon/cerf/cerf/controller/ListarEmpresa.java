package br.gov.pb.procon.cerf.cerf.controller;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import br.gov.pb.procon.cerf.cerf.R;
import br.gov.pb.procon.cerf.cerf.model.Empresa;

/**
 * Created by fabiano on 18/03/17.
 */

public class ListarEmpresa {
    private static ListarEmpresa instanceListarEmpresa;
    private Context context;
    private static String[] RANKING = new String[0];
    private static String[] RAZAO = new String[0];
    private static String[] NOME = new String[0];
    private static String[] ATENDIDA = new String[0];
    private static String[] NAOATENDIDA = new String[0];
    private static String[] TOTAL = new String[0];

    public static synchronized ListarEmpresa getInstanceListarEmpresa(Context context){
        if(instanceListarEmpresa == null)
            instanceListarEmpresa =  new ListarEmpresa(context);
        return instanceListarEmpresa;
    }

    public ListarEmpresa(Context context) {
        this.context = context;
        this.RANKING = this.context.getResources().getStringArray(R.array.Ranking);
        this.RAZAO = this.context.getResources().getStringArray(R.array.Razao_Social);
        this.NOME = this.context.getResources().getStringArray(R.array.Empresas);
        this.ATENDIDA = this.context.getResources().getStringArray(R.array.Atendidas);
        this.NAOATENDIDA = this.context.getResources().getStringArray(R.array.NaoAtendidas);
        this.TOTAL = this.context.getResources().getStringArray(R.array.Totais);
    }
    
    public List<Empresa> getListarEmpresa(){
        List<Empresa> empresasList = new ArrayList<Empresa>();
        int indice = 0;

        while (indice < this.RAZAO.length){
            Empresa empresa = new Empresa();
            empresa.setNome(this.NOME[indice]);
            empresa.setRanker(this.RANKING[indice]);
            empresa.setAtendido(this.ATENDIDA[indice]);
            empresa.setNaoAtendido(this.NAOATENDIDA[indice]);
            empresa.setTotal(this.TOTAL[indice]);
            empresasList.add(empresa);
            indice++;
        }
        return empresasList;
    }

    public List<Empresa> searchEmpresa(String nome) {
        List<Empresa> empresasList = new ArrayList<Empresa>();
        int indice = getIndexArraySearch(nome);

        if (indice >= 0) {
            Empresa empresa = new Empresa();
            empresa.setNome(this.NOME[indice]);
            empresa.setRanker(this.RANKING[indice]);
            empresa.setAtendido(this.ATENDIDA[indice]);
            empresa.setNaoAtendido(this.NAOATENDIDA[indice]);
            empresa.setTotal(this.TOTAL[indice]);

            empresasList.add(empresa);
            return empresasList;
        }
        return null;
    }

    private int getIndexArraySearch(String nome){
        int i = 0;
        while (i < this.RAZAO.length){
            if (this.RAZAO[i].equals(nome) || this.NOME[i].equals(nome))
                return i;
            i++;
        }
        return -1;
    }

}
