package ch.killenberger.day;

import java.io.IOException;

public interface Day<T> {

    public T run(boolean partOne) throws IOException;
}
