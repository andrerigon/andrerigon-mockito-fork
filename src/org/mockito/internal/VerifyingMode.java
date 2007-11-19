package org.mockito.internal;

import org.mockito.exceptions.MockitoException;

public class VerifyingMode {

    private static final int ANY_NUMBER_OF_TIMES = -1;
    private final int exactNumberOfInvocations;

    public VerifyingMode(int exactNumberOfTimes) {
        this.exactNumberOfInvocations = exactNumberOfTimes;
    }
    
    public static VerifyingMode anyTimes() {
        return new VerifyingMode(ANY_NUMBER_OF_TIMES);
    }

    public static VerifyingMode times(int exactNumberOfInvocations) {
        if (exactNumberOfInvocations < 0) {
            throw new MockitoException("Negative value is not allowed here");
        }
        return new VerifyingMode(exactNumberOfInvocations);
    }

    public boolean numberOfInvocationsMatters() {
        return exactNumberOfInvocations != ANY_NUMBER_OF_TIMES;
    }

    public int getExactNumberOfInvocations() {
        return exactNumberOfInvocations;
    }
}