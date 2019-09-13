@file:Suppress("UNCHECKED_CAST")

package PS.Control.Monad.Cont.Class
import Foreign.PsRuntime.app
import Foreign.PsRuntime.appRun
object Module  {
  @JvmField
  val MonadCont = { Monad0 : Any ->
     { callCC : Any ->
       mapOf(("Monad0" to Monad0),  ("callCC" to callCC))
    }
  };
  @JvmField
  val callCC = { dict : Any ->
     (dict as Map<String, Any>)["callCC"]!!
  };
}