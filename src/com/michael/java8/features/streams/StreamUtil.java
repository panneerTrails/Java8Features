/**
 * 
 */
package com.michael.java8.features.streams;

import java.util.PrimitiveIterator;
import java.util.Spliterators;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

/**
 * @author 109726
 *
 */
public class StreamUtil {
	public static IntStream takeWhile(IntStream stream, IntPredicate predicate)
	{
		return StreamSupport.intStream(new PredicateIntSpliterator(stream, predicate), false);
	}

	private static class PredicateIntSpliterator extends Spliterators.AbstractIntSpliterator
	{
		private final PrimitiveIterator.OfInt iterator;
		private final IntPredicate predicate;

		public PredicateIntSpliterator(IntStream stream, IntPredicate predicate)
		{
			super(Long.MAX_VALUE, IMMUTABLE);
			this.iterator = stream.iterator();
			this.predicate = predicate;
		}

		@Override
		public boolean tryAdvance(IntConsumer action)
		{
			if (iterator.hasNext()) {
				int value = iterator.nextInt();
				if (predicate.test(value)) {
					action.accept(value);
					return true;
				}
			}

			return false;
		}
	}

}
