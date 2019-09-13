@file:Suppress("UNCHECKED_CAST")

package PS.Data.Ordering
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  sealed class _Type_Ordering ()  {
    object LT : _Type_Ordering() {};
    object GT : _Type_Ordering() {};
    object EQ : _Type_Ordering() {};
  };
  val LT = _Type_Ordering.LT;
  val GT = _Type_Ordering.GT;
  val EQ = _Type_Ordering.EQ;
  @JvmField
  val showOrdering = PS.Data.Show.Module.Show
                       .app({ v : Any ->
       when {
        (v is PS.Data.Ordering.Module._Type_Ordering.LT) -> {
          "LT";
        }
        (v is PS.Data.Ordering.Module._Type_Ordering.GT) -> {
          "GT";
        }
        (v is PS.Data.Ordering.Module._Type_Ordering.EQ) -> {
          "EQ";
        }
        else -> (error("Error in Pattern Match") as Any)
      }
    });
  @JvmField
  val semigroupOrdering = PS.Data.Semigroup.Module.Semigroup
                            .app({ v : Any ->
       { v1 : Any ->
         when {
          (v is PS.Data.Ordering.Module._Type_Ordering.LT) -> {
            PS.Data.Ordering.Module.LT;
          }
          (v is PS.Data.Ordering.Module._Type_Ordering.GT) -> {
            PS.Data.Ordering.Module.GT;
          }
          (v is PS.Data.Ordering.Module._Type_Ordering.EQ) -> {
            val y = v1;
            y;
          }
          else -> (error("Error in Pattern Match") as Any)
        }
      }
    });
  @JvmField
  val invert = { v : Any ->
     when {
      (v is PS.Data.Ordering.Module._Type_Ordering.GT) -> {
        PS.Data.Ordering.Module.LT;
      }
      (v is PS.Data.Ordering.Module._Type_Ordering.EQ) -> {
        PS.Data.Ordering.Module.EQ;
      }
      (v is PS.Data.Ordering.Module._Type_Ordering.LT) -> {
        PS.Data.Ordering.Module.GT;
      }
      else -> (error("Error in Pattern Match") as Any)
    }
  };
  @JvmField
  val eqOrdering = PS.Data.Eq.Module.Eq
                     .app({ v : Any ->
       { v1 : Any ->
         when {
          (v is PS.Data.Ordering.Module._Type_Ordering
                  .LT)&& (v1 is PS.Data.Ordering.Module._Type_Ordering
                                  .LT) -> {
            true;
          }
          (v is PS.Data.Ordering.Module._Type_Ordering
                  .GT)&& (v1 is PS.Data.Ordering.Module._Type_Ordering
                                  .GT) -> {
            true;
          }
          (v is PS.Data.Ordering.Module._Type_Ordering
                  .EQ)&& (v1 is PS.Data.Ordering.Module._Type_Ordering
                                  .EQ) -> {
            true;
          }
          else -> {
            false;
          }
        }
      }
    });
}