package br.gov.pb.procon.cerf.cerf.base;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import br.gov.pb.procon.cerf.cerf.R;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.Optional;

/**
 * Created by Fabio on 31/07/2016.
 */
public class ToolbarActivity extends AppCompatActivity {

    @Optional
    @InjectView(R.id.toolbar)
    protected Toolbar toolbar;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);

        ButterKnife.inject(this);
        setSupportActionBar(toolbar);

        Log.d("TOOLBAR","Entrou!");

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_activity_cerf, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_search) {
            Log.d("TOOLBAR","Icon favorito search!");
            return true;
        }
        if (id == R.id.action_settings) {
            Log.d("TOOLBAR","Icon configurcao!");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
