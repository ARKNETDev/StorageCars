package com.iia.shop;

import java.util.ArrayList;
import java.util.Scanner;
import com.iia.shop.entity.Voiture;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Store {

	private static ArrayList<Voiture> voitures;
	private static Scanner sc;

	public static void main(String[] args) {

		sc = new Scanner(System.in);

		File dir = new File("F:\\StorageVehicule\\Data");
		File Dir = new File("F:\\StorageVehicule\\Data\\Voiture.txt");
		File newfile = new File("F:\\StorageVehicule\\Data\\Voiture.txt");
		Voiture Car = new Voiture();
		int i;
		String marque = Car.getMarque(); 
		int speed = Car.getSpeed(); 
		int year = Car.getYear();
		String model = Car.getModel(); 
		String color = Car.getColor();  
		double prix = Car.getPrice();
		Car = new Voiture(marque, speed, year, model, color,  prix);
		i = 0;
		int application = 1;

		System.out.println("Bienvenue à notre magasin de voiture !");
		System.out.println("");
		System.out.println("1 - Rester !");
		System.out.println("");
		System.out.println("2 - Quitter!");
		System.out.println("");
		System.out.println("Veuillez choisir une operation : ");
		int action = sc.nextInt();
		System.out.println("");

		switch (action) {
		case 1:
			while (application == 1) {
				System.out.println("Gestion des véhicules");
				System.out.println("1 - créer un véhicule");				
				System.out.println("2 - voir tous les véhicules");
				System.out.println("3 - Quitter le magasin");

				System.out.println("Votre choix");
				int choice = sc.nextInt();

				Voiture vehicule;

				switch (choice) {
				case 1:
					vehicule = new Voiture();
					ArrayList<Voiture> AddCar = new ArrayList<Voiture>();
					AddCar.add(vehicule);
					setVehicule(i, vehicule);					
					System.out.println("");
					createFile(newfile, "Marque de la Voiture : " + vehicule.getMarque());
					System.out.println("");
					createFile(newfile, "Année de la Voiture : " + Integer.toString(vehicule.getYear()));
					System.out.println("");
					createFile(newfile, "Modèle de la Voiture : " + vehicule.getModel());
					System.out.println("");
					createFile(newfile, "Couleur de la Voiture : " + vehicule.getColor());
					System.out.println("");
					createFile(newfile, "Prix de la Voiture : " + Double.toString(vehicule.getPrice()));
					System.out.println("");

					break;
				case 2:				
						ArrayList<Voiture> vehicules = readAll();						
						ReadFile(Dir);
					break;
				case 3:
					System.out.println("AU REVOIR");
					application = 0;
					break;
				default:
					break;
				}
			}

			break;

		case 2:
			System.out.println("AU REVOIR");
			application = 0;
			break;

		default:
			break;
		}

	}

	private static ArrayList<Voiture> readAll() {	
		return voitures;
	}

	private static void displayVehicule(Voiture vehicule) {
		System.out.println("Marque : " + vehicule.getMarque());
		System.out.println("Modèle : " + vehicule.getModel());
		System.out.println("Couleur : " + vehicule.getColor());
		System.out.println("Année : " + vehicule.getYear());
		System.out.println("Vitesse : " + vehicule.getSpeed());
		System.out.println("Prix : " + vehicule.getPrice());
	}

	private static void setVehicule(int i ,Voiture voiture) {
		i++;
		System.out.println("Voiture N°" + i);	
		System.out.println("Veuillez saisir la marque du véhicule");
		voiture.setMarque(sc.next());	
		System.out.println("Veuillez saisir l'année du véhicule");
		voiture.setYear(sc.nextInt());
		System.out.println("Veuillez saisir le modèle du véhicule");
		voiture.setModel(sc.next());
		System.out.println("Veuillez saisir la couleur du véhicule");
		voiture.setColor(sc.next());
		System.out.println("Veuillez saisir le prix du véhicule");
		voiture.setPrice(sc.nextDouble());	
	}

	public static void File(File Directory) {

		if (Directory.isDirectory()) {
			String list[] = Directory.list();

			if (list != null && list.length > 0) {
				File file;
				for (String filename : list) {
					file = new File(Directory.getAbsolutePath() + "\\" + filename);
					if (file.isDirectory()) {
						File(file);
					} else {
						System.out.println(Directory.getAbsolutePath());
					}
				}
			}
		}
	}

	public static void createFile(File file, String value) {
		try {
			FileWriter writer = new FileWriter(file, true);
			BufferedWriter buffer = new BufferedWriter(writer);
			buffer.write(value);
			buffer.newLine();

			buffer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void ReadFile(File file) {
		try {
			FileReader reader = new FileReader(file);
			BufferedReader buffer = new BufferedReader(reader);

			while (buffer.ready()) {
				System.out.println(buffer.readLine());
				System.out.println("");
			}
			buffer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void WriteFile(File file, String value) {
		try {
			FileWriter writer = new FileWriter(file);
			// mettre un newLine() pour créer un nouveau texte si on met un
			// boolean.
			BufferedWriter buffer = new BufferedWriter(writer);
			buffer.write(value);
			buffer.newLine(); // pour accéder à une nouvelle ligne
			buffer.write(value);
			buffer.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
