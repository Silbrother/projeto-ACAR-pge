package com.acar;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class grafico extends AppCompatActivity {
    float itensGrafico[] = {48.6f, 56.8f, 45.7f, 10.5f, 35.2f, 25.6f,36.78f,8.45f,15.6f,32.4f};
    String descricao[] = {"Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"};
    PieChart grafico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafico);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        /*Grafico implementado!*/
        grafico = (PieChart) findViewById(R.id.graficoID);
        List<PieEntry> entradasGrafico = new ArrayList<>();
        for (int i = 0; i < itensGrafico.length; i++){
            entradasGrafico.add(new PieEntry(itensGrafico[i],descricao[i]));
    }

        PieDataSet dataSet = new PieDataSet(entradasGrafico,  "Legenda do Gráfico");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        PieData pieData = new PieData(dataSet);
        grafico.animateY(1300);
        grafico.setData(pieData);
        grafico.invalidate();
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
