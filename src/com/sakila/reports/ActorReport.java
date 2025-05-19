package com.sakila.reports;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sakila.models.Actor;

public class ActorReport {
	
	public static void exportToCSV(List<Actor> actors, String filename)
	{
		try (FileWriter writer = new FileWriter(filename))
		{
			writer.append("actor_id;first_name;last_name;last_update\n");
			
			for (Actor actor : actors)
			{
				writer.append(actor.getActorId() + ";")
					 .append(actor.getFirstName() + ";")
					 .append(actor.getLastName() + ";")
					 .append(actor.getLastUpdate() + "\n");
			}
			System.out.println("📄 CSV exportado correctamente: " + filename);
		} catch (IOException e ) {
			System.out.println("❌ Error al exportat CSV" + e.getMessage());
		}
	}
	
	public static void exportToJSON(List<Actor> actors, String filename) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(filename)) {
            gson.toJson(actors, writer);
            System.out.println("📄 JSON exportado correctamente: " + filename);
        } catch (IOException e) {
            System.out.println("❌ Error al exportar JSON: " + e.getMessage());
        }
    }

}
