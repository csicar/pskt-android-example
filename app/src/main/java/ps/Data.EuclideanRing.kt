@file:Suppress("UNCHECKED_CAST")
package PS.Data.EuclideanRing
import Foreign.PsRuntime.app
object Module  {
  val intDegree = Foreign.Data.EuclideanRing.intDegree;
  val intDiv = Foreign.Data.EuclideanRing.intDiv;
  val intMod = Foreign.Data.EuclideanRing.intMod;
  val numDiv = Foreign.Data.EuclideanRing.numDiv;
  @JvmField
  val EuclideanRing = { CommutativeRing0 : Any ->
     { degree : Any ->
       { div : Any ->
         { mod : Any ->
           mapOf(("CommutativeRing0" to CommutativeRing0),  
            ("degree" to degree),  ("div" to div),  ("mod" to mod))
        }
      }
    }
  };
  @JvmField val mod = { dict : Any -> (dict as Map<String, Any>)["mod"]!!};
  @JvmField val gcd = (::__rec_gcd)();
  fun __rec_gcd(): Any = { dictEq : Any ->
     { dictEuclideanRing : Any ->
       { a : Any ->
         { b : Any ->
           when {
            (PS.Data.Eq.Module.eq.app(dictEq).app(b)
               .app(PS.Data.Semiring.Module.zero
                      .app(
                (((dictEuclideanRing as Map<String, Any>)["CommutativeRing0"]!!
                    .app(Unit) as Map<String, Any>)["Ring0"]!!
                   .app(Unit) as Map<String, Any>)["Semiring0"]!!
                  .app(Unit))) == true) -> {
              a;
            }
            else -> {
              PS.Data.EuclideanRing.Module.gcd.app(dictEq)
                .app(dictEuclideanRing)
                .app(b)
                .app(PS.Data.EuclideanRing.Module.mod.app(dictEuclideanRing)
                       .app(a)
                       .app(b));
            }
          }
        }
      }
    }
  };
  @JvmField
  val euclideanRingNumber = PS.Data.EuclideanRing.Module.EuclideanRing
                              .app({ _ : Any ->
                                   PS.Data.CommutativeRing.Module.commutativeRingNumber
                                })
                              .app({ v : Any ->
                                   1
                                })
                              .app(PS.Data.EuclideanRing.Module.numDiv)
                              .app({ v : Any ->
       { v1 : Any ->
         0.0
      }
    });
  @JvmField
  val euclideanRingInt = PS.Data.EuclideanRing.Module.EuclideanRing
                           .app({ _ : Any ->
                                PS.Data.CommutativeRing.Module.commutativeRingInt
                             })
                           .app(PS.Data.EuclideanRing.Module.intDegree)
                           .app(PS.Data.EuclideanRing.Module.intDiv)
                           .app(PS.Data.EuclideanRing.Module.intMod);
  @JvmField val div = { dict : Any -> (dict as Map<String, Any>)["div"]!!};
  @JvmField
  val lcm = { dictEq : Any ->
     { dictEuclideanRing : Any ->
       { a : Any ->
         { b : Any ->
           when {
            (PS.Data.HeytingAlgebra.Module.disj
               .app(PS.Data.HeytingAlgebra.Module.heytingAlgebraBoolean)
               .app(PS.Data.Eq.Module.eq.app(dictEq).app(a)
                      .app(PS.Data.Semiring.Module.zero
                             .app(
                     (((dictEuclideanRing as Map<String, Any>)["CommutativeRing0"]!!
                         .app(Unit) as Map<String, Any>)["Ring0"]!!
                        .app(Unit) as Map<String, Any>)["Semiring0"]!!
                       .app(Unit))))
               .app(PS.Data.Eq.Module.eq.app(dictEq).app(b)
                      .app(PS.Data.Semiring.Module.zero
                             .app(
                  (((dictEuclideanRing as Map<String, Any>)["CommutativeRing0"]!!
                      .app(Unit) as Map<String, Any>)["Ring0"]!!
                     .app(Unit) as Map<String, Any>)["Semiring0"]!!
                    .app(Unit)))) == true) -> {
              PS.Data.Semiring.Module.zero
                .app(
                (((dictEuclideanRing as Map<String, Any>)["CommutativeRing0"]!!
                    .app(Unit) as Map<String, Any>)["Ring0"]!!
                   .app(Unit) as Map<String, Any>)["Semiring0"]!!
                  .app(Unit));
            }
            else -> {
              PS.Data.EuclideanRing.Module.div.app(dictEuclideanRing)
                .app(PS.Data.Semiring.Module.mul
                       .app(
                         (((dictEuclideanRing as Map<String, Any>)["CommutativeRing0"]!!
                             .app(Unit) as Map<String, Any>)["Ring0"]!!
                            .app(Unit) as Map<String, Any>)["Semiring0"]!!
                           .app(Unit))
                       .app(a)
                       .app(b))
                .app(PS.Data.EuclideanRing.Module.gcd.app(dictEq)
                       .app(dictEuclideanRing)
                       .app(a)
                       .app(b));
            }
          }
        }
      }
    }
  };
  @JvmField
  val degree = { dict : Any ->
     (dict as Map<String, Any>)["degree"]!!
  };
}