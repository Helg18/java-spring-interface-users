package com.henryleon.useApi;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UseApiApplication {

	public static void main(String[] args) throws Exception {

		// manejarod de peticiones
		UseApiApplication manejador = new UseApiApplication();

		// validar que exista
		if (args != null) {
			// validar valores de la peticion
			manejador.detectRequet(args);

			// hacer peticion
			// formatear datos
			// imprimir datos.
		} else {
			System.out.println("*********************************");
			System.out.println("*                               *");
			System.out.println("*   No se recibio la peticion   *");
			System.out.println("*                               *");
			System.out.println("*********************************");
		}

	}

	public void detectRequet(String[] request) throws Exception {

		Requester requester = new Requester();

		// Get user list
		if (request[0].equals("getUsers")) {
			System.out.println("listando lista de usuarios");
			System.out.println(Requester.getUsers());
		}

		// get user by username
		if (request[0].equals("getUserByUsername")) {
			if (request.length > 1) {
				System.out.println("Usuario: " + request[1]);
				System.out.println(Requester.getUserByUsername(request[1]));
			} else {
				System.out.println("Por favor especifique el username a buscar.");
			}
		}

		// create user
		if (request[0].equals("createUser")) {
			if (request.length == 10) {
				System.out.println("Usuario: " + request[1]);
				System.out.println(Requester.createUser(request));
			} else {
				System.out.println("Por favor especifique \n " + "        nombres string \n"
						+ "        apellidos string \n" + "        email string \n" + "        telefono string \n"
						+ "        username string \n" + "        password string \n"
						+ "        fechaCreacion date (YYYY-MM-DD) \n" + "        activo Boolean (0|1) \n"
						+ "        rolId Integer (OBLIGATORIO)\n"
						+ "En este mismo orden, si desea dejar un campo sin llenar puede abrir y cerrar comillas ");
			}
		}
		
		// update user
		if (request[0].equals("updateUser")) {
			if (request.length == 11) {
				System.out.println("Usuario: " + request[1]);
				System.out.println(Requester.updateUser(request));	
			} else {
				System.out.println("Por favor especifique \n " + "        ID Integer \n" + "        nombres string \n"
						+ "        apellidos string \n" + "        email string \n" + "        telefono string \n"
						+ "        username string \n" + "        password string \n"
						+ "        fechaCreacion date (YYYY-MM-DD) \n" + "        activo Boolean (0|1) \n"
						+ "        rolId Integer (OBLIGATORIO)\n"
						+ "En este mismo orden, si desea dejar un campo sin llenar puede abrir y cerrar comillas ");
			}
		}

		// delete user
		if (request[0].equals("deleteUser")) {
				if (request.length == 2) {
					System.out.println("Usuario: " + request[1]);
					System.out.println(Requester.deleteUser(request));
				} else {
				System.out.println("Por favor especifique \n " + "        id Integer \n "
						+ "Ingrese el ID del usuario que desea eliminar.");
				}
		}

		// get user by date creacion
		if (request[0].equals("getUsersByDate")) {
			System.out.println("Listado de usuarios ordenados por fecha");
			System.out.println(Requester.getUsersByDate());
		}
	}
}
