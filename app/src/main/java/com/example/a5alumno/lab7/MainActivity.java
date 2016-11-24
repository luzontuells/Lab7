package com.example.a5alumno.lab7;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements ActionMode.Callback, View.OnLongClickListener{


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

    ActionMode mActionMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView launchMe = (ImageView) this.findViewById(R.id.launcher);
//        this.registerForContextMenu(launchMe);
        launchMe.setOnLongClickListener(this);

        Toolbar mChildToolbar = (Toolbar) this.findViewById(R.id.my_toolbar_second);
        this.setSupportActionBar(mChildToolbar);
        // Enable the Up button (A Back button, actually)
        // Make sure the corresponding import relates to the suppport v7 library
//        ActionBar mActionBar = this.getSupportActionBar();
//        mActionBar.setDisplayHomeAsUpEnabled(true);   // This line actually enables the UP button
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

//        if(item.getItemId()==R.id.button_second){
//            PopupMenu mPopMenu = new PopupMenu(this, this.findViewById(R.id.addItem));
//            MenuInflater mMenuInflater = mPopMenu.getMenuInflater();
//            mMenuInflater.inflate(R.menu.popup_menu, mPopMenu.getMenu());
//            // The pop-up menu is configured to be clickable and later is shown
//            mPopMenu.setOnMenuItemClickListener(this);
//            mPopMenu.show();
//        }
        return false;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {

    }


    @Override
    public boolean onLongClick(View view) {
        if (view.getId() == R.id.button_second)
        {
            // if ActionMode is null "not started"
            if (mActionMode != null) { return false; }
            // Start the CAB
            this.mActionMode = this.startActionMode(this);
            view.setSelected(true);
            return true;
        }
        else
            return false;
    }
}
