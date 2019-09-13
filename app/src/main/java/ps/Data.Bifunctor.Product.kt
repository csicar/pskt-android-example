@file:Suppress("UNCHECKED_CAST")

package PS.Data.Bifunctor.Product
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  sealed class _Type_Product ()  {
    data class Product (val value0 : Any,  val value1 : Any) : _Type_Product(
    ) {};
  };
  val Product = { value0 : Any ->
     { value1 : Any ->
       _Type_Product.Product(value0,  value1)
    }
  };
  @JvmField
  val showProduct = { dictShow : Any ->
     { dictShow1 : Any ->
       PS.Data.Show.Module.Show
         .app({ v : Any ->
           when {
            (v is PS.Data.Bifunctor.Product.Module._Type_Product.Product) -> {
              val x = v.value0;
              val y = v.value1;
              (("(Product " as String) + (((PS.Data.Show.Module.show
                                              .app(dictShow)
                                              .app(x
              ) as String) + (((" " as String) + (((PS.Data.Show.Module.show
                                                      .app(dictShow1)
                                                      .app(y
              ) as String) + (")" as String)) as String)) as String)) as String));
            }
            else -> (error("Error in Pattern Match") as Any)
          }
        })
    }
  };
  @JvmField
  val eqProduct = { dictEq : Any ->
     { dictEq1 : Any ->
       PS.Data.Eq.Module.Eq
         .app({ x : Any ->
           { y : Any ->
             when {
              (x is PS.Data.Bifunctor.Product.Module._Type_Product
                      .Product)&&
              (y is PS.Data.Bifunctor.Product.Module._Type_Product
                      .Product) -> {
                val l = x.value0;
                val l1 = x.value1;
                val r = y.value0;
                val r1 = y.value1;
                PS.Data.HeytingAlgebra.Module.conj
                  .app(PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean)
                  .app(PS.Data.Eq.Module.eq.app(dictEq).app(l).app(r))
                  .app(PS.Data.Eq.Module.eq.app(dictEq1).app(l1).app(r1));
              }
              else -> (error("Error in Pattern Match") as Any)
            }
          }
        })
    }
  };
  @JvmField
  val ordProduct = { dictOrd : Any ->
     { dictOrd1 : Any ->
       PS.Data.Ord.Module.Ord
         .app({ _ : Any ->
              PS.Data.Bifunctor.Product.Module.eqProduct
                .app((dictOrd as Map<String, Any>)["Eq0"]!!.app(Unit))
                .app((dictOrd1 as Map<String, Any>)["Eq0"]!!.app(Unit))
           })
         .app({ x : Any ->
           { y : Any ->
             when {
              (x is PS.Data.Bifunctor.Product.Module._Type_Product
                      .Product)&&
              (y is PS.Data.Bifunctor.Product.Module._Type_Product
                      .Product) -> {
                val l = x.value0;
                val l1 = x.value1;
                val r = y.value0;
                val r1 = y.value1;
                object   {
                    val v = PS.Data.Ord.Module.compare.app(dictOrd).app(l)
                              .app(r);
                  }
                  .run({
                    val v = this.v;
                    when {
                      (v is PS.Data.Ordering.Module._Type_Ordering.LT) -> {
                        PS.Data.Ordering.Module.LT;
                      }
                      (v is PS.Data.Ordering.Module._Type_Ordering.GT) -> {
                        PS.Data.Ordering.Module.GT;
                      }
                      else -> {
                        PS.Data.Ord.Module.compare.app(dictOrd1).app(l1)
                          .app(r1);
                      }
                    };
                  });
              }
              else -> (error("Error in Pattern Match") as Any)
            }
          }
        })
    }
  };
  @JvmField
  val bifunctorProduct = { dictBifunctor : Any ->
     { dictBifunctor1 : Any ->
       PS.Data.Bifunctor.Module.Bifunctor
         .app({ f : Any ->
           { g : Any ->
             { v : Any ->
               when {
                (v is PS.Data.Bifunctor.Product.Module._Type_Product
                        .Product) -> {
                  val f1 = f;
                  val g1 = g;
                  val x = v.value0;
                  val y = v.value1;
                  PS.Data.Bifunctor.Product.Module.Product
                    .app(PS.Data.Bifunctor.Module.bimap.app(dictBifunctor)
                           .app(f1)
                           .app(g1)
                           .app(x))
                    .app(PS.Data.Bifunctor.Module.bimap.app(dictBifunctor1)
                           .app(f1)
                           .app(g1)
                           .app(y));
                }
                else -> (error("Error in Pattern Match") as Any)
              }
            }
          }
        })
    }
  };
  @JvmField
  val biapplyProduct = { dictBiapply : Any ->
     { dictBiapply1 : Any ->
       PS.Control.Biapply.Module.Biapply
         .app({ _ : Any ->
              PS.Data.Bifunctor.Product.Module.bifunctorProduct
                .app((dictBiapply as Map<String, Any>)["Bifunctor0"]!!.app(Unit)
                )
                .app((dictBiapply1 as Map<String, Any>)["Bifunctor0"]!!
                       .app(Unit))
           })
         .app({ v : Any ->
           { v1 : Any ->
             when {
              (v is PS.Data.Bifunctor.Product.Module._Type_Product
                      .Product)&&
              (v1 is PS.Data.Bifunctor.Product.Module._Type_Product
                       .Product) -> {
                val w = v.value0;
                val x = v.value1;
                val y = v1.value0;
                val z = v1.value1;
                PS.Data.Bifunctor.Product.Module.Product
                  .app(PS.Control.Biapply.Module.biapply.app(dictBiapply).app(w)
                         .app(y))
                  .app(PS.Control.Biapply.Module.biapply.app(dictBiapply1)
                         .app(x)
                         .app(z));
              }
              else -> (error("Error in Pattern Match") as Any)
            }
          }
        })
    }
  };
  @JvmField
  val biapplicativeProduct = { dictBiapplicative : Any ->
     { dictBiapplicative1 : Any ->
       PS.Control.Biapplicative.Module.Biapplicative
         .app({ _ : Any ->
              PS.Data.Bifunctor.Product.Module.biapplyProduct
                .app((dictBiapplicative as Map<String, Any>)["Biapply0"]!!
                       .app(Unit))
                .app((dictBiapplicative1 as Map<String, Any>)["Biapply0"]!!
                       .app(Unit))
           })
         .app({ a : Any ->
           { b : Any ->
             PS.Data.Bifunctor.Product.Module.Product
               .app(PS.Control.Biapplicative.Module.bipure
                      .app(dictBiapplicative)
                      .app(a)
                      .app(b))
               .app(PS.Control.Biapplicative.Module.bipure
                      .app(dictBiapplicative1)
                      .app(a)
                      .app(b))
          }
        })
    }
  };
}