import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static int initial , cylinders ;
	public static String direction , algo ;
	
	public static int fcfs ( int initial , ArrayList<Integer> queue ){
		
		int res = 0 ;

		ArrayList<Integer> moves = new ArrayList<Integer>() ;
		moves.addAll(queue);

		moves.add( 0 , initial );
		
		System.out.println( moves.toString() );
		
		for ( int i=0; i<moves.size()-1; i++ ){
			
			res += Math.abs( moves.get(i) - moves.get( i + 1 ) ) ;
		}
		
		return res ;
	}

	public static int sstf ( int initial , ArrayList<Integer> queue ){
		
		int res = 0 , idx ;
		ArrayList<Integer> moves = new ArrayList<Integer>() ;
		ArrayList<Integer> tempQueue = new ArrayList<Integer>() ;
		tempQueue.addAll(queue);
		
		tempQueue.add( initial );

		while ( tempQueue.size() > 0 ){
			
			Collections.sort( tempQueue, new Comparator<Integer>(){
				
		        public int compare(Integer x, Integer y) {
		        	
		        	return x - y ;
		        }
		    });
			
			idx = tempQueue.indexOf ( initial ) ;
			
			moves.add ( tempQueue.get(idx) );
			
			if ( idx + 1 < tempQueue.size() && idx - 1 >= 0 ){
				
				if ( Math.abs( tempQueue.get( idx + 1 ) - tempQueue.get( idx ) ) 
					< Math.abs( tempQueue.get( idx - 1 ) - tempQueue.get( idx ) ) ){
					
					initial = tempQueue.get( idx + 1 ) ;
				}
				else 
					initial = tempQueue.get( idx - 1 ) ;
			}
			else if ( idx + 1 < tempQueue.size() )
				initial = tempQueue.get( idx + 1 ) ;
			
			else if ( idx - 1 >= 0 )
				initial = tempQueue.get( idx - 1 ) ;
			
			tempQueue.remove ( idx ) ;	
		}
		
		System.out.println( moves.toString() );
		
		for ( int i=0; i<moves.size()-1; i++ ){
			
			res += Math.abs( moves.get(i) - moves.get( i + 1 ) ) ;
		}
		
		return res ;
	}
	
	public static int scan ( int initial , int cylinders , String direction , ArrayList<Integer> queue ){
		
		int res = 0 ;
		ArrayList<Integer> moves = new ArrayList<Integer>() ;
		ArrayList<Integer> tempQueue = new ArrayList<Integer>() ;
		tempQueue.addAll(queue);

		tempQueue.add( initial );
		
		Collections.sort( tempQueue, new Comparator<Integer>(){
			
	        public int compare(Integer x, Integer y) {
	        	
	        	return x - y ;
	        }
	    });
		
		int idx = tempQueue.indexOf ( initial ) ;
		
		if ( direction.equals("right") ){
			
			for ( int i=idx ; i<tempQueue.size() ; i ++ ){
				
				moves.add( tempQueue.get(i) );
			}
			
			if ( moves.size() < tempQueue.size() )
				moves.add ( cylinders-1 ) ;
			
			for ( int i=idx-1 ; i>=0 ; i -- ){
				
				moves.add( tempQueue.get(i) );
			}
		}
		
		else if ( direction.equals("left") ){
			
			for ( int i=idx ; i>=0 ; i -- ){
				
				moves.add( tempQueue.get(i) );
			}
			
			if ( moves.size() < tempQueue.size() )
				moves.add ( 0 ) ;
			
			for ( int i=idx+1 ; i<tempQueue.size() ; i ++ ){
				
				moves.add( tempQueue.get(i) );
			}
		}
		
		System.out.println( moves.toString() );
		
		for ( int i=0; i<moves.size()-1; i++ ){
			
			res += Math.abs( moves.get(i) - moves.get( i + 1 ) ) ;
		}
		
		return res ;
	}
	
	public static int cScan ( int initial , int cylinders , String direction , ArrayList<Integer> queue ){
		
		int res = 0 ;
		
		ArrayList<Integer> moves = new ArrayList<Integer>() ;
		ArrayList<Integer> tempQueue = new ArrayList<Integer>() ;
		
		tempQueue.addAll(queue);

		tempQueue.add( initial );
		
		Collections.sort( tempQueue, new Comparator<Integer>(){
			
	        public int compare(Integer x, Integer y) {
	        	
	        	return x - y ;
	        }
	    });
		
		int idx = tempQueue.indexOf ( initial ) ;
		
		if ( direction.equals("right") ){
			
			for ( int i=idx ; i<tempQueue.size() ; i ++ ){
				
				moves.add( tempQueue.get(i) );
			}
			
			if ( moves.size() < tempQueue.size() ){
				moves.add ( cylinders - 1 ) ;
				moves.add ( 0 ) ;
			}
			
			for ( int i=0 ; i<idx ; i ++ ){
				
				moves.add( tempQueue.get(i) );
			}
		}
		
		else if ( direction.equals("left") ){
			
			for ( int i=idx ; i>=0 ; i -- ){
				
				moves.add( tempQueue.get(i) );
			}
			
			if ( moves.size() < tempQueue.size() ){
				moves.add ( 0 ) ;
				moves.add ( cylinders - 1 ) ;
			}
			
			for ( int i=tempQueue.size()-1 ; i>idx ; i -- ){
				
				moves.add( tempQueue.get(i) );
			}
		}
		
		System.out.println( moves.toString() );
		
		for ( int i=0; i<moves.size()-1; i++ ){
			
			res += Math.abs( moves.get(i) - moves.get( i + 1 ) ) ;
		}
		
		return res ;
	}
	
	public static int cLook ( int initial , int cylinders , String direction , ArrayList<Integer> queue ){
		
		int res = 0 ;
		
		ArrayList<Integer> moves = new ArrayList<Integer>() ;
		ArrayList<Integer> tempQueue = new ArrayList<Integer>() ;
		
		tempQueue.addAll(queue);

		tempQueue.add( initial );
		
		Collections.sort( tempQueue, new Comparator<Integer>(){
			
	        public int compare(Integer x, Integer y) {
	        	
	        	return x - y ;
	        }
	    });
		
		int idx = tempQueue.indexOf ( initial ) ;
		
		if ( direction.equals("right") ){
			
			for ( int i=idx ; i<tempQueue.size() ; i ++ ){
				
				moves.add( tempQueue.get(i) );
			}
			
			for ( int i=0 ; i<idx ; i ++ ){
				
				moves.add( tempQueue.get(i) );
			}
		}
		
		else if ( direction.equals("left") ){
			
			for ( int i=idx ; i>=0 ; i -- ){
				
				moves.add( tempQueue.get(i) );
			}
			
			for ( int i=tempQueue.size()-1 ; i>idx ; i -- ){
				
				moves.add( tempQueue.get(i) );
			}
		}
		
		System.out.println( moves.toString() );
		
		for ( int i=0; i<moves.size()-1; i++ ){
			
			res += Math.abs( moves.get(i) - moves.get( i + 1 ) ) ;
		}
		
		return res ;
	}
	
	public static void main(String[] args){
		
		ArrayList<Integer> queue = new ArrayList<Integer>() ;
		
		try {
			
			File file = new File("in.txt");

			Scanner in = new Scanner(file);

			while ( in.hasNextLine() ) {
				
			    int i = in.nextInt();
			    queue.add(i);
			}
			
			in.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Scanner in = new Scanner(System.in);
		
		while ( true ){
			
			System.out.println("\n*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=\n");
		
			System.out.print( "Initial head cylinder = " );
			
			initial = in.nextInt();
			
			System.out.print( "Number of cylinders = " );
			
			cylinders = in.nextInt();
			
			System.out.print( "Desired algorithm = " );
			
			algo = in.next() ;
			
			if ( algo.equals( "FCFS" ) ){
				
				System.out.println( "Number of head movements = " + fcfs ( initial , queue ) ) ;
			}
			else if ( algo.equals( "SSTF" ) ){
				
				System.out.println( "Number of head movements = " + sstf ( initial , queue ) ) ;
			}
			else if ( algo.equals( "SCAN" ) ){
				
				System.out.print( "Desired direction = " );
				direction = in.next() ;
				System.out.println( "Number of head movements = " + scan ( initial , cylinders , direction , queue ) ) ;
			}
			else if ( algo.equals( "CSCAN" ) ){
				
				System.out.print( "Desired direction = " );
				direction = in.next() ;
				System.out.println( "Number of head movements = " + cScan ( initial , cylinders , direction , queue ) ) ;
			}
			else if ( algo.equals( "CLOOK" ) ){
				
				System.out.print( "Desired direction = " );
				direction = in.next() ;
				System.out.println( "Number of head movements = " + cLook ( initial , cylinders , direction , queue ) ) ;
			}
			else {
				
				System.exit(0);
			}
		}
	}
}
