package com.example.a5alumno.lab7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ImageView launchMe = (ImageView) this.findViewById(R.id.button_second);
        this.registerForContextMenu(launchMe);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu){
//        MenuInflater mMenuInflater = this.getMenuInflater();
//        mMenuInflater.inflate(R.menu.menu_secundario, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item)
//    {
//
//        switch (item.getItemId()){
//            case R.id.addItem:
//                Log.e("Item","Add Pressed, Second Activity");
//                return true;
//            //break;
//            case R.id.likeItem:
//                Log.e("Item","Like Pressed, Second Activity");
//                return true;
//            //break;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }

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
                Log.e("Item", "Start Pressed, First Activity");
                Intent intent = new Intent(this, SecondActivity.class);
                startActivity(intent);
                return true;
            //break;
            case R.id.likeItem:
                Log.e("Item", "Like Pressed, First Activity");
                return true;
            //break;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

//    public void showPopup(View view){
//        PopupMenu mPopMenu = new PopupMenu(this, this.findViewById(R.id.addItem));
//        MenuInflater mMenuInflater = mPopMenu.getMenuInflater();
//        mMenuInflater.inflate(R.menu.popup_menu, mPopMenu.getMenu());
//// The pop-up menu is configured to be clickable and later is shown
//        mPopMenu.setOnMenuItemClickListener(this);
//        mPopMenu.show();
//    }


}
