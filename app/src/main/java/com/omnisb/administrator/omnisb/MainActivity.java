package com.omnisb.administrator.omnisb;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.AlertDialog;

import java.net.URLEncoder;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String searchTerm;

        final EditText terms = (EditText) findViewById(R.id.s_terms);
        final TextView testing = (TextView) findViewById(R.id.textView2);

        Button googleButton = (Button) findViewById(R.id.button_google);
        Button naverButton = (Button) findViewById(R.id.button_naver);
        Button enhaButton = (Button) findViewById(R.id.button_enha);

        googleButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(terms.equals(null)){
                    //AlertDialog.Builder basicAlert = new AlertDialog.Builder();

                }//end of if
                else{
                    testing.setText(terms.getText().toString());

                    search("http://www.google.com/search?q=" + terms.getText().toString());
                }//end of else
            }
        });

        naverButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(terms.equals(null)){
                    //AlertDialog.Builder basicAlert = new AlertDialog.Builder();

                }//end of if
                else{
                    testing.setText(terms.getText().toString());

                    search("http://search.naver.com/search.naver?where=nexearch&query=" + terms.getText().toString());
                }//end of else
            }
        });

        enhaButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(terms.equals(null)){
                    //AlertDialog.Builder basicAlert = new AlertDialog.Builder();

                }//end of if
                else{
                    testing.setText(terms.getText().toString());

                    search("https://mirror.enha.kr/wiki/" + terms.getText().toString());
                }//end of else
            }
        });

    }

    public void search(String search_url){

        //String url = "http://www.google.com/search?q=" + keywords;
        //String query = URLEncoder.encode(url , "US-ASCII ");

        Intent intent = new Intent(Intent.ACTION_VIEW);

        Uri myUrl = Uri.parse(search_url);
        intent.setData(myUrl);
        //intent.setData(Uri.parse(url));
        startActivity(intent);

    }//end of search method.

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
