package controlNotas;

import java.util.ArrayList;
import java.util.Scanner;

public class ControlNotas {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
  

/**
 * La clase ControlNotas permite gestionar un conjunto de estudiantes y sus notas.
 * 
 * Funcionalidades principales:
 * <ul>
 *   <li>Ingresar notas</li>
 *   <li>Modificar notas</li>
 *   <li>Mostrar promedios</li>
 *   <li>Eliminar una nota</li>
 * </ul>
 * 
 * El programa funciona mediante un menú de opciones en consola.
 * 
 * @author Ronnie
 */
        ArrayList<ArrayList<Double>> estudiantes = new ArrayList<>();
        int opcion;
        
        /**
         * Establecemos un bucle do-while para manejar el menu de opciones
         * y que se repita con cada accion de usuario hasta que este decida 
         * SALIR
         */
        do {
        	System.out.println("=== MENÚ ===");
        	System.out.println("1) Ingresar notas");
        	System.out.println("2) Modificar nota");
        	System.out.println("3) Mostrar promedios");
        	System.out.println("4) Eliminar una nota");
        	System.out.println("0) Salir");
        	System.out.print("Selecciona una opción y presiona Enter: ");
        	opcion = teclado.nextInt();
        
        
        switch (opcion) {
        case 1 :{
        	System.out.println("1. Ingresar las notas de los estudiantes");
        		      		
        				// Creamos 5 estudiantes
        				for (int i = 0; i < 5; i++) {
        				estudiantes.add(new ArrayList<>());
        				
        											} 
        				
        				// cada estudiante tiene su lista de notas
        				// Pedimos 3 notas por cada estudiante (ejemplo)
        		        for (int i = 0; i < estudiantes.size(); i++) {
        		            System.out.println("Ingrese 3 notas para el estudiante " + (i + 1) + ":");
        		            for (int k = 0; k < 3; k++) {
        		                double nota;
        		                do {
        		                    System.out.print("Nota " + (k+1) + ": ");
        		                    nota = teclado.nextDouble();
        		                    if (nota < 1 || nota > 10) {
        		                        System.out.println("❌ La nota debe estar entre 1 y 10. Intente de nuevo.");
        		                    }
        		                } while (nota < 1 || nota > 10);

        		                estudiantes.get(i).add(nota);
        		            } 
        		            
        		        }
        		        
       
        		 break;
        	}
        		            
        case 2:  {
        	System.out.println("Haz ingresado a modificación de notas");
        	System.out.println("Ingrese numero del estudiante: " );
        	int numeroEstudiante = teclado.nextInt();
        			if ( numeroEstudiante <1 || numeroEstudiante > estudiantes.size()) {
        					System.out.println("❌ Estudiante inválido.");
        					break;
        					
        			}
        			 	ArrayList<Double> notas = estudiantes.get(numeroEstudiante-1);
        				System.out.println("Las notas actuales del estudiante son: " +  numeroEstudiante + notas);
        				System.out.println();
        				
        				System.out.println("Ingrese cual nota se va a modificar");
        				int numeroNota = teclado.nextInt();
        				
        				System.out.println();
        				
        					if( numeroNota < 1 || numeroNota > notas.size()) {
            					System.out.println("❌ Nota inválida.");
            					break;
            			}
        				System.out.println();
        				
        				double nuevaNota;
        				
        				do {
        					System.out.println("Ingrese la nueva nota: ");
        					nuevaNota = teclado.nextDouble();
        					if( nuevaNota < 1 || nuevaNota > 10) {
            					System.out.println("❌ Nota debe estar entre 1 y 10 ."); 
        					}


        						} while ( nuevaNota < 1 || nuevaNota > 10);
        				
        				notas.set(numeroNota -1,nuevaNota);
        				
        				System.out.println("La nota: " + (numeroNota - 1) + ", fue modificada exitosamente" );
        				System.out.println("Nuevas notas: " + notas);
        				break;
        					
        				}
        				
        
      
        case 3:{
        	  System.out.println("\nNotas de los estudiantes:");
              for (int i = 0; i < estudiantes.size() ; i++) {
              	ArrayList <Double> can_notas = estudiantes.get(i);
              
                  System.out.println("Estudiante " + (i+1) + ": " + estudiantes.get(i));
                  double suma = 0;
                  for (double n : can_notas) {
                  	suma += n;
                  }
                  
                  double promedio = suma / can_notas.size();
                  System.out.println("Tu promnedio de notas es: " + promedio);
                  
                  if (promedio >= 6) {
                      System.out.println("✅ Aprobaste, ¡Felicidades!");
                      System.out.println();
                  } else {
                      System.out.println("❌ Reprobaste, lo siento :(");
                      System.out.println();
                  }
              }
              	
                  
              break;	
             
              }
        
        case 4: {
        	System.out.println("Haz ingresado en la eliminacion de notas");
        	System.out.println("Ingresa el numero del estudiante: " );
        	int numeroEstudiante = teclado.nextInt();
        	
        	if ( numeroEstudiante <1 || numeroEstudiante > estudiantes.size()) {
				System.out.println("❌ Estudiante inválido.");
				break;
				
        	}
		        	ArrayList<Double> notas = estudiantes.get(numeroEstudiante-1);
					System.out.println("Las notas actuales del estudiante son: " +  numeroEstudiante + notas);
					System.out.println();
					
					System.out.println("Ingrese cual nota se va a modificar");
					int numeroNota = teclado.nextInt() - 1;
					
					System.out.println();
					
						if( numeroNota < 1 || numeroNota > notas.size()) {
							System.out.println("❌ Nota inválida.");
							break;
					}
					System.out.println();
					
					notas.remove(numeroNota);
					//Para que le promedio sea consecuente con la cantidad de notas totales se agrega un 1.0
					//en la nota eliminada
					notas.add(numeroNota, 1.0);
					
					System.out.println("La nota: " + (numeroNota) + ", fue ELIMINDA exitosamente" );
					System.out.println("Nuevas notas: " + notas);
					
					break;
				
			}
			
        	
        }

             // teclado.close();
        }while (opcion != 0);
        System.out.println("Gracias por usar nuestro gestor de notas.");
    }
        
    }  

        