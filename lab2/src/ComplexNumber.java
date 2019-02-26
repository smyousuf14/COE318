package coe318.lab2;
/**
 * ComplexNumber models a complex number expressed
 * in rectangular form (real and imaginary parts).
 * It is an <em>immutable</em> object.
 *
 * @author Syed Yousuf
 */
public class ComplexNumber 
{
  //Instance variable declarations
  private double imaginaryPart;
  private double realPart;

  /**
   * Construct a ComplexNumber given its
   * real and imaginary parts.
   * @param re The real component
   * @param im The imaginary component
   */
  public ComplexNumber(double re, double im) 
  {
      //Initialize the instance variables
      realPart = re;
      imaginaryPart = im;
  }

  /**
   * Returns the real component.
   * @return the real value/component of the complex number
   */
  public double getReal() 
  {
      return realPart;  //A stub: to be fixed
  }

  /**
   * Returns the imaginary component.
   * @return the imaginary
   */
  public double getImaginary() 
  {
      return imaginaryPart;  //A stub: to be fixed
  }

  /**
   * Returns a new ComplexNumber number that is
   * the negative(Conjugate) of <em>this</em>.  Note: the
   * original ComplexNumber is <b>NOT</b>
   * modified.
   * @return -this The negative of the new complex number
   */
  public ComplexNumber negate() 
  {   
      ComplexNumber newNumber = new ComplexNumber(-realPart, -imaginaryPart); 
      
      return newNumber; 
  }

  /**
   * Returns a new ComplexNumber that is the
   * sum of <em>this</em>  and <em>z</em>.
   * Note: the  original ComplexNumber is
   * <b>NOT</b> modified.
   * @param z Another complex number
   * @return this + z
   */
  public ComplexNumber add(ComplexNumber z) 
  {
      /*Create a new complex number*/
      ComplexNumber sumValue = new ComplexNumber((z.getReal()+ realPart), (z.getImaginary() + imaginaryPart));
      
      return sumValue;  // The sum of this complex number and the z complex number
  }

  /**
   * Returns a new ComplexNumber that is the
   * difference of <em>this</em>  and <em>z</em>.
   * Note: the  original ComplexNumber is
   * <b>NOT</b> modified.
   * @param z Another complex number
   * @return this + z
   */
  public ComplexNumber subtract(ComplexNumber z) 
  {
      /*Create a new complex number*/
      ComplexNumber differenceValue = new ComplexNumber(realPart - z.getReal(), imaginaryPart - z.getImaginary());
      
      return differenceValue;  // The difference value.
  }

  /**
   * Returns a new ComplexNumber that is the
   * product of <em>this</em> and <em>z</em>.
   * Note: the original ComplexNumber is
   * <b>NOT</b> modified.
   * @param z Another complex number
   * @return this * z
   */
  public ComplexNumber multiply(ComplexNumber z) 
  {
      /*Create a new complex number*/
      ComplexNumber productValue; 
      productValue = new ComplexNumber((realPart * z.getReal()) - (imaginaryPart * z.getImaginary()),
                     (realPart * z.getImaginary()) + (imaginaryPart * z.getReal()));
      
      return productValue;  // The product value of the complex numbers
  }

  /**
   * Returns a new ComplexNumber that is
   * the reciprocal of <em>this</em>.
   * Note: the original ComplexNumber is
   * <b>NOT</b> modified.
   * @return 1.0 / this
   */
  public ComplexNumber reciprocal() 
  {
      ComplexNumber newNumber; 
      newNumber = new ComplexNumber(realPart/((realPart * realPart) + (imaginaryPart * imaginaryPart) ),
              -(imaginaryPart/((realPart * realPart) + (imaginaryPart * imaginaryPart) )));
      
      return newNumber;  // The reciprocal complex number
  }

  /**
   * Returns a new ComplexNumber that is
   * <em>this</em> divided by <em>z</em>.
   * Note: the original ComplexNumber is
   * <b>NOT</b> modified.
   * @param z The original complex number
   * @return this / z
   */
  public ComplexNumber divide(ComplexNumber z) 
  {
      ComplexNumber dividentValue; 
      
      dividentValue = new ComplexNumber(((realPart * z.getReal()) + (imaginaryPart * z.getImaginary()))
              / ((z.getReal() * z.getReal()) + (z.getImaginary() * z.getImaginary())) ,((-1 * realPart * z.getImaginary()) 
              + (imaginaryPart * z.getReal()) ) / ( (z.getReal() * z.getReal()) + (z.getImaginary() * z.getImaginary())));
      
      return dividentValue;  //A stub: to be fixed
  }

  /**
   * Returns a String representation of
   * <em>this</em> in the format:
   * <pre>
   * real +-(optional) i imaginary
   * </pre>
   * If the imaginary part is zero, only the
   * real part is converted to a String.
   * A "+" or "-" is placed between the real
   * and imaginary parts depending on the
   * the sign of the imagrinary part.
   * <p>
   * Examples:
   * <pre>
   *  ..println(new ComplexNumber(0,0); = "0.0"
   *  ..println(new ComplexNumber(1,1); = "1.0 + i1.0"
   *  ..println(new ComplexNumber(1,-1); = "1.0 - i1.0"
   * </pre>
   * @return the String representation.
   */
  @Override
  public String toString() 
  {
      //DO NOT MODIFY THIS CODE!
      String str = "" + this.getReal();
      if (this.getImaginary() == 0.0) {
          return str;
      }
      if (this.getImaginary() > 0) {
          return str + " + i" + this.getImaginary();
      } else {
          return str + " - i" + -this.getImaginary();
      }
  }
}