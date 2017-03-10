package com.zoka.caesarcipher;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText mEncodeEditText;
    private EditText mDecodeEditText;
    private Button mEncodeButton;
    private Button mDecodeButton;
    private Spinner mSpinner;
    private ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEncodeButton = (Button) findViewById(R.id.encode_btn);
        mDecodeButton = (Button) findViewById(R.id.decode_btn);
        mEncodeEditText = (EditText) findViewById(R.id.encode_edit_text);
        mDecodeEditText = (EditText) findViewById(R.id.decode_edit_text);
        mSpinner = (Spinner) findViewById(R.id.spiner);
        arrayList = fillSpinnerList();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList);
        mSpinner.setAdapter(adapter);
        mEncodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int shiftAmount = Integer.parseInt(arrayList.get(mSpinner.getSelectedItemPosition() ));
                Toast.makeText(MainActivity.this, ""+shiftAmount, Toast.LENGTH_SHORT).show();
                String alphabet = mEncodeEditText.getText().toString();
                ArrayList<Integer> integerArrayList = Utils.encodeText(Utils.getAlphabetIndex(alphabet), shiftAmount);
                mDecodeEditText.setText(Utils.getAlphabeText(integerArrayList).toUpperCase());

            }
        });
        mDecodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int shiftAmount = Integer.parseInt(arrayList.get(mSpinner.getSelectedItemPosition()));
                String alphabet = mDecodeEditText.getText().toString();
                ArrayList<Integer> integerArrayList = Utils.decodeText(Utils.getAlphabetIndex(alphabet), shiftAmount);
                mEncodeEditText.setText(Utils.getAlphabeText(integerArrayList).toUpperCase());
            }
        });
    }

    private ArrayList<String> fillSpinnerList() {
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 1; i < 26; i++) {
            strings.add("" + i);
        }
        return strings;
    }
}
