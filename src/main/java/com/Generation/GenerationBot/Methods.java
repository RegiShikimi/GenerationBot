package com.Generation.GenerationBot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Methods {
	
	public Methods() {
		
	}
	
	public String Methods(String r) { //Funciones que quisiéramos el bot realizara, como juegos u otras actividades
		String method = r;
		String answer = "";
		switch (method) { //Switch-case, ya que podríamos meterle más funciones como algún juego o no se.
		case "8ball": //Juego de preguntas si/no
			BufferedReader reader8ball = null; //Lector
			try {
				//StringBuilder sb = new StringBuilder(); //función prueba
				File file = new File("/Users/Alejandro/Documents/Generation/workspace/GenerationBot/8ball.txt"); //Apertura del archivo y guardado en una variable de tipo File
				reader8ball = new BufferedReader(new FileReader(file)); //Se le asigna el buffer para leer el archivo.
				System.out.println("I could open the file"); 
				List<String> lines = new ArrayList<String>(); //Creación variable de tipo ArrayList
				String line = reader8ball.readLine(); //Creación de un string, asignándole la primera línea del archivo.
				while (line != null) { //Linea va a estar revisando que lo que lea no sea nulo. Mientras no lo sea, irá leyendo línea por línea el archivo.
					lines.add(line); //Se le añade la línea en la que está "line" al ArrayList"lines".
					//sb.append(line); //prueba
					//sb.append("\n"); //prueba
					line = reader8ball.readLine(); //Se va a la siguiente línea
				}
				//String archivo = sb.toString(); //prueba
				//System.out.println(archivo); //prueba
				Random random = new Random(); //Se crea un número random, ya que queremos elegir una respuesta al azar del ArrayList.
				answer = lines.get(random.nextInt(lines.size()-1)); //El String en la posición "random" del ArrayList se le asignará a "answer", que es lo que se nos regresa.
				//answer = lines.get(new Random().nextInt(lines.size()-1));
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					reader8ball.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			break;
			
		default:
			break;
		}
		
		return answer;
	}
	
	//Decidí hacer esta una función aparte ya que conversar con alguien es muy "grande" como para tenerlo en un "switch-case".
	public String Conversacion(String c) {
		System.out.println("Entre al método 'Conversación'");
		//String convo = c;
		//System.out.println(convo);
		String answer = "";
		BufferedReader readerConvo = null;
		System.out.println("Pasé el buffer");
		if (c.contains("Hola") || c.contains("hola")) {
			try {
				System.out.println("Entre al 'try'");
				File file = new File("/Users/Alejandro/Documents/Generation/workspace/GenerationBot/hola.txt");
				readerConvo = new BufferedReader(new FileReader(file));
				System.out.println("I could open the file");
				List<String> lines = new ArrayList<String>();
				String line = readerConvo.readLine();
				while (line != null) { 
					lines.add(line);
					line = readerConvo.readLine();
				}
				Random random = new Random();
				answer = lines.get(random.nextInt(lines.size()-1));
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					readerConvo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} 
		//else if (convo.startsWith(""))
		return answer;
	}
	
	public String Cuestionario(String s) {
		BufferedReader readerConvo = null;
		BufferedReader readerConvo2 = null;
		String answer = "";
		String state = "";
		System.out.println("Estoy en el método 'Cuestionario'");
		if (s.equalsIgnoreCase(">CuestionarioP")) {
			state = "CuestionarioP";
		} else if (s.startsWith(">CuestionarioPE ")) {
			state = "CuestionarioPE";
		} else if (s.equalsIgnoreCase(">CuestionarioL")) {
			state = "CuestionarioL";
		} else if (s.startsWith(">CuestionarioPRE ")) {
			state = "CuestionarioPRE";
		} 
		switch(state) {
		case "CuestionarioP":
			System.out.println("Entré al case 'Cuestionario Pregunta'");
			try {
				System.out.println("Entré al 'try'");
				File file = new File("/Users/Alejandro/Documents/Generation/workspace/GenerationBot/Preguntas.txt");
				readerConvo = new BufferedReader(new FileReader(file));
				System.out.println("I could open the file");
				List<String> lines = new ArrayList<String>();
				String line = readerConvo.readLine();
				while (line != null) { 
					lines.add(line);
					line = readerConvo.readLine();
				}
				Random random = new Random();
				answer = lines.get(random.nextInt(lines.size()-1));
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					readerConvo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			break;
			
		case "CuestionarioL":
			System.out.println("Entré al case 'Cuestionario Lista'");
			try {
				System.out.println("Entré al 'try'");
				StringBuilder sb = new StringBuilder();
				File file = new File("/Users/Alejandro/Documents/Generation/workspace/GenerationBot/Preguntas.txt");
				readerConvo = new BufferedReader(new FileReader(file));
				System.out.println("I could open the file");
				String line = readerConvo.readLine();
				while (line != null) { 
					sb.append(line);
					sb.append("\n");
					line = readerConvo.readLine();
				}
				answer = sb.toString();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					readerConvo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			break;
			
		case "CuestionarioPE":
			System.out.println("Entre al método 'Cuestionario Pregunta Elegida'");
			int pregunta = 0;
			boolean found = false;
			if(s.matches(".*\\d+.*")) {
				for(char c : s.toCharArray()) {
					if(Character.isDigit(c)){
			            pregunta = Character.getNumericValue(c);
			            found = true;
			        } else if(found){
			            // If we already found a digit before and this char is not a digit, stop looping
			            break;   
			        }
				}
			}
			try {
				System.out.println("Entre al 'try'");
				File file = new File("/Users/Alejandro/Documents/Generation/workspace/GenerationBot/Preguntas.txt");
				readerConvo = new BufferedReader(new FileReader(file));
				System.out.println("I could open the file");
				List<String> lines = new ArrayList<String>();
				String line = readerConvo.readLine();
				while (line != null) { 
					lines.add(line);
					line = readerConvo.readLine();
				}
				answer = lines.get(pregunta);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					readerConvo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			break;
		case "CuestionarioPRE":
			System.out.println("Entre al método 'Cuestionario Pregunta Elegida'");
			int pregunta2 = 0;
			String numero = "";
			boolean found2 = false;
			if(s.matches(".*\\d+.*")) {
				for(char c2 : s.toCharArray()) {
					if(Character.isDigit(c2)){
						numero = (numero + Character.getNumericValue(c2));
			            //pregunta2 = pregunta2 + Character.getNumericValue(c2);
						//found2 = true;
			        } // else if(found2){
			            // If we already found a digit before and this char is not a digit, stop looping
			            // break;   
			        //}
				}
			}
			
			pregunta2 = Integer.parseInt(numero) - 1;
			
			try {
				System.out.println("Entre al 'try'");
				File filePreguntas = new File("/Users/Alejandro/Documents/Generation/workspace/GenerationBot/Preguntas.txt");
				File fileRespuestas = new File("/Users/Alejandro/Documents/Generation/workspace/GenerationBot/Respuestas.txt");
				readerConvo = new BufferedReader(new FileReader(filePreguntas));
				readerConvo2 = new BufferedReader(new FileReader(fileRespuestas));
				System.out.println("I could open both files");
				List<String> linesPreguntas = new ArrayList<String>();
				List<String> linesRespuestas = new ArrayList<String>();
				String linePregunta = readerConvo.readLine();
				String lineRespuesta = readerConvo2.readLine();
				while (linePregunta != null && lineRespuesta != null) { 
					linesPreguntas.add(linePregunta);
					linesRespuestas.add(lineRespuesta);
					linePregunta = readerConvo.readLine();
					lineRespuesta = readerConvo2.readLine();
				}
				answer = (linesPreguntas.get(pregunta2) + "\n" + linesRespuestas.get(pregunta2));
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					readerConvo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			break;
		
		default:
			break;
		}
		//else if (convo.startsWith(""))
		return answer;
	}
}

