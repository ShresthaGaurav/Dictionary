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
    TextView searchList;
    private Map<String, String> searchValue;
    private Map<String, String> dayValue;
    private Map<String, String> Search;

    String countrie[] = {"nepal", "kathmandu", "India", "New Delhi", "china", "Beijing",
            "uk", "London", "usa", "Washington DC", "Canada", "ottwa"};

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
            searchText.setAdapter(arraySearch);}

    }

    private void SetDayWord() {
        final String countries[] = {"nepal", "kathmandu", "India", "New Delhi", "china", "Beijing",
                "uk", "London", "usa", "Washington DC", "Canada", "ottwa"};
        dayValue = new HashMap<String, String>();

        for (int i = 0; i < countries.length; i += 2) {
            dayValue.put(countries[i], countries[i + 1]);
            ArrayAdapter arrayAdapter = new ArrayAdapter(WindowofDictionary.this,
                    android.R.layout.simple_expandable_list_item_1, new ArrayList<String>(dayValue.keySet()));
            dayList.setAdapter(arrayAdapter);
            dayList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                   String word = parent.getItemAtPosition(position).toString();
                   // Toast.makeText(WindowofDictionary.this, "hello"+word, Toast.LENGTH_SHORT).show();
                    searchList.setText("Your search item is  :\n" + word + "\n" + dayValue.get(word));
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
                        searchList.setText("Your search item is  :\n" + countrie[i] + "\n" + searchValue.get(countrie[i]));
                        return;
                    } else {
                        searchList.setText("Your search item not found  :\n" + searchtxt);

                    }

                }


                break;
        }
    }

}
