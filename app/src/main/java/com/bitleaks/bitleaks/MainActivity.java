package com.bitleaks.bitleaks;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button submit = (Button) findViewById(R.id.submitButton);
        final TextView messageBox = (TextView) findViewById(R.id.editText);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prepareTextForOpReturn(messageBox.getText().toString());
                messageBox.setText("Message stored on Bitcoin testnet blockchain," +
                        " see it here: https://testnet.smartbit.com.au/" +
                        "address/mnoQEPQe1D7hy2mvByJZk7cQ2JCd64cawA");
            }
        });
    }

    protected void prepareTextForOpReturn(String text)
    {
        if(text.length() > 40)
        {
            int j = 0;
            for(int i=40; i < text.length(); i += 40)
            {
                writeToBlockchain(text.substring(j, i));
                j = i;
            }
        }
        else
        {
            writeToBlockchain(text);
        }
    }

    public static void main(String args[]){
        writeToBlockchain("hello");
    }

    protected static void writeToBlockchain(String chunk)
    {
        OpReturnApi.Companion.storeMessageOnBlockchain(chunk);
    }
}
