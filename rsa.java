import java.math.BigInteger;
import java.util.Arrays; 
import java.util.Random; 
import java.util.Scanner;
public class RSA {
public static void main(String[] args) {
Random rand=new Random();
int bitLength = 1024;
// Two prime numbers 
BigInteger p=BigInteger.probablePrime (bitLength, rand);
BigInteger q=BigInteger.probablePrime (bitLength, rand);
// Find N & phi
BigInteger N = p.multiply(q);
BigInteger phi = (p.subtract (BigInteger.ONE)). multiply (q. subtract (BigInteger.ONE));
//Find E & D
BigInteger E =BigInteger.probablePrime (bitLength/2, rand);
BigInteger D = E. modInverse (phi);
Scanner in = new Scanner(System.in);
System.out.print("Enter the Plain Text: ");
String plainText = in.nextLine();
System.out.println("Encrypting String: "+plainText);
byte[] msgBytes = plainText.getBytes();
System.out.println("String in Bytes :"+ Arrays.toString(msgBytes));
//Encrypt
byte []C = (new BigInteger (msgBytes)). modPow(E,N).toByteArray(); 
byte []M=(new BigInteger(C)).modPow(D,N).toByteArray();
// System.out.println("The Cyper Text is "+ new String(C));
System.out.println("The Cyper Text in Bytes "+Arrays.toString(C));
System.out.println("The Message Text is "+ new String(M)); 
System.out.println("The Message in Bytes "+ Arrays.toString(M));
}
}