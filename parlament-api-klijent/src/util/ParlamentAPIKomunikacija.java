package util;

import java.awt.SecondaryLoop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import domen.Poslanik;

public class ParlamentAPIKomunikacija {
	private static final String poslaniciURL = "http://147.91.128.71:9090/parlament/api/members";
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
	
	public List<Poslanik> vratiPoslanike(){
		try{
			String rezultat = sendGet(poslaniciURL);
			LinkedList<Poslanik> poslanici = new LinkedList<>();
			
			Gson gson = new GsonBuilder().create();
			JsonArray jsA = gson.fromJson(rezultat, JsonArray.class);
			
			for (int i = 0; i < jsA.size(); i++) {
				JsonObject jsonPoslanik = (JsonObject) jsA.get(i);
				Poslanik p = new Poslanik();
				p.setId(jsonPoslanik.get("id").getAsInt());
				p.setIme(jsonPoslanik.get("ime").getAsString());
				p.setPrezime(jsonPoslanik.get("prezime").getAsString());
				if(jsonPoslanik.get("datum")!=null){
					p.setDatumRodjenja(sdf.parse(jsonPoslanik.get("datum").getAsString()));
				}
				poslanici.add(p);
			}
			return poslanici;
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		return new LinkedList<Poslanik>();
	}


	private String sendGet(String url) throws IOException {
		// TODO Auto-generated method stub
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("GET");

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

		boolean zavrsenoCitanje = true;
		String text = "";

		while (zavrsenoCitanje) {
			String s = in.readLine();

			if (s != null) {
				text += s;
			} else {
				zavrsenoCitanje = false;
			}
		}
		in.close();

		return text.toString();
	}
		
}