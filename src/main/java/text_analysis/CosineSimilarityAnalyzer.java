
package text_analysis;


public class CosineSimilarityAnalyzer {
    
    public CosineSimilarityAnalyzer(){
        
    }
    
    public static double computeDotProductOfTwoVectors(double[] vectorA, double[] vectorB){
        //Dot Product of two vectors: sum of products of vector X and vector Y values at the same indices
        // multiple same indice values together (ex: value[i] for X * value[i] for Y)
        // then sum up all the products --> get dot product (return that as a double)
        //the vectors being compared will be of the same length 
        double runningSum = 0;
        
        //go through each index in the length of the vector (both vectors have same length) and add the product to the runningSum
        for(int i=0; i<vectorA.length; i++){
            runningSum += (vectorA[i]*vectorB[i]);
        }
        return runningSum;
    }
    
    public static double computeCosineSimilarityOfTwoVectors(double[] vectorA, double[] vectorB){
        // Cosine Similarity Score:
        // compute by: (dot product of vA and vB)/((magnitude of vA) x (magnitude of vB))
        double cosineSimScore = (computeDotProductOfTwoVectors(vectorA, vectorB))/(computeMagnitudeOfVector(vectorA) * computeMagnitudeOfVector(vectorB));
        return cosineSimScore;
    }
    
    public static double computeMagnitudeOfVector(double[] vector){
        // To compute a vector's magnitude: take each val {vector[i]} and raise it to the power of 2
        // --> then sum up all value products --> take square root of total sum 
        double runningSum = 0; 
        for(int i=0; i<vector.length; i++){
            runningSum += Math.pow(vector[i], 2);
        }
        return Math.sqrt(runningSum);
    }
    
}
