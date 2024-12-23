package conversorAlura;

import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;

import conversorAlura.service.HTTPService;

public class Main {
    public static void main(String[] args) {
        mostrarMenu();
    }

	private static void mostrarMenu() {
		final HTTPService conversorService = new HTTPService();
		final List<Moneda> monedas = List.of(
    			new Moneda("USD", "Dólar estadounidense", "US$"),
    			new Moneda("ARS", "Peso argentino", "$"),
    			new Moneda("BRL", "Real brasileño", "R$"),
    			new Moneda("CLP", "Peso chileno", "$")
    			);
		Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (true) {
            System.out.println("******************************************");
            System.out.println("**     Bienvenido al Menú Principal     **");
            System.out.println("******************************************");
            System.out.println("Por favor, selecciona una opción para el conversor de monedas:");
            System.out.println("1. Opción 1: Dólar --> Peso argentino");
            System.out.println("2. Opción 2: Peso argentino --> Dólar");
            System.out.println("3. Opción 3: Real brasileño --> Dólar");
            System.out.println("4. Opción 4: Dólar --> Real brasileño");
            System.out.println("5. Opción 5: Dólar --> Peso chileno");
            System.out.println("6. Opción 6: Peso chileno --> Dólar");
            System.out.println("7. Opción 7: Salir");
            System.out.println("Elija una opción válida");
            System.out.println("******************************************");

            // Validar entrada del usuario
            try {
                System.out.print("Ingresa tu elección (1-7): ");
                opcion = Integer.parseInt(scanner.nextLine());
                double cantidad;
                double resultado;

                if (opcion >= 1 && opcion <= 7) {
                    // Procesar la opción seleccionada
                    switch (opcion) {
                        case 1:
                        	System.out.print("Ingresa la cantidad a convertir: ");
                        	cantidad = Double.parseDouble(scanner.nextLine());
                        	System.out.println("Procesando...");
                        	resultado = conversorService.convert(monedas.get(0).getCodigo(), monedas.get(1).getCodigo(), cantidad);
                        	System.out.println(monedas.get(0).getCodigo() + " " + cantidad + " son " + String.format("%.2f", resultado) + " " + monedas.get(1).getCodigo());
                        	
                            break;
                        case 2:
                        	System.out.print("Ingresa la cantidad a convertir: ");
                        	cantidad = Double.parseDouble(scanner.nextLine());
                        	System.out.println("Procesando...");
                        	resultado = conversorService.convert(monedas.get(1).getCodigo(), monedas.get(0).getCodigo(), cantidad);
                        	System.out.println(monedas.get(1).getCodigo() + " " + cantidad + " son " + String.format("%.2f", resultado) + " " + monedas.get(0).getCodigo());
                        	

                            break;
                        case 3:
                        	System.out.print("Ingresa la cantidad a convertir: ");
                        	cantidad = Double.parseDouble(scanner.nextLine());
                        	System.out.println("Procesando...");
                        	resultado = conversorService.convert(monedas.get(0).getCodigo(), monedas.get(2).getCodigo(), cantidad);
                        	System.out.println(monedas.get(0).getCodigo() + " " + cantidad + " son " + String.format("%.2f", resultado) + " " + monedas.get(2).getCodigo());
                        	

                            break;
                        case 4:
                        	System.out.print("Ingresa la cantidad a convertir: ");
                        	cantidad = Double.parseDouble(scanner.nextLine());
                        	System.out.println("Procesando...");
                        	resultado = conversorService.convert(monedas.get(2).getCodigo(), monedas.get(0).getCodigo(), cantidad);
                        	System.out.println(monedas.get(2).getCodigo() + " " + cantidad + " son " + String.format("%.2f", resultado) + " " + monedas.get(0).getCodigo());
                        	

                            break;
                        case 5:
                        	System.out.print("Ingresa la cantidad a convertir: ");
                        	cantidad = Double.parseDouble(scanner.nextLine());
                        	System.out.println("Procesando...");
                        	resultado = conversorService.convert(monedas.get(0).getCodigo(), monedas.get(3).getCodigo(), cantidad);
                        	System.out.println(monedas.get(0).getCodigo() + " " + cantidad + " son " + String.format("%.2f", resultado) + " " + monedas.get(3).getCodigo());
                        	

                            break;
                        case 6:
                        	System.out.print("Ingresa la cantidad a convertir: ");
                        	cantidad = Double.parseDouble(scanner.nextLine());
                        	System.out.println("Procesando...");
                        	resultado = conversorService.convert(monedas.get(3).getCodigo(), monedas.get(0).getCodigo(), cantidad);
                        	System.out.println(monedas.get(3).getCodigo() + " " + cantidad + " son " + String.format("%.2f", resultado) + " " + monedas.get(0).getCodigo());
                        	

                            break;
                        case 7:
                            System.out.println("Gracias por usar el sistema. ¡Hasta luego!");
                            scanner.close();
                            return; // 
                    }
                } else {
                    System.out.println("Por favor, selecciona una opción válida (1-7).");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingresa un número entre 1 y 7.");
            } catch (Exception e) {
            	System.out.println("Error en la conversión");
            }

            // Esperar antes de mostrar el menú nuevamente
            System.out.println();
        }
		
	}
}
