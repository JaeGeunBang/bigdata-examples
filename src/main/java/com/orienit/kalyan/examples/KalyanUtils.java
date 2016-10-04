package com.orienit.kalyan.examples;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import com.google.common.base.Joiner;
import com.orienit.kalyan.models.ProductLog;
import com.orienit.kalyan.models.User;

public class KalyanUtils {

	public static List<String> products = Arrays.asList("Mobiles", "Laptops", "Tablets", "Televisions", "Cameras", "Computers");
	public static List<String> transactions = Arrays.asList("Success", "Failure", "Pending");

	public static List<String> countries = new ArrayList<String>(Arrays.asList("India", "US"));
	public static List<String> acities = Arrays.asList("Visakhapatnam", "Vijayawada", "Guntur", "Rajahmundry", "Tirupati", "Kakinada");
	public static List<String> tcities = Arrays.asList("Hyderabad", "Warangal", "Nizamabad", "Karimnagar", "Nalgonda", "Khammam");
	public static List<String> kcities = Arrays.asList("Bengaluru", "Bagalkot", "Ballari", "Bidar", "Vijayapura", "Mangaluru");
	public static List<String> ccities = Arrays.asList("Adambakkam", "Mangadu", "Tambaram", "Virugambakkam", "Kottur", "Madras");
	public static List<String> fcities = Arrays.asList("Indian Creek", "South Beach", "Key Biscayne", "Tierra Verde", "Hollywood", "Orlando");
	public static List<String> hcities = Arrays.asList("Honolulu", "Pearl City", "Mililani Town", "Hanapepe", "Pupukea", "East Honolulu");
	public static List<String> ncities = Arrays.asList("Albany", "Canandaigua", "Glens Falls", "Hornell", "Little Falls", "Niagara Falls");
	public static List<String> wcities = Arrays.asList("Seattle", "Bellevue", "Renton", "Bellingham", "Pasco", "Auburn");
	public static Map<String, Map<String, List<String>>> data = getData();

	public static Map<String, Map<String, List<String>>> getData() {
		Map<String, List<String>> imap = new HashMap<String, List<String>>();
		imap.put("Andhra Pradesh", acities);
		imap.put("Telangana", tcities);
		imap.put("Karnataka", kcities);
		imap.put("Chennai", ccities);

		Map<String, List<String>> umap = new HashMap<String, List<String>>();
		umap.put("Florida", fcities);
		umap.put("Hawaii", hcities);
		umap.put("New York", ncities);
		umap.put("Washington", wcities);

		Map<String, Map<String, List<String>>> data = new HashMap<String, Map<String, List<String>>>();
		data.put("India", imap);
		data.put("US", umap);

		return data;
	}

	public static List<User> getUsers(int number) {
		List<User> users = new ArrayList<User>();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");

		for (int i = 1; i <= number; i++) {
			String date = sdf.format(new Date());
			String country = countries.get(new Random().nextInt(countries.size()));
			Map<String, List<String>> smap = data.get(country);
			Set<String> sset = smap.keySet();
			String state = (String) sset.toArray()[new Random().nextInt(sset.size())];
			List<String> clist = smap.get(state);
			String city = clist.get(new Random().nextInt(clist.size()));
			String username = "user" + i;
			User user = new User(i, username, username, username + "@gmail.com", country, state, city, date);
			users.add(user);
		}

		return users;
	}

	public static void generateUsers(String path, int startNumber, int numberOfUsers, String delimiter, long sleep) throws IOException {
		FileWriter fw = new FileWriter(path, true);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");

		for (int i = startNumber; i < startNumber + numberOfUsers; i++) {
			String date = sdf.format(new Date());
			String country = countries.get(new Random().nextInt(countries.size()));
			Map<String, List<String>> smap = data.get(country);
			Set<String> sset = smap.keySet();
			String state = (String) sset.toArray()[new Random().nextInt(sset.size())];
			List<String> clist = smap.get(state);
			String city = clist.get(new Random().nextInt(clist.size()));
			String username = "user" + i;
			User user = new User(i, username, username, username + "@gmail.com", country, state, city, date);
			Object[] fields = { i, username, username, username + "@gmail.com", country, state, city, date };
			String json = delimiter != null ? join(fields, delimiter) : user.toString();
			fw.write(json + "\n");
			fw.flush();
			sleep(sleep);
		}

		fw.close();
	}

	public static List<ProductLog> getProductLog(int number) throws IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		List<User> users = getUsers(100);
		List<ProductLog> logs = new ArrayList<ProductLog>();

		for (int i = 1; i <= number; i++) {
			String date = sdf.format(new Date());
			String product = products.get(new Random().nextInt(products.size()));
			String transaction = transactions.get(new Random().nextInt(transactions.size()));
			String country = countries.get(new Random().nextInt(countries.size()));
			Map<String, List<String>> smap = data.get(country);
			Set<String> sset = smap.keySet();
			String state = (String) sset.toArray()[new Random().nextInt(sset.size())];
			List<String> clist = smap.get(state);
			String city = clist.get(new Random().nextInt(clist.size()));

			User user = users.get(new Random().nextInt(users.size()));
			ProductLog log = new ProductLog(user.getUserid(), user.getUsername(), user.getEmail(), date, product, transaction, country, state, city);
			logs.add(log);
		}

		return logs;
	}

	public static void generateProductLog(String path, int numberOfUsers, int numberOfLogs, String delimiter, long sleep) throws IOException {
		FileWriter fw = new FileWriter(path, true);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		List<User> users = getUsers(numberOfUsers);

		for (int i = 1; i <= numberOfLogs; i++) {
			String date = sdf.format(new Date());
			String product = products.get(new Random().nextInt(products.size()));
			String transaction = transactions.get(new Random().nextInt(transactions.size()));
			String country = countries.get(new Random().nextInt(countries.size()));
			Map<String, List<String>> smap = data.get(country);
			Set<String> sset = smap.keySet();
			String state = (String) sset.toArray()[new Random().nextInt(sset.size())];
			List<String> clist = smap.get(state);
			String city = clist.get(new Random().nextInt(clist.size()));

			User user = users.get(new Random().nextInt(users.size()));
			ProductLog log = new ProductLog(user.getUserid(), user.getUsername(), user.getEmail(), date, product, transaction, country, state, city);
			Object[] fields = { user.getUserid(), user.getUsername(), user.getEmail(), date, product, transaction, country, state, city };
			String json = delimiter != null ? join(fields, delimiter) : log.toString();
			fw.write(json + "\n");
			fw.flush();
			sleep(sleep);
		}

		fw.close();
	}

	private static String join(Object[] fields, String delimiter) {
		if (delimiter.equals("\\t")) {
			return Joiner.on("\t").join(fields);
		} else {
			return Joiner.on(delimiter).join(fields);
		}
	}

	private static void sleep(long duration) {
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
