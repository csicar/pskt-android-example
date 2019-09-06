@file:Suppress("UNCHECKED_CAST")
package PS.Control.Monad.Gen.Class
import Foreign.PsRuntime.app
object Module  {
  @JvmField
  val MonadGen = { Monad0 : Any ->
     { chooseBool : Any ->
       { chooseFloat : Any ->
         { chooseInt : Any ->
           { resize : Any ->
             { sized : Any ->
               mapOf(("Monad0" to Monad0),  ("chooseBool" to chooseBool),  
                ("chooseFloat" to chooseFloat),  ("chooseInt" to chooseInt),  
                ("resize" to resize),  ("sized" to sized))
            }
          }
        }
      }
    }
  };
  @JvmField val sized = { dict : Any -> (dict as Map<String, Any>)["sized"]!!};
  @JvmField
  val resize = { dict : Any ->
     (dict as Map<String, Any>)["resize"]!!
  };
  @JvmField
  val chooseInt = { dict : Any ->
     (dict as Map<String, Any>)["chooseInt"]!!
  };
  @JvmField
  val chooseFloat = { dict : Any ->
     (dict as Map<String, Any>)["chooseFloat"]!!
  };
  @JvmField
  val chooseBool = { dict : Any ->
     (dict as Map<String, Any>)["chooseBool"]!!
  };
}