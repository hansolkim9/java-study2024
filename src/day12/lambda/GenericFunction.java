package day12.lambda;

@FunctionalInterface
public interface GenericFunction<X, Y> {

	// X를 주면 Y를 추출하게
	Y apply(X x);
}
