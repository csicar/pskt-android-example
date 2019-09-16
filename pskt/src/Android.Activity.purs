module Android.Activity where

import Effect (Effect)
import Effect.Uncurried
import Effect.Console (log, logShow)
import Global (readFloat)
import Data.Int (floor)
import Unsafe.Coerce (unsafeCoerce)
import Prelude
import Data.Tuple (Tuple(..))
import Android.Widget

data Activity = Activity { onCreate :: Context -> Effect Unit}

myActivity = Activity { onCreate: \a -> pure unit }