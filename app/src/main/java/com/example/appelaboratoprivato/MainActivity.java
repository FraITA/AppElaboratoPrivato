package com.example.appelaboratoprivato;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

	WebView wv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Stampa e reindirizza il contenuto del file xml main_activity.xml
		setContentView(R.layout.activity_main);
		//Prendo l'oggetto di tipo WebView dal layout
		this.wv = (WebView) findViewById(R.id.webView);
		//pulisco la cache della webview
		this.wv.clearCache(true);
		//Abilito Javascript nella webview
		this.wv.getSettings().setJavaScriptEnabled(true);
		//Configuro il client della WebView
		this.wv.setWebViewClient(new WebViewClient());
		//Se l'istanza non è ancora stata creata, carico l'URL
		if (savedInstanceState == null)
		{
			this.wv.loadUrl("http://192.168.43.186/dashboard/progetti/ElaboratoEsamePriv/");
		}

	}

	@Override
	protected void onSaveInstanceState(Bundle outState )
	{
		super.onSaveInstanceState(outState);
		this.wv.saveState(outState);
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState)
	{
		super.onRestoreInstanceState(savedInstanceState);
		this.wv.restoreState(savedInstanceState);
	}

}