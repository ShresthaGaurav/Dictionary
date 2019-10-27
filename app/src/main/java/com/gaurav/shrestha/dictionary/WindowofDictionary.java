package com.gaurav.shrestha.dictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class WindowofDictionary extends AppCompatActivity implements View.OnClickListener {
    AutoCompleteTextView searchText;
    Button searchBtn;
    ListView dayList;
    int num = 0;
    TextView searchList;
    private Map<String, String> searchValue;
    private Map<String, String> dayValue;
    private Map<String, String> Search;
    String countrie[] = {"accidial", "dial someone's number on phone accidentally",
            "agender  ", "people do not identify as male or female",
            "airball  ", "completely miss the basket, rim, and backboard with a shot",
            "automagically", "in a way that seems magical, especially by computer",
            "awesomesauce", "extremely good; excellent",
            "bargainous", "costing less than expected, cheap or relatively cheap",
            "barista  ", "a person whose job involves preparing and serving different types of coffee",
            "bedunged  ", "has been soiled with or covered in dung; very old or old-fashioned.",
            "binge-watch  ", "watch multiple episodes of a television program in rapid succession",
            "bitcoin", "an online payment system that does not require an intermediary",
            "cheesebal", "lacking taste, style, or originality",
            "chillax", "calm down and relax",
            "consider", "deem to be", "minute", "infinitely or immeasurably small",
            "Castor oil ", "oil from castor seeds",
            "Casual", "accidental, chance",
            "Casualty  ", "accident, mishap, a person injured by accident",
            "Cat ", " a carnivorous domestic animal, pussy",
            " Cataclysm ", "deluge",
            "Catalogue", "a list",
            " Celibacy   ", "the state of being unmarried",
            "Celestial  ", "heavenly",
            " Celebrity  ", "a well-known person",
            "Celebration ", "observance or performance with due rites",
            "Celebrated ", "famous",
            "Celebrate", "perform with proper rites and ceremonies",
            " Ceiling ", "the inner roof of a house"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_windowof_dictionary);
        searchText = findViewById(R.id.autocomtext);
        searchBtn = findViewById(R.id.Btnsearch);
        searchBtn.setOnClickListener(this);
        searchList = findViewById(R.id.LV1);
        dayList = findViewById(R.id.LV2);
        SetDayWord();
        Search = new HashMap<String, String>();
        for (int i = 0; i < countrie.length; i += 2) {
            Search.put(countrie[i], countrie[i + 1]);
            ArrayAdapter arraySearch = new ArrayAdapter(WindowofDictionary.this,
                    android.R.layout.simple_expandable_list_item_1, new ArrayList<String>(Search.keySet()));
            searchText.setAdapter(arraySearch);
        }

    }

    private void SetDayWord() {
        final String countries[] = {"accidial", "dial someone's number on phone accidentally",
                "agender  ", "people do not identify as male or female",
                "airball  ", "completely miss the basket, rim, and backboard with a shot",
                "automagically", "in a way that seems magical, especially by computer",
                "awesomesauce", "extremely good; excellent",
                "bargainous", "costing less than expected, cheap or relatively cheap",
                "barista  ", "a person whose job involves preparing and serving different types of coffee",
                "bedunged  ", "has been soiled with or covered in dung; very old or old-fashioned.",
                "binge-watch  ", "watch multiple episodes of a television program in rapid succession",
                "bitcoin", "an online payment system that does not require an intermediary",
                "cheesebal", "lacking taste, style, or originality",
                "chillax", "calm down and relax",
                "consider", "deem to be", "minute", "infinitely or immeasurably small",
                "Castor oil ", "oil from castor seeds",
                "Casual", "accidental, chance",
                "Casualty  ", "accident, mishap, a person injured by accident",
                "Cat ", " a carnivorous domestic animal, pussy",
                " Cataclysm ", "deluge",
                "Catalogue", "a list",
                " Celibacy   ", "the state of being unmarried",
                "Celestial  ", "heavenly",
                " Celebrity  ", "a well-known person",
                "Celebration ", "observance or performance with due rites",
                "Celebrated ", "famous",
                "Celebrate", "perform with proper rites and ceremonies",
                " Ceiling ", "the inner roof of a house"};
        dayValue = new HashMap<String, String>();
        Random r = new Random();
        int ran = r.nextInt(24 - 0) + 1;
        if (ran % 2 == 0) {
            num = ran;
        } else {
            num = ran - 1;
        }
        android.widget.Toast.makeText(this, "number is " + num, Toast.LENGTH_SHORT).show();
        for (int i = num; i < countries.length; i += 2) {
            dayValue.put(countries[i], countries[i + 1]);
            ArrayAdapter arrayAdapter = new ArrayAdapter(WindowofDictionary.this,
                    android.R.layout.simple_expandable_list_item_1, new ArrayList<String>(dayValue.keySet()));
            dayList.setAdapter(arrayAdapter);
            dayList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String word = parent.getItemAtPosition(position).toString();
                    // Toast.makeText(WindowofDictionary.this, "hello"+word, Toast.LENGTH_SHORT).show();
                    searchList.setText("Your search item is  : " + word + "\n" + "meaning  : " + dayValue.get(word));
                }
            });

        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Btnsearch:
                String searchtxt = searchText.getText().toString();
                for (int i = 0; i < countrie.length; i += 2) {
                    if (searchtxt.equalsIgnoreCase(countrie[i])) {
                        searchValue = new HashMap<String, String>();
                        searchValue.put(countrie[i], countrie[i + 1]);
                        searchList.setText("Your search item is  : " + countrie[i] + "\n" + "meaning  : " + searchValue.get(countrie[i]));
                        return;
                    } else {
                        searchList.setText("Your search item not found  :\n" + searchtxt);

                    }

                }


                break;
        }
    }

}
