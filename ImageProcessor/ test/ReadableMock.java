import java.io.IOException;
import java.nio.CharBuffer;

public class ReadableMock implements Readable {

  @Override
  public int read(CharBuffer cb) throws IOException {
    throw new IOException("Readable failed");
  }

}
