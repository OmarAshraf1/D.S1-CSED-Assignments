package eg.edu.alexu.csd.datastructure.iceHockey;

import java.awt.Point;
import java.util.Vector;

public class icehockey implements IPlayersFinder {

	//to count team chain 
	static int counter=0 ;

	static int boundi=0 ;
	static int boundj=0 ;
	//max bound of y 
	static int maxi=0 ;
	//max bound of x
	static int maxj = 0 ;
	//min bound
	static int mini = 0;
	static int minj = 0;
	//the coordinate of x player's center
	static int cordx=0 ; 
	//the coordinate of y player's center
	static int cordy=0 ;
	
	static Point[] cord ; 
	
	static Vector<Point> point =new Vector<Point>() ;
	final static int pixel = 4 ;
	
	
	

	public Point[] findPlayers(String[] photo, int team, int threshold) {
		
		if(photo == null) {
			return null ;
		}
		if ((photo.length) <= 0) {
			throw new IllegalArgumentException("Empty");
		}

		
		//String x = photo[0] ; //to get column length
		
		 char[][] completephoto = new char[101][101] ; // array of the homogenious photo
		 int i=0,j=0 ;
		for(  i=0 ; i <( photo.length) ; i++) {
			for( j=0 ; j < (photo[0].length() ) ; j++) {
				if(photo[i].charAt(j) == (char) ( team + '0' ) ) {
					completephoto[i][j] = (char) ( team + '0' ) ;
				}
				else {
					
					completephoto[i][j] = 'b' ;	
				}
					
				
			}
		}
		boundi = i ; 
		boundj = j ;
		
		
		for( int n=0 ; n < photo.length ; n++) {
			for(int m=0 ; m < photo[0].length() ; m++) {
				if(completephoto[n][m] == (char) (team + '0') ) {
					counter = 0 ;
					maxi = n;
					maxj = m;
					mini = n;
					minj = m;
					
					search ( n ,  m , completephoto ,team ,threshold);
					if (cordx >= 0 || cordy >= 0) {
						if ((counter * pixel)>= threshold) {
						
							point.add(new Point(cordx, cordy));
							
						}
					}
					
					
				}
				counter = 0 ;
				
			}
		}
		cord = new Point[point.size()] ;
		for(int v =0 ; v< point.size();v++) {
			cord[v] = point.elementAt(v) ;
		}
		Point temp ;
		for(int c = 0 ; c < point.size() - 1 ; c++ ) {
			for(int v = c + 1 ; v < point.size()  ; v++ ) {
				if(cord[c].x > cord[v].x ) {
					temp = cord[c] ;
					cord[c] = cord[v] ;
					cord[v] = temp ;
				}
				else if(cord[c].x == cord[v].x) {
					if(cord[c].y > cord[v].y) {
						temp = cord[c] ;
						cord[c] = cord[v] ;
						cord[v] = temp ;
					}
					
					
				}
					
				
			}
		}
		point.removeAllElements(); 
		if (point.size() >= 0) {
			return cord ;
		} else {
			return null;
		}
		
		
		
		
		
			
		
				
		
	}
	
	
	
	//recursion method to find chain of pixels 
	
 	public void search ( int n , int m , char[][] arr ,int num ,int ar) {
		//final int pixel = 4 ;
		if(arr[n][m] != (char)(num + '0') || n < 0 || m < 0 || n >= boundi || m >= boundj ) {
			
			return ;
		}
		if(n > maxi) {
			maxi = n ;
		}
		if(n < mini) {
			mini = n ;
		}
		if(m > maxj) { 
			maxj = m ;
		}
		if(m < minj) {
			minj = m ;
		}
		counter ++ ;
		arr[n][m] = 'a' ;
		if(m < boundj  ) {
			
			search (  n , m+1 ,arr , num , ar) ;
		}
		if(n < boundi  ) {
			
			search (  n+1 , m ,arr , num , ar) ;
		}
		if(m > 0  ) {
			
			search (  n , m-1 ,arr , num , ar) ;
		}
		if(n > 0  ) {
			
			search (  n-1  , m ,arr , num , ar) ;
		}
		
		if( (counter * pixel) >= ar) {
			cordx = (minj + maxj + 1) ;
			cordy = (mini + maxi + 1) ;
			
		}
		
		
		

	
	}
 	
 	
	
	}

	
	
	
	
	
	
	
	
	


