

public class BigInteger {
	
	private int length;
	private char Num[];			// Num[999] == ones place Num[998] == Tens , so on
	/**
	 * setNum(char[])
	 * 
	 * 		Checks that there are no leading 0s in the array passed. sets the length member variable of this
	 * 		to the number of characters 0-9 it finds in the array passed. ignores each character that is not
	 * 		one of these numbers.
	 * 
	 * @param a
	 */
	private void setNum(char a[]) { 
		a = rmZero(a);
		Num = new char[1000];
		length = 0;
		int b = a.length, c = a.length ;
		for(int i = 999; i>999- a.length; i--) {
			if (b>0 && toNumb(a[b-1])!= -99) {
				Num[i+(c - b)] = a[b-1];
				b--;
				c--;
				this.length++;
			}else if(b>0) {
				b--;
			}else{
				return;
			}
		}
	}
	
	/**
	 *int toNumb(char)
	 *
	 * 		Converts the character passed to a single digit integer 0-9.
	 * 		if the character cannot be converted to one of these digits 
	 * 		the function returns -99.
	 * 
	 * @param a
	 * @return
	 */
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
	 * BigInteger(char[])
	 * 
	 * 		Constructor that is passed a character array.
	 * 		Passes directly to setNum(char[]).
	 * 
	 * @param a
	 */
	public BigInteger(char a[]) {
		setNum(a);
	}
	
	/**
	 * BigInteger(String)
	 * 
	 * 		Constructor that is passed a string. Passes the
	 * 		string to setNum as a character array using the 
	 * 		string method toCharArray()
	 * 
	 * @param a
	 */
	public BigInteger(String a) {
		setNum(a.toCharArray());
		
	}
	
	/**
	 * BigInteger(long)
	 * 
	 * 		Constructor that is passed a long. calls setNum and passes it 
	 * 		long with the wrapper function toString().toCharArray();
	 * 
	 * @param n
	 */
	public BigInteger(long n) {
		setNum(Long.toString(n).toCharArray());
	}
	
	/**
	 * BigInteger()
	 * 		
	 * 		Default constructor. Sets this.Num to new char[1000] and length to 0
	 * 
	 */
	public BigInteger() {
		setNum(new char[1000]);
	}

	/**
	 * BigInteger(BigInteger)
	 * 
	 * 		Constructs a BigInteger with the same member variables as the one passed.
	 * 
	 * @param a
	 */
	public BigInteger(BigInteger a) {
		setNum(a.Num);
	}
	
	/**
	 * setBigInteger(char a[])
	 * 
	 * 		calls setNum and passes it the array passed.
	 */
	public void setBigInteger(char a[]) {
		setNum(a);
	}
	
	/**
	 * setBigInteger(char a[])
	 * 
	 * 		calls setNum and passes it the int passed as a character array.
	 */
	public void setBigInteger(int a) {
		setNum(Integer.toString(a).toCharArray());
	}
	
	/**
	 * setBigInteger(char a[])
	 * 
	 * 		calls setNum and passes it the String passed as a character array.
	 */
	public void setBigInteger(String a) {
		setNum(a.toCharArray());
	}
	
	/**
	 * setBigInteger(char a[])
	 * 
	 * 		calls setNum and passes it the long passed as a character array.
	 */
	public void setBigInteger(long a) {
		setNum(Long.toString(a).toCharArray());
	}
	
	/**
	 * show()
	 * 		
	 * 		Prints the contents of the array this.Num and a new line.
	 */
	public void show() {
		System.out.println(this.toString());
	}
	
	/**
	 * toString()
	 * 		
	 * 		Converts the character array to a string directly.
	 * 
	 * @return x
	 */
	public String toString() {
		String x = new String();
		for(int i = length-1; i>=0; i--) {
			x = x + (Num[999-i]);
			// System.out.println("i: "+i+" num:"+Num[999-i]);
		}
		return x;
	}
	
	/**
	 * push(char [])
	 * 
	 * 		Creates a new char[] with a length one larger than the one passed 
	 * 		and populates the new array with the values of the array passed from
	 * 		index 1 to arrayPassed.length. Returns the new array.
	 * 		
	 * @param a
	 * @param len
	 * @return
	 */
	private char[] push(char[] a) {					// if a[5] ={1:0,2:1,3:2,4:3,5:4}
		char ret[] = new char[a.length+1];
		for(int i = a.length; i >0; i--) {
			ret[i] = a[i-1];						// ret[6] ={'':0,1:1,2:2,3:3,4:4,5:5}
		}
		return ret;
	}
	
	/**
	 * BigInteger add(BigInteger)
	 * 
	 * 		Adds BigInteger two BigInteger that is passed and returns
	 * 		new BigInteger created with a character array populated with
	 * 		the sum of the two BigIntegers.
	 * 
	 * @param a
	 * @return new BigInteger 
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
			b[bigLen-(i+1)] = value.toCharArray()[0];						// the array b must be in reverse order to work with the BigInteger(char[]) Constructor
		}
		if(carry){															// executes if the last value is reached and there is still a carry
			String value = ""+1;											
			b = push(b);													// extends the array by 1
			b[0] = value.toCharArray()[0];									// sets largest digit to 1
		}
		return new BigInteger(b);
	}
	
	/**
	 * boolean isZero()
	 * 
	 * 		returns true if the length of this is 0
	 * 		otherwise returns false.
	 * 
	 * @return
	 */
	public boolean isZero() {
		if(this.length <= 0)
			return true;
		else 
			return false;
	}
	
	/**
	 * char [] rmZero(char[])
	 * 
	 * 		removes the leading zeros of char[] passed and returns 
	 * 		the array.
	 * 
	 * @param a
	 * @return
	 */
	private char [] rmZero(char[] a) {
		int leading = 0;
			for(int i = 0; i < a.length; i ++) {
				if(a[i] == '0'||toNumb(a[i]) == -99)
					leading++;
				else
					break;
			}
		int newSize = a.length - leading;
		char b[] = new char[newSize];
		for(int i = 0; i < newSize; i++ ) {
			b[(newSize - i)-1] = a[(a.length - i )- 1];
		}
		return b;
	}
	
	/**
	 * BigInteger subtract(BigInteger)
	 * 	
	 * 		returns the difference between this and BigInteger passed
	 * 		
	 * @param a
	 * @return
	 */
	public BigInteger subtract(BigInteger a) {
		int bigLen, carry = 0; 												// index for the largest value digit of the bigint
		
		boolean sLen = (this.length == a.length), bigger = 
				(this.length > a.length);									// carry will hold is any two chars at index add to > 10
																			// sLen will be true only if length is equal
		bigLen = (sLen)? this.length: (bigger)? this.length:a.length;		// bigLen will hold the value of length for whichever is larger
		char [] b = new char[bigLen+1];
		int small = (bigger)? a.length: this.length;						// small will hold the smaller length
		for(int i = 0; i < bigLen; i++) {
			int num = 0;
			if(i<small) {													// if iterator is less than the length of smaller array
				num = toNumb(this.Num[999-i]) - toNumb(a.Num[999-i]) + carry;	
				carry = (num >= 0)? 0 : -1;		
				num = (num>=0)? num : 10 + num;
				
			}else {															
				num = toNumb(this.Num[999 - i] ) + carry;
				carry = (num >= 0)? 0 : -1;
				num = (num>=0)? num : 10 + num;	
			}
			b[bigLen - i] = Integer.toString(num).toCharArray()[0];	
		}
		return new BigInteger(b);
	}
	
	/**
	 * BigInteger increment()
	 * 
	 * 		Calls this.setnum and passes it this.add(1) so that 
	 * 		this.Num is increased by 1. returns this.
	 * 
	 * @return
	 */
	public BigInteger increment() {
		setNum(this.add(new BigInteger(1)).toString().toCharArray());
		return this;
	}
	
	/**
	 * BigInteger deincrement()
	 * 
	 * 		Calls this.setNum and passes it this.subtract(1) so that 
	 * 		this.Num is reduced by 1. Returns this.
	 * 
	 * @return
	 */
	public BigInteger deincrement() {
		setNum(this.subtract(new BigInteger(1)).toString().toCharArray());
		return this;
	}
	
	/**
	 * BigInteger multiply(BigInteger)
	 * 
	 * 		creates a copy of the Big integer passed called place in order to use 
	 * 		it's deincrement method as a count. b is created as a copy of this. while 
	 * 		place.isZero() is false b.add is called with the arguement this and place.deincrement()
	 * 		is called. once place.isZero() returns true b is returned. 
	 * 		
	 * @param a
	 * @return
	 */
	public BigInteger multiply(BigInteger a) {
		BigInteger b = new BigInteger(this);
		BigInteger place = new BigInteger(a);
		place.deincrement();
		while(!place.isZero()) {
			b = b.add(this);				
			place.deincrement();
			
		}
		return b;	
	}
	
	/**
	 * boolean larger(BigInteger)
	 * 
	 * 		returns true if BigInteger passed is larger than this,
	 * 		otherwise returns false.
	 * 	
	 * @param a
	 * @return
	 */
	public boolean larger(BigInteger a) {
		if(a.length != 0)
			return((a.length >this.length )|| toNumb(a.Num[1000-length])>toNumb(this.Num[1000-length]));
		return false;
	}
	
	/**
	 * BigInteger devide(int)
	 * 
	 * 		subtracts a copy of this by int passed until the copy is 
	 * 		less than int. for each subtraction, ret is incremented.
	 * 		returns ret. 
	 * 
	 * @param a
	 * @return
	 */
	public BigInteger devide(int a) {
		BigInteger div = new BigInteger(a), 
				ret =(this.larger(div))? new BigInteger(1):new BigInteger(0), 
				b =(this.larger(div))? this.subtract(div) : new BigInteger(this);
		while(!b.larger(div)) {
			ret.increment();
			b = b.subtract(div);
			
		}
		return ret;
	}
	
	/**
	 * status()
	 * 		
	 * 		Outputs the member variables of this BigInteger to stdOut
	 */
	private void status() {
		System.out.println("This int's toString is " + toString());
		System.out.println("length: "+length);
		for(int i = 0; i<length; i++)
			System.out.print("char at 999 - " + i + " is " + Num[999-i] + " \\ ");
		System.out.println();
	}
	
	/**
	 * BigInteger mod(int)
	 * 
	 * 		subtracts the int passed from a copy of 'this' until that
	 * 		copy is less than the int passed. Returns the first value that is less 
	 * 		than the int passed. If the int passed is larger than the value of 
	 * 		this then it will return a copy of this without any subtractions made.
	 * 
	 * 	
	 * @param a
	 * @return
	 */
	public BigInteger mod(int a) {
		BigInteger div = new BigInteger(a),  b =(this.larger(div))?  this.subtract(div) : new BigInteger(this) ;
		while(!b.larger(div)) {
			b = b.subtract(div);
		}
		
		return b;
	}
	
	public static void main(String[] args) {
		BigInteger x = new BigInteger("12345");
		BigInteger y = new BigInteger(10);
		BigInteger z;
		char a[] = {'m'};
		z = x.add(y);
		z.show();
		z = x.subtract(y);
		z.show();
		y.setBigInteger(a);
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
	
	 
}
