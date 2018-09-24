package jbhembise.testauto.junit4;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.junit.experimental.theories.ParametersSuppliedBy;

@Retention(RetentionPolicy.RUNTIME)
@ParametersSuppliedBy(BetweenIntSupplier.class)
public @interface BetweenInt {
    int min() default 0;
    int max() default Integer.MAX_VALUE;
}
