module Android.Content where

import Effect (Effect)
import Effect.Uncurried
import Effect.Console (log, logShow)
import Global (readFloat)
import Data.Int (floor)
import Unsafe.Coerce (unsafeCoerce)
import Prelude
import Data.Tuple (Tuple(..))
import Android.Widget

foreign import data Intent :: Type

foreign import _intentUrl :: EffectFn1 String Intent
intentUrl = runEffectFn1 _intentUrl
foreign import _startIntent :: EffectFn2 Context Intent Unit
startIntent = runEffectFn2 _startIntent 