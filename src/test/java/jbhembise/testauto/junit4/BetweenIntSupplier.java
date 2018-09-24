package jbhembise.testauto.junit4;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.PotentialAssignment;

public class BetweenIntSupplier extends ParameterSupplier {

    private static final int MAX_TRIES = 1000;

    @Override
    public List<PotentialAssignment> getValueSources(ParameterSignature sig) throws Throwable {
        BetweenInt annotation = sig.getAnnotation(BetweenInt.class);
        return IntStream.rangeClosed(annotation.min(), annotation.max())
                .limit(MAX_TRIES)
                .mapToObj(i -> PotentialAssignment.forValue(String.valueOf(i), i))
                .collect(Collectors.toList());
    }
}
