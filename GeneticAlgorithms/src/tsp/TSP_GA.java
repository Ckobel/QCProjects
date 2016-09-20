/*
 * TSP_GA.java
 * Create a tour and evolve a solution
 */

package tsp;

public class TSP_GA {

     public static void main(String[] args) {

    	 // Add 50 cities with random location
    	 for(int i = 0; i < 100; i++){
    		 TourManager.addCity(new City());
    	 }
    	 
         // Initialize population
         Population pop = new Population(90, true);
         System.out.println("Initial distance: " + pop.getFittest().getDistance());

         // Evolve population for 100 generations
         pop = GA.evolvePopulation(pop);
         for (int i = 0; i < 1000; i++) {
             pop = GA.evolvePopulation(pop);
         }

         // Print final results
         System.out.println("Finished");
         System.out.println("Final distance: " + pop.getFittest().getDistance());
         System.out.println("Solution:");
         System.out.println(pop.getFittest());
     }
 }