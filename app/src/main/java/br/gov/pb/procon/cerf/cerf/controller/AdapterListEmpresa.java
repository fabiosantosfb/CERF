package br.gov.pb.procon.cerf.cerf.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import br.gov.pb.procon.cerf.cerf.R;
import br.gov.pb.procon.cerf.cerf.model.Empresa;

/**
 * Created by Fabio on 29/07/2016.
 */
public class AdapterListEmpresa extends ArrayAdapter<Empresa> {

    private List<Empresa> listEmpresa;
    private Context context;

    public AdapterListEmpresa(Context context, List<Empresa> list) {
        super(context, R.layout.content_list_empresas, list);
        this.listEmpresa = list;
        this.context = context;
    }

    @Override
    public View getView (int position, View convertView, ViewGroup pai) {
        View view = null;

        if (convertView == null) {
            LayoutInflater inflator;
            inflator = LayoutInflater.from(context);
            view = inflator.inflate(R.layout.content_list_empresas, null);
            ViewHolder viewHolder = new ViewHolder ();

            viewHolder.txtViewNome = (TextView) view.findViewById (R.id.textViewNomeEmpresa);
            viewHolder.txtViewAtend = (TextView) view.findViewById (R.id.textViewAtendida);
            viewHolder.txtViewNaTend = (TextView) view.findViewById (R.id.textViewNaoAtendida);
            viewHolder.txtViewTotalAtend = (TextView) view.findViewById (R.id.textViewTotal);
            viewHolder.txtViewRanker = (TextView) view.findViewById (R.id.textViewRancking);
            view.setTag (viewHolder);

        } else {
            view = convertView;
        }
        ViewHolder holder = (ViewHolder) view.getTag ();
        holder.txtViewNome.setText (listEmpresa.get(position).getNome());
        holder.txtViewAtend.setText (listEmpresa.get(position).getAtendido());
        holder.txtViewNaTend.setText (listEmpresa.get(position).getNaoAtendido());
        holder.txtViewTotalAtend.setText (listEmpresa.get(position).getTotal());
        holder.txtViewRanker.setText (listEmpresa.get(position).getRanker());

        return view;
    }

    static class ViewHolder {
        TextView txtViewNome;
        TextView txtViewAtend;
        TextView txtViewNaTend;
        TextView txtViewTotalAtend;
        TextView txtViewRanker;
    }
}