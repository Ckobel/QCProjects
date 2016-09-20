package genes;

public class GA {

     public static void main(String[] args) throws InterruptedException {

         // Set a candidate solution
         FitnessCalc.setSolution("1111000000000111110100000010011000101010101010101010101001010010");

         // Create an initial population
         Population myPop = new Population(1000000, true);
         
         // Evolve our population until we reach an optimum solution
         int generationCount = 0;
         while (myPop.getFittest().getFitness() < FitnessCalc.getMaxFitness()) {
             generationCount++;
             System.out.println("Generation: " + generationCount + " Fittest: " + myPop.getFittest().getFitness());
             System.out.println("Candidate: " + myPop.getFittest().toString());
             System.out.println("Solution:  " + "1111000000000000000100000010000000101010101010101010101001010010" );
             myPop = Algorithm.evolvePopulation(myPop);
         }
         System.out.println("Solution found!");
         System.out.println("Generation: " + generationCount);
         System.out.println("Genes:");
         System.out.println(myPop.getFittest());

     }
 }