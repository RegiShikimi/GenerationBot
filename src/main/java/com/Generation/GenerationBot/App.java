package com.Generation.GenerationBot;

import java.util.Random;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class App extends ListenerAdapter
{
    public static void main( String[] args ) throws Exception
    {
        JDA jda = new JDABuilder(AccountType.BOT).setToken(Ref.token).buildBlocking(); //Inicialización del bot
        jda.addEventListener(new App()); //Función do/while infinita donde estará recibiendo siempre mensajes
    }
    
    @Override
    public void onMessageReceived(MessageReceivedEvent evt) {
    	
    	//Objetos
    	Methods method = new Methods(); 
    	Methods conversation = new Methods();
    	Methods cuestionario = new Methods();
    	User objUser = evt.getAuthor();
    	MessageChannel objMsgCh = evt.getChannel();
    	Message objMsg = evt.getMessage();
    	
    	//Variables
    	String convo = "";
    	
    	//Commands
    	if(objMsg.getContentRaw().equalsIgnoreCase(Ref.prefix+"ping")) { //Función ping
    		objMsgCh.sendMessage(objUser.getAsMention() + " Pong!").queue();
    	}
    	
    	if(objMsg.getContentRaw().equalsIgnoreCase(Ref.prefix+ "8ball")) { //Función describiendo uso de 8ball	
    		objMsgCh.sendMessage("Si quieres hacer uso del 8ball, escribe en este formato '>8ball <pregunta>'.").queue();
    	}
    	
    	if(objMsg.getContentRaw().startsWith(Ref.prefix+"8ball ")) { //Función respuesta 8ball
    		objMsgCh.sendMessage(method.Methods("8ball")).queue();
    	}
    	
    	if (objMsg.getContentRaw().startsWith(Ref.prefix+"Conversacion ")) { //Función conversación
    		objMsgCh.sendMessage(conversation.Conversacion(objMsg.getContentRaw())).queue(); //Mensaje mandado en Discord
    		System.out.println("Mandé respuesta");
    		//convo = ""; //Resetear string.
    	}
    	
    	if(objMsg.getContentRaw().equalsIgnoreCase(Ref.prefix+ "Conversacion")) { //Método describir uso de "Conversación".
    		objMsgCh.sendMessage("Si quieres entablar una conversación conmigo, basta con escribir '>conversacion <mensaje>'. Espero ser lo más coherente posible.").queue();
    	}
    	
    	if(objMsg.getContentRaw().equalsIgnoreCase(Ref.prefix+ "Cuestionario")) { //Método describir uso de "Cuestionario".
    		objMsgCh.sendMessage("Hay varias funciones para el Cuestionario").queue();
    	}
    	
    	if(objMsg.getContentRaw().equalsIgnoreCase(Ref.prefix+ "CuestionarioP")) { //Método mostrar pregunta al azar
    		objMsgCh.sendMessage(cuestionario.Cuestionario(objMsg.getContentRaw())).queue(); //aquí va una pregunta a mandar.
    	}
    	
    	if(objMsg.getContentRaw().equalsIgnoreCase(Ref.prefix+ "CuestionarioL")) { //Método mostrar lista de preguntas del cuestionario
    		//objMsgCh.sendMessage().queue(); aquí va la lista de preguntas
    	}
    	
    	if(objMsg.getContentRaw().equalsIgnoreCase(Ref.prefix+ "CuestionarioPE ")) { //Método mostrar pregunta elegida de la lista
    		//objMsgCh.sendMessage().queue(); aquí va la pregunta elegida a mandar
    	}
    	
    	if(objMsg.getContentRaw().startsWith(Ref.prefix+ "CuestionarioPRE ")) { //Método mostrar pregunta y respuesta elegida de la lista
    		objMsgCh.sendMessage(cuestionario.Cuestionario(objMsg.getContentRaw())).queue(); //aquí va la pregunta y respuesta elegida a mandar
    	}
    	
    	
    }
}
