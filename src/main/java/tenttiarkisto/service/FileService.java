package tenttiarkisto.service;

import java.io.File;
import java.io.InputStream;

public interface FileService {

    //returns URL to the file

    public String putFile(File f, String name);

    public String putFile(String name, InputStream is, long length);
}
