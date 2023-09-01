package net.feltmc.abstractium.util.obj_holders;

import java.util.List;
import java.util.function.Function;

public abstract class ObjectHolder<T> {
   public abstract T getHeldObj();

   public abstract ObjectHolder<T> mutateHeldObj(Function<T, T> mutatedObj);

   public boolean equalsAny(List<T> list) {
      for (final var element : list)
         if (element.equals(getHeldObj()))
            return true;
      return false;
   }
}
