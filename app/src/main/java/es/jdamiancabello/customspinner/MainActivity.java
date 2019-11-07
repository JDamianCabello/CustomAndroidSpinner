package es.jdamiancabello.customspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import es.jdamiancabello.customspinner.adapter.SocialAdapter;
import es.jdamiancabello.customspinner.model.Social;

public class MainActivity extends AppCompatActivity {

    private Spinner spSocial;
    private SocialAdapter socialAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1 Bindeamos el spinner
        spSocial = findViewById(R.id.spinner2);

        //2 Vinculamos el adapter a la vista
        socialAdapter = new SocialAdapter(this,getListSocial());
        socialAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSocial.setAdapter(socialAdapter);

        //3 Personalizar la vista drop del adapter

    }

    private List<Social> getListSocial() {
        List<Social> list = new ArrayList<>();
        list.add(new Social(R.drawable.facebook,"Facebook"));
        list.add(new Social(R.drawable.github,"Github"));
        list.add(new Social(R.drawable.telegram,"Telegram"));
        list.add(new Social(R.drawable.youtube,"YouTube"));

        return list;
    }
}
