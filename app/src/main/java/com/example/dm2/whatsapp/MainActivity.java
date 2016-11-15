package com.example.dm2.whatsapp;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {

    Menu menu;
    TabHost tabs;
    MenuItem item;
    ListView ListLlamadas,ListChats,ListContactos;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        item=(MenuItem)findViewById(R.id.action_otro);
        setSupportActionBar(toolbar);
        Resources res = getResources();
        tabs = (TabHost) findViewById(android.R.id.tabhost);
        tabs.setup();

        TabHost.TabSpec spec = tabs.newTabSpec("llamadas");
        spec.setContent(R.id.llamadas);
        spec.setIndicator("LLAMADAS");
        tabs.addTab(spec);

        spec = tabs.newTabSpec("chats");
        spec.setContent(R.id.chats);
        spec.setIndicator("CHATS");
        tabs.addTab(spec);

        spec = tabs.newTabSpec("Contactos");
        spec.setContent(R.id.Contactos);
        spec.setIndicator("CONTACTOS");
        tabs.addTab(spec);

        tabs.setOnTabChangedListener(new TabHost.OnTabChangeListener(){
            public void onTabChanged(String s){
                if(s.equals("llamadas")){
                    item = menu.findItem(R.id.action_otro);
                    item.setIcon(R.drawable.ic_llamadas);
                }
                if(s.equals("chats")){
                    item = menu.findItem(R.id.action_otro);
                    item.setIcon(R.drawable.ic_chats);
                }
                if(s.equals("Contactos")){
                    item = menu.findItem(R.id.action_otro);
                    item.setIcon(R.drawable.ic_contactos);
                }
            }
        }
        );

        final String[] datosLlamadas=new String[]{"Llamada 1","Llamada 2","Llamada 3","Llamada 4","Llamada 5"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datosLlamadas );
        ListLlamadas=(ListView) findViewById(R.id.ListLlamadas);
        ListLlamadas.setAdapter(adapter);

        final String[] datosChats=new String[]{"Chast 1","Chast 2","Chast 3","Chast 4","Chast 5"};
        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datosChats );
        ListChats=(ListView) findViewById(R.id.ListChats);
        ListChats.setAdapter(adapter1);

        final String[] datosContactos=new String[]{"Contacto 1","Contacto 2","Contacto 3","Contacto 4","Contacto 5"};
        ArrayAdapter<String> adapter2=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datosContactos);
        ListContactos=(ListView) findViewById(R.id.ListContactos);
        ListContactos.setAdapter(adapter2);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        this.menu=menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
