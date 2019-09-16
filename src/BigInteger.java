import play.CustIO;

public class BigInteger {
	
	private int length;
	private char Num[];			// Num[999] == ones place Num[998] == Tens , so on
	
	private void setNum(char a[]) {
		length = a.length;
		int b = length - 1;
		for(int i = 999; i>length-1; i--) {
			Num[i] = a[b];
			b--;
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
		return 0;
		
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
		String b = ""+n+"";
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
		for(int i = 0; i<length; i++) {
			System.out.print(Num[i]);
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
	private char[] push(char[] a, int len) {
		char ret[] = new char[1000];
		for(int i = len+1; i >0; i--) {
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
		int end = 999 - length, bigLen; 									// index for the largest value diget of the bigint
		char[] b = new char[1000];
		boolean carry=false, sLen = (this.length == a.length);
		//This was added in branch "feature"
		and this;
		
		/*
		int diff, num;						// bigLen holds the value of len for the longer big int
		
		if(!sLen){										// lengths are not the same
			if(isBiggerThan(a)) {						// find the longest length to find where the addition needs to start.
				bigLen = this.length;
				diff = this.length - a.length;
			}
			else {
				bigLen = a.length;
				diff = a.length - this.length;
			}
			for(int i = bigLen-1; i>=0; i--) {				// Num[5] = {'1','2','3','4','5'} + a.Num[2] = {'1','0'}
				//System.out.println(i);
				if(i!= 0) {
					if(i-diff>=0)							// num should exit this conditional holding the value of current place this plus
						num = toNumb(this.Num[i]) + toNumb(a.Num[i-diff]);	// current place a or the value of current place a or this
					else if(isBiggerThan(a))
						num = toNumb(this.Num[i]);
					else
						num = toNumb(a.Num[i]);
					if(carry)								// if last addition was greater than 10 then current must be iterated
						num++;
					carry = (num >= 10);					// if current addition is greater than 10 then next must be iterated
					b[i] = (char)(num%10);
				}else if (carry) {
					b = push(b, bigLen);
					b[0] = 1;
				}else if(this.length == a.length) {
					num = toNumb(this.Num[0]) +toNumb(a.Num[0]);
				}else
					b[0] = (isBiggerThan(a))? Num[0]: a.Num[0];	// TODO num must be resolved for i = 0 if both BigInt are equal		
			}
		}else	{												// lengths are the same
			for(int i = length-1; i>0; i--) {
				num = toNumb(this.Num[i]) + toNumb(a.Num[i]);
				if(carry)
					num++;
				carry = (num>=10);
				if(i==0) {
					
				}else
					b[i] = (char)(num%10);
				
			}
		}
		*/
			
		return new BigInteger(b);
		
	}
	
	
	
	public static void main(String[] args) {
		BigInteger x = new BigInteger(12345);
		BigInteger y = new BigInteger(90000);
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
