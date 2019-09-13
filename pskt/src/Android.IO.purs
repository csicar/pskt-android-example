module Android.IO where

import Effect (Effect)
import Effect.Uncurried
import Effect.Console (log, logShow)
import Global (readFloat)
import Data.Int (floor)
import Unsafe.Coerce (unsafeCoerce)
import Prelude
import Android.Widget


foreign import _httpGet :: EffectFn3 Context String (String -> Effect Unit) (Effect Unit)
httpGet = runEffectFn3 _httpGet