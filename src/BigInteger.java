import play.CustIO;

public class BigInteger {
	
	private int length;
	private char Num[];			// Num[999] == ones place Num[998] == Tens , so on
	
	private void setNum(char a[]) { //a[] == {1,2,3,4,5} then Num[i==999 - iteration] == a[a.length - 1 - iteration] while (999-iteration > a.length - 1)
		length = 0;
		int b = a.length - 1;
		for(int i = 999; i>a.length-1; i--) {
			if (b>=0 && toNumb(a[b])!= -99) {
			Num[i] = a[b];
			b--;
			length++;
			}else if(b>=0)
				b--;
			else{
				return;
			}
		}
	}
	
	private int toNumb(char a) {
		switch(a) {
			case'0':
				return 0;
			case '1':
				return 1;
			case '2':
				return 2;
			case '3':
				return 3;
			case '4':
				return 4;
			case '5':
				return 5;
			case '6':
				return 6;
			case '7':
				return 7;
			case '8': 
				return 8;
			case '9':
				return 9;
		}
		return -99;
		
	}
	/**
	 * 
	 * @param a
	 */
	public BigInteger(char a[]) {
		Num = new char[1000];
		setNum(a);
	}
	/**
	 * 
	 * @param a
	 */
	public BigInteger(String a) {
		char b[]=a.toCharArray();
		Num = new char[1000];
		setNum(b);
	}
	/**
	 * 
	 * @param n
	 */
	public BigInteger(long n) {
		Num = new char[1000];
		String b = ""+n;
		setNum(b.toCharArray());
		
	}
	/**
	 * 
	 */
	public BigInteger() {
		Num = new char[1000];
		length = 0;
	}
	
	/**
	 * 
	 */
	public void show() {
		for(int i = length; i>=0; i--) {
			System.out.print(Num[999-i]);
		}
		System.out.println();
	}
	/**
	 * 
	 * @param a
	 * @return 
	 */
	private boolean isBiggerThan(BigInteger a) {
		boolean is = (this.length > a.length); 
		return is;
	}
	/**
	 * 
	 * @param a
	 * @param len
	 * @return
	 */
	private char[] push(char[] a) {
		char ret[] = new char[a.length+1];
		for(int i = a.length; i >0; i--) {
			ret[i] = a[i-1];
		}
		return ret;
	}
	/**
	 * 
	 * @param a
	 * @return
	 */
	public BigInteger add(BigInteger a) {
		int bigLen; 														// index for the largest value digit of the bigint
		
		boolean carry=false, sLen = (this.length == a.length), bigger = 
				(this.length > a.length);									// carry will hold is any two chars at index add to > 10
																			// sLen will be true only if length is equal
		bigLen = (sLen)? length: (bigger)? this.length:a.length;			// bigLen will hold the value of length for whichever is larger
		char [] b = new char[bigLen+1];
		int small = (bigger)? a.length: length;								// small will hold the smaller length
		
		for(int i = 0; i<bigLen; i++) {										// will iterate until i == bigLen - 1
			String value = "";
			if(i<small && !carry) {											// as long as i is less the smaller length and there's no carry
				int num = (toNumb(Num[999-i])+toNumb(a.Num[999-i]));		// add two values at index 99 - i and set num to that
				value = ""+num%10;											// convert num%10 to string 
				carry =(num>=10);											// set carry to true if two digits are greater than 10
			}else if (i<small && carry){									// as long as i is less the smaller length and there's a carry
				int num = (toNumb(Num[999-i])+toNumb(a.Num[999-i])+1);		// add two values at index 99 - i and set num to that + 1 (for carry)
				value = ""+num%10;											// convert num%10 to string 
				carry =(num>=10);
			}else if(carry){												// only executes at the last index if carry == true
				int num = (bigger)? toNumb(this.Num[999- i]): toNumb(a.Num[999-i]);	// if this.length is bigger num = Num at current index otherwise sets to a.Num
				num++;														// num is iterated 
				carry =(num >= 10);											// num might have been 9
				value = ""+num%10;											// set value to num for conversion to char
			}
			else {															// if not carry at the last index
				int num = (bigger)? toNumb(this.Num[999- i]): toNumb(a.Num[999-i]);
				value = ""+num%10;											// set value to the digit in the array
			}
			// System.out.println(value.toCharArray()[0]+ "i:" + i);
			b[bigLen-(i+1)] = value.toCharArray()[0];						// the array b must be in reverse order to work with the BigInteger(char[]) Constructor
		}
		if(carry){															// executes if the last value is reached and there is still a carry
			String value = ""+1;											
			b = push(b);													// extends the array by 1
			b[0] = value.toCharArray()[0];									// sets largest digit to 1
		
		}
		
		return new BigInteger(b);
		
	}
	
	
	
	public static void main(String[] args) {
		BigInteger x = new BigInteger("999");
		BigInteger y = new BigInteger("999");
		BigInteger z;
		x.show();
		y.show();
		z = x.add(y);
		z.show();
		System.out.println("end");	
	}
	
	/*
	public static void main(String[] args) {
		BigInteger x = new BigInteger("12345");
		BigInteger y = new BigInteger(10);
		BigInteger z;
		
		z = x.add(y);
		z.show();
		z = x.subtract(y);
		z.show();
		y.setBigInteger(100);
		z = x.multiply(y);
		z.show();
		z = x.devide(100);
		z.show();
		z = x.mod(10);
		z.show();
		x.increment();
		x.show();
		x.deincrement();
		x.show();
	
	}
	*/
	 
}
