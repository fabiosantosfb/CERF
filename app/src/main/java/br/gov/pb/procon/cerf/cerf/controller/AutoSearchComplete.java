package br.gov.pb.procon.cerf.cerf.controller;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import br.gov.pb.procon.cerf.cerf.R;

/**
 * Created by fabiano on 19/03/17.
 */

public class AutoSearchComplete {

    public AutoSearchComplete(Context context, AutoCompleteTextView search){
        final String[] razao_social = context.getResources().getStringArray(R.array.Razao_Social);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_dropdown_item_1line, razao_social);
        search.setAdapter(adapter);
    }
}
