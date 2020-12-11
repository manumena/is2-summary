package dataflow.abs;

// En ZeroAbstractValue agregar al enum la constante BOTTOM para representar el resultado de una 
// posible division por cero (indefinido). Luego cuando se opera con este valor abstracto, el 
// resultado de cualquier operación que lo tenga como operando debería ser BOTTOM (excepto quizas en el
// caso de BOTTOM * ZERO que sabemos da ZERO). Al momento de unificar (join o merge de dos predecesores)
// BOTTOM con algún otro valor abstracto X, el resultado debería ser X.


public enum ZeroAbstractValue {

  BOTTOM("bottom"), NOT_ZERO("not-zero"), ZERO("zero"), MAYBE_ZERO("maybe-zero");

  private String name;

  @Override
  public String toString() {
    return this.name;
  }

  ZeroAbstractValue(String name) {
    this.name = name;
  }

  public ZeroAbstractValue add(ZeroAbstractValue another) {
    if (this == BOTTOM || another == BOTTOM) return BOTTOM;
    else if (this == MAYBE_ZERO || another == MAYBE_ZERO) return MAYBE_ZERO;
    else if (this == ZERO) return another;
    else if (another == ZERO) return this;
    else return MAYBE_ZERO;
  }
  

  public ZeroAbstractValue divideBy(ZeroAbstractValue another) {
    if (this == BOTTOM || another == BOTTOM || another == ZERO || another == MAYBE_ZERO) return BOTTOM;
    else return this;
  }
  

  public ZeroAbstractValue multiplyBy(ZeroAbstractValue another) {
    if (this == ZERO || another == ZERO) return ZERO;
    else if (this == BOTTOM || another == BOTTOM) return BOTTOM;
    else if (this == MAYBE_ZERO || another == MAYBE_ZERO) return MAYBE_ZERO;
    else return NOT_ZERO;
  }
  

  public ZeroAbstractValue substract(ZeroAbstractValue another) {
    return add(another);
  }
  

  public ZeroAbstractValue merge(ZeroAbstractValue another) {
    if (this == another) return this;
    else if (this == BOTTOM) return another;
    else if (another == BOTTOM) return this;
    else return MAYBE_ZERO;
  }
  
}
