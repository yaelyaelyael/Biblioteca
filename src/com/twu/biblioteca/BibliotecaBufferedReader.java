package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Created by cbiggs on 6/18/15.
 */
public class BibliotecaBufferedReader extends BufferedReader {

    public BibliotecaBufferedReader( Reader in ) {
        super(in);
    }

    @Override
    public String readLine() {
        try {
            return super.readLine();
        } catch (IOException e) {
            throw new RuntimeIOException(e);
        }
    }
}
