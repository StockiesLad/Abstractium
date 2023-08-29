package net.feltmc.abstractium.util.obj_holders;

import java.util.List;

public abstract class ObjectHolder<T> {
   public abstract T getHeldObj();

   public abstract ObjectHolder<T> mutateHeldObj(T newObj);

   public boolean equalsAny(List<T> list) {
      for (final var element : list)
         if (element.equals(getHeldObj()))
            return true;
      return false;
   }
}
