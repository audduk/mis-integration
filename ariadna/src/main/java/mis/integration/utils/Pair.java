package mis.integration.utils;

//
// Source code is a copy of org.springframework.data.util.Pair
//

import lombok.NonNull;

public final class Pair<S, T> {
  @NonNull
  private final S first;
  @NonNull
  private final T second;

  public static <S, T> Pair<S, T> of(S first, T second) {
    return new Pair(first, second);
  }

  public S getFirst() {
    return this.first;
  }

  public T getSecond() {
    return this.second;
  }

  public String toString() {
    return "Pair(first=" + this.getFirst() + ", second=" + this.getSecond() + ")";
  }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    } else if (!(o instanceof Pair)) {
      return false;
    } else {
      Pair other = (Pair) o;
      Object this$first = this.getFirst();
      Object other$first = other.getFirst();
      if (this$first == null) {
        if (other$first != null) {
          return false;
        }
      } else if (!this$first.equals(other$first)) {
        return false;
      }

      Object this$second = this.getSecond();
      Object other$second = other.getSecond();
      if (this$second == null) {
        if (other$second != null) {
          return false;
        }
      } else if (!this$second.equals(other$second)) {
        return false;
      }

      return true;
    }
  }

  public int hashCode() {
    boolean PRIME = true;
    byte result = 1;
    Object $first = this.getFirst();
    int result1 = result * 59 + ($first == null ? 43 : $first.hashCode());
    Object $second = this.getSecond();
    result1 = result1 * 59 + ($second == null ? 43 : $second.hashCode());
    return result1;
  }

  private Pair(@NonNull S first, @NonNull T second) {
    if (first == null) {
      throw new IllegalArgumentException("first is null");
    } else if (second == null) {
      throw new IllegalArgumentException("second is null");
    } else {
      this.first = first;
      this.second = second;
    }
  }
}
