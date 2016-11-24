package com.example.a5alumno.lab7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements ActionMode.Callback{


    /*
     *   La aplicación a implementar incluye dos elementos Activity con layouts muy simples, aunque diferentes. En
     *   el primer caso la App Bar incluye la tradicional Action Bar, mientras que en el segundo alberga la novedosa
     *   Toolbar, más flexible y robusta.
     *   Además, en lo referente a menús contextuales, el primer layout incluye un clásico menú contextual flotante,
     *   mientras que el segundo implementa lo que se conoce como Contextual Action Mode, y que convive con la
     *   Toolbar.
     *   Por último, a una de las opciones del segundo layout se le ha agregado un pop-up menú, mostrando así una
     *   de las clásicas alternativas que hay en Android para presentar información adicional al usuario.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView launchMe = (ImageView) this.findViewById(R.id.launcher);
        this.registerForContextMenu(launchMe);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater mMenuInflater = this.getMenuInflater();
        mMenuInflater.inflate(R.menu.menu_principal, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater mContMenuInflater = this.getMenuInflater();
        mContMenuInflater.inflate(R.menu.menu_principal, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addItem:
                Log.e("Item", "Add Pressed");
                return true;
            //break;
            case R.id.likeItem:
                Log.e("Item", "Like Pressed");
                return true;
            //break;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        switch (item.getItemId()){
            case R.id.addItem:
                Log.e("Item","Add Pressed");
                return true;
                //break;
            case R.id.likeItem:
                Log.e("Item","Like Pressed");
                return true;
                //break;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        MenuInflater mMenuInflater = this.getMenuInflater();
        mMenuInflater.inflate(R.menu.menu_principal, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        return false;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {

    }
}
