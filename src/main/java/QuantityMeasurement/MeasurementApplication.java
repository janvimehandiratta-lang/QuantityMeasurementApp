package QuantityMeasurement;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MeasurementApplication {
	 static class Feet {
	        private final double value;
	        // Constructor

	        public Feet(double value) {

	            this.value = value;

	        }
	        // Override equals method

	        @Override

	        public boolean equals(Object obj) {

	            if (this == obj) return true;



	            if (obj == null || getClass() != obj.getClass())

	                return false;



	            Feet other = (Feet) obj;
	            return Double.compare(this.value, other.value) == 0;
	            

	        }
	     }
	        static class Inch {
		        private final double value;
		        // Constructor

		        public Inch(double value) {

		            this.value = value;

		        }
		        // Override equals method

		        @Override

		        public boolean equals(Object obj) {

		            if (this == obj) return true;



		            if (obj == null || getClass() != obj.getClass())

		                return false;



		            
		            Inch other = (Inch) obj;
		            return Double.compare(this.value, other.value) == 0;
		            
		            

		        }

	    }

	    // Main method to test

	    public static void main(String[] args) {

	    	//SpringApplication.run(MeasurementApplication.class,args);

	        Feet f1 = new Feet(5.0);

	        Feet f2 = new Feet(5.0);
	        System.out.println("Are equal? " + f1.equals(f2));
	        
	        
	        Inch I1 = new Inch(5.0);

	        Inch I2 = new Inch(5.0);
	        System.out.println("Are equal? " + I1.equals(I2));
	        

	    }

}