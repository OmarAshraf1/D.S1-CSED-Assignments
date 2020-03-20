package eg.edu.alexu.csd.datastructure.linkedList.csxx_csyy;


import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver ;

import java.lang.Math; 


public class polynomialsolver implements IPolynomialSolver {
	
		static class polynode{
		Object coef ;
		Object expo ;
		
		polynode(Object c ,Object e){
			coef = c ;
			expo = e ;
		}
	}

	
	singlelinkedlist A = new singlelinkedlist() ;
	singlelinkedlist B = new singlelinkedlist() ;
	singlelinkedlist C = new singlelinkedlist() ;
	singlelinkedlist R = new singlelinkedlist() ;

	
	
	public void setPolynomial(char poly, int[][] terms) {
		
		//sorting polynomials according to index method
		
		int [][]a = sort(terms) ;
		clearPolynomial(poly); 
		for(int i = 0 ; i<a.length ; i++) {
			polynode term = new polynode(a[i][0],a[i][1]) ;
			//Add each node to it list
			if(poly == 'A') {
				A.add(term);
			}
			else if (poly == 'B') {
				B.add(term);
			}
			else if (poly == 'C') {
				C.add(term);
			}
			else if(poly == 'R'){
				R.add(term);
			}
			else {
				throw new RuntimeException();
			}
		}
		
	}
	@Override
	public String print(char poly) {
		singlelinkedlist temp = polynomial(poly) ;
		
		polynode var ;
		String result = "";
		for(int i = 0 ; i < temp.size() ; i++) {
			var = (polynode) temp.get(i) ;
			
			if((int)var.coef == 0 ) {
				continue;
			}
			
			if(i == 0 || (int)var.coef < 0 ) {
				result += var.coef ;
			}
			else if(i != 0) {
				result += "+" ;
				result +=  var.coef ;
			}
			if((int)var.expo != 0 ) {
				result += "x" ; 
			}
			if((int)var.expo != 1 && (int)var.expo != 0 ) {
				result += "^" ;
				result += var.expo ;
			}
			
		}
		System.out.println(result);
		return result ;
		
		
	}
	public void clearPolynomial(char poly) {
		if(poly == 'A') {
			A.clear();
		}
		else if(poly == 'B') {
			B.clear();
		}
		else if(poly == 'C') {
			C.clear();
		}
		else if(poly == 'R') {
			R.clear();
		}
		else {
			throw new RuntimeException();
		}
		
		
	}
	public float evaluatePolynomial(char poly, float value) {
		singlelinkedlist temp = polynomial(poly) ;
		
		polynode var ;
		float result = 0;
		for(int i = 0 ; i < temp.size() ;i++) {
			var = (polynode) temp.get(i) ;
			result += (float)var.coef *  Math.pow( value, (float)var.expo) ;
			
		}
		return result ;
	}
	
	public int[][] add(char poly1, char poly2){
		polynode var1  ;
		polynode var2  ;
		singlelinkedlist temp1 = polynomial(poly1) ;
		singlelinkedlist temp2 = polynomial(poly2) ;
		if(temp1==null|| temp2==null){
			throw new RuntimeException();
		}
		int[][] arr = new int[temp1.size() + temp2.size()][2] ;
		int k =0 ;
		for( k =0 ; k < temp1.size() ; k++) {
			var1 = (polynode) temp1.get(k) ;
			arr[k][0] = (int) var1.coef ;
			arr[k][1] = (int) var1.expo ;
		}
		int z =0 ;
		for( z =0 ; z < temp2.size() ; z++) {
			var2 = (polynode) temp2.get(z) ;
			arr[z+k][0] = (int) var2.coef ;
			arr[z+k][1] = (int) var2.expo ;
		}
		
		setPolynomial('R',sort(arr)) ;
		return sort(arr) ;
		
	}
	public int[][] subtract(char poly1, char poly2){
		polynode var1  ;
		polynode var2  ;
		singlelinkedlist temp1 = polynomial(poly1) ;
		singlelinkedlist temp2 = polynomial(poly2) ;
		if(temp1==null|| temp2==null){
			throw new RuntimeException();
		}
		int[][] arr = new int[temp1.size() + temp2.size()][2] ;
		int k =0 ;
		for( k =0 ; k < temp1.size() ; k++) {
			var1 = (polynode) temp1.get(k) ;
			arr[k][0] = (int) var1.coef ;
			arr[k][1] = (int) var1.expo ;
		}
		int z =0 ;
		for( z =0 ; z < temp2.size() ; z++) {
			var2 = (polynode) temp2.get(z) ;
			arr[z+k][0] = -1*(int)var2.coef ;
			arr[z+k][1] = (int) var2.expo ;
		}
		
		setPolynomial('R',sort(arr)) ;
		return sort(arr) ;
		
	
	}
	
	public int[][] multiply(char poly1, char poly2){
		polynode var1 ;
		polynode var2 ;
		singlelinkedlist temp1 = polynomial(poly1) ;
		singlelinkedlist temp2 = polynomial(poly2) ;
		int [][] arr = new int[temp1.size() * temp2.size()][2] ;
		int n = 0 ;
		for(int i = 0 ; i<temp1.size() ; i++) {
			var1 = (polynode) temp1.get(i); 
			for(int j =0 ;j < temp2.size() ; j++) {
				var2 = (polynode) temp2.get(j) ;
				arr[n][0] =(int) var1.coef *(int) var2.coef ;
				arr[n][1] = (int) var1.expo + (int) var2.expo ;
				n++ ;
			}
		}
		
		setPolynomial('R',sort(arr));
		
		return 	sort(arr) ;
	}


	

	
	public int[][] sort(final int[][] terms){
		int num=terms.length;
		for(int i=0;i<terms.length;i++){
			for(int j=i+1;j<terms.length;j++){
				if(terms[i][1]<terms[j][1]){
					int coeff =terms[i][0];
					int exp =terms[i][1];
					terms[i][0]=terms[j][0];
					terms[i][1]=terms[j][1];
					terms[j][0]=coeff;
					terms[j][1]=exp;
				}
			}
		}
	  for(int i=0;i<terms.length;i++){
		  for(int j=i+1;j<terms.length;j++){
				if(terms[i][1]==terms[j][1]&&(terms[j][0]!=0&&terms[j][1]!=0)){
					terms[i][0]=terms[i][0]+terms[j][0];
					terms[j][0]=0;
					terms[j][1]=0;
					num--;
				}
		  }
	  }
	  int [][] sortedTerms=new int[num][2];
	  int j=0;
	  for(int i=0;i<terms.length;i++){
			  if((terms[i][0]==0&&terms[i][1]==0)||terms[i][0]==0){
				  continue ;
			  }else{
				  sortedTerms[j][0]=terms[i][0];
				  sortedTerms[j][1]=terms[i][1];
				  j++;
			  }
			
			
	  }
	  
	 
		return sortedTerms ;
	}
	
	//method return llist matches poly
	public singlelinkedlist polynomial(char a) {
		
			if(a=='A'){
				return A ;
			}else if (a=='B'){
				return B ;
			}else if (a=='C'){
				return C ;
			}else if (a=='R'){
				return R ;
			}else
			{
				throw new RuntimeException();
			}
			
		}
	


}








